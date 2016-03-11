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
@Table(name = "hel_helper_pic")
public class HelperPic extends BaseEntity<String> {
	
	private static final long serialVersionUID = 1L;
			@Column(name = "picUrl")		
			private String picUrl;// 图片地址
			@Column(name = "picSize")		
			private String picSize;// 图片大小
			@Column(name = "picName")		
			private String picName;// 图片名称
			@Column(name = "picType")		
			private String picType;// 图片类型
			@Column(name = "helperId")		
			private String helperId;// 所属帮号
			@Column(name = "usedType")		
			private String usedType;// 使用类型

	

			public String getPicUrl() {
				return picUrl;
			}
		
			public void setPicUrl(String picUrl) {
				this.picUrl = picUrl;
			}
			public String getPicSize() {
				return picSize;
			}
		
			public void setPicSize(String picSize) {
				this.picSize = picSize;
			}
			public String getPicName() {
				return picName;
			}
		
			public void setPicName(String picName) {
				this.picName = picName;
			}
			public String getPicType() {
				return picType;
			}
		
			public void setPicType(String picType) {
				this.picType = picType;
			}
			public String getHelperId() {
				return helperId;
			}
		
			public void setHelperId(String helperId) {
				this.helperId = helperId;
			}
			public String getUsedType() {
				return usedType;
			}
		
			public void setUsedType(String usedType) {
				this.usedType = usedType;
			}
	
}