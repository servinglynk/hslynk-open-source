package com.servinglynk.hmis.warehouse.model.base;
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
	
	@Column(name = "INSERT_BY")
	@Column(name = "UPDATE_AT")
	@Column(name = "UPDATE_BY")
}