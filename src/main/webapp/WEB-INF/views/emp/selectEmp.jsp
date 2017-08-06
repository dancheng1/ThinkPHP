<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
    <link href="${pageContext.request.contextPath}/static/lib/css/plugins/footable/footable.core.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/static/lib/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/lib/css/style.min.css" rel="stylesheet">
    <%--<base target="_blank">--%>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>员工信息</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link" title="折叠">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a href="insert" target="_self" title="添加员工">
                            <i class="fa fa-plus"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <input type="text" class="form-control input-sm m-b-xs" id="filter" placeholder="搜索表格...">
                    <table id="employee" class="footable table table-stripped toggle-arrow-tiny" data-page-size="8" data-filter=#filter>
                        <thead>
                        <tr>
                            <th data-toggle="true">员工编号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>邮箱</th>
                            <th>电话</th>
                            <th>职位</th>
                            <th>所属部门</th>
                            <th>婚否</th>
                            <th>出生日期</th>
                            <th>工作年限</th>
                            <th data-hide="all">居住地</th>
                            <th data-hide="all">户口所在地</th>
                            <th data-hide="all">政治面貌</th>
                            <th data-hide="all">身份证号</th>
                            <th data-hide="all">邮编1</th>
                            <th data-hide="all">邮编2</th>
                            <th data-hide="all">紧急电话</th>
                            <th data-hide="all">档案所在地</th>
                            <th data-hide="all">档案管理形式</th>
                            <th data-hide="all">入职时间</th>
                            <th data-hide="all">在职状态</th>
                            <th data-hide="all">录入时间</th>
                            <th data-hide="all">录入人</th>
                            <th data-hide="all">更新时间</th>
                            <th data-hide="all">更新人</th>
                            <th data-hide="all">是否缴纳社会保险</th>
                            <th data-hide="all">保险形式</th>
                            <th data-hide="all">社保卡号码</th>
                            <th data-hide="all">社会保险险种</th>
                            <th data-hide="all">是否缴纳公积金</th>
                            <th data-hide="all">公积金形式</th>
                            <th data-hide="all">公积金号码</th>
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
<script src="${pageContext.request.contextPath}/static/lib/js/plugins/footable/footable.all.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/content.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/js/empControl.js"></script>

