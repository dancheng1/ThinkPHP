<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/10
  Time: 16:28
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
  <link href="${pageContext.request.contextPath}/static/lib/css/animate.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/lib/css/plugins/dropzone/basic.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/lib/css/plugins/dropzone/dropzone.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/lib/css/plugins/dropzone/dropzone.css" rel="stylesheet">
  <base target="_blank">

</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeIn">
  <div class="row">
    <div class="col-sm-4 form-group">
      <form id="uploadForm" enctype="multipart/form-data">
        请选择文件<input id="file" type="file" name="file" />
        <button id="upload" type="button" class="btn btn-primary">上传</button>
      </form>
    </div>

  </div>
</div>
<script src="${pageContext.request.contextPath}/static/lib/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/bootstrap.min.js"></script>
<script>
  $(document).ready(function() {
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
