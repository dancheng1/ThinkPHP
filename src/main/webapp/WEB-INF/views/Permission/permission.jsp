<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/27
  Time: 10:46
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

  <link href="${pageContext.request.contextPath}/static/lib/css/Css.css" rel="stylesheet" type="text/css" />
  <link href="${pageContext.request.contextPath}/static/lib/css/font-awesome.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/lib/css/plugins/footable/footable.core.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/lib/css/animate.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/lib/css/style.min.css" rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/lib/css/jquery.treetable.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/lib/css/jquery.treetable.theme.default.css" />
  <link href="${pageContext.request.contextPath}/static/lib/css/bootstrap.min.css" rel="stylesheet">
  <base target="_blank">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <h5>角色权限</h5>
          <div class="ibox-tools">
            <a class="collapse-link" title="折叠">
              <i class="fa fa-chevron-up"></i>
            </a>
          </div>
        </div>
        <div class="ibox-content">
          <div class="row">
            <div class="col-sm-10"></div>
            <h2>菜单管理</h2>
            <table id="example-advanced" width="200"></table>
            <a href="#" class="btn" onclick="$('#example-advanced').treetable('expandAll'); return false;">展开所有</a>
            <a href="#" class="btn" onclick="$('#example-advanced').treetable('collapseAll'); return false;">关闭所有</a>
          </div>

        </div>
      </div>
    </div>
  </div>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/lib/js/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/lib/js/jquery.treetable.js"></script>
  <script>
    $(function() {
      //显示树
      $.ajax({
        type: 'post',
        url: "http://192.168.40.152:8080/ky/per/selectPer",
        data: {},
        contentType: "application/json;charset=utf-8",
        success: function(data) {
          var obj=data.rows;
          for (var i=0;i<obj.length;i++) {
            if (obj[i].pid == 0) {
              console.log(i);
              $("<tr data-tt-id="+obj[i].id+" data-tt-parent-id=0><td><span class='edit_input'>"+obj[i].name+"</span></td><td><a href='javascript:void(0);' class='cha'>修改 </a><a href='javascript:void(0);' class='del'> 删除</a></td></tr>").appendTo("#example-advanced");
              for (var j=0;j<obj.length;j++) {
                if (obj[j].pid == obj[i].id) {
                  $("<tr data-tt-id="+obj[j].id+" data-tt-parent-id="+obj[i].id+"><td><span class='edit_input'>" + obj[j].name + "</span></td><td><a href='javascript:void(0);' class='cha'>修改 </a><a href='javascript:void(0);' class='del'> 删除</a></td></tr>").appendTo("#example-advanced");
                  for (var f=0;f<obj.length;f++) {
                    if (obj[f].pid == obj[j].id) {
                      $("<tr data-tt-id="+obj[f].id+" data-tt-parent-id="+obj[j].id+"><td><span class='edit_input'>" + obj[f].name + "</span></td><td><a href='javascript:void(0);' class='cha'>修改 </a><a href='javascript:void(0);' class='del'> 删除</a></td></tr>").appendTo("#example-advanced");
                    }
                  }
                }
              }
            }
          }

          //加载treetable
          $("#example-advanced").treetable({ expandable: true });
          //选中高亮
          $("#example-advanced tbody").on("mousedown", "tr", function() {
            $(".selected").not(this).removeClass("selected");
            $(this).toggleClass("selected");
          });

        },
        error: function(data) {
          alert(data.msg);
        }
      })

      //删除按钮
      $("#example-advanced").on("click", ".del", function() {
        var aId = $(this).parent().parent().attr('data-tt-id');
        var num = 0;
        var dat = [];
        $("tr").each(function() {
          dat.push($(this).attr("data-tt-parent-id"));
        })
        for(var i = 0; i < dat.length; i++) {
          if(aId == dat[i]) {
            num++;
          }
        }
        if(num == 0) {
//						$("#example-advanced").treetable("removeNode", aId);
          //删除
          $.ajax({
            type: 'post',
            url: 'http://192.168.40.152:8080/ky/per/deletePer',
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify({ "id":aId }),
            success:function(data){
              alert(data.msg);
            },
            error:function(data){
              alert(data.msg);
            }
          });

        }
      })
      //编辑文字
      $("#example-advanced").on("click", ".cha", function() { //点击编辑的操作（动态绑定，作用于动态生成的HTML）
        var origin = $(this).parent().parent().children().eq(0).children().eq(1); //找到要修改文本的容器节点
        var text = origin.text(); //保存下初始文本
        origin.remove(); //移除这个节点
        var input = $("<input>"); //创建一个input
        input.attr("class", "edit_input").attr("value", text); //给这个input指定class并把初始值赋给它的value
        input.appendTo($(this).parent().parent().children().eq(0)); //插到父容器的前面
        input.focus(); //把光标移动到input上
        $(this).removeClass("cha").addClass("confirm").text("确定"); //修改class和button的文字
      }).on("click", ".confirm", function() { //点击确定的操作
        var change = $(this).parent().parent().children().eq(0).children("input"); //找到input的节点
        var value = change.val(); //获取修改后的值
        change.remove(); //移除这个input
        var span = $("<span></span>"); //创建一个span标签
        span.attr("class", "edit_input").text(value); //修改它的class和文本内容为用户输入的内容
        span.appendTo($(this).parent().parent().children().eq(0));
        //提交修改
        var odata=$(this).parent().parent();
        $.ajax({
          type:"post",
          url:"http://192.168.40.152:8080/ky/per/updatePer",
          contentType: "application/json;charset=utf-8",
          data: JSON.stringify({
            "id":odata.attr("data-tt-id"),
            "pid":odata.attr("data-tt-parent-id"),
            "name":odata.children().eq(0).children("span.edit_input").text()
          }),
          success:function(data){
            alert(data.msg);
          },
          error:function(data){
            alert(data.msg);
          }
        });
        $(this).removeClass("confirm").addClass("cha").text("修改"); //修改class和button的文字
      }).on("keyup", "input.edit_input", function(e) { //输入后按回车键保存功能
        var e = e || window.event;
        if(e.keyCode == 13) {
          $(this).parent().parent().children().eq(1).children("a.confirm").click();
        }
      }).on("click", "span.edit_input", function() { //直接点击文字也可以编辑
        $(this).parent().parent().children().eq(1).children("a.cha").click();
      })

    })
  </script>
</body>

</html>
