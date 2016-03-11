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
@Table(name = "hel_help_reply")
public class HelpReply extends BaseEntity<String> {
	
	private static final long serialVersionUID = 1L;
			@Column(name = "replyContent")		
			private String replyContent;// 回复内容
			@Column(name = "helpId")		
			private String helpId;// 帮助id
			@Column(name = "replyUserId")		
			private String replyUserId;// 回复人id

	

			public String getReplyContent() {
				return replyContent;
			}
		
			public void setReplyContent(String replyContent) {
				this.replyContent = replyContent;
			}
			public String getHelpId() {
				return helpId;
			}
		
			public void setHelpId(String helpId) {
				this.helpId = helpId;
			}
			public String getReplyUserId() {
				return replyUserId;
			}
		
			public void setReplyUserId(String replyUserId) {
				this.replyUserId = replyUserId;
			}
	
}