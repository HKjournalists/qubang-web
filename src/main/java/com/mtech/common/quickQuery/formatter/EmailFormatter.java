/**    
 * Copyright (C),Kingmed
 * @FileName: EmailFormatter.java  
 * @Package: com.kingmed.platform.modules.quickQuery.formatter  
 * @Description: //模块目的、功能描述  
 * @Author HuangSiwei  
 * @Date 2014年8月25日 上午11:07:03  
 * @History: //修改记录
 * 〈author〉      〈time〉      〈version〉       〈desc〉
 * 修改人姓名            修改时间            版本号              描述   
 */

package com.mtech.common.quickQuery.formatter;

/**
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年8月25日 上午11:07:03
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class EmailFormatter implements IFormatter {

	@Override
	public String format(Object value) {
		String email = value == null ? "" : value.toString();
		return "<a href=\"mailto:" + email + "\">" + email + "</a>";
	}

}
