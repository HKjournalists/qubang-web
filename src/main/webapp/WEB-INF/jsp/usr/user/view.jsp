<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/tbsp/common/taglibs.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>查看用户</title>
	<%@include file="/WEB-INF/jsp/tbsp/common/metas.jsp"%>
	<%@include file="/WEB-INF/jsp/tbsp/common/scriptBase.jsp"%>
	<%@include file="/WEB-INF/jsp/tbsp/common/scriptForm.jsp"%>
</head>
<body>
<div class="contentbox top5">
	<form style="margin-left: 30px;" name="form1" id="form1" action="${ctx}/usr/user/userSave.json" method="post" submitType="ajaxSubmit" ajaxCallBack="formCallBack">
		<div id="errorLabelContainer"></div>
		<table cellpadding="0" cellspacing="0" class="l-table">
		            <tr>
						<td align="right" >no：</td>
						<td align="left"  style="width:160px">
							${user.no}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >headerPic：</td>
						<td align="left"  style="width:160px">
							${user.headerPic}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >nickName：</td>
						<td align="left"  style="width:160px">
							${user.nickName}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >remark：</td>
						<td align="left"  style="width:160px">
							${user.remark}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >mobileNo：</td>
						<td align="left"  style="width:160px">
							${user.mobileNo}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >areaCode：</td>
						<td align="left"  style="width:160px">
							${user.areaCode}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >signature：</td>
						<td align="left"  style="width:160px">
							${user.signature}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >helpNum：</td>
						<td align="left"  style="width:160px">
							${user.helpNum}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >beHelpedNum：</td>
						<td align="left"  style="width:160px">
							${user.beHelpedNum}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >availableHelpNum：</td>
						<td align="left"  style="width:160px">
							${user.availableHelpNum}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >favourNum：</td>
						<td align="left"  style="width:160px">
							${user.favourNum}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >collegeName：</td>
						<td align="left"  style="width:160px">
							${user.collegeName}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >毕业时间：</td>
						<td align="left"  style="width:160px">
							${user.eduEndDate}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >education：</td>
						<td align="left"  style="width:160px">
							${user.education}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >major：</td>
						<td align="left"  style="width:160px">
							${user.major}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >myCollege：</td>
						<td align="left"  style="width:160px">
							${user.myCollege}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >入学时间：</td>
						<td align="left"  style="width:160px">
							${user.eduStrartDate}
						</td>
						<td align="left"></td>
					</tr>
		</table>
	</form>
 </div>
</body>
</html>