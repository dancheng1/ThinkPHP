<?php
//Admin模型
class AdminModel extends Model{
	public function test(){
		$sql = "select * from {$this->table}";
		return $this->db->getAll($sql);
	}

	//验证用户名和密码
	public function checkUser($username, $password){
		$password = md5($password);
		$sql = "select * from {$this->table} where username = '$username' and password = '$password' limit 1";
		return $this->db->getRow($sql);
	}
}