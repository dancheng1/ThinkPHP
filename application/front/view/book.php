<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
		<title>选择操作</title>
			<!-- http://fontawesome.dashgame.com/ -->
	
		<meta name="Keywords" content="借阅，伴侣，书屋" />
        <meta name="Description" content="这是一个用来做无微不至，借阅伴侣的网站" />
        <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
		<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">        

		<!-- Mobile Devices Support @begin -->
            <meta content="application/xhtml+xml;charset=UTF-8" http-equiv="Content-Type">
            <meta content="no-cache,must-revalidate" http-equiv="Cache-Control">
            <meta content="no-cache" http-equiv="pragma">
            <meta content="0" http-equiv="expires">
            <meta content="telephone=no, address=no" name="format-detection">
            <meta name="apple-mobile-web-app-capable" content="yes" /> <!-- apple devices fullscreen -->
            <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
        <!-- Mobile Devices Support @end -->

        <style>
        	*{padding:0; margin:0;}
			html, body{ height:100%;background-color:#e1e0de;}
			a {
				text-decoration: none;
				-webkit-tap-highlight-color: rgba(0, 0, 0, 0.35);
				font-size:14px;
			}
			img {
				vertical-align: middle;
			}
			img:not([src*="/"]){display:none;}
			.body{
				max-width:640px;
				margin:auto;
				min-height:100%;
				position:relative;
			}
			.link_tel_kong{
				display:block!important;
				line-height:28px!important;
				margin:10px 10px 0 10px;
				margin-top:10px!important;
				color:#000000!important;
				text-align:center; 
				text-indent:5px;
				border-radius:5px; 
				word-spacing:nowrap; 
				overflow:hidden;
				font-size:22px;
				position:relative;
			}
        	.button{
        		width:50%; 
        		height:100px; 
        		border:0px; 
        		background-color:#008000 ; 
        		border-radius:8px; 
        		Float:center;
        	}
			.button1{
        		width:50%; 
        		height:100px; 
        		border:0px; 
        		background-color:red ; 
        		border-radius:8px; 
        		Float:center;
        	}
        </style>
    </head>
    <body onselectstart="return true;" ondragstart="return false;">
		<section class="body">	
			<?php 
				$openid = $_GET['openid'];
			?>
			<section class="link_tel_kong">
				<strong><?php echo $msg; ?></strong>
			</section>
			<br/><br/><br/>
			<form action="http://skydancheng.duapp.com/index1.php?p=front&c=Book&a=show&book_id=<?php echo $openid; ?>" method="post">
				<section class="link_tel_kong">
					<input style="font-size: 22px; color: #000000;" class="button" type="submit" name="submit1" value="查看书籍详情" />
				</section>
			</form>
			<br/><br/>
			<form action="http://skydancheng.duapp.com/index1.php?p=front&c=Order&a=add&id=<?php echo $openid; ?>" method="post">
				<section class="link_tel_kong">
					<input style="font-size: 22px; color: #000000;" class="button1" type="submit" name="submit2" value="加入借书栏" />
				</section>
			</form>
		</section>
	</body>
</html>
