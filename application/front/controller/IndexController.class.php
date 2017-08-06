<?php
class IndexController extends Controller{
	/**
	* 显示主页面
	*/
	public function showAction(){
		$classify = Factory::M('ClassifyModel');
		$classifys = $classify -> findAll();
		$book = Factory::M('BookModel');
		$books = $book -> findAll();
		require CURRENT_VIEW_PATH . 'index.html';
	}
}
