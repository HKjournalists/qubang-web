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
   
   if(columnSize<=18){
     dialogHeight=40*columnSize+50;
   }
   
	manager = $("#maingrid").ligerGrid({
        columns: [
			          { display: 'id', name: 'id', width: 1,align:'left',hide : true },
			          { display: '配送地址', name: 'delAddr', minWidth: 60,align:'left',
				        render:function(row){
				        		var html = '';
				        		html += '<a  href="javascript:void(0);" onclick="view(\'' + row.id + '\')">'+row.delAddr+'</a>';
				        		return html;
				        	} 
					   }
			              ,{ display: '帮助内容', name: 'helpContent',align:'left' } 
			              ,{ display: '帮豆', name: 'helpNum',align:'left' } 
			              ,{ display: '红包金额', name: 'cost',align:'left' } 
			              ,{ display: '是否可用', name: 'available',align:'left' } 
			              ,{ display: '使用次数', name: 'usedNum',align:'left' } 
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
	pagebar = $("#pagebar").pagebar({url:ctx+'/usr/userHelpFavorite/list.json',pageCallback:pageCallback,queryFormId:'userHelpFavoriteQueryForm'});
}
function pageCallback(list,index){
	var rowData = $.parseJSON("{\"Rows\":"+JSON.stringify(list)+"}");
	manager.options.data = $.extend(true, {}, rowData);
	manager.loadData();
}
function add() {
	//打开弹出窗口
	var options = {
		dialogId : "userHelpFavoriteSaveDialog", //指定别名，自定义关闭时需此参数
		dialog : {
			title : "新增常用帮助收藏",
			height : dialogHeight,
            width : 500,
            showMax: true, 
			url : ctx+'/usr/userHelpFavorite/save.html?data='+ new Date(),
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
		dialogId : "userHelpFavoriteViewDialog", //指定别名，自定义关闭时需此参数
		dialog : {
			title : "查看常用帮助收藏",
			height : dialogHeight,
            width : 500,
            showMax: true, 
			url : ctx+'/usr/userHelpFavorite/view.html?id='+ id,
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
			dialogId : "userHelpFavoriteEditDialog", //指定别名，自定义关闭时需此参数
			dialog : {
				title : "编辑常用帮助收藏",
				height : dialogHeight,
	            width : 500,
				url : ctx+'/usr/userHelpFavorite/edit.html?id='+ row.id,
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
				$.get(ctx+"/usr/userHelpFavorite/delete.json?id="+row.id 
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