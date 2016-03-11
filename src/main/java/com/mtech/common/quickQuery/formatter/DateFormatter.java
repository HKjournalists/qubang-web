/**    
 * Copyright (C),Kingmed
 * @FileName: DateFormatter.java  
 * @Package: com.kingmed.platform.modules.quickQuery.formatter  
 * @Description: //模块目的、功能描述  
 * @Author HuangSiwei  
 * @Date 2014年8月25日 上午10:47:04  
 * @History: //修改记录
 * 〈author〉      〈time〉      〈version〉       〈desc〉
 * 修改人姓名            修改时间            版本号              描述   
 */

package com.mtech.common.quickQuery.formatter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年8月25日 上午10:47:04
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component(value = "quickGridDateFormatter")
public class DateFormatter implements IFormatter {

	private static final String DEFAULT_PATTERN = "yyyy-MM-dd";
	private String pattern = DEFAULT_PATTERN;

	@Override
	public String format(Object val) {
		if (val instanceof Date) {
			Date value = (Date) val;
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);

			return sdf.format(value);
		}
		return val == null ? null : val.toString();
	}

	/**
	 * 返回 pattern 的值
	 * 
	 * @return pattern
	 */

	public String getPattern() {
		return pattern;
	}

	/**
	 * 设置 pattern 的值
	 * 
	 * @param pattern
	 */

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}
