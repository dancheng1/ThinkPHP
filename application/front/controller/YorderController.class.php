<?php
class YorderController extends Controller{
	/**
	* 查询所有书籍
	*/
	public function findAllAction(){
		$openid = $_COOKIE['openid'];
		$y_order = Factory::M('YorderModel');
		$book = Factory::M('BookModel');
		$h_order = Factory::M('HorderModel');
		$yorders = $y_order -> findAll($openid);

		$ids = array();
		$books = array();
		$times = array();

		$i = 0;
		while($mess = mysql_fetch_assoc($yorders)){
			$ids[$i] = $mess['id'];
			$books[$i] = $book -> findById($mess['book_id']);
			$result = $h_order -> findByBookId($mess['book_id']);
			$temp = 0;
			while($cx_book = mysql_fetch_assoc($result)){
				if($cx_book['time'] > $temp){
					$temp = $cx_book['time'];
				}
			}
			if(($temp + 604800) < time()){
				$times[$i] = 0;
			} else {
				$times[$i] = ($temp + 604800) - time();
			}
			$i++;
		}

		echo '<meta http-equiv="refresh" content="1">';
		require CURRENT_VIEW_PATH . 'addyy_book.html';
	}

	/**
	* 预约栏添加数据
	*/
	public function addAction(){
		$openid = $_COOKIE['openid'];
		$book_id = $_GET['id'];
		$y_order = Factory::M('YorderModel');
		$book = Factory::M('BookModel');
		$h_order = Factory::M('HorderModel');
		$y_order -> add($openid, $book_id);

		$yorders = $y_order -> findAll($openid);

		$ids = array();
		$books = array();
		$times = array();

		$i = 0;
		while($mess = mysql_fetch_assoc($yorders)){
			$ids[$i] = $mess['id'];
			$books[$i] = $book -> findById($mess['book_id']);
			$result = $h_order -> findByBookId($mess['book_id']);
			$temp = 0;
			while($cx_book = mysql_fetch_assoc($result)){
				if($cx_book['time'] > $temp){
					$temp = $cx_book['time'];
				}
			}
			if(($temp + 604800) < time()){
				$times[$i] = 0;
			} else {
				$times[$i] = ($temp + 604800) - time();
			}
			$i++;
		}
		require CURRENT_VIEW_PATH . 'addyy_book.html';
	}

	/**
	* 预约栏删除数据
	*/
	public function deleteAction(){
		$openid = $_COOKIE['openid'];
		$id = $_GET['id'];
		$y_order = Factory::M('YorderModel');
		$book = Factory::M('BookModel');
		$h_order = Factory::M('HorderModel');
		$y_order -> delete($id);

		$yorders = $y_order -> findAll($openid);
		$ids = array();
		$books = array();
		$times = array();

		$i = 0;
		while($mess = mysql_fetch_assoc($yorders)){
			$ids[$i] = $mess['id'];
			$books[$i] = $book -> findById($mess['book_id']);
			$result = $h_order -> findByBookId($mess['book_id']);
			$temp = 0;
			while($cx_book = mysql_fetch_assoc($result)){
				if($cx_book['time'] > $temp){
					$temp = $cx_book['time'];
				}
			}
			if(($temp + 604800) < time()){
				$times[$i] = 0;
			} else {
				$times[$i] = ($temp + 604800) - time();
			}
			$i++;
		}  
		require CURRENT_VIEW_PATH . 'addyy_book.html';
	}
}


