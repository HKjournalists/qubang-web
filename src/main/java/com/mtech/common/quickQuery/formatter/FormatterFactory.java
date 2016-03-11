/**    
 * Copyright (C),Kingmed
 * @FileName: FormatterFactory.java  
 * @Package: com.kingmed.platform.modules.quickQuery.formatter  
 * @Description: //模块目的、功能描述  
 * @Author HuangSiwei  
 * @Date 2014年9月4日 下午4:22:54  
 * @History: //修改记录
 * 〈author〉      〈time〉      〈version〉       〈desc〉
 * 修改人姓名            修改时间            版本号              描述   
 */

package com.mtech.common.quickQuery.formatter;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

import com.mtech.common.quickQuery.configs.Formatter;

/**
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年9月4日 下午4:22:54
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component(value = "formatterFactory")
public class FormatterFactory implements BeanFactoryAware {
	private BeanFactory beanFactory;

	public IFormatter getFormatter(Formatter config) {
		if (config == null) {
			return null;
		}
		try {
			String clazz = config.getClazz();
			String ref = config.getRef();
			IFormatter fmatter = null;
			if (StringUtils.isNotBlank(clazz)) {
				Class<?> forName = Class.forName(clazz);
				fmatter = (IFormatter) forName.newInstance();
			} else if (StringUtils.isNotBlank(ref)) {
				fmatter = beanFactory.getBean(ref, IFormatter.class);
			} else {
				return null;
			}

			Map<String, String> propertyMap = config.getPropertyMap();

			BeanUtils.populate(fmatter, propertyMap);

			return fmatter;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
}
