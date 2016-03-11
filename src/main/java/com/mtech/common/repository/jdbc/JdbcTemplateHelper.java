package com.mtech.common.repository.jdbc;

import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * JDBCTemplateHelper
 * 实现ORACLE下的分页处理，使用spring data的Page及Pageable接口 
 *
 * @author Jiarong
 * @date 2014年11月25日 下午11:46:39 
 * @version 0.0.1
 * 
 * @param <E>
 */
public abstract class JdbcTemplateHelper<E> {
	
	public static final String COUNT_QUERY_STRING = "select count(1) from (%s) as total";
//	public static final String PAGE_QUERY_STRING = "SELECT DATA_.* FROM (SELECT ROW_.*, ROWNUM AS RN  FROM (%s) ROW_) DATA_ WHERE RN > ? AND RN <= ?";
	public static final String PAGE_QUERY_STRING = "SELECT DATA_.* FROM (SELECT ROW_.*   FROM (%s) ROW_) DATA_ LIMIT  ? , ?";
	
	private JdbcTemplate jdbcTemplate;
	
	private Class<E> mapperClass;
	
	public JdbcTemplateHelper(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.mapperClass = (Class<E>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
	}
	
	/**
	 * 
	 * 通过SQL获取分页数据
	 * @param pageable 分页信息
	 * @param sql 查询SQL，以?表示传入参数
	 * @param args 查询SQL参数
	 * @param rowMapper 自定义RowMapper
	 * @return 
	 * @return Page<E>    返回类型
	 */
	public Page<E> fetchPage(
            final Pageable pageable,
            final String sql,
            final Object[] args,
            RowMapper<E> rowMapper) {

		final String countSql = String.format(COUNT_QUERY_STRING, sql);
        // determine how many rows are available
        final int rowCount = jdbcTemplate.queryForInt(countSql, args);
        
        Object[] pageArgs = new Object[args.length+2];
        System.arraycopy(args, 0, pageArgs, 0, args.length);
        pageArgs[args.length] = pageable.getOffset();
       // pageArgs[args.length+1] = pageable.getOffset()+pageable.getPageSize();
        pageArgs[args.length+1] = pageable.getPageSize();
        final String pageSql = String.format(PAGE_QUERY_STRING,sql);
        
        if(rowMapper == null){
        	rowMapper = new BeanPropertyRowMapper<>(this.mapperClass);
        }

        final RowMapper<E> finalRowMapper = rowMapper; 
        
        final List<E> pageItems = new ArrayList<E>();
        jdbcTemplate.query(
        		pageSql,
                pageArgs,
                new ResultSetExtractor<E>() {
                    public E extractData(ResultSet rs) throws SQLException, DataAccessException {
                        int currentRow = pageable.getOffset();
                        while (rs.next()) {
                            pageItems.add(finalRowMapper.mapRow(rs, currentRow));
                            currentRow++;
                        }
                        return null;
                    }
                });
        // create the page object
        final Page<E> page = new PageImpl<E>(pageItems,pageable,rowCount);
        
        return page;
    }
	
	/**
	 * 
	 * 通过SQL获取分页数据
	 * @param pageable 分页信息
	 * @param sql 查询SQL，以?表示传入参数
	 * @param args 查询SQL参数
	 * @return 
	 * @return Page<E>    返回类型
	 */
	public Page<E> fetchPage(
            final Pageable pageable,
            final String sql,
            final Object... args){
		
		return fetchPage(pageable, sql, args, null);
	}
	
	/**
	 * 
	 * 获取所有SQL中的所有查询结果
	 * @param sql
	 * @param args
	 * @param rowMapper
	 * @return List<E>    返回类型
	 */
	public List<E> fetchAll(final String sql, final Object[] args, RowMapper<E> rowMapper){
		
		if(rowMapper==null){
			rowMapper = new BeanPropertyRowMapper<>(this.mapperClass);
		}
		final RowMapper<E> finalRowMapper = rowMapper;
		
		final List<E> resultList = new ArrayList<E>();
        jdbcTemplate.query(
    		sql,
            args,
            new ResultSetExtractor<E>() {
                public E extractData(ResultSet rs) throws SQLException, DataAccessException {
                    int currentRow = 0;
                    while (rs.next()) {
                        resultList.add(finalRowMapper.mapRow(rs, currentRow));
                        currentRow++;
                    }
                    return null;
                }
        });
        return resultList;
	}
	
	/**
	 * 
	 * 获取所有SQL中的所有查询结果
	 * @param sql
	 * @param args
	 * @return List<E>    返回类型
	 */
	public List<E> fetchAll(final String sql, final Object... args){
		return fetchAll(sql, args, null);
	}

	public E fetchOne(final String sql, final Object... args){
		List<E> fetchAll = fetchAll(sql, args, null);
		if(fetchAll!=null ){
			if(fetchAll.size()!=1){
				throw new IllegalArgumentException("查询结果有多条记录");
			}
		}else{
			return null;
		}
		return  fetchAll.get(0);
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
