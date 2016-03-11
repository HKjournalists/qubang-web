/**    
 * Copyright (C),Kingmed
 * @FileName: Condition.java  
 * @Package: com.kingmed.platform.modules.quickQuery.configs  
 * @Description: //模块目的、功能描述  
 * @Author HuangSiwei  
 * @Date 2014年8月26日 下午2:08:39  
 * @History: //修改记录
 * 〈author〉      〈time〉      〈version〉       〈desc〉
 * 修改人姓名            修改时间            版本号              描述   
 */

package com.mtech.common.quickQuery.configs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年8月26日 下午2:08:39
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Condition {

	@JsonIgnore
	@XmlAttribute
	private String field;

	@XmlAttribute
	private String name;

	@XmlAttribute
	private String label;

	@XmlAttribute
	private String searchType;

	@XmlAttribute
	private String showType;

	@XmlAttribute
	private String showCallback;

	@XmlAttribute
	private String defaultValue;

	@XmlAttribute
	private boolean hidden;

	/**
	 * 返回 field 的值
	 * 
	 * @return field
	 */

	public String getField() {
		return field;
	}

	/**
	 * 设置 field 的值
	 * 
	 * @param field
	 */

	public void setField(String field) {
		this.field = field;
	}

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
	 * 返回 label 的值
	 * 
	 * @return label
	 */

	public String getLabel() {
		return label;
	}

	/**
	 * 设置 label 的值
	 * 
	 * @param label
	 */

	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * 返回 searchType 的值
	 * 
	 * @return searchType
	 */

	public String getSearchType() {
		return searchType;
	}

	/**
	 * 设置 searchType 的值
	 * 
	 * @param searchType
	 */

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	/**
	 * 返回 showType 的值
	 * 
	 * @return showType
	 */

	public String getShowType() {
		return showType;
	}

	/**
	 * 设置 showType 的值
	 * 
	 * @param showType
	 */

	public void setShowType(String showType) {
		this.showType = showType;
	}

	/**
	 * 返回 showCallback 的值
	 * 
	 * @return showCallback
	 */

	public String getShowCallback() {
		return showCallback;
	}

	/**
	 * 设置 showCallback 的值
	 * 
	 * @param showCallback
	 */

	public void setShowCallback(String showCallback) {
		this.showCallback = showCallback;
	}

	/**
	 * 返回 defaultValue 的值
	 * 
	 * @return defaultValue
	 */

	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * 设置 defaultValue 的值
	 * 
	 * @param defaultValue
	 */

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * 返回 hidden 的值
	 * 
	 * @return hidden
	 */

	public boolean isHidden() {
		return hidden;
	}

	/**
	 * 设置 hidden 的值
	 * 
	 * @param hidden
	 */

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

}
