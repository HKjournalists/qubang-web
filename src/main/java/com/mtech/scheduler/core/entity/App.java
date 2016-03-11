
/**
 * @author: alvin
 * @version: 1.0
 * @since 2014-09-24
 */
package com.mtech.scheduler.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mtech.common.entity.BaseEntity;
import com.mtech.common.utils.FullDateSerializer;

@Entity
@Table(name = "SYS_APP")
public class App extends BaseEntity<String>{
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 3058941106135280610L;
	/** 应用名称 **/
	@Column(name = "app_name")
	private java.lang.String appName;
	/** 应用中文名称 **/
	@Column(name = "app_cname")
	private java.lang.String appCname;
	/** 应用KEY **/
	@Column(name = "app_key")
	private java.lang.String appKey;
	/** APP_SECRET **/
	@Column(name = "app_secret")
	private java.lang.String appSecret;
	/** HOSTNAME **/
	@Column(name = "hostname")
	private java.lang.String hostname;
	/** 应用上下文 **/
	@Column(name = "web_context")
	private java.lang.String webContext;
	/** 顺序 **/
	@Column(name = "orderby")
	private java.lang.String orderby;
	/** 是否可用 **/
	@Column(name = "available")
	private java.lang.String available;

	public java.lang.String getAppName() {
		return appName;
	}

	public java.lang.String getAppCname() {
		return appCname;
	}

	public java.lang.String getAppKey() {
		return appKey;
	}

	public java.lang.String getAppSecret() {
		return appSecret;
	}

	public java.lang.String getHostname() {
		return hostname;
	}

	public java.lang.String getWebContext() {
		return webContext;
	}

	public java.lang.String getOrderby() {
		return orderby;
	}

	public java.lang.String getAvailable() {
		return available;
	}

	public void setAppName(java.lang.String appName) {
		this.appName = appName;
	}

	public void setAppCname(java.lang.String appCname) {
		this.appCname = appCname;
	}

	public void setAppKey(java.lang.String appKey) {
		this.appKey = appKey;
	}

	public void setAppSecret(java.lang.String appSecret) {
		this.appSecret = appSecret;
	}

	public void setHostname(java.lang.String hostname) {
		this.hostname = hostname;
	}

	public void setWebContext(java.lang.String webContext) {
		this.webContext = webContext;
	}

	public void setOrderby(java.lang.String orderby) {
		this.orderby = orderby;
	}

	public void setAvailable(java.lang.String available) {
		this.available = available;
	}
	@JsonSerialize(using=FullDateSerializer.class)
	@Override
	public Date getCreateDate() {
		return super.getCreateDate();
	}
	

	

}