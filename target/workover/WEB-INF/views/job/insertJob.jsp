<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/10
  Time: 15:47
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
  <link href="${pageContext.request.contextPath}/static/lib/css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">
</head>
<body>
<div class="wrapper wrapper-content animated fadeInRight">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title row">
          <div class="col-sm-4 col-sm-offset-5">
            <h2>添加岗位</h2>
          </div>
          <a class="fa fa-close pull-right"  data-dismiss="modal"></a>
        </div>
        <div class="ibox-content">
          <form role="form" class="form-inline m-t" id="addJob">
            <div class="row m-t-md">
              <div class="form-group col-sm-4 col-sm-offset-2">
                <label for="position_id">岗位编号</label>
                <input type="text" required="required" id="position_id" class="form-control" name="position_id" placeholder="请输入岗位编号" maxlength="4" >
              </div>
              <div class="form-group col-sm-4">
                <label for="position_name">岗位名称</label>
                <input type="text" required="required" id="position_name" class="form-control" name="position_name" placeholder="请输入岗位名称">
              </div>
            </div>
            <div class="row m-t-md">
              <div class="form-group col-sm-4 col-sm-offset-2">
                <label for="create_date">创建时间</label>
                <input type="datetime-local" id="create_date" class="form-control" name="birthday" value="2017-01-01T00:00">
              </div>
              <div class="form-group col-sm-4">
                <label for="create_by">创建人</label>
                <input type="text" id="create_by" class="form-control" name="create_by" placeholder="请输入创建人姓名" >
              </div>
            </div>
            <div class="row m-t-md">
              <div class="form-group col-sm-4 col-sm-offset-4">
                <button class="btn btn-primary" type="button" id="submit">提交</button>
                <button class="btn btn-primary" type="button" id="change" style="display: none;">确定</button>
                <button class="btn btn-white" type="reset" id="quxiao">取消</button>
              </div>
            </div>

          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="${pageContext.request.contextPath}/static/lib/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/plugins/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/jobControl.js"></script>
<script type="text/javascript">
  $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green"});});
</script>

</body>
</html>
