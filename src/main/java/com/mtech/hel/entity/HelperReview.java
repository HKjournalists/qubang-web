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
@Table(name = "hel_helper_review")
public class HelperReview extends BaseEntity<String> {
	
	private static final long serialVersionUID = 1L;
			@Column(name = "score")		
			private String score;// 得分
			@Column(name = "content")		
			private String content;// 内容
			@Column(name = "helperId")		
			private String helperId;// 帮号ID
			@Column(name = "userId")		
			private String userId;// 点评人ID

	

			public String getScore() {
				return score;
			}
		
			public void setScore(String score) {
				this.score = score;
			}
			public String getContent() {
				return content;
			}
		
			public void setContent(String content) {
				this.content = content;
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
	
}