package cn.itcast.goods.cart.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.cart.dao.CartItemDao;
import cn.itcast.goods.cart.domain.CartItem;

public class CartItemService {
	private CartItemDao  cartItemDao = new CartItemDao();
	//加载多个cartItem
	public List<CartItem> loadCartItems(String cartItemIds){
		try {
			return cartItemDao.loadCartItem(cartItemIds);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//修改条目数量
	public CartItem updateQuantity(String cartItemId, int quantity){
		try{
			cartItemDao.updateQuantity(cartItemId, quantity);
			return cartItemDao.findByCartItemId(cartItemId);
		} catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	//批量删除
	public void batchDelete(String cartItemIds){
		try {
			cartItemDao.batchDelete(cartItemIds);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//添加条目
	public void add(CartItem cartItem){
		//使用uid和bid去数据库中查询这个条目是否存在
		try {
			CartItem _cartItem = cartItemDao.findByUidAndBid(cartItem.getUser().getUid(),
					cartItem.getBook().getBid());
			if(_cartItem == null){//如果原来没有   添加
				cartItem.setCartItemId(CommonUtils.uuid());
				cartItemDao.addCartItem(cartItem);
			} else {//如果原来有    修改条目
				//使用原有数量和新条目数量之和来做新的数量
				int quantity = cartItem.getQuantity() + _cartItem.getQuantity();
				//修改这个老条目的数量
				cartItemDao.updateQuantity(_cartItem.getCartItemId(), quantity);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//我的购物车
	public List<CartItem> myCart(String uid){
		try {
			return cartItemDao.findByUid(uid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
