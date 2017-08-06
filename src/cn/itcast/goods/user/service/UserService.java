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

//�û�ģ��ҵ���
public class UserService {
	private UserDao userDao = new UserDao();
	//�޸�����
	public void updatePassword(String uid, String newPass, String oldPass) throws UserException{
		try {
			//У�������� 
			boolean bool = userDao.findByUidAndPassword(uid, oldPass);
			if(!bool){     //������������
				throw new UserException("ԭ�������");
			}
			//�޸�����
			userDao.updatePassword(uid, newPass); 
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//�û���ע��У��
	public boolean ajaxvalidateLoginname(String loginname){
		try {
			return userDao.ajaxvalidateLoginname(loginname);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//EmailУ��
	public boolean ajaxvalidateEmail(String email){
		try {
			return userDao.ajaxvalidateEmail(email);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//ע�Ṧ��
	public void regist(User user){
		 //���ݵĲ���
		user.setUid(CommonUtils.uuid());
		user.setStatus(true);
		user.setActivationCode(CommonUtils.uuid() + CommonUtils.uuid());
		//�����ݿ����
		try {
			userDao.add(user);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		//���ʼ�
/*		Properties prop = new Properties();
		try {
			prop.load(this.getClass().getClassLoader().getResourceAsStream("email_template.properties"));
		} catch (IOException e1) {
			throw new RuntimeException(e1);
		}
		//��¼�ʼ����������õ�session
		String host = prop.getProperty("host"); 	 
		String name = prop.getProperty("username");
		String pass = prop.getProperty("password"); 
		Session session = MailUtils.createSession(host, name, pass);
		//����mail����
		String from = prop.getProperty("from");
		String to = user.getEmail();
		String subject = prop.getProperty("subject");
		// MessageFrom.format������ѵ�һ�������е�{0}��ʹ�õڶ����������滻��
		// ����messageForm.format("���{0}����{1}"�� "����", "ȥ���ɣ�");  ����"���������ȥ���ɣ�"
		String content = MessageFormat.format(prop.getProperty("content"), user.getActivationCode());
		Mail mail = new Mail(from, to, subject, content);
		//�����ʼ�
		try {
			MailUtils.send(session, mail); 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}*/
	}
	//��¼����
	public User login(User user){
		try {
			return userDao.findByLoginnameAndLoginpass(user.getLoginname(), user.getLoginpass());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
