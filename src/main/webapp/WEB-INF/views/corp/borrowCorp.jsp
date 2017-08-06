<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/27
  Time: 10:38
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
  <link href="${pageContext.request.contextPath}/static/lib/css/style.min.css" rel="stylesheet">
  <base target="_blank">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <h2 style="text-align: center;">资产领用单</h2>
        </div>
        <div class="ibox-content">
          <form role="form" class="form-inline m-t" id="zcNote">
            <div id="per">
              <div class="row m-t-md">
                <div class="form-group col-sm-3 col-sm-offset-1">
                  <label for="userId1">领用人：</label>
                  <select name="userId1" id="userId1" class="form-control">
                    <option value="l小狗">小狗</option>
                    <option value="l小猫">小猫</option>
                    <option value="l小刺猬">小刺猬</option>
                  </select>
                </div>
                <div class="form-group col-sm-3">
                  <label for="lqTime">领用时间:</label>
                  <input class="now form-control" name="lqTime" id="lqTime" />
                  <!--<input type="datetime-local" id="lqTime" class="form-control" name="lqTime"  value="2017-01-01T00:00">-->
                </div>
              </div>
              <div class="row m-t-md">
                <div class="form-group col-sm-3 col-sm-offset-1">
                  <label for="userId2">审批人：</label>
                  <select name="userId2" id="userId2" class="form-control">
                    <option value="s小铁">小铁</option>
                    <option value="s小美">小美</option>
                    <option value="s小月">小月</option>
                  </select>
                </div>
                <div class="form-group col-sm-4">
                  <label for="ghTime">预计归还时间:</label>
                  <input type="datetime-local" id="ghTime" class="form-control" name="ghTime" value="2017-01-01T00:00">
                </div>
              </div>
            </div>
            <div class="row" id="dat" style="margin-top: 50px;">
              <a class="fa fa-plus pull-right" id="plus"></a>
              <div class="col-sm-12">
                <div class="form-group col-sm-2"><label>类别</label></div>
                <div class="form-group col-sm-2"><label>名称</label></div>
                <div class="form-group col-sm-2"><label>编号</label></div>
                <div class="form-group col-sm-2"><label>价格</label></div>
                <div class="form-group col-sm-2"><label>现存放地点</label></div>
                <div class="form-group col-sm-2"><label>备注</label></div>
              </div>
              <div class="col-sm-12 clo add">
                <div class="form-group col-sm-2">
                  <select name="assetstype" class="form-control"></select>
                </div>
                <div class="form-group col-sm-2">
                  <select name="assetsname" class="form-control"></select>
                </div>
                <div class="form-group col-sm-2">
                  <input type="text" name="assetsno" class="form-control" />
                </div>
                <div class="form-group col-sm-2">
                  <input type="number" name="buyprice" min="0" class="form-control" />
                </div>
                <div class="form-group col-sm-2">
                  <select name="savepoint" class="form-control">
                    <option value="qm">启明软件园</option>
                    <option value="cyy">青年创业园</option>
                  </select>
                </div>
                <div class="form-group col-sm-2">
                  <textarea name="note" class="form-control" style="resize: none;"></textarea>
                </div>
              </div>
            </div>
            <div class="row m-t-md">
              <div class="form-group col-sm-4 col-sm-offset-4">
                <button class="btn btn-primary" type="submit" id="submit">提交</button>
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

