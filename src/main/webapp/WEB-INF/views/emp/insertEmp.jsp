<%--
  Created by IntelliJ IDEA.
  User: 13455
  Date: 2017/1/10
  Time: 15:06
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
    <link href="${pageContext.request.contextPath}/static/lib/css/style.min.css" rel="stylesheet">

</head>

<body>
<div class="wrapper wrapper-content animated fadeInRight">
<div class="row">
<div class="col-sm-12">
<div class="ibox float-e-margins emp">
<div class="ibox-title row">
    <div class="col-sm-4 col-sm-offset-5">
        <h2>添加员工</h2>
    </div>
    <a class="fa fa-close pull-right"  data-dismiss="modal"></a>
</div>
<div class="ibox-content">
<form role="form" class="form-inline m-t" id="addp">
<div class="row m-t-md">
    <h4>基本信息</h4>
    <hr />
</div>
<div class="row">
    <div class="form-group col-sm-4">
        <label for="id">员工编号</label>
        <input type="text" placeholder="请输入员工编号" id="id" class="form-control" name="id" maxlength="4" required>
    </div>
    <div class="form-group col-sm-4">
        <label for="employee_name">员工姓名</label>
        <input type="text" id="employee_name" class="form-control" name="employee_name" placeholder="请输入员工姓名" maxlength="10" required onchange="if(/^[\u0391-\uFFE5]+$/gi.test(this.value)?true:false){return this.value;}else{alert('请输入中文');}">
    </div>
    <div class="form-group col-sm-4">
        <label for="id_number">身份证号</label>
        <input type="text" id="id_number" class="form-control" name="id_number" placeholder="请输入身份证号" maxlength="18" required onchange="if(/^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/gi.test(this.value)?true:false){return;}else{alert('输入有误');}">
    </div>
</div>
<div class="row m-t-md">
    <div class="form-group col-sm-4">
        <label for="email">电子邮箱</label>
        <input type="email" id="email" class="form-control" name="email" maxlength=20 placeholder="请输入邮箱" required>
    </div>
    <div class="form-group col-sm-4">
        <label for="mobile_number">联系电话</label>
        <input type="text" id="mobile_number" class="form-control" name="mobile_number" placeholder="请输入联系电话" required  maxlength=11 onchange="if(/\d{11}/gi.test(this.value)?true:false){return;}else{alert('电话号码11位数');}">
    </div>
    <div class="form-group col-sm-4">
        <label for="birthday">出生日期</label>
        <input type="datetime-local" id="birthday" class="form-control" name="birthday" value="2017/01/01 00:00">
    </div>
</div>
<div class="row m-t-md">
    <div class="form-group col-sm-4">
        <label for="zip_code_1">居住地邮编</label>
        <input type="text" id="zip_code_1" class="form-control" name="zip_code_1" placeholder="请输入邮编1" maxlength=6 onchange="if(/\d{6}/gi.test(this.value)?true:false){return this.value;}else{alert('邮编六位数');}">
    </div>
    <div class="form-group col-sm-4">
        <label for="zip_code_2">户口所在地邮编</label>
        <input type="text" id="zip_code_2" class="form-control" name="zip_code_2" placeholder="请输入邮编2" maxlength=6 onchange="if(/\d{6}/gi.test(this.value)?true:false){return this.value;}else{alert('邮编六位数');}">
    </div>
    <div class="form-group col-sm-4">
        <label for="emergency_call">紧急联系电话</label>
        <input type="text" id="emergency_call" class="form-control" name="emergency_call" placeholder="请输入紧急联系电话"  maxlength=11 onchange="if(/\d{11}/gi.test(this.value)?true:false){return;}else{alert('电话号码11位数');}">
    </div>
</div>
<div class="row m-t-md">
    <div class="form-group col-sm-4">
        <label for="address">居住地址</label>
        <textarea id="address" class="form-control" name="address" placeholder="请输入居住地" style="resize: none;"></textarea>
    </div>
    <div class="form-group col-sm-4">
        <label for="account_location">户口所在地</label>
        <textarea id="account_location" class="form-control" name="account_location" placeholder="请输入户口所在地" style="resize: none;"></textarea>
    </div>
    <div class="form-group col-sm-4">
        <label for="file_location">档案所在地</label>
        <textarea id="file_location" class="form-control" name="file_location" placeholder="请输入档案所在地" style="resize: none;"></textarea>
    </div>
