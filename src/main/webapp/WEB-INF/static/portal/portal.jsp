<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- Bootstrap -->
<link rel="stylesheet" href="${ctx}/static/portal/css/portal-all.css">
<!-- Bootstrap -->
<script src="${ctx}/static/portal/js/dropdown.js"></script>
<script type="text/javascript">
function changePasswd(){
	//打开弹出窗口
	var options = {
		dialogId : "changePasswdDialog", //指定别名，自定义关闭时需此参数
		dialog : {
			title : "修改密码",
			height : 280,
            width : 550,
            showMax: true, 
			url : ctx+'/workbench/changePasswd.html?data='+ new Date(),
			buttons: [
			          { text: '保存', onclick: function (item, dialog) { dialog.frame.save();}},
                       { text: '关闭', onclick: function (item, dialog) { dialog.close(); } }
                    ]
		}
		//,callBack : "closechangePasswdDialogCallBack" //自定义窗口关闭回调函数
	};
	openDialog(options);
}

function showPersonInfo(){
		//打开弹出窗口
		var options = {
			dialogId : "personInfoDialog", //指定别名，自定义关闭时需此参数
			dialog : {
				title : "个人中心",
				height : 280,
	            width : 550,
	            showMax: true, 
				url : ctx+'/workbench/personInfo.html?data='+ new Date(),
				buttons: [
	                       { text: '关闭', onclick: function (item, dialog) { dialog.close(); } }
	                    ]
			},
			callBack : "closepersonInfoDialogCallBack" //自定义窗口关闭回调函数
		};
		openDialog(options);
}
function bindMenuEvent(){
	//展开左侧主菜单
	$("div[id='left-btn']").unbind().click(function(){
		  $(this).toggleClass('left-btn-l');
		  $(".flexfa").toggleClass('fa-angle-double-right');
		  $(".rmain").toggleClass('wmain');
		  $(".wleft").toggleClass('oleft');
	});
	var accordion_head = $('.subnav > .subnav-title'),
	accordion_body = $('.subnav > .subnav-menu');
	accordion_head.first().next().slideDown('normal');
	accordion_head.on('click', function(event) {
		event.preventDefault();
		if ($(this).next(".subnav-menu").is(":hidden")){
			accordion_body.slideUp('normal');
			$(this).next().stop(true,true).slideToggle('normal');
			accordion_head.removeClass('active');
			$(this).addClass('active');
			adjustContentWindowHeight(this,true);
		}else{
			accordion_body.slideUp('normal');
			accordion_head.removeClass('active');
			$(this).addClass('active');
			adjustContentWindowHeight(this,false);
		}
	});
}
</script>
<script type="text/javascript">
/*========================加载菜单::开始=========================*/
var menu = {
		createSubNav:function(data1){
			 var html = "";
		     html += "<div class='subnav'><div class='subnav-title'>";
		     html += "<a href='javascript:void(0);' class='toggle-subnav'";
		     if(data1.url){
		    	 if(data1.target=='BLANK'){
			    	 html += "onclick='popup(\""+data1.menuName+"\", \""+data1.url+"\")'"; 
			     }else{
			    	 html += "onclick='f_addTab(\""+data1.menuName+"\", \""+data1.url+"\",\""+data1.id+"\")'"; 
			     }
		     } 
		     html += "><i class='fa ";
		     if(data1.icon){ html += data1.icon; }else{ html += " fa-angle-down"; }
		     html += "'></i><span>"+data1.menuName+"</span></a></div>";
		     if(data1.children){ html += this.createSubnavMenu(data1.children); }
			 html += "</div>";
			 return html;
		},
		createSubnavMenu:function(data){
			var subMenu = "<ul class='subnav-menu'>";
			for(var i=0;i<data.length;i++){
				var data1 = data[i];
				if(data1.children){
					subMenu += this.createSubLi(data1);
				}else{
					subMenu += "<li><a href='javascript:void(0);'";
					  if(data1.url){
					    	 if(data1.target=='BLANK'){
					    		 subMenu += "onclick='popup(\""+data1.menuName+"\", \""+data1.url+"\")'";
						     }else{
						    	 subMenu += "onclick='f_addTab(\""+data1.menuName+"\", \""+data1.url+"\", \""+data1.id+"\")'"; 
						     }
					     } 
					subMenu += ">"+data1.menuName+"</a></li>";
				}
			}
			subMenu +="</ul>";
			return subMenu;
		},
		createSubLi:function(data1){
			var subMenu = "<li class='dropdown'>";
			subMenu += "<a href='javascript:void(0);' data-toggle='dropdown'";
			if(data1.url){subMenu += "onclick='f_addTab(\""+data1.menuName+"\", \""+data1.url+"\", \""+data1.id+"\")'";}
			subMenu += "><i class='fa '></i>&nbsp;"+data1.menuName+"</a>";
			subMenu += "<ul class='dropdown-menu'>";
			var children = data1.children;
			for(var i=0;i<children.length;i++){
				var child = children[i];
				subMenu +="<li><a href='javascript:void(0);'";
				if(child.url){
			    	 if(child.target=='BLANK'){
			    		 subMenu += "onclick='popup(\""+child.menuName+"\", \""+child.url+"\")'";
				     }else{
				    	 subMenu += "onclick='f_addTab(\""+child.menuName+"\", \""+child.url+"\", \""+child.id+"\")'";
				     }
			     }
				subMenu +=">"+child.menuName+"</a></li>";
			}
			subMenu += "</ul>";
			return subMenu;
		},
		getMenu:function(){
		   	$.ajax({    
		           type:'get',        
		           url:'${ctx}/workbench/menuList.json',    
		           dataType:'json', 
		           cache:false, 
		           success:function(data){
		               if(data && data.list){
		            	    $("#left").empty();
		            	    var list = data.list;
		            	    $("#left").append("<div id='left-btn' class='left-btn-r'><i class='fa fa-angle-double-left flexfa'></i></div>");
		            	    for(var i=0;i<list.length;i++){
		            	    	var data1 = list[i];
			             		$("#left").append(menu.createSubNav(data1));
		            	    }
		             		bindMenuEvent();
		               }
		           }    
		    });
		},
		closeMenu:function(){
			$(".dropdown").each(function(i){
				  if($(this).hasClass("open")){
					  $(this).removeClass("open");
				  }
		    });
		}
};
/*===========================================================*/

