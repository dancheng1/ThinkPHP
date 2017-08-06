<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/10
  Time: 16:04
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
          <h5>加班信息</h5>
          <div class="ibox-tools">
            <a class="collapse-link">
              <i class="fa fa-chevron-up"></i>
            </a>
            <a class="dropdown-toggle" data-toggle="dropdown" href="table_basic.html#">
              <i class="fa fa-wrench"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
              <li><a href="table_basic.html#">添加</a></li>
            </ul>
          </div>
        </div>
        <div class="ibox-content">
          <div class="row">
            <div class="col-sm-4 form-group">
              <form id="uploadForm" enctype="multipart/form-data">
                <label for="file">
                  请选择文件
                </label>
                <input id="file" type="file" name="file" class="btn" />
                <button id="upload" type="button" class="btn btn-primary">上传</button>
              </form>
            </div>
          </div>
          <input type="text" class="form-control input-sm m-b-xs" id="filter" placeholder="搜索表格...">
          <table class="footable table table-bordered" id="overtime" data-page-size="8" data-filter=#filter>
            <thead>
            <tr>
              <th>加班编号</th>
              <th>员工编号</th>
              <th>员工姓名</th>
              <th>加班日期</th>
              <th>开始时间</th>
              <th>结束时间</th>
              <th>加班时长</th>
              <th>加班补助</th>
              <th>餐补</th>
              <th>交通补助</th>
              <th>加班合计</th>
              <th>年份</th>
              <th>月份</th>
              <th>创建人</th>
              <th>创建时间</th>
              <th>更新人</th>
              <th>更新时间</th>
              <th>操作</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
          </table>
        </div>
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
<script src="${pageContext.request.contextPath}/static/lib/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/bootstrap.min.js?v=3.3.5"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/plugins/peity/jquery.peity.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/content.min.js?v=1.0.0"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/plugins/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/demo/peity-demo.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/overtimeControl.js"></script>

<script src="${pageContext.request.contextPath}/static/lib/js/plugins/footable/footable.all.min.js" type="text/javascript"></script>

<script>
  $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green"});
    $(".footable").footable();
    $(".footable2").footable();
    $("#upload").click(function() {
      $.ajax({
        url: 'http://192.168.40.152:8080/ky/upload/workUpload1',
        type: 'POST',
        cache: false,
        data: new FormData($('#uploadForm')[0]),
        processData: false,
        contentType: false,
        success:function(){
          alert("成功");
        },
        error:function(){
          alert("失败");
        }
      });
    });
  });
</script>

</body>
</html>
