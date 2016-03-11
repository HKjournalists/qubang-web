package com.mtech.usr.entity;

import org.hibernate.validator.constraints.Length;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.mtech.common.entity.BaseEntity;

/**
 * 用户管理Entity
 * @author code generator
 * @date 2016-03-01
 */
@Entity
@Table(name = "usr_user")
public class User extends BaseEntity<String> {
	
	private static final long serialVersionUID = 1L;
			@Column(name = "no")		
			private String no;// no
			@Column(name = "headerPic")		
			private String headerPic;// headerPic
			@Column(name = "nickName")		
			private String nickName;// nickName
			@Column(name = "remark")		
			private String remark;// remark
			@Column(name = "mobileNo")		
			private String mobileNo;// mobileNo
			@Column(name = "areaCode")		
			private String areaCode;// areaCode
			@Column(name = "signature")		
			private String signature;// signature
			@Column(name = "helpNum")		
			private Integer helpNum;// helpNum
			@Column(name = "beHelpedNum")		
			private Integer beHelpedNum;// beHelpedNum
			@Column(name = "availableHelpNum")		
			private Integer availableHelpNum;// availableHelpNum
			@Column(name = "favourNum")		
			private Integer favourNum;// favourNum
			@Column(name = "collegeName")		
			private String collegeName;// collegeName
			@Column(name = "eduEndDate")		
			private String eduEndDate;// 毕业时间
			@Column(name = "education")		
			private String education;// education
			@Column(name = "major")		
			private String major;// major
			@Column(name = "myCollege")		
			private String myCollege;// myCollege
			@Column(name = "eduStrartDate")		
			private String eduStrartDate;// 入学时间

	

			public String getNo() {
				return no;
			}
		
			public void setNo(String no) {
				this.no = no;
			}
			public String getHeaderPic() {
				return headerPic;
			}
		
			public void setHeaderPic(String headerPic) {
				this.headerPic = headerPic;
			}
			public String getNickName() {
				return nickName;
			}
		
			public void setNickName(String nickName) {
				this.nickName = nickName;
			}
			public String getRemark() {
				return remark;
			}
		
			public void setRemark(String remark) {
				this.remark = remark;
			}
			public String getMobileNo() {
				return mobileNo;
			}
		
			public void setMobileNo(String mobileNo) {
				this.mobileNo = mobileNo;
			}
			public String getAreaCode() {
				return areaCode;
			}
		
			public void setAreaCode(String areaCode) {
				this.areaCode = areaCode;
			}
			public String getSignature() {
				return signature;
			}
		
			public void setSignature(String signature) {
				this.signature = signature;
			}
			public Integer getHelpNum() {
				return helpNum;
			}
		
			public void setHelpNum(Integer helpNum) {
				this.helpNum = helpNum;
			}
			public Integer getBeHelpedNum() {
				return beHelpedNum;
			}
		
			public void setBeHelpedNum(Integer beHelpedNum) {
				this.beHelpedNum = beHelpedNum;
			}
			public Integer getAvailableHelpNum() {
				return availableHelpNum;
			}
		
			public void setAvailableHelpNum(Integer availableHelpNum) {
				this.availableHelpNum = availableHelpNum;
			}
			public Integer getFavourNum() {
				return favourNum;
			}
		
			public void setFavourNum(Integer favourNum) {
				this.favourNum = favourNum;
			}
			public String getCollegeName() {
				return collegeName;
			}
		
			public void setCollegeName(String collegeName) {
				this.collegeName = collegeName;
			}
			public String getEduEndDate() {
				return eduEndDate;
			}
		
			public void setEduEndDate(String eduEndDate) {
				this.eduEndDate = eduEndDate;
			}
			public String getEducation() {
				return education;
			}
		
			public void setEducation(String education) {
				this.education = education;
			}
			public String getMajor() {
				return major;
			}
		
			public void setMajor(String major) {
				this.major = major;
			}
			public String getMyCollege() {
				return myCollege;
			}
		
			public void setMyCollege(String myCollege) {
				this.myCollege = myCollege;
			}
			public String getEduStrartDate() {
				return eduStrartDate;
			}
		
			public void setEduStrartDate(String eduStrartDate) {
				this.eduStrartDate = eduStrartDate;
			}
	
}