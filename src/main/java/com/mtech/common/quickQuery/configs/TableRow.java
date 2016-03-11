/**    
 * Copyright (C),Kingmed
 * @FileName: TableRow.java  
 * @Package: com.kingmed.platform.modules.quickQuery.configs  
 * @Description: //模块目的、功能描述  
 * @Author HuangSiwei  
 * @Date 2014年9月2日 下午3:22:51  
 * @History: //修改记录
 * 〈author〉      〈time〉      〈version〉       〈desc〉
 * 修改人姓名            修改时间            版本号              描述   
 */

package com.mtech.common.quickQuery.configs;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年9月2日 下午3:22:51
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class TableRow {
	@XmlElement(name = "column")
	private List<Column> columns;

	/**
	 * 返回 columns 的值
	 * 
	 * @return columns
	 */

	public List<Column> getColumns() {
		return columns;
	}

	/**
	 * 设置 columns 的值
	 * 
	 * @param columns
	 */

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

}
