<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/tbsp/common/taglibs.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>功能作者-待添加管理</title>
    <%@include file="/WEB-INF/jsp/tbsp/common/metas.jsp"%>
    <%@include file="/WEB-INF/jsp/tbsp/common/scriptBase.jsp"%>
    <%@include file="/WEB-INF/jsp/tbsp/common/scriptForm.jsp"%>
    <script type="text/javascript" src="${ctx}/static/hel/helperReview/list.js"></script>
  </head>
  
 
<body>
	<div class="contentbox navigaTop">功能作者-待添加管理</div>
    <div class="contentbox inner5 top5">
        <form id="helperReviewQueryForm">
          	<table cellpadding="0" cellspacing="0" class="l-table">
		      
			      	     <tr>
			             <td align="right">得分：</td>
			             <td align="left">
			  				<input type="text" ltype="text" stype="eq" name="score" id="score" />
			             </td>
			         
		      
			             <td align="right">内容：</td>
			             <td align="left">
			  				<input type="text" ltype="text" stype="eq" name="content" id="content" />
			             </td>
			         
		      
			             <td align="right">帮号ID：</td>
			             <td align="left">
			  				<input type="text" ltype="text" stype="eq" name="helperId" id="helperId" />
			             </td>
			         
		      
			             <td align="right">点评人ID：</td>
			             <td align="left">
			  				<input type="text" ltype="text" stype="eq" name="userId" id="userId" />
			             </td>
			         
			              </tr>
		    </table>  	 
        </form>
    </div>
    <div class="toolbar_btn top5">
    		<a class="search_button" href="javascript:void(0);" onclick="loadData()"><i class="fa fa-search"></i>查询</a>
	    	<a href="javascript:void(0);" class="l-button-2" onclick="add()"><i class="fa fa-plus"></i>增加</a>
	    	<a href="javascript:void(0);" class="l-button-2" onclick="edit()"><i class="fa fa-pencil"></i>修改</a>
	    	<a href="javascript:void(0);" class="l-button-2" onclick="del()"><i class="fa fa-trash-o"></i>删除</a>
	</div>
    <div class="contentbox">
		<div id="maingrid"></div>
		<div id="pagebar"></div>
    </div>
</body>
</html>