</div>
<div class="row m-t-md">
    <div class="form-group col-sm-4">
        <label for="sex">性别</label>
        <div class="radio i-checks" id="sex">
            <label><input type="radio" checked="" value="1" name="sex"> <i></i> 男</label>
            <label><input type="radio" value="0" name="sex"> <i></i> 女</label>
        </div>
    </div>
    <div class="form-group col-sm-4">
        <label for="political_status">政治面貌</label>
        <div class="radio i-checks" id="political_status">
            <label><input type="radio" checked="" value="团员" name="political_status"> <i></i> 团员</label>
            <label><input type="radio" value="党员" name="political_status"> <i></i> 党员</label>
        </div>
    </div>
    <div class="form-group col-sm-4">
        <label for="marred">婚否</label>
        <div class="radio i-checks" id="marred">
            <label><input type="radio" checked="" value="已婚" name="marred"> <i></i> 已婚</label>
            <label><input type="radio" value="未婚" name="marred"> <i></i> 未婚</label>
        </div>
    </div>
</div>
<div class="row m-t-md">
    <div class="form-group col-sm-4">
        <label for="file_location_type">档案管理形式</label>
        <select id="file_location_type" class="form-control" name="file_location_type">
            <option value="1">人事局</option>
            <option value="2">个人</option>
        </select>
    </div>
</div>
<hr />
<div class="row m-t-md">
    <h4>社保信息</h4>
    <hr />
</div>
<div class="row m-t-md">
    <div class="form-group col-sm-4">
        <label for="provident_fund">是否缴纳公积金</label>
        <div class="radio i-checks" id="provident_fund">
            <label><input type="radio" checked="" value="1" name="provident_fund"> <i></i> 是</label>
            <label><input type="radio" value="0" name="provident_fund"> <i></i> 否</label>
        </div>
    </div>
    <div class="form-group col-sm-4">
        <label for="provident_fund_type">公积金形式</label>
        <select class="form-control" id="provident_fund_type" name="provident_fund_type">
            <option value="1">公积金形式1</option>
            <option value="2">公积金形式2</option>
            <option value="3">公积金形式3</option>
        </select>
    </div>
    <div class="form-group col-sm-4">
        <label for="provident_fund_number">公积金号码</label>
        <input type="text" id="provident_fund_number" class="form-control" name="provident_fund_number" placeholder="请输入公积金号码">
    </div>
</div>

<div class="row m-t-md">
    <div class="form-group col-sm-4">
        <label for="social_insurance">是否缴纳社会保险</label>
        <div class="radio i-checks" id="social_insurance">
            <label><input type="radio" checked="" value="1" name="social_insurance"> <i></i> 是</label>
            <label><input type="radio" value="0" name="social_insurance"> <i></i> 否</label>
        </div>
    </div>
    <div class="form-group col-sm-4">
        <label for="social_insurance_type">保险形式</label>
        <select class="form-control" id="social_insurance_type" name="social_insurance_type">
            <option value="1">保险形式1</option>
            <option value="2">保险形式2</option>
            <option value="3">保险形式3</option>
        </select>
    </div>
    <div class="form-group col-sm-4">
        <label for="social_security_number">社保卡号码</label>
        <input type="text" id="social_security_number" class="form-control" name="social_security_number" placeholder="请输入社保卡号码">
    </div>
</div>
<div class="row m-t-md">
    <div class="form-group col-sm-4">
        <label for="social_security_kind">社会保险险种</label>
        <select id="social_security_kind" class="form-control" name="social_security_kind">
            <option value="1">险种1</option>
            <option value="2">险种2</option>
            <option value="3">险种4</option>
        </select>
    </div>
</div>
<hr />
<div class="row m-t-md">
    <h4>其他信息</h4>
    <hr />