<script>
    $(document).ready(function(){$(".footable").footable();$(".footable2").footable()

        params = {};
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/emp/selectEmp",
            data:JSON.stringify(params),
            async:false,
            contentType:"application/json;charset=UTF-8",
            success:function(data){
                showEm(data);
            },
            error:function(data){
                alert(data.isSuccess)
            }
        });
        function showEm(data){
            tbody=$("#employee>tbody");
            for ( var i =0;i< data.rows.length;i++)
            {
                var tr=$("<tr></tr>").appendTo(tbody);
                var obj = data.rows[i];
                var td1=$("<td>"+obj.id+"</td>").appendTo(tr);
                var td2=$("<td>"+obj.employeeName+"</td>").appendTo(tr);
                var td3=$("<td>"+obj.sex+"</td>").appendTo(tr);
                var td4=$("<td>"+obj.email+"</td>").appendTo(tr);
                var td5=$("<td>"+obj.mobileNumber+"</td>").appendTo(tr);
                var td6=$("<td>"+obj.positionId+"</td>").appendTo(tr);
                var td7=$("<td>"+obj.departId+"</td>").appendTo(tr);
                var td8=$("<td>"+obj.marred+"</td>").appendTo(tr);
                var td9=$("<td>"+obj.birthday+"</td>").appendTo(tr);
                var td10=$("<td>"+obj.workExperience+"</td>").appendTo(tr);
                var td11=$("<td>"+obj.address+"</td>").appendTo(tr);
                var td12=$("<td>"+obj.accountLocation+"</td>").appendTo(tr);
                var td13=$("<td>"+obj.politicalStatus+"</td>").appendTo(tr);
                var td14=$("<td>"+obj.idNumber+"</td>").appendTo(tr);
                var td15=$("<td>"+obj.zipCode1+"</td>").appendTo(tr);
                var td16=$("<td>"+obj.zipCode2+"</td>").appendTo(tr);
                var td17=$("<td>"+obj.emergencyCall+"</td>").appendTo(tr);
                var td18=$("<td>"+obj.fileLocation+"</td>").appendTo(tr);
                var td19=$("<td>"+obj.fileLocationType+"</td>").appendTo(tr);
                var td20=$("<td>"+obj.entryTime+"</td>").appendTo(tr);
                var td21=$("<td>"+obj.employeeState+"</td>").appendTo(tr);
                var td22=$("<td>"+obj.createDate+"</td>").appendTo(tr);
                var td23=$("<td>"+obj.createBy+"</td>").appendTo(tr);
                var td24=$("<td>"+obj.updateDate+"</td>").appendTo(tr);
                var td25=$("<td>"+obj.updateBy+"</td>").appendTo(tr);
                var td26=$("<td>"+obj.socialInsurance+"</td>").appendTo(tr);
                var td27=$("<td>"+obj.socialInsuranceType+"</td>").appendTo(tr);
                var td28=$("<td>"+obj.socialSecurityNumber+"</td>").appendTo(tr);
                var td29=$("<td>"+obj.socialSecurityKind+"</td>").appendTo(tr);
                var td30=$("<td>"+obj.providentFund+"</td>").appendTo(tr);
                var td31=$("<td>"+obj.providentFundType+"</td>").appendTo(tr);
                var td32=$("<td>"+obj.providentFundNumber+"</td>").appendTo(tr);
                var tdcon=$("<td><a href='insert' class='cha'  data-toggle='modal' data-target='#myModal' onclick='edit("+obj.id+")'><i class='fa fa-edit text-navy'></i> 修改</a><!--<a href='#'><i class='fa fa-close text-danger'></i> 删除</a>--></td>").appendTo(tr);
//                var tdcon=$("<td><a href='insert' class='cha' onclick='edit("+obj.id+")'><i class='fa fa-edit text-navy'></i> 修改</a><!--<a href='#'><i class='fa fa-close text-danger'></i> 删除</a>--></td>").appendTo(tr);
            }
        }
        function edit(id){
            params = {};
            params.id = id;
            var all=$("a.cha");
            $("a.cha").each(function(){
                $(this).click(function(){
                    var back=$(this).parent().parent().children().eq(0).text();
                    $.each($("#addp").parents(), function() {
                        if ($(this).hasClass('modal-content')) {
                            $(".emp h2").text('修改员工信息');
                            $("#addp button#submit").hide();
                            $("#addp button#change").show();
                        }
                    });
                })
            })
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/emp/editEmp",
                data:JSON.stringify({"id":params.id}),
                contentType:"application/json;charset=UTF-8",
                success:function(data){
                    alert("back"+data.msg);
                    backNum(data,"#addp");
                    //                showEm(data);

                },
                error:function(data){
                    alert(data.isSuccess);
                }
            });

            //员工更新
            $("#addp button#change").click(function(){
                alert('click change');
                console.log(JSON.stringify($("#addp").serializeJson()));
                $.ajax({
                    type:'post',
                    url:'http://192.168.40.152:8080/ky/emp/updateEmp',
                    contentType:"application/json;charset=utf-8",
                    data:JSON.stringify($("#addp").serializeJson()),
                    success:function(data){
                        alert(data.msg);
                        console.log(data);
                    },
                    error:function(data){
                        alert(data.msg);
                        console.log(data);
                    }
                })
            });
        }

        function backNum(data,space){
            //修改人员回显
            //输入框和文本域
            var inp=$(space).find('input[id],textarea');
            for(var i=0;i<inp.length;i++){
                for (var key in data.rows) {
                    $.each(inp,function() {
                        if ($(this).attr('name')==key) {
                            var n=$(this).attr('name');
                            if (this.tagName=='TEXTAREA') {
                                $(this).html(data.rows[n]);
                            }else{
                                $(this).attr('value',data.rows[n]);
                            }
                        }
                    });
                }
            }
            //单选
            var rad=$(space+" input[type='radio']");
            for (var key in data.rows) {
                $.each(rad,function(){
                    var name=$(this).attr('name');
                    var value=$(this).attr('value');
                    if (name==key&&value==data.rows[key]) {
                        $(this).attr("checked","checked");
                        $(this).parent().addClass("checked");
                    }
                });
            }
            //下拉
            var sel=$(space+" select");
            $("select").each(function(){
                $(this).children("option").each(function(){
                    for (var key in data.rows) {
                        if ($(this).parent('select').attr('name')==key) {
                            if ($(this).attr('value')==data.rows[key]) {
                                $(this).attr('selected','selected');
                            }
                        }
                    }
                });
            });
        }


    });


</script>

</body>

</html>