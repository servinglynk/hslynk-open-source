package com.servinglynk.hmis.warehouse.model;



public class SortedPagination {

	private Integer from=0;
	private Integer returned;
	private Integer total;
	private Integer maximum=30;
	private Sort sort;
	


	public Integer getMaximum() {
		return maximum;
	}


	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}


	public Integer getFrom() {
		return from;
	}


	public void setFrom(Integer from) {
		this.from = from;
	}


	public Integer getReturned() {
		return returned;
	}


	public void setReturned(Integer returned) {
		this.returned = returned;
	}


	public Integer getTotal() {
		return total;
	}


	public void setTotal(Integer total) {
		this.total = total;
	}


	public Sort getSort() {
		if(sort==null) return new Sort();
		return sort;
	}


	public void setSort(Sort sort) {
		this.sort = sort;
	}


}
