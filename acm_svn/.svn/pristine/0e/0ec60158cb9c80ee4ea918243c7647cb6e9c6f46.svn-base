<?php
//个人中心
class UserController extends Controller{
    /**
     * 跳转到登陆
     */
    public function jumpLoginAction(){
        include CUR_VIEW_PATH . "a\gerenzhongxin\userLogin\index.html";
    }

    /**
     * 跳转到加入我们
     */
    public function jumpJoinAction(){

        include CUR_VIEW_PATH . "a\gerenzhongxin\userRegist\index.html";
    }

    /**
     * 信息
     */
    public function jumpMessageAction(){
        $this->jump('index.php', '此功能还没有开发，如果有意愿开发，请联系站长：<a href="index.php">dancheng</a>', 10);
    }

    /**
     * 跳转到博客
     */
    public function jumpBlogAction(){
        $this->jump('index.php', '此功能还没有开发，如果有意愿开发，请联系站长：<a href="index.php">dancheng</a>', 10);
    }

    /**
     * 进入修改页面
     */
    public function jumpUpdateAction(){
        if(!isset($_COOKIE['user'])){
            $this->jump('index.php?p=home&c=user&a=jumpLogin', '你还没登录', 3);
        } else {
            $userModel = new UserModel('user');
            $username = $_COOKIE['user'];
            $userinfo = $userModel->findByUserName($username);
            $data['acm_name'] = $userinfo['acm_name'];
            $data['acm_sex'] = $userinfo['acm_sex'];
            $data['acm_tel'] = $userinfo['acm_tel'];
            $data['acm_qq'] = $userinfo['acm_qq'];
            $data['acm_hobby'] = $userinfo['acm_hobby'];
            $data['acm_self'] = $userinfo['acm_self'];
            include CUR_VIEW_PATH . "a\gerenzhongxin\userUpdate\index.html";
        }
    }

    /**
     * 跳转到个人中心
     */
    public function jumpUserAction(){
        if(!isset($_COOKIE['user'])){
            $this->jump('index.php?p=home&c=user&a=jumpLogin', '你还没登录', 3);
        } else {
            $userModel = new UserModel('user');
            $username = $_COOKIE['user'];
            $userinfo = $userModel->findByUserName($username);
            include CUR_VIEW_PATH . "a\gerenzhongxin\index.html";
        }
    }

    /**
     * 修改验证
     */
    public function testUpdateAction(){
        //1.收集表单数据
        $data['acm_name'] = trim($_POST['acm_name']);
        $data['acm_sex'] = trim($_POST['acm_sex']);
        $data['acm_tel'] = trim($_POST['acm_tel']);
        $data['acm_qq'] = trim($_POST['acm_qq']);
        $data['acm_hobby'] = trim($_POST['acm_hobby']);
        $data['acm_self'] = trim($_POST['acm_self']);
        $data['acm_username'] = $_COOKIE['user'];

        //2.验证及处理
        $this->helper("input");
        $data = deepslashes($data);
        $data = deepspecialchars($data);
        if(strlen($data['acm_qq']) < 4){
            echo <<<STD
            <script> 
                alert('QQ长度不能低于4位');
            </script>
STD;
            include CUR_VIEW_PATH . "a\gerenzhongxin\userUpdate\index.html";
            exit();
        } else if(strlen($data['acm_qq']) > 13){
            echo <<<STD
            <script> 
                alert('QQ不能长于13位');
            </script>
STD;
            include CUR_VIEW_PATH . "a\gerenzhongxin\userUpdate\index.html";
            exit();
        }

        if(strlen($data['acm_name']) <= 2){
            echo <<<STD
            <script> 
                alert('名字长度不能低于2位');
            </script>
STD;
            include CUR_VIEW_PATH . "a\gerenzhongxin\userUpdate\index.html";
            exit();
        } else if(strlen($data['acm_name']) > 20){
            echo <<<STD
            <script> 
                alert('名字不能长于10位');
            </script>
STD;
            include CUR_VIEW_PATH . "a\gerenzhongxin\userUpdate\index.html";
            exit();
        }

        if(strlen($data['acm_tel']) < 5){
            echo <<<STD
            <script> 
                alert('电话长度不能低于5位');
            </script>
STD;
            include CUR_VIEW_PATH . "a\gerenzhongxin\userUpdate\index.html";
            exit();
        } else if(strlen($data['acm_tel']) > 13){
            echo <<<STD
            <script> 
                alert('电话不能长于13位');
            </script>
STD;
            include CUR_VIEW_PATH . "a\gerenzhongxin\userUpdate\index.html";
            exit();
        }

        if(strlen($data['acm_hobby']) > 511){
            echo <<<STD
            <script> 
                alert('兴趣爱好不能过长');
            </script>
STD;
            include CUR_VIEW_PATH . "a\gerenzhongxin\userUpdate\index.html";
            exit();
        }

        if(strlen($data['acm_self']) > 511){
            echo <<<STD
            <script> 
                alert('自我介绍不能过长');
            </script>
STD;
            include CUR_VIEW_PATH . "a\gerenzhongxin\userUpdate\index.html";
            exit();
        }

        $userModel = new UserModel("user");
        $userModel->updateInformation($data);
        $this->jump('index.php?p=home&c=user&a=jumpUser', '修改成功', 2);
    }

