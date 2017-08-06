package cn.itcast.goods.user.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.goods.user.daomain.User;
import cn.itcast.jdbc.TxQueryRunner;


public class UserDao {
	private QueryRunner qr = new TxQueryRunner();
	public boolean findByUidAndPassword(String uid, String password) throws SQLException {
		String sql = "select count(*) from t_user where uid=? and loginpass=?";
		Number number = (Number)qr.query(sql, new ScalarHandler(), uid, password);
		return number.intValue() > 0;
	}
	
	
	public void updatePassword(String uid, String password) throws SQLException{
		String sql = "update t_user set loginpass=? where uid=?";
		qr.update(sql, password, uid);
	}
	
	//���û���������ѯ
	public User findByLoginnameAndLoginpass(String loginname, String loginpass) throws SQLException{
		String sql = "select * from t_user where loginname=? and loginpass=?";
		return qr.query(sql, new BeanHandler<User>(User.class), loginname, loginpass);
	}
	
	//У���û����Ƿ�ע��
	public boolean ajaxvalidateLoginname(String loginname) throws SQLException{
		String sql = "select count(1) from t_user where loginname=?";
		Number number = (Number) qr.query(sql, new ScalarHandler(), loginname);
		return number.intValue() == 0;
	}
	//У��Email�Ƿ�ע��
	public boolean ajaxvalidateEmail(String email) throws SQLException{
		String sql = "select count(1) from t_user where email=?";
		Number number = (Number) qr.query(sql, new ScalarHandler(), email);
		return number.intValue() == 0;
	}
	//����û�
	public void add(User user) throws SQLException{
		String sql = "insert into t_user value(?,?,?,?,?,?)";
		Object[] params = {user.getUid(), user.getLoginname(), user.getLoginpass(),
				user.getEmail(), user.isStatus(), user.getActivationCode()};
		qr.update(sql, params);
	}
	
}
