<?php
class UserController extends Controller {
	/**
	* 进入登录页面
	*/
	public function loginAction(){
		require CURRENT_VIEW_PATH . 'login.html';
	}

	/**
	* 通行证跳转
	*/
	public function txzAction(){
		require CURRENT_VIEW_PATH . 'txz.html';
	}

	/**
	* 跳转到用户修改页面
	*/
	public function updateUserAction(){
		$openid = $_COOKIE['openid'];
		require CURRENT_VIEW_PATH . 'update_user.html';
	}

	/**
	* 管理员跳转到用户的还书页面
	*/
	public function glHBookAction(){
		$userOpenid = $_GET['openid'];
		$openid = $_COOKIE['openid'];
		$m_user = Factory::M('UserModel');
		$glUser = $m_user -> findById($openid);

		if($glUser['grade'] >= 1){
			$horder = Factory::M('HorderModel');
			$book = Factory::M('BookModel');
			$horders = $horder -> findByWh($userOpenid);

			$time = array();
			$books = array();
			$ids = array();

			$i = 0;
			while($mess = mysql_fetch_assoc($horders)){
				$books[] = $book -> findById($mess['book_id']);
				$ids[$i] = $mess['id'];
				$time[$i] = $mess['time'];
				$i++;
			}
			require CURRENT_VIEW_PATH . 'h_book.html';
		} else {
			$msg = "您没有权限访问用户的还书页面！";
			require CURRENT_VIEW_PATH . 'user.php';
		}
	}

	/**
	* 管理员跳转到用户的订单页面
	*/
	public function glOrderAction(){
		$userOpenid = $_GET['openid'];
		$openid = $_COOKIE['openid'];
		$m_user = Factory::M('UserModel');
		$glUser = $m_user -> findById($openid);

		if($glUser['grade'] >= 1){
			$order = Factory::M('OrderModel');
			$result = $order -> findByOrder($userOpenid);

			$book = Factory::M('BookModel');
			$books = array();
			$ids = array();
			$j = 0;
			while($mess = mysql_fetch_assoc($result)){
				$books[] = $book -> findById($mess['book_id']);
				$ids[$j] = $mess['id'];
				$j++;
			}
			require CURRENT_VIEW_PATH . 'gl_order.html';
		} else {
			$msg = "您没有权限访问用户的订单！";
			require CURRENT_VIEW_PATH . 'user.php';
		}

	}

	/**
	* 个人二维码显示
	*/
	public function qrcodeAction(){
		$openid = $_COOKIE['openid'];
		$m_user = Factory::M('UserModel');
		$result = $m_user -> findById($openid);
		$img = $result['qr_code'];
		require CURRENT_VIEW_PATH . 'qrcode.html';
	}

	/**
	* 验证登录页面
	*/
	public function testLoginAction(){
		$txz = $_POST['txz'];
		$password = $_POST['password'];

		$m_user = Factory::M('UserModel');
		$result = $m_user -> findByTP($txz, $password);
		if($result == false){
			$msg = "您输入的用户不存在或密码不正确！";
			require CURRENT_VIEW_PATH . 'login.html';
		} else {
			$openid = $result['openid'];
			setcookie('openid', $openid, time() + PHP_INT_MAX);
			$classify = Factory::M('ClassifyModel');
			$classifys = $classify -> findAll();
			require CURRENT_VIEW_PATH . 'index.html';
		}
	}

	/**
	* 完善信息
	*/
	public function updateAction(){
		$openid = $_POST['openid']; 
		$name = $_POST['name'];
		$tel = $_POST['tel'];
		$address = $_POST['address'];

		if(strlen($name) > 32){
			$errorsMsg1 = "名字长度不能超过32位！";
		} else if(strlen($name) == 0){
			$errorsMsg1 = "名字不能为空！";
		}
		if(strlen($tel) < 6){
			$errorsMsg2 = "电话号码长度不能低于6位！";
		} else if(strlen($tel) > 11){
			$errorsMsg2 = "电话号码长度不能超过11位";
		}
		if(strlen($address) < 6){
			$errorsMsg3 = "地址需要填详细地址！";
		}

		if(!isset($errorsMsg1) && !isset($errorsMsg2) && !isset($errorsMsg3)){
			$m_user = Factory::M('UserModel');
			$m_user -> update($address, $name, $tel, $openid);
			$classify = Factory::M('ClassifyModel');
			$classifys = $classify -> findAll();
			require CURRENT_VIEW_PATH . 'index.html';
		} else {
			require CURRENT_VIEW_PATH . 'update_user.html';
		}
	}

