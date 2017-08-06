<?php
	/**
	* 插入人员信息
	*/
	function insert($object){
		include 'conn.inc.php';
		$openId = $object['openid'];
		$nickname = $object["nickname"];
		$sex = $object["sex"];
		$city = $object["city"];
		$province = $object["province"];

		$sql = "insert into book_user(openid, nickname, sex, city, province) values('". $openId ."', '". $nickname ."', ". $sex .", '". $city ."', '". $province ."')";

		mysql_query($sql);
	}

	/**
	* 判断通行令是否存在
	*/
	function exist($str){
		include 'conn.inc.php';
		$sql = "select * from book_user where txz = '" . $str . "'";
		$result = mysql_query($sql);
		if(mysql_num_rows($result) < 1){
			return false;
		}
		return true;
	}

	/**
	* 修改通行令
	*/
	function update($str, $openid){
		include 'conn.inc.php';
		$sql = "update book_user set txz ='" . $str . "' where openid = '" . $openid . "'";
		mysql_query($sql);
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
	* 获取用户基本信息
	*/ 
	function getUserInfo($openid){
		$access_token = get_token();
		$url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token={$access_token}&openid={$openid}&lang=zh_CN";
		$jsoninfo = httpRequest($url);
		$user = json_decode($jsoninfo, true);
		return $user;
	}



?>



