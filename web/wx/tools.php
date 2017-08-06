<?php
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

	function my_json_encode($p, $type="text"){  
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

?>
