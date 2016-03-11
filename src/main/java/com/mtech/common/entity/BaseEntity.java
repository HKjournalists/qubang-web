package com.mtech.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.mtech.common.plugin.entity.LogicDeleteable;

/**
 * 
 * 抽象实体基类，提供统一的ID，和相关的基本功能方法 
 * 提供基础的id, createBy, createDate, updateBy, updateDate, version, isDeleted等基础数据库字典的ORM
 * 提供审计字段createBy, createDate, updateBy, updateDate的自动记录功能，业务模块不需要对这些字段进行处理。
 * 提供逻辑删除的基础实现
 * @author Jiarong
 * @date 2014年11月3日 下午3:49:44 
 * @version 0.0.1
 * 
 * @param <ID>
 */

@MappedSuperclass
@EntityListeners(value ={AuditingEntityListener.class}) 
public abstract class BaseEntity<ID extends Serializable> extends AbstractEntity<ID> implements LogicDeleteable{

    /** 
	 * @Fields serialVersionUID
	 */ 
	private static final long serialVersionUID = -4827320623102036715L;

	/**
	 * UUID
	 */
	@Id
    @GenericGenerator(name="system-uuid", strategy="uuid") 
	@GeneratedValue(generator="system-uuid")
    private ID id;
    
	/**
     * 记录创建人标识，记录用户的UUID
     */
    @CreatedBy
	@Column(updatable=false, name="create_by")
	private String createBy;
    
    /**
     * 记录创建日期
     */
	@CreatedDate
	@Column(updatable=false, name="create_date")
	private Date createDate;
	
	/**
	 * 记录最后更新人标识，记录用户的UUID
	 */
	@LastModifiedBy
	@Column(name="update_by")
	private String updateBy;
	
	/**
	 * 记录最后更新日期
	 */
	@LastModifiedDate
	@Column(name="update_date")
	private Date updateDate;
	
	@Version
	@Column(name="version")
	private Long version;
	
	/** 
	 * @return createBy 
	 */
	public String getCreateBy() {
		return createBy;
	}

	/** 
	 * @param createBy 要设置的 createBy 
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/** 
	 * @return createDate 
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/** 
	 * @param createDate 要设置的 createDate 
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/** 
	 * @return updateBy 
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	/** 
	 * @param updateBy 要设置的 updateBy 
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/** 
	 * @return updateDate 
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/** 
	 * @param updateDate 要设置的 updateDate 
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/** 
	 * @return version 
	 */
	public Long getVersion() {
		return version;
	}

	/** 
	 * @param version 要设置的 version 
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/** 
	 * @return isDeleted 
	 */
	@Override
	public String getIsDeleted() {
		return isDeleted;
	}

	/** 
	 * @param isDeleted 要设置的 isDeleted 
	 */
	@Override
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**
	 * 
	 * 标记为逻辑删除  
	 * @see com.mtech.common.plugin.entity.LogicDeleteable#markDeleted()
	 */
	@Override
	public void markDeleted() {
		this.isDeleted = "1";
	}

	/**
	 * 逻辑删除标志
	 */
	@Column(name="is_deleted")
	private String isDeleted = "0";

    @Override
    public ID getId() {
        return id;
    }

    @Override
    public void setId(ID id) {
        this.id = id;
    }
    
    /**
     *  
	 * @return 
	 * @see java.lang.Object#toString() 
	 */
	@Override
	public String toString() {
		return "BaseEntity [id=" + id + ", createBy=" + createBy
				+ ", createDate=" + createDate + ", updateBy=" + updateBy
				+ ", updateDate=" + updateDate + ", version=" + version
				+ ", isDeleted=" + isDeleted + "]";
	}

	/**
	 *  
	 * @return 
	 * @see java.lang.Object#hashCode() 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 *  
	 * @param obj
	 * @return 
	 * @see java.lang.Object#equals(java.lang.Object) 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
