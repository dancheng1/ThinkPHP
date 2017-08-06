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

  	//获取id
	var all=$("a.cha");
	$("a.cha").each(function(){		
		$(this).click(function(){
			var back=$(this).parent().parent().children().eq(0).text();
			$.each($("#addzc").parents(), function() {
				if ($(this).hasClass('modal-content')) {
					$(".ibox-title h2").text('修改资产信息');
					$("#addzc button#submit").hide();
					$("#addzc button#change").show();
					$.ajax({
						type:"post",
						url:"http://192.168.40.152:8080/ky/emp/editEmp",
						data:JSON.stringify({"assetsno":back}),
						cache:false,
						contentType:"application/json;charset=utf-8",
						success:function(data){
							alert(data.msg);
							backNum(data,"#addzc")
							console.log(back+"回显成功："+data);
						},
						error:function(data){
							alert(data.isSuccess);
							console.log("回显失败："+data);
						}
					});

					//资产更新
					$("#addzc button#change").click(function(){
						console.log(JSON.stringify($("#addzc").serializeJson()));
						$.ajax({
							type:'post',
							url:'http://192.168.40.152:8080/ky/emp/updateEmp',
							contentType:"application/json;charset=utf-8",
							data:JSON.stringify($("#addzc").serializeJson()),
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
	
	//资产显示
	$.ajax({
		type:"post",
		url:"http://192.168.40.152:8080/ky/corp/selectCorp",
		data:JSON.stringify({}),
		contentType:"application/json;charset=utf-8",
		success:function(data){
			showZc(data);
			console.log("data.rows"+data.rows);
		},
		error:function(data){
			console.log(data);
		}
	});
	
	function showZc(data){
		tbody=$("#zc>tbody");
        for ( var i = 0; i < data.rows.length; i++)
        {
            var tr=$("<tr></tr>").appendTo(tbody);
            var obj = data.rows[i];
       		var td1=$("<td>"+obj.assetsno+"</td>").appendTo(tr);
       		var td2=$("<td>"+obj.assentstype+"</td>").appendTo(tr);
       		var td3=$("<td>"+obj.assentsname+"</td>").appendTo(tr);
       		var td4=$("<td>"+obj.userperson+"</td>").appendTo(tr);
       		var td5=$("<td>"+obj.savestate+"</td>").appendTo(tr);
       		var td6=$("<td>"+obj.useplace+"</td>").appendTo(tr);
       		var td7=$("<td>"+obj.receivetime+"</td>").appendTo(tr);
       		var td8=$("<td>"+obj.returntime+"</td>").appendTo(tr);
       		var td9=$("<td>"+obj.auditperson+"</td>").appendTo(tr);
       		var td10=$("<td>"+obj.buyperson+"</td>").appendTo(tr);
       		var td11=$("<td>"+obj.buyprice+"</td>").appendTo(tr);
       		var td12=$("<td>"+obj.buyon+"</td>").appendTo(tr);
       		var td13=$("<td>"+obj.danwei+"</td>").appendTo(tr);
       		var td14=$("<td>"+obj.note+"</td>").appendTo(tr);
       		var tdcon=$("<td><a href='gl_addzc.html' class='cha' data-toggle='modal' data-target='#myModal'><i class='fa fa-edit text-navy'></i> 修改</a><a href='javascript:void(0);' class='del'><i class='fa fa-close text-danger'></i> 删除</a></td>").appendTo(tr);
        }
    };

})
	