function popup(text,url) {
	var wth = $(window).width();
	var hht = $(window).height();
	//打开弹出窗口
	　window.open (url+'?data='+ new Date(), text, 'height=hht, width=wth, top=0, left=0,toolbar=no, menubar=no, scrollbars=no, resizable=no,location=n o, status=no') 
}
 

/*===========================================================*/
/*========================加载菜单::结束=========================*/
/*========================加载岗位::开始=========================*/
var orgJob = {
	getOrgJob:function(){
		$.ajax({    
	           type:'get',        
	           url:'${ctx}/workbench/listUserOrgJob.json',    
	           dataType:'json', 
	           cache:false, 
	           success:function(data){
	        	   if(data){
		        	   $("#portalOrgJob").append(orgJob.createOrgJob(data));
	        	   }
	           }    
	    });
	},
	createOrgJob:function(data){
		var orgJobHtml = "";
		for(var i=0;i<data.length;i++){
			orgJobHtml +="<li><a href='javascript:void(0);' onclick='orgJob.changeOrgJob(\""+data[i].orgId+"\",\""+data[i].jobId+"\")'>"+data[i].jobName+"@"+data[i].orgName+"</a></li>";
		} 
		return orgJobHtml;
	},
	changeOrgJob:function(orgId,jobId){
		$.ajax({    
	           type:'get',        
	           url:'${ctx}/workbench/changUserOrgJob.json', 
	           data:"orgId="+orgId+"&jobId="+jobId,
	           dataType:'json', 
	           cache:false, 
	           success:function(data){
	        	   window.location.reload();
	           }    
	    });
	}
	
};
/*========================加载岗位::结束=========================*/
/*========================加载消息::开始=========================*/
var message = {
	getMessage:function(){
	    $.ajax({  
            type : "get",  
            //async : false,  
            url:appCtx['mtech-message-web']+"/site/siteIndex.json?callback=?",  
            dataType : "jsonp",  
            jsonp : "callback", //传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback)  
            jsonpCallback : "handler", //自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名，也可以写"?"，jQuery会自动为你处理数据  
            success : function(data) {  
            	 if(data){
            		$("#messagediv").empty();
		        	$("#messagediv").append(message.createMsgTip(data));
	        	 }
            },  
            error : function() {  
                console.error('An error occurred getMessage()');  
            }  
        });  
	} ,
	createMsgTip:function(data){
		var html = "";
			html += "<a href='#' class='dropdown-toggle' data-toggle='dropdown'>";
			html += "<i class='fa fa-envelope'></i>";
			if(data.totalElements > 0){
				html += "<span class='label label-lightred'>"+data.totalElements+"</span>";
			}
		    html += "</a>";
			html += message.createMsgLi(data.content);
		return html;
	},
	createMsgLi:function(data){
		var li = "";
			li += "<ul class='dropdown-menu pull-right message-ul'>";
		if(data && data.length > 0){
				for(var i=0;i<data.length;i++){
					var obj = data[i];
					li += "<li>";
					li += "<a href='javascript:void(0);' onclick='message.readSiteMsg(\""+obj.title+"\",\""+obj.id+"\")'>";
					li += "<img class='headiconradio' src='"+ctx+"/static/portal/img/demo/user-1.jpg' alt=''>";
					li += "<div class='details'>";
					li += "<div class='name'>"+obj.createBy+"</div>";
					li += "<div class='message'>";
					li += obj.createDate+obj.title;
					li += "</div>";
					li += "</div>";
					li += "</a>";
					li += "</li>"; 
				} 
		}
		li += "<li><a href='javascript:void(0);' onclick='message.openSiteMsgCenter(\""+new Date().getTime()+"\")' class='more-messages'>";
		li += "马上去消息中心";
		li += "<i class='fa fa-arrow-right'></i>";
		li += "</a></li>";
		li += "</ul>";
		return li;
	},
	openSiteMsgCenter:function(tabId){
		f_addTab("消息中心",appCtx['mtech-message-web']+"/site/siteList.html",tabId);
	},
	readSiteMsg:function(title,id){
		//f_addTab(title,appCtx['mtech-message-web']+"/site/siteDetail.html?id="+id,id);
		var options = {
		        dialogId : "readSiteMsg", 
		        dialog : {
		            title : title,
		            height : 390,
		            width : 700,
		            url : appCtx['mtech-message-web']+"/site/siteDetail.html?id="+id,
		            buttons: [
		               { text: '关闭', onclick: function (item, dialog) { dialog.close(); } }
		            ]
		        }
		    };
		    openDialog(options);
	}
};
/*========================加载岗位::结束=========================*/
$(function(){
	menu.getMenu();//初始化菜单
	//orgJob.getOrgJob();//初始化岗位列表
	//message.getMessage();//初始化消息列表
});
</script>
<Script type="text/javascript">
/*=======================主区域布局::开始=========================*/
var tab = null;
var tabItems = [];
$(function (){
    //布局
    $("#left").ligerLayout({leftWidth: 190});
    //var height = $(window).height()+1000;
    $("#framecenter").ligerTab({
        //height: height,
        changeHeightOnResize:true,
        showSwitchInTab : true,
        showSwitch: true,
        onAfterAddTabItem: function (tabdata){
            tabItems.push(tabdata);
        },
        onAfterRemoveTabItem: function (tabid){ 
            for (var i = 0; i < tabItems.length; i++){
                var o = tabItems[i];
                if (o.tabid == tabid){
                    tabItems.splice(i, 1);
                    break;
                }
            }
        },
        onReload: function (tabdata){
            var tabid = tabdata.tabid;
        }
    });

    tab = liger.get("framecenter");
    $("#pageloading").hide();
	$("#framecenter > div[class='l-tab-content'] > [tabid='home']").height($(window).height()-78);
});
function f_addTab(text,url,tabid){
	f_addTabWithData(text,url,null,tabid);
}
function f_addTabById(text,url,tabid){
	f_addTabWithData(text,url,null,tabid);
}
function f_addTabWithData(text,url,data,tabid){
	if(!tabid){tabid = new Date().getTime();}
    tab.addTabItem({
        tabid: tabid,
        text: text,
        data:data,
        url: url,
        callback: function (){
        	var _$tab = $("#framecenter > div[class='l-tab-content'] > [tabid='"+tabid+"']");
        	var _windowHeight = $(window).height()-78;
        	if(_$tab.height() < _windowHeight){
        		_$tab.height(_windowHeight);
        	}
        }
    });
}
function f_addTabByIdReload(text, url, tabid){
	if(!tab.isTabItemExist(tabid)){
		f_addTabWithData(text,url,null,tabid)
	}else{
		tab.removeSelectedTabItem();
		tab.selectTabItem(tabid);
		tab.reload(tabid);
	}
}
function f_getCurrentTabId(){
	var $div = $("#framecenter > div[class='l-tab-content'] > div[class='l-tab-content-item']:visible");
	return $div.attr("tabid");
}
function f_getSelectTabData(tabid){
	if(!tabid){
		var $div = $("#framecenter > div[class='l-tab-content'] > div[class='l-tab-content-item']:visible");
		tabid = $div.attr("tabid");
	}
	return $("iframe[id='"+tabid+"']").data("tabData");
}
function f_removeTabById(tabid){
	tab.removeTabItem(tabid);
}
function iFrameHeight(height) {
	var $div = $("#framecenter > div[class='l-tab-content'] > div[class='l-tab-content-item']:visible");
	var _tabid = $div.attr("tabid");
	var _height = $div.height();
	if(_height < height){
    	$("#framecenter > div[class='l-tab-content'] > [tabid='"+_tabid+"']").height(height);
    	$("#framecenter > div[class='l-tab-content'] > [tabid='"+_tabid+"']").attr("tabheight",height);
	}
}
/**增加页面高度*/
function increaseIFrameHeight(shifting){
	var $div = $("#framecenter > div[class='l-tab-content'] > div[class='l-tab-content-item']:visible");
	var _tabid = $div.attr("tabid");
	var _height = $div.height();
    $("#framecenter > div[class='l-tab-content'] > [tabid='"+_tabid+"']").height(_height+shifting);
}
/**减少页面高度*/
function decreaseIFrameHeight(shifting){
	var $div = $("#framecenter > div[class='l-tab-content'] > div[class='l-tab-content-item']:visible");
	var _tabid = $div.attr("tabid");
	var _height = $div.height();
    $("#framecenter > div[class='l-tab-content'] > [tabid='"+_tabid+"']").height(_height-shifting);
}
/**菜单调整页面高度*/
function adjustContentWindowHeight(obj,operation){
	//计算菜单高度
	var menuHeight = $("#left").height()-32;
	if (operation){
		var _li_height = $(obj).next(".subnav-menu").children("li").height();
		var _li_size = $(obj).next(".subnav-menu").children("li").size();
		var _subMenuHeight = _li_height*_li_size;
		var _title_size = $(obj).parent(".subnav").siblings().size()+1;
		var _title_Height = $(obj).height();
		var _menu_title_Height = _title_size*_title_Height;
		if((_menu_title_Height+_subMenuHeight) > menuHeight){
			menuHeight = _menu_title_Height+_subMenuHeight-32;
		}
	}
	if(tabItems.length==0){
		$("#framecenter > div[class='l-tab-content'] > [tabid='home']").height(menuHeight);
		$("#left").height(menuHeight+32);
	}else{
		var $div = $("#framecenter > div[class='l-tab-content'] > div[class='l-tab-content-item']:visible");
    	var _tabid = $div.attr("tabid");
    	var _tabHeight = $div.attr("tabheight");
    	if(!_tabHeight){
	    	var _windowHeight = $(window).height()-78;
    		if(_windowHeight < menuHeight){
		    	$("#framecenter > div[class='l-tab-content'] > [tabid='"+_tabid+"']").height(menuHeight);
		    	$("#left").height(menuHeight+32);
    		}else{
    			$("#framecenter > div[class='l-tab-content'] > [tabid='"+_tabid+"']").height(_windowHeight);
		    	$("#left").height(_windowHeight+32);
    		}
    	}
	}
}
/*=======================主区域布局::结束=========================*/
/*=======================Portal登出操作=========================*/
var LogoutUtils = {
	appIndex : 0,
	logoutFrame : null,
	logout : function(){
		$.ajax({
			 url : ctx + "/workbench/logout.json",
			 type: "POST",
			 dataType:"json",
			 success: function(msg){
				 if(msg.success){
				   location.href= ctx +"/workbench/login.html";
				 }else{
					 $.notice("退出失败","error");
				 }
			 }
		});
	}
} 

</script>
