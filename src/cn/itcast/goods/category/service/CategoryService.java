package cn.itcast.goods.category.service;
import java.sql.SQLException;
import java.util.List;






//ҵ���
import cn.itcast.goods.category.dao.CategoryDao;
import cn.itcast.goods.category.daomain.Category;

public class CategoryService {
	private CategoryDao categoryDao = new CategoryDao();
	/**
	 * ��ӷ���
	 * @param category
	 */
	public void add(Category category){
		try {
			categoryDao.add(category);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ��ѯ���з���
	 * @return
	 */
	public List<Category> findAll() {	
		try {
			return categoryDao.findAll();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * -----------------------------��̨�����-------------------------------------
	 */
	/**
	 * 
	 * ��ȡ���и����࣬�����ӷ���
	 * @return
	 */
	public List<Category> findParents() {	
		try {
			return categoryDao.findParents();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ���ط���
	 * @param cid
	 * @return
	 */
	public Category load(String cid){
		try {
			return categoryDao.load(cid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * �޸ķ���
	 * @param category
	 */
	public void edit(Category category){
		try {
			categoryDao.edit(category);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ��ѯָ�����������ӷ���ĸ���
	 * @param pid
	 * @return
	 */
	public int findChildrenCountByParent(String pid){
		try {
			return categoryDao.findChildrenCountByParent(pid);
		} catch (SQLException e) {
			throw new RuntimeException(e); 
		}
	}
	/**
	 * ɾ������
	 * @param cid
	 */
	public void delete(String cid){
		try {
			categoryDao.delete(cid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ��ѯָ���������µ������ӷ���
	 * @param pid
	 * @return
	 */
	public List<Category> findChildren(String pid){
		try {
			return categoryDao.findByParent(pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
