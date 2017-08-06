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

	//新增部门
	$("#addDep button#submit").click(function(){
		console.log(JSON.stringify($("#addDep").serializeJson()));
		$.ajax({
			type:"post",
			url:'http://192.168.40.152:8080/ky/dep/insertDepartment',
			contentType:"application/json;charset=utf-8",
			data:JSON.stringify($("#addDep").serializeJson()),
			success:function(data){
				alert(data.msg);
				console.log(data);
			},
			error:function(data){
				alert(data.msg);
				console.log(data);
			}
		})
	})

	//部门显示
	params = {};
	$.ajax({
		type:'POST',
		url:'http://192.168.40.152:8080/ky/dep/selectAll',
		contentType:"application/json;charset=utf-8",
		data:JSON.stringify(params),
		success:function(data){
			showDep(data);
			alert(data.msg);
			console.log(data);
		},
		error:function(data){
			alert(data.msg);
			console.log(data);
		}
	})
	function showDep(data){
		console.log(data.rows.length);
		for (var i =0 ; i< data.rows.length ; i++) {
			var tr=$("<tr></tr>");
			var td1=$("<td><input type='hidden' value="+data.rows[i].dept_id+"/>"+data.rows[i].dept_id+"</td>").appendTo(tr);
			var td2=$("<td>"+data.rows[i].dept_name+"</td>").appendTo(tr);
			var td3=$("<td><input type='datetime-local' disabled class='form-control' value="+data.rows[i].established+"></td>").appendTo(tr);
			var td4=$("<td>"+data.rows[i].update_by+"</td>").appendTo(tr);
			var td5=$("<td><input type='datetime-local' disabled class='form-control' value="+data.rows[i].update_date+"></td>").appendTo(tr);
			var td6=$("<td>"+data.rows[i].create_by+"</td>").appendTo(tr);
			var td7=$("<td><input type='datetime-local' disabled class='form-control' value="+data.rows[i].create_date+"></td>").appendTo(tr);
			var td8=$("<td><a href='insert' class='cha'  data-toggle='modal' data-target='#myModal' onclick='edit("+data.rows[i].id+")'><i class='fa fa-edit text-navy'></i> 修改</a><a href='#'><i class='fa fa-close text-danger'></i> 删除</a></td>").appendTo(tr);
			tr.appendTo($("#depart>tbody"));
		}
	};

	function edit(id) {
		dd = {};
		dd.id = id;
		//获取id
		var all=$("a.cha");
		$("a.cha").each(function(){
			$(this).click(function(){
				var back=$(this).parent().parent().children().eq(0).text();
				$.each($("#addDep").parents(), function() {
					if ($(this).hasClass('dep')) {
						$(".dep h2").text('修改部门信息');
						$("#addDep button#submit").hide();
						$("#addDep button#change").show();
					}
				});
				$.ajax({
					type:"POST",
					url:"http://192.168.40.152:8080/ky/dep/editEmp",
					data:JSON.stringify({"id":back}),
					cache:false,
					contentType:"application/json;charset=utf-8",
					success:function(data){
						alert(data.msg);
						backNum(data,"#addDep")
						console.log(back+"回显成功："+data);
					},
					error:function(data){
						alert(data.isSuccess);
						console.log("回显失败："+data);
					}
				});
			})
		})
		//部门更新
		$("#addDep button#change").click(function () {
			alert('click change');
			console.log(JSON.stringify($("#addDep").serializeJson()));
			$.ajax({
				type: 'POST',
				url: 'http://192.168.40.152:8080/ky/dep/updateEmp',
				contentType: "application/json;charset=utf-8",
				data: JSON.stringify($("#addDep").serializeJson()),
				success: function (data) {
					alert(data.msg);
					console.log(data);
				},
				error: function (data) {
					alert(data.msg);
					console.log(data);
				}
			})
		});
	}
})
	
