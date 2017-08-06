<?php
	//页面输出中文 
	header("Content-Type:text/html;charset=utf-8");
	//使用自定义的上传类
	include "fileupload.class.php";
	//包含连接数据库的代码
	include "conn.inc.php";
	//函数库
	include "ufun.inc.php";


	//如果用户提交上传
	if(isset($_POST['dosubmit'])) {
		//创建上传类的对象
		$up = new FileUpload();
		//设置上传的类型
		$up->set("allowtype", array('jpg','jpeg', 'mp3', 'mp4','amr'));
		
		//开始上传
		if($up->upload('res')) {
			//获取上传后的名子
			$filename = $up->getFileName();	
			//获取access_token
			$access_token = get_token();

			//通过这个接口上传到公众号上
			$url = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token={$access_token}&type={$_POST['rtype']}";
			//上传公众号一定要使用绝对路径
			$filepath = dirname(__FILE__)."/uploads/".$filename;
			//形成上传的数据
			$filedata = array("media"=>"@".$filepath);
			//调用公众号接口，上传
			$result = https_request($url, $filedata);
			//将返回信息变成数组
			$data = json_decode($result, true);
			//如上传的是缩略图，处理一下
			if($_POST['rtype']=="thumb") {
				$data['media_id']=$data['thumb_media_id'];
			}

			//将入到本地数据库
			$sql = "insert into media(filename, rtype, media_id, created_at) values('{$filename}','{$data['type']}','{$data['media_id']}','{$data['created_at']}')";
			mysql_query($sql);

			
		}else{
			echo $up->getErrorMsg();
		}
	}




	//根据用户选择设置从数据库查询条件，如果没有选择则返回全部信息
	if(!empty($_GET['type'])) {
		$type="where rtype='{$_GET['type']}'";	
	} else {
		$type="";
	}
	//设置SQL语句，并执行
	$sql = "select * from media {$type} order by created_at desc";
	$result=mysql_query($sql);

	
	echo '<h1>媒体列表:</h1>';
	echo '<p><a href="up.php?type=image">图片</a> | ';
	echo '<a href="up.php?type=voice">语言</a> | ';
	echo '<a href="up.php?type=video">视频</a> | ';
	echo '<a href="up.php?type=thumb">缩略图</a> |';
	echo '<a href="up.php?type=news">图文</a></p>';
	echo '<table border="1" width="80%">';
	echo '<tr>';
	echo '<th>ID</th> <th>文件名</th> <th>类型</th> <th>media_id</th> <th>上传时间</th>';
	echo '</tr>';
	//形成表格
	while($media = mysql_fetch_assoc($result)) {
		echo '<tr>';
		echo '<td>'.$media['id'].'</td>';
		echo '<td>';
		if($media['rtype']=="image" || $media['rtype']=="thumb") {
			echo '<img height="100" src="./uploads/'.$media['filename'].'">';	
		}else{
			echo $media['filename'];
		}
		echo '</td>';
		echo '<td>'.$media['rtype'].'</td>';
		echo '<td>'.$media['media_id'].'</td>';
		echo '<td>'.date("Y-m-d", $media['created_at']).'</td>';
		echo '</tr>';	
	}
	echo '</table>'; 

?>
<br>上传的多媒体文件有格式和大小限制，如下： <br>
<p>
图片（image）: 1M，支持JPG格式  <br>
语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式 <br> 
视频（video）：10MB，支持MP4格式 <br>
缩略图（thumb）：64KB，支持JPG格式 <br>
</p>

<form action="up.php?type=<?php echo $_GET['type'] ?>" method="post" enctype="multipart/form-data">
	上传文件： 
	<input type="file" name="res">
	<select name="rtype">
		<option value="image">图片</option>
		<option value="voice">语音</option>
		<option value="video">视频</option>
		<option value="thumb">缩略图</option>
		
	</select>

	<input type="submit" name="dosubmit" value="上传">

</form>

<a target="_blank" href="upnews.php?num=2">添加图文</a>
