<?php
class ClassifyModel extends Model {
	/**
	* 查询所有分类
	*/
	public function findAll(){
		$sql = "select * from book_category";
		$result = $this->_dao->query($sql);
		return $result;
	}

	/**
	* 按id查询分类
	*/
	public function findById($id){
		$sql = "select * from book_category where id = '" . $id . "'";
		$result = $this->_dao->getRow($sql);
		return $result;
	}
}
