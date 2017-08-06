<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KY 信息技术有限公司 - 主页</title>
	<meta name="keywords" content="科羽信息,后台HTML,响应式后台">
	<meta name="description" content="吉林省科羽信息技术有限公司后台管理系统">
    <link rel="shortcut icon" href="ky.ico"> 
    
	<link href="css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
	<link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
	<link href="css/plugins/footable/footable.core.css" rel="stylesheet" />
	<link href="css/animate.min.css" rel="stylesheet">
	<link href="css/style.min.css?v=4.0.0" rel="stylesheet">
	<base target="_blank">
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">

        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>员工信息</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link" title="折叠">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a href="gl_addperson.html" target="_self" title="添加员工">
                                <i class="fa fa-plus"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
						<input type="text" class="form-control input-sm m-b-xs" id="filter" placeholder="搜索表格...">
                        <table id="employee" class="footable table table-stripped toggle-arrow-tiny" data-page-size="8" data-filter=#filter>
                            <thead>
                            <tr>
                                <th data-toggle="true">员工编号</th>
                                <th>姓名</th>
                                <th>性别</th>
                                <th>邮箱</th>
                                <th>电话</th>
                                <th>职位</th>
                                <th>所属部门</th>
                                <th>婚否</th>
                                <th>出生日期</th>
                                <th>工作年限</th>
                                <th data-hide="all">居住地</th>
                                <th data-hide="all">户口所在地</th>
                                <th data-hide="all">政治面貌</th>
                                <th data-hide="all">身份证号</th>
                                <th data-hide="all">邮编1</th>
                                <th data-hide="all">邮编2</th>
                                <th data-hide="all">紧急电话</th>
                                <th data-hide="all">档案所在地</th>
                                <th data-hide="all">档案管理形式</th>
                                <th data-hide="all">入职时间</th>
                                <th data-hide="all">在职状态</th>
                                <th data-hide="all">录入时间</th>
                                <th data-hide="all">录入人</th>
                                <th data-hide="all">更新时间</th>
                                <th data-hide="all">更新人</th>
                                <th data-hide="all">是否缴纳社会保险</th>
                                <th data-hide="all">保险形式</th>
                                <th data-hide="all">社保卡号码</th>
                                <th data-hide="all">社会保险险种</th>
                                <th data-hide="all">是否缴纳公积金</th>
                                <th data-hide="all">公积金形式</th>
                                <th data-hide="all">公积金号码</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
        <!--
                            <tr>
                                <td>0001</td>
                                <td>袁岳</td>
                                <td>男</td>
                                <td>1234345@qq.com</td>
                                <td>12345678900</td>
                                <td>java开发工程师</td>
                                <td>开发部</td>
                                <td>未婚</td>
                                <td>2016.12.1</td>
                                <td>3年</td>
                                
                                <td>南湖广场</td>
                                <td>吉林省长春市朝阳区南湖大路与前进大街交汇</td>
                                <td>团员</td>
                                <td>222222222222222222</td>
                                <td><span>130022</span><span>130021</span></td>
                                <td>12345678900</td>
                                <td>长春</td>
                                <td>个人</td>
                                <td>2016.12.1</td>
                                <td>在职</td>
                                <td>2016.12.1</td>
                                <td>小铁</td>
                                <td>2016.12.12</td>
                                <td>小铁</td>
                                <td>是</td>
                                <td>保险形式</td>
                                <td>社保卡号码</td>
                                <td>保险险种</td>
                                <td>是</td>
                                <td>公积金形式</td>
                                <td>公积金号码</td>
                                <td><a href="#"><i class="fa fa-edit text-navy"></i> 修改</a>
                                	<a href="#"><i class="fa fa-close text-danger"></i> 删除</a>
                                </td>
                            </tr>
                            <tr>
                                <td>0001</td>
                                <td>袁岳</td>
                                <td>男</td>
                                <td>1234345@qq.com</td>
                                <td>12345678900</td>
                                <td>java开发工程师</td>
                                <td>开发部</td>
                                <td>未婚</td>
                                <td>2016.12.1</td>
                                <td>3年</td>
                                
                                <td>南湖广场</td>
                                <td>吉林省长春市朝阳区南湖大路与前进大街交汇</td>
                                <td>团员</td>
                                <td>222222222222222222</td>
                                <td><span>130022</span><span>130021</span></td>
                                <td>12345678900</td>
                                <td>长春</td>
                                <td>个人</td>
                                <td>2016.12.1</td>
                                <td>在职</td>
                                <td>2016.12.1</td>
                                <td>小铁</td>
                                <td>2016.12.12</td>
                                <td>小铁</td>
                                <td>是</td>
                                <td>保险形式</td>
                                <td>社保卡号码</td>
                                <td>保险险种</td>
                                <td>是</td>
                                <td>公积金形式</td>
                                <td>公积金号码</td>
                                <td><a href="#"><i class="fa fa-edit text-navy"></i> 修改</a>
                                	<a href="#"><i class="fa fa-close text-danger"></i> 删除</a>
                                </td>
                            </tr>
                            <tr>
                                <td>0022</td>
                                <td>升水</td>
                                <td>男</td>
                                <td>1234345@qq.com</td>
                                <td>12345678900</td>
                                <td>web前端开发</td>
                                <td>营销部</td>
                                <td>未婚</td>
                                <td>2016.12.1</td>
                                <td>3年</td>
                                
                                <td>南湖广场</td>
                                <td>吉林省长春市朝阳区南湖大路与前进大街交汇</td>
                                <td>团员</td>
                                <td>222222222222222222</td>
                                <td><span>130022</span><span>130021</span></td>
                                <td>12345678900</td>
                                <td>长春</td>
                                <td>个人</td>
                                <td>2016.12.1</td>
                                <td>在职</td>
                                <td>2016.12.1</td>
                                <td>小铁</td>
                                <td>2016.12.12</td>
                                <td>小铁</td>
                                <td>是</td>
                                <td>保险形式</td>
                                <td>社保卡号码</td>
                                <td>保险险种</td>
                                <td>是</td>
                                <td>公积金形式</td>
                                <td>公积金号码</td>
                                <td><a href="#"><i class="fa fa-edit text-navy"></i> 修改</a>
                                	<a href="#"><i class="fa fa-close text-danger"></i> 删除</a>
                                </td>
                            </tr>
                            <tr>
                                <td>0002</td>
                                <td>袁岳</td>
                                <td>男</td>
                                <td>1234345@qq.com</td>
                                <td>12345678900</td>
                                <td>java开发工程师</td>
                                <td>营销部</td>
                                <td>未婚</td>
                                <td>2016.12.1</td>
                                <td>3年</td>
                                
                                <td>南湖广场</td>
                                <td>吉林省长春市朝阳区南湖大路与前进大街交汇</td>
                                <td>团员</td>
                                <td>222222222222222222</td>
                                <td><span>130022</span><span>130021</span></td>
                                <td>12345678900</td>
                                <td>长春</td>
                                <td>个人</td>
                                <td>2016.12.1</td>
                                <td>在职</td>
                                <td>2016.12.1</td>
                                <td>小铁</td>
                                <td>2016.12.12</td>
                                <td>小铁</td>
                                <td>是</td>
                                <td>保险形式</td>
                                <td>社保卡号码</td>
                                <td>保险险种</td>
                                <td>是</td>
                                <td>公积金形式</td>
                                <td>公积金号码</td>
                                <td><a href="#"><i class="fa fa-edit text-navy"></i> 修改</a>
                                	<a href="#"><i class="fa fa-close text-danger"></i> 删除</a>
                                </td>
                            </tr>
                            <tr>
                                <td>0001</td>
                                <td>袁岳</td>
                                <td>男</td>
                                <td>1234345@qq.com</td>
                                <td>12345678900</td>
                                <td>java开发工程师</td>
                                <td>开发部</td>
                                <td>未婚</td>
                                <td>2016.12.1</td>
                                <td>3年</td>
                                
                                <td>南湖广场</td>
                                <td>吉林省长春市朝阳区南湖大路与前进大街交汇</td>
                                <td>团员</td>
                                <td>222222222222222222</td>
                                <td><span>130022</span><span>130021</span></td>
                                <td>12345678900</td>
                                <td>长春</td>
                                <td>个人</td>
                                <td>2016.12.1</td>
                                <td>在职</td>
                                <td>2016.12.1</td>
                                <td>小铁</td>
                                <td>2016.12.12</td>
                                <td>小铁</td>
                                <td>是</td>
                                <td>保险形式</td>
                                <td>社保卡号码</td>
                                <td>保险险种</td>
                                <td>是</td>
                                <td>公积金形式</td>
                                <td>公积金号码</td>
                                <td><a href="#"><i class="fa fa-edit text-navy"></i> 修改</a>
                                	<a href="#"><i class="fa fa-close text-danger"></i> 删除</a>
                                </td>
                            </tr>
                            <tr>
                                <td>0051</td>
                                <td>袁岳</td>
                                <td>男</td>
                                <td>1234345@qq.com</td>
                                <td>12345678900</td>
                                <td>测试</td>
                                <td>操作</td>
                                <td>未婚</td>
                                <td>2016.12.1</td>
                                <td>3年</td>
                                
                                <td>南湖广场</td>
                                <td>吉林省长春市朝阳区南湖大路与前进大街交汇</td>
                                <td>团员</td>
                                <td>222222222222222222</td>
                                <td><span>130022</span><span>130021</span></td>
                                <td>12345678900</td>
                                <td>长春</td>
                                <td>个人</td>
                                <td>2016.12.1</td>
                                <td>在职</td>
                                <td>2016.12.1</td>
                                <td>小铁</td>
                                <td>2016.12.12</td>
                                <td>小铁</td>
                                <td>是</td>
                                <td>保险形式</td>
                                <td>社保卡号码</td>
                                <td>保险险种</td>
                                <td>是</td>
                                <td>公积金形式</td>
                                <td>公积金号码</td>
                                <td><a href="#"><i class="fa fa-edit text-navy"></i> 修改</a>
                                	<a href="#"><i class="fa fa-close text-danger"></i> 删除</a>
                                </td>
                            </tr>
                            <tr>
                                <td>0001</td>
                                <td>袁岳</td>
                                <td>男</td>
                                <td>1234345@qq.com</td>
                                <td>12345678900</td>
                                <td>java开发工程师</td>
                                <td>开发部</td>
                                <td>未婚</td>
                                <td>2016.12.1</td>
                                <td>3年</td>
                                
                                <td>南湖广场</td>
                                <td>吉林省长春市朝阳区南湖大路与前进大街交汇</td>
                                <td>团员</td>
                                <td>222222222222222222</td>
                                <td><span>130022</span><span>130021</span></td>
                                <td>12345678900</td>
                                <td>长春</td>
                                <td>个人</td>
                                <td>2016.12.1</td>
                                <td>在职</td>
                                <td>2016.12.1</td>
                                <td>小铁</td>
                                <td>2016.12.12</td>
                                <td>小铁</td>
                                <td>是</td>
                                <td>保险形式</td>
                                <td>社保卡号码</td>
                                <td>保险险种</td>
                                <td>是</td>
                                <td>公积金形式</td>
                                <td>公积金号码</td>
                                <td><a href="#"><i class="fa fa-edit text-navy"></i> 修改</a>
                                	<a href="#"><i class="fa fa-close text-danger"></i> 删除</a>
                                </td>
                            </tr>
                            <tr>
                                <td>0001</td>
                                <td>袁岳</td>
                                <td>男</td>
                                <td>1234345@qq.com</td>
                                <td>12345678900</td>
                                <td>java开发工程师</td>
                                <td>开发部</td>
                                <td>未婚</td>
                                <td>2016.12.1</td>
                                <td>3年</td>
                                
                                <td>南湖广场</td>
                                <td>吉林省长春市朝阳区南湖大路与前进大街交汇</td>
                                <td>团员</td>
                                <td>222222222222222222</td>
                                <td><span>130022</span><span>130021</span></td>
                                <td>12345678900</td>
                                <td>长春</td>
                                <td>个人</td>
                                <td>2016.12.1</td>
                                <td>在职</td>
                                <td>2016.12.1</td>
                                <td>小铁</td>
                                <td>2016.12.12</td>
                                <td>小铁</td>
                                <td>是</td>
                                <td>保险形式</td>
                                <td>社保卡号码</td>
                                <td>保险险种</td>
                                <td>是</td>
                                <td>公积金形式</td>
                                <td>公积金号码</td>
                                <td><a href="#"><i class="fa fa-edit text-navy"></i> 修改</a>
                                	<a href="#"><i class="fa fa-close text-danger"></i> 删除</a>
                                </td>
                            </tr>
                            <tr>
                                <td>0011</td>
                                <td>袁岳</td>
                                <td>男</td>
                                <td>1234345@qq.com</td>
                                <td>12345678900</td>
                                <td>java开发工程师</td>
                                <td>开发部</td>
                                <td>未婚</td>
                                <td>2016.12.1</td>
                                <td>3年</td>
                                
                                <td>南湖广场</td>
                                <td>吉林省长春市朝阳区南湖大路与前进大街交汇</td>
                                <td>团员</td>
                                <td>222222222222222222</td>
                                <td><span>130022</span><span>130021</span></td>
                                <td>12345678900</td>
                                <td>长春</td>
                                <td>个人</td>
                                <td>2016.12.1</td>
                                <td>在职</td>
                                <td>2016.12.1</td>
                                <td>小铁</td>
                                <td>2016.12.12</td>
                                <td>小铁</td>
                                <td>是</td>
                                <td>保险形式</td>
                                <td>社保卡号码</td>
                                <td>保险险种</td>
                                <td>是</td>
                                <td>公积金形式</td>
                                <td>公积金号码</td>
                                <td><a href="#"><i class="fa fa-edit text-navy"></i> 修改</a>
                                	<a href="#"><i class="fa fa-close text-danger"></i> 删除</a>
                                </td>
                            </tr>
                            <tr>
                                <td>0001</td>
                                <td>袁岳</td>
                                <td>男</td>
                                <td>1234345@qq.com</td>
                                <td>12345678900</td>
                                <td>java开发工程师</td>
                                <td>开发部</td>
                                <td>未婚</td>
                                <td>2016.12.1</td>
                                <td>3年</td>
                                
                                <td>南湖广场</td>
                                <td>吉林省长春市朝阳区南湖大路与前进大街交汇</td>
                                <td>团员</td>
                                <td>222222222222222222</td>
                                <td><span>130022</span><span>130021</span></td>
                                <td>12345678900</td>
                                <td>长春</td>
                                <td>个人</td>
                                <td>2016.12.1</td>
                                <td>在职</td>
                                <td>2016.12.1</td>
                                <td>小铁</td>
                                <td>2016.12.12</td>
                                <td>小铁</td>
                                <td>是</td>
                                <td>保险形式</td>
                                <td>社保卡号码</td>
                                <td>保险险种</td>
                                <td>是</td>
                                <td>公积金形式</td>
                                <td>公积金号码</td>
                                <td><a href="#"><i class="fa fa-edit text-navy"></i> 修改</a>
                                	<a href="#"><i class="fa fa-close text-danger"></i> 删除</a>
                                </td>
                            </tr>
                            <tr>
                                <td>0001</td>
                                <td>袁岳</td>
                                <td>男</td>
                                <td>1234345@qq.com</td>
                                <td>12345678900</td>
                                <td>java开发工程师</td>
                                <td>开发部</td>
                                <td>未婚</td>
                                <td>2016.12.1</td>
                                <td>3年</td>
                                
                                <td>南湖广场</td>
                                <td>吉林省长春市朝阳区南湖大路与前进大街交汇</td>
                                <td>团员</td>
                                <td>222222222222222222</td>
                                <td><span>130022</span><span>130021</span></td>
                                <td>12345678900</td>
                                <td>长春</td>
                                <td>个人</td>
                                <td>2016.12.1</td>
                                <td>在职</td>
                                <td>2016.12.1</td>
                                <td>小铁</td>
                                <td>2016.12.12</td>
                                <td>小铁</td>
                                <td>是</td>
                                <td>保险形式</td>
                                <td>社保卡号码</td>
                                <td>保险险种</td>
                                <td>是</td>
                                <td>公积金形式</td>
                                <td>公积金号码</td>
                                <td><a href="#"><i class="fa fa-edit text-navy"></i> 修改</a>
                                	<a href="#"><i class="fa fa-close text-danger"></i> 删除</a>
                                </td>
                            </tr>
                            <tr>
                                <td>0001</td>
                                <td>袁岳</td>
                                <td>男</td>
                                <td>1234345@qq.com</td>
                                <td>12345678900</td>
                                <td>java开发工程师</td>
                                <td>开发部</td>
                                <td>未婚</td>
                                <td>2016.12.1</td>
                                <td>3年</td>
                                
                                <td>南湖广场</td>
                                <td>吉林省长春市朝阳区南湖大路与前进大街交汇</td>
                                <td>团员</td>
                                <td>222222222222222222</td>
                                <td><span>130022</span><span>130021</span></td>
                                <td>12345678900</td>
                                <td>长春</td>
                                <td>个人</td>
                                <td>2016.12.1</td>
                                <td>在职</td>
                                <td>2016.12.1</td>
                                <td>小铁</td>
                                <td>2016.12.12</td>
                                <td>小铁</td>
                                <td>是</td>
                                <td>保险形式</td>
                                <td>社保卡号码</td>
                                <td>保险险种</td>
                                <td>是</td>
                                <td>公积金形式</td>
                                <td>公积金号码</td>
                                <td><a href="#"><i class="fa fa-edit text-navy"></i> 修改</a>
                                	<a href="#"><i class="fa fa-close text-danger"></i> 删除</a>
                                </td>
                            </tr>
                            <tr>
                                <td>0001</td>
                                <td>袁岳</td>
                                <td>男</td>
                                <td>1234345@qq.com</td>
                                <td>12345678900</td>
                                <td>java开发工程师</td>
                                <td>开发部</td>
                                <td>未婚</td>
                                <td>2016.12.1</td>
                                <td>3年</td>
                                
                                <td>南湖广场</td>
                                <td>吉林省长春市朝阳区南湖大路与前进大街交汇</td>
                                <td>团员</td>
                                <td>222222222222222222</td>
                                <td><span>130022</span><span>130021</span></td>
                                <td>12345678900</td>
                                <td>长春</td>
                                <td>个人</td>
                                <td>2016.12.1</td>
                                <td>在职</td>
                                <td>2016.12.1</td>
                                <td>小铁</td>
                                <td>2016.12.12</td>
                                <td>小铁</td>
                                <td>是</td>
                                <td>保险形式</td>
                                <td>社保卡号码</td>
                                <td>保险险种</td>
                                <td>是</td>
                                <td>公积金形式</td>
                                <td>公积金号码</td>
                                <td><a href="#"><i class="fa fa-edit text-navy"></i> 修改</a>
                                	<a href="#"><i class="fa fa-close text-danger"></i> 删除</a>
                                </td>
                            </tr>
                            <tr>
                                <td>0001</td>
                                <td>袁岳</td>
                                <td>男</td>
                                <td>1234345@qq.com</td>
                                <td>12345678900</td>
                                <td>java开发工程师</td>
                                <td>开发部</td>
                                <td>未婚</td>
                                <td>2016.12.1</td>
                                <td>3年</td>
                                
                                <td>南湖广场</td>
                                <td>吉林省长春市朝阳区南湖大路与前进大街交汇</td>
                                <td>团员</td>
                                <td>222222222222222222</td>
                                <td><span>130022</span><span>130021</span></td>
                                <td>12345678900</td>
                                <td>长春</td>
                                <td>个人</td>
                                <td>2016.12.1</td>
                                <td>在职</td>
                                <td>2016.12.1</td>
                                <td>小铁</td>
                                <td>2016.12.12</td>
                                <td>小铁</td>
                                <td>是</td>
                                <td>保险形式</td>
                                <td>社保卡号码</td>
                                <td>保险险种</td>
                                <td>是</td>
                                <td>公积金形式</td>
                                <td>公积金号码</td>
                                <td><a href="#"><i class="fa fa-edit text-navy"></i> 修改</a>
                                	<a href="#"><i class="fa fa-close text-danger"></i> 删除</a>
                                </td>
                            </tr>
        -->
                            </tbody>
                            <tfoot>
                            <tr>
                                <td colspan="5">
                                    <ul class="pagination pull-right"></ul>
                                    <button id="shazi">14</button>
                                </td>
                            </tr>
                            </tfoot>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.5"></script>
    <script src="js/newData.js"></script>
    <script src="js/操作数据.js"></script>
    <script src="js/plugins/footable/footable.all.min.js"></script>
    <script src="js/content.min.js?v=1.0.0"></script>
    
    <script>
        $(document).ready(function(){$(".footable").footable();$(".footable2").footable()});
    </script>
    
</body>

</html>