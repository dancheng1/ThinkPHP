<?php
class YorderModel extends Model{
	/**
	* 显示所有预约书籍
	*/
	public function findAll($openid){
		$sql = "select * from book_yorder where openid = '" . $openid . "'";
		$result = $this->_dao->query($sql);
		return $result;
	}

	/**
	* 添加预约
	*/
	public function add($openid, $book_id){
		$sql = "insert into book_yorder(openid, book_id) values('" . $openid . "', '" . $book_id . "')";
		$result = $this->_dao->query($sql);
		return $result;
	}

	/**
	* 删除预约
	*/
	public function delete($id){
		$sql = "delete from book_yorder where id = " . $id;
		$result = $this->_dao->query($sql);
		return $result;
	}
}