<script type="text/javascript">
  $(document).ready(function() {
    $(".clo").css("margin-top", "10px");
    //克隆新的一条记录
    $("#plus").click(function() {
      $("#dat").append($(".add").clone(true).removeClass("add"));
    })
    // 去重
    function replace(array) {
      array.sort();
      var re = [array[0]];
      for(var i = 1; i < array.length; i++) {
        if(array[i] !== re[re.length - 1]) {
          re.push(array[i]);
        }
      }
      return re;
    }
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
    $("#lqTime").val(now);
    //判别类别下的资产
    function back(obj) {
      $.ajax({
        type: "post",
        url: "http://192.168.40.152:8080/ky/corp/findByAssType",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify({ "assetstype": obj }),
        success: function(data) {
          for(var i = 0; i < data.rows.length; i++) {
            $("<option value=" + data.rows[i].assetsname + ">" + data.rows[i].assetsname + "</option>").appendTo("select[name='assetsname']");
          }
        },
        error: function(data) {
          alert(data.msg)
        }
      });
    }
    //类别名称
    $.ajax({
      type: "post",
      url: "http://192.168.40.152:8080/ky/corp/selectCorp",
      contentType: "application/json;charset=utf-8",
      data: JSON.stringify({}),
      success: function(data) {
        var dat = [];
        for(var i = 0; i < data.rows.length; i++) {
          dat.push(data.rows[i].assetstype);
        }
        dat = replace(dat);

        $(".clo").each(function(){
          var apar=$(this);
          var atype=apar.children().find("select[name='assetstype']");
          var aname=apar.children().find("select[name='assetsname']");
          for(var i = 0; i < dat.length; i++) {
            $("<option value=" + dat[i] + " onclick='back(" + dat[i] + ");'>" + dat[i] + "</option>").appendTo("select[name='assetstype']");
          }

          $.each(atype, function() {
            //this是类别select
            $(this).change(function() { //change：每次选择选项获取选中值
              console.log(this);
              $.ajax({
                type: "post",
                url: "http://192.168.40.152:8080/ky/corp/findByAssType",
                contentType: "application/json;charset=utf-8",
                data: JSON.stringify({ "assetstype": $(this).val() }),
                cache: false,
                success: function(data) {
                  var uuu=$(this).parents(".clo").children("select[name='assetsname']");
                  aname.empty();
                  for (var i=0;i<data.rows.length;i++) {
                    aname.append("<option value='"+data.rows[i].assetsname+"' index="+i+">"+data.rows[i].assetsname+"</option>");
                  }
                  aname.change(function(){
                    var index=$(this).find("option:selected").index();
                    $(this).parents('.clo').find("input[name='assetsno']").val(data.rows[index].assetsno);
                    $(this).parents('.clo').find("input[name='buyprice']").val(data.rows[index].buyprice);
                    $(this).parents('.clo').find("textarea[name='note']").val(data.rows[index].buyprice);
                  })
                },
                error: function(data) {
                  alert(data.msg)
                }
              });

            })
          });
        })
        back(dat[0]);

      },
      error: function(data) {
        alert(data.msg)
      }
    });
    //提交资产
    $("#submit").click(function() {
      var json = {};
      json.userId1 = $("#userId1").val();
      json.userId2 = $("#userId2").val();
      json.lqTime = $("#lqTime").val();
      json.ghTime = $("#ghTime").val();
      json.list = [];
      for(var i = 0; i < $(".clo").length; i++) {
        var jj = {};
        jj.assetstype = $(".clo:eq(" + i + ") select[name='assetstype']").val();
        jj.assetsname = $(".clo:eq(" + i + ") select[name='assetsname']").val();
        jj.assetsno = $(".clo:eq(" + i + ") input[name='assetsno']").val();
        jj.buyprice = $(".clo:eq(" + i + ") input[name='buyprice']").val();
        jj.savepoint = $(".clo:eq(" + i + ") select[name='savepoint']").val();
        jj.note = $(".clo:eq(" + i + ") textarea[name='note']").val();
        json.list.push(jj);
      }
      console.log(JSON.stringify(json));
      $.ajax({
        type: "post",
        url: "http://192.168.40.152:8080/ky/bor/insertBoreturn",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(json),
        success: function(data) {
          alert(data.msg);
        },
        error: function(data) {
          alert(data.msg)
        }
      });
    })
    //jquery将表单序列化成json
    $.fn.serializeJson = function() {
      var serializeObj = {};
      var array = this.serializeArray();
      var str = this.serialize();
      $(array).each(function() {
        if(serializeObj[this.name]) {
          if($.isArray(serializeObj[this.name])) {
            serializeObj[this.name].push(this.value);
          } else {
            serializeObj[this.name] = [serializeObj[this.name], this.value];
          }
        } else {
          serializeObj[this.name] = this.value;
        }
      });
      return serializeObj;
    };
  });
</script>

</body>

</html>
