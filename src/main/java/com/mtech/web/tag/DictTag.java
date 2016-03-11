package com.mtech.web.tag;

import com.mtech.uam.basedata.vo.Dict;
import com.mtech.uam.basedata.web.tag.AbstractDictTag;
import com.mtech.utils.DictUtil;

public class DictTag extends AbstractDictTag{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Dict findDictByType(String dictType) {
		return DictUtil.findDictByType(dictType);
	}

	@Override
	public Dict findDityByTypeAndTag(String dictType, String tag) {
		return DictUtil.findDictByType(dictType);
	}

	@Override
	public Dict findDictByTypeAndCode(String dictType, String dictCode) {
		return DictUtil.findDictByTypeAndCode(dictType,dictCode);
	}

}
