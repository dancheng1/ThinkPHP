<?php
	$arr = array("name"=>"skydancheng", "age"=>20, "sex"=>"nan");

	//数组转json
	//$jsonstr = json_encode($arr);
	$jsonstr = '
		{
			"button": [
			   {
				    "name": "扫码", 
				    "sub_button": [
						{
							"type": "scancode_waitmsg", 
							"name": "扫码带提示", 
							"key": "rselfmenu_0_0", 
							"sub_button": [ ]
						}, 
						{
							"type": "scancode_push", 
							"name": "扫码推事件", 
							"key": "rselfmenu_0_1", 
							"sub_button": [ ]
						}
					]
				}, 
				{
					"type": "click", 
					"name": "今日歌曲", 
					"key": "V1001_TODAY_MUSIC"
				}, 
				{
					"name": "菜单", 
					"sub_button": [
						{
							"type": "view", 
							"name": "搜索", 
							"url": "http://www.soso.com/"
						}, 
						{
							"type": "view", 
							"name": "视频", 
							"url": "http://v.qq.com/"
						}, 
						{
							"type": "click", 
							"name": "赞一下我们", 
							"key": "V1001_GOOD"
						}, 
						{
							"type": "scancode_waitmsg", 
							"name": "扫码带提示", 
							"key": "rselfmenu_0_0", 
							"sub_button": [ ]
						}
					]
				}
			]
		}
	';
	echo $jsonstr;
	
	//json转数组
	echo "<br/><hr/>";
	echo "<pre>";
	$arr_1 = json_decode($jsonstr, true);
	print_r($arr_1);
	echo "</pre>";

	//json转对象
	echo "<br/><hr/>";
	echo "<pre>";
	$arr_2 = json_decode($jsonstr);
	print_r($arr_2);
	echo "</pre>";

	echo my_json_encode("text", $arr_1);

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




?>
