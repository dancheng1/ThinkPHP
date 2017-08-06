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
  <meta http-equiv="">

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
<body>
<div class="wrapper wrapper-content animated fadeInRight">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title row">
          <div class="col-sm-4 col-sm-offset-5">
            <h2>修改加班记录</h2>
          </div>
          <a class="fa fa-close pull-right"  data-dismiss="modal"></a>
        </div>
        <div class="ibox-content">
          <form role="form" class="form-inline m-t" id="changeOvetime">
            <div class="row m-t-md">
              <h4>基本信息</h4>
              <hr />
            </div>
            <div class="row m-t-md">
              <div class="form-group col-sm-4">
                <label for="id">加班编号</label>
                <input type="text" id="id" class="form-control" name="id" >
              </div>
              <div class="form-group col-sm-4">
                <label for="personno">员工编号</label>
                <input type="text" id="personno" class="form-control" name="personno" >
              </div>
              <div class="form-group col-sm-4">
                <label for="personname">员工姓名</label>
                <input type="text" id="personname" class="form-control" name="personname" >
              </div>
            </div>
            <div class="row m-t-md">

              <div class="form-group col-sm-4">
                <label for="starttime">开始时间</label>
                <input type="text" id="starttime" class="form-control" name="starttime">
              </div>
              <div class="form-group col-sm-4">
                <label for="endtime">结束时间</label>
                <input type="text" id="endtime" class="form-control" name="endtime">
              </div>
              <div class="form-group col-sm-4">
                <label for="lehgthtime">加班时长</label>
                <input type="number" id="lehgthtime" class="form-control" name="lehgthtime" min=0  >
              </div>
            </div>
            <div class="row m-t-md">
              <div class="form-group col-sm-4">
                <label for="workcost">加班补助</label>
                <input type="text" id="workcost" class="form-control" name="workcost" >
              </div>
              <div class="form-group col-sm-4">
                <label for="mealcost">餐补</label>
                <input type="text" id="mealcost" class="form-control" name="mealcost" >
              </div>
              <div class="form-group col-sm-4">
                <label for="trafficcost">交通补助</label>
                <input id="trafficcost" class="form-control" name="trafficcost" >
              </div>
            </div>
            <div class="row m-t-md">
              <div class="form-group col-sm-4">
                <label for="suncost">加班合计</label>
                <input type="text" id="suncost" class="form-control" name="suncost" >
              </div>
            </div>
            <div class="row m-t-md">
              <div class="form-group col-sm-4">
                <label for="currentdate">加班日期</label>
                <input type="text" id="currentdate" class="form-control" name="currentdate" >
              </div>
              <div class="form-group col-sm-4">
                <label for="year">年份</label>
                <input type="text" id="year" class="form-control" name="year" >
              </div>
              <div class="form-group col-sm-4">
                <label for="mouth">月份</label>
                <input id="mouth" class="form-control" name="mouth" >
              </div>
            </div>
            <div class="row m-t-md">
              <div class="form-group col-sm-3">
                <label for="creatBy">创建人</label>
                <input type="text" class="form-control" name="creatBy" id="creatBy">
              </div>
              <div class="form-group col-sm-3">
                <label for="creattime">创建时间</label>
                <input type="text" id="creattime" class="form-control" name="creattime">
              </div>
              <div class="form-group col-sm-3">
                <label for="updateby">更新人</label>
                <input id="updateby" class="form-control" name="updateby"  >
              </div>
              <div class="form-group col-sm-3">
                <label for="updatetime">更新时间</label>
                <input type="text" id="updatetime" class="form-control" name="updatetime">
              </div>
            </div>
            <div class="row m-t-md">
              <div class="form-group col-sm-4 col-sm-offset-4">
                <button class="btn btn-primary" type="submit" id="change">确定修改</button>
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
<script src="${pageContext.request.contextPath}/static/lib/js/overtimeControl.js"></script>

<script type="text/javascript">
  $(document).ready(function(){
    $(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green"});
    /*
     $("#addzc button#submit").click(function(){
     console.log(JSON.stringify($("#addzc").serializeJson()));
     $.ajax({
     type:'post',
     url:'http://192.168.40.11:8081/ky/corp/insertCorp',
     data:JSON.stringify($("#addzc").serializeJson()),
     contentType:"application/json;charset=utf-8",
     success:function(data){
     alert('资产新增'+data.msg);
     },
     error:function(data){
     alert('资产新增'+data.msg);
     }
     })
     })

     //jquery将表单序列化成json
     $.fn.serializeJson=function(){
     var serializeObj={};
     var array=this.serializeArray();
     var str=this.serialize();
     $(array).each(function(){
     if(serializeObj[this.name]){
     if($.isArray(serializeObj[this.name])){
     serializeObj[this.name].push(this.value);
     }else{
     serializeObj[this.name]=[serializeObj[this.name],this.value];
     }
     }else{
     serializeObj[this.name]=this.value;
     }
     });
     return serializeObj;
     };
     */

  });

</script>

</body>
</html>
