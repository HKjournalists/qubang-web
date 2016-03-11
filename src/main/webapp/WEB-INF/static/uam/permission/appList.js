var manager = null;
$(function () {
	manager = $("#maingrid").ligerGrid({
        columns: [
        { display: '应用名称', name: 'appName', minWidth: 60,align:'left' },
        { display: 'id', name: 'id', width: 1,align:'left',hide : true },
        { display: '应用中文名称', name: 'appCname',align:'left' }, 
        { display: '应用KEY', name: 'appKey',align:'left' }, 
        { display: '安全码', name: 'appSecret',align:'left' }, 
        { display: '主机', name: 'hostname',align:'left' }, 
        { display: '应用上下文', name: 'webContext',align:'left' }, 
        { display: '是否可用', name: 'available',width:60 }
        ],  
        usePager : false,
        frozenRownumbers:false,
        rownumbers:true
    });
    $("#pageloading").hide();
    loadData();//加载数据
});
var pagebar = null;
function loadData(){
	pagebar = $("#pagebar").pagebar({url:ctx+'/permission/app/appList.json',pageRowSize:9,pageCallback:pageCallback,queryFormId:'appQueryForm'});
}
function pageCallback(list,index){
	var rowData = $.parseJSON("{\"Rows\":"+JSON.stringify(list)+"}");
	manager.options.data = $.extend(true, {}, rowData);
	manager.loadData();
}
function add() {
	//打开弹出窗口
	var options = {
		dialogId : "appSaveDialog", //指定别名，自定义关闭时需此参数
		dialog : {
			title : "新增应用",
			height : 380,
            width : 500,
            showMax: true, 
			url : ctx+'/permission/app/appSave.html?data='+ new Date(),
			buttons: [
                       { text: '保存', onclick: function (item, dialog) { dialog.frame.save();}},
                       { text: '关闭', onclick: function (item, dialog) { dialog.close(); } }
                    ]
		},
		callBack : "closeAppSaveDialogCallBack" //自定义窗口关闭回调函数
	};
	openDialog(options);
}
function closeAppSaveDialogCallBack() {
	//刷新列表
	//$("#demoDiv").KM_QuickGrid('doQuery');
	loadData();
	$.notice("操作成功！","success");   
}
function edit() {
	var row = manager.getSelectedRow();
	if (row) {
		//打开弹出窗口
		var options = {
			dialogId : "appEditDialog", //指定别名，自定义关闭时需此参数
			dialog : {
				title : "编辑应用",
				height : 380,
	            width : 500,
				url : ctx+'/permission/app/appEdit.html?id='+ row.id,
				buttons: [
                       { text: '保存', onclick: function (item, dialog) { dialog.frame.save();}},
                       { text: '关闭', onclick: function (item, dialog) { dialog.close(); } }
                    ]
			},
			callBack : "closeAppUpdateDialogCallBack" //自定义窗口关闭回调函数
		};
		openDialog(options);
	} else {
		$.notice("请选择行!","info");
	}
}
function closeAppUpdateDialogCallBack(){
	pagebar.reload();
	$.notice("操作成功！","success");   
}
function del() {
	var row = manager.getSelectedRow();
	if (row) {
		window.parent.$.ligerDialog.confirm('确定删除?', function(flag) {
			if (flag) {
				$.get(ctx+"/permission/app/appDelete.json?id="+row.id 
						, function(data) {
							if(data.success){
		        	    		$.notice("删除成功！","success");
		        	    		loadData();
		        	    	}else{
		        	        	$.ligerDialog.error(data.msg);
		        	        }
				});
			}
		});
	} else {
		$.notice("请选择行!","info");
	}
}
