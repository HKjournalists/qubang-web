/**    
 * Copyright (C),Kingmed
 * @FileName: Dict.java  
 * @Package: com.kingmed.platform.modules.quickQuery.configs  
 * @Description: //模块目的、功能描述  
 * @Author HuangSiwei  
 * @Date 2014年8月28日 下午2:45:03  
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
 * @create 2014年8月28日 下午2:45:03
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customDict")
public class CustomDict {

	@XmlAttribute(required = true)
	private String id;

	@XmlValue
	private String sql;

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
	 * 返回 sql 的值
	 * 
	 * @return sql
	 */

	public String getSql() {
		return sql;
	}

	/**
	 * 设置 sql 的值
	 * 
	 * @param sql
	 */

	public void setSql(String sql) {
		this.sql = sql;
	}

}
