package com.mtech.common.quickQuery.service.impl;
///**    
// * Copyright (C),Kingmed
// * @FileName: QuickGridServiceImpl.java  
// * @Package: com.kingmed.platform.modules.quickQuery.service.impl  
// * @Description: //模块目的、功能描述  
// * @Author HuangSiwei  
// * @Date 2014年8月25日 上午9:52:40  
// * @History: //修改记录
// * 〈author〉      〈time〉      〈version〉       〈desc〉
// * 修改人姓名            修改时间            版本号              描述   
// */
//
//package com.mtech.common.quickQuery.service.impl;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.mtech.common.quickQuery.configs.Column;
//import com.mtech.common.quickQuery.configs.CustomDict;
//import com.mtech.common.quickQuery.configs.Formatter;
//import com.mtech.common.quickQuery.configs.Grid;
//import com.mtech.common.quickQuery.configs.Query;
//import com.mtech.common.quickQuery.configs.Querys;
//import com.mtech.common.quickQuery.configs.QuerysContext;
//import com.mtech.common.quickQuery.configs.TableRow;
//import com.mtech.common.quickQuery.formatter.FormatterFactory;
//import com.mtech.common.quickQuery.formatter.IFormatter;
//import com.mtech.common.quickQuery.formatter.LigerGridForMatter;
//import com.mtech.common.quickQuery.service.DictManage;
//import com.mtech.common.quickQuery.service.QuickGridService;
//import com.mtech.common.quickQuery.sqlBuild.SQLBuilder;
//
///**
// * 〈一句话功能简述〉 功能详细描述
// * 
// * @author HuangSiwei
// * @create 2014年8月25日 上午9:52:40
// * @version 1.0.0
// * @see [相关类/方法]（可选）
// * @since [产品/模块版本] （可选）
// */
//@Service
////@Transactional(readOnly = true)
//public class QuickGridServiceImpl implements QuickGridService {
//
//	private final static Logger LOGGER =  LoggerFactory.getLogger(QuickGridServiceImpl.class);
//
////	@PersistenceContext
////	private EntityManager em;
//
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	@Autowired
//	private DictManage dictManage;
//
//	@Autowired
//	private FormatterFactory formatterFactory;
//
//	/**
//	 * @param queryId
//	 * @param searchParams
//	 * @param pageNumber
//	 * @param pageSize
//	 * @param direction
//	 * @param sortProperty
//	 * @return
//	 * @see com.mtech.common.quickQuery.service.QuickGridService#findPage(java.lang.String,
//	 *      java.util.Map, int, int, java.lang.String, java.lang.String)
//	 */
//
//	@Override
//	public Page<Map<String, Object>> findPage(String queryId,
//			Map<String, String[]> searchParams, int pageNumber, int pageSize,
//			String order, String sort) {
//		QuerysContext queryContext = QuerysContext.getInstance();
//		final Query query = queryContext.getQuery(queryId);
//		SQLBuilder sqlBuilder = new SQLBuilder(query, searchParams, order, sort);
//
//		String baseSql = sqlBuilder.getBoundSQL();// 获取已绑定参数的SQL
//		List<Object> paramList = sqlBuilder.getParamList();
//		String countSql = sqlBuilder.getCountSQL(baseSql);
//		String paginationSql = sqlBuilder.getPaginationSQL(baseSql);
//		LOGGER.debug(baseSql);
//
//		int count = jdbcTemplate.queryForObject(countSql, paramList.toArray(),
//				Integer.class);// 总数
//
//		int pageCount = (int) Math.ceil((double) count / pageSize);
//		if (pageCount <= 0) {
//			return new PageImpl<Map<String, Object>>(
//					new ArrayList<Map<String, Object>>());
//		}
//		if (pageNumber < 0) {
//			pageNumber = 1;
//		}
//		if (pageNumber > pageCount) {
//			pageNumber = pageCount;
//		}
//		int start = (pageNumber - 1) * pageSize;
//		int end = pageNumber * pageSize;
//
//		paramList.add(end);
//		paramList.add(start);
//
//		final Grid grid = query.getGrid();
//		List<Map<String, Object>> context = jdbcTemplate.query(paginationSql,
//				paramList.toArray(), new RowMapper<Map<String, Object>>() {
//
//					@Override
//					public Map<String, Object> mapRow(ResultSet rs, int rowNum)
//							throws SQLException {
//						List<TableRow> rows = grid.getTableRows();
//						Map<String, Object> row = new HashMap<String, Object>();
//
//						for (TableRow tr : rows) {
//							List<Column> columns = tr.getColumns();
//
//							for (Column column : columns) {
//								if (!Column.TYPE_SHOW.equalsIgnoreCase(column
//										.getType())) {
//									String field = column.getName();
//									Object value = rs.getObject(field);
//									row.put(field, value);
//								}
//							}
//						}
//						return row;
//					}
//				});
//
//		fieldFormat(context, query);
//		Pageable pageable = new PageRequest(pageNumber, pageSize);
//
//		return new PageImpl<Map<String, Object>>(context, pageable, count);
//	}
//
//	/**
//	 * 格式化查询结果
//	 * 
//	 * @param context
//	 * @param query
//	 * @see [相关类/方法]（可选）
//	 * @since [产品/模块版本] （可选）
//	 */
//	private void fieldFormat(List<Map<String, Object>> context, Query query) {
//		Querys querys = query.getQuerys();
//		List<TableRow> tableRows = query.getGrid().getTableRows();
//
//		for (int i = 0; i < tableRows.size(); i++) {// 遍历读取字典数据
//			TableRow tableRow = tableRows.get(i);
//			List<Column> columns = tableRow.getColumns();
//
//			for (int j = 0; j < columns.size(); j++) {
//				Column column = columns.get(j);
//				String customDictId = column.getCustomDict();
//				String sysDict = column.getSysDict();
//				String beanFormatter = column.getBeanFormatter();
//				String field = column.getName();
//
//				Map<String, String> cdData = null;
//				IFormatter formatter = null;
//				if (StringUtils.isNotBlank(customDictId)) {// 优先使用
//					CustomDict customDict = querys.getCustomDict(customDictId);
//					if (customDict != null) {
//						cdData = dictManage.findCustomDict(customDict);
//					}
//				} else if (StringUtils.isNotBlank(column.getSysDict())) {
//					cdData = dictManage.findActiveDictMapByCategory(sysDict);
//				} else if (StringUtils.isNotBlank(beanFormatter)) {
//					Formatter config = querys.getFormatter(beanFormatter);
//					formatter = formatterFactory.getFormatter(config);
//
//				}
//
//				if (cdData != null) {
//					fieldFormat(context, field, cdData);
//				} else if (formatter != null) {
//					fieldFormat(context, field, formatter);
//				}
//			}
//		}
//	}
//
//	/**
//	 * 格式化一列数据
//	 * 
//	 * @param context
//	 * @param field
//	 * @param cdData
//	 * @see [相关类/方法]（可选）
//	 * @since [产品/模块版本] （可选）
//	 */
//	private void fieldFormat(List<Map<String, Object>> context, String field,
//			IFormatter formatter) {
//		for (Map<String, Object> item : context) {
//			Object object = item.get(field);
//			String value = formatter.format(object);
//			item.put(field, value);
//		}
//	}
//
//	/**
//	 * 格式化一列数据
//	 * 
//	 * @param context
//	 * @param field
//	 * @param cdData
//	 * @see [相关类/方法]（可选）
//	 * @since [产品/模块版本] （可选）
//	 */
//	private void fieldFormat(List<Map<String, Object>> context, String field,
//			Map<String, String> cdData) {
//		for (Map<String, Object> item : context) {
//			Object object = item.get(field);
//			if (object != null) {
//				String key = object.toString();
//				String value = cdData.get(key);
//				item.put(field, value);
//			}
//		}
//	}
//
//	@Override
//	public LigerGridForMatter findGrid(String queryId,
//			Map<String, String[]> searchParams, int pageNumber, int pageSize,
//			String order, String sort) {
//		Page<Map<String, Object>> page =  findPage(queryId, searchParams, pageNumber, pageSize, order, sort);
//		
//		return new LigerGridForMatter(page.getContent(),page.getTotalElements());
//	}
//
//}
