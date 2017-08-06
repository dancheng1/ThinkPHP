<?php
//活动广场模块
class ActivityController extends Controller{
    /**
     * 跳转到活动广场
     */
    public function jumpActivityAction(){
        $activityModel = new ActivityModel('activity');
        //$activitys = $activityModel->findAll();

        $where = ""; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $activityModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 3;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $activitys = $activityModel->findAll($offset,$pagesize);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"home","c"=>"activity","a"=>"jumpActivity"));
        $pageinfo = $page->showPage();

        //---以上是分页
        $zuiXin = $activityModel->findZuiXin();
        $reMen = $activityModel->findReMen();

        include CUR_VIEW_PATH . "a\xinwenzhongxin\index.html";
    }

    /**
     * 跳到比赛活动
     */
    public function jumpMatchAction(){
        $activityModel = new ActivityModel('activity');
        //$activitys = $activityModel->findAll();

        $where = "parent = 1"; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $activityModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 3;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $activitys = $activityModel->findMatch($offset,$pagesize);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"home","c"=>"activity","a"=>"jumpMatch"));
        $pageinfo = $page->showPage();

        //---以上是分页
        $zuiXin = $activityModel->findZuiXin();
        $reMen = $activityModel->findReMen();
        include CUR_VIEW_PATH . "a\xinwenzhongxin\gongsixinwen\index.html";
    }

    /**
     * 跳到培训活动
     */
    public function jumpTrainAction(){
        $activityModel = new ActivityModel('activity');
        //$activitys = $activityModel->findAll();

        $where = "parent = 2"; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $activityModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 3;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $activitys = $activityModel->findTrain($offset,$pagesize);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"home","c"=>"activity","a"=>"jumpTrain"));
        $pageinfo = $page->showPage();

        //---以上是分页
        $zuiXin = $activityModel->findZuiXin();
        $reMen = $activityModel->findReMen();
        include CUR_VIEW_PATH . "a\xinwenzhongxin\xingyexinwen\index.html";
    }

    /**
     * 跳到最新动态
     */
    public function jumpSituationAction(){
        $activityModel = new ActivityModel('activity');
        //$activitys = $activityModel->findAll();

        $where = ""; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $activityModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 3;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $activitys = $activityModel->findAll($offset,$pagesize);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"home","c"=>"activity","a"=>"jumpSituation"));
        $pageinfo = $page->showPage();

        //---以上是分页
        $zuiXin = $activityModel->findZuiXin();
        $reMen = $activityModel->findReMen();

        include CUR_VIEW_PATH . "a\xinwenzhongxin\zuixindongtai\index.html";
    }

    /**
     * 跳到活动详情
     */
    public function jumpEditActivityAction(){
        $id = $_GET['id'];
        $activityModel = new ActivityModel('activity');
        $activity = $activityModel->findById($id);
        $zuiXin = $activityModel->findZuiXin();
        $reMen = $activityModel->findReMen();
        include CUR_VIEW_PATH . "a/xinwenzhongxin/edit.html";
    }
}