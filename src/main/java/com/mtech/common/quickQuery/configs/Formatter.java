/**    
 * Copyright (C),Kingmed
 * @FileName: Formatter.java  
 * @Package: com.kingmed.platform.modules.quickQuery.configs  
 * @Description: //模块目的、功能描述  
 * @Author HuangSiwei  
 * @Date 2014年9月4日 下午2:43:55  
 * @History: //修改记录
 * 〈author〉      〈time〉      〈version〉       〈desc〉
 * 修改人姓名            修改时间            版本号              描述   
 */

package com.mtech.common.quickQuery.configs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年9月4日 下午2:43:55
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Formatter {

	@XmlAttribute
	private String id;

	@XmlAttribute
	private String ref;

	@XmlAttribute(name = "class")
	private String clazz;

	@XmlElementWrapper(name = "properties")
	@XmlElement(name = "property")
	private List<Property> properties;

	/**
	 * 返回 id 的值
	 * 
	 * @return id
	 */

	public String getId() {
		return id;
	}

	/**
	 * 设置 id 的值
	 * 
	 * @param id
	 */

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 返回 ref 的值
	 * 
	 * @return ref
	 */

	public String getRef() {
		return ref;
	}

	/**
	 * 设置 ref 的值
	 * 
	 * @param ref
	 */

	public void setRef(String ref) {
		this.ref = ref;
	}

	/**
	 * 返回 clazz 的值
	 * 
	 * @return clazz
	 */

	public String getClazz() {
		return clazz;
	}

	/**
	 * 设置 clazz 的值
	 * 
	 * @param clazz
	 */

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	/**
	 * 返回 properties 的值
	 * 
	 * @return properties
	 */

	public List<Property> getProperties() {
		return properties;
	}

	/**
	 * 设置 properties 的值
	 * 
	 * @param properties
	 */

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	/**
	 * 
	 * 〈一句话功能简述〉 功能详细描述
	 * 
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public Map<String, String> getPropertyMap() {
		Map<String, String> map = new HashMap<String, String>();
		if (properties != null) {
			for (Property property : properties) {
				map.put(property.getName(), property.getValue());
			}
		}
		return map;
	}
}
