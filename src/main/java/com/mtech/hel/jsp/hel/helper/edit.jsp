<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/tbsp/common/taglibs.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>编辑功能作者-待添加</title>
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
                closeDialog({dialogId:"helperEditDialog"});
            }else{
            	$.ligerDialog.error('保存失败!');
            }
        }
    </script>
</head>
<body>
<div class="contentbox top5">
	<form style="margin-left: 30px;" name="form1" id="form1" action="${ctx}/hel/helper/edit.json" method="post" submitType="ajaxSubmit" ajaxCallBack="formCallBack">
		<div id="errorLabelContainer"></div>
		<input type="hidden" value="${helper.id}" name="id" />
		<input type="hidden" value="${helper.version}" name="version" />
		<table cellpadding="0" cellspacing="0" class="l-table">
		            <tr>
						<td align="right" >帮号编号：</td>
						<td align="left"  style="width:160px">
							<input name="helperNo" type="text" value="${helper.helperNo}" id="helperNo" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮号名称：</td>
						<td align="left"  style="width:160px">
							<input name="helperName" type="text" value="${helper.helperName}" id="helperName" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮号简称：</td>
						<td align="left"  style="width:160px">
							<input name="simpleName" type="text" value="${helper.simpleName}" id="simpleName" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮号地址：</td>
						<td align="left"  style="width:160px">
							<input name="addr" type="text" value="${helper.addr}" id="addr" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮号坐标：</td>
						<td align="left"  style="width:160px">
							<input name="location" type="text" value="${helper.location}" id="location" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >联系电话：</td>
						<td align="left"  style="width:160px">
							<input name="phone" type="text" value="${helper.phone}" id="phone" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >功能介绍：</td>
						<td align="left"  style="width:160px">
							<input name="functionDesc" type="text" value="${helper.functionDesc}" id="functionDesc" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >已帮助数：</td>
						<td align="left"  style="width:160px">
							<input name="helpedNum" type="text" value="${helper.helpedNum}" id="helpedNum" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >发起的帮助数：</td>
						<td align="left"  style="width:160px">
							<input name="allHelpNum" type="text" value="${helper.allHelpNum}" id="allHelpNum" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >标签：</td>
						<td align="left"  style="width:160px">
							<input name="tags" type="text" value="${helper.tags}" id="tags" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >联系人姓名：</td>
						<td align="left"  style="width:160px">
							<input name="contactName" type="text" value="${helper.contactName}" id="contactName" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >身份证号：</td>
						<td align="left"  style="width:160px">
							<input name="idCardNo" type="text" value="${helper.idCardNo}" id="idCardNo" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮号类型：</td>
						<td align="left"  style="width:160px">
							<input name="categoryCode" type="text" value="${helper.categoryCode}" id="categoryCode" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >用户ID：</td>
						<td align="left"  style="width:160px">
							<input name="userId" type="text" value="${helper.userId}" id="userId" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		</table>
	</form>
 </div>
</body>
</html>