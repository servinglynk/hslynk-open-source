package com.servinglynk.hmis.warehouse.hbase.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HmisUser extends HbaseEntity implements Serializable{
	
	private String id;
	private Personal personal;
	private Professional professional;
	
	public class Personal {
		public Personal(){}
		private String firstName;
		private String lastName;
		private String middleName;
		private String nameSuffix;
		private String ssn;
		private Date dob;
		private String gender;
		
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getMiddleName() {
			return middleName;
		}
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		public String getNameSuffix() {
			return nameSuffix;
		}
		public void setNameSuffix(String nameSuffix) {
			this.nameSuffix = nameSuffix;
		}
		public String getSsn() {
			return ssn;
		}
		public void setSsn(String ssn) {
			this.ssn = ssn;
		}
		public Date getDob() {
			return dob;
		}
		public void setDob(Date dob) {
			this.dob = dob;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
	}
		   
    public class Professional {
    	private String organization;
    	private Date dateCreated;
		private Date dateUpdated;
		
    	public String getOrganization() {
    		return organization;
    	}

    	public void setOrganization(String organization) {
    		this.organization = organization;
    	}
    	public Date getDateCreated() {
    		return dateCreated;
    	}
    	public void setDateCreated(Date dateCreated) {
    		this.dateCreated = dateCreated;
    	}
    	public Date getDateUpdated() {
    		return dateUpdated;
    	}
    	public void setDateUpdated(Date dateUpdated) {
    		this.dateUpdated = dateUpdated;
    	}

    }

    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Personal getPersonal() {
		return personal;
	}
	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	public Professional getProfessional() {
		return professional;
	}
	public void setProfessional(Professional professional) {
		this.professional = professional;
	}
	public String getTableName()
	{
		return "hmisuser";
	}
	
	public List<String> getColumnFamilies()
	{
		List<String>  families = new ArrayList<String>();
		families.add("personal");
		families.add("professional");
		return families;
	}
	
	public List<String> getColumns(String columnFamily)
	{
		//Field[] fields = this.getClass().getFields();
	    Map<String, List<String>> map = new HashMap<String, List<String>>();
	    List<String> personalColumns = new ArrayList<String>();
	    personalColumns.add("firstName");
	    personalColumns.add("lastName");
	    personalColumns.add("middleName");
	    personalColumns.add("ssn");
	    personalColumns.add("dob");
	    personalColumns.add("gender");
	    
	    map.put("personal",personalColumns);
	    //
	    List<String> professionalColumns = new ArrayList<String>();
	    professionalColumns.add("organization");
	    
	    map.put("professional",professionalColumns);
	    List<String> tableColumns = new ArrayList<String>();
	    tableColumns.add("id");
	    map.put("hmisuser", tableColumns);
	    if(columnFamily !=null)
	    {
	    	return map.get(columnFamily);
	    }

	    return null;
	}
}
