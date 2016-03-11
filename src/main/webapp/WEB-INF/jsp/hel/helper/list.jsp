<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/tbsp/common/taglibs.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>功能作者-待添加管理</title>
    <%@include file="/WEB-INF/jsp/tbsp/common/metas.jsp"%>
    <%@include file="/WEB-INF/jsp/tbsp/common/scriptBase.jsp"%>
    <%@include file="/WEB-INF/jsp/tbsp/common/scriptForm.jsp"%>
    <script type="text/javascript" src="${ctx}/static/hel/helper/list.js"></script>
  </head>
  
 
<body>
	<div class="contentbox navigaTop">功能作者-待添加管理</div>
    <div class="contentbox inner5 top5">
        <form id="helperQueryForm">
          	<table cellpadding="0" cellspacing="0" class="l-table">
		      
			      	     <tr>
			             <td align="right">帮号编号：</td>
			             <td align="left">
			  				<input type="text" ltype="text" stype="eq" name="helperNo" id="helperNo" />
			             </td>
			         
		      
			             <td align="right">帮号名称：</td>
			             <td align="left">
			  				<input type="text" ltype="text" stype="like" name="helperName" id="helperName" />
			             </td>
			         
		      
			             <td align="right">帮号简称：</td>
			             <td align="left">
			  				<input type="text" ltype="text" stype="like" name="simpleName" id="simpleName" />
			             </td>
			         
		      
			             <td align="right">帮号地址：</td>
			             <td align="left">
			  				<input type="text" ltype="text" stype="eq" name="addr" id="addr" />
			             </td>
			         
			              </tr>
		      
			      	     <tr>
			             <td align="right">帮号坐标：</td>
			             <td align="left">
			  				<input type="text" ltype="text" stype="eq" name="location" id="location" />
			             </td>
			         
		      
			             <td align="right">联系电话：</td>
			             <td align="left">
			  				<input type="text" ltype="text" stype="eq" name="phone" id="phone" />
			             </td>
			         
		      
			             <td align="right">功能介绍：</td>
			             <td align="left">
			  				<input type="text" ltype="text" stype="eq" name="functionDesc" id="functionDesc" />
			             </td>
			         
		      
			             <td align="right">已帮助数：</td>
			             <td align="left">
			  				<input type="text" ltype="text" stype="eq" name="helpedNum" id="helpedNum" />
			             </td>
			         
			              </tr>
		      
			      	     <tr>
			             <td align="right">发起的帮助数：</td>
			             <td align="left">
			  				<input type="text" ltype="text" stype="eq" name="allHelpNum" id="allHelpNum" />
			             </td>
			         
		      
			             <td align="right">标签：</td>
			             <td align="left">
			  				<input type="text" ltype="text" stype="eq" name="tags" id="tags" />
			             </td>
			         
		      
			             <td align="right">联系人姓名：</td>
			             <td align="left">
			  				<input type="text" ltype="text" stype="like" name="contactName" id="contactName" />
			             </td>
			         
		      
			             <td align="right">身份证号：</td>
			             <td align="left">
			  				<input type="text" ltype="text" stype="eq" name="idCardNo" id="idCardNo" />
			             </td>
			         
			              </tr>
		      
			      	     <tr>
			             <td align="right">帮号类型：</td>
			             <td align="left">
			  				<input type="text" ltype="text" stype="eq" name="categoryCode" id="categoryCode" />
			             </td>
			         
		      
			             <td align="right">用户ID：</td>
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