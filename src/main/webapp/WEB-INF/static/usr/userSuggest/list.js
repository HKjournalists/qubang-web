var manager = null;
var dialogHeight=700;
$(function () {
  var columnSize=0;
   	    columnSize++;
	    columnSize++;
	    columnSize++;
	    columnSize++;
	    columnSize++;
   
   if(columnSize<=18){
     dialogHeight=40*columnSize+50;
   }
   
	manager = $("#maingrid").ligerGrid({
        columns: [
			          { display: 'id', name: 'id', width: 1,align:'left',hide : true },
			          { display: '用户ID', name: 'userId', minWidth: 60,align:'left',
				        render:function(row){
				        		var html = '';
				        		html += '<a  href="javascript:void(0);" onclick="view(\'' + row.id + '\')">'+row.userId+'</a>';
				        		return html;
				        	} 
					   }
			              ,{ display: '用户意见内容', name: 'suggestDesc',align:'left' } 
			              ,{ display: '审核状态', name: 'status',align:'left' } 
			              ,{ display: '处理结果', name: 'auditResult',align:'left' } 
			              ,{ display: '处理人id', name: 'auditId',align:'left' } 
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
	pagebar = $("#pagebar").pagebar({url:ctx+'/usr/userSuggest/list.json',pageCallback:pageCallback,queryFormId:'userSuggestQueryForm'});
}
function pageCallback(list,index){
	var rowData = $.parseJSON("{\"Rows\":"+JSON.stringify(list)+"}");
	manager.options.data = $.extend(true, {}, rowData);
	manager.loadData();
}
function add() {
	//打开弹出窗口
	var options = {
		dialogId : "userSuggestSaveDialog", //指定别名，自定义关闭时需此参数
		dialog : {
			title : "新增用户意见",
			height : dialogHeight,
            width : 500,
            showMax: true, 
			url : ctx+'/usr/userSuggest/save.html?data='+ new Date(),
			buttons: [
                       { text: '保存', onclick: function (item, dialog) { dialog.frame.save();}},
                       { text: '关闭', onclick: function (item, dialog) { dialog.close(); } }
                    ]
		},
		callBack : "closeSaveDialogCallBack" //自定义窗口关闭回调函数
	};
	openDialog(options);
}

function view(id) {
	//打开弹出窗口
	var options = {
		dialogId : "userSuggestViewDialog", //指定别名，自定义关闭时需此参数
		dialog : {
			title : "查看用户意见",
			height : dialogHeight,
            width : 500,
            showMax: true, 
			url : ctx+'/usr/userSuggest/view.html?id='+ id,
			buttons: [
                       { text: '关闭', onclick: function (item, dialog) { dialog.close(); } }
                    ]
		}
	};
	openDialog(options);
}

function closeSaveDialogCallBack() {
	//刷新列表
	loadData();
	$.notice("操作成功！","success");   
}
function edit() {
	var row = manager.getSelectedRow();
	if (row) {
		//打开弹出窗口
		var options = {
			dialogId : "userSuggestEditDialog", //指定别名，自定义关闭时需此参数
			dialog : {
				title : "编辑用户意见",
				height : dialogHeight,
	            width : 500,
				url : ctx+'/usr/userSuggest/edit.html?id='+ row.id,
				buttons: [
                       { text: '保存', onclick: function (item, dialog) { dialog.frame.save();}},
                       { text: '关闭', onclick: function (item, dialog) { dialog.close(); } }
                    ]
			},
			callBack : "closeUpdateDialogCallBack" //自定义窗口关闭回调函数
		};
		openDialog(options);
	} else {
		$.notice("请选择行!","info");
	}
}
function closeUpdateDialogCallBack(){
	pagebar.reload();
	$.notice("操作成功！","success");   
}
function del() {
	var row = manager.getSelectedRow();
	if (row) {
		window.parent.$.ligerDialog.confirm('确定删除?', function(flag) {
			if (flag) {
				$.get(ctx+"/usr/userSuggest/delete.json?id="+row.id 
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