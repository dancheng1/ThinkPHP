<?php
class OrderModel extends Model{
	/**
	* 按个人订单显示书籍
	*/
	public function findByOrder($openid){
		$sql = "select * from book_order where openid='" . $openid . "'";
		$result = $this->_dao->query($sql);
		return $result;
	}

	/**
	* 查询个人订单的个数
	*/
	public function findCount($openid){
		$sql = "SELECT count( * ) AS count FROM book_order WHERE openid = '" . $openid . "'";
		$result = $this->_dao->query($sql);
		return $result;
	}

	/**
	* 添加订单
	*/
	public function insert($openid, $book_id){
		$sql = "insert into book_order(openid, book_id) values('" . $openid . "', '" . $book_id . "')";
		$result = $this->_dao->query($sql); 
		return $result; 
	}

	/**
	* 按id删除订单
	*/
	public function delete($id){
		$sql = "delete from book_order where id = '" . $id . "'";
		$result = $this->_dao->query($sql); 
		return $result; 
	}

	/**
	* 按openid删除订单
	*/
	public function deleteByUserOpenid($openid){
		$sql = "delete from book_order where openid = '" . $openid . "'";
		$result = $this->_dao->query($sql); 
		return $result; 
	}
}


