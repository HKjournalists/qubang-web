/**    
 * Copyright (C),Kingmed
 * @FileName: Dictionary.java  
 * @Package: com.kingmed.platform.modules.quickQuery.configs  
 * @Description: //模块目的、功能描述  
 * @Author HuangSiwei  
 * @Date 2014年9月3日 上午9:01:07  
 * @History: //修改记录
 * 〈author〉      〈time〉      〈version〉       〈desc〉
 * 修改人姓名            修改时间            版本号              描述   
 */

package com.mtech.common.quickQuery.configs;

import java.util.Hashtable;
import java.util.Map;

/**
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年9月3日 上午9:01:07
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class SysDictContext {

	private static final Map<String, Map<String, String>> CONTEXT = new Hashtable<String, Map<String, String>>();;

	public static void put(String dictKey, Map<String, String> dict) {
		CONTEXT.put(dictKey, dict);
	}

	public static Map<String, String> getMap(String dictKey) {
		return CONTEXT.get(dictKey);
	}

	public static boolean isEmpty() {
		return CONTEXT.isEmpty();
	}

	public static Map<String, String> remove(String key) {
		return CONTEXT.remove(key);
	}

	public static void putAll(Map<String, Map<String, String>> m) {
		CONTEXT.putAll(m);
	}

	public static void clear() {
		CONTEXT.clear();
	}

}
