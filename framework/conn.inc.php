<?php
	$dbname = 'pqYfKCBHnqzToWyFgGrp';
	$user = 'c8a2ebc5cf234dc9ae881e103084243b';
	$pwd = '4457528c6e894d2c9faf05f095ca092e'; 
	$link = mysql_connect("sqld.duapp.com:4050", $user, $pwd, true);
	mysql_select_db($dbname);
	mysql_query("set names utf8");
?>