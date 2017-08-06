<?php
class HistoryModel extends Model {
	/**
	* 添加历史记录
	*/
	public function add($str, $openid){
		$sql = "insert into book_history(openid, str, time) values('" . $openid . "', '" . $str . "', '" . time() . "')";
		$result = $this->_dao->query($sql); 
		return $result; 
	}

	/**
	* 根据用户id查询历史记录
	*/
	public function findByOpenid($openid){
		$sql = "select * from book_history where openid='" . $openid . "' order by time desc"; 	
		$result = $this->_dao->query($sql);
		return $result;
	}

}
