<?php
//核心启动类
class Framework{
	//让项目run起来
	public static function run(){
		self::init();
		self::autoload();
		self::router();
	}

	//初始化方法
	public static function init(){
		//定义路径，获取当前工作路径 getcwd()
		define("DS", DIRECTORY_SEPARATOR);
		define("ROOT", getcwd() . DS);
		define("APP_PATH", ROOT . "application" . DS);
		define("FRAMEWORK_PATH", ROOT . "framework" . DS);
		define("PUBLIC_PATH", ROOT . "public" . DS);
		define("MODEL_PATH", APP_PATH . "models" . DS);
		define("VIEW_PATH", APP_PATH . "views" . DS);
		define("CONTROLLER_PATH", APP_PATH . "controllers" . DS);
		define("CONFIG_PATH", APP_PATH . "config" . DS);
		define("CORE_PATH", FRAMEWORK_PATH . "core" . DS);
		define("DB_PATH", FRAMEWORK_PATH . "database" . DS);
		define("HELPER_PATH", FRAMEWORK_PATH . "helpers" . DS);
		define("LIB_PATH", FRAMEWORK_PATH . "libraries" . DS);

		//前后台的控制器和视图目录怎么定义
		define("PLATFORM", isset($_REQUEST['p']) ? $_REQUEST['p'] : "home");
		define("CONTROLLER", isset($_REQUEST['c']) ? ucfirst($_REQUEST['c']) : "Index");
		define("ACTION", isset($_REQUEST['a']) ? $_REQUEST['a'] : "index");

		define("CUR_CONTROLLER_PATH", CONTROLLER_PATH . PLATFORM . DS);
		define("CUR_VIEW_PATH", VIEW_PATH . PLATFORM . DS);
		define("UPLOAD_PATH", PUBLIC_PATH . "uploads" . DS);

		//手动载入核心类
		require CORE_PATH . "Controller.class.php";
		require CORE_PATH . "Model.class.php";
		require DB_PATH . "Mysql.class.php";
		$GLOBALS['config'] = include CONFIG_PATH . "config.php";

	}

	//路由方法
	public static function router(){
		//确定类名和方法名
		$controller_name = CONTROLLER . "Controller";  //如GoodsController
		$action_name = ACTION . "Action";  //如addAction
		//实例化控制器，然后调用相应的方法
		$controller = new $controller_name;
		$controller -> $action_name();
	}

	//自动加载方法
	public static function autoload(){
		spl_autoload_register(array(__CLASS__, "load"));
	}

	//加载方法
	public static function load($classname){
		//只负责加载 application 下面的 控制器类和模型类， 如GoodsController， AdminModel
		if(substr($classname, -10) == 'Controller'){
			require CUR_CONTROLLER_PATH . "{$classname}.class.php";
		} elseif(substr($classname, -5) == 'Model') {
			require MODEL_PATH . "{$classname}.class.php";
		} else {

		}
	}	
}

?>