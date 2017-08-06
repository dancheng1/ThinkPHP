<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/17
  Time: 15:12
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
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/lib/ky.ico">

  <link href="${pageContext.request.contextPath}/static/lib/css/Css.css" rel="stylesheet" type="text/css" />
  <link href="${pageContext.request.contextPath}/static/lib/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/lib/css/font-awesome.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/lib/css/plugins/footable/footable.core.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/lib/css/animate.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/lib/css/style.min.css" rel="stylesheet">
  <base target="_blank">

  <link href="${pageContext.request.contextPath}/static/lib/css/demo.css" type="text/css" rel="stylesheet" />
  <link href="${pageContext.request.contextPath}/static/lib/css/zTreeStyle/zTreeStyle.css" type="text/css" rel="stylesheet" />


  <style>
    .left {
      float: left;
      margin-top: 10px;
    }
    #menu li {
      width: 100%;
      height: 40px;
      text-align: center;
      display: block;
      background: #0B61A4;
      border: 1px silver solid;
      color: white;
      font-size: 14px;
      font-weight: bold;
      word-spacing: 2px;
      line-height: 40px;
      margin-top: 10px;
    }
    #menu li.cur {
      background: #66A3D2;
      color: white;
    }
  </style>
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
            <a href="gl_addperson.html" target="_self" title="添加角色权限">
              <i class="fa fa-plus"></i>
            </a>
          </div>
        </div>
        <div class="ibox-content">
          <div class="row">
            <div class="col-sm-3" style="background: rgba(128,128,128,0.14); height: 200px;">
              <h2>程序员提示您：</h2>
              <p>每更改一个人请点击一次保存！</p>
            </div>
            <div class="col-sm-5" >
              <ul id="menu"></ul>
            </div>
            <div class="col-sm-3" >
              <ul id="treeDemo" class="ztree"></ul>
            </div>
          </div>

          <div class="row">
            <div class="col-sm-1 col-sm-offset-5">
              <div id="submit" class="btn btn-primary">保存</div>
            </div>
            <div class="col-sm-1">
              <div id="no" class="btn btn-primary">取消</div>
            </div>
          </div>
        </div>

      </div>
    </div>
  </div>
</div>

<script src="${pageContext.request.contextPath}/static/lib/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/jquery.ztree.core.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/jquery.ztree.excheck.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/jquery.kkPages.js"></script>
<script>
  var setting = {
    check: {
      enable: true,
      chkStyle: "checkbox"
    },
    data: {
      simpleData: {
        enable: true
      }
    }
  };
  $(document).ready(function() {
    var ID=1;
    //显示所有权限
    var json = [];
    $.ajax({
      type: 'post',
      url: 'http://192.168.40.152:8080/ky/per/selectPer',
      contentType:"application/json;charset=utf-8",
      data: JSON.stringify({}),
      success: function(data) {
        for(var i = 0; i < data.rows.length; i++) {
          var jj = {};
          jj.id = data.rows[i].id;
          jj.pId = data.rows[i].pid;
          jj.name = data.rows[i].name;
          jj.open = true;
          json.push(jj);
        }
        $.fn.zTree.init($("#treeDemo"), setting, json);
        showTree('1');
      },
      error: function(data) {
        alert('权限' + data.msg);
      }
    });

    //角色显示
    $.ajax({
      type: 'post',
      url: 'http://192.168.40.152:8080/ky/role/findAll',
      data: {},
      contentType:"application/json;charset=utf-8",
      success: function(data) {
        for(var i = 0; i < data.rows1.length; i++) {
          var li = $("<li class='item' id=" + data.rows1[i].id + ">" + data.rows1[i].name + "</li>");
          $("#menu").append(li);
        }
        $('ul#menu').kkPages({
          PagesClass:'.item', //需要分页的元素
          PagesMth:4, //每页显示个数
          PagesNavMth:5 //显示导航个数
        });
        var allLi = $("#menu li");
        $("#menu").children().eq(0).addClass('cur');
        $.fn.zTree.init($("#treeDemo"), setting, json);
        for(var i = 0; i < allLi.length; i++) {
          allLi[i].onclick = function() {
            for (var i=0;i<json.length;i++) {
              json[i].checked=false;
            }
            allLi.not(this).removeClass("cur");
            $(this).addClass("cur");
            ID = $(this).attr('id');
            showTree(ID);
          }
        }
      },
      error: function(data) {
        alert(data.msg)
      }
    })

    //某个角色的权限
    function showTree(ID) {
      $.ajax({
        type: 'post',
        url: 'http://192.168.40.152:8080/ky/role/findPerByRole',
        contentType:"application/json;charset=utf-8",
        data: JSON.stringify({"id":ID}),
        success: function(data) {
          for(var i = 0; i < data.rows.length; i++) {
            for(var j = 0; j < json.length; j++) {
              if(json[j].id == data.rows[i].id && json[j].pId == data.rows[i].pid) {
                json[j].checked=true;
                $.fn.zTree.init($("#treeDemo"), setting, json);
              }
            }
          }
        },
        error: function(data) {
          alert('角色查询权限' + data.msg);
        }
      });
    }

//				修改角色权限
    $("#submit").click(function(){
      $.ajax({
        type:"post",
        url:"http://192.168.40.152:8080/ky/rper/updateRolePers",
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify(getData(ID)),
        success:function(data){
          alert("修改"+data.msg);
        },
        error:function(data){
          alert("修改"+data.msg);
        }
      });
    })
    function getData(ID){
      var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
      var jData={};
      jData.roleId=ID;
      jData.list=[];
      var hj=treeObj.getCheckedNodes(true);
      for (var i=0;i<hj.length;i++) {
        var jk={};
        jk.id=hj[i].id;
        jk.pid=hj[i].pId;
        jk.name=hj[i].name;
        jData.list.push(jk);
      }
      return jData;
    }

  });
</script>

</body>
</html>
