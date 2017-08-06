package cn.itcast.goods.category.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.category.daomain.Category;
import cn.itcast.jdbc.TxQueryRunner;

/**
 * ����ĳ־ò�
 * @author Administrator
 *
 */
public class CategoryDao {
	private QueryRunner  qr = new TxQueryRunner();
	/**
	 * ��һ��Map�е�����ӳ�䵽Category��
	 * @param map
	 * @return
	 */
	private Category toCategory(Map<String, Object> map){
		//map {cid:xxx, cname:xxx, pid:xxx, desc:xx, orderBy:xx}
		//Category {cid:xxx, cname:xxx, parent:xxx, desc:xx}
		Category category = CommonUtils.toBean(map, Category.class);
		String pid = (String)map.get("pid");     //�����һ������pid = null
		if(pid != null){  //���������ID��Ϊ��
			//ʹ��һ�������������װ��pid
			//�ٰѸ��������ø�category
			Category parent = new Category();
			parent.setCid(pid);
			category.setParent(parent);
		}
		return category; 
	}
	/**
	 * ���԰Ѷ��map��List<Map>��ӳ��ɶ��Category��List<Category>��
	 * @param mapList
	 * @return
	 */
	private List<Category> toCategoryList(List<Map<String, Object>> mapList){
		List<Category> categoryList = new ArrayList<Category>();
		for(Map<String, Object> map : mapList){
			Category c = toCategory(map);
			categoryList.add(c);
		}
		return categoryList;
	}
	/**
	 * ����������
	 * @return
	 * @throws SQLException
	 */
	public List<Category> findAll() throws SQLException {
		//��ѯ������һ������
		String sql = "select * from t_category where pid is null order by orderBy";
		List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler());
		
		List<Category> parents = toCategoryList(mapList);
		//ѭ����������һ�����࣬Ϊÿһ��һ������������Ķ�������
		for(Category parent : parents){
			//��ѯ����ǰ ������������ӷ���
			List<Category> children = findByParent(parent.getCid());
			//���ø�������
			parent.setChildren(children);
		}
		return parents;
	}
	/**
	 * ͨ���������ѯ�ӷ���
	 * @param pid
	 * @return
	 * @throws SQLException
	 */
	public List<Category> findByParent(String pid) throws SQLException{
		String sql = "select * from t_category where pid=? order by orderBy";
		List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(), pid);
		return toCategoryList(mapList);
	}
	/**
	 * ��ӷ��� 
	 * @param category
	 * @throws SQLException
	 */
	public void add(Category category) throws SQLException{
		String sql = "insert into t_category(cid, cname, pid, `desc`) value(?,?,?,?)";
		//��Ϊһ������û��parent�� ������������
		//�������Ҫ�������з��࣬������Ҫ�ж�
		String pid = null;//һ������
		if(category.getParent() != null){
			pid = category.getParent().getCid();
		}
		Object[] params = {category.getCid(), category.getCname(), pid, category.getDesc()};
		qr.update(sql, params);
	}
	/**
	 * ---------------------------------��̨�����-------------------------------------
	 */
	/**
	 * ��ȡ���и����࣬ �����ӷ���� 
	 * @return
	 * @throws SQLException
	 */
	public List<Category> findParents() throws SQLException {
		//��ѯ������һ������
		String sql = "select * from t_category where pid is null order by orderBy";
		List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler());
		return toCategoryList(mapList);
	}
	/**
	 * ���ط��࣬���ɼ���һ�����࣬Ҳ�ɼ��ض�������
	 * @param cid
	 * @return
	 * @throws SQLException 
	 */
	public Category load(String cid) throws SQLException{
		String sql = "select * from t_category where cid=?";
		return toCategory(qr.query(sql, new MapHandler(), cid));
	}
	/**
	 * �޸ķ���
	 * �����޸�һ�����࣬Ҳ���޸Ķ�������
	 * @param category
	 * @throws SQLException 
	 */
	public void edit(Category category) throws SQLException{
		String sql = "update t_category set cname=?, pid=?, `desc`=? where cid=?";
		String pid = null;
		if(category.getParent() != null){
			pid = category.getParent().getCid();
		}
		Object[] params = {category.getCname(), pid, category.getDesc(), category.getCid()};
		qr.update(sql, params);
	}
	/**
	 * ��ѯָ��������������ĸ���
	 * @param pid
	 * @return
	 * @throws SQLException 
	 */
	public int findChildrenCountByParent(String pid) throws SQLException{
		String sql = "select count(*) from t_category where pid=?";
		Number cnt = (Number)qr.query(sql, new ScalarHandler(), pid);
		return cnt == null ? 0 : cnt.intValue();
	}
	
	public void delete(String cid) throws SQLException{
		String sql = "delete from t_category where cid=?";
		qr.update(sql, cid);
	}
}
