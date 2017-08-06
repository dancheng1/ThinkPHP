<?php
//设置页面内容是html编码格式是utf-8
header("Content-Type: text/plain;charset=utf-8"); 

//如果是POST请求，则进行新建
//$_SERVER是一个超全局变量，在一个脚本的全部作用域中都可用，不用使用global关键字
//$_SERVER["REQUEST_METHOD"]返回访问页面使用的请求方法
if ($_SERVER["REQUEST_METHOD"] == "GET") {
	search();
} elseif ($_SERVER["REQUEST_METHOD"] == "POST"){
	create();
}
//创建员工
function create(){
	//判断信息是否填写完全
	if (!isset($_POST["price"]) || empty($_POST["price"])
		|| !isset($_POST["product_Index"]) || empty($_POST["product_Index"])
		|| !isset($_POST["product_Name"]) || empty($_POST["product_Name"])
		|| !isset($_POST["work_Index"]) || empty($_POST["work_Index"])
		|| !isset($_POST["product_Name"]) || empty($_POST["product_Name"])
		|| !isset($_POST["workerName"]) || empty($_POST["workerName"])
		|| !isset($_POST["cast"]) || empty($_POST["cast"])) {
		echo "参数错误，员工信息填写不全";
		return;
	}
	//TODO: 获取POST表单数据并保存到数据库
	
	//提示保存成功
	echo "物品：" . $_POST["product_Name"] . " 信息保存成功！";
}
