var manager = null;
var dialogHeight=700;
$(function () {
  var columnSize=0;
   	    columnSize++;
	    columnSize++;
	    columnSize++;
	    columnSize++;
	    columnSize++;
	    columnSize++;
	    columnSize++;
	    columnSize++;
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
			          { display: '帮助编号', name: 'helpNo', minWidth: 60,align:'left',
				        render:function(row){
				        		var html = '';
				        		html += '<a  href="javascript:void(0);" onclick="view(\'' + row.id + '\')">'+row.helpNo+'</a>';
				        		return html;
				        	} 
					   }
			              ,{ display: '帮助内容', name: 'helpContent',align:'left' } 
			              ,{ display: '帮助费用', name: 'helpCost',align:'left' } 
			              ,{ display: '帮号ID', name: 'helperId',align:'left' } 
			              ,{ display: '发起帮助人ID', name: 'userId',align:'left' } 
			              ,{ display: '接收帮助人ID', name: 'acceptUserId',align:'left' } 
			              ,{ display: '使用的帮豆数', name: 'usedHelpNum',align:'left' } 
			              ,{ display: '配送地址', name: 'delAddr',align:'left' } 
			              ,{ display: '帮助状态', name: 'helpStatus',align:'left' } 
			              ,{ display: '帮助开始时间', name: 'helpStartDate',align:'left' } 
			              ,{ display: '帮助结束时间', name: 'helpEndDate',align:'left' } 
			              ,{ display: '赞数', name: 'zan',align:'left' } 
			              ,{ display: '点评数', name: 'reviewNum',align:'left' } 
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
	pagebar = $("#pagebar").pagebar({url:ctx+'/hel/help/list.json',pageCallback:pageCallback,queryFormId:'helpQueryForm'});
}
function pageCallback(list,index){
	var rowData = $.parseJSON("{\"Rows\":"+JSON.stringify(list)+"}");
	manager.options.data = $.extend(true, {}, rowData);
	manager.loadData();
}
function add() {
	//打开弹出窗口
	var options = {
		dialogId : "helpSaveDialog", //指定别名，自定义关闭时需此参数
		dialog : {
			title : "新增功能作者-待添加",
			height : dialogHeight,
            width : 500,
            showMax: true, 
			url : ctx+'/hel/help/save.html?data='+ new Date(),
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
		dialogId : "helpViewDialog", //指定别名，自定义关闭时需此参数
		dialog : {
			title : "查看功能作者-待添加",
			height : dialogHeight,
            width : 500,
            showMax: true, 
			url : ctx+'/hel/help/view.html?id='+ id,
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
			dialogId : "helpEditDialog", //指定别名，自定义关闭时需此参数
			dialog : {
				title : "编辑功能作者-待添加",
				height : dialogHeight,
	            width : 500,
				url : ctx+'/hel/help/edit.html?id='+ row.id,
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
				$.get(ctx+"/hel/help/delete.json?id="+row.id 
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