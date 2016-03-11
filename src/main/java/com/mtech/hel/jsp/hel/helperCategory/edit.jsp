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
                closeDialog({dialogId:"helperCategoryEditDialog"});
            }else{
            	$.ligerDialog.error('保存失败!');
            }
        }
    </script>
</head>
<body>
<div class="contentbox top5">
	<form style="margin-left: 30px;" name="form1" id="form1" action="${ctx}/hel/helperCategory/edit.json" method="post" submitType="ajaxSubmit" ajaxCallBack="formCallBack">
		<div id="errorLabelContainer"></div>
		<input type="hidden" value="${helperCategory.id}" name="id" />
		<input type="hidden" value="${helperCategory.version}" name="version" />
		<table cellpadding="0" cellspacing="0" class="l-table">
		            <tr>
						<td align="right" >编号：</td>
						<td align="left"  style="width:160px">
							<input name="categoryCode" type="text" value="${helperCategory.categoryCode}" id="categoryCode" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >名称：</td>
						<td align="left"  style="width:160px">
							<input name="categoryName" type="text" value="${helperCategory.categoryName}" id="categoryName" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >父级编号：</td>
						<td align="left"  style="width:160px">
							<input name="parentCode" type="text" value="${helperCategory.parentCode}" id="parentCode" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		</table>
	</form>
 </div>
</body>
</html>