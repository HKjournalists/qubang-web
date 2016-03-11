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
	<form style="margin-left: 30px;" name="form1" id="form1" action="${ctx}/hel/helperPic/helperPicSave.json" method="post" submitType="ajaxSubmit" ajaxCallBack="formCallBack">
		<div id="errorLabelContainer"></div>
		<table cellpadding="0" cellspacing="0" class="l-table">
		            <tr>
						<td align="right" >图片地址：</td>
						<td align="left"  style="width:160px">
							${helperPic.picUrl}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >图片大小：</td>
						<td align="left"  style="width:160px">
							${helperPic.picSize}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >图片名称：</td>
						<td align="left"  style="width:160px">
							${helperPic.picName}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >图片类型：</td>
						<td align="left"  style="width:160px">
							${helperPic.picType}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >所属帮号：</td>
						<td align="left"  style="width:160px">
							${helperPic.helperId}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >使用类型：</td>
						<td align="left"  style="width:160px">
							${helperPic.usedType}
						</td>
						<td align="left"></td>
					</tr>
		</table>
	</form>
 </div>
</body>
</html>