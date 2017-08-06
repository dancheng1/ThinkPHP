<?php
	include 'tools.php';
	//获取ticket
	function get_ticket($text){
		$access_token = get_token();
		$url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token={$access_token}";

		$jsonstr = '{"action_name": "QR_LIMIT_SCENE", "action_info": {"scene": {"scene_id": '. $text .'}}}';

		$result = https_request($url, $jsonstr);

		$arr = json_decode($result, true);

		return $arr;
	}

	//下载图片
	function downImage($url){
		$curl = curl_init($url);
		curl_setopt($curl, CURLOPT_HEADER, 0);
		curl_setopt($curl, CURLOPT_NOBODY, 0);
		curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false);
		curl_setopt($curl, CURLOPT_SSL_VERIFYHOST, false);
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
		$output = curl_exec($curl);
		curl_close($curl);
		return $output;
	}
	
	//生成二位码
	function get_image($ticket){
		$url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=". urlencode($ticket);
		$imageInfo = downImage($url);
		$filename = "140.jpg";
		file_put_contents($filename, $imageInfo);
		return $filename;
	}




	$arr = get_ticket(1);
	//拿到票
	$ticket = $arr['ticket'];
	$filename = get_image($ticket);

	echo '<img src="'. $filename .'"/>';
?>