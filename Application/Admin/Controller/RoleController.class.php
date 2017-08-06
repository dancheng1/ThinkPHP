<?php
namespace Admin\Controller;
use Model\RoleModel;
use Think\Controller;
class RoleController extends Controller{
    public function showlist(){
        $list = M('role')->select();
        $this->assign('list', $list);
        $this->display();
    }

    //分配权限的方法
    public function distribute($role_id){
        if($role_id == 0)
            die('参数不正确');
        $role = new RoleModel();
        if(IS_POST){
            $auth_ids = $_POST['auth'];
            if($role->updateRole($auth_ids, $role_id)){
                $this->success('添加成功', U('showlist'), 3);
            } else {
                $this->error('修改失败');
            }
            exit;
        }

        $role_info = $role->find($role_id);   //角色信息找到
        $role_auth_ids = $role_info['role_auth_ids'];   //角色具有的权限
        $role_auth_id_array = explode(',', $role_auth_ids);    //吧权限字符串切割成数组
        $this->assign('role_auth_id_array', $role_auth_id_array);


        $info1 = M('auth')->where("auth_level = 0")->select();
        $info2 = M('auth')->where("auth_level = 1")->select();
        $this->assign('info1', $info1);
        $this->assign('info2', $info2);
        $this->display();
    }
}