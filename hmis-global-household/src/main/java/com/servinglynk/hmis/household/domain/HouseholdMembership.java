package com.servinglynk.hmis.household.domain;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * A HouseholdMembership.
 */
@Entity
@Table(name = "household_membership",schema="global_household")
public class HouseholdMembership extends GlobalHouseholdBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="household_membership_id")
    private UUID householdMembershipId;

    @Column(name = "global_client_id")
    private String globalClientId;

    @Column(name = "relationship_to_head_of_household")
    private String relationshipToHeadOfHousehold;

    @ManyToOne
    @JoinColumn(name="global_household_id")
    private GlobalHousehold globalHousehold;


    public UUID getHouseholdMembershipId() {
		return householdMembershipId;
	}

	public void setHouseholdMembershipId(UUID householdMembershipId) {
		this.householdMembershipId = householdMembershipId;
	}

	public String getGlobalClientId() {
        return globalClientId;
    }

    public void setGlobalClientId(String globalClientId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HouseholdMembership householdMembership = (HouseholdMembership) o;
        if(householdMembership.householdMembershipId == null || householdMembershipId == null) {
            return false;
        }
        return Objects.equals(householdMembershipId, householdMembership.householdMembershipId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(householdMembershipId);
    }

    @Override
    public String toString() {
        return "HouseholdMembership{" +
            "householdMembershipId=" + householdMembershipId +
            ", globalClientId='" + globalClientId + "'" +
            ", relationshipToHeadOfHousehold='" + relationshipToHeadOfHousehold + "'" +
            '}';
    }
}
