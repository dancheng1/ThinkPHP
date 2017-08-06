<?php
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
	$jsonmenu = '
		{
			"button": [
				{	
			        "type":"click",
			        "name":"联系我们",
			        "key":"\n你好，如有工作需要请加QQ：########(请注明事项)"
		      	},
				{
					"type": "view", 
					"name": "借阅伴侣",   
					"url": "http://skydancheng.duapp.com/index1.php"
				}, 
				{
					"name": "菜单", 
					"sub_button": [
						{
						    "type": "view", 
						    "name": "完善信息", 
						    "url": "http://skydancheng.duapp.com/index1.php?p=front&c=User&a=txz"
						},
						{
						    "type": "scancode_push", 
						    "name": "用户扫码", 
					        "key": "rselfmenu_0_1", 
					        "sub_button": [ ]
						},
						{
						    "type": "view", 
						    "name": "管理员", 
						    "url": "http://skydancheng.duapp.com/index1.php?p=front&c=User&a=txz"
						}, 
					    {
						    "type": "scancode_push", 
						    "name": "管理员扫码", 
					        "key": "rselfmenu_0_1", 
					        "sub_button": [ ]
					    } 	
					]
				}
			]
		}
	';

	$access_token = get_token();

	$menuurl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token={$access_token}";
	$result = https_request($menuurl, $jsonmenu);
	var_dump($result);


?>
