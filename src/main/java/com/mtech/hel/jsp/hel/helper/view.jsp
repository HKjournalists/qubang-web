<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/tbsp/common/taglibs.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>查看功能作者-待添加</title>
	<%@include file="/WEB-INF/jsp/tbsp/common/metas.jsp"%>
	<%@include file="/WEB-INF/jsp/tbsp/common/scriptBase.jsp"%>
	<%@include file="/WEB-INF/jsp/tbsp/common/scriptForm.jsp"%>
</head>
<body>
<div class="contentbox top5">
	<form style="margin-left: 30px;" name="form1" id="form1" action="${ctx}/hel/helper/helperSave.json" method="post" submitType="ajaxSubmit" ajaxCallBack="formCallBack">
		<div id="errorLabelContainer"></div>
		<table cellpadding="0" cellspacing="0" class="l-table">
		            <tr>
						<td align="right" >帮号编号：</td>
						<td align="left"  style="width:160px">
							${helper.helperNo}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮号名称：</td>
						<td align="left"  style="width:160px">
							${helper.helperName}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮号简称：</td>
						<td align="left"  style="width:160px">
							${helper.simpleName}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮号地址：</td>
						<td align="left"  style="width:160px">
							${helper.addr}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮号坐标：</td>
						<td align="left"  style="width:160px">
							${helper.location}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >联系电话：</td>
						<td align="left"  style="width:160px">
							${helper.phone}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >功能介绍：</td>
						<td align="left"  style="width:160px">
							${helper.functionDesc}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >已帮助数：</td>
						<td align="left"  style="width:160px">
							${helper.helpedNum}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >发起的帮助数：</td>
						<td align="left"  style="width:160px">
							${helper.allHelpNum}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >标签：</td>
						<td align="left"  style="width:160px">
							${helper.tags}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >联系人姓名：</td>
						<td align="left"  style="width:160px">
							${helper.contactName}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >身份证号：</td>
						<td align="left"  style="width:160px">
							${helper.idCardNo}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮号类型：</td>
						<td align="left"  style="width:160px">
							${helper.categoryCode}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >用户ID：</td>
						<td align="left"  style="width:160px">
							${helper.userId}
						</td>
						<td align="left"></td>
					</tr>
		</table>
	</form>
 </div>
</body>
</html>