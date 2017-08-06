<?php
class OrderController extends Controller{
	/**
	* 按个人订单显示书籍
	*/
	public function showAction(){
		$openid = $_COOKIE['openid'];
		$order = Factory::M('OrderModel');
		$result = $order -> findByOrder($openid);

		$book = Factory::M('BookModel');
		$books = array();
		$ids = array();
		$j = 0;
		while($mess = mysql_fetch_assoc($result)){
			$books[] = $book -> findById($mess['book_id']);
			$ids[$j] = $mess['id'];
			$j++;
		}
		require CURRENT_VIEW_PATH . 'order.html';
	}


	/**
	* 添加订单
	*/
	public function addAction(){
		$openid = $_COOKIE['openid'];
		$book_id = $_GET['id'];

		$order = Factory::M('OrderModel');
		$book = Factory::M('BookModel');
		$m_user = Factory::M('UserModel');
		$result = $order -> findByOrder($openid);
		$d_book = $book -> findById($book_id);
		$d_user = $m_user -> findById($openid);

		if($d_book['kc'] < 1){
			$msg = "此书没有库存了，您可以预约！";
			$book_desc = $book -> findById($book_id);
			require CURRENT_VIEW_PATH . 'book_edit.html';
		} else if($d_user['flag'] != 1){
			$msg = "您还没有注册，请先完善信息！";
			$book_desc = $book -> findById($book_id);
			require CURRENT_VIEW_PATH . 'book_edit.html';
		} else {
			$idss = array();
			$i = 0;
			while($mess = mysql_fetch_assoc($result)){
				$idss[$i] = $mess['id'];
				$i++;
			}

			if($i >= 2){
				$result = $order -> findByOrder($openid);
				$books = array();
				$ids = array();

				$j = 0;
				while($mess = mysql_fetch_assoc($result)){
					$books[] = $book -> findById($mess['book_id']);
					$ids[$j] = $mess['id'];
					$j++;
				}

			 	$msg = "借书栏中最多只能加两本书！";
			} else {
				$order -> insert($openid, $book_id);
				$result = $order -> findByOrder($openid);
				$books = array();
				$ids = array();

				$j = 0;
				while($mess = mysql_fetch_assoc($result)){
					$books[] = $book -> findById($mess['book_id']);
					$ids[$j] = $mess['id'];
					$j++;
				}
			}
			require CURRENT_VIEW_PATH . 'order.html';
		}
	}

	/**
	* 按id删除订单
	*/
	public function deleteAction(){
		$openid = $_COOKIE['openid'];
		$id = $_GET['id'];
		$order = Factory::M('OrderModel');
		$order -> delete($id);
		$result = $order -> findByOrder($openid);

		$book = Factory::M('BookModel');
		$books = array();
		$ids = array();

		$i = 0;
		while($mess = mysql_fetch_assoc($result)){
			$books[] = $book -> findById($mess['book_id']);
			$ids[$i] = $mess['id'];
			$i++;
		}
		require CURRENT_VIEW_PATH . 'order.html';
	}

	/**
	* 管理员按id删除用户订单
	*/
	public function gl_deleteAction(){
		$openid = $_GET['openid'];
		$id = $_GET['id'];
		$order = Factory::M('OrderModel');
		$order -> delete($id);
		$result = $order -> findByOrder($openid);

		$book = Factory::M('BookModel');
		$books = array();
		$ids = array();

		$i = 0;
		while($mess = mysql_fetch_assoc($result)){
			$books[] = $book -> findById($mess['book_id']);
			$ids[$i] = $mess['id'];
			$i++;
		}
		require CURRENT_VIEW_PATH . 'order.html';
	}
}

 