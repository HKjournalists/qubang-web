/**    
 * Copyright (C),Kingmed
 * @FileName: Grid.java  
 * @Package: com.kingmed.platform.modules.quickQuery.configs  
 * @Description: //模块目的、功能描述  
 * @Author HuangSiwei  
 * @Date 2014年8月27日 上午9:55:32  
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
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年8月27日 上午9:55:32
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Grid {

	@JsonIgnore
	@XmlAttribute
	private boolean distinct;

	@XmlElement(name = "table-row")
	private List<TableRow> tableRows;

	/**
	 * 返回 distinct 的值
	 * 
	 * @return distinct
	 */

	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * 设置 distinct 的值
	 * 
	 * @param distinct
	 */

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * 返回 tableRows 的值
	 * 
	 * @return tableRows
	 */

	public List<TableRow> getTableRows() {
		return tableRows;
	}

	/**
	 * 设置 tableRows 的值
	 * 
	 * @param tableRows
	 */

	public void setTableRows(List<TableRow> tableRows) {
		this.tableRows = tableRows;
	}

}
