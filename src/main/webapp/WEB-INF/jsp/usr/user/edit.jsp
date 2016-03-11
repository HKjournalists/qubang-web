<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/tbsp/common/taglibs.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>编辑用户</title>
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
                closeDialog({dialogId:"userEditDialog"});
            }else{
            	$.ligerDialog.error('保存失败!');
            }
        }
    </script>
</head>
<body>
<div class="contentbox top5">
	<form style="margin-left: 30px;" name="form1" id="form1" action="${ctx}/usr/user/edit.json" method="post" submitType="ajaxSubmit" ajaxCallBack="formCallBack">
		<div id="errorLabelContainer"></div>
		<input type="hidden" value="${user.id}" name="id" />
		<input type="hidden" value="${user.version}" name="version" />
		<table cellpadding="0" cellspacing="0" class="l-table">
		            <tr>
						<td align="right" >no：</td>
						<td align="left"  style="width:160px">
							<input name="no" type="text" value="${user.no}" id="no" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >headerPic：</td>
						<td align="left"  style="width:160px">
							<input name="headerPic" type="text" value="${user.headerPic}" id="headerPic" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >nickName：</td>
						<td align="left"  style="width:160px">
							<input name="nickName" type="text" value="${user.nickName}" id="nickName" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >remark：</td>
						<td align="left"  style="width:160px">
							<input name="remark" type="text" value="${user.remark}" id="remark" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >mobileNo：</td>
						<td align="left"  style="width:160px">
							<input name="mobileNo" type="text" value="${user.mobileNo}" id="mobileNo" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >areaCode：</td>
						<td align="left"  style="width:160px">
							<input name="areaCode" type="text" value="${user.areaCode}" id="areaCode" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >signature：</td>
						<td align="left"  style="width:160px">
							<input name="signature" type="text" value="${user.signature}" id="signature" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >helpNum：</td>
						<td align="left"  style="width:160px">
							<input name="helpNum" type="text" value="${user.helpNum}" id="helpNum" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >beHelpedNum：</td>
						<td align="left"  style="width:160px">
							<input name="beHelpedNum" type="text" value="${user.beHelpedNum}" id="beHelpedNum" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >availableHelpNum：</td>
						<td align="left"  style="width:160px">
							<input name="availableHelpNum" type="text" value="${user.availableHelpNum}" id="availableHelpNum" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >favourNum：</td>
						<td align="left"  style="width:160px">
							<input name="favourNum" type="text" value="${user.favourNum}" id="favourNum" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >collegeName：</td>
						<td align="left"  style="width:160px">
							<input name="collegeName" type="text" value="${user.collegeName}" id="collegeName" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >毕业时间：</td>
						<td align="left"  style="width:160px">
							<input name="eduEndDate" type="text" value="${user.eduEndDate}" id="eduEndDate" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >education：</td>
						<td align="left"  style="width:160px">
							<input name="education" type="text" value="${user.education}" id="education" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >major：</td>
						<td align="left"  style="width:160px">
							<input name="major" type="text" value="${user.major}" id="major" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >myCollege：</td>
						<td align="left"  style="width:160px">
							<input name="myCollege" type="text" value="${user.myCollege}" id="myCollege" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >入学时间：</td>
						<td align="left"  style="width:160px">
							<input name="eduStrartDate" type="text" value="${user.eduStrartDate}" id="eduStrartDate" ltype="text" validate="" />
						</td>
						<td align="left"></td>
					</tr>
		</table>
	</form>
 </div>
</body>
</html>