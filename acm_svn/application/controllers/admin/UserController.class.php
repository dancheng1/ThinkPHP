<?php
//用户后台
class UserController extends BaseController{
    /**
     * 进入用户添加
     */
    public function jumpAddAction(){
        include CUR_VIEW_PATH  . "html\user\add\users_add.html";
    }

    /**
     * 进入用户修改
     */
    public function jumpUpdateAction(){
        $id = $_GET['id'];
        $userModel = new UserModel("user");
        $user = $userModel->AfindByUserId($id);
        include CUR_VIEW_PATH  . "html/user/update/users_update.html";
    }

    /**
     * 进入基本信息
     */
    public function jumpEditAction(){
        $id = $_GET['id'];
        $userModel = new UserModel("user");
        $user = $userModel->AfindByUserId($id);
        include CUR_VIEW_PATH . "html/user/edit/users_edit.html";
    }

    /**
     * 进入修改密码列表
     */
    public function jumpUpPsswAction(){
        $userModel = new UserModel("user");
        $users = $userModel->findAllNoLevelLing();
        include CUR_VIEW_PATH . "html/user/uppssw/users_list.html";
    }

    /**
     * 进入个人密码修改
     */
    public function upPsswAction(){
        $id = $_GET['id'];
        $userModel = new UserModel("user");
        $user = $userModel->AfindByUserId($id);
        include CUR_VIEW_PATH . "html/user/uppssw/users_uppssw.html";
    }

    /**
     * 将新的密码写入数据库
     */
    public function writePsswAction(){
        $id = $_POST['id'];
        $username = trim($_POST['acm_username']);
        $password = trim($_POST['acm_password']);
        $userModel = new UserModel("user");
        $userinfo = $userModel->findByUserName($username);
        if(empty($userinfo)){
            $userModel->upPssw($id, $password, $username);
            $this->jumpUpPsswAction();
            exit();
        } else {
            $this->jumpUpPsswAction();
        }
    }

    /**
     * 进入会员备注列表
     */
    public function jumpRemarksAction(){
        $userModel = new UserModel("user");
        $users = $userModel->findAllNoLevelLing();
        include CUR_VIEW_PATH . "html/user/remarks/users_list.html";
    }

    /**
     * 进入会员备注
     */
    public function jumpUpRemarksAction(){
        $id = $_GET['id'];
        $userModel = new UserModel("user");
        $user = $userModel->AfindByUserId($id);
        include CUR_VIEW_PATH . "html/user/remarks/users_remarks.html";
    }

    /**
     * 将备注写入数据库
     */
    public function writeRemarkAction(){
        $id = $_POST['id'];
        $remark = trim($_POST['remark']);
        $userModel = new UserModel("user");
        $userModel->addremark($id, $remark);
        $this->jumpRemarksAction();
    }

    /**
     * 进入会员级别设置列表
     */
    public function jumpupLevelAction(){
        $userModel = new UserModel("user");
        $users = $userModel->findAllNoLevelLing();
        include CUR_VIEW_PATH . "html/user/level/users_uplevel.html";
    }

    /**
     * 进入会员级别设置
     */
    public function jumpupLeAction(){
        $id = $_GET['id'];
        $userModel = new UserModel("user");
        $user = $userModel->AfindByUserId($id);
        include CUR_VIEW_PATH . "html/user/level/users_up.html";
    }

    /**
     * 修改用户级别
     */
    public function upLevelAction(){
        $id = $_POST['id'];
        $level = $_POST['level'];
        $str = '';
        switch ($level){
            case 1:$str = '会员';
                break;
            case 2:$str = '超级会员';
                break;
            case 3:$str = '干事-校队';
                break;
            case 4:$str = '学长-学姐';
                break;
            case 5:$str = '老师';
                break;
        }
        $userModel = new UserModel("user");
        $userModel->upLevel($id, $level, $str);
        $this->jumpupLevelAction();
    }

    /**
     * 删除会员
     */
    public function deleAction(){
        $id = $_GET['id'];
        $userModel = new UserModel("user");
        $userModel->AdeleteById($id);
        $this->AllAction();
    }

    /**
     * 审核删除会员
     */
    public function dele1Action(){
        $id = $_GET['id'];
        $userModel = new UserModel("user");
        $userModel->AdeleteById($id);
        $this->doExamineAction();
    }

    /**
     * 审核
     */
    public function doExamineAction(){
        //获取所有的审核用户
        $userModel = new UserModel("user");
        $users = $userModel->findAllLevelLing();
        include CUR_VIEW_PATH . "html/user/examine/users_doexamine.html";
    }

