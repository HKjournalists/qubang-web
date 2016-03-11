/**    
 * Copyright (C),Kingmed
 * @FileName: CriteriaBuilder.java  
 * @Package: com.kingmed.platform.modules.quickQuery.sqlBuild  
 * @Description: //模块目的、功能描述  
 * @Author HuangSiwei  
 * @Date 2014年8月28日 下午3:53:24  
 * @History: //修改记录
 * 〈author〉      〈time〉      〈version〉       〈desc〉
 * 修改人姓名            修改时间            版本号              描述   
 */

package com.mtech.common.quickQuery.sqlBuild;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年8月28日 下午3:53:24
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class CriteriaBuilder {
	/**
	 * 
	 * 〈一句话功能简述〉 功能详细描述
	 * 
	 * @param builder
	 * @param paramList
	 * @param field
	 * @param value
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public boolean equal(StringBuilder builder, List<Object> paramList,
			String field, String[] value) {
		if (value.length != 1 || StringUtils.isBlank(value[0])) {
			return false;
		}
		builder.append(field + " = ? ");
		paramList.add(value[0]);
		return true;
	}

	/**
	 * 
	 * 〈一句话功能简述〉 功能详细描述
	 * 
	 * @param builder
	 * @param paramList
	 * @param field
	 * @param value
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public boolean lessThan(StringBuilder builder, List<Object> paramList,
			String field, String[] value) {
		if (value.length != 1 || StringUtils.isBlank(value[0])) {
			return false;
		}
		builder.append(field + " < ? ");
		paramList.add(value[0]);
		return true;
	}

	/**
	 * 
	 * 〈一句话功能简述〉 功能详细描述
	 * 
	 * @param builder
	 * @param paramList
	 * @param field
	 * @param value
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public boolean lessThanOrEqualTo(StringBuilder builder,
			List<Object> paramList, String field, String[] value) {
		if (value.length != 1 || StringUtils.isBlank(value[0])) {
			return false;
		}
		builder.append(field + " <= ? ");
		paramList.add(value[0]);
		return true;
	}

	/**
	 * 
	 * 〈一句话功能简述〉 功能详细描述
	 * 
	 * @param builder
	 * @param paramList
	 * @param field
	 * @param value
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public boolean greaterThan(StringBuilder builder, List<Object> paramList,
			String field, String[] value) {
		if (value.length != 1 || StringUtils.isBlank(value[0])) {
			return false;
		}
		try{
			//尝试将参数转换为int类型，如果不成功，将忽略这个参数
			int intValue= Integer.parseInt(value[0]);
			builder.append(field + " > ? ");
			paramList.add(intValue);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}

	/**
	 * 
	 * 〈一句话功能简述〉 功能详细描述
	 * 
	 * @param builder
	 * @param paramList
	 * @param field
	 * @param value
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public boolean greaterThanOrEqualTo(StringBuilder builder,
			List<Object> paramList, String field, String[] value) {
		if (value.length != 1 || StringUtils.isBlank(value[0])) {
			return false;
		}
		builder.append(field + " >= ? ");
		paramList.add(value[0]);
		return true;
	}

	/**
	 * 
	 * 〈一句话功能简述〉 功能详细描述
	 * 
	 * @param builder
	 * @param paramList
	 * @param field
	 * @param value
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public boolean like(StringBuilder builder, List<Object> paramList,
			String field, String[] value) {
		if (value.length != 1 || StringUtils.isBlank(value[0])) {
			return false;
		}
		builder.append(field + " like ? ");
		paramList.add("%" + value[0] + "%");
		return true;
	}

	/**
	 * 
	 * 〈一句话功能简述〉 功能详细描述
	 * 
	 * @param builder
	 * @param paramList
	 * @param field
	 * @param value
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public boolean in(StringBuilder builder, List<Object> paramList,
			String field, String[] value) {
		if (0 > value.length) {
			return false;
		}

		builder.append(field + " in( ");
		for (int i = 0; i < value.length; i++) {
			builder.append("?");
			paramList.add(value[i]);
			if (i < value.length - 1) {
				builder.append(",");
			} else {
				builder.append(" ) ");
			}
		}
		return true;
	}

	/**
	 * 
	 * 〈一句话功能简述〉 功能详细描述
	 * 
	 * @param builder
	 * @param paramList
	 * @param field
	 * @param value
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public boolean between(StringBuilder builder, List<Object> paramList,
			String field, String[] value) {
		if (value != null && value[0].split(",").length == 2) {
			String val0 = value[0].split(",")[0];
			String val1 = value[0].split(",")[1];
			boolean blankVal0 = StringUtils.isBlank(val0);
			boolean blankVal1 = StringUtils.isBlank(val1);

			if (blankVal0) {
				if (!blankVal1) {// 查询第一个值为空，第二个值不为空，换成小于等于
					return this.lessThanOrEqualTo(builder, paramList, field,
							new String[] { val1 });
				}
			} else if (blankVal1) {// 查询第一个值不为空，第二个值为空，换成大于等于
				return this.greaterThanOrEqualTo(builder, paramList, field,
						new String[] { val0 });
			} else {// between
				builder.append(field + " between ? and ? ");
				paramList.add(val0);
				paramList.add(val1);
				return true;
			}
		}
		return false;
	}
}
