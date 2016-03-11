var manager = null;
$(function () {
	manager = $("#maingrid").ligerGrid({
        columns: [
        { display: '编码', name: 'code', width: "18%",align:'left' },
        { display: '描述', name: 'description',width: "27%", align:'left' },
        //{ display: 'id', name: 'id', width: "10%",align:'left',hide : true },
        { display: '所属应用', name: 'appId.appCname', width: "12%", align:'left' },
        { display: '状态', name: 'available.name',width: "9%", align:'left' }, 
        { display: '最后一次执行时间', name: 'triggerDate',width: "13%", align:'left' }, 
        { display: '最后一次执行结果', name: 'runResult.name',width: "13%", align:'left' }, 
        ,{ display: '操作', isSort: false,  width: "8%" ,align:'left', render: function (rowdata, rowindex, value)
            {
        	var av = rowdata.available;  
            var h = "";
            if(av.code == '0'){
        	 h += "<a href='javascript:activeOrSuspen("+av.code+")' ><i ></i>激活</a> ";
            }else{
        	 h += "<a href='javascript:activeOrSuspen("+av.code+")' ><i ></i>停止</a> ";
            }
            return h;
            }
        }
        //{ display: '创建时间', name: 'createDate' },
        ],  
        usePager : false,
        frozenRownumbers:false,
        rownumbers:true
    });
    $("#pageloading").hide();
    loadData();//加载数据
    
//    $("#appIdTree").ligerComboBox({
//        width: 180,
//        selectBoxWidth: 200,
//        selectBoxHeight: 200, 
//        valueField: 'id',textField: 'text',
//        tree: { url: ctx+'/core/job/getAllApp.json', checkbox: false, ajaxType: 'get' },
//        onSelected:onSelected
//    });
});

function onSelected(newvalue,text){
	$('#appId').attr("value",newvalue);
}


function activeOrSuspen(state) {
	var row = manager.getSelectedRow();
	var url = "";
	if(state=='0'){
		url = ctx+"/core/job/activeJob.json?jobId="+row.id
	}else{
		url = ctx+"/core/job/disactiveJob.json?jobId="+row.id
	}
	$.ajax({
		type : "POST",
		url : url,
		success : function(msg) {
			if (msg.ajaxResponse.success) {
			loadData();
			}
		}
	});

}
var pagebar = null;
function loadData(){
	pagebar = $("#pagebar").pagebar({url:ctx+'/core/job/schedulerJobList.json',pageRowSize:10,pageCallback:pageCallback,queryFormId:'scheduQueryForm'});
}
function pageCallback(list,index){
	var rowData = $.parseJSON("{\"Rows\":"+JSON.stringify(list)+"}");
	manager.options.data = $.extend(true, {}, rowData);
	manager.loadData();
}

function add() {
	//打开弹出窗口
	var options = {
		dialogId : "schedulerSaveDialog", //指定别名，自定义关闭时需此参数
		dialog : {
			title : "新增任务",
			height : 480,
            width : 500,
            showMax: true, 
			url : ctx+'/core/job/newJob.html',
			buttons: [
                       { text: '保存', onclick: function (item, dialog) { dialog.frame.save();}},
                       { text: '关闭', onclick: function (item, dialog) { dialog.close(); } }
                    ]
		},
		callBack : "closeSchedulerSaveDialogDialogCallBack" //自定义窗口关闭回调函数
	};
	openDialog(options);
}
function closeSchedulerSaveDialogDialogCallBack() {
	//刷新列表
	//$("#demoDiv").KM_QuickGrid('doQuery');
	loadData();
	//openWaitting("save");
}
function edit() {
	var row = manager.getSelectedRow();
	if (row) {
		//打开弹出窗口
		var options = {
			dialogId : "scheduleEditDialog", //指定别名，自定义关闭时需此参数
			dialog : {
				title : "编辑任务",
				height : 500,
	            width : 500,
				url : ctx+'/core/job/editJob.html?jobId='+ row.id,
				buttons: [
                       { text: '保存', onclick: function (item, dialog) { dialog.frame.save();}},
                       { text: '关闭', onclick: function (item, dialog) { dialog.close(); } }
                    ]
			},
			callBack : "closeSchedulerUpdateDialogDialogCallBack" //自定义窗口关闭回调函数
		};
		openDialog(options);
	} else {
		window.parent.$.ligerDialog.alert("请选择行", '提示', 'none');
	}
}
function closeSchedulerUpdateDialogDialogCallBack(){
	pagebar.reload();
	$.notice("操作成功","success");
}
function del() {
	var row = manager.getSelectedRow();
	if (row) {
		window.parent.$.ligerDialog.confirm('确定删除?', function(flag) {
			if (flag) {
				$.get(ctx+"/core/job/deleteJob.json?jobId="+row.id 
						, function(data) {
							if (data) {
								manager.deleteRow(row);
							}
				});
			}
		});
	} else {
		window.parent.$.ligerDialog.alert("请选择行", '提示', 'none');
	}
}
function run() {
	var row = manager.getSelectedRow();
	if (row) {
		window.parent.$.ligerDialog.confirm('确定立即执行?', function(flag) {
			if (flag) {
				$.get(ctx+"/core/job/executeJob.json?jobId="+row.id 
						, function(data) {
						if (data.ajaxResponse.success) {
							$.notice("操作成功！","success");
						}else{
							$.notice("操作失败!","error");
						}
				});
			}
		});
	} else {
		window.parent.$.ligerDialog.alert("请选择行", '提示', 'none');
	}
}
function init(){
	window.parent.$.ligerDialog.confirm('确定全部初始化调度?', function(flag) {
		if (flag) {
			$.get(ctx+"/core/admin/initJobs.json" 
					, function(data) {
					$.notice("操作成功！","success");
			});
		}
	});
}
function clearsche(){
	window.parent.$.ligerDialog.confirm('确定全部清除调度?', function(flag) {
		if (flag) {
			$.get(ctx+"/core/admin/clearJobs.json"
					, function(data) {
					$.notice("操作成功！","success");
			});
		}
	});
}