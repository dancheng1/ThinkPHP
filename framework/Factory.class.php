<?php
/*
项目中的工厂类
实现单例模式	
*/
class Factory{
	//生成单例对象
	public static function M($model_name){
		static $model_list = array();
		if(!isset($model_list[$model_name])){
			$model_list[$model_name] = new $model_name;
		}	
		return $model_list[$model_name];
	}
}