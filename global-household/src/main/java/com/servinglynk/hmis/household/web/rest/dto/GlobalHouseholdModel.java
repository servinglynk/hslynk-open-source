package com.servinglynk.hmis.household.web.rest.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.servinglynk.hmis.household.anntation.ValidateDedupId;
import com.servinglynk.hmis.warehouse.core.model.JsonDateDeserializer;
import com.servinglynk.hmis.warehouse.core.model.JsonDateTimeSerializer;


/**
 * A DTO for the GlobalHousehold entity.
 */
@SuppressWarnings("serial")
@ValidateDedupId(clientIdField="headOfHouseholdId",linkField="link",dedupClientIdField="dedupClientId")
public class GlobalHouseholdModel implements Serializable {

	@JsonProperty("genericHouseholdId")
    private UUID globalHouseholdId;

    
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
	
	@NotNull(message=" Head of household is required.")
	private UUID dedupClientId;

	private String schemaYear;
   
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