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
	<form style="margin-left: 30px;" name="form1" id="form1" action="${ctx}/hel/helpReply/helpReplySave.json" method="post" submitType="ajaxSubmit" ajaxCallBack="formCallBack">
		<div id="errorLabelContainer"></div>
		<table cellpadding="0" cellspacing="0" class="l-table">
		            <tr>
						<td align="right" >回复内容：</td>
						<td align="left"  style="width:160px">
							${helpReply.replyContent}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮助id：</td>
						<td align="left"  style="width:160px">
							${helpReply.helpId}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >回复人id：</td>
						<td align="left"  style="width:160px">
							${helpReply.replyUserId}
						</td>
						<td align="left"></td>
					</tr>
		</table>
	</form>
 </div>
</body>
</html>