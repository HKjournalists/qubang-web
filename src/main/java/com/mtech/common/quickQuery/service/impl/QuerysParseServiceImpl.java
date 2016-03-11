package com.mtech.common.quickQuery.service.impl;

import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.mtech.common.quickQuery.configs.QuerysContext;
import com.mtech.common.quickQuery.parser.QueryXmlReader;
import com.mtech.common.quickQuery.service.QuerysParseService;

/**
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年9月3日 上午11:16:37
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class QuerysParseServiceImpl implements QuerysParseService {

	private static final String DEFAULT_QUICK_QUERY_XML = "query/quickQuery.xml";

	private String fileName = DEFAULT_QUICK_QUERY_XML;

	@Override
	public void reloadFile() {
		QuerysContext queryContext = QuerysContext.getInstance();

		if (queryContext.isParsed() && !queryContext.isDebug()) {
			return;
		}
		
		queryContext.clear();
		InputStream resource = this.getClass().getClassLoader()
				.getResourceAsStream(fileName);

		QueryXmlReader.loadMainFile(resource);
	}

	/**
	 * 设置 fileName 的值
	 * 
	 * @param fileName
	 */

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 
	 * @Title: test abc
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param abc
	 * @throws Exception    设定文件 
	 * @return void    返回类型
	 */
	public void test(String abc) throws Exception{
		
	}

}
