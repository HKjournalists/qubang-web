<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/tbsp/common/taglibs.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>查看常用帮助收藏</title>
	<%@include file="/WEB-INF/jsp/tbsp/common/metas.jsp"%>
	<%@include file="/WEB-INF/jsp/tbsp/common/scriptBase.jsp"%>
	<%@include file="/WEB-INF/jsp/tbsp/common/scriptForm.jsp"%>
</head>
<body>
<div class="contentbox top5">
	<form style="margin-left: 30px;" name="form1" id="form1" action="${ctx}/usr/userHelpFavorite/userHelpFavoriteSave.json" method="post" submitType="ajaxSubmit" ajaxCallBack="formCallBack">
		<div id="errorLabelContainer"></div>
		<table cellpadding="0" cellspacing="0" class="l-table">
		            <tr>
						<td align="right" >用户ID：</td>
						<td align="left"  style="width:160px">
							${userHelpFavorite.userId}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >配送地址：</td>
						<td align="left"  style="width:160px">
							${userHelpFavorite.delAddr}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮助内容：</td>
						<td align="left"  style="width:160px">
							${userHelpFavorite.helpContent}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮豆：</td>
						<td align="left"  style="width:160px">
							${userHelpFavorite.helpNum}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >红包金额：</td>
						<td align="left"  style="width:160px">
							${userHelpFavorite.cost}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >是否可用：</td>
						<td align="left"  style="width:160px">
							${userHelpFavorite.available}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >使用次数：</td>
						<td align="left"  style="width:160px">
							${userHelpFavorite.usedNum}
						</td>
						<td align="left"></td>
					</tr>
		</table>
	</form>
 </div>
</body>
</html>