package com.mtech.usr.entity;

import org.hibernate.validator.constraints.Length;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.mtech.common.entity.BaseEntity;

/**
 * 用户意见管理Entity
 * @author code generator
 * @date 2016-03-01
 */
@Entity
@Table(name = "usr_user_suggest")
public class UserSuggest extends BaseEntity<String> {
	
	private static final long serialVersionUID = 1L;
			@Column(name = "userId")		
			private String userId;// 用户ID
			@Column(name = "suggestDesc")		
			private String suggestDesc;// 用户意见内容
			@Column(name = "status")		
			private String status;// 审核状态
			@Column(name = "auditResult")		
			private String auditResult;// 处理结果
			@Column(name = "auditId")		
			private String auditId;// 处理人id

	

			public String getUserId() {
				return userId;
			}
		
			public void setUserId(String userId) {
				this.userId = userId;
			}
			public String getSuggestDesc() {
				return suggestDesc;
			}
		
			public void setSuggestDesc(String suggestDesc) {
				this.suggestDesc = suggestDesc;
			}
			public String getStatus() {
				return status;
			}
		
			public void setStatus(String status) {
				this.status = status;
			}
			public String getAuditResult() {
				return auditResult;
			}
		
			public void setAuditResult(String auditResult) {
				this.auditResult = auditResult;
			}
			public String getAuditId() {
				return auditId;
			}
		
			public void setAuditId(String auditId) {
				this.auditId = auditId;
			}
	
}