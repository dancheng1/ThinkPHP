<?php
class BookController extends Controller{
	/**
	* 根据分类查询书籍
	*/
	public function classifyAction(){
		$id = $_GET['classid'];
		$classify = Factory::M('ClassifyModel');
		$result = $classify -> findById($id);
		$class_name = $result['name'];
		$book = Factory::M('BookModel');
		$books = $book -> findByClass($id);
		require CURRENT_VIEW_PATH . 'book.html';
	}

	/**
	* 查看书籍详情
	*/
	public function showAction(){
		$book_id = $_GET['book_id'];
		$book = Factory::M('BookModel');
		$book_desc = $book -> findById($book_id);
		require CURRENT_VIEW_PATH . 'book_edit.html';
	}

	/**
	* 查询书籍
	*/
	public function searchAction(){
	 	$openid = $_COOKIE['openid'];
	 	$str = $_POST['sososo'];
	 	$book = Factory::M('BookModel');
	 	$history = Factory::M('HistoryModel');
		$result = $history -> add($str, $openid);

		$books1 = $book -> findByName($str);
		$books2 = $book -> findByLikeName($str);
		require CURRENT_VIEW_PATH . 'search_book.html';
	}

	/**
	* 查询数据页面查询操作
	*/
	public function h_searchAction(){
	 	$openid = $_COOKIE['openid'];
	 	$str = $_GET['name'];
	 	$book = Factory::M('BookModel');
	 	$history = Factory::M('HistoryModel');
		$result = $history -> add($str, $openid);

		$books1 = $book -> findByName($str);
		$books2 = $book -> findByLikeName($str);
		require CURRENT_VIEW_PATH . 'search_book.html';
	}
}
