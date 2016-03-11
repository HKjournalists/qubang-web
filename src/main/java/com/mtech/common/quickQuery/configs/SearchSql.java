/**    
 * Copyright (C),Kingmed
 * @FileName: SearchSql.java  
 * @Package: com.kingmed.platform.modules.quickQuery.configs  
 * @Description: //模块目的、功能描述  
 * @Author HuangSiwei  
 * @Date 2014年8月28日 下午1:47:16  
 * @History: //修改记录
 * 〈author〉      〈time〉      〈version〉       〈desc〉
 * 修改人姓名            修改时间            版本号              描述   
 */

package com.mtech.common.quickQuery.configs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年8月28日 下午1:47:16
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class SearchSql {

	@XmlElement
	private String baseSql;

	@XmlElement
	private String groupSql;

	/**
	 * 返回 baseSql 的值
	 * 
	 * @return baseSql
	 */

	public String getBaseSql() {
		return baseSql;
	}

	/**
	 * 设置 baseSql 的值
	 * 
	 * @param baseSql
	 */

	public void setBaseSql(String baseSql) {
		this.baseSql = baseSql;
	}

	/**
	 * 返回 groupSql 的值
	 * 
	 * @return groupSql
	 */

	public String getGroupSql() {
		return groupSql;
	}

	/**
	 * 设置 groupSql 的值
	 * 
	 * @param groupSql
	 */

	public void setGroupSql(String groupSql) {
		this.groupSql = groupSql;
	}

}
