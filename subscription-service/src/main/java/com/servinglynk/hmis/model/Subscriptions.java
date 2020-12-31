package com.servinglynk.hmis.model;

import java.util.ArrayList;
import java.util.List;

public class Subscriptions extends PaginatedModel {
	
	private List<SubscriptionModel> subscriptions = new ArrayList<SubscriptionModel>();

	public List<SubscriptionModel> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<SubscriptionModel> subscriptions) {
		this.subscriptions = subscriptions;
	}
	
	public void addSubscription(SubscriptionModel subscription) {
		this.subscriptions.add(subscription);
	}

}
