/**   
 * TODO(用一句话描述该文件做什么) 
 * @author Jiarong 
 * @date 2014年12月4日 下午3:15:38 
 * @version 0.0.1
 */
package com.mtech.common.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/** 
 * 原封不动返回Body内容，用于转出特殊标签信息，
 * 可以配合xmp标签使用使用
 *
 * @author Jiarong
 * @date 2014年12月4日 下午3:15:38 
 * @version 0.0.1
 *  
 */
public class PureTag extends BodyTagSupport {
	/**
	 * TODO 
	 * @return
	 * @throws JspException 
	 * @see javax.servlet.jsp.tagext.BodyTagSupport#doStartTag() 
	 */
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_BODY_INCLUDE;
	}
	/**
	 * TODO 
	 * @return
	 * @throws JspException 
	 * @see javax.servlet.jsp.tagext.BodyTagSupport#doEndTag() 
	 */
	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().write(getBodyContent()==null?"":getBodyContent().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}
	
}
