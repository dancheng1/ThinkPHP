<?php
class ClassifyController extends Controller{	
	/**
	* 查看所有分类
	*/
	public function showAction(){
		$classify = Factory::M('ClassifyModel');
		$classifys = $classify -> findAll();
		require CURRENT_VIEW_PATH . 'classify.html';
	}
}
