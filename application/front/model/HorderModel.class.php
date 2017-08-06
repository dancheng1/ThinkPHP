<?php
class HorderModel extends Model{
	/**
	* 添加借书记录
	*/
	public function add($openid, $book_id){
		$sql = "insert into book_horder(openid, book_id, time, flag) values('" . $openid . "', '" . $book_id . "', " . time() . ", 0)";
		$result = $this->_dao->query($sql);
		return $result;
	}

	/**
	* 查询未还书记录
	*/
	public function findByWh($openid){
		$sql = "SELECT * FROM book_horder WHERE openid = '" . $openid . "' AND flag = 0";
		$result = $this->_dao->query($sql);
		return $result;
	}

	/**
	* 查询已还书记录
	*/
	public function findByYh($openid){
		$sql = "SELECT * FROM book_horder WHERE openid = '" . $openid . "' AND flag = 1";
		$result = $this->_dao->query($sql);
		return $result;
	}

	/**
	* 查询还书记录ById
	*/
	public function findById($id){
		$sql = "select * from book_horder where id = '" . $id . "'";
		$result = $this->_dao->getRow($sql);
		return $result;
	}

	/**
	* 根据用户的还书进行修改历史记录
	*/
	public function updatetime($id){
		$sql = "update book_horder set gh_time = '" . time() . "', flag = 1 where id = '" . $id . "'";
		$result = $this->_dao->query($sql);
		return $result;
	}

	/**
	* 查询整个借书单查询书籍
	*/
	public function findByBookId($book_id){
		$sql = "select * from book_horder where book_id = '" . $book_id . "' and flag = 0";
		$result = $this->_dao->query($sql);
		return $result;
	}
}

