
package com.mtech.common.entity.search.filter;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;


public class OrCondition implements SearchFilter,Serializable {

    private List<SearchFilter> orFilters = Lists.newArrayList();

    OrCondition() {
    }

    public OrCondition add(SearchFilter filter) {
        this.orFilters.add(filter);
        return this;
    }

    public List<SearchFilter> getOrFilters() {
        return orFilters;
    }

    @Override
    public String toString() {
        return "OrCondition{" + orFilters + '}';
    }
}
