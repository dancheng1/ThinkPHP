<?php
class HistoryController extends Controller{
	/**
	* 显示历史记录
	*/
	public function showAction(){
		$openid = $_COOKIE['openid'];
		$history = Factory::M('HistoryModel');
		$result = $history -> findByOpenid($openid);
		require CURRENT_VIEW_PATH . 'history.html';
	}
}
