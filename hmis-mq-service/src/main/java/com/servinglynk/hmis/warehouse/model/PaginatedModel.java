package com.servinglynk.hmis.warehouse.model;



public abstract class PaginatedModel {
	
	
	private SortedPagination pagination;

	public SortedPagination getPagination() {
		if(pagination==null) pagination = new SortedPagination();
		return pagination;
	}

	public void setPagination(SortedPagination pagination) {
		this.pagination = pagination;
	}
	
}
