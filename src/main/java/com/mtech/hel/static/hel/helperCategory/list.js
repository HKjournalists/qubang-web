var manager = null;
var dialogHeight=700;
$(function () {
  var columnSize=0;
   	    columnSize++;
	    columnSize++;
	    columnSize++;
   
   if(columnSize<=18){
     dialogHeight=40*columnSize+50;
   }
   
	manager = $("#maingrid").ligerGrid({
        columns: [
			          { display: 'id', name: 'id', width: 1,align:'left',hide : true },
			          { display: '编号', name: 'categoryCode', minWidth: 60,align:'left',
				        render:function(row){
				        		var html = '';
				        		html += '<a  href="javascript:void(0);" onclick="view(\'' + row.id + '\')">'+row.categoryCode+'</a>';
				        		return html;
				        	} 
					   }
			              ,{ display: '名称', name: 'categoryName',align:'left' } 
			              ,{ display: '父级编号', name: 'parentCode',align:'left' } 
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
	pagebar = $("#pagebar").pagebar({url:ctx+'/hel/helperCategory/list.json',pageCallback:pageCallback,queryFormId:'helperCategoryQueryForm'});
}
function pageCallback(list,index){
	var rowData = $.parseJSON("{\"Rows\":"+JSON.stringify(list)+"}");
	manager.options.data = $.extend(true, {}, rowData);
	manager.loadData();
}
function add() {
	//打开弹出窗口
	var options = {
		dialogId : "helperCategorySaveDialog", //指定别名，自定义关闭时需此参数
		dialog : {
			title : "新增功能作者-待添加",
			height : dialogHeight,
            width : 500,
            showMax: true, 
			url : ctx+'/hel/helperCategory/save.html?data='+ new Date(),
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
		dialogId : "helperCategoryViewDialog", //指定别名，自定义关闭时需此参数
		dialog : {
			title : "查看功能作者-待添加",
			height : dialogHeight,
            width : 500,
            showMax: true, 
			url : ctx+'/hel/helperCategory/view.html?id='+ id,
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
			dialogId : "helperCategoryEditDialog", //指定别名，自定义关闭时需此参数
			dialog : {
				title : "编辑功能作者-待添加",
				height : dialogHeight,
	            width : 500,
				url : ctx+'/hel/helperCategory/edit.html?id='+ row.id,
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
				$.get(ctx+"/hel/helperCategory/delete.json?id="+row.id 
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