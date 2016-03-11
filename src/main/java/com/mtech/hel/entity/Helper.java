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
@Table(name = "hel_helper")
public class Helper extends BaseEntity<String> {
	
	private static final long serialVersionUID = 1L;
			@Column(name = "helperNo")		
			private String helperNo;// 帮号编号
			@Column(name = "helperName")		
			private String helperName;// 帮号名称
			@Column(name = "simpleName")		
			private String simpleName;// 帮号简称
			@Column(name = "addr")		
			private String addr;// 帮号地址
			@Column(name = "location")		
			private String location;// 帮号坐标
			@Column(name = "phone")		
			private String phone;// 联系电话
			@Column(name = "functionDesc")		
			private String functionDesc;// 功能介绍
			@Column(name = "helpedNum")		
			private Long helpedNum;// 已帮助数
			@Column(name = "allHelpNum")		
			private Long allHelpNum;// 发起的帮助数
			@Column(name = "tags")		
			private String tags;// 标签
			@Column(name = "contactName")		
			private String contactName;// 联系人姓名
			@Column(name = "idCardNo")		
			private String idCardNo;// 身份证号
			@Column(name = "categoryCode")		
			private String categoryCode;// 帮号类型
			@Column(name = "userId")		
			private String userId;// 用户ID

	

			public String getHelperNo() {
				return helperNo;
			}
		
			public void setHelperNo(String helperNo) {
				this.helperNo = helperNo;
			}
			public String getHelperName() {
				return helperName;
			}
		
			public void setHelperName(String helperName) {
				this.helperName = helperName;
			}
			public String getSimpleName() {
				return simpleName;
			}
		
			public void setSimpleName(String simpleName) {
				this.simpleName = simpleName;
			}
			public String getAddr() {
				return addr;
			}
		
			public void setAddr(String addr) {
				this.addr = addr;
			}
			public String getLocation() {
				return location;
			}
		
			public void setLocation(String location) {
				this.location = location;
			}
			public String getPhone() {
				return phone;
			}
		
			public void setPhone(String phone) {
				this.phone = phone;
			}
			public String getFunctionDesc() {
				return functionDesc;
			}
		
			public void setFunctionDesc(String functionDesc) {
				this.functionDesc = functionDesc;
			}
			public Long getHelpedNum() {
				return helpedNum;
			}
		
			public void setHelpedNum(Long helpedNum) {
				this.helpedNum = helpedNum;
			}
			public Long getAllHelpNum() {
				return allHelpNum;
			}
		
			public void setAllHelpNum(Long allHelpNum) {
				this.allHelpNum = allHelpNum;
			}
			public String getTags() {
				return tags;
			}
		
			public void setTags(String tags) {
				this.tags = tags;
			}
			public String getContactName() {
				return contactName;
			}
		
			public void setContactName(String contactName) {
				this.contactName = contactName;
			}
			public String getIdCardNo() {
				return idCardNo;
			}
		
			public void setIdCardNo(String idCardNo) {
				this.idCardNo = idCardNo;
			}
			public String getCategoryCode() {
				return categoryCode;
			}
		
			public void setCategoryCode(String categoryCode) {
				this.categoryCode = categoryCode;
			}
			public String getUserId() {
				return userId;
			}
		
			public void setUserId(String userId) {
				this.userId = userId;
			}
	
}