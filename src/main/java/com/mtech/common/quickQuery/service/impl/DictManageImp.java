/**    
 * Copyright (C),Kingmed
 * @FileName: DictManageImp.java  
 * @Package: com.kingmed.platform.modules.quickQuery.service.impl  
 * @Description: //模块目的、功能描述  
 * @Author HuangSiwei  
 * @Date 2014年9月3日 下午1:25:20  
 * @History: //修改记录
 * 〈author〉      〈time〉      〈version〉       〈desc〉
 * 修改人姓名            修改时间            版本号              描述   
 */

package com.mtech.common.quickQuery.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mtech.common.quickQuery.configs.CustomDict;
import com.mtech.common.quickQuery.service.DictManage;

/**
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年9月3日 下午1:25:20
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
@Transactional(readOnly = true)
public class DictManageImp implements DictManage {

	@Autowired
	private JdbcTemplate jdbcTemplate;

//	@Autowired
//	private DataDictService dataDictService;

	/**
	 * @param customDict
	 * @return
	 * @see com.mtech.common.quickQuery.service.DictManage#findCustomDict(com.mtech.common.quickQuery.configs.CustomDict)
	 */

	@Override
	public Map<String, String> findCustomDict(CustomDict customDict) {

		String sql = customDict.getSql();
		final Map<String, String> data = new HashMap<String, String>();
		jdbcTemplate.query(sql, new RowMapper<Object>() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				data.put(rs.getString("CODE"), rs.getString("NAME"));
				return null;
			}
		});
		return data;
	}

	@Override
	public Map<String, String> findActiveDictMapByCategory(String category) {
		return null;
//		return dataDictService.findActiveDictMapByCategory(category);
	}

}
