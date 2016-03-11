<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/tbsp/common/taglibs.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>编辑常用帮助收藏</title>
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
                closeDialog({dialogId:"userHelpFavoriteEditDialog"});
            }else{
            	$.ligerDialog.error('保存失败!');
            }
        }
    </script>
</head>
<body>
<div class="contentbox top5">
	<form style="margin-left: 30px;" name="form1" id="form1" action="${ctx}/usr/userHelpFavorite/edit.json" method="post" submitType="ajaxSubmit" ajaxCallBack="formCallBack">
		<div id="errorLabelContainer"></div>
		<input type="hidden" value="${userHelpFavorite.id}" name="id" />
		<input type="hidden" value="${userHelpFavorite.version}" name="version" />
		<table cellpadding="0" cellspacing="0" class="l-table">
		            <tr>
						<td align="right" >用户ID：</td>
						<td align="left"  style="width:160px">
							<input name="userId" type="text" value="${userHelpFavorite.userId}" id="userId" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >配送地址：</td>
						<td align="left"  style="width:160px">
							<input name="delAddr" type="text" value="${userHelpFavorite.delAddr}" id="delAddr" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮助内容：</td>
						<td align="left"  style="width:160px">
							<input name="helpContent" type="text" value="${userHelpFavorite.helpContent}" id="helpContent" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮豆：</td>
						<td align="left"  style="width:160px">
							<input name="helpNum" type="text" value="${userHelpFavorite.helpNum}" id="helpNum" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >红包金额：</td>
						<td align="left"  style="width:160px">
							<input name="cost" type="text" value="${userHelpFavorite.cost}" id="cost" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >是否可用：</td>
						<td align="left"  style="width:160px">
							<input name="available" type="text" value="${userHelpFavorite.available}" id="available" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >使用次数：</td>
						<td align="left"  style="width:160px">
							<input name="usedNum" type="text" value="${userHelpFavorite.usedNum}" id="usedNum" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		</table>
	</form>
 </div>
</body>
</html>