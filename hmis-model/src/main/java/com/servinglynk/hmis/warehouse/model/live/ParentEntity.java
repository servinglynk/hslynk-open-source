package com.servinglynk.hmis.warehouse.model.live;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * The base model class.
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class ParentEntity implements IParentEntity{
	protected Date insertAt ;
	
	protected String insertBy;
	
	protected Date updateAt;	
	
	protected String updateBy;
//	protected abstract void setId(Long id);
//	public abstract Long getId();
		@Column(name = "INSERT_AT")	public Date getInsertAt() {		return insertAt;	}	public void setInsertAt(Date insertAt) {		this.insertAt = insertAt;	}
	@Column(name = "INSERT_BY")	public String getInsertBy() {		return insertBy;	}	public void setInsertBy(String insertBy) {		this.insertBy = insertBy;	}
	@Column(name = "UPDATE_AT")	public Date getUpdateAt() {		return updateAt;	}	public void setUpdateAt(Date updateAt) {		this.updateAt = updateAt;	}
	@Column(name = "UPDATE_BY")	public String getUpdateBy() {		return updateBy;	}	public void setUpdateBy(String updateBy) {		this.updateBy = updateBy;	}
}