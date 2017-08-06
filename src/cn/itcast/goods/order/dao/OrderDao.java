package cn.itcast.goods.order.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.book.domain.Book;
import cn.itcast.goods.order.domain.Order;
import cn.itcast.goods.order.domain.OrderItem;
import cn.itcast.goods.pager.Expression;
import cn.itcast.goods.pager.PageBean;
import cn.itcast.goods.pager.PageConstants;
import cn.itcast.jdbc.TxQueryRunner;

public class OrderDao {
	private QueryRunner qr = new TxQueryRunner();
	//��ѯ����״̬
	public int findStatus(String oid) throws SQLException{
		String sql = "select status from t_order where oid=?";
		Number number =  (Number)qr.query(sql, new ScalarHandler(), oid);
		return number.intValue();
	}
	//�޸Ķ���״̬
	public void updateStatus(String oid, int status) throws SQLException{
		String sql = "update t_order set status=? where oid=?";
		qr.update(sql, status, oid);
	}
	
	//���ض���
	public Order load(String oid) throws SQLException{
		String sql = "select * from t_order where oid=?";
		Order order = qr.query(sql, new BeanHandler<Order>(Order.class), oid);
		loadOrderItem(order);   //Ϊ��ǰ���������������ж�����Ŀ
		return order;
	}
	
	//���ɶ���
	public void add(Order order) throws SQLException{
		//���붩��
		String sql = "insert into t_order values(?,?,?,?,?,?)";
		Object[] params = {order.getOid(), order.getOrdertime(), order.getTotal(),
				order.getStatus(), order.getAddress(), order.getOwner().getUid()};
		qr.update(sql, params);
		//ѭ������������������Ŀ����ÿ����Ŀ����һ��Object���飬�����Ŀ����Object[][]
		//ִ����������ɶ�����Ŀ
		sql = "insert into t_orderitem values(?,?,?,?,?,?,?,?)";
		int len = order.getOrderItemList().size();
		Object[][] objs = new Object[len][];
		for(int i = 0; i < len; i++){
			OrderItem item = order.getOrderItemList().get(i);
			objs[i] = new Object[]{item.getOrderItemId(), item.getQuantity(),
					item.getSubtotal(), item.getBook().getBid(), item.getBook().getBname(),
					item.getBook().getCurrPrice(), item.getBook().getImage_b(),
					order.getOid()};
		}
		qr.batch(sql, objs);
	}
	
	//���û���ѯ����
	public PageBean<Order> findByUser(String uid, int pc) throws SQLException{
		List<Expression> exprList = new ArrayList<Expression>();
		exprList.add(new Expression("uid", "=", uid));
		return findByCriteria(exprList, pc);
	}
	
	public PageBean<Order> findByCriteria(List<Expression> exprList, int pc) throws SQLException {
		//�õ�ps
		int ps = PageConstants.ORDER_PAGE_SIZE;    //ÿҳ��¼��
		//ͨ��exprList������where�Ӿ�
		StringBuilder whereSql = new StringBuilder(" where 1=1 ");
		List<Object> params = new ArrayList<Object>();   //SQL�����ʺŵ�ֵ�����Ƕ�Ӧ�ʺŵ�ֵ
		for(Expression expr : exprList) {
			//���һ��������1.��and��ͷ 2.���������� 3.�������������������=����=��>��< ... is null�� is nullû��ֵ 
			//4.�����������is null����׷���ʺţ�Ȼ������params�����һ���ʺŶ�Ӧ��ֵ
			whereSql.append(" and ").append(expr.getName()).append(" ")
				.append(expr.getOperator()).append(" ");
			// where 1=1 and bid = 
			if(!expr.getOperator().equals("is null")){
				whereSql.append("?");
				params.add(expr.getValue());
			}
		}
		//�õ�pr        select count(*) from t_book where
		String sql = "select count(*) from t_order" + whereSql;
		Number number = (Number)qr.query(sql, new ScalarHandler(), params.toArray());
		int tr = number.intValue();         //�õ����ܼ�¼�� 
		//�õ�beanList
		sql = "select * from t_order" + whereSql + " order by ordertime desc limit ?,?";
		params.add((pc - 1) * ps);      //��һ���ʺţ���ǰҳ���м�¼���±�
		params.add(ps);      //�ڶ����ʺţ�һ����ѯ���У�����ÿҳ��¼��
		
		List<Order> beanList = qr.query(sql, new BeanListHandler<Order>(Order.class), 
				params.toArray());
		//��Ȼ�Ѿ���ȡ�˶�������ÿ�������в�û�ж�����Ŀ��
		//����ÿ��������Ϊ������������ж�����Ŀ
		for(Order order : beanList){
			loadOrderItem(order);
		}
		//����PageBean�����ò���
		PageBean<Order> pd = new PageBean<Order>();
		//pagebean  û��url   ���������Servlet���
		pd.setBeanList(beanList);
		pd.setPc(pc);
		pd.setPs(ps);
		pd.setTr(tr);
		return pd;
	}
	//Ϊָ����Order��������orderItem 
	private void loadOrderItem(Order order) throws SQLException {
		//����sql���select * from t_orderitem where oid=?
		//ִ�У��õ�List<OrderItem>
		//���ø�Order����
		String sql = "select * from t_orderitem where oid=?";
		List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(), order.getOid());
		List<OrderItem> orderItemList = toOrderItemList(mapList);
		
		order.setOrderItemList(orderItemList);
	}
	//�Ѷ��Mapת���ɶ��OrderItem
	private List<OrderItem> toOrderItemList(List<Map<String, Object>> mapList) {
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		for(Map<String, Object> map : mapList){
			OrderItem orderItem = toOrderItem(map);
			orderItemList.add(orderItem);
		}
		return orderItemList;
	}
	//��һ��Mapת����һ��OrderItem
	private OrderItem toOrderItem(Map<String, Object> map) {
		OrderItem orderItem = CommonUtils.toBean(map, OrderItem.class);
		Book book = CommonUtils.toBean(map, Book.class);
		orderItem.setBook(book);
		return orderItem;
	}	
}
