/**    
 * Copyright (C),Kingmed
 * @FileName: Querys.java  
 * @Package: com.kingmed.platform.modules.quickQuery.configs  
 * @Description: //模块目的、功能描述  
 * @Author HuangSiwei  
 * @Date 2014年8月27日 上午9:21:11  
 * @History: //修改记录
 * 〈author〉      〈time〉      〈version〉       〈desc〉
 * 修改人姓名            修改时间            版本号              描述   
 */

package com.mtech.common.quickQuery.configs;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年8月27日 上午9:21:11
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "querys")
public class Querys {

	@JsonIgnore
	@XmlAttribute
	private String id;

	@JsonIgnore
	@XmlElementWrapper(name = "dicts")
	@XmlElement(name = "customDict")
	private List<CustomDict> cdList;

	@JsonIgnore
	@XmlElementWrapper(name = "formatters")
	@XmlElement(name = "formatter")
	private List<Formatter> fmatterList;

	@XmlElement(name = "query")
	private List<Query> querys;

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
	 * 返回 cdList 的值
	 * 
	 * @return cdList
	 */

	public List<CustomDict> getCdList() {
		return cdList;
	}

	/**
	 * 设置 cdList 的值
	 * 
	 * @param cdList
	 */

	public void setCdList(List<CustomDict> cdList) {
		this.cdList = cdList;
	}

	/**
	 * 返回 fmatterList 的值
	 * 
	 * @return fmatterList
	 */

	public List<Formatter> getFmatterList() {
		return fmatterList;
	}

	/**
	 * 设置 fmatterList 的值
	 * 
	 * @param fmatterList
	 */

	public void setFmatterList(List<Formatter> fmatterList) {
		this.fmatterList = fmatterList;
	}

	/**
	 * 返回 querys 的值
	 * 
	 * @return querys
	 */

	public List<Query> getQuerys() {
		return querys;
	}

	/**
	 * 设置 querys 的值
	 * 
	 * @param querys
	 */

	public void setQuerys(List<Query> querys) {
		this.querys = querys;
	}

	/**
	 * 
	 * 根据id获取Querys文件中的字典配置
	 * 
	 * @param dictId
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public CustomDict getCustomDict(String dictId) {
		for (int i = 0; i < cdList.size(); i++) {

			CustomDict cd = cdList.get(i);
			if (StringUtils.equals(cd.getId(), dictId)) {
				return cd;
			}
		}
		return null;
	}

	/**
	 * 
	 * 根据id获取Querys文件中的格式器配置
	 * 
	 * @param dictId
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public Formatter getFormatter(String fmatterId) {
		for (int i = 0; i < fmatterList.size(); i++) {

			Formatter f = fmatterList.get(i);
			if (StringUtils.equals(f.getId(), fmatterId)) {
				return f;
			}
		}
		return null;
	}
}
