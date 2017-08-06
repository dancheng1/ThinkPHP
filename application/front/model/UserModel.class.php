<?php
class UserModel extends Model {
	/**
	* 查询用户
	*/
	public function findAll(){
		$sql = 'select * from book_user';
		$result = $this->_dao->query($sql); 
		return $result; 
	} 

	/**
	* 根据用户的通行证和密码查询
	*/
	public function findByTP($txz, $password){
		$sql = "select * from book_user where txz = '" . $txz .  "' and password = md5('" . $password . "')";
		$result = $this->_dao->getRow($sql);
		return $result;
	}

	/**
	* txz查询用户
	*/
	public function findByTxz($txz){
		$sql = "select * from book_user where txz = '" . $txz . "'";
		$result = $this->_dao->getRow($sql);
		return $result;
	}

	/**
	* 按用户id查询
	*/
	public function findById($openid){
		$sql = "select * from book_user where openid = '" . $openid . "'";
		$result = $this->_dao->getRow($sql);
		return $result;
	}

	/**
	* 关联微信 添加用户
	*/
	public function add($openid){
		$user = getUserInfo($openid);
		$openId = $user['openid'];
		$nickname = $user["nickname"];
		$sex = $user["sex"];
		$city = $user["city"];
		$country = $user["country"];
		$province = $user["province"];

		$url = "";
		$img = erweima($url);

		$sql = "insert into book_user(id, nickname, sex, city, country, province, qr_code) values('" . $openId . "','" . $nickname . "','" . $sex . "','" . $city . "','" . $country . "','" . $province . "','" . $img . "')";

		return $this->_dao->query($sql);
	}

	/**
	* 完善信息
	*/
	public function add2($password, $address, $name, $tel, $openid, $qr_code){
		$sql = "UPDATE `book_user` SET address='" . $address . "', name='" . $name . "', tel='" . $tel . "', password=md5('" . $password . "'), qr_code = '" . $qr_code . "', flag = 1 WHERE openid='" . $openid . "'";
		$result = $this->_dao->query($sql);
		return $result;
	}

	/**
	* 删除用户
	*/
	public function delete($id){
		$sql = "delete from book_user where id=" . "'" . $id . "'";
		$result = $this->_dao->query($sql);
		return $result;
	}

	/**
	* 修改用户
	*/
	public function update($address, $name, $tel, $openid){
		$sql = "UPDATE `book_user` SET address='" . $address . "', NAME='" . $name . "', tel='" . $tel . "' WHERE openid='" . $openid . "'";
		$result = $this->_dao->query($sql);
		return $result;
	}

	/**
	* 请求接口   通过http  中的get 或 post
	*/
	function httpRequest($url){
		$ch = curl_init();
		curl_setopt($ch, CURLOPT_URL, $url);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
		$output = curl_exec($ch);
		curl_close($ch);
		if($output == false){
			return "cURL Error:" . curl_error($ch);
		}
		return $output;
	}

	/**
	* 请求接口   通过https 中的get 或 post
	*/
	function https_request($url, $data=null){
		$curl = curl_init();
		curl_setopt($curl, CURLOPT_URL, $url);
		curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false);
		curl_setopt($curl, CURLOPT_SSL_VERIFYHOST, false);
		if(!empty($data)){
			curl_setopt($curl, CURLOPT_POST, 1);
			curl_setopt($curl, CURLOPT_POSTFIELDS, $data);
		}
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
		$output = curl_exec($curl);
		curl_close($curl);
		return $output;
	}

	/**
	* 获取token
	*/
	function get_token(){
		$appid = "wxfd4478db3b0b2ca0";
		$secret = "614a0092bc7e44642b7cd3108c1e0e89";
		$url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={$appid}&secret={$secret}";
		$json = https_request($url);
		$arr = json_decode($json, true);
		return $arr['access_token'];
	}

	/**
	* openid和用户说的内容
	* 获取和客服聊天用户的基本信息形成列表
	*/
	function getUserInfo($openid){
		$access_token = get_token();
		$url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token={$access_token}&openid={$openid}&lang=zh_CN";
		$jsoninfo = httpRequest($url);
		$user = json_decode($jsoninfo, true);
		return $user;
	}

	/**
	* 二维码生成器
	*/
	function erweima($chl) {
    	return '<img src="http://pan.baidu.com/share/qrcode?w=150&h=150&url=' . $chl . '" />';
	}
}
