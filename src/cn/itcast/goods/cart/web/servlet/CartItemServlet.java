package cn.itcast.goods.cart.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.book.domain.Book;
import cn.itcast.goods.cart.domain.CartItem;
import cn.itcast.goods.cart.service.CartItemService;
import cn.itcast.goods.user.daomain.User;
import cn.itcast.servlet.BaseServlet;

public class CartItemServlet extends BaseServlet {
	private CartItemService cartItemService = new CartItemService();
	//���ض��cartItem
	public String loadCartItems(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡcartItemIds����
		String cartItemIds = req.getParameter("cartItemIds");
		double total = Double.parseDouble(req.getParameter("total"));
		//ͨ��service�õ�List<CartItem>
		List<CartItem> cartItemList = cartItemService.loadCartItems(cartItemIds);
		//���棬Ȼ��ת����/cart/showitem.jsp
		req.setAttribute("cartItemList", cartItemList);
		req.setAttribute("total", total);
		req.setAttribute("cartItemIds", cartItemIds);
		return "f:/jsps/cart/showitem.jsp";
	}
	
	public String updateQuantity(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cartItemId = req.getParameter("cartItemId");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		CartItem cartItem = cartItemService.updateQuantity(cartItemId, quantity);
		StringBuilder sb = new StringBuilder("{");
		sb.append("\"quantity\"").append(":").append(cartItem.getQuantity());
		sb.append(",");
		sb.append("\"subtotal\"").append(":").append(cartItem.getSubtotal());
		sb.append("}");
		System.out.println(sb);
		resp.getWriter().print(sb);
		return null;
	}
	
	public String batchDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡcartItemIds����
		//����service��ɹ���
		//����list.jsp
		String cartItemIds = req.getParameter("cartItemIds");
		cartItemService.batchDelete(cartItemIds);
		return myCart(req, resp);
	}
	
	//��ӹ��ﳵ��Ŀ
	public String add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��װ�����ݵ�CartItem(bid, quantity)
		Map map = req.getParameterMap();
		CartItem cartItem = CommonUtils.toBean(map, CartItem.class);
		Book book = CommonUtils.toBean(map, Book.class);
		User user = (User)req.getSession().getAttribute("sessionUser");
		cartItem.setBook(book);
		cartItem.setUser(user);
		
		//����service������
		cartItemService.add(cartItem);
		//��ѯ��ǰ�û���������Ŀ
		return myCart(req, resp);
	}
	
	public String myCart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�õ�uid
		User user = (User)req.getSession().getAttribute("sessionUser");
		String uid = user.getUid();
		//ͨ��service�õ���ǰ�û������й��ﳵ����Ŀ
		List<CartItem> cartItemList = cartItemService.myCart(uid);
		//����������ת����/cart/list.jsp
		req.setAttribute("cartItemList", cartItemList);
		return "f:/jsps/cart/list.jsp";
	}
	
}
