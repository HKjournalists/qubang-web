/**   
 * TODO(用一句话描述该文件做什么) 
 * @author Jiarong 
 * @date 2014年12月18日 上午9:55:46 
 * @version 0.0.1
 */
package com.mtech.common.repository.hibernate.filter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/** 
 * TODO(这里用一句话描述作用) 
 *
 * @author Jiarong
 * @date 2014年12月18日 上午9:55:46 
 * @version 0.0.1
 *  
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface FilterQuery {
	String name()  default "";
	String jpql()  default "";
}
