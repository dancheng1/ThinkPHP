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
 * 用户模块WEB层
 * 
 * */
public class UserServlet extends BaseServlet {
	private UserService userService = new UserService();
	//注册功能
	//ajax用户名是否注册校验
	public String ajaxValidateLoginname(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取用户名
		String loginname = req.getParameter("loginname");
		//通过service得到校验结果
		boolean b = userService.ajaxvalidateLoginname(loginname);
		//发给客户端
		resp.getWriter().print(b);
		return null;
	}
	//ajaxEmail是否注册校验
	public String ajaxValidateEmail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取Email
		String email = req.getParameter("email");
		//通过service得到校验结果
		boolean b = userService.ajaxvalidateEmail(email);
		//发给客户端
		resp.getWriter().print(b);
		return null;
	}
	//ajax验证码是否正确校验
	public String ajaxValidateVerifyCode(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取输入框中的校验码
		String verifyCode = req.getParameter("verifyCode");	
		//获取图片上的真实校验码
		String vcode = (String) req.getSession().getAttribute("vCode");
		//进行忽略大小写比较，得到结果
		boolean b = verifyCode.equalsIgnoreCase(vcode); 
		//最后发给客户端 
		resp.getWriter().print(b);
		return null;
	}
	
	public String regist(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取表单数据
		User formUser = CommonUtils.toBean(req.getParameterMap(), User.class);
		//校验之，如果校验失败，保存错误信息，返回到regist.jsp页面显示
		Map<String, String> errors = validateRegist(formUser, req.getSession());
		if(errors.size() > 0){
			req.setAttribute("form", formUser);
			req.setAttribute("errors", errors);
			return "f:/jsps/user/regist.jsp";
		}
		//使用service完成业务
		userService.regist(formUser);
		//保存成功信息，转发到msg.jsp中
		req.setAttribute("code", "success");
		req.setAttribute("msg", "注册成功！");
		return "f:/jsps/msg.jsp";
	}
	 //注册校验
	 //对表单的字段逐个校验，如果有错误，使用当前字段名称为key，错误信息为value，保存到map中
	 //返回map
	private Map<String, String> validateRegist(User fromUser, HttpSession session) {
		Map<String, String> errors = new HashMap<String, String>();
		//校验登录名
		String loginname = fromUser.getLoginname();
		if(loginname == null || loginname.trim().isEmpty()){
			errors.put("loginname", "用户名不能为空！");
		} else if(loginname.length() < 3 || loginname.length() > 20){
			errors.put("loginname", "用户名必须在3~20之间");
		} else if(!userService.ajaxvalidateLoginname(loginname)){
			errors.put("loginname", "用户名已注册");
		}
		//校验登录密码
		String loginpass = fromUser.getLoginpass();
		if(loginpass == null || loginpass.trim().isEmpty()){
			errors.put("loginpass", "密码不能为空！");
		} else if(loginpass.length() < 3 || loginpass.length() > 20){
			errors.put("loginpass", "密码必须在3~20之间");
		}
		//确认密码
		String reloginpass = fromUser.getReloginpass();
		if(reloginpass == null || reloginpass.trim().isEmpty()){
			errors.put("reloginpass", "确认密码不能为空！");
		} else if(!reloginpass.equals(loginpass)){
			errors.put("reloginpass", "两次密码输入不一致！");
		}
		//email校验
		String email = fromUser.getEmail();
		if(email == null || email.trim().isEmpty()){
			errors.put("email", "Email不能为空！");
		} else if(!email.matches("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$")){
			errors.put("email", "Email格式错误！");
		} else if(!userService.ajaxvalidateEmail(email)){
			errors.put("email", "Email已注册");
		}
		//验证码校验
		String verifyCode = fromUser.getVerifyCode();
		String vcode = (String) session.getAttribute("vCode");
		if(verifyCode == null || verifyCode.trim().isEmpty()){
			errors.put("verifyCode", "验证码不能为空！");
		} else if(!verifyCode.equalsIgnoreCase(vcode)){
			errors.put("verifyCode", "验证码错误！"); 
		}
		return errors;
	}
