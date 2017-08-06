<?php
namespace Admin\Controller;
use Think\Controller;
class AuthorityController extends Controller{
    public function showlist(){
        $list = M('auth')->select();
        $this->assign('list', $list);
        $this->display();
    }

    public function updateAuth($auth_id){
        $model = M('auth');
        $parent_auth = $model->where('auth_level = 0')->select();
        $this->assign('parent_auth', $parent_auth);
        $this->display();
    }
}