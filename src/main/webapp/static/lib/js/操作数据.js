$(function(){
	var oTable=$("#employee>tbody");
	for (var j=0;j<dataM[0].list.length;j++) {
		var tr=$("<tr></tr>");
		for (var i in dataM[0].list[j]) {
			var td=$("<td>"+dataM[0].list[j][i]+"</td>");
			td.appendTo(tr);
		}
		var td2=$('<td><a href="gl_addperson.html" data-toggle="modal" data-target="#myModal" ><i class="fa fa-edit text-navy"></i> 修改</a> <a href="#"><i class="fa fa-close text-danger"></i> 删除</a></td>');
		td2.appendTo(tr);
		tr.appendTo(oTable);
	}
	var xia=$("#employee>tbody>tr:eq("+this.index+")>td:eq(0)")
	$("#shazi").click(function(){ console.log(xia); })
		
	$("table tr").each(function() {    // 遍历每一行
	    $(this).children('td:eq(0)');  // td:eq(0)选择器表示第一个单元格
	});
	
	
	//jquery将表单序列化成json
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
    })(jQuery); 
    
    //显示form表单提交的数据
//	$("#submit").click( function () { console.log($("form").serialize()); });
	
    
//  $("#quxiao").click( function () { console.log($("form").serializeJson()); });
//	var can=$("form").serializeJson();
//	$('#addp').on('submit', function() {
//		$.ajax({
//			type: "POST",
//			url: "http://172.31.2.45:8080/ky/emp/insertEmp",
//			dataType: "json",
//			data: {can},
//			success: function(data) {
//				alert("已经成功！");
//				alert(data.id);   
//			},
//			error: function(e) {
//				alert("提交失败")
//			}
//		});
//	};

$("#submit").click(function(){
	alert("right  here ");
	$.ajax({
		type:"post",
		url:"http://172.31.2.45:8080/ky/emp/insertEmp",
		async:false,
		data:$("form").serializeJson(),
		dataType:"json",
		success:function(data){
			if(data.isSuccess == "1"){
				alert("success");
			}
		},error{
			alert("error");
		}
	});
});
	
//	$("#submit").click(
//		$.ajax({
//			type: "POST",
//			url: "http://172.31.2.45:8080/ky/emp/insertEmp",
//			dataType: "json",
//			data: $("form").serializeJson(),
//			success: function(data) {
//				alert("已经成功！");
//				alert(data.id);   
//			},
//			error: function(e) {
//				alert("提交失败")
//			}
//		});
//	);
})
	
