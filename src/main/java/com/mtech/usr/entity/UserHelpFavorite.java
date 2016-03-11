package com.mtech.usr.entity;

import org.hibernate.validator.constraints.Length;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.mtech.common.entity.BaseEntity;

/**
 * 常用帮助收藏管理Entity
 * @author code generator
 * @date 2016-03-01
 */
@Entity
@Table(name = "usr_user_help_favorite")
public class UserHelpFavorite extends BaseEntity<String> {
	
	private static final long serialVersionUID = 1L;
			@Column(name = "userId")		
			private String userId;// 用户ID
			@Column(name = "delAddr")		
			private String delAddr;// 配送地址
			@Column(name = "helpContent")		
			private String helpContent;// 帮助内容
			@Column(name = "helpNum")		
			private Long helpNum;// 帮豆
			@Column(name = "cost")		
			private String cost;// 红包金额
			@Column(name = "available")		
			private Long available;// 是否可用
			@Column(name = "usedNum")		
			private Long usedNum;// 使用次数

	

			public String getUserId() {
				return userId;
			}
		
			public void setUserId(String userId) {
				this.userId = userId;
			}
			public String getDelAddr() {
				return delAddr;
			}
		
			public void setDelAddr(String delAddr) {
				this.delAddr = delAddr;
			}
			public String getHelpContent() {
				return helpContent;
			}
		
			public void setHelpContent(String helpContent) {
				this.helpContent = helpContent;
			}
			public Long getHelpNum() {
				return helpNum;
			}
		
			public void setHelpNum(Long helpNum) {
				this.helpNum = helpNum;
			}
			public String getCost() {
				return cost;
			}
		
			public void setCost(String cost) {
				this.cost = cost;
			}
			public Long getAvailable() {
				return available;
			}
		
			public void setAvailable(Long available) {
				this.available = available;
			}
			public Long getUsedNum() {
				return usedNum;
			}
		
			public void setUsedNum(Long usedNum) {
				this.usedNum = usedNum;
			}
	
}