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
	<form style="margin-left: 30px;" name="form1" id="form1" action="${ctx}/hel/help/helpSave.json" method="post" submitType="ajaxSubmit" ajaxCallBack="formCallBack">
		<div id="errorLabelContainer"></div>
		<table cellpadding="0" cellspacing="0" class="l-table">
		            <tr>
						<td align="right" >帮助编号：</td>
						<td align="left"  style="width:160px">
							${help.helpNo}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮助内容：</td>
						<td align="left"  style="width:160px">
							${help.helpContent}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮助费用：</td>
						<td align="left"  style="width:160px">
							${help.helpCost}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮号ID：</td>
						<td align="left"  style="width:160px">
							${help.helperId}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >发起帮助人ID：</td>
						<td align="left"  style="width:160px">
							${help.userId}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >接收帮助人ID：</td>
						<td align="left"  style="width:160px">
							${help.acceptUserId}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >使用的帮豆数：</td>
						<td align="left"  style="width:160px">
							${help.usedHelpNum}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >配送地址：</td>
						<td align="left"  style="width:160px">
							${help.delAddr}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >帮助状态：</td>
						<td align="left"  style="width:160px">
							${help.helpStatus}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >赞数：</td>
						<td align="left"  style="width:160px">
							${help.zan}
						</td>
						<td align="left"></td>
					</tr>
		            <tr>
						<td align="right" >点评数：</td>
						<td align="left"  style="width:160px">
							${help.reviewNum}
						</td>
						<td align="left"></td>
					</tr>
		</table>
	</form>
 </div>
</body>
</html>