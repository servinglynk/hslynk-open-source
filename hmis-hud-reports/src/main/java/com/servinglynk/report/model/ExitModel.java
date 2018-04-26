package com.servinglynk.report.model;

import java.util.Date;

public class ExitModel extends BaseModel {
		private String exitid;
		private String destination;
		private String destination_desc;
		private Date exitdate;
		private Date dateCreatedFromSource;
		private String otherdestination;
		private String projectEntryID;
		private String exit_source_system_id;
		
		public ExitModel() {}
		public ExitModel(String exitid, String destination,
				String destination_desc, Date exitdate,
				String otherdestination, String projectEntryID,
				String exit_source_system_id,Date dateCreatedFromSource) {
			super();
			this.exitid = exitid;
			this.destination = destination;
			this.destination_desc = destination_desc;
			this.exitdate = exitdate;
			this.otherdestination = otherdestination;
			this.projectEntryID = projectEntryID;
			this.exit_source_system_id = exit_source_system_id;
			this.dateCreatedFromSource =dateCreatedFromSource;
		}
		/**
		 * @return the exitid
		 */
		public String getExitid() {
			return exitid;
		}
		/**
		 * @param exitid the exitid to set
		 */
		public void setExitid(String exitid) {
			this.exitid = exitid;
		}
		/**
		 * @return the destination
		 */
		public String getDestination() {
			return destination;
		}
		/**
		 * @param destination the destination to set
		 */
		public void setDestination(String destination) {
			this.destination = destination;
		}
		/**
		 * @return the destination_desc
		 */
		public String getDestination_desc() {
			return destination_desc;
		}
		/**
		 * @param destination_desc the destination_desc to set
		 */
		public void setDestination_desc(String destination_desc) {
			this.destination_desc = destination_desc;
		}
		/**
		 * @return the exitdate
		 */
		public Date getExitdate() {
			return exitdate;
		}
		/**
		 * @param exitdate the exitdate to set
		 */
		public void setExitdate(Date exitdate) {
			this.exitdate = exitdate;
		}
		
		public Date getDateCreatedFromSource() {
			return dateCreatedFromSource;
		}
		public void setDateCreatedFromSource(Date dateCreatedFromSource) {
			this.dateCreatedFromSource = dateCreatedFromSource;
		}
		/**
		 * @return the otherdestination
		 */
		public String getOtherdestination() {
			return otherdestination;
		}
		/**
		 * @param otherdestination the otherdestination to set
		 */
		public void setOtherdestination(String otherdestination) {
			this.otherdestination = otherdestination;
		}
		/**
		 * @return the projectEntryID
		 */
		public String getProjectEntryID() {
			return projectEntryID;
		}
		/**
		 * @param projectEntryID the projectEntryID to set
		 */
		public void setProjectEntryID(String projectEntryID) {
			this.projectEntryID = projectEntryID;
		}
		/**
		 * @return the exit_source_system_id
		 */
		public String getExit_source_system_id() {
			return exit_source_system_id;
		}
		/**
		 * @param exit_source_system_id the exit_source_system_id to set
		 */
		public void setExit_source_system_id(String exit_source_system_id) {
			this.exit_source_system_id = exit_source_system_id;
		}
		
		
}
