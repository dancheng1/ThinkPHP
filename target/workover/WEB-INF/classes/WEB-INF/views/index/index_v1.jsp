<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/27
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!--360浏览器优先以webkit内核解析-->


  <title>H+ 后台主题UI框架 - 主页示例</title>

  <link rel="shortcut icon" href="favicon.ico"> <link href="${pageContext.request.contextPath}/static/lib/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/lib/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

  <link href="${pageContext.request.contextPath}/static/lib/css/animate.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/lib/css/style.min.css" rel="stylesheet">
  <base target="_blank">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <h5>更新日志</h5>
        </div>
        <div class="ibox-content no-padding">
          <div class="panel-body">
            <div class="panel-group" id="version">
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h5 class="panel-title">
                    <a data-toggle="collapse" data-parent="#version" href="#v40">内容</a><code class="pull-right" id="data"></code>
                  </h5>
                </div>
                <div id="v40" class="panel-collapse collapse in">
                  <div class="panel-body">
                    <ol>
                      <li>这里添加想写的话</li>
                      <li>这里添加想写的话</li>
                      <li>这里添加想写的话</li>
                      <li>这里添加想写的话</li>
                      <li>这里添加想写的话</li>
                      <li>这里添加想写的话</li>
                    </ol>
                  </div>
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
<script src="${pageContext.request.contextPath}/static/lib/js/plugins/layer/layer.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/content.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/welcome.min.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
    /*   获取当前时间     */
    function p(s) {
      return s < 10 ? '0' + s : s;
    }
    var myDate = new Date();
    var year = myDate.getFullYear();
    var month = myDate.getMonth() + 1;
    var date = myDate.getDate();
    var h = myDate.getHours(); //获取当前小时数(0-23)
    var m = myDate.getMinutes(); //获取当前分钟数(0-59)
    var s = myDate.getSeconds();
    var now = year + '-' + p(month) + "-" + p(date) + " " + p(h) + ':' + p(m) + ":" + p(s);
    $("#data").text(now);
  })
</script>
</body>

</html>
