package com.mtech.common.entity;
import java.io.Serializable;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 
 * 抽象实体基类，提供统一的ID，和相关的基本功能方法 
 * 提供基础的id, createBy, createDate, updateBy, updateDate, version, isDeleted等基础数据库字典的ORM
 * 提供审计字段createBy, createDate, updateBy, updateDate的自动记录功能，业务模块不需要对这些字段进行处理。
 * 提供逻辑删除的基础实现
 * @date 2014年11月3日 下午3:49:44 
 * @version 0.0.1
 * 
 * @param <ID>
 */
@MappedSuperclass
@EntityListeners(value ={AuditingEntityListener.class}) 
public class PoJoEntity <ID extends Serializable> extends AbstractEntity<ID>{

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
			return "BaseEntity [id=" + id + "]";
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
			PoJoEntity other = (PoJoEntity) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
	}
