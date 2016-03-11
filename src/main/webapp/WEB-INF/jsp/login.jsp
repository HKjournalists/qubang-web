<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/tbsp/common/taglibs.jspf"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
   	<%@include file="/WEB-INF/jsp/tbsp/common/metas.jsp"%>
	<%@include file="/WEB-INF/jsp/tbsp/common/scriptBase.jsp"%>
	<%@include file="/WEB-INF/static/portal/portal.jsp"%>
	<title>万众科技调度系统</title>
	<link rel="stylesheet" href="${ctx}/static/css/cas.css" />
	
</head>

<script type="text/javascript">

function login(){
	var uname=$("#userName").val();
	var pwd=$("#pwd").val();
	$.ajax({
		 url : ctx + "/workbench/login.json",
		 type: "POST",
		 data: {userName:uname,pwd:pwd },
		 dataType:"json",
		 success: function(msg){
			 if(msg.success){
			   location.href= ctx +"/workbench/index.html";
			 }else{
				 $.notice("用户名或密码错误","error");
			 }
		 }
	});
}


</script>
<body>

<!-- <form action="" method="post">
    用户名：<input type="text" name="userName" id="userName" value="admin"><br/>
    密码：<input type="password" name="pwd" id="pwd" value="123456"><br/>
    <input type="button" value="登录" onclick="login()">
</form> -->


<div id="container" class="login">
      <div id="content">
		<div class="box" id="login">
		  <form method="post" id="fm1" commandName="credential" htmlEscape="true" >
		    <h2>登录</h2>
			  <div class="lable">
			      <label for="username">账号：
			          <input type="text" name="userName" id="userName"  value="admin" />
			      </label>
			      <label for="password">密码：
			          <input type="password" name="pwd" id="pwd" value="123456"/>
			      </label>
			  </div>
			  <section class="row btn-row" style="text-align: right;margin-top:20px;">
			      <input class="btn-submit" type="button" value="登录" onclick="login()" />
			  </section>
		  </form>
		</div>
  	  </div> 
	  <div class="foot">
	  <p>Coyright 2010-2015,All Rights Reserved</p>
	  <p>版权所有：万众科技有限公司</p>
	  </div>
    </div>

      </div> <!-- END #content -->
      
      <footer>
        <div id="copyright">
          <p>copyright © 2015 www.mtech.com.cn 版权所有|万众科技有限公司</p>
        </div>
      </footer>

    </div> <!-- END #container -->
    
</body>
</html>