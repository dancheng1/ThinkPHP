package cn.itcast.goods.cart.domain;

import java.math.BigDecimal;

import cn.itcast.goods.book.domain.Book;
import cn.itcast.goods.user.daomain.User;

public class CartItem {
	private String cartItemId;//����
	private int quantity;//����
	private Book book;//��Ŀ��Ӧ��ͼ��
	private User user;//�����û�	
	
	//���С�Ʒ���
	public double getSubtotal() {
		//ʹ��BigDecimal���������,   Ҫ�����ʹ��String���͹�����
		BigDecimal b1 = new BigDecimal(book.getCurrPrice() + "");
		BigDecimal b2 = new BigDecimal(quantity + "");
		BigDecimal b3 = b1.multiply(b2);
		return b3.doubleValue();
	}
	
	public String getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}