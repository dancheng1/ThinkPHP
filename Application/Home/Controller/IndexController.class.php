<?php
namespace Home\Controller;
use Think\Controller;
class IndexController extends Controller {
    public function index(){
        $this->display();
        //$this->display('show');
        //$this->display('Goods/index');
        //$this->display('./Application/Public/test.html');
    }

    public function shows(){
        $this->display();
    }

    public function test1(){
        echo C('DB_TYPE');
        /*$this->assign('score', 88);
        $this->display();*/
    }
}