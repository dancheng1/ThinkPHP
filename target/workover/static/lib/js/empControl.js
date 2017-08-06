$(function(){
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
    $("input[disabled]").css('background','#fff');
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

	//员工添加
	$("#addp button#submit").click(function(){
		$.ajax({
			type:"post",
			url:"http://192.168.40.152:8080/ky/emp/insertEmp",
			contentType:"application/json;charset=utf-8",
			data:JSON.stringify($("#addp").serializeJson()),
			success:function(data){
				alert("员工添加"+data.msg);
				console.log(data);
			},
			error:function(data){
				alert("员工添加"+data.msg);
			}
		});
	});

  	//获取id
	var all=$("a.cha");
	$("a.cha").each(function(){
		$(this).click(function(){
			var back=$(this).parent().parent().children().eq(0).text();
			$.each($("#addp").parents(), function() {
				if ($(this).hasClass('modal-content')) {
					$(".ibox-title h2").text('修改员工信息');
					$("#addp button#submit").hide();
					$("#addp button#change").show();
					$.ajax({
						type:"post",
						url:"http://192.168.40.152:8080/ky/emp/editEmp",
						data:JSON.stringify({"id":back}),
						cache:false,
						contentType:"application/json;charset=utf-8",
						success:function(data){
							alert(data.msg);
							backNum(data,"#addp")
							console.log(back+"回显成功："+data);
						},
						error:function(data){
							alert(data.isSuccess);
							console.log("回显失败："+data);
						}
					});

					//员工更新
					$("#addp button#change").click(function(){
						console.log(JSON.stringify($("#addp").serializeJson()));
						$.ajax({
							type:'post',
							url:'http://192.168.40.11:8081/ky/emp/updateEmp',
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
				
			});
		})
	})
	
	
	
	// 员工信息显示
	/*
	var params ={};
	$.ajax({
		type:"post",
		url:"http://192.168.40.152:8080/ky/emp/selectEmp",
		contentType:"application/json;charset=utf-8",
		data:JSON.stringify(params),
		success:function(data){
			showEm(data);
			alert("员工信息显示成功");
		},
		error:function(data){
			console.log(data);
			alert("员工信息显示失败");
		}
	});
	function showEm(data){
		tbody=$("#employee>tbody");
        for ( var i = 0; i < data.rows.length; i++)
        {
            var tr=$("<tr></tr>").appendTo(tbody);
            var obj = data.rows[i];
       		var td1=$("<td><input type='hidden' value="+obj.id+" />"+obj.id+"</td>").appendTo(tr);
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
       		var tdcon=$("<td><a href='http://192.168.40.152:8080/ky/views/emp/insertEmp' class='cha'  data-toggle='modal' data-target='#myModal'><i class='fa fa-edit text-navy'></i> 修改</a></td>").appendTo(tr);
        }
    }
    */


	

})
	
