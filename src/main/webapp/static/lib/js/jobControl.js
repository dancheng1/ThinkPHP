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

	//添加岗位
    $("#addJob button#submit").click(function(){
    	$.ajax({
    		type:'post',
    		url:'http://192.168.40.152:8080/ky/job/insertJob',
    		contentType:"application/json;charset=utf-8",
    		data:JSON.stringify($("#addJob").serializeJson()),
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

  	//获取id
  	var backN="";
	var all=$("a.cha");
	$("a.cha").each(function(all){		
		$(this).click(function(){
			var back=$(this).parent().parent().children().eq(0).text();
			$.each($("#addJob").parents(), function() {
				if ($(this).hasClass('modal-content')) {
					$(".ibox-title h2").text('修改岗位信息');
					$("#addJob button#submit").hide();
					$("#addJob button#change").show();
					$.ajax({
						type:"post",
						url:"http://192.168.40.152:8080/ky/emp/editEmp",
						data:JSON.stringify({"id":back}),
						cache:false,
						contentType:"application/json;charset=utf-8",
						success:function(data){
							alert(data.msg);
							backNum(data,"#addJob")
							console.log(back+"回显成功："+data);
						},
						error:function(data){
							alert(data.isSuccess);
							console.log("回显失败："+data);
						}
					});

					//员工更新
					$("#addJob button#change").click(function(){
						console.log(JSON.stringify($("#addJob").serializeJson()));
						$.ajax({
							type:'post',
							url:'http://192.168.40.152:8080/ky/emp/updateEmp',
							contentType:"application/json;charset=utf-8",
							data:JSON.stringify($("#addJob").serializeJson()),
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

	//岗位显示
	$.ajax({
		type:'post',
		url:'http://192.168.40.152:8080/ky/job/selectJob',
		contentType:"application/json;charset=utf-8",
		data:{},
		success:function(data){
			showJob(data);
			alert(data.msg);
		},
		error:function(data){
			alert("岗位显示错误")
		}
	})
	function showJob(data){
        console.log(data);
        for (var i = 0;i<data.rows.length; i++) {
        	var tr=$("<tr></tr>");
        	var td1=$("<td class='col-sm-1 col-sm-offset-1'><input type='hidden' value="+data.rows[i].position_id+"/>"+data.rows[i].position_id+"</td>").appendTo(tr);
	        var td2=$("<td class='col-sm-1'>"+data.rows[i].position_name+"</td>").appendTo(tr);
	        var td3=$("<td class='col-sm-2'><input type='datetime-local' disabled class='form-control input-sm' value="+data.rows[i].create_date+"></td>").appendTo(tr);
	        var td4=$("<td class='col-sm-1'>"+data.rows[i].create_by+"</td>").appendTo(tr);
	        var td5=$("<td class='col-sm-2'><input type='datetime-local' disabled class='form-control input-sm' value="+data.rows[i].update_date+"></td>").appendTo(tr);
	        var td6=$("<td class='col-sm-1'>"+data.rows[i].update_by+"</td>").appendTo(tr);
	        var td7=$("<td class='col-sm-1'><a href='insert'><i class='fa fa-edit text-navy'></i> 修改</a> <a href='/job/deleteJob'><i class='fa fa-close text-danger'></i> 删除</a></td>").appendTo(tr);
	        tr.appendTo($("#job>tbody"));
        }
    }
    
})
	
