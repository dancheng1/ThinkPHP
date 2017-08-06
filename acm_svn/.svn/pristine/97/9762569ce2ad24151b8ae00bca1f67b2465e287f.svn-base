<?php
//基础控制器
class Controller{
	public function jump($url, $message, $wait = 3){
		if($wait == 0){
			header("Location:$url");
		} else {
			include CUR_VIEW_PATH . "message.html";
		}
		//要强制退出
		exit();
	}

	//定义载入负责函数方法
	public function helper($helper){
		require HELPER_PATH . "{$helper}_helper.php";
	}

	//载入类库文件方法
	public function library($lib){
		require LIB_PATH . "{$lib}.class.php";
	}
}