<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/10
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="Access-Control-Allow-Origin" content="*">

  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>KY 信息技术有限公司 - 主页</title>
  <meta name="keywords" content="科羽信息,后台HTML,响应式后台">
  <meta name="description" content="吉林省科羽信息技术有限公司后台管理系统">
  <link rel="shortcut icon" href="ky.ico">

  <link href="${pageContext.request.contextPath}/static/lib/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/lib/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/lib/css/plugins/footable/footable.core.css" rel="stylesheet" />
  <link href="${pageContext.request.contextPath}/static/lib/css/animate.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/lib/css/style.min.css?v=4.0.0" rel="stylesheet">
  <base target="_blank">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">

  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <h5>公司资产详细</h5>
          <div class="ibox-tools">
            <a class="collapse-link" title="折叠">
              <i class="fa fa-chevron-up"></i>
            </a>
            <a href="gl_addperson.html" target="_self" title="添加记录">
              <i class="fa fa-plus"></i>
            </a>
          </div>
        </div>
        <div class="ibox-content">
          <input type="text" class="form-control input-sm m-b-xs" id="filter" placeholder="搜索表格...">
          <table id="zc" class="footable table table-stripped toggle-arrow-tiny" data-page-size="8" data-filter=#filter>
            <thead>
            <tr>
              <th data-toggle="true">资产编号</th>
              <th>资产类别</th>
              <th>资产名称</th>
              <th>负责人</th>
              <th>存取状态</th>
              <th>现在地址</th>
              <th>领用时间</th>
              <th>归还时间</th>
              <th data-hide="all">审核人</th>
              <th data-hide="all">购买人</th>
              <th data-hide="all">购买价格</th>
              <th data-hide="all">购买数量</th>
              <th data-hide="all">物品单位</th>
              <th data-hide="all">备注</th>
              <th>操作</th>
            </tr>
            </thead>
            <tbody>

            </tbody>
            <tfoot>
            <tr>
              <td colspan="5">
                <ul class="pagination pull-right"></ul>
              </td>
            </tr>
            </tfoot>
          </table>

        </div>
        <div class="ibox ">
          <div class="ibox-content">
            <div class="modal inmodal" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
              <div class="modal-dialog modal-lg">
                <div class="modal-content animated bounceInRight">
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>
  </div>
</div>
<script src="${pageContext.request.contextPath}/static/lib/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/bootstrap.min.js?v=3.3.5"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/plugins/footable/footable.all.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/content.min.js?v=1.0.0"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/zcControl.js"></script>

<script>
  $(document).ready(function(){
    $(".footable").footable();
    $(".footable2").footable();
  });
</script>

</body>
