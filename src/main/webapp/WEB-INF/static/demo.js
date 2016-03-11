/**
 * 增加按钮响应函数
 */
function add(){
//打开新页面
//	window.parent.f_addTab("132456677899", "增加", "http://demo.gzl.com.cn:8089/tbsp-appdemo-web/demo/demoSave.html");
//	$.ligerDialog.open({title:"demo",height: 400,width: 700,url: 'http://demo.gzl.com.cn:8089/tbsp-appdemo-web/demo/demoSave.html'+"?date="+new Date()});
	
	//定义弹出框参数
	var options = {
			dialogId:"demoDialog",
			dialog:{
				title:"demo测试",
				height: 450,
				width: 700,
				url: 'http://demo.gzl.com.cn:8089/tbsp-appdemo-web/demo/demoSave.html?date='+new Date(),
				data: {
			        name: "参数1"
			    },
			    //自定义参数
			    myDataName: "自定义参数1"
			},
			callBack:"closeDialogCallBack" //窗口关闭回调函数
	};
	//打开弹出窗
	openDialog(options);
}

function closeDialogCallBack(data){
	//打印窗口关闭回传数据
	console.dir(data);
	
	//刷新列表
	$("#demoDiv").KM_QuickGrid('doQuery');
}

/**
 * 编辑按钮响应函数
 */
function edit(){
	var row = manager.getSelectedRow();
	if(row){
		console.dir(["selected row", row]);
		//打开新页面
		//window.parent.f_addTab("132456677898", "修改组织", "http://demo.gzl.com.cn:8089/tbsp-appdemo-web/demo/demoEdit.html?id="+row.ID);
		
		//打开弹出窗口
		var options = {
				dialogId:"demoEditDialog",		//指定别名，自定义关闭时需此参数
				dialog:{
					title:"demo测试",
					height: 450,
					width: 700,
					url: 'http://demo.gzl.com.cn:8089/tbsp-appdemo-web/demo/demoEdit.html?id='+row.ID,
					data: {
				        name: "参数1"
				    },
				    //自定义参数
				    myDataName: "自定义参数1"
				},
				callBack:"closeDialogCallBack" //自定义窗口关闭回调函数
		};
		openDialog(options);
	}else{
		window.parent.$.ligerDialog.alert("请选择行",'提示', 'none');
	}
}

/**
 * 删除按钮响应函数
 */
function del(){
	var row = manager.getSelectedRow();
    if(row){ 
    	window.parent.$.ligerDialog.confirm('确定删除?', function (flag){
    		if(flag){
    			$.get("http://demo.gzl.com.cn:8089/tbsp-appdemo-web/demo/demoDelete.html?id="+row.ID+"&date="+new Date(),function(data){
    				if(data == 'success'){
    					manager.deleteSelectedRow();
    				}
    			});
    		}
    	});
    }else{
    	window.parent.$.ligerDialog.alert("请选择行",'提示', 'none');
    }
}

/**
 * 自定义响应函数
 */
function test(){
	alert("test");
}