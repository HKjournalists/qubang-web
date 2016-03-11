package com.mtech.web.json;

import com.mtech.uam.basedata.json.AbstractJsonDictSerializer;
import com.mtech.uam.basedata.vo.Dict;
import com.mtech.utils.DictUtil;

/** 
 *
 * @author caimingqin
 * @date 2014年12月12日 下午1:56:15
 * @version 0.0.1
 *  
 */
public class JsonDictSerializer extends AbstractJsonDictSerializer{

	@Override
	public Dict findDictByTypeAndCode(String dictType, String dictCode) {
		
		return DictUtil.findDictByTypeAndCode(dictType, dictCode);
	}

	
	
}