	/**
	* 完善信息验证
	*/
	public function registAction(){ 
		$openid = $_POST['openid']; 
		$name = $_POST['name'];
		$tel = $_POST['tel'];
		$address = $_POST['address'];
		$password = $_POST['password'];
		$password1 = $_POST['password1'];

		if(strlen($name) > 32){
			$errorsMsg1 = "名字长度不能超过32位！";
		} else if(strlen($name) == 0){
			$errorsMsg1 = "名字不能为空！";
		}
		if(strlen($tel) < 6){
			$errorsMsg2 = "电话号码长度不能低于6位！";
		} else if(strlen($tel) > 11){
			$errorsMsg2 = "电话号码长度不能超过11位";
		}
		if(strlen($address) < 6){
			$errorsMsg3 = "地址需要填详细地址！";
		}
		if(strlen($password) < 8 || strlen($password) > 16){
			$errorsMsg4 = "密码长度在8~16的范围！";
		} 
		if($password != $password1){
			$errorsMsg5 = "两次密码不同！";
		} 

		if(!isset($errorsMsg1) && !isset($errorsMsg2) && !isset($errorsMsg3)&& !isset($errorsMsg4) && !isset($errorsMsg5)){
			$qr_code = '<img src="http://pan.baidu.com/share/qrcode?w=150&h=150&url=http://skydancheng.duapp.com/application/front/view/user.php?openid='.  $openid .'" />';

			$m_user = Factory::M('UserModel');
			$m_user -> add2($password, $address, $name, $tel, $openid, $qr_code);
			setcookie('openid', $openid, time() + PHP_INT_MAX);
			$classify = Factory::M('ClassifyModel');
			$classifys = $classify -> findAll();
			require CURRENT_VIEW_PATH . 'index.html';
		} else {
			require CURRENT_VIEW_PATH . 'regist.html';
		}
	}

	/**
	* 验证通行证
	*/
	public function testTxzAction(){
		$txz = $_POST['txz'];
		$m_user = Factory::M('UserModel');
		$result = $m_user -> findByTxz($txz);
		$openid = $result['openid'];
		if($result == false){
			$msg = "系统没有此通行证！";
			require CURRENT_VIEW_PATH . 'txz.html';
		} else {
			$res = $m_user -> findById($openid);
			if($res['flag'] > 0){
				$msg = "您已经注册过了！";
				require CURRENT_VIEW_PATH . 'txz.html';
			} else {
				require CURRENT_VIEW_PATH . 'regist.html';
			}
		}  
	}

	/** 
	* 查询用户
	*/
	public function findAllAction(){ 
		$m_user = Factory::M('UserModel');
		$result = $m_user->findAll();
		while($record = mysql_fetch_array($result)){
			echo "<tr>";
			$fieldCount = mysql_num_fields($result);
			for($i = 0; $i < $fieldCount; ++$i){
				$fieldName = mysql_field_name($result, $i);
				echo "<td>" . $record[$fieldName] . "</td>";
			}
			echo "</tr>";
		}
	}

	/**
	* 按用户id查询
	*/
	public function findByIdAction(){
		$id = $_GET[''];
		$m_user = Factory::M('UserModel');
		$result = $m_user->findById($id);
	}

	/**
	* 完善信息
	*/
	public function addAction(){
		$address = $_POST[''];
		$name = $_POST[''];
		$tel = $_POST[''];
		$id = $_GET[''];
		$m_user = Factory::M('UserModel');
		$result = $m_user->add2($address, $name, $tel, $id);
	}

	/**
	* 删除用户
	*/
	public function deleteAction(){
		$id = $_GET[''];
		$m_user = Factory::M('UserModel');
		$result = $m_user->delete($id);
	}
}
