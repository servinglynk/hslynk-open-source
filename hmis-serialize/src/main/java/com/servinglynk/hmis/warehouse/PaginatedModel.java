package com.servinglynk.hmis.warehouse;



public abstract class PaginatedModel extends ClientModel{
	
	
	private SortedPagination pagination;

	public SortedPagination getPagination() {
		if(pagination==null) pagination = new SortedPagination();
		return pagination;
	}

	public void setPagination(SortedPagination pagination) {
		this.pagination = pagination;
	}
	
}
