<%--
  Created by IntelliJ IDEA.
  User: 13455
  Date: 2017/1/17
  Time: 12:40
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

  <link href="css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
  <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
  <link href="css/animate.min.css" rel="stylesheet">
  <link href="css/plugins/dropzone/basic.css" rel="stylesheet">
  <link href="css/plugins/dropzone/dropzone.css" rel="stylesheet">
  <link href="css/style.min.css?v=4.0.0" rel="stylesheet">
  <base target="_blank">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeIn">
  <div class="row">
    <div class="col-sm-4 form-group">
      <form id="upload">
        <input type="file" id="file" class="form-control" />
        <button type="submit" class="btn btn-primary">提交</button>
      </form>

    </div>

  </div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
  $(document).ready(function() {
    $("button[type='submit']").click(function() {
      var formData = new FormData();
      var name = $("#file").val();
      formData.append("file", $("#upload")[0].files[0]);
      formData.append("name", name);
      $.ajax({
        url: "${pageContext.request.contextPath}/upload/workUploadExcel",
        type: 'POST',
        data: formData,
        // 告诉jQuery不要去处理发送的数据
        processData: false,
        // 告诉jQuery不要去设置Content-Type请求头
        contentType: false,
        beforeSend: function() {
          console.log("正在进行，请稍候");
        },
        success: function(responseStr) {
          if(responseStr.status === 0) {
            console.log("成功" + responseStr);
          } else {
            console.log("失败");
          }
        },
        error: function(responseStr) {
          console.log("error");
        }
      });
    })
  });
</script>

</body>

</html>
