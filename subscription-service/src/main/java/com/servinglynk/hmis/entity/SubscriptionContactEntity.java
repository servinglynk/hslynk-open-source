package com.servinglynk.hmis.entity;

import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "subscription_contact", schema = "base")
public class SubscriptionContactEntity extends BaseEntity {

	@Id
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	  @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private UUID id;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "subscription_id", nullable = true )
	private SubscriptionEntity subscription;
	
	@Column(name = "system")
	private String system;
	
	@Column(name = "value")
	private String value;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public SubscriptionEntity getSubscription() {
		return subscription;
	}

	public void setSubscription(SubscriptionEntity subscription) {
		this.subscription = subscription;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}