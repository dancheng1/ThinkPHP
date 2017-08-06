<?php
//前台首页控制器
class IndexController extends Controller{
    /**
     * 显示首页
     */
    public function indexAction(){

        include CUR_VIEW_PATH . "index.html";
    }

    /**
     * 进入宣传视频
     */
    public function intoVideoAction(){
        include CUR_VIEW_PATH . "video1.html";
    }

    /**
     * 跳转关于我们
     */
    public function jumpOurAction(){
        $userModel = new UserModel('user');
        $userNum = $userModel->findAllNum();
        $mohamedNum = $userModel->findMohamedNum();
        $teacherNum = $userModel->findTeacherNum();
        include CUR_VIEW_PATH . "a\guanyuwomen\index.html";
    }

    /**
     * 跳转联系我们
     */
    public function jumpLinkAction(){

        include CUR_VIEW_PATH . "a\lianxiwomen\index.html";
    }
}