</div>
<div class="row m-t-md">
    <div class="form-group col-sm-2">
        <label for="depart_id">所属部门</label>
        <select name="depart_id" id="depart_id" class="form-control">
            <option value="d1">开发部</option>
            <option value="s1">销售部</option>
            <option value="t1">测试部</option>
        </select>
    </div>
    <div class="form-group col-sm-2">
        <label for="position_id">职位</label>
        <select name="position_id" id="position_id" class="form-control">
            <option value="01">java</option>
            <option value="02">web前端</option>
            <option value="03">测试</option>
        </select>
    </div>
    <div class="form-group col-sm-4">
        <label for="entry_time">入职时间</label>
        <input type="datetime-local" id="entry_time" class="form-control" name="entry_time" value="2017/01/01 00:00" >
    </div>
    <div class="form-group col-sm-4">
        <label for="work_experience">工作年限</label>
        <input type="number" id="work_experience" class="form-control" name="work_experience" min="0" placeholder="请输入工作年限" >
    </div>
</div>
<div class="row m-t-md">
    <div class="form-group col-sm-4">
        <label for="employee_state">在职状态</label>
        <div class="radio i-checks" id="employee_state">
            <label><input type="radio" checked="" value="1" name="employee_state"> <i></i> 在职</label>
            <label><input type="radio" value="0" name="employee_state"> <i></i> 离职</label>
        </div>
    </div>
    <div class="form-group col-sm-4">
        <label for="create_date">录入时间</label>
        <input type="datetime-local" id="create_date" class="form-control" name="create_date" value="2017/01/01 00:00">
    </div>
    <div class="form-group col-sm-4">
        <label for="create_by">录入人</label>
        <input type="text" id="create_by" class="form-control" name="create_by" placeholder="请输入录入人"  maxlength="10"  onchange="if(/^[\u0391-\uFFE5]+$/gi.test(this.value)?true:false){return this.value;}else{alert('请输入中文');}">
    </div>
</div>
<div class="row m-t-md">
    <div class="form-group col-sm-4">
        <label for="update_date">更新时间</label>
        <input type="datetime-local" id="update_date" class="form-control" name="update_date" value="2017/01/01 00:00">
    </div>
    <div class="form-group col-sm-4">
        <label for="update_by">更新人</label>
        <input type="text" id="update_by" class="form-control" name="update_by" placeholder="请输入更新人"  maxlength="10"  onchange="if(/^[\u0391-\uFFE5]+$/gi.test(this.value)?true:false){return this.value;}else{alert('请输入中文');}">
    </div>
</div>
<div class="row m-t-md">
    <div class="form-group col-sm-4 col-sm-offset-4">
        <button class="btn btn-primary" type="submit" id="submit">提交</button>
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
<script src="${pageContext.request.contextPath}/static/lib/js/empControl.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green"});

        /*//jquery将表单序列化成json
        (function($){
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
        })(jQuery);*/
        $("#submit").click(function () {
            alert("right here");
            params = {};
            params.id = $("#id").val();
            params.employeeName = $("#employee_name").val();
            params.idNumber = $("#id_number").val();
            params.email = $("#email").val();
            params.mobileNumber = $("#mobile_number").val();
            params.birthday = $("#birthday").val();
            params.zipCode1 = $("#zip_code_1").val();
            params.zipCode2 = $("#zip_code_2").val();
            params.emergencyCall = $("#emergency_call").val();
            params.address = $("#address").val();
            params.accountLocation = $("#account_location").val();
            params.fileLocation = $("#file_location").val();
            params.sex = $("#sex").val();
            params.politicalStatus = $("#political_status").val();
            params.marred = $("#marred").val();
            params.fileLocationType = $("#file_location_type").val();
            params.providentFund = $("#provident_fund").val();
            params.providentFundType = $("#provident_fund_type").val();
            params.providentFundNumber = $("#provident_fund_number").val();
            params.socialInsurance = $("#social_insurance").val();
            params.socialInsuranceType = $("#social_insurance_type").val();
            params.socialSecurityNumber = $("#social_security_number").val();
            params.socialSecurityKind = $("#social_security_kind").val();
            params.departId = $("#depart_id").val();
            params.positionId = $("#position_id").val();
            params.entryTime = $("#entry_time").val();
            params.workExperience = $("#work_experience").val();
            params.employeeState = $("#employee_state").val();
            alert(JSON.stringify(params));
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/emp/insertEmp",
                async: false,
                data: JSON.stringify(params),
                dataType: "json",
                contentType:"application/json;charset=UTF-8",
                success: function (data) {
                    alert(data.isSuccess);
                }
            });
        });

    });

</script>

</body>
</html>
