<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/10
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>KY 信息技术有限公司 - 主页</title>
  <meta name="keywords" content="科羽信息,后台HTML,响应式后台">
  <meta name="description" content="吉林省科羽信息技术有限公司后台管理系统">
  <link rel="shortcut icon" href="ky.ico">
  <link href="${pageContext.request.contextPath}/static/lib/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/lib/css/font-awesome.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/lib/css/plugins/iCheck/custom.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/lib/css/animate.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/lib/css/style.min.css" rel="stylesheet"><base target="_blank">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <h5>部门信息</h5>
          <div class="ibox-tools">
            <a class="collapse-link">
              <i class="fa fa-chevron-up"></i>
            </a>
            <a href="gl_addDep.html" target="_self" title="添加部门">
              <i class="fa fa-plus"></i>
            </a>
          </div>
        </div>
        <div class="ibox-content">
          <input type="text" class="form-control input-sm m-b-xs" id="filter" placeholder="搜索表格...">
          <table class="table table-bordered footable" id="depart" data-page-size="8" data-filter=#filter>
            <thead>
            <tr>
              <th>部门编号</th>
              <th>部门名称</th>
              <th>成立时间</th>
              <th>更新人</th>
              <th>更新时间</th>
              <th>录入人</th>
              <th>录入时间</th>
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
<script src="${pageContext.request.contextPath}/static/lib/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/plugins/peity/jquery.peity.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/content.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/plugins/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/demo/peity-demo.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/plugins/footable/footable.all.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/depControl.js"></script>


<script>
  $(document).ready(function(){
    $(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green"});
    $(".footable").footable();
    $(".footable2").footable();

  })

</script>

</body>
</html>
