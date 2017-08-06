package cn.itcast.goods.user.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.user.dao.UserDao;
import cn.itcast.goods.user.daomain.User;
import cn.itcast.goods.user.service.exception.UserException;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;

//用户模块业务层
public class UserService {
	private UserDao userDao = new UserDao();
	//修改密码
	public void updatePassword(String uid, String newPass, String oldPass) throws UserException{
		try {
			//校验老密码 
			boolean bool = userDao.findByUidAndPassword(uid, oldPass);
			if(!bool){     //如果老密码错误
				throw new UserException("原密码错误！");
			}
			//修改密码
			userDao.updatePassword(uid, newPass); 
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//用户名注册校验
	public boolean ajaxvalidateLoginname(String loginname){
		try {
			return userDao.ajaxvalidateLoginname(loginname);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//Email校验
	public boolean ajaxvalidateEmail(String email){
		try {
			return userDao.ajaxvalidateEmail(email);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//注册功能
	public void regist(User user){
		 //数据的补齐
		user.setUid(CommonUtils.uuid());
		user.setStatus(true);
		user.setActivationCode(CommonUtils.uuid() + CommonUtils.uuid());
		//向数据库插入
		try {
			userDao.add(user);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		//发邮件
/*		Properties prop = new Properties();
		try {
			prop.load(this.getClass().getClassLoader().getResourceAsStream("email_template.properties"));
		} catch (IOException e1) {
			throw new RuntimeException(e1);
		}
		//登录邮件服务器，得到session
		String host = prop.getProperty("host"); 	 
		String name = prop.getProperty("username");
		String pass = prop.getProperty("password"); 
		Session session = MailUtils.createSession(host, name, pass);
		//创建mail对象
		String from = prop.getProperty("from");
		String to = user.getEmail();
		String subject = prop.getProperty("subject");
		// MessageFrom.format方法会把第一个参数中的{0}，使用第二个参数来替换。
		// 例如messageForm.format("你好{0}，你{1}"， "张三", "去死吧！");  返回"你好张三你去死吧！"
		String content = MessageFormat.format(prop.getProperty("content"), user.getActivationCode());
		Mail mail = new Mail(from, to, subject, content);
		//发送邮件
		try {
			MailUtils.send(session, mail); 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}*/
	}
	//登录功能
	public User login(User user){
		try {
			return userDao.findByLoginnameAndLoginpass(user.getLoginname(), user.getLoginpass());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
