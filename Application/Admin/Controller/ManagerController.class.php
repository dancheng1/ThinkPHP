<?php
namespace Admin\Controller;
use Think\Controller;
class ManagerController extends Controller{
    public function index(){
        $this->display();
    }

    public function head(){
        $this->display();
    }

    public function left(){
        $manager = M('Manager')->find(session('mg_id'));  //或得当前管理员
        $role = M("role")->find($manager['mg_role_id']);   //通过角色id获取角色的信息
        $auth_ids = $role['role_auth_ids'];             //角色权限集合

        if($manager['mg_role_id'] == 0){
            $info1 = M('auth')->where("auth_level = 0")->select();
            $info2 = M('auth')->where("auth_level = 1")->select();
        } else {
            $info1 = M('auth')->where("auth_level = 0 and auth_id in ($auth_ids)")->select();
            $info2 = M('auth')->where("auth_level = 1 and auth_id in ($auth_ids)")->select();
        }
        $this->assign('info1', $info1);
        $this->assign('info2', $info2);
        $this->display();
    }

    public function right(){
        $this->display();
    }

    public function  managertest1(){
        echo '这是manager的测试1方法';
    }
}