    /**
     * 上传头像
     */
    public function resPhotoAction(){
        $this->library("Upload");
        $upload = new Upload();
        if($filename = $upload->up($_FILES['acm_img'])){
            //成功
            $url = 'public/uploads/' . $filename;
            $username = $_COOKIE['user'];
            $userModel = new UserModel('user');
            $userModel->updateImg($username, $url);
            $userinfo = $userModel->findByUserName($username);
            if($userinfo['level'] == 1){
                $userModel->HupdateLevel($username);
            }
            $this->jump('index.php?p=home&c=user&a=jumpUser', '', 0);
        } else {
            //失败
            $this->jump('index.php?p=home&c=user&a=jumpUser', '上传失败', 3);
        }
    }

    /**
     * 登录验证
     */
    public function testLoginAction(){
        session_start();
        //0.验证验证码
        $captcha = trim($_POST['captcha']);
        if (strtolower($captcha) != $_SESSION['captcha']){
            $this->jump('index.php?p=home&c=user&a=jumpLogin',"验证码错误",3);
        }

        //1.收集用户名和密码
        $username = $_POST['username'];
        $password = $_POST['password'];

        //载入负责函数
        $this->helper('input');
        $username = deepslashes($username);
        $password = deepslashes($password);

        //3.调用模型来进行验证，给出提示
        $userModel = new UserModel('user');
        $userinfo = $userModel->checkUser($username, $password);

        if(empty($userinfo)){
            $this->jump('index.php?p=home&c=user&a=jumpLogin', '用户名和密码错误，请重试', 3);
        } else {
            if($userinfo['level'] == 0){
                $this->jump('index.php', '你未通过审核，请联系我们', 3);
            } else {
                //登录成功，保存用户状态,跳到后台主页
                setcookie('user', $userinfo['acm_username'], time() + 1800);
                $this->jump('index.php?p=home&c=index&a=index', '', 0);
            }
        }
    }

