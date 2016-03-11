package com.mtech.web.json;

import org.springframework.beans.BeanUtils;

import com.mtech.common.utils.SpringUtils;
import com.mtech.scheduler.core.service.AppService;
import com.mtech.uam.permission.json.AbstractJsonAppSerializer;
import com.mtech.uam.permission.vo.App;

/** 
 *
 * @author Jiarong
 * @date 2014年12月12日 下午1:56:15 
 * @version 0.0.1
 *  
 */
public class JsonAppSerializer extends AbstractJsonAppSerializer{

	@Override
	public App getAppById(String appId) {
		AppService appService = SpringUtils.getBean(AppService.class);
		com.mtech.scheduler.core.entity.App app = appService.findOne(appId);
		App appVo= new App();
        BeanUtils.copyProperties(app, appVo);
		return appVo;
	}
	


}