    /**
     * 通过审核
     */
    public function testExamineAction(){
        $id = $_GET['id'];
        $userModel = new UserModel("user");
        $userModel->updateGoLevel($id);
        $this->doExamineAction();
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
        $data['acm_school'] = trim($_POST['acm_school']);
        $data['acm_college'] = trim($_POST['acm_college']);
        $data['acm_system'] = trim($_POST['acm_system']);
        $data['acm_class'] = trim($_POST['acm_class']);
        $data['acm_hobby'] = trim($_POST['acm_hobby']);
        $data['acm_self'] = trim($_POST['acm_self']);
        $data['id'] = $_POST['id'];

        //2.验证及处理
        $this->helper("input");
        $data = deepslashes($data);
        $data = deepspecialchars($data);

        $userModel = new UserModel("user");
        $userModel->AupdateInformation($data);
        $this->jump('index.php?p=admin&c=user&a=All', '修改成功', 0);
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


        //2.验证及处理
        $this->helper("input");
        $data = deepslashes($data);
        $data = deepspecialchars($data);
        $userModel = new UserModel("user");
        $userinfo = $userModel->findByUserName($data['acm_username']);
        if(empty($userinfo)){
            if($userModel->insert($data)){
                $this->jump("index.php?p=admin&c=user&a=All", "等待审核", 3);
            } else {
                $this->jump("index.php?p=admin&c=user&a=jumpAdd", "添加失败", 1);
            }
        } else {
            $this->jump("index.php?p=admin&c=user&a=jumpAdd", "该用户已存在", 1);
        }
    }

    /**
     * 进入老师
     */
    public function teacherAction(){
        //获取所有的审核用户
        $userModel = new UserModel("user");

        //载入分页类
        $where = "level = 5"; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $userModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 15;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $users = $userModel->getPageLevelUsers($offset,$pagesize,5);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"admin","c"=>"user","a"=>"teacher"));
        $pageinfo = $page->showPage();

        include CUR_VIEW_PATH . "html/user/show/users_teacher.html";
    }

    /**
     * 进入学长学姐
     */
    public function seniorAction(){
        //获取所有的审核用户
        $userModel = new UserModel("user");

        //载入分页类
        $where = "level = 4"; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $userModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 15;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $users = $userModel->getPageLevelUsers($offset,$pagesize,4);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"admin","c"=>"user","a"=>"senior"));
        $pageinfo = $page->showPage();

        include CUR_VIEW_PATH . "html/user/show/users_senior.html";
    }

    /**
     * 进入干事、校队
     */
    public function mohamedAction(){
        //获取所有的审核用户
        $userModel = new UserModel("user");

        //载入分页类
        $where = "level = 3"; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $userModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 15;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $users = $userModel->getPageLevelUsers($offset,$pagesize,3);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"admin","c"=>"user","a"=>"mohame"));
        $pageinfo = $page->showPage();

        include CUR_VIEW_PATH . "html/user/show/users_mohamed.html";
    }

    /**
     * 进入超级会员
     */
    public function superMemberAction(){
        //获取所有的审核用户
        $userModel = new UserModel("user");

        //载入分页类
        $where = "level = 2"; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $userModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 15;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $users = $userModel->getPageLevelUsers($offset,$pagesize,2);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"admin","c"=>"user","a"=>"superMember"));
        $pageinfo = $page->showPage();

        include CUR_VIEW_PATH . "html/user/show/users_super_member.html";
    }

    /**
     * 进入会员
     */
    public function memberAction(){
        //获取所有的审核用户
        $userModel = new UserModel("user");

        //载入分页类
        $where = "level = 1"; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $userModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 15;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $users = $userModel->getPageLevelUsers($offset,$pagesize,1);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"admin","c"=>"user","a"=>"member"));
        $pageinfo = $page->showPage();

        include CUR_VIEW_PATH . "html/user/show/users_member.html";
    }

    /**
     * 进入未审核
     */
    public function ExamineAction(){
        //获取所有的审核用户
        $userModel = new UserModel("user");

        //载入分页类
        $where = "level = 0"; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $userModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 15;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $users = $userModel->getPageLevelUsers($offset,$pagesize,0);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"admin","c"=>"user","a"=>"Examine"));
        $pageinfo = $page->showPage();

        include CUR_VIEW_PATH . "html/user/show/users_examine.html";
    }

    /**
     * 进入全体
     */
    public function AllAction(){
        //获取所有的审核用户
        $userModel = new UserModel("user");

        //载入分页类
        $where = ""; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $userModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 15;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $users = $userModel->getPageUsers($offset,$pagesize);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"admin","c"=>"user","a"=>"All"));
        $pageinfo = $page->showPage();

        include CUR_VIEW_PATH . "html/user/show/users_list.html";
    }
}