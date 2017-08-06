<?php
//资源分享后台管理
class ResourceController extends BaseController{
    public function showVideoAction(){
        $resTypeModel = new ResourceModel('resource_type');
        $resourceModel = new ResourceModel('resource');

        $parent_parent = isset($_GET['parent_parent']) ? $_GET['parent_parent'] : 1;
        if(isset($_POST['soso'])){
            if($_POST['field'] == 'parent_id'){
                $typeInfo = $resTypeModel->AfindTypeByName(trim($_POST['soso']));
                if(isset($typeInfo)){
                    $soso = $typeInfo['id'];
                } else {
                    $soso = 0;
                }
            } else {
                $soso = $_POST['soso'];
            }
            $where = "parent_parent = " . $parent_parent . " and " . $_POST['field'] . " = '". $soso . "'"; //查询条件
        } else {
            $where = "parent_parent = " . $parent_parent; //查询条件
        }
        $this->library("Page");
        //获取user总的记录数
        $total = $resourceModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 15;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $resources = $resourceModel->AfindByTypeId($where,$offset,$pagesize);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"admin","c"=>"resource","a"=>"showVideo"));
        $pageinfo = $page->showPage();
        include CUR_VIEW_PATH . "html/resource/resource/video/video_list.html";
    }

    /**
     * 进入添加资源页面
     */
    public function jumpAddresAction(){
        $parent_parent = $_GET['parent_parent'];
        $resTypeModel = new ResourceModel('resource_type');
        $types = $resTypeModel->AfindTypeByParentId($parent_parent);
        include CUR_VIEW_PATH . "html/resource/resource/add/res_add.html";
    }

    /**
     * 进入修改图片界面
     */
    public function jumpUpdateTupianAction(){
        $id = $_GET['id'];
        $parent_parent = $_GET['parent_parent'];
        $resourceModel = new ResourceModel('resource');
        $resInfo = $resourceModel->findById($id);
        include CUR_VIEW_PATH . "html/resource/resource/update/res_updatetupian.html";
    }

    /**
     * 删除资源
     */
    public function deleteResAction(){
        $id = $_GET['id'];
        $parent_parent = $_GET['parent_parent'];
        $resourceModel = new ResourceModel('resource');
        $resourceModel->deleteByResId($id);
        $this->jump("index.php?p=admin&c=resource&a=showVideo&parent_parent=" . $parent_parent, "修改成功", 0);
    }

    /**
     * 修改图片
     */
    public function updateTupianAction(){
        $id = $_POST['id'];
        $parent_parent = $_POST['parent_parent'];

        $this->library("Upload");
        $upload = new Upload();
        if(isset($_FILES['img_first_url'])) {
            if ($filename = $upload->up($_FILES['img_first_url'])) {
                //成功
                $url = 'public/uploads/' . $filename;
                $first = $url;
            } else {
                //失败
                //$data['img_first_url'] = '';
            }
        }

        if(isset($_FILES['img_second_url'])) {
            if ($filename = $upload->up($_FILES['img_second_url'])) {
                //成功
                $url = 'public/uploads/' . $filename;
                $second = $url;
            } else {
                //失败
                //$data['img_first_url'] = '';
            }
        }

        if(isset($_FILES['img_third_url'])) {
            if ($filename = $upload->up($_FILES['img_third_url'])) {
                //成功
                $url = 'public/uploads/' . $filename;
                $third = $url;
            } else {
                //失败
                //$data['img_first_url'] = '';
            }
        }

        $set = "";
        $flag = 0;
        if(isset($first)){
            $set .= "img_first_url = '" . $first . "'";
            $flag = 1;
        }
        if(isset($second)){
            if($flag == 1){
                $set .= ", img_second_url = '" . $second . "'";
            } else {
                $set .= "img_second_url = '" . $second . "'";
                $flag = 1;
            }
        }
        if(isset($third)){
            if($flag == 1){
                $set .= ", img_third_url = '" . $third . "'";
            } else {
                $set .= "img_third_url = '" . $third . "'";
            }
        }
        $resourceModel = new ResourceModel('resource');
        $resourceModel->updateResTp($id, $set);
        $this->jump("index.php?p=admin&c=resource&a=showVideo&parent_parent=" . $parent_parent, "修改成功", 3);
    }

    /**
     * 进入修改页面
     */
    public function jumpUpdateAction(){
        $id = $_GET['id'];
        $parent_parent = $_GET['parent_parent'];
        $resourceModel = new ResourceModel('resource');
        $resTypeModel = new ResourceModel('resource_type');
        $resInfo = $resourceModel->findById($id);
        $types = $resTypeModel->AfindTypeByParentId($parent_parent);
        include CUR_VIEW_PATH . "html/resource/resource/update/res_update.html";
    }

    /**
     * 修改
     */
    public function updateAction(){
        //1.收集表单数据
        $data['name'] = trim($_POST['name']);
        $data['creator'] = trim($_POST['creator']);
        $data['link'] = trim($_POST['link']);
        $data['password'] = trim($_POST['password']);
        $data['abstract'] = trim($_POST['abstract']);
        $data['content'] = trim($_POST['content']);
        $data['parent_id'] = $_POST['parent_id'];
        $data['level'] = $_POST['level'];
        $data['id'] = $_POST['id'];
        $data['parent_parent'] = $_POST['parent_parent'];

        //2.验证及处理
        $this->helper("input");
        $data = deepslashes($data);
        $data = deepspecialchars($data);

        $resourceModel = new ResourceModel('resource');
        if($resourceModel->updateRes($data)){
            $this->jump("index.php?p=admin&c=resource&a=showVideo&parent_parent=" . $data['parent_parent'], "修改成功", 3);
        } else {
            $this->jump("index.php?p=admin&c=resource&a=showVideo&parent_parent=" . $data['parent_parent'], "修改失败", 3);
        }
    }

    /**
     * 显示详情
     */
    public function editResAction(){
        $id = $_GET['id'];
        $parent_parent = $_GET['parent_parent'];
        $resourceModel = new ResourceModel('resource');
        $resTypeModel = new ResourceModel('resource_type');
        $resInfo = $resourceModel->findById($id);
        $resType = $resTypeModel->findById($resInfo['parent_id']);
        $parent = $resType['name'];
        include CUR_VIEW_PATH . "html/resource/resource/edit/res_edit.html";
    }

    /**
     * 添加资源
     */
    public function addResAction(){
        //1.收集表单数据
        $data['name'] = trim($_POST['name']);
        $data['creator'] = trim($_POST['creator']);
        $data['link'] = trim($_POST['link']);
        $data['password'] = trim($_POST['password']);
        $data['abstract'] = trim($_POST['abstract']);
        $data['content'] = trim($_POST['content']);
        $data['parent_id'] = $_POST['parent_id'];
        $data['level'] = $_POST['level'];
        $data['parent_parent'] = $_POST['parent_parent'];
        $data['createtime'] = time();

        $this->library("Upload");
        $upload = new Upload();
        if($filename = $upload->up($_FILES['img_first_url'])){
            //成功
            $url = 'public/uploads/' . $filename;
            $data['img_first_url'] = $url;
        } else {
            //失败
            //$data['img_first_url'] = '';
        }

        if($filename = $upload->up($_FILES['img_second_url'])){
            //成功
            $url = 'public/uploads/' . $filename;
            $data['img_second_url'] = $url;
        } else {
            //失败
            //$data['img_second_url'] = '';
        }

        if($filename = $upload->up($_FILES['img_third_url'])){
            //成功
            $url = 'public/uploads/' . $filename;
            $data['img_third_url'] = $url;
        } else {
            //失败
           // $data['img_third_url'] = '';
        }

        //2.验证及处理
        $this->helper("input");
        $data = deepslashes($data);
        $data = deepspecialchars($data);

        $resourceModel = new ResourceModel('resource');
        if($resourceModel->insert($data)){
            $this->jump("index.php?p=admin&c=resource&a=showVideo&parent_parent=" . $data['parent_parent'], "添加成功", 3);
        } else {
            $this->jump("index.php?p=admin&c=resource&a=showVideo&parent_parent=" . $data['parent_parent'], "添加失败", 3);
        }
    }








    //--------------------------------------------------------------------------------------
    //------------------------------对资源分类的操作-------------------------------------------
    //--------------------------------------------------------------------------------------
    /**
     * 添加资源分类
     */
    public function jumpAddTypeAction(){
        include CUR_VIEW_PATH . "html/resource/type/add/resource_type_add.html";
    }

    /**
     * 删除分类
     */
    public function deleteTypeAction(){
        $id = $_GET['id'];
        $resModel = new ResourceModel('resource');
        $resources = $resModel->findresByTypeId($id);
        $i = 0;
        foreach ($resources as $resource){
            $i++;
        }
        if($i == 0){
            $resourceModel = new ResourceModel('resource_type');
            $resourceModel->deleteType($id);
        }
        $this->AllTypeAction();
    }

    /**
     * 进入修改图片页面内
     */
    public function jumpUpdateTypeTuPianAction(){
        $id = $_GET['id'];
        $resourceModel = new ResourceModel('resource_type');
        $resource = $resourceModel->findById($id);
        include CUR_VIEW_PATH . "html/resource/type/update/resource_type_uptupian.html";
    }

    /**
     * 进入修改页面
     */
    public function jumpUpdateTypeAction(){
        $id = $_GET['id'];
        $resourceModel = new ResourceModel('resource_type');
        $resource = $resourceModel->findById($id);
        include CUR_VIEW_PATH . "html/resource/type/update/resource_type_update.html";
    }

    /**
     * 修改类别图片
     */
    public function updateTypeTuPianAction(){
        $id = $_POST['id'];
        $this->library("Upload");
        $upload = new Upload();
        if($filename = $upload->up($_FILES['acm_img'])){
            //成功
            $url = 'public/uploads/' . $filename;
            $resourceModel = new ResourceModel('resource_type');
            $resourceModel->updateTypeTuPian($id, $url);
            $this->AllTypeAction();
        } else {
            //失败
            $this->AllTypeAction();
        }
    }

    /**
     * 修改类别
     */
    public function updateTypeAction(){
        //收集表单
        $data['name'] = trim($_POST['name']);
        $data['content'] = trim($_POST['content']);
        $data['parent'] = $_POST['parent'];
        $data['id'] = $_POST['id'];

        //2.验证及处理
        $this->helper("input");
        $data = deepslashes($data);
        $data = deepspecialchars($data);

        $resourceModel = new ResourceModel('resource_type');
        $typeInfo = $resourceModel->AfindTypeByName($data['name']);
        if(empty($typeInfo)){
            $resourceModel->updateType($data);
            $this->AllTypeAction();
        } else {
            $this->jump("index.php?p=admin&c=resource&a=AllType", "此分类名以存在不可以修改", 3);
        }
    }

    /**
     * 查看详情
     */
    public function editTypeAction(){
        $id = $_GET['id'];
        $resourceModel = new ResourceModel('resource_type');
        $resource = $resourceModel->findById($id);
        include CUR_VIEW_PATH . "html/resource/type/edit/resource_type_edit.html";
    }

    /**
     * 新增资源
     */
    public function addTypeAction(){
        //收集表单
        $data['name'] = trim($_POST['name']);
        $data['content'] = trim($_POST['content']);
        $data['parent'] = $_POST['parent'];

        //2.验证及处理
        $this->helper("input");
        $data = deepslashes($data);
        $data = deepspecialchars($data);

        $this->library("Upload");
        $upload = new Upload();
        if($filename = $upload->up($_FILES['acm_img'])){
            //成功
            $url = 'public/uploads/' . $filename;
            $data['img_url'] = $url;
        } else {
            //失败
            $data['img_url'] = '';
        }
        $resourceModel = new ResourceModel('resource_type');
        $typeInfo = $resourceModel->AfindTypeByName($data['name']);
        if(empty($typeInfo)){
            if($resourceModel->insert($data)){
                $this->jump("index.php?p=admin&c=resource&a=AllType", "", 0);
            } else {
                $this->jump("index.php?p=admin&c=resource&a=AllType", "", 0);
            }
        } else {
            $this->jump("index.php?p=admin&c=resource&a=AllType", "此分类名以存在不可以添加", 3);
        }

    }



    /**
     * 进入全部分类
     */
    public function AllTypeAction(){
        $resourceModel = new ResourceModel('resource_type');

        $where = ""; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $resourceModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 10;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $resources = $resourceModel->findAll($offset,$pagesize);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"admin","c"=>"resource","a"=>"AllType"));
        $pageinfo = $page->showPage();
        include CUR_VIEW_PATH . "html/resource/type/show/resource_type_list.html";
    }

    /**
     * 进入视频资源列表
     */
    public function videoTypeAction(){
        $resourceModel = new ResourceModel('resource_type');

        $where = "parent = 1"; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $resourceModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 10;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $resources = $resourceModel->findVideo($offset,$pagesize);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"admin","c"=>"resource","a"=>"videoType"));
        $pageinfo = $page->showPage();
        include CUR_VIEW_PATH . "html/resource/type/show/resource_type_video.html";
    }

    /**
     * 进入笔记列表
     */
    public function nodeTypeAction(){
        $resourceModel = new ResourceModel('resource_type');

        $where = "parent = 2"; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $resourceModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 10;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $resources = $resourceModel->findNode($offset,$pagesize);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"admin","c"=>"resource","a"=>"nodeType"));
        $pageinfo = $page->showPage();
        include CUR_VIEW_PATH . "html/resource/type/show/resource_type_node.html";
    }

    /**
     * 进入书籍推荐列表
     */
    public function bookTypeAction(){
        $resourceModel = new ResourceModel('resource_type');

        $where = "parent = 3"; //查询条件
        $this->library("Page");
        //获取user总的记录数
        $total = $resourceModel->total($where);

        //指定分页数，每一页显示的记录数
        $pagesize = 10;

        //获取当前页数，默认是1
        $current = isset($_GET['page']) ? $_GET['page'] : 1;
        $offset = ( $current - 1 ) * $pagesize;
        //使用模型完成数据的查询
        $resources = $resourceModel->findBook($offset,$pagesize);
        //使用分页类获取分页信息
        $page = new Page($total,$pagesize,$current,"index.php",array("p"=>"admin","c"=>"resource","a"=>"bookType"));
        $pageinfo = $page->showPage();
        include CUR_VIEW_PATH . "html/resource/type/show/resource_type_book.html";
    }
}