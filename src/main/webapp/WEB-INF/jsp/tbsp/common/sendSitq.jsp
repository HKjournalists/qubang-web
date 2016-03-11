<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
/**
 * 发送站内信
 * @param param
 */
function openSendSiteqDialog(param){
	var options = {
	        dialogId : "sendqDialog", //发送站内信
	        dialog : { 
				height: 400
			   ,width: 700
			   ,title:"发送站内信"
			   ,url: appCtx['mtech-message-web']+'/siteq/sendSiteq.html'
			   ,isHidden:false
			   ,data:param
			   ,buttons: [
                      { text: '发送', onclick: function (item, dialog) { dialog.frame.save();}},
                      { text: '关闭', onclick: function (item, dialog) { dialog.close(); } }
                   ]
			}
	    };
	openDialog(options);
}
</script>
