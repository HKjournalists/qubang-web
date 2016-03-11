/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.mtech.common.web.controller;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.mtech.common.entity.AbstractEntity;

@SuppressWarnings("rawtypes")
public abstract class BaseController<M extends AbstractEntity, ID extends Serializable> {
    
	public Map<String,Object> getAllParams(HttpServletRequest request) {  
        Map<String,Object> map = new HashMap<String,Object>();  
        Enumeration<String> paramNames = request.getParameterNames();  
        while (paramNames.hasMoreElements()) {  
            String paramName = paramNames.nextElement();  
            String[] paramValues = request.getParameterValues(paramName);  
            if (paramValues.length == 1) {  
                String paramValue = paramValues[0];  
                if (paramValue.length() != 0) {  
                    map.put(paramName, paramValue);  
                }  
            }  
        }  
      return map;
    }  
}
