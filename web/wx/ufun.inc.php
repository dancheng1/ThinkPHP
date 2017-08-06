<?php

	$access_token = get_token();
	//请求接口   通过http  中的get 或 post
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

	//请求接口   通过https 中的get 或 post
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

		//执行并获取HTML文档内容
		$output = curl_exec($curl);

		//释放curl句柄
		curl_close($curl);

		return $output;
	}

	//获取token
	function get_token(){
		$appid = "wxfd4478db3b0b2ca0";
		$secret = "614a0092bc7e44642b7cd3108c1e0e89";
		$url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={$appid}&secret={$secret}";

		$json = https_request($url);

		$arr = json_decode($json, true);

		return $arr['access_token'];
	}

	//openid和用户说的内容
	//获取和客服聊天用户的基本信息形成列表
	function getUserInfo($openid){
		global $access_token;
		//$access_token = get_token();
		$url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token={$access_token}&openid={$openid}&lang=zh_CN";
		
		//请求获取用户信息的接口，返回这个openid对应的用户信息，json格式
		$jsoninfo = httpRequest($url);
		
		//将json转成php的数组，可以使用php数组操作这个用户信息
		$user = json_decode($jsoninfo, true);
		
		//测试
		//$result .= "111 openid = " . $user['openid'] . "  nickname = " . $user['nickname'] . "  sex = " . $user['sex'];
		
		//insertuser($user);
		//insertmessage($openid, $text, 0, 'text');
		return $user;
	}

	//include "conn.inc.php";
	//将用户消息写入数据库
	function insertuser($user){
		$openId = $user['openid'];
		$nickname = $user["nickname"];
		$sex = $user["sex"];
		$city = $user["city"];
		$province = $user["province"];
		$headimgurl = $user["headimgurl"];


		$dbname = 'pqYfKCBHnqzToWyFgGrp';
		$user = 'c8a2ebc5cf234dc9ae881e103084243b';
		$pwd = '4457528c6e894d2c9faf05f095ca092e';
		$link = mysql_connect("sqld.duapp.com:4050", $user, $pwd, true);
		mysql_select_db($dbname);
		mysql_query("set names utf8");

		
		$sql = "insert into user(openid, nickname, sex, city, province, headimgurl, utime) values('$openId','$nickname','$sex','$city','$province','$headimgurl','". time() ."')";

		mysql_query($sql);
	}

	//参数：openid:用户id，text:你说的和公众号说的 1表示公众号   0表示用户消息
	function insertmessage($openid, $text, $who="0", $mtype="text"){
		include 'conn.inc.php';

		$sql = "insert into message(openid, mess, who, utime, mtype) values('{$openid}','{$text}','{$who}','" . time() . "','{$mtype}')";
		
		mysql_query($sql);

		$sql = "update user set utime='" . time() . "', message = '1' where openid = '{$openid}'";

		mysql_query($sql);
	}


	function my_json_encode($type, $p){  
		if(PHP_VERSION >= '5.4'){  
			$str = json_encode($p, JSON_UNESCAPED_SLASHES|JSON_UNESCAPED_UNICODE);  
		} else {  
			switch($type){  
				case 'text':  
					isset($p['text']['content']) && ($p['text']['content'] = urlencode($p['text']['content']));  
					break;  
			}  
			$str = urldecode(json_encode($p));  
		}  
		return $str;  
	} 


	//客服向用户发送文本
	function sendText($openid, $text){
		global $access_token;
		//$access_token = get_token();
		$url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token={$access_token}";

		$textarr = array("touser"=>$openid, "msgtype"=>"text", "text"=>array("content"=>$text));

		$jsontext = my_json_encode("text", $textarr);

		$result = https_request($url, $jsontext);
	}


	//添加用户列表
	function adduser($openid, $groupid=0, $subscribe=true) {
		include "conn.inc.php";
		//使用全局的access_token
		global $access_token;

		//如果参数subscribe=true就移到分组，否则只在本数地加个用户
		if($subscribe) {					
			//接口是移动组的接口， 如果关注时，用指定组的能数，直接将用户分到指定的组中
			$url = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token={$access_token}";
	
			//参数post json 
			$jsonstr = '{"openid":"'.$openid.'","to_groupid":'.$groupid.'}';

			$result = https_request($url, $jsonstr);
		}
		
		//通过自己写的一个函数getUserInfo()获取用户的详细信息
		$user = getUserInfo($openid);
		$user['groupid'] = $groupid;
		$openId = $user['openid'];
		$nickname = $user['nickname'];
		$sex = $user["sex"];
		$city = $user["city"];
		$country = $user['country'];
		$province = $user["province"];
		$headimgurl = $user["headimgurl"];
		$subscribe_time = $user['subscribe_time'];


		//如果已经是关注过又取消的，则已经有记录了， 有记录了更新关注字段、组和时间即可
		$sql = "select count(*) as num from wuser where openid='{$openid}'";
		$result = mysql_query($sql);
		$count = mysql_fetch_assoc($result);
		//如果根据openid在表中查到有记录，就不要再插入数据
		if($count['num']  > 0) {
			$sql = "update wuser set subscribe='1', groupid='{$groupid}', subscribe_time='{$subscribe_time}' where openid='{$openid}'";
		
			mysql_query($sql);
		}else{
			//第一次关注时加一条记录
			
			$sql = "insert into wuser(openid, groupid, subscribe, nickname, sex, city, country, province, headimgurl, subscribe_time) values('{$openid}','{$groupid}','{$subscribe}','{$nickname}','{$sex}','{$city}','{$country}','{$province}','{$headimgurl}','{$subscribe_time}')";

		
			$result=mysql_query($sql);

		}
		
	}

	function deluser($openid) {
		include "conn.inc.php";
		$sql = "update wuser set subscribe='0' where openid='{$openid}'";
		mysql_query($sql);
	}

	function modgroup($openid, $groupid) {
		include "conn.inc.php";
		$sql = "update wuser set groupid='{$groupid}' where openid='{$openid}'";
		mysql_query($sql);
	}

?>
