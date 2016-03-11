package com.mtech.hel.entity;

import org.hibernate.validator.constraints.Length;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.mtech.common.entity.BaseEntity;

/**
 * 功能名-待添加Entity
 * @author coder generator
 * @date 2016-03-11
 */
@Entity
@Table(name = "hel_helper_category")
public class HelperCategory extends BaseEntity<String> {
	
	private static final long serialVersionUID = 1L;
			@Column(name = "categoryCode")		
			private String categoryCode;// 编号
			@Column(name = "categoryName")		
			private String categoryName;// 名称
			@Column(name = "parentCode")		
			private String parentCode;// 父级编号

	

			public String getCategoryCode() {
				return categoryCode;
			}
		
			public void setCategoryCode(String categoryCode) {
				this.categoryCode = categoryCode;
			}
			public String getCategoryName() {
				return categoryName;
			}
		
			public void setCategoryName(String categoryName) {
				this.categoryName = categoryName;
			}
			public String getParentCode() {
				return parentCode;
			}
		
			public void setParentCode(String parentCode) {
				this.parentCode = parentCode;
			}
	
}