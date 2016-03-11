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
	    columnSize++;
   
   if(columnSize<=18){
     dialogHeight=40*columnSize+50;
   }
   
	manager = $("#maingrid").ligerGrid({
        columns: [
			          { display: 'id', name: 'id', width: 1,align:'left',hide : true },
			          { display: '帮号编号', name: 'helperNo', minWidth: 60,align:'left',
				        render:function(row){
				        		var html = '';
				        		html += '<a  href="javascript:void(0);" onclick="view(\'' + row.id + '\')">'+row.helperNo+'</a>';
				        		return html;
				        	} 
					   }
			              ,{ display: '帮号名称', name: 'helperName',align:'left' } 
			              ,{ display: '帮号简称', name: 'simpleName',align:'left' } 
			              ,{ display: '帮号地址', name: 'addr',align:'left' } 
			              ,{ display: '帮号坐标', name: 'location',align:'left' } 
			              ,{ display: '联系电话', name: 'phone',align:'left' } 
			              ,{ display: '功能介绍', name: 'functionDesc',align:'left' } 
			              ,{ display: '已帮助数', name: 'helpedNum',align:'left' } 
			              ,{ display: '发起的帮助数', name: 'allHelpNum',align:'left' } 
			              ,{ display: '标签', name: 'tags',align:'left' } 
			              ,{ display: '联系人姓名', name: 'contactName',align:'left' } 
			              ,{ display: '身份证号', name: 'idCardNo',align:'left' } 
			              ,{ display: '帮号类型', name: 'categoryCode',align:'left' } 
			              ,{ display: '用户ID', name: 'userId',align:'left' } 
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
	pagebar = $("#pagebar").pagebar({url:ctx+'/hel/helper/list.json',pageCallback:pageCallback,queryFormId:'helperQueryForm'});
}
function pageCallback(list,index){
	var rowData = $.parseJSON("{\"Rows\":"+JSON.stringify(list)+"}");
	manager.options.data = $.extend(true, {}, rowData);
	manager.loadData();
}
function add() {
	//打开弹出窗口
	var options = {
		dialogId : "helperSaveDialog", //指定别名，自定义关闭时需此参数
		dialog : {
			title : "新增功能作者-待添加",
			height : dialogHeight,
            width : 500,
            showMax: true, 
			url : ctx+'/hel/helper/save.html?data='+ new Date(),
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
		dialogId : "helperViewDialog", //指定别名，自定义关闭时需此参数
		dialog : {
			title : "查看功能作者-待添加",
			height : dialogHeight,
            width : 500,
            showMax: true, 
			url : ctx+'/hel/helper/view.html?id='+ id,
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
			dialogId : "helperEditDialog", //指定别名，自定义关闭时需此参数
			dialog : {
				title : "编辑功能作者-待添加",
				height : dialogHeight,
	            width : 500,
				url : ctx+'/hel/helper/edit.html?id='+ row.id,
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
				$.get(ctx+"/hel/helper/delete.json?id="+row.id 
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