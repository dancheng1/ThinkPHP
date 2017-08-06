package cn.itcast.goods.cart.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.cart.dao.CartItemDao;
import cn.itcast.goods.cart.domain.CartItem;

public class CartItemService {
	private CartItemDao  cartItemDao = new CartItemDao();
	//���ض��cartItem
	public List<CartItem> loadCartItems(String cartItemIds){
		try {
			return cartItemDao.loadCartItem(cartItemIds);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//�޸���Ŀ����
	public CartItem updateQuantity(String cartItemId, int quantity){
		try{
			cartItemDao.updateQuantity(cartItemId, quantity);
			return cartItemDao.findByCartItemId(cartItemId);
		} catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	//����ɾ��
	public void batchDelete(String cartItemIds){
		try {
			cartItemDao.batchDelete(cartItemIds);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//�����Ŀ
	public void add(CartItem cartItem){
		//ʹ��uid��bidȥ���ݿ��в�ѯ�����Ŀ�Ƿ����
		try {
			CartItem _cartItem = cartItemDao.findByUidAndBid(cartItem.getUser().getUid(),
					cartItem.getBook().getBid());
			if(_cartItem == null){//���ԭ��û��   ���
				cartItem.setCartItemId(CommonUtils.uuid());
				cartItemDao.addCartItem(cartItem);
			} else {//���ԭ����    �޸���Ŀ
				//ʹ��ԭ������������Ŀ����֮�������µ�����
				int quantity = cartItem.getQuantity() + _cartItem.getQuantity();
				//�޸��������Ŀ������
				cartItemDao.updateQuantity(_cartItem.getCartItemId(), quantity);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//�ҵĹ��ﳵ
	public List<CartItem> myCart(String uid){
		try {
			return cartItemDao.findByUid(uid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
