package com.mtech.common.quickQuery.configs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年9月3日 下午2:54:02
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class QuerysContext {
	private boolean debug = true;
	private List<String> configFileList = new ArrayList<String>();
	private final List<Querys> querysList = new ArrayList<Querys>();

	/**
	 * 
	 * 构造函数
	 */
	private QuerysContext() {
	}

	/**
	 * 
	 * 单例
	 * 
	 * @author HuangSiwei
	 * @create 2014年9月3日 下午2:53:59
	 * @version 1.0.0
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	private static class SingletonHolder {
		public final static QuerysContext instance = new QuerysContext();
	}

	/**
	 * 
	 * 获取实例
	 * 
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public static QuerysContext getInstance() {
		return SingletonHolder.instance;
	}

	/**
	 * 
	 * 〈一句话功能简述〉 功能详细描述
	 * 
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public boolean isParsed() {
		return querysList != null && !querysList.isEmpty();
	}

	/**
	 * 
	 * 〈一句话功能简述〉 功能详细描述
	 * 
	 * @param querys
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public boolean add(Querys querys) {
		return querysList.add(querys);
	}

	/**
	 * 
	 * 〈一句话功能简述〉 功能详细描述
	 * 
	 * @param querysList
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public boolean addAll(Collection<Querys> querysList) {
		return querysList.addAll(querysList);
	}

	/**
	 * 
	 * 〈一句话功能简述〉 功能详细描述
	 * 
	 * @param id
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public Querys getQuerys(String id) {
		for (int i = 0; i < querysList.size(); i++) {
			Querys querys = querysList.get(i);
			if (StringUtils.equals(id, querys.getId())) {
				return querys;
			}
		}
		return null;
	}

	/**
	 * 
	 * 〈一句话功能简述〉 功能详细描述
	 * 
	 * @param id
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public Query getQuery(String id) {
		for (int i = 0; i < querysList.size(); i++) {
			Querys querys = querysList.get(i);
			List<Query> queryList = querys.getQuerys();
			for (Query query : queryList) {
				if (StringUtils.equals(id, query.getId())) {
					query.setQuerys(querys);// 将querys放入query中，便于使用
					return query;
				}
			}
		}
		return null;
	}

	/**
	 * 返回 configFileList 的值
	 * 
	 * @return configFileList
	 */

	public List<String> getConfigFileList() {
		return configFileList;
	}

	/**
	 * 设置 configFileList 的值
	 * 
	 * @param configFileList
	 */

	public void addConfigFile(String configFile) {
		this.configFileList.add(configFile);
	}

	public void clear() {
		configFileList.clear();
		querysList.clear();
	}

	/**
	 * 返回 debug 的值
	 * 
	 * @return debug
	 */

	public boolean isDebug() {
		return debug;
	}

	/**
	 * 设置 debug 的值
	 * 
	 * @param debug
	 */

	public void setDebug(boolean debug) {
		this.debug = debug;
	}
}
