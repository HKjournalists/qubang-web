/**    
 * Copyright (C),Kingmed
 * @FileName: DomReader.java  
 * @Package: com.kingmed.platform.modules.quickQuery.util.xml  
 * @Description: //模块目的、功能描述  
 * @Author HuangSiwei  
 * @Date 2014年8月25日 下午1:01:20  
 * @History: //修改记录
 * 〈author〉      〈time〉      〈version〉       〈desc〉
 * 修改人姓名            修改时间            版本号              描述   
 */

package com.mtech.common.quickQuery.parser;

import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.ElementHandler;
import org.dom4j.ElementPath;
import org.dom4j.io.SAXReader;

import com.mtech.common.quickQuery.configs.Querys;
import com.mtech.common.quickQuery.configs.QuerysContext;

/**
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年8月25日 下午1:01:20
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class QueryXmlReader {
	private static final String ROOT_PATH = "/queryConfig";
	private static final String IMPORT_PATH = "/queryConfig/import";
	private static final String DEBUG = "debug";
	private static final String RESOURCE = "resource";

	/**
	 * 
	 * 〈一句话功能简述〉 功能详细描述
	 * 
	 * @param is
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public static void loadMainFile(InputStream is) {
		try {
			SAXReader saxReader = new SAXReader();
			final QuerysContext instance = QuerysContext.getInstance();

			saxReader.addHandler(ROOT_PATH, new ElementHandler() {

				@Override
				public void onStart(ElementPath ep) {
				}

				@Override
				public void onEnd(ElementPath ep) {
					Attribute attribute = ep.getCurrent().attribute(DEBUG);
					if (attribute != null) {
						instance.setDebug(Boolean.valueOf(attribute.getValue()));
					}
				}
			});
			
			saxReader.addHandler(IMPORT_PATH, new ElementHandler() {

				@Override
				public void onStart(ElementPath ep) {
				}

				@Override
				public void onEnd(ElementPath ep) {
					Attribute attribute = ep.getCurrent().attribute(RESOURCE);
					if (attribute != null) {
						instance.addConfigFile(attribute.getValue());
					}
				}
			});
			saxReader.read(is);

			loadSubFile();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * 〈一句话功能简述〉 功能详细描述
	 * 
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public static void loadSubFile() {
		QuerysContext instance = QuerysContext.getInstance();
		List<String> configFileList = instance.getConfigFileList();
		ClassLoader classLoader = QueryXmlReader.class.getClassLoader();
		for (int i = 0; i < configFileList.size(); i++) {
			String cf = configFileList.get(i);
			InputStream is = classLoader.getResourceAsStream(cf);
			parserSubXml(is);
		}
	}

	/**
	 * 
	 * 〈一句话功能简述〉 功能详细描述
	 * 
	 * @param resource
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public static void parserSubXml(InputStream resource) {
		try {
			SAXReader saxReader = new SAXReader();
			Document doc = saxReader.read(resource);
			String xml = doc.asXML();

			Class<?> c = Querys.class;
			JAXBContext context = JAXBContext.newInstance(c);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			StringReader reader = new StringReader(xml);
			Querys querys = (Querys) unmarshaller.unmarshal(reader);

			QuerysContext instance = QuerysContext.getInstance();
			instance.add(querys);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
