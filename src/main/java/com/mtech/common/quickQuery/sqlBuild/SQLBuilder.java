/**    
 * Copyright (C),Kingmed
 * @FileName: SQLBuilder.java  
 * @Package: com.kingmed.platform.modules.quickQuery.sqlBuild  
 * @Description: //模块目的、功能描述  
 * @Author HuangSiwei  
 * @Date 2014年8月28日 上午10:40:09  
 * @History: //修改记录
 * 〈author〉      〈time〉      〈version〉       〈desc〉
 * 修改人姓名            修改时间            版本号              描述   
 */

package com.mtech.common.quickQuery.sqlBuild;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.mtech.common.quickQuery.configs.Condition;
import com.mtech.common.quickQuery.configs.Query;
import com.mtech.common.quickQuery.configs.SearchCondition;
import com.mtech.common.quickQuery.configs.SearchSql;

/**
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年8月28日 上午10:40:09
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class SQLBuilder {

	public enum Operator {
		EQ, LIKE, GT, LT, GTE, LTE, IN, BETWEEN
	}

	private Query query;
	private Map<String, String[]> paramMap;

	private List<Object> paramList = new ArrayList<Object>();
	private String order;
	private String sort;

	public SQLBuilder(Query query, Map<String, String[]> paramMap,
			String order, String sort) {
		super();
		this.query = query;
		this.paramMap = paramMap;
		this.order = order;
		this.sort = sort;
	}

	public String getBoundSQL() {
		StringBuilder select = new StringBuilder();

		SearchSql searchSql = query.getSearchSql();

		String baseSql = searchSql.getBaseSql();
		baseSql = baseSql.trim().toUpperCase();
		boolean endWhere = baseSql.endsWith("WHERE");

		String where = buildWhere();

		String groupSql = searchSql.getGroupSql();

		String orderBy = buildOrder();

		select.append(baseSql);
		where = where.trim();
		if (!endWhere && where.length() > 0) {
			select.append(" and");
		}
		select.append(" ");
		select.append(where);

		select.append(groupSql);

		select.append(orderBy);

		return select.toString();
	}

	private String buildWhere() {
		StringBuilder builder = new StringBuilder();
		if (paramMap != null) {
			SearchCondition searchCondition = query.getSearchCondition();
			List<Condition> conditionList = searchCondition.getConditionList();

			CriteriaBuilder cb = new CriteriaBuilder();
			List<StringBuilder> list = new ArrayList<StringBuilder>();
			for (int i = 0; i < conditionList.size(); i++) {
				boolean buildResult = false;
				Condition condition = conditionList.get(i);
				String searchType = condition.getSearchType();
				String field = condition.getField();
				String name = condition.getName();

				if (StringUtils.isNotBlank(searchType)) {
					searchType = searchType.toUpperCase();
					String[] value = paramMap.get(name);
					if (value == null) {
						continue;
					}

					StringBuilder br = new StringBuilder();
					Operator operator = Operator.valueOf(searchType);
					switch (operator) {
					case EQ:
						buildResult = cb.equal(br, paramList, field, value);
						break;
					case GT:
						buildResult = cb.greaterThan(br, paramList, field,
								value);
						break;
					case GTE:
						buildResult = cb.greaterThanOrEqualTo(br, paramList,
								field, value);
						break;
					case LT:
						buildResult = cb.lessThan(br, paramList, field, value);
						break;
					case LTE:
						buildResult = cb.lessThanOrEqualTo(br, paramList,
								field, value);
						break;
					case LIKE:
						buildResult = cb.like(br, paramList, field, value);
						break;
					case IN:
						buildResult = cb.in(br, paramList, field, value);
						break;
					case BETWEEN:
						buildResult = cb.between(br, paramList, field, value);
						break;

					default:
						break;
					}

					if (buildResult) {
						list.add(br);
					}
				}
			}

			for (int i = 0; i < list.size(); i++) {
				builder.append(list.get(i));
				if (i < list.size() - 1) {
					builder.append(" and ");
				}

			}
		}
		return builder.toString();
	}

	public String buildOrder() {
		if (StringUtils.isNotBlank(this.order)
				&& StringUtils.isNotBlank(this.sort)) {
			return "order by " + this.sort + " " + this.order;
		}
		return "";
	}

	public String getCountSQL(String baseSql) {
		String sqlBegin = "select count(1)from(";
		String sqlEnd = ") as total ";
		return sqlBegin + baseSql + sqlEnd;
	}

	public String getPaginationSQL(String baseSql) {
		String sqlBegin = "SELECT * FROM (SELECT ROW_.*,ROWNUM ROWNUM_ FROM (";
		String sqlEnd = ")ROW_ WHERE ROWNUM <= ?)ROW_ WHERE ROWNUM_	>?";
		return sqlBegin + baseSql + sqlEnd;
	}

	/**
	 * 返回 paramList 的值
	 * 
	 * @return paramList
	 */

	public List<Object> getParamList() {
		return paramList;
	}
}
