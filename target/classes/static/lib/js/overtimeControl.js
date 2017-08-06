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
		//信息回显在输入框内
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

  	//获取id
	var all=$("a.cha");
	$("a.cha").each(function(all){		
		$(this).click(function(){
			var back=$(this).parent().parent().children().eq(0).text();
			$.each($("#changeOvetime").parents(), function() {
				if ($(this).hasClass('modal-content')) {
					$.ajax({
						type:"post",
						url:"http://192.168.40.152:8080/ky/work/editWork",
						data:JSON.stringify({"id":back}),
						cache:false,
						contentType:"application/json;charset=utf-8",
						success:function(data){
							alert(data.msg);
							backNum(data,"#changeOvetime")
							console.log(back+"回显成功："+data);
						},
						error:function(data){
							alert(data.isSuccess);
							console.log("回显失败："+data);
						}
					});

					//员工加班信息更新
					$("#changeOvetime button#change").click(function(){
						console.log(JSON.stringify($("#changeOvetime").serializeJson()));
						$.ajax({
							type:'post',
							url:'http://192.168.40.152:8080/ky/work/updateWork',
							contentType:"application/json;charset=utf-8",
							data:JSON.stringify($("#changeOvetime").serializeJson()),
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
	
	
	
	// 加班信息显示
	$.ajax({
		type:"post",
		url:"http://192.168.40.152:8080/ky/work/findAll",
		contentType:"application/json;charset=utf-8",
		data:JSON.stringify({}),
		success:function(data){
			showEm(data);
			alert("加班信息显示成功");
		},
		error:function(data){
			console.log(data);
			alert("加班信息显示失败");
		}
	});
	function showEm(data){
		tbody=$("#overtime>tbody");
        for ( var i = 0; i < data.rows.length; i++)
        {
            var tr=$("<tr></tr>").appendTo(tbody);
            var obj = data.rows[i];
       		var td1=$("<td>"+obj.id+"</td>").appendTo(tr);
       		var td2=$("<td>"+obj.personno+"</td>").appendTo(tr);
       		var td3=$("<td>"+obj.personname+"</td>").appendTo(tr);
       		var td4=$("<td>"+obj.currentdate+"</td>").appendTo(tr);
       		var td5=$("<td>"+obj.starttime+"</td>").appendTo(tr);
       		var td6=$("<td>"+obj.endtime+"</td>").appendTo(tr);
       		var td7=$("<td>"+obj.lehgthtime+"</td>").appendTo(tr);
       		var td8=$("<td>"+obj.workcost+"</td>").appendTo(tr);
       		var td9=$("<td>"+obj.mealcost+"</td>").appendTo(tr);
       		var td10=$("<td>"+obj.trafficcost+"</td>").appendTo(tr);
       		var td11=$("<td>"+obj.suncost+"</td>").appendTo(tr);
       		var td12=$("<td>"+obj.year+"</td>").appendTo(tr);
       		var td13=$("<td>"+obj.mouth+"</td>").appendTo(tr);
       		var td14=$("<td>"+obj.creatBy+"</td>").appendTo(tr);
       		var td15=$("<td>"+obj.creattime+"</td>").appendTo(tr);
       		var td16=$("<td>"+obj.updateby+"</td>").appendTo(tr);
       		var td17=$("<td>"+obj.updatetime+"</td>").appendTo(tr);
       		var tdcon=$("<td><a data-toggle='modal' href='update' data-target='#myModal' class='cha' ><i class='fa fa-edit text-navy'></i> 修改</a><a href='javascript:void(0);' class='del'><i class='fa fa-close text-danger'></i> 删除</a></td>").appendTo(tr);
        }
    }
	

})
	
