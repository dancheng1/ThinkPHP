<?php
namespace Admin\Controller;
use Components\EmailTool;
use Model\GoodsModel;
use Think\Controller;
use Think\Image;
use Think\Page;
use Think\Upload;

class GoodsController extends Controller{
    public function showlist(){
        $model = M('goods');
        $recordcount = $model->count();
        //第一个参数是总记录数，第二个参数是页面大小
        $page = new Page($recordcount, 10);

        $page->lastSuffix = false;     //最后一页是否显示总页数
        $page->rollPage = 4;           //显示页数
        $page->setConfig('prev', '【上一页】');
        $page->setConfig('next', '【下一页】');
        $page->setConfig('first', '【首页】');
        $page->setConfig('last', '【末页】');
        //$page->setConfig('$lastSuffix', '');

        $page->setConfig('theme', '%FIRST% %UP_PAGE% %LINK_PAGE% %DOWN_PAGE% %END%');

        $startno = $page->firstRow;
        $pagesize = $page->listRows;
        $list = $model->limit("$startno, $pagesize")->select();

        $pagestr = $page->show();   //组装分页字符串

        $this->assign('list', $list);
        $this->assign('pagestr', $pagestr);
        $this->display();
    }

    public function add(){
        //方法一
        /*if(IS_POST){
            $data['goods_name'] = $_POST['goods_name'];
            $data['goods_category_id'] = $_POST['goods_category_id'];
            $data['goods_price'] = $_POST['goods_price'];
            $data['goods_introduce'] = $_POST['goods_introduce'];
            $msg = '添加失败';
            if(M('goods')->add($data)){
                $msg = '添加成功';
            }
            $this->redirect('showlist', array(), 3, $msg);
        }*/
        //方法二
        $goods = M('Goods');
        if(IS_POST){
            if($data = $goods->create()){
                if($_FILES['goods_image']['error'] == 0){
                    //文件上传部分
                    $config = array(
                        'rootPath'      =>  './Application/public/uploads/',
                    );
                    $upload = new Upload($config);
                    $info = $upload->uploadOne($_FILES['goods_image']);
                    $data['goods_big_img'] = $info['savepath'] . $info['savename'];

                    //生成缩略图
                    $img = new Image();
                    //1、打开图片
                    $big_img = $upload->rootPath . $data['goods_big_img'];
                    $img->open($big_img);
                    //制作缩略图
                    $img->thumb(200,300,6);
                    //3、保存
                    $small_img = $upload->rootPath . $info['savepath'] . 'small' . $info['savename'];
                    $img->save($small_img);
                    $data['goods_small_img'] = $info['savepath'] . 'small' . $info['savename'];
                    $data['goods_create_time'] = time();

                    if($goods->add($data)){
                        $this->success('添加成功', 'showlist', 3);
                    } else {
                        $this->error('添加失败');
                    }
                } else {
                    echo '文件上传失败';
                    exit;
                }
            }
            exit;
        }
        //方法三
       /* if(IS_POST){
            if(M('goods')->add(I('post.'))){
                $this->success('添加成功', 'showlist', 3);
            } else {
                $this->error('添加失败');
            }
        }*/



        $category = M('category')->select();
        $this->assign('category', $category);
        $this->display();
    }

    public function update($goods_id){
        if(IS_POST){
            $goods = M('goods');
            $data = $goods->create();
            $data['goods_create_time'] = time();
            if($goods->save($data)){
                $this->success('修改成功', U('showlist'), 3);
            } else {
                $this->error('修改失败');
            }
            exit;
        }
        $category = M('category')->select();
        $data = M('goods')->find($goods_id);
        $this->assign('category', $category);
        $this->assign('data', $data);
        $this->display();
    }

    public function del($goods_id){
        if(M('goods')->delete($goods_id)){
            $this->success('删除成功', U('showlist'), 2);
        } else {
            $this->error('删除失败', U('showlist'), 1);
        }
    }

    public function send(){
        $obj = new \Components\EmailTool();
        $obj->send();
    }
}