<?php
//目录常量
define('ROOT_PATH', getCWD() . '/');
define('APPLICTION_PATH', ROOT_PATH . 'application/');
define('FRAMEWORK_PATH', ROOT_PATH . 'framework/');


function userAutoload($class_name) {
	$framework_class_list = array(
		// '类名' => '类文件地址'
		'Controller'	=> FRAMEWORK_PATH . 'Controller.class.php',
		'Model' 		=> FRAMEWORK_PATH . 'Model.class.php',
		'Factory'		=> FRAMEWORK_PATH . 'Factory.class.php',
		'MySQLDB' 		=> FRAMEWORK_PATH . 'MySQLDB.class.php',
		) ;
	//判断是否为核心类
	if (isset($framework_class_list[$class_name])) {
		//是核心类
		require $framework_class_list[$class_name];
	}
	//判断是否为可增加（控制器类，模型类）
	//控制器类，截取后是个字符，匹配Controller
	elseif (substr($class_name, -10) == 'Controller') {
		// 控制器类， 当前平台下controller目录
		require CURRENT_CONTROLLER_PATH . $class_name . '.class.php';
	}
	//模型类，截取后5个字符，匹配Model
	elseif (substr($class_name, -5) == 'Model') {
		// 模型类，当前平台下model目录
		require CURRENT_MODEL_PATH . $class_name . '.class.php';
	}
}
spl_autoload_register('userAutoload');



//确定分发参数
//确定平台
$defualt_platform = 'front';
define('PLATFORM', isset($_GET['p']) ? $_GET['p'] : $defualt_platform);
//确定控制器参数
$default_controller = 'Index';
define('CONTROLLER', isset($_GET['c']) ? $_GET['c'] : $default_controller);
//确定动作
$default_action = 'show';
define('ACTION', isset($_GET['a']) ? $_GET['a'] : $default_action);


define('CURRENT_CONTROLLER_PATH', APPLICTION_PATH . PLATFORM . '/controller/');
define('CURRENT_MODEL_PATH', APPLICTION_PATH . PLATFORM . '/model/');
define('CURRENT_VIEW_PATH', APPLICTION_PATH . PLATFORM . '/view/');
 
$controller_name = CONTROLLER . 'Controller';
$controller = new $controller_name();
$actionname = ACTION . 'Action';
$controller->$actionname();
