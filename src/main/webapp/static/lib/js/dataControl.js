$(function(){
	// 员工信息显示
	(function(){
		alert("员工信息显示");
		$.ajax({
			type:"post",
			url:"/emp/selectEmp",
			async:true,
			contentType:"application/json;charset=UTF-8",
			success:function(data){
				alert(JSON.stringify(data));
				console.log(JSON.stringify(data))
				//showEm(data);
			},
			error:function(data){
				alert(data.isSuccess)
			}
		});
		function showEm(data){
				tbody=$("#employee>tbody");
				for ( var i in data.rows.length)
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
				var tdcon=$("<td><a href='#'><i class='fa fa-edit text-navy'></i> 修改</a><a href='#'><i class='fa fa-close text-danger'></i> 删除</a></td>").appendTo(tr);
			}
		}
	})();


})

