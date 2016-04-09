package com.servinglynk.hmis.warehouse.model.v2014;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity (name = "bulk_upload")
@Table(name = "bulk_upload", catalog = "hmis", schema = "v2014")
public class BulkUpload extends HmisBaseModel implements Cloneable, Serializable {


	/** Serial Version UID. */
	private static final long serialVersionUID = -3243148389368176233L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());
	
	private Long id;
	private String inputPath;
	private String status;
	private Long size;
	/** Field mapping. */
	private Export export;
	private String description;

	 /**
	 * Return the value associated with the column: export.
	 * @return A Export object (this.export)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.LAZY)
//	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.REMOVE})
	@Basic( optional = true )
	@JoinColumn(name = "export_id", nullable = true )
	public Export getExport() {
		return this.export;
		
	}
	

 
	 /**  
	 * Set the value related to the column: export.
	 * @param export the export value you wish to set
	 */
	public void setExport(final Export export) {
		this.export = export;
	}
	
	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="bulk_upload_id_seq", name="bulk_upload_id_seq" , catalog = "hmis", schema = "v2014")
	@GeneratedValue(generator="bulk_upload_id_seq", strategy=GenerationType.SEQUENCE )
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "size")
	public Long getSize() {
		return size;
	}



	public void setSize(Long size) {
		this.size = size;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "inputPath")
	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}


	@Column(name = "description")
	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}
	


	
}