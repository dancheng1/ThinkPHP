package cn.itcast.goods.user.web.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.user.daomain.User;
import cn.itcast.goods.user.service.UserService;
import cn.itcast.goods.user.service.exception.UserException;
import cn.itcast.servlet.BaseServlet;
/* *
 * �û�ģ��WEB��
 * 
 * */
public class UserServlet extends BaseServlet {
	private UserService userService = new UserService();
	//ע�Ṧ��
	//ajax�û����Ƿ�ע��У��
	public String ajaxValidateLoginname(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡ�û���
		String loginname = req.getParameter("loginname");
		//ͨ��service�õ�У����
		boolean b = userService.ajaxvalidateLoginname(loginname);
		//�����ͻ���
		resp.getWriter().print(b);
		return null;
	}
	//ajaxEmail�Ƿ�ע��У��
	public String ajaxValidateEmail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡEmail
		String email = req.getParameter("email");
		//ͨ��service�õ�У����
		boolean b = userService.ajaxvalidateEmail(email);
		//�����ͻ���
		resp.getWriter().print(b);
		return null;
	}
	//ajax��֤���Ƿ���ȷУ��
	public String ajaxValidateVerifyCode(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡ������е�У����
		String verifyCode = req.getParameter("verifyCode");	
		//��ȡͼƬ�ϵ���ʵУ����
		String vcode = (String) req.getSession().getAttribute("vCode");
		//���к��Դ�Сд�Ƚϣ��õ����
		boolean b = verifyCode.equalsIgnoreCase(vcode); 
		//��󷢸��ͻ��� 
		resp.getWriter().print(b);
		return null;
	}
	
	public String regist(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡ������
		User formUser = CommonUtils.toBean(req.getParameterMap(), User.class);
		//У��֮�����У��ʧ�ܣ����������Ϣ�����ص�regist.jspҳ����ʾ
		Map<String, String> errors = validateRegist(formUser, req.getSession());
		if(errors.size() > 0){
			req.setAttribute("form", formUser);
			req.setAttribute("errors", errors);
			return "f:/jsps/user/regist.jsp";
		}
		//ʹ��service���ҵ��
		userService.regist(formUser);
		//����ɹ���Ϣ��ת����msg.jsp��
		req.setAttribute("code", "success");
		req.setAttribute("msg", "ע��ɹ���");
		return "f:/jsps/msg.jsp";
	}
	 //ע��У��
	 //�Ա����ֶ����У�飬����д���ʹ�õ�ǰ�ֶ�����Ϊkey��������ϢΪvalue�����浽map��
	 //����map
	private Map<String, String> validateRegist(User fromUser, HttpSession session) {
		Map<String, String> errors = new HashMap<String, String>();
		//У���¼��
		String loginname = fromUser.getLoginname();
		if(loginname == null || loginname.trim().isEmpty()){
			errors.put("loginname", "�û�������Ϊ�գ�");
		} else if(loginname.length() < 3 || loginname.length() > 20){
			errors.put("loginname", "�û���������3~20֮��");
		} else if(!userService.ajaxvalidateLoginname(loginname)){
			errors.put("loginname", "�û�����ע��");
		}
		//У���¼����
		String loginpass = fromUser.getLoginpass();
		if(loginpass == null || loginpass.trim().isEmpty()){
			errors.put("loginpass", "���벻��Ϊ�գ�");
		} else if(loginpass.length() < 3 || loginpass.length() > 20){
			errors.put("loginpass", "���������3~20֮��");
		}
		//ȷ������
		String reloginpass = fromUser.getReloginpass();
		if(reloginpass == null || reloginpass.trim().isEmpty()){
			errors.put("reloginpass", "ȷ�����벻��Ϊ�գ�");
		} else if(!reloginpass.equals(loginpass)){
			errors.put("reloginpass", "�����������벻һ�£�");
		}
		//emailУ��
		String email = fromUser.getEmail();
		if(email == null || email.trim().isEmpty()){
			errors.put("email", "Email����Ϊ�գ�");
		} else if(!email.matches("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$")){
			errors.put("email", "Email��ʽ����");
		} else if(!userService.ajaxvalidateEmail(email)){
			errors.put("email", "Email��ע��");
		}
		//��֤��У��
		String verifyCode = fromUser.getVerifyCode();
		String vcode = (String) session.getAttribute("vCode");
		if(verifyCode == null || verifyCode.trim().isEmpty()){
			errors.put("verifyCode", "��֤�벻��Ϊ�գ�");
		} else if(!verifyCode.equalsIgnoreCase(vcode)){
			errors.put("verifyCode", "��֤�����"); 
		}
		return errors;
	}
