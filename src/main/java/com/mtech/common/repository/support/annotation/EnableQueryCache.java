package com.mtech.common.repository.support.annotation;

import java.lang.annotation.*;

/**
 * 
 * 开启查询缓存
 *
 * @author Jiarong
 * @date 2014年12月1日 下午6:29:29 
 * @version 0.0.1
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableQueryCache {
    boolean value() default true;
}