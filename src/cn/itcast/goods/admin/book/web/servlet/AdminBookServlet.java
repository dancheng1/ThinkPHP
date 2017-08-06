package cn.itcast.goods.admin.book.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.book.domain.Book;
import cn.itcast.goods.book.service.BookService;
import cn.itcast.goods.category.daomain.Category;
import cn.itcast.goods.category.service.CategoryService;
import cn.itcast.goods.pager.PageBean;
import cn.itcast.servlet.BaseServlet;

public class AdminBookServlet extends BaseServlet {
	private BookService bookService  = new BookService();
	private CategoryService categoryService = new CategoryService();  
	/**
	 * 添加图书第一步
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String addPre (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 1.获取所有一级分类，保存
		 * 2.转发到add.jsp，该页面会在下拉列表中显示所有一级分类
		 */
		List<Category> parents = categoryService.findParents();
		req.setAttribute("parents", parents);
		return "f:/adminjsps/admin/book/add.jsp";
	}
	
	public String ajaxFindChildren (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 1.获取pid
		 * 2.通过pid查询出所有二级分类
		 * 3.吧List<Category>转换成json，输出给客户端
		 */
		String pid = req.getParameter("pid");
		List<Category> children = categoryService.findChildren(pid);
		String json = toJson(children);
		resp.getWriter().print(json);
		System.out.println(json);
		return null;
	}
	/**
	 * 功能：生成 {"cid":"asdasd", "cname":"asdasd"}
	 * @param category
	 * @return
	 */
	private String toJson(Category category){
		StringBuilder sb = new StringBuilder("{");
		sb.append("\"cid\"").append(":").append("\"").append(category.getCid()).append("\"");
		sb.append(",");
		sb.append("\"cname\"").append(":").append("\"").append(category.getCname()).append("\"");	
		sb.append("}");
		return sb.toString();
	}
	/**
	 * 功能：生成 [{"cid":"asdasd", "cname":"asdasd"}, {"cid":"asdasd", "cname":"asdasd"}]
	 * @param categoryList
	 * @return
	 */
	private String toJson(List<Category> categoryList){
		StringBuilder sb = new StringBuilder("[");
		for(int i = 0; i < categoryList.size(); i++){
			sb.append(toJson(categoryList.get(i)));
			if(i < categoryList.size() - 1){
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	
	/**
	 * 显示所有分类
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findCategoryAll (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//通过service得到所有的分类
		//保存到request中，转发到left.jsp
		List<Category> parents = categoryService.findAll();
		req.setAttribute("parents", parents);
		return "f:/adminjsps/admin/book/left.jsp";
	}
	
	
	
	
	
	/**
	 * 获取当前页
	 * @param req
	 * @return
	 */
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
	/**
	 * 获取url
	 * @param req
	 * @return
	 */
	private String getUrl (HttpServletRequest req){
		String url = req.getRequestURI() + "?" + req.getQueryString();
		//如果url中存在pc参数，截取掉，如果不存在那就不用截
		int index = url.lastIndexOf("&pc=");
		if(index != -1){
			url = url.substring(0, index);
		}
		return url;
	}
	/**
	 * 按bid查询
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String load(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String bid = req.getParameter("bid");
		Book book = bookService.load(bid);
		req.setAttribute("book", book);
		return "f:/adminjsps/admin/book/desc.jsp";
	}
	
	/**
	 * 按分类查
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
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
		return "f:/adminjsps/admin/book/list.jsp";
	}
	/**
	 * 按作者查
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByAuthor(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//req.setCharacterEncoding("UTF-8");
		//author =     new String(author.getBytes("ISO-8895-1"), "UTF-8");  
		//req.setCharacterEncoding("utf-8");
		//得到pc:如果页面传递，使用页面的， 如果没传，pc=1
		int pc = getPc(req);
		//得到url
		String url = getUrl(req);
		//获得查询条件，本方法就是cid，即分类的id
		String author = req.getParameter("author");
		//使用pc和cid调用service#findByCategory得到pageBean
		PageBean<Book> pb = bookService.findByAuthor(author, pc);
		//给pageBean设置url，保存PageBean，转发到adminjsps/admin/book/list.jsp
		pb.setUrl(url);
		req.setAttribute("pb", pb);
		return "f:/adminjsps/admin/book/list.jsp";
	}
	/**
	 * 安出版社查询
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByPress(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int pc = getPc(req);
		String url = getUrl(req);
		String press = req.getParameter("press");
		PageBean<Book> pb = bookService.findByPress(press, pc);
		pb.setUrl(url);
		req.setAttribute("pb", pb);
		return "f:/adminjsps/admin/book/list.jsp";
	}
	/**
	 * 按书名查询
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByBname(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int pc = getPc(req);
		String url = getUrl(req);
		String bname = req.getParameter("bname");
		PageBean<Book> pb = bookService.findByBname(bname, pc);
		pb.setUrl(url);
		req.setAttribute("pb", pb);
		return "f:/adminjsps/admin/book/list.jsp";
	}
	/**
	 * 多条件组合查询
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByCombination(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int pc = getPc(req);
		String url = getUrl(req);
		Book criteria = CommonUtils.toBean(req.getParameterMap(), Book.class);
		PageBean<Book> pb = bookService.findByCombination(criteria, pc);
		pb.setUrl(url);
		req.setAttribute("pb", pb);
		return "f:/adminjsps/admin/book/list.jsp";
	}
}
