<?php
//会员留言模块
class WordController extends Controller{
    /**
     * 跳转到会员留言
     */
    public function jumpWordAction(){
        include CUR_VIEW_PATH . "a\huiyuanliuyan\index.html";
    }
}