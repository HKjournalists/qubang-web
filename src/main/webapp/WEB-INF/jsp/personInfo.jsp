<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/tbsp/common/taglibs.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>应用管理</title>
	<%@include file="/WEB-INF/jsp/tbsp/common/metas.jsp"%>
	<%@include file="/WEB-INF/jsp/tbsp/common/scriptBase.jsp"%>
	<%@include file="/WEB-INF/jsp/tbsp/common/scriptForm.jsp"%>
    <script type="text/javascript">
        $(function(){
        	var dialog = frameElement.dialog; //调用页面的dialog对象(ligerui对象)
        });
        //保存
        function save(){
        	$("#form1").submit();
        }
        //ajax提交回调函数
        function formCallBack(data){
            if(data){
                closeDialog({dialogId:"appEditDialog"});
            }else{
            	$.ligerDialog.error('保存失败!');
            }
        }
    </script>
</head>
<body>
<div class="contentbox top5">
	<form style="margin-left: 30px;" name="form1" id="form1" action="${ctx}/permission/app/appEdit.json" method="post" submitType="ajaxSubmit" ajaxCallBack="formCallBack">
		<div id="errorLabelContainer"></div>
		<input type="hidden" value="${user.id}" name="id" />
		<table cellpadding="0" cellspacing="0" class="l-table">
			<tr>
				<td align="right" >姓名:</td>
				<td align="left"  style="width:160px">
				<label>${user.realName }</label>
				</td>
				<td align="left"></td>
				<td align="right" >登录名:</td>
				<td align="left"  style="width:160px">
				<label>${user.username }</label>
				</td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" >员工编号:</td>
				<td align="left"  style="width:160px">
				<label>${user.employeeCode }</label>
				</td>
				<td align="left"></td>
				<td align="right" >登陆名:</td>
				<td align="left"  style="width:160px">
				<label>${user.username }</label>
				</td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" >服务部门:</td>
				<td align="left"  style="width:160px">
				<label>${user.serviceDepName }</label>
				</td>
				<td align="left"></td>
				<td align="right" >服务公司:</td>
				<td align="left"  style="width:160px">
				<label>${user.serviceCompanyName }</label>
				</td>
				<td align="left"></td>
			</tr>
		</table>
	</form>
 </div>
</body>
</html>