/**    
 * Copyright (C),Kingmed
 * @FileName: Property.java  
 * @Package: com.kingmed.platform.modules.quickQuery.configs  
 * @Description: //模块目的、功能描述  
 * @Author HuangSiwei  
 * @Date 2014年9月4日 下午3:29:07  
 * @History: //修改记录
 * 〈author〉      〈time〉      〈version〉       〈desc〉
 * 修改人姓名            修改时间            版本号              描述   
 */

package com.mtech.common.quickQuery.configs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年9月4日 下午3:29:07
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Property {
	
	@XmlAttribute(required = true)
	public String name;
	
	@XmlValue
	public String value;

	/**
	 * 返回 name 的值
	 * 
	 * @return name
	 */

	public String getName() {
		return name;
	}

	/**
	 * 设置 name 的值
	 * 
	 * @param name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 返回 value 的值
	 * 
	 * @return value
	 */

	public String getValue() {
		return value;
	}

	/**
	 * 设置 value 的值
	 * 
	 * @param value
	 */

	public void setValue(String value) {
		this.value = value;
	}

}
