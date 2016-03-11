<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<script type="text/javascript">
var manager = null;
$(function () {
	manager = $("#maingrid").ligerGrid({
        columns: [
        { display: '编码', name: 'code', width: "15%",align:'left' },
        { display: 'id', name: 'id', width: "5%",align:'left',hide : true },
        { display: '所属应用', name: 'appId.appCname', width: "20%", align:'left' }, 
        //{ display: '触发类型', name: 'triggerType',width: "10%", align:'left' }
        //,{ display: '运行状态', name: 'runStatus.name',width: "10%", align:'left' }
        ,{ display: '运行结果', name: 'runResult.name',width: "10%", align:'left' }
        ,{ display: '开始时间', name: 'triggerDate',width: "20%", align:'left' }
        ,{ display: '结束时间', name: 'finishedDate',width: "20%", align:'left' }
        ],  
        usePager : false,
        frozenRownumbers:false,
        rownumbers:true
    });
    $("#pageloading").hide();
    loadData();//加载数据
});

function onSelected(newvalue,text){
	$('#appId').attr("value",newvalue);
}

function loadData(){
	$("#pagebar").pagebar({url:ctx+'/core/job/schedulerLogList.json',pageRowSize:10,pageCallback:pageCallback,queryFormId:'scheduLogQueryForm'});
}
function pageCallback(list,index){
	var rowData = $.parseJSON("{\"Rows\":"+JSON.stringify(list)+"}");
	manager.options.data = $.extend(true, {}, rowData);
	manager.loadData();
}

function closeSchedulerSaveDialogDialogCallBack() {
	//刷新列表
	//$("#demoDiv").KM_QuickGrid('doQuery');
	loadData();
	openWaitting("save");
}
function edit() {
	var row = manager.getSelectedRow();
	if (row) {
		//打开弹出窗口
		var options = {
			dialogId : "scheduleEditDialog", //æå®å«åï¼èªå®ä¹å³é­æ¶éæ­¤åæ°
			dialog : {
				title : "查看任务",
				height : 600,
	            width : 600,
				url : ctx+'/core/job/viewLog.html?id='+ row.id,
				buttons: [
                       { text: '关闭', onclick: function (item, dialog) { dialog.close(); } }
                    ]
			},
			callBack : "closeSchedulerSaveDialogDialogCallBack" //自定义窗口关闭回调函数
		};
		openDialog(options);
	} else {
		window.parent.$.ligerDialog.alert("请选择行", '提示', 'none');
	}
}
</script>