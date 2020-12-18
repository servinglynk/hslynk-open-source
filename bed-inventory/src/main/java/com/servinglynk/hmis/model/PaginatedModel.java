package com.servinglynk.hmis.model;



public abstract class PaginatedModel extends ClientModel{
	
	
	private SortedPagination pagination;

	public SortedPagination getPagination() {
		if(pagination==null) pagination = new SortedPagination();
		return pagination;
	}

	public void setPagination(SortedPagination pagination) {
		this.pagination = pagination;
	}
	
	private InventorySummary summary;

	public InventorySummary getSummary() {
		return summary;
	}

	public void setSummary(InventorySummary summary) {
		this.summary = summary;
	}
	
	
}
