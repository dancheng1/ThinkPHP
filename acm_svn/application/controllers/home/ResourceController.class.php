<?php
//资源分享模块
class ResourceController extends  Controller{
    /**
     * 跳转到资源分享的总模块上
     */
    public function junpResourceAction(){
        $resourceModel = new ResourceModel('resource_type');

        $where = ""; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $resourceModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 6;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $resources = $resourceModel->findAll($offset,$pagesize);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"home","c"=>"resource","a"=>"junpResource"));
        $pageinfo = $page->showPage();
        include CUR_VIEW_PATH . "a\kefuanli\index.html";
    }

    /**
     * 跳转到视频资源上
     */
    public function jumpVideoAction(){
        $resourceModel = new ResourceModel('resource_type');

        $where = "parent = 1"; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $resourceModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 6;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $resources = $resourceModel->findVideo($offset,$pagesize);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"home","c"=>"resource","a"=>"junpResource"));
        $pageinfo = $page->showPage();
        include CUR_VIEW_PATH . "a\kefuanli\wangzhansheji\index.html";
    }

    /**
     * 跳转到笔记上
     */
    public function jumpNodesAction(){
        $resourceModel = new ResourceModel('resource_type');

        $where = "parent = 2"; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $resourceModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 6;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $resources = $resourceModel->findNode($offset,$pagesize);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"home","c"=>"resource","a"=>"junpResource"));
        $pageinfo = $page->showPage();
        include CUR_VIEW_PATH . "a\kefuanli\shoujiyingyong\index.html";
    }

    /**
     * 跳转到书籍推荐上
     */
    public function jumpBooksAction(){
        $resourceModel = new ResourceModel('resource_type');

        $where = "parent = 3"; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $resourceModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 6;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $resources = $resourceModel->findBook($offset,$pagesize);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"home","c"=>"resource","a"=>"junpResource"));
        $pageinfo = $page->showPage();
        include CUR_VIEW_PATH . "a\kefuanli\pingmiansheji\index.html";
    }

    /**
     * 按分类跳到资源操作上
     */
    public function jumpByTypeAction(){
        $id = $_GET['id'];
        $resourceModel = new ResourceModel('resource');
        //$resources = $resourceModel->findByTypeId($id);

        $where = "parent_id = " . $id; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $resourceModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 4;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $resources = $resourceModel->findByTypeId($id,$offset,$pagesize);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"home","c"=>"resource","a"=>"jumpByType","id"=>"$id"));
        $pageinfo = $page->showPage();
        include CUR_VIEW_PATH . "a/kefuanli/index_list.html";
    }

    /**
     * 跳到资源详情上
     */
    public function jumpEditAction(){
        $id = $_GET['id'];
        $resourceModel = new ResourceModel('resource');
        $resource = $resourceModel->findById($id);
        $num = $resource['visit'];
        $num++;
        $resourceModel->updateVisit($id, $num);
        include CUR_VIEW_PATH . "a/kefuanli/edit.html";
    }

    /**
     * 获取密码
     */
    public function jumpGetPassAction(){
        $id = $_GET['id'];
        $resourceModel = new ResourceModel('resource');
        $resource = $resourceModel->findById($id);
        if(!isset($_COOKIE['user'])){
            $this->jump('index.php?p=home&c=user&a=jumpLogin', '你还没登录', 2);
        } else {
            $userModel = new UserModel('user');
            $username = $_COOKIE['user'];
            $userinfo = $userModel->findByUserName($username);
            if($userinfo['level'] >= $resource['level']){
                $this->jump('index.php?p=home&c=resource&a=jumpEdit&id=' . $id, '下载链接：' . $resource['link'] . '<br/>下载密码：' . $resource['password'] . '<br/><a href="index.php?p=home&c=resource&a=jumpEdit&id=' . $id . '"><input type="button" value="点击返回" /></a>', 20);
            } else {
                $this->jump('index.php?p=home&c=resource&a=jumpEdit&id=' . $id, '你的权限不够，请找一些' . $userinfo['acm_position'] . '级别或' . $userinfo['acm_position'] . '级别以下的资源下载。如有需要请联系我们。', 3);
            }
        }
    }
}