package com.servinglynk.hmis.household.domain;
import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.servinglynk.hmis.household.enums.RelationshipToHOfHEnum;

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
    
    @Type(type="com.servinglynk.hmis.household.enums.RelationshipToHOfHEnumType")
    @Column(name = "relationship_to_head_of_household")
    private RelationshipToHOfHEnum relationshipToHeadOfHousehold;

    @ManyToOne
    @JoinColumn(name="global_household_id")
    private GlobalHousehold globalHousehold;
    
    @Column(name="client_link")
    private String clientLink;
    
	@Column( name = "dedup_client_id"  ) 
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID dedupClientId;
	
	@Column(name="schema_year")
	private String schemaYear;


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

    public RelationshipToHOfHEnum getRelationshipToHeadOfHousehold() {
        return relationshipToHeadOfHousehold;
    }

    public void setRelationshipToHeadOfHousehold(RelationshipToHOfHEnum relationshipToHeadOfHousehold) {
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
	
	public UUID getDedupClientId() {
		return dedupClientId;
	}

	public void setDedupClientId(UUID dedupClientId) {
		this.dedupClientId = dedupClientId;
	}

	public String getSchemaYear() {
		return schemaYear;
	}

	public void setSchemaYear(String schemaYear) {
		this.schemaYear = schemaYear;
	}
}