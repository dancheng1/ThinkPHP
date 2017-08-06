<?php
//后台活动
class ActivityController extends BaseController{
    /**
     * 删除功能
     */
    public function deleAction(){
        $id = $_GET['id'];
        $activityModel = new ActivityModel("activity");
        $activityModel->delete($id);
        $this->jump("index.php?p=admin&c=activity&a=findAll", "删除成功", 0);
    }

    /**
     * 进入修改界面
     */
    public function jumpUpdateAction(){
        $id = $_GET['id'];
        $activityModel = new ActivityModel("activity");
        $activity = $activityModel->findById($id);
        include CUR_VIEW_PATH . "html/activity/update/activity_update.html";
    }

    /**
     * 修改
     */
    public function UpdateAction(){
        //1.收集表单数据
        $data['title'] = trim($_POST['title']);
        $data['creator'] = trim($_POST['creator']);
        $data['utime'] = trim($_POST['utime']);
        $data['address'] = trim($_POST['address']);
        $data['contact'] = trim($_POST['contact']);
        $data['abstract'] = trim($_POST['abstract']);
        $data['content'] = trim($_POST['content']);
        $data['parent'] = $_POST['parent'];
        $data['id'] = $_POST['id'];

        //2.验证及处理
        $this->helper("input");
        $data = deepslashes($data);
        $data = deepspecialchars($data);

        $activityModel = new ActivityModel("activity");
        $activityModel->updateActivity($data);

        $this->jump("index.php?p=admin&c=activity&a=findAll", "修改成功", 0);
    }

    /**
     * 进入添加界面
     */
    public function jumpAddAction(){
        include CUR_VIEW_PATH . "html/activity/add/activity_add.html";
    }

    /**
     * 添加
     */
    public function AddAction(){
        //1.收集表单数据
        $data['title'] = trim($_POST['title']);
        $data['creator'] = trim($_POST['creator']);
        $data['utime'] = trim($_POST['utime']);
        $data['address'] = trim($_POST['address']);
        $data['contact'] = trim($_POST['contact']);
        $data['abstract'] = trim($_POST['abstract']);
        $data['content'] = trim($_POST['content']);
        $data['parent'] = $_POST['parent'];
        $data['createtime'] = time();

        //2.验证及处理
        $this->helper("input");
        $data = deepslashes($data);
        $data = deepspecialchars($data);

        $activityModel = new ActivityModel("activity");
        if($activityModel->insert($data)){
            $this->jump("index.php?p=admin&c=activity&a=findAll", "添加成功", 2);
        } else {
            $this->jump("index.php?p=admin&c=activity&a=findAll", "添加失败", 2);
        }
    }

    /**
     * 进入详情
     */
    public function jumpEditAction(){
        $id = $_GET['id'];
        $activityModel = new ActivityModel("activity");
        $activity = $activityModel->findById($id);
        include CUR_VIEW_PATH . "html/activity/edit/activity_edit.html";
    }

    /**
     * 进入全部活动列表
     */
    public function findAllAction(){
        //获取所有的审核用户
        $activityModel = new ActivityModel("activity");

        //载入分页类
        $where = ""; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $activityModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 5;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $activitys = $activityModel->findAll($offset,$pagesize);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"admin","c"=>"activity","a"=>"findAll"));
        $pageinfo = $page->showPage();

        include CUR_VIEW_PATH . "html/activity/show/activity_list.html";
    }

    /**
     * 进入比赛列表
     */
    public function findBiSaiAction(){
        //获取所有的审核用户
        $activityModel = new ActivityModel("activity");

        //载入分页类
        $where = "parent = 1"; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $activityModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 5;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $activitys = $activityModel->findMatch($offset,$pagesize);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"admin","c"=>"activity","a"=>"findBiSai"));
        $pageinfo = $page->showPage();
        include CUR_VIEW_PATH . "html/activity/show/activity_bisai_list.html";
    }

    /**
     * 进入培训列表
     */
    public function findPeiXunAction(){
        //获取所有的审核用户
        $activityModel = new ActivityModel("activity");

        //载入分页类
        $where = "parent = 2"; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $activityModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 5;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $activitys = $activityModel->findTrain($offset,$pagesize);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"admin","c"=>"activity","a"=>"findPeiXun"));
        $pageinfo = $page->showPage();
        include CUR_VIEW_PATH . "html/activity/show/activity_peixun_list.html";
    }
}