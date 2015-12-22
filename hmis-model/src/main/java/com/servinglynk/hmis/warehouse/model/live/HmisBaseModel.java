package com.servinglynk.hmis.warehouse.model.live;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class HmisBaseModel implements Entity{
//	/** Field mapping. */
//	protected LocalDateTime dateCreated;
//	/** Field mapping. */
//	protected LocalDateTime dateUpdated;
	/** Field mapping. */
	protected String projectGroupCode;
	/** Field mapping. */
//	private HmisUser user;
	 /**
//		 * Return the value associated with the column: dateCreated.
//		 * @return A LocalDateTime object (this.dateCreated)
//		 */
//		@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
//		@Basic( optional = true )
//		@Column( name = "date_created"  )
//		public LocalDateTime getDateCreated() {
//			return this.dateCreated;
//		}
//		 /**  
//		 * Set the value related to the column: dateCreated.
//		 * @param dateCreated the dateCreated value you wish to set
//		 */
//		public void setDateCreated(final LocalDateTime dateCreated) {
//			this.dateCreated = dateCreated;
//		}
//
//		 /**
//		 * Return the value associated with the column: dateUpdated.
//		 * @return A LocalDateTime object (this.dateUpdated)
//		 */
//		@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
//		@Basic( optional = true )
//		@Column( name = "date_updated"  )
//		public LocalDateTime getDateUpdated() {
//			return this.dateUpdated;
//		}
//		 /**  
//		 * Set the value related to the column: dateUpdated.
//		 * @param dateUpdated the dateUpdated value you wish to set
//		 */
//		public void setDateUpdated(final LocalDateTime dateUpdated) {
//			this.dateUpdated = dateUpdated;
//		}
	
		  @Column(name="project_group_code")
			public String getProjectGroupCode() {
				return projectGroupCode;
			}
			public void setProjectGroupCode(String projectGroupCode) {
				this.projectGroupCode = projectGroupCode;
			}
			
			
//
//			 /**
//			 * Return the value associated with the column: user.
//			 * @return A HmisUser object (this.user)
//			 */
//			@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
//			@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//			@Basic( optional = true )
//			@JoinColumn(name = "user_id", nullable = true )
//			public HmisUser getUser() {
//				return this.user;
//				
//			}
//			
//
//		  
//			 /**  
//			 * Set the value related to the column: user.
//			 * @param user the user value you wish to set
//			 */
//			public void setUser(final HmisUser user) {
//				this.user = user;
//			}
}