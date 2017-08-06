<?php
class HorderController extends Controller{
	/**
	* 显示借书记录
	*/
	public function showAction(){
		$openid = $_COOKIE['openid'];
		$horder = Factory::M('HorderModel');
		$book = Factory::M('BookModel');
		$horders1 = $horder -> findByWh($openid);
		$horders2 = $horder -> findByYh($openid);

		$time1 = array();
		$time2 = array();
		$gh_time = array();
		
		$books1 = array();
		$books2 = array();
		$ids1 = array();
		$ids2 = array();
		$i = 0;
		while($mess = mysql_fetch_assoc($horders1)){
			$books1[] = $book -> findById($mess['book_id']);
			$ids1[$i] = $mess['id'];
			$time1[$i] = $mess['time'];
			$i++;
		}
		$i = 0;
		while($mess = mysql_fetch_assoc($horders2)){
			$books2[] = $book -> findById($mess['book_id']);
			$ids2[$i] = $mess['id'];
			$time2[$i] = $mess['time'];
			$gh_time[$i] = $mess['gh_time'];
			$i++;
		}

		require CURRENT_VIEW_PATH . 'horder.html';
	}

	/**
	* 根据提交的订单添加借书记录
	*/
	public function addByOrderAction(){
		$userOpenid = $_GET['openid'];
		$order = Factory::M('OrderModel');
		$book = Factory::M('BookModel');
		$horder = Factory::M('HorderModel');
		$result = $order -> findByOrder($userOpenid);
		$ids = array();

		$pd = true;
		$i = 1;
		$j = 0;
		while($mess = mysql_fetch_assoc($result)){
			$book_book = $book -> findById($mess['book_id']);
			$ids[$j] = $mess['book_id'];
			if($book_book['kc'] < 1){
				$pd = false;
				break;
			}
			$i++;$j++;
		}

		if($pd == true){
			for($l = 0; $l < $j; $l++){
				$horder -> add($userOpenid, $ids[$l]);
				$book -> subKc($ids[$l]);
			}
			$order -> deleteByUserOpenid($userOpenid);
			echo '请自行返回！';
		} else {
			$book_book = $book -> findById($ids[$i - 1]);
			$msg = $book_book['name'] . '已被借没！';
			require CURRENT_VIEW_PATH . 'gl_order.html';
		}

	}

	/**
	* 根据还书单id进行还书操作
	*/
	public function HsAction(){
		$id = $_GET['id'];
		$m_horder = Factory::M('HorderModel');
		$book = Factory::M('BookModel');
		$result = $m_horder -> findById($id);

		$book -> addKc($result['book_id']);
		$m_horder -> updatetime($id);
		echo '请自行返回！';
	}
}

