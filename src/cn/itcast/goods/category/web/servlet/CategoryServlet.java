package cn.itcast.goods.category.web.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.goods.category.daomain.Category;
import cn.itcast.goods.category.service.CategoryService;
//����ģ���WEB��
import cn.itcast.servlet.BaseServlet;

public class CategoryServlet extends BaseServlet {
	private CategoryService categoryService = new CategoryService(); 
	//��ѯ���и���
	public String findAll (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//ͨ��service�õ����еķ���
		//���浽request�У�ת����left.jsp
		List<Category> parents = categoryService.findAll();
		req.setAttribute("parents", parents);
		return "f:/jsps/left.jsp";
	}
}
