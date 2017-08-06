<?php
namespace Admin\Controller;
use Think\Controller;
class EmptyController extends Controller{
    public function _empty(){
        echo '<meta charset="utf-8">';
        echo '控制器的非法操作。。。';
    }
}