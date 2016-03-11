package com.mtech.hel.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


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
@Table(name = "hel_help")
public class Help extends BaseEntity<String> {
	
	private static final long serialVersionUID = 1L;
			@Column(name = "helpNo")		
			private String helpNo;// 帮助编号
			@Column(name = "helpContent")		
			private String helpContent;// 帮助内容
			@Column(name = "helpCost")		
			private String helpCost;// 帮助费用
			@Column(name = "helperId")		
			private String helperId;// 帮号ID
			@Column(name = "userId")		
			private String userId;// 发起帮助人ID
			@Column(name = "acceptUserId")		
			private String acceptUserId;// 接收帮助人ID
			@Column(name = "usedHelpNum")		
			private Long usedHelpNum;// 使用的帮豆数
			@Column(name = "delAddr")		
			private String delAddr;// 配送地址
			@Column(name = "helpStatus")		
			private String helpStatus;// 帮助状态
			@Column(name = "helpStartDate")		
			private Date helpStartDate;// 帮助开始时间
			@Column(name = "helpEndDate")		
			private Date helpEndDate;// 帮助结束时间
			@Column(name = "zan")		
			private Long zan;// 赞数
			@Column(name = "reviewNum")		
			private Long reviewNum;// 点评数

	

			public String getHelpNo() {
				return helpNo;
			}
		
			public void setHelpNo(String helpNo) {
				this.helpNo = helpNo;
			}
			public String getHelpContent() {
				return helpContent;
			}
		
			public void setHelpContent(String helpContent) {
				this.helpContent = helpContent;
			}
			public String getHelpCost() {
				return helpCost;
			}
		
			public void setHelpCost(String helpCost) {
				this.helpCost = helpCost;
			}
			public String getHelperId() {
				return helperId;
			}
		
			public void setHelperId(String helperId) {
				this.helperId = helperId;
			}
			public String getUserId() {
				return userId;
			}
		
			public void setUserId(String userId) {
				this.userId = userId;
			}
			public String getAcceptUserId() {
				return acceptUserId;
			}
		
			public void setAcceptUserId(String acceptUserId) {
				this.acceptUserId = acceptUserId;
			}
			public Long getUsedHelpNum() {
				return usedHelpNum;
			}
		
			public void setUsedHelpNum(Long usedHelpNum) {
				this.usedHelpNum = usedHelpNum;
			}
			public String getDelAddr() {
				return delAddr;
			}
		
			public void setDelAddr(String delAddr) {
				this.delAddr = delAddr;
			}
			public String getHelpStatus() {
				return helpStatus;
			}
		
			public void setHelpStatus(String helpStatus) {
				this.helpStatus = helpStatus;
			}
			public Date getHelpStartDate() {
				return helpStartDate;
			}
		
			public void setHelpStartDate(Date helpStartDate) {
				this.helpStartDate = helpStartDate;
			}
			public Date getHelpEndDate() {
				return helpEndDate;
			}
		
			public void setHelpEndDate(Date helpEndDate) {
				this.helpEndDate = helpEndDate;
			}
			public Long getZan() {
				return zan;
			}
		
			public void setZan(Long zan) {
				this.zan = zan;
			}
			public Long getReviewNum() {
				return reviewNum;
			}
		
			public void setReviewNum(Long reviewNum) {
				this.reviewNum = reviewNum;
			}
	
}