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
            	/*var option = {
                         dialogId:"menuSaveDialog"
                         ,data:{
                             name: "回传参数测试2"
                         }
                    }*/
                //关闭窗口
                closeDialog({dialogId:"appSaveDialog"});
            }else{
            	$.ligerDialog.error('保存失败!');
            }
        }
    </script>
</head>
<body>
<div class="contentbox top5">
	<form style="margin-left: 30px;" name="form1" id="form1" action="${ctx}/permission/app/appSave.json" method="post" submitType="ajaxSubmit" ajaxCallBack="formCallBack">
		<div id="errorLabelContainer"></div>
		<table cellpadding="0" cellspacing="0" class="l-table">
			<tr>
				<td align="right" >应用名称:</td>
				<td align="left"  style="width:160px"><input
					name="appName" type="text" id="appName" ltype="text"
					validate="{required:true,maxlength:100}" /></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" >应用中文名称:</td>
				<td align="left"  style="width:160px"><input
					name="appCname" type="text" id="appCname" ltype="text"
					validate="{required:true,maxlength:100}" /></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" >应用key:</td>
				<td align="left"  style="width:160px"><input
					name="appKey" type="text" id="appKey" ltype="text"
					validate="{required:true,maxlength:100}" /></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" >appSecret:</td>
				<td align="left"  style="width:160px"><input
					name="appSecret" type="text" id="appSecret" ltype="text"
					validate="{required:true,maxlength:100}" /></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" >hostname:</td>
				<td align="left"  style="width:160px"><input
					name="hostname" type="text" id="hostname" ltype="text"
					validate="{required:true,maxlength:100}" /></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" >应用上下文:</td>
				<td align="left"  style="width:160px"><input
					name="webContext" type="text" id="webContext" ltype="text"
					validate="{required:true,maxlength:100}" /></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" >顺序(数字):</td>
				<td align="left"  style="width:160px"><input
					name="orderby" type="text" id="orderby" validate="{maxlength:4}" /></td>
				<td align="left"></td>
			</tr>
			  <tr>
                <td align="right"  valign="top">是否可用:</td>
                <td align="left" >
                 <tbsp:dict  id="available" name="available" defaultvalue="1"  display="radio" dictType="UAM_AVAIL_STATUS"></tbsp:dict>       
                </td>
            </tr>    
		</table>
	</form>
</div>
</body>
</html>