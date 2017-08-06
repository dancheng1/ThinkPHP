<?php
//被其他的类调用
class Model{
	protected $_dao;

	protected function _initDAO(){
		//通过数据操作，将比赛列表需要的数据处理
		$config = array('host' => 'localhost',	'port' => '3306', 'username'=>'root', 'password' => '123', 'charset'=>'utf8', 'dbname'=>'shop');
		$this->_dao = MySQLDB::getInstance($config);
	}

	/*构造方法*/
	public function __construct(){
		$this->_initDAO();
	}
}