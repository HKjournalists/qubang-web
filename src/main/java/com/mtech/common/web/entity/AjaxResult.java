package com.mtech.common.web.entity;

public class AjaxResult {
	 public static String  SUC_DEF_MSG="执行成功！";
	    public static String  FAIL_DEF_MSG="执行失败！";
		private boolean success;
		private String msg;
		private Object returnObj;
		
	   private AjaxResult(){
		   
	   }
		private AjaxResult(boolean success, String msg, Object obj) {
			super();
			this.success = success;
			this.msg = msg;
			this.returnObj = obj;
		}
		public static AjaxResult  fail(){
			return fail(FAIL_DEF_MSG, null);
		}
		public static AjaxResult  fail(String msg){
			return fail(msg, null);
		}
		public static AjaxResult  fail(String msg, Object obj){
			AjaxResult result = new AjaxResult(false, msg,obj);
			return result;
		}
		
		
		
		public static AjaxResult  suc(){
			return suc(SUC_DEF_MSG, null);
		}
		
		public static AjaxResult  suc( Object returnObj){
			return suc(SUC_DEF_MSG, returnObj);
		}
		
		public static AjaxResult  suc(String msg, Object obj){
			AjaxResult executeResult =new AjaxResult(true, msg,obj);
			return executeResult;
		}
		public boolean isSuccess() {
			return success;
		}
		public void setSuccess(boolean success) {
			this.success = success;
		}
		public String getMsg() {
			return msg;
		}
		public Object getReturnObj() {
			return returnObj;
		}
		
}
