package cn.itcast.goods.category.web.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.goods.category.daomain.Category;
import cn.itcast.goods.category.service.CategoryService;
//分类模块的WEB层
import cn.itcast.servlet.BaseServlet;

public class CategoryServlet extends BaseServlet {
	private CategoryService categoryService = new CategoryService(); 
	//查询所有父类
	public String findAll (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//通过service得到所有的分类
		//保存到request中，转发到left.jsp
		List<Category> parents = categoryService.findAll();
		req.setAttribute("parents", parents);
		return "f:/jsps/left.jsp";
	}
}
