<?php
define("TOKEN", "dancheng");
$wechatObj = new wechatCallbackapiTest();
$wechatObj->valid();
require 'web/wx/curl.php';

class wechatCallbackapiTest{
	public function valid(){
        $echoStr = $_GET["echostr"];
        if($this->checkSignature()){
			$result = $this->responseMsg();
        } else {
			echo "das"; 
		}
    }

	private function checkSignature(){
        $signature = $_GET["signature"];
        $timestamp = $_GET["timestamp"];
        $nonce = $_GET["nonce"];	
        		
		$token = TOKEN;
		$tmpArr = array($token, $timestamp, $nonce);
		sort($tmpArr);
		$tmpStr = implode( $tmpArr );
		$tmpStr = sha1( $tmpStr );
		
		if( $tmpStr == $signature ){
			return true;
		}else{
			return false;
		}
	}

    public function responseMsg(){
		$postStr = $GLOBALS["HTTP_RAW_POST_DATA"];

		if (!empty($postStr)){
                
              	$postObj = simplexml_load_string($postStr, 'SimpleXMLElement', LIBXML_NOCDATA);
				
				$RX_TYPE = trim($postObj -> MsgType);
				switch($RX_TYPE){
					case 'event':
						$result = $this -> receiveEvent($postObj);
						break;
					case 'text':
						$result = $this -> receiveText($postObj);
						break;
					case 'image':
						$result = $this -> receiveImage($postObj);
						break;
					case 'voice':
						$result = $this -> receiveVoice($postObj);
						break;
					case 'video':
						$result = $this -> receiveVideo($postObj);
						break;
					case 'location':
						$result = $this -> receiveLocation($postObj);
						break;
					case 'link':
						$result = $this -> receiveLink($postObj);
						break;
					default:
						$result = "unkone msg type" . $RX_TYPE;
						break;
				}
				echo $result;
        }else {
        	echo "";
        	exit;
        }
    }

	//接收事件
	private function receiveEvent($object){
		$content = "";
		switch($object -> Event){
			case "subscribe":
				$content = "欢迎关注借阅伴侣的测试账号！\n请设置通行证！\n\n注：通行证设置方式:\n“txz：通行证号”";
				include 'framework/UserModel.php';
				$user = getUserInfo($object -> FromUserName);
				insert($user);
				break;
			case "unsubscribe":
				$content = "取消关注";
				break;
			case "SCAN":
				$content .= "\n扫描场景" . $object -> EventKey;
				break;
			case "CLICK":
				switch($object -> EventKey){
					case "company":
						$content = array();
						$content[] = array("Title" => "小规模低性能低流量网站设计原则！");
						break;
					default:
						$content = "点击菜单" . $object -> EventKey;
						break;
				}
				break;
			case "LOCATION":
				$content = "上传位置：纬度 " . $object -> Latitude . "； 精度" . $object -> Longitude;
				break;
			case "VIEW":
				$content = "跳转链接 " . $object -> EventKey;
				break;
			case "MASSSENDJOBFINISH":
				$content = "消息ID：" . $object -> MsgID . "，结果：" . $object -> Status;
				break;
			default:
				$content = "receive a new event:" . $object -> Event;
				break;
		}
		if(is_array($content)){
			if(isset($content[0])){
				$result = $this -> transmitNews($object, $content);
			} else if(isset($content['MusicUrl'])){
				$result = $this -> transmitMusic($object, $content);
			}
		} else {
			$result = $this -> transmitText($object, $content);
		}
		return $result;
	}

	
	//接收图片消息
	private function receiveImage($object){
		$content = array("MediaId"=>$object->MediaId);
		$result = $this -> transmitImage($object, $content);
		return $result;
	}


	//接收位置消息
	private function receiveLocation($object){
		$content = "你发送的是位置，纬度为：" . $object -> Location_X . "; 经度为：" . $object -> Location_Y;
		$result = $this -> transmitText($object, $content);
		return $result;
	}


	//接收语音消息
	private function receiveVoice($object){
		if(isset($object -> Recognition) && !empty($object -> Recognition)){
			$text = $object -> Recognition;
			$content = "你刚才说的是：" . $text;
			$result = $this -> transmitText($object, $content);
		} else {
			$content = array("MediaId"=>$object -> MediaId);
			$result = $this -> transmitVoice($object, $content);
		}
		return $result;
	}


	//接收视频消息
	private function receiveVideo($object){
		$content = array("MediaId"=>$object -> MediaId, "Title"=>"asd", "Description"=>"这是视频");
		$result = $this -> transmitVideo($object, $content);
		return $result;
	}


	//接收链接消息
	private function receiveLink($object){
		$content = "你发送的链接，标题是：" . $object -> Title . "； 内容是：" . $object -> Description . "； 消息链接：" . $object -> Url;
		$result = $this -> transmitText($object, $content);
		return $result;
	}



	//回复图片信息
	private function transmitImage($object, $imageArray){
		$itemTpl = "
			<Image>
				<MediaId><![CDATA[%s]]></MediaId>
			</Image>
		";
	
		$item_str = sprintf($itemTpl, $imageArray['MediaId']);

		$xmlTpl = "
			<xml>
				<ToUserName><![CDATA[%s]]></ToUserName>
				<FromUserName><![CDATA[%s]]></FromUserName>
				<CreateTime>%s</CreateTime>
				<MsgType><![CDATA[image]]></MsgType>
				%s
			</xml>
		";

		$result = sprintf($xmlTpl, $object -> FromUserName, $object -> ToUserName, time(), $item_str);
		return $result;
	}


