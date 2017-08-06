package cn.itcast.goods.book.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.book.domain.Book;
import cn.itcast.goods.book.service.BookService;
import cn.itcast.goods.pager.PageBean;
import cn.itcast.servlet.BaseServlet;

public class BookServlet extends BaseServlet {
	private BookService bookService = new BookService();
	
	//获取当前页
	private int getPc(HttpServletRequest req) {
		int pc = 1;
		String param = req.getParameter("pc");
		if(param != null && !param.trim().isEmpty()){
			try {
				pc = Integer.parseInt(param);
			} catch (RuntimeException e){}
		}
		return pc;
	}
	//获取url
	private String getUrl (HttpServletRequest req){
		String url = req.getRequestURI() + "?" + req.getQueryString();
		//如果url中存在pc参数，截取掉，如果不存在那就不用截
		int index = url.lastIndexOf("&pc=");
		if(index != -1){
			url = url.substring(0, index);
		}
		return url;
	}
	//按bid查询
	public String load(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String bid = req.getParameter("bid");
		Book book = bookService.load(bid);
		req.setAttribute("book", book);
		return "f:/jsps/book/desc.jsp";
	}
	
	//按分类查
	public String findByCategory(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//得到pc:如果页面传递，使用页面的，如果没传，pc=1
		int pc = getPc(req);
		//得到url
		String url = getUrl(req);
		//获取查询条件，本方法就是cid，即分类的id
		String cid = req.getParameter("cid");
		//使用pc和cid调用service#findByCategory得到PageBean
		PageBean<Book> pb = bookService.findByCategory(cid, pc);
		//给PageBean设置url，保存PageBean，转发到/jsps/book/list.jsp
		pb.setUrl(url);
		req.setAttribute("pb", pb);
		return "f:/jsps/book/list.jsp";
	}
	//鎸変綔鑰呮煡璇�
	public String findByAuthor(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//req.setCharacterEncoding("UTF-8");
		//author =     new String(author.getBytes("ISO-8895-1"), "UTF-8");  
		//req.setCharacterEncoding("utf-8");
		//寰楀埌pc:濡傛灉椤甸潰浼犻�锛屼娇鐢ㄩ〉闈㈢殑锛屽鏋滄病浼狅紝pc=1
		int pc = getPc(req);
		//寰楀埌url
		String url = getUrl(req);
		//鑾峰彇鏌ヨ鏉′欢锛屾湰鏂规硶灏辨槸cid,鍗冲垎绫荤殑id
		String author = req.getParameter("author");
		//浣跨敤pc鍜宑id璋冪敤service#findByCategory寰楀埌PageBean
		PageBean<Book> pb = bookService.findByAuthor(author, pc);
		//璁剧疆缁橮ageBean璁剧疆url锛屼繚瀛楶ageBean锛岃浆鍙戝埌/jsps/book/list.jsp
		pb.setUrl(url);
		req.setAttribute("pb", pb);
		return "f:/jsps/book/list.jsp";
	}
	//鎸夊嚭鐗堢ぞ鏌ヨ
	public String findByPress(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int pc = getPc(req);
		String url = getUrl(req);
		String press = req.getParameter("press");
		PageBean<Book> pb = bookService.findByPress(press, pc);
		pb.setUrl(url);
		req.setAttribute("pb", pb);
		return "f:/jsps/book/list.jsp";
	}
	//鎸夊悕绉版煡璇�
	public String findByBname(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int pc = getPc(req);
		String url = getUrl(req);
		String bname = req.getParameter("bname");
		PageBean<Book> pb = bookService.findByBname(bname, pc);
		pb.setUrl(url);
		req.setAttribute("pb", pb);
		return "f:/jsps/book/list.jsp";
	}
	//澶氭潯浠剁粍鍚堟煡璇�
	public String findByCombination(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int pc = getPc(req);
		String url = getUrl(req);
		Book criteria = CommonUtils.toBean(req.getParameterMap(), Book.class);
		PageBean<Book> pb = bookService.findByCombination(criteria, pc);
		pb.setUrl(url);
		req.setAttribute("pb", pb);
		return "f:/jsps/book/list.jsp";
	}
}
