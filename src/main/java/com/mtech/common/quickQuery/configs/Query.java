package com.mtech.common.quickQuery.configs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年8月26日 下午2:18:37
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Query {

	@XmlAttribute(name = "id", required = true)
	private String id;

	@XmlElement
	private SearchCondition searchCondition;

	@JsonIgnore
	@XmlElement(name = "searchSql")
	private SearchSql searchSql;

	@XmlElement(name = "grid")
	private Grid grid;
	
	@XmlElement
	private Pages pages;

	@JsonIgnore
	@XmlTransient
	private Querys querys;

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
	 * 返回 searchCondition 的值
	 * 
	 * @return searchCondition
	 */

	public SearchCondition getSearchCondition() {
		return searchCondition;
	}

	/**
	 * 设置 searchCondition 的值
	 * 
	 * @param searchCondition
	 */

	public void setSearchCondition(SearchCondition searchCondition) {
		this.searchCondition = searchCondition;
	}

	/**
	 * 返回 searchSql 的值
	 * 
	 * @return searchSql
	 */

	public SearchSql getSearchSql() {
		return searchSql;
	}

	/**
	 * 设置 searchSql 的值
	 * 
	 * @param searchSql
	 */

	public void setSearchSql(SearchSql searchSql) {
		this.searchSql = searchSql;
	}

	/**
	 * 返回 grid 的值
	 * 
	 * @return grid
	 */

	public Grid getGrid() {
		return grid;
	}

	/**
	 * 设置 grid 的值
	 * 
	 * @param grid
	 */

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	/**
	 * 返回 querys 的值
	 * 
	 * @return querys
	 */

	public Querys getQuerys() {
		return querys;
	}

	/**
	 * 设置 querys 的值
	 * 
	 * @param querys
	 */

	public void setQuerys(Querys querys) {
		this.querys = querys;
	}

	public Pages getPages() {
		return pages;
	}

	public void setPages(Pages pages) {
		this.pages = pages;
	}

}
