<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/tbsp/common/taglibs.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>编辑用户意见</title>
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
        var res=$.parseJSON(data);
            if(res.success){
                closeDialog({dialogId:"userSuggestEditDialog"});
            }else{
            	$.ligerDialog.error('保存失败!');
            }
        }
    </script>
</head>
<body>
<div class="contentbox top5">
	<form style="margin-left: 30px;" name="form1" id="form1" action="${ctx}/usr/userSuggest/edit.json" method="post" submitType="ajaxSubmit" ajaxCallBack="formCallBack">
		<div id="errorLabelContainer"></div>
		<input type="hidden" value="${userSuggest.id}" name="id" />
		<input type="hidden" value="${userSuggest.version}" name="version" />
		<table cellpadding="0" cellspacing="0" class="l-table">
		            <tr>
						<td align="right" >用户ID：</td>
						<td align="left"  style="width:160px">
							<input name="userId" type="text" value="${userSuggest.userId}" id="userId" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >用户意见内容：</td>
						<td align="left"  style="width:160px">
							<input name="suggestDesc" type="text" value="${userSuggest.suggestDesc}" id="suggestDesc" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >审核状态：</td>
						<td align="left"  style="width:160px">
							<input name="status" type="text" value="${userSuggest.status}" id="status" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >处理结果：</td>
						<td align="left"  style="width:160px">
							<input name="auditResult" type="text" value="${userSuggest.auditResult}" id="auditResult" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >处理人id：</td>
						<td align="left"  style="width:160px">
							<input name="auditId" type="text" value="${userSuggest.auditId}" id="auditId" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		</table>
	</form>
 </div>
</body>
</html>