/*	//�����
	public String activation(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			System.out.println("activation()...");
		return null;
	}*/
	//�޸�����
	public String updatePassword(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��װ����Ϣ��user��
		User formUser = CommonUtils.toBean(req.getParameterMap(), User.class);
		//��sesion�л�ȡuid
		User user = (User)req.getSession().getAttribute("sessionUser");
		if(user == null){
			//����û�û�е�¼�����ص���¼ҳ�棬��ʾ������Ϣ
			req.setAttribute("msg", "����û�е�¼��");  
			return "f:/jsps/user/login.jsp";
		}
		try {
			userService.updatePassword(user.getUid(), formUser.getNewpass(), 
					formUser.getLoginpass());
			req.setAttribute("msg", "�޸�����ɹ���");
			req.setAttribute("code", "success");
			return "f:/jsps/msg.jsp";
		} catch (UserException e) {
			req.setAttribute("msg", e.getMessage());  //�����쳣��Ϣ��requset
			req.setAttribute("user", formUser);
			return "f:/jsps/user/pwd.jsp";
		}
	}
	//��¼����
	public String login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��װ�����ݵ�user
		User formUser = CommonUtils.toBean(req.getParameterMap(), User.class);
		//У�������
		Map<String, String> errors = validateLogin(formUser, req.getSession());
		if(errors.size() > 0){
			req.setAttribute("user", formUser);
			req.setAttribute("errors", errors);	
			return "f:/jsps/user/login.jsp";
		}
		//ʹ��service��ѯ
		User user = userService.login(formUser);
		//�鿴�û��Ƿ����
		//  *���������Ϣ���û������������
		//  *�����û�����Ϊ�˻���
		//  *ת����login.jsp
		//������ڣ��鿴״̬�����״̬��false��
		//  *���������Ϣ����û�м���
		//  *��������ͣ�Ϊ�˻���
		//  *ת����login.jsp
		//��¼�ɹ�
		//  *���浱ǰ�û���session
		//  *���浱ǰ�û�����cookie�У��´θ��û���¼ʱ���û�������ʾ���ı����У�ע�����ı���
		if(user == null){
			req.setAttribute("msg", "�û������������");
			req.setAttribute("user", formUser);
			return "f:/jsps/user/login.jsp";
		} else {
			if(!user.isStatus()){
				req.setAttribute("msg", "����û�м��");
				req.setAttribute("user", formUser);
				return "f:/jsps/user/login.jsp";
			} else {
				req.getSession().setAttribute("sessionUser", user);
				//װ������
				String loginname = user.getLoginname();
				loginname = URLEncoder.encode(loginname, "utf-8");
				Cookie cookie = new Cookie("loginname", loginname);
				cookie.setMaxAge(60 * 60 * 24 * 10);    //����ʮ��
				resp.addCookie(cookie);
				return "r:/index.jsp";   //�ض�����ҳ
			}
		}
	}
	
	private Map<String, String> validateLogin(User fromUser, HttpSession session) {
		Map<String, String> errors = new HashMap<String, String>();
		//У���¼��
		String loginname = fromUser.getLoginname();
		if(loginname == null || loginname.trim().isEmpty()){
			errors.put("loginname", "�û�������Ϊ�գ�");
		} else if(loginname.length() < 3 || loginname.length() > 20){
			errors.put("loginname", "�û������ȱ�����3 ~ 20֮�䣡");
		} else if(userService.ajaxvalidateLoginname(loginname)){
			errors.put("loginname", "�û�������");
		}
		//У���¼����
		String loginpass = fromUser.getLoginpass();
		if(loginpass == null || loginpass.trim().isEmpty()){ 
			errors.put("loginpass", "���벻��Ϊ�գ�");
		} else if(loginpass.length() < 3 || loginpass.length() > 20){
			errors.put("loginpass", "���볤�ȱ�����3 ~ 20֮�䣡");
		}
		//��֤��У��
		String verifyCode = fromUser.getVerifyCode();
		String vcode = (String) session.getAttribute("vCode");
		if(verifyCode == null || verifyCode.trim().isEmpty()){
			errors.put("verifyCode", "��֤�벻��Ϊ�գ�");
		} else if(!verifyCode.equalsIgnoreCase(vcode)){
			errors.put("verifyCode", "�������֤�룡"); 
		}
		return errors;
	}
	//�˳�����
	public String quit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { 
		req.getSession().invalidate();
		return "r:/jsps/user/login.jsp";
	}
} 
