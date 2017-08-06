<?php
//后台基础控制器
class BaseController extends Controller{
	//构造方法
	public function __construct(){
		$this->checkLogin();
	}
	//验证用户是否登录
	public function checkLogin(){
		session_start();
		//只需要检查session即可
		if (empty($_SESSION['admin'])){
			//说明没有登录,就需要给出提示，并跳转到登录页面
			$this->jump("index.php?p=admin&c=login&a=login","你还没有登录呢",3);
		}
	}
}