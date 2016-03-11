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
@Table(name = "hel_help_zan")
public class HelpZan extends BaseEntity<String> {
	
	private static final long serialVersionUID = 1L;
			@Column(name = "zanUserId")		
			private String zanUserId;// 用户ID
			@Column(name = "helpId")		
			private String helpId;// 帮助ID

	

			public String getZanUserId() {
				return zanUserId;
			}
		
			public void setZanUserId(String zanUserId) {
				this.zanUserId = zanUserId;
			}
			public String getHelpId() {
				return helpId;
			}
		
			public void setHelpId(String helpId) {
				this.helpId = helpId;
			}
	
}