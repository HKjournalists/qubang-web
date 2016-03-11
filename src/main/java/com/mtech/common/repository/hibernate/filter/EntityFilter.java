package com.mtech.common.repository.hibernate.filter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * TODO(这里用一句话描述作用) 
 *
 * @author Jiarong
 * @date 2014年12月18日 上午9:53:57 
 * @version 0.0.1
 *  
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityFilter {
	FilterQuery[] filterQueries() default  {};
}
