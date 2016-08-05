package com.servinglynk.hmis.household.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.orm.jpa.EntityScan;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.Objects;

/**
 * A GlobalHousehold.
 */
@Entity
@Table(name = "global_household",schema="global_household")
public class GlobalHousehold extends GlobalHouseholdBaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1573515448747014869L;

	@Id
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	@Column(name="global_household_id")
    private UUID globalHouseholdId;

    @Column(name = "head_of_household_id")
    private String headOfHouseholdId;

    @OneToMany(mappedBy = "globalHousehold",cascade=CascadeType.ALL)
    @JsonIgnore
    private Set<HouseholdMembership> members = new HashSet<>();


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

    public Set<HouseholdMembership> getMembers() {
        return members;
    }

    public void setMembers(Set<HouseholdMembership> householdMemberships) {
        this.members = householdMemberships;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlobalHousehold globalHousehold = (GlobalHousehold) o;
        if(globalHousehold.globalHouseholdId == null || globalHouseholdId == null) {
            return false;
        }
        return Objects.equals(globalHouseholdId, globalHousehold.globalHouseholdId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(globalHouseholdId);
    }
    
    

    @Override
    public String toString() {
        return "GlobalHousehold{" +
            "globalHouseholdId=" + globalHouseholdId +
            ", headOfHouseholdId='" + headOfHouseholdId + "'" +
            '}';
    }

	
}
