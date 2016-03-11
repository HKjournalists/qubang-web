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
</head>
<body style="overflow-x:hidden;padding: 0px;height: 0px;" class="theme-green" data-theme="theme-green">
	<div id="navigation">
		<div class="container-fluid">
			<a href="#" id="brand"><img src="${ctx}/static/portal/images/logo.png" width="122" height="43"></a>
			<div class="user">
				<ul class="icon-nav">
					<li class='dropdown' id="messagediv">
				
					</li>
				</ul>
				<div class="dropdown" style="margin-right:3px;">
					<a href="#" class='dropdown-toggle' data-toggle="dropdown">admin - 调度系统管理员@广州万众科技有限公司
						<img class="headiconradio" src="${ctx}/static/portal/img/demo/user-avatar.jpg" alt="">
					</a>
					<ul class="dropdown-menu pull-right">
						<!-- <li>
							<a href="#" onclick="showPersonInfo()">个人中心</a>
						</li>
						<li>
							<a href="#" onclick="changePasswd()">密码修改</a>
						</li> -->
						<li>
							<a href="javascript:void(0);" onclick="LogoutUtils.logout()">退出</a>
						</li>
					</ul>
				</div>
                
                <!-- <div class="dropdown"><a href="#" data-toggle="dropdown" style="height:45px; line-height:28px; padding:10px 12px 6px 12px;">切换岗位</a>
                	<ul id="portalOrgJob" class="dropdown-menu pull-right">
					</ul>
                </div> -->
			</div>
		</div>
	</div>
	<div>
	  <div id="left" class="wleft">
	  </div>
	  <div id="main" class="rmain" position="center" style="padding: 0px;height:100%;">
		<div position="center" id="framecenter"> 
			<div tabid="home" title="我的主页">
				<iframe frameborder="0" scrolling="no" name="home" id="home" src="${welcomePage}"></iframe>
			</div> 
		</div> 
      </div>
	</div>
</body>
</html>

