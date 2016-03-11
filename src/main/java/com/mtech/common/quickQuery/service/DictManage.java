/**    
 * Copyright (C),Kingmed
 * @FileName: DictManage.java  
 * @Package: com.kingmed.platform.modules.quickQuery.service.impl  
 * @Description: //模块目的、功能描述  
 * @Author HuangSiwei  
 * @Date 2014年9月3日 下午12:32:34  
 * @History: //修改记录
 * 〈author〉      〈time〉      〈version〉       〈desc〉
 * 修改人姓名            修改时间            版本号              描述   
 */

package com.mtech.common.quickQuery.service;

import java.util.Map;

import com.mtech.common.quickQuery.configs.CustomDict;

/**
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年9月3日 下午12:32:34
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public interface DictManage {
	/**
	 * 
	 * 〈一句话功能简述〉 功能详细描述
	 * 
	 * @param customDict
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	Map<String, String> findCustomDict(CustomDict customDict);

	/**
	 * 
	 * 〈一句话功能简述〉 功能详细描述
	 * 
	 * @param category
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	Map<String, String> findActiveDictMapByCategory(String category);
}
