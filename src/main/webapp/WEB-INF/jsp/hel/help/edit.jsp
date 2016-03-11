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
                closeDialog({dialogId:"helpEditDialog"});
            }else{
            	$.ligerDialog.error('保存失败!');
            }
        }
    </script>
</head>
<body>
<div class="contentbox top5">
	<form style="margin-left: 30px;" name="form1" id="form1" action="${ctx}/hel/help/edit.json" method="post" submitType="ajaxSubmit" ajaxCallBack="formCallBack">
		<div id="errorLabelContainer"></div>
		<input type="hidden" value="${help.id}" name="id" />
		<input type="hidden" value="${help.version}" name="version" />
		<table cellpadding="0" cellspacing="0" class="l-table">
		            <tr>
						<td align="right" >帮助编号：</td>
						<td align="left"  style="width:160px">
							<input name="helpNo" type="text" value="${help.helpNo}" id="helpNo" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮助内容：</td>
						<td align="left"  style="width:160px">
							<input name="helpContent" type="text" value="${help.helpContent}" id="helpContent" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮助费用：</td>
						<td align="left"  style="width:160px">
							<input name="helpCost" type="text" value="${help.helpCost}" id="helpCost" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮号ID：</td>
						<td align="left"  style="width:160px">
							<input name="helperId" type="text" value="${help.helperId}" id="helperId" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >发起帮助人ID：</td>
						<td align="left"  style="width:160px">
							<input name="userId" type="text" value="${help.userId}" id="userId" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >接收帮助人ID：</td>
						<td align="left"  style="width:160px">
							<input name="acceptUserId" type="text" value="${help.acceptUserId}" id="acceptUserId" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >使用的帮豆数：</td>
						<td align="left"  style="width:160px">
							<input name="usedHelpNum" type="text" value="${help.usedHelpNum}" id="usedHelpNum" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >配送地址：</td>
						<td align="left"  style="width:160px">
							<input name="delAddr" type="text" value="${help.delAddr}" id="delAddr" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮助状态：</td>
						<td align="left"  style="width:160px">
							<input name="helpStatus" type="text" value="${help.helpStatus}" id="helpStatus" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >赞数：</td>
						<td align="left"  style="width:160px">
							<input name="zan" type="text" value="${help.zan}" id="zan" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >点评数：</td>
						<td align="left"  style="width:160px">
							<input name="reviewNum" type="text" value="${help.reviewNum}" id="reviewNum" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		</table>
	</form>
 </div>
</body>
</html>