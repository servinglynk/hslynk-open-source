package com.servinglynk.hmis.warehouse.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Criteria extends BaseObject
{
	private static final long serialVersionUID = 7534673028743277151L;

	private List<Criterion> criteria;
	private List<OrderCriterion> orderCriteria;
	private boolean lazyIdentifiers = false;

	public Criteria() {
		criteria = new ArrayList<Criterion>();
		orderCriteria = new ArrayList<OrderCriterion>();
	}
	
	public void addCriterion(Criterion criterion) {
		criteria.add(criterion);
	}

	public void addOrderCriterion(OrderCriterion criterion) {
		orderCriteria.add(criterion);
	}
	
	public List<Criterion> getCriteria() {
		return criteria;
	}

	public void setCriteria(List<Criterion> criteria) {
		this.criteria = criteria;
	}
	
	public List<OrderCriterion> getOrderCriteria() {
		return orderCriteria;
	}
	
	public boolean isLazyIdentifiers() {
		return lazyIdentifiers;
	}

	public void setLazyIdentifiers(boolean lazyIdentifiers) {
		this.lazyIdentifiers = lazyIdentifiers;
	}
	
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Criteria))
			return false;
		Criteria castOther = (Criteria) other;
		return new EqualsBuilder().append(criteria, castOther.criteria).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(criteria).toHashCode();
	}

	@Override
	public String toString() {
		return "Criteria [criteria=" + criteria + ", orderCriteria=" + orderCriteria + "]";
	}
}
