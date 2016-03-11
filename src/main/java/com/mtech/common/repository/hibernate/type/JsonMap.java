package com.mtech.common.repository.hibernate.type;

import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * TODO(这里用一句话描述作用) 
 *
 * @author Jiarong
 * @date 2014年12月18日 上午9:50:52 
 * @version 0.0.1
 *
 */
public class JsonMap implements Serializable {

    private Map<Object, Object> map;

    public JsonMap() {
    }

    public JsonMap(Map<Object, Object> map) {
        this.map = map;
    }

    public Map<Object, Object> getMap() {
        if (map == null) {
            map = Maps.newHashMap();
        }
        return map;
    }

    public void setMap(Map<Object, Object> map) {
        this.map = map;
    }
}
