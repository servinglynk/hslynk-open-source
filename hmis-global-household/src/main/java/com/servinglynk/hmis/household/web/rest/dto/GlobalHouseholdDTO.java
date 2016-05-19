package com.servinglynk.hmis.household.web.rest.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;

import org.springframework.context.annotation.ComponentScan;

import java.util.Objects;


/**
 * A DTO for the GlobalHousehold entity.
 */
public class GlobalHouseholdDTO implements Serializable {

    private UUID globalHouseholdId;

    private String headOfHouseholdId;
    
	private LocalDateTime dateCreated;
	
	private LocalDateTime dateUpdated;
	
	private String userCreate;
	
	private String userUpdate;
	
	private Boolean inactive;


   
    public UUID getGlobalHouseholdId() {
		return globalHouseholdId;
	}

	public void setGlobalHouseholdId(UUID globalHouseholdId) {
		this.globalHouseholdId = globalHouseholdId;
	}

	public String getHeadOfHouseholdId() {
        return headOfHouseholdId;
    }

    public void setHeadOfHouseholdId(String headOfHouseholdId) {
        this.headOfHouseholdId = headOfHouseholdId;
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

        GlobalHouseholdDTO globalHouseholdDTO = (GlobalHouseholdDTO) o;

        if ( ! Objects.equals(globalHouseholdId, globalHouseholdDTO.globalHouseholdId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(globalHouseholdId);
    }

    @Override
    public String toString() {
        return "GlobalHouseholdDTO{" +
            "globalHouseholdId=" + globalHouseholdId +
            ", headOfHouseholdId='" + headOfHouseholdId + "'" +
            '}';
    }
}