	//回复语音消息
	private function transmitVoice($object, $voiceArray){
		$itemTpl = "
			<Voice>
				<MediaId><![CDATA[%s]]></MediaId>
			</Voice>
		";

		$item_str = sprintf($itemTpl, $voiceArray['MediaId']);

		$xmlTpl = "
			<xml>
				<ToUserName><![CDATA[%s]]></ToUserName>
				<FromUserName><![CDATA[%s]]></FromUserName>
				<CreateTime>%s</CreateTime>
				<MsgType><![CDATA[voice]]></MsgType>
				%s
			</xml>
		";

		$result = sprintf($xmlTpl, $object -> FromUserName, $object -> ToUserName, time(), $item_str);
		return $result;
	}


	//回复视频消息
	private function transmitVideo($object, $videoArray){
		$itemTpl = "
			<Video>
				<MediaId><![CDATA[%s]]></MediaId>
				<Title><![CDATA[%s]]></Title>
				<Description><![CDATA[%s]]></Description>
			</Video> 
		"; 

		$item_str = sprintf($itemTpl, $videoArray['MediaId'], $videoArray['Title'], $videoArray['Description']);

		$xmlTpl = "
			<xml>
				<ToUserName><![CDATA[%s]]></ToUserName>
				<FromUserName><![CDATA[%s]]></FromUserName>
				<CreateTime>%s</CreateTime>
				<MsgType><![CDATA[video]]></MsgType>
				%s
			</xml>
		";

		$result = sprintf($xmlTpl, $object -> FromUserName, $object -> ToUserName, time(), $item_str);
		return $result;
	}

	private function receiveText($object){
		include 'web/wx/sql.php';
		//接收内容，放到变量中
		$keyword = trim($object -> Content);

		$pdtianq = getcity($keyword);
		if(isset($pdtianq)){
			$tqtq = getWeatherInfo($pdtianq);
			$content = array();
			$content = array_merge($content, $tqtq);
		} else if(substr($keyword, 0, 3) == 'txz'){
			$str = substr($keyword, 4); 
			include 'framework/UserModel.php';
			if(exist($str)){
				$content = "该通行令已存在，请重新输入通行令。\n\n注：格式为：“txz：通行证号”";
			} else {
				update($str, $object -> FromUserName);
				$content = "通行令设置成功！\n完善个人信息，便可以自由借阅了！！！";
			} 
			$result = $this -> transmitText($object, $content);
		} else if(strstr($keyword, "1")){
			$content = "亲，您关注了我们，就已经是借阅伴侣的一员了！如果您想要进行其他操作，可以完善信息。\n注意：完善信息需要通行证，若不知通行证或不会添加通行证，请按 2 ";
		} else if(strstr($keyword, "2")){
			$content = "设置通行证的格式：“txz：通行证号”";
		} else if(strstr($keyword, "3")){
			
		} else {
			$content = "欢迎来到借阅伴侣！\n\n";
			$content .= "怎么注册----------------请按1\n";
			$content .= "怎么设置通行证-----请按2\n";
		}

		if(is_array($content)){
			if(isset($content[0]['PicUrl'])){
				$result = $this -> transmitNews($object, $content);
			} else if(isset($content['MusicUrl'])){
				$result = $this -> transmitMusic($object, $content);
			}
		} else {                       
			$result = $this -> transmitText($object, $content);
		}	
		return $result;
	}
		

	//回复文本音乐消息
	function transmitMusic($object, $music){
		$xmlTpl = "
			<xml>
				<ToUserName><![CDATA[%s]]></ToUserName>
				<FromUserName><![CDATA[%s]]></FromUserName>
				<CreateTime>%s</CreateTime>
				<MsgType><![CDATA[music]]></MsgType>
				<Music>
					<Title><![CDATA[%s]]></Title>
					<Description><![CDATA[%s]]></Description>
					<MusicUrl><![CDATA[%s]]></MusicUrl>
					<HQMusicUrl><![CDATA[$s]]></HQMusicUrl>
				</Music>
			</xml>
		";

		
		return sprintf($xmlTpl, $object->FromUserName, $object->ToUserName, time(), $music['Title'], $music['Description'], $music['MusicUrl'], $music['HQMusicUrl']);
	}


	/*
	回复文本信息
	*/
	function transmitText($object, $content){
		$xmlTpl = "
			<xml>
				<ToUserName><![CDATA[%s]]></ToUserName>
				<FromUserName><![CDATA[%s]]></FromUserName>
				<CreateTime>%s</CreateTime>
				<MsgType><![CDATA[text]]></MsgType>
				<Content><![CDATA[%s]]></Content>
			</xml>
		";
		$result = sprintf($xmlTpl, $object->FromUserName, $object->ToUserName, time(), $content);
		return $result;
	}
	/*
	回复单图文或多图文
	*/
	function transmitNews($object, $newsArray){
		$itemTpl = "
			<item>
				<Title><![CDATA[%s]]></Title> 
				<Description><![CDATA[%s]]></Description>
				<PicUrl><![CDATA[%s]]></PicUrl>
				<Url><![CDATA[%s]]></Url>
			</item>
		";
		$item_str = "";
		foreach($newsArray as $item){
			$item_str .= sprintf($itemTpl, $item['Title'], $item['Description'], $item['PicUrl'], $item['Url']);
		}
		
		$xmlTpl = "
			<xml>
				<ToUserName><![CDATA[%s]]></ToUserName>
				<FromUserName><![CDATA[%s]]></FromUserName>
				<CreateTime>%s</CreateTime>
				<MsgType><![CDATA[news]]></MsgType>
				<ArticleCount>%s</ArticleCount>
				<Articles>
					%s
				</Articles>
			</xml>
		";
		
		return sprintf($xmlTpl, $object->FromUserName, $object->ToUserName, time(), count($newsArray), $item_str);
	}
 	
}
?>