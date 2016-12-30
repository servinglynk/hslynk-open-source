package com.servinglynk.hmis.household.web.rest.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.servinglynk.hmis.household.anntation.ValidateClient;
import com.servinglynk.hmis.warehouse.core.model.JsonDateDeserializer;
import com.servinglynk.hmis.warehouse.core.model.JsonDateTimeSerializer;


/**
 * A DTO for the GlobalHousehold entity.
 */
@SuppressWarnings("serial")
@ValidateClient(clientIdField="headOfHouseholdId",linkField="link")
public class GlobalHouseholdDTO implements Serializable {

    private UUID globalHouseholdId;

    
    @NotNull(message=" Head of household is required.")
    private UUID headOfHouseholdId;
    
	@JsonDeserialize(using=JsonDateDeserializer.class)
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	private LocalDateTime dateCreated;
	
	@JsonDeserialize(using=JsonDateDeserializer.class)
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	private LocalDateTime dateUpdated;
	
	private UUID userId;
	
	@JsonProperty(access=Access.WRITE_ONLY)
	private String link;

   
    public UUID getGlobalHouseholdId() {
		return globalHouseholdId;
	}

	public void setGlobalHouseholdId(UUID globalHouseholdId) {
		this.globalHouseholdId = globalHouseholdId;
	}

	public UUID getHeadOfHouseholdId() {
        return headOfHouseholdId;
    }

    public void setHeadOfHouseholdId(UUID headOfHouseholdId) {
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


	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
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
