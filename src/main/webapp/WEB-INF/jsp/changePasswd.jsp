<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/tbsp/common/taglibs.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>应用管理</title>
	<%@include file="/WEB-INF/jsp/tbsp/common/metas.jsp"%>
	<%@include file="/WEB-INF/jsp/tbsp/common/scriptBase.jsp"%>
	<%@include file="/WEB-INF/jsp/tbsp/common/scriptForm.jsp"%>
    <script type="text/javascript">
        $(function(){
        	var dialog = frameElement.dialog; //调用页面的dialog对象(ligerui对象)
        });
        //保存
        function save(){
        	  if($("#seondPassword").val() != $("#password").val()){
        		  $.ligerDialog.warn("亲，你两次输入密码不一致！");
        		  return;
        	  }else if(($("#seondPassword").val() == $("#oldPassword").val())&& ($("#seondPassword").val()!="" && $("#seondPassword").val()!=null)){
        		  $.ligerDialog.warn("亲，新密码不能和原密码一样！");
        		  return;
        	  }
        	$("#form1").submit();
        }
        //ajax提交回调函数
        function formCallBack(data){
            if(data=="true"){
            	
                //关闭窗口
                
                $.ligerDialog.success('亲，密码修改成功!');
                //closeDialog({dialogId:"changePasswdDialog"});
            }else{
            	$.ligerDialog.warn('亲，你的原始密码不正确!');
            }
        }
    </script>
</head>
<body>
<div class="contentbox top5">
	<form style="margin-left: 30px;" name="form1" id="form1" action="${ctx}/workbench/changePasswd.json" method="post" submitType="ajaxSubmit" ajaxCallBack="formCallBack">
		<div id="errorLabelContainer"></div>
		<table cellpadding="0" cellspacing="0" class="l-table">
			<tr>
				<td align="right" >原密码:<span style="color: red;">*</span></td>
				<td align="left"  style="width:160px"><input
					name="oldPassword" type="password" id="oldPassword" ltype="text"
					validate="{required:true,maxlength:45}" /></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" >新密码:<span style="color: red;">*</span></td>
				<td align="left"  style="width:160px"><input
					name="password" type="password" id="password" ltype="text"
					validate="{required:true,minlength:6,maxlength:45}" /></td>
				<td align="left"></td>
			</tr>
			<tr>
				<td align="right" >重复密码:<span style="color: red;">*</span></td>
				<td align="left"  style="width:160px"><input
					 type="password" id="seondPassword" ltype="text"
					validate="{required:true,minlength:6,maxlength:45}" /></td>
				<td align="left"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>