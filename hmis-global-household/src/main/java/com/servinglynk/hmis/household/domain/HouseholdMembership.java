package com.servinglynk.hmis.household.domain;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * A HouseholdMembership.
 */
@Entity
@Table(name = "household_membership",schema="housing_inventory")
public class HouseholdMembership extends GlobalHouseholdBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="household_membership_id")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    private UUID householdMembershipId;

    @Column(name = "global_client_id")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID globalClientId;

    @Column(name = "relationship_to_head_of_household")
    private String relationshipToHeadOfHousehold;

    @ManyToOne
    @JoinColumn(name="global_household_id")
    private GlobalHousehold globalHousehold;
    
    @Column(name="client_link")
    private String clientLink;


    public UUID getHouseholdMembershipId() {
		return householdMembershipId;
	}

	public void setHouseholdMembershipId(UUID householdMembershipId) {
		this.householdMembershipId = householdMembershipId;
	}

	public UUID getGlobalClientId() {
        return globalClientId;
    }

    public void setGlobalClientId(UUID globalClientId) {
        this.globalClientId = globalClientId;
    }

    public String getRelationshipToHeadOfHousehold() {
        return relationshipToHeadOfHousehold;
    }

    public void setRelationshipToHeadOfHousehold(String relationshipToHeadOfHousehold) {
        this.relationshipToHeadOfHousehold = relationshipToHeadOfHousehold;
    }

    public GlobalHousehold getGlobalHousehold() {
        return globalHousehold;
    }

    public void setGlobalHousehold(GlobalHousehold globalHousehold) {
        this.globalHousehold = globalHousehold;
    }
    
    public String getClientLink() {
		return clientLink;
	}

	public void setClientLink(String clientLink) {
		this.clientLink = clientLink;
	}
}