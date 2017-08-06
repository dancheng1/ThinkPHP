<?php
//后台首页控制器
class IndexController extends Controller{
    public function testAction(){
        include CUR_VIEW_PATH . "test.html";
    }

    public function delAction(){
        $file = 'public/20170730/20170730073242597d1b1aea68e.jpg';
        $result = @unlink ($file);
        if ($result == false) {
            echo '蚊子赶走了';
        } else {
            echo '无法赶走';
        }
    }

    public function resTestAction(){
        echo '<meta charset="utf-8">';
        $this->library("Upload");
        $upload = new Upload();
        if($filename = $upload->up($_FILES['goods_img'])){
            //成功
            echo '<img src="public/uploads/' . $filename . '">';
            echo 'public/uploads/' . $filename;
        } else {
            //失败
            echo '失败';
        }
    }

	public function indexAction(){
		include CUR_VIEW_PATH . "index.html";
	}

	public function topAction(){
		include CUR_VIEW_PATH . "top.html";
	}

	public function menuAction(){
		include CUR_VIEW_PATH . "menu.html";
	}

	public function dragAction(){ 
		include CUR_VIEW_PATH . "drag.html";
	}

	public function mainAction(){
		include CUR_VIEW_PATH . "main.html";

		/*//载入辅助函数
		$this->helper("input");
		f1();

		//实例化admin模型
		$adminModel = new AdminModel("admin");
		$admins = $adminModel->test();
		echo "<pre>";
		var_dump($admins);
		echo "</pre>";*/
		//echo 'sss';
	}
}