package cn.itcast.goods.book.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.book.domain.Book;
import cn.itcast.goods.category.daomain.Category;
import cn.itcast.goods.pager.Expression;
import cn.itcast.goods.pager.PageBean;
import cn.itcast.goods.pager.PageConstants;
import cn.itcast.jdbc.TxQueryRunner;

public class BookDao {
	private QueryRunner qr = new TxQueryRunner();
	//��bid��ѯ
	public Book fingByBid(String bid) throws SQLException{
		String sql = "select * from t_book where bid=?";
		//һ�м�¼�У������ܶ��book���ԣ�����һ��cid����
		Map<String, Object> map = qr.query(sql, new MapHandler(), bid);
		//��Map�г���cid�������������ӳ�䵽Book������
		Book book = CommonUtils.toBean(map, Book.class);
		//��Map��cid����ӳ�䵽Category�У������Categoryֻ��cid
		Category category = CommonUtils.toBean(map, Category.class);
		//�����߽�����ϵ
		book.setCategory(category);
		return book;
	}
	/**
	 * �������ѯ
	 * @param cid
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Book> findByCategory(String cid, int pc) throws SQLException{
		List<Expression> exprList = new ArrayList<Expression>();
		exprList.add(new Expression("cid", "=", cid));
		return findByCriteria(exprList, pc);
	}
	/**
	 * ������ģ����ѯ
	 * @param bname
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Book> findByBname(String bname, int pc) throws SQLException{
		List<Expression> exprList = new ArrayList<Expression>();
		exprList.add(new Expression("bname", "like", "%" + bname + "%"));
		return findByCriteria(exprList, pc);
	}
	/**
	 * �����߲�
	 * @param author
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Book> findByAuthor(String author, int pc) throws SQLException{
		List<Expression> exprList = new ArrayList<Expression>();
		exprList.add(new Expression("author", "like", "%" + author + "%"));
		return findByCriteria(exprList, pc);
	}
	/**
	 * ���������ѯ
	 * @param press
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Book> findByPress(String press, int pc) throws SQLException{
		List<Expression> exprList = new ArrayList<Expression>();
		exprList.add(new Expression("press", "like", "%" + press + "%"));
		return findByCriteria(exprList, pc);
	}
	/**
	 * ��������ѯ
	 * @param criteria
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Book> findByCombination(Book criteria, int pc) throws SQLException{
		List<Expression> exprList = new ArrayList<Expression>();
		exprList.add(new Expression("bname", "like", "%" + criteria.getBname() + "%"));
		exprList.add(new Expression("author", "like", "%" + criteria.getAuthor()  + "%"));
		exprList.add(new Expression("press", "like", "%" + criteria.getPress()  + "%"));
		return findByCriteria(exprList, pc);
	}
	/**
	 * ͨ�õĲ�ѯ����
	 * @param exprList
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Book> findByCriteria(List<Expression> exprList, int pc) throws SQLException {
		//�õ�ps
		int ps = PageConstants.BOOK_PAGE_SIZE;    //ÿҳ��¼��
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
		String sql = "select count(*) from t_book" + whereSql;
		Number number = (Number)qr.query(sql, new ScalarHandler(), params.toArray());
		int tr = number.intValue();         //�õ����ܼ�¼�� 
		//�õ�beanList
		sql = "select * from t_book" + whereSql + " order by orderBy limit ?,?";
		params.add((pc - 1) * ps);      //��һ���ʺţ���ǰҳ���м�¼���±�
		params.add(ps);      //�ڶ����ʺţ�һ����ѯ���У�����ÿҳ��¼��
		
		List<Book> beanList = qr.query(sql, new BeanListHandler<Book>(Book.class), 
				params.toArray());
		
		//����PageBean�����ò���
		PageBean<Book> pd = new PageBean<Book>();
		//pagebean  û��url   ���������Servlet���
		pd.setBeanList(beanList);
		pd.setPc(pc);
		pd.setPs(ps);
		pd.setTr(tr);
		return pd;
	}
	//--------------------------------------��̨����--------------------------
	/**
	 * ��ѯָ��������ͼ��ĸ���
	 * @param cid
	 * @return
	 * @throws SQLException
	 */
	public int findBookCountByCategory(String cid) throws SQLException{
		String sql = "select count(*) from t_book where cid=?";
		Number cnt = (Number)qr.query(sql, new ScalarHandler(), cid);
		return cnt == null ? 0 : cnt.intValue();
	}
}
