<?php
class BookModel extends Model {
	/**
	* 查看所有书籍
	*/
	public function findAll(){
		$sql = "select * from book_book";
		$result = $this->_dao->query($sql);
		return $result;
	}

	/**
	* 按id查询书籍
	*/
	public function findById($id){
		$sql = "select * from book_book where id = " . $id;
		$result = $this->_dao->getRow($sql);
		return $result;
	} 

	/**
	* 按书名查询书籍
	*/
	public function findByName($name){
		$sql = "select * from book_book where name='" . $name . "'";
		$result = $this->_dao->query($sql);
		return $result;
	}

	/**
	* 模糊查询
	*/
	public function findByLikeName($name){
		$sql1 = "select * from book_book where name='" . $name . "' or soso like '%" . $name . "%'";
		$sql = "select * from book_book where name like '%" . $name . "%'";
		$result = $this->_dao->query($sql1);
		return $result;
	}

	/**
	* 按分类查询书籍
	*/
	public function findByClass($class_id){
		$sql = "select * from book_book where class_id = " . $class_id;
		$result = $this->_dao->query($sql);
		return $result;
	}

	/**
	* 书籍减一
	*/
	public function subKc($id){
		$sql = "select * from book_book where id = '" . $id . "'";
		$result = $this->_dao->getRow($sql);
		$sum = $result['kc'];
		$sum--;
		$sql1 = "update book_book set kc = '" . $sum . "' where id = '" . $id . "'";
		$result1 = $this->_dao->query($sql1);
		return $result1;
	}

	/**
	* 书籍加一
	*/
	public function addKc($id){
		$sql = "select * from book_book where id = '" . $id . "'";
		$result = $this->_dao->getRow($sql);
		$sum = $result['kc'];
		$sum++;
		$sql1 = "update book_book set kc = '" . $sum . "' where id = '" . $id . "'";
		$result1 = $this->_dao->query($sql1);
		return $result1;
	}
}