    /**
     * 注册验证
     */
    public function testJoinAction(){
        //1.收集表单数据
        $data['acm_username'] = trim($_POST['acm_username']);
        $data['acm_password'] = trim($_POST['acm_password']);
        $data['acm_name'] = trim($_POST['acm_name']);
        $data['acm_sex'] = trim($_POST['acm_sex']);
        $data['acm_tel'] = trim($_POST['acm_tel']);
        $data['acm_qq'] = trim($_POST['acm_qq']);
        $data['acm_school'] = $_POST['acm_school'];
        $data['acm_college'] = $_POST['acm_college'];
        $data['acm_system'] = $_POST['acm_system'];
        $data['acm_class'] = $_POST['acm_class'];
        $data['acm_hobby'] = trim($_POST['acm_hobby']);
        $data['acm_self'] = trim($_POST['acm_self']);
        $data['createtime'] = time();
        $data['acm_password'] = md5($data['acm_password']);
        $data['img_url'] = '';


        //2.验证及处理
        $this->helper("input");
        $data = deepslashes($data);
        $data = deepspecialchars($data);
        if(strlen($data['acm_username']) < 4){
            echo <<<STD
            <script> 
                alert('用户名长度不能低于4位');
            </script>
STD;
            include CUR_VIEW_PATH . "a\gerenzhongxin\userRegist\index.html";
            exit();
        } else if(strlen($data['acm_username']) > 16){
            echo <<<STD
            <script> 
                alert('用户名长度不能长于16位');
            </script>
STD;
            include CUR_VIEW_PATH . "a\gerenzhongxin\userRegist\index.html";
            exit();
        }

        if(strlen($data['acm_qq']) < 4){
            echo <<<STD
            <script> 
                alert('QQ长度不能低于4位');
            </script>
STD;
            include CUR_VIEW_PATH . "a\gerenzhongxin\userRegist\index.html";
            exit();
        } else if(strlen($data['acm_qq']) > 13){
            echo <<<STD
            <script> 
                alert('QQ不能长于13位');
            </script>
STD;
            include CUR_VIEW_PATH . "a\gerenzhongxin\userRegist\index.html";
            exit();
        }

        if(strlen($data['acm_name']) < 2){
            echo <<<STD
            <script> 
                alert('名字长度不能低于2位');
            </script>
STD;
            include CUR_VIEW_PATH . "a\gerenzhongxin\userRegist\index.html";
            exit();
        } else if(strlen($data['acm_name']) > 20){
            echo <<<STD
            <script> 
                alert('名字不能长于10位');
            </script>
STD;
            include CUR_VIEW_PATH . "a\gerenzhongxin\userRegist\index.html";
            exit();
        }

        if(strlen($data['acm_tel']) < 5){
            echo <<<STD
            <script> 
                alert('电话长度不能低于5位');
            </script>
STD;
            include CUR_VIEW_PATH . "a\gerenzhongxin\userRegist\index.html";
            exit();
        } else if(strlen($data['acm_tel']) > 13){
            echo <<<STD
            <script> 
                alert('电话不能长于13位');
            </script>
STD;
            include CUR_VIEW_PATH . "a\gerenzhongxin\userRegist\index.html";
            exit();
        }

        if(strlen($data['acm_hobby']) > 511){
            echo <<<STD
            <script> 
                alert('兴趣爱好不能过长');
            </script>
STD;
            include CUR_VIEW_PATH . "a\gerenzhongxin\userRegist\index.html";
            exit();
        }

        if(strlen($data['acm_self']) > 511){
            echo <<<STD
            <script> 
                alert('自我介绍不能过长');
            </script>
STD;
            include CUR_VIEW_PATH . "a\gerenzhongxin\userRegist\index.html";
            exit();
        }

        $userModel = new UserModel("user");
        $userinfo = $userModel->findByUserName($data['acm_username']);
        if(empty($userinfo)){
            if($userModel->insert($data)){
                $this->jump("index.php", "等待审核", 3);
            } else {
                echo <<<STD
                    <script> 
                        alert('注册失败');
                    </script>
STD;
                include CUR_VIEW_PATH . "a\gerenzhongxin\userRegist\index.html";
            }
        } else {
            echo <<<STD
            <script> 
                alert('用户名已被注册！！！');
            </script>
STD;
            include CUR_VIEW_PATH . "a\gerenzhongxin\userRegist\index.html";
        }
    }
}