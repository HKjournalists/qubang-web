package com.mtech.common.quickQuery.configs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 列定义
 * 
 * @author HuangSiwei
 * @create 2014年8月25日 上午9:22:56
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Column {
	public static final String TYPE_SEARCH = "search";
	public static final String TYPE_SHOW = "show";
	public static final String TYPE_BOTH = "both";

	@JsonIgnore
	@XmlAttribute
	private String type = TYPE_BOTH;

	@XmlAttribute
	private String name;

	@XmlAttribute
	private boolean checkbox;

	@XmlAttribute
	private String display;

	@JsonIgnore
	@XmlAttribute
	private String customDict;

	@JsonIgnore
	@XmlAttribute
	private String sysDict;

	@XmlAttribute
	private boolean hide;

	@XmlAttribute
	private boolean isSort;

	@XmlAttribute
	private String width;

	@XmlAttribute
	private String align;

	@JsonIgnore
	@XmlAttribute
	private String beanFormatter;

	@XmlAttribute
	private String formatter;

	/**
	 * 返回 checkbox 的值
	 * 
	 * @return checkbox
	 */

	public boolean isCheckbox() {
		return checkbox;
	}

	/**
	 * 设置 checkbox 的值
	 * 
	 * @param checkbox
	 */

	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}

	/**
	 * 返回 type 的值
	 * 
	 * @return type
	 */

	public String getType() {
		return type;
	}

	/**
	 * 设置 type 的值
	 * 
	 * @param type
	 */

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 返回 customDict 的值
	 * 
	 * @return customDict
	 */

	public String getCustomDict() {
		return customDict;
	}

	/**
	 * 设置 customDict 的值
	 * 
	 * @param customDict
	 */

	public void setCustomDict(String customDict) {
		this.customDict = customDict;
	}

	/**
	 * 返回 sysDict 的值
	 * 
	 * @return sysDict
	 */

	public String getSysDict() {
		return sysDict;
	}

	/**
	 * 设置 sysDict 的值
	 * 
	 * @param sysDict
	 */

	public void setSysDict(String sysDict) {
		this.sysDict = sysDict;
	}

	/**
	 * 返回 hidden 的值
	 * 
	 * @return hidden
	 */

	public boolean isHide() {
		return hide;
	}

	/**
	 * 设置 hidden 的值
	 * 
	 * @param hidden
	 */

	public void setHide(boolean hidden) {
		this.hide = hidden;
	}

	

	/**
	 * 返回 width 的值
	 * 
	 * @return width
	 */

	public String getWidth() {
		return width;
	}

	/**
	 * 设置 width 的值
	 * 
	 * @param width
	 */

	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * 返回 align 的值
	 * 
	 * @return align
	 */

	public String getAlign() {
		return align;
	}

	/**
	 * 设置 align 的值
	 * 
	 * @param align
	 */

	public void setAlign(String align) {
		this.align = align;
	}

	/**
	 * 返回 beanFormatter 的值
	 * 
	 * @return beanFormatter
	 */

	public String getBeanFormatter() {
		return beanFormatter;
	}

	/**
	 * 设置 beanFormatter 的值
	 * 
	 * @param beanFormatter
	 */

	public void setBeanFormatter(String beanFormatter) {
		this.beanFormatter = beanFormatter;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public boolean isSort() {
		return isSort;
	}

	public void setSort(boolean isSort) {
		this.isSort = isSort;
	}

	public String getFormatter() {
		return formatter;
	}

	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}
	
	

}
