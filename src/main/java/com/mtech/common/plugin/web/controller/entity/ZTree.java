/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.mtech.common.plugin.web.controller.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * ztree类
 *
 * @param <ID>
 */
@SuppressWarnings("rawtypes")
public class ZTree<ID extends Serializable> implements Serializable {
	private static final long serialVersionUID = 9072605094132201533L;
	private ID id;
    private ID pId;
    private String name;
    private String iconSkin;
    private boolean open;
    private boolean root;
    private boolean isParent;
    private boolean nocheck = false;
    private boolean checked;		//是否选中
	private List<ZTree> children;
	private boolean chkDisabled;	//true表示此节点的 checkbox / radio 被禁用。
	
	private Map extendFields;//扩展字段
	private String extendField;//扩展字段
	private String type;//类型
	private String typeLevel;//级别
    public ZTree() {
		super();
	}
    

	public ZTree(ID id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public ZTree(ID id, ID pId, String name) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
	}


	public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public ID getpId() {
        return pId;
    }

    public void setpId(ID pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconSkin() {
        return iconSkin;
    }

    public void setIconSkin(String iconSkin) {
        this.iconSkin = iconSkin;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }


    public boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }

    public boolean isIsParent() {
        return isParent;
    }

    public void setIsParent(boolean isParent) {
        this.isParent = isParent;
    }

    public boolean isNocheck() {
        return nocheck;
    }

    public void setNocheck(boolean nocheck) {
        this.nocheck = nocheck;
    }

	public boolean isChecked() {
		return checked;
	}


	public void setChecked(boolean checked) {
		this.checked = checked;
	}


	public List<ZTree> getChildren() {
		return children;
	}


	public void setChildren(List<ZTree> children) {
		this.children = children;
	}


	public boolean isChkDisabled() {
		return chkDisabled;
	}


	public void setChkDisabled(boolean chkDisabled) {
		this.chkDisabled = chkDisabled;
	}


	public Map getExtendFields() {
		return extendFields;
	}


	public void setExtendFields(Map extendFields) {
		this.extendFields = extendFields;
	}


	public String getExtendField() {
		return extendField;
	}

	public void setExtendField(String extendField) {
		this.extendField = extendField;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getTypeLevel() {
		return typeLevel;
	}


	public void setTypeLevel(String typeLevel) {
		this.typeLevel = typeLevel;
	}
    
    

}
