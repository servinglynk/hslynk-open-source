package com.servinglynk.hmis.household.web.rest.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


/**
 * A DTO for the HouseholdMembership entity.
 */
public class HouseholdMembershipDTO implements Serializable {

    private UUID householdMembershipId;

    private UUID globalClientId;
    
    private LocalDateTime dateCreated;
	
	private LocalDateTime dateUpdated;
	
	private String userCreate;
	
	private String userUpdate;
	
	private Boolean inactive;

    private String relationshipToHeadOfHousehold;

    private UUID globalHouseholdId;
    
    
    
    
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

    

	public UUID getGlobalHouseholdId() {
		return globalHouseholdId;
	}

	public void setGlobalHouseholdId(UUID globalHouseholdId) {
		this.globalHouseholdId = globalHouseholdId;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDateTime getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getUserCreate() {
		return userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}


	public String getUserUpdate() {
		return userUpdate;
	}

	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}

	public Boolean getInactive() {
		return inactive;
	}

	public void setInactive(Boolean inactive) {
		this.inactive = inactive;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HouseholdMembershipDTO householdMembershipDTO = (HouseholdMembershipDTO) o;

        if ( ! Objects.equals(householdMembershipId, householdMembershipDTO.householdMembershipId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(householdMembershipId);
    }

    @Override
    public String toString() {
        return "HouseholdMembershipDTO{" +
            "householdMembershipId=" + householdMembershipId +
            ", globalClientId='" + globalClientId + "'" +
            ", relationshipToHeadOfHousehold='" + relationshipToHeadOfHousehold + "'" +
            '}';
    }
}
