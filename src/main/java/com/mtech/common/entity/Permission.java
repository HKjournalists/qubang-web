package com.mtech.common.entity;

public class Permission {
	public enum PERMISSION_TYPE {
		add, edit, del, view;
	};

	/**
	 * 展示名称
	 */
	private String text;
	/**
	 * 权限类型
	 */
	private PERMISSION_TYPE permissionType;
	/**
	 * 图标
	 */
	private String icon;
	
	/**
	 * 自定义图片路径
	 */
	private String img;
	
	/**
	 * 自定义js响应方法名称，如果为空，将默认使用权限类型对应的响应方法
	 */
	private String action;

	public Permission(String text, PERMISSION_TYPE permissionType,
			String iconURL, String action, String img) {
		super();
		this.text = text;
		this.permissionType = permissionType;
		this.icon = iconURL;
		this.action = action;
		this.img = img;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public PERMISSION_TYPE getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(PERMISSION_TYPE permissionType) {
		this.permissionType = permissionType;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getImg() {
		return img;
	}

	/**
	 * @param img 注意指定路径时，最前面不要加/，否则会指定到服务器根目录，而不是应用中的目录
	 */
	public void setImg(String img) {
		this.img = img;
	}

}