/*	//激活功能
	public String activation(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			System.out.println("activation()...");
		return null;
	}*/
	//修改密码
	public String updatePassword(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//封装表单信息到user中
		User formUser = CommonUtils.toBean(req.getParameterMap(), User.class);
		//从sesion中获取uid
		User user = (User)req.getSession().getAttribute("sessionUser");
		if(user == null){
			//如果用户没有登录，返回到登录页面，显示错误信息
			req.setAttribute("msg", "您还没有登录！");  
			return "f:/jsps/user/login.jsp";
		}
		try {
			userService.updatePassword(user.getUid(), formUser.getNewpass(), 
					formUser.getLoginpass());
			req.setAttribute("msg", "修改密码成功！");
			req.setAttribute("code", "success");
			return "f:/jsps/msg.jsp";
		} catch (UserException e) {
			req.setAttribute("msg", e.getMessage());  //保存异常信息到requset
			req.setAttribute("user", formUser);
			return "f:/jsps/user/pwd.jsp";
		}
	}
	//登录功能
	public String login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//封装表单数据到user
		User formUser = CommonUtils.toBean(req.getParameterMap(), User.class);
		//校验表单数据
		Map<String, String> errors = validateLogin(formUser, req.getSession());
		if(errors.size() > 0){
			req.setAttribute("user", formUser);
			req.setAttribute("errors", errors);	
			return "f:/jsps/user/login.jsp";
		}
		//使用service查询
		User user = userService.login(formUser);
		//查看用户是否存在
		//  *保存错误信息（用户名或密码错误）
		//  *保存用户名：为了回显
		//  *转发到login.jsp
		//如果存在，查看状态，如果状态是false：
		//  *保存错误信息：您没有激活
		//  *保存表单数就：为了回显
		//  *转发到login.jsp
		//登录成功
		//  *保存当前用户到session
		//  *保存当前用户名到cookie中，下次该用户登录时，用户名会显示在文本框中，注意中文编码
		if(user == null){
			req.setAttribute("msg", "用户名或密码错误！");
			req.setAttribute("user", formUser);
			return "f:/jsps/user/login.jsp";
		} else {
			if(!user.isStatus()){
				req.setAttribute("msg", "您还没有激活！");
				req.setAttribute("user", formUser);
				return "f:/jsps/user/login.jsp";
			} else {
				req.getSession().setAttribute("sessionUser", user);
				//装换编码
				String loginname = user.getLoginname();
				loginname = URLEncoder.encode(loginname, "utf-8");
				Cookie cookie = new Cookie("loginname", loginname);
				cookie.setMaxAge(60 * 60 * 24 * 10);    //保存十天
				resp.addCookie(cookie);
				return "r:/index.jsp";   //重定向到主页
			}
		}
	}
	
	private Map<String, String> validateLogin(User fromUser, HttpSession session) {
		Map<String, String> errors = new HashMap<String, String>();
		//校验登录名
		String loginname = fromUser.getLoginname();
		if(loginname == null || loginname.trim().isEmpty()){
			errors.put("loginname", "用户名不能为空！");
		} else if(loginname.length() < 3 || loginname.length() > 20){
			errors.put("loginname", "用户名长度必须在3 ~ 20之间！");
		} else if(userService.ajaxvalidateLoginname(loginname)){
			errors.put("loginname", "用户不存在");
		}
		//校验登录密码
		String loginpass = fromUser.getLoginpass();
		if(loginpass == null || loginpass.trim().isEmpty()){ 
			errors.put("loginpass", "密码不能为空！");
		} else if(loginpass.length() < 3 || loginpass.length() > 20){
			errors.put("loginpass", "密码长度必须在3 ~ 20之间！");
		}
		//验证码校验
		String verifyCode = fromUser.getVerifyCode();
		String vcode = (String) session.getAttribute("vCode");
		if(verifyCode == null || verifyCode.trim().isEmpty()){
			errors.put("verifyCode", "验证码不能为空！");
		} else if(!verifyCode.equalsIgnoreCase(vcode)){
			errors.put("verifyCode", "错误的验证码！"); 
		}
		return errors;
	}
	//退出功能
	public String quit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { 
		req.getSession().invalidate();
		return "r:/jsps/user/login.jsp";
	}
} 
