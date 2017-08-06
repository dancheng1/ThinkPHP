<?php
namespace Admin\Controller;
use Think\Controller;
use Think\Verify;

class LoginController extends Controller{
    public function login(){
        if(IS_POST){
            $obj = new Verify();
            if($obj->check(I('post.captcha', '', 'trim'))){
                $data['mg_name'] = I('post.admin_user');
                $data['mg_pwd'] = I('post.admin_psd', '', mysql_real_escape_string);
                $row = M('manager')->where($data)->find();
                if($row){
                    session('mg_id', $row['mg_id']);
                    $this->redirect('Manager/index');
                } else {
                    $this->error('用户名或密码错误', U('login'), 3);
                }
            } else {
                $this->error('验证码错误', U('login'), 3);
            }
        }
        $this->display();
    }

    public function verifyImg(){
        $config = array(
            'imageW' => 120,
            'imageH' => 30,
            'fontSize' => 15,
            'length' => 4,
            'fontttf' => '4.ttf'
        );
        $obj = new Verify($config);
        $obj->entry();
    }

    public function _empty(){
        echo '<meta charset="utf-8">';
        echo '非法操作。。。。';
    }

    public function test1(){
        echo C('name');
    }
}