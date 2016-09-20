package com.servinglynk.hmis.warehouse.model.v2015;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Export extends BaseModel {

	@Column(name = "export_date")
	public Timestamp export_date;
	@Column(name = "start_date")
	public Timestamp start_date;
	@Column(name = "end_date")
	public Timestamp end_date;
	@Column(name = "exportperiodtype")
	public String exportperiodtype;
	@Column(name = "exportdirective")
	public String exportdirective;
	@Column(name = "source_id")
	public UUID source_id;

	/**
	 * @return the export_date
	 */
	public Timestamp getExport_date() {
		return export_date;
	}

	/**
	 * @param export_date
	 *            the export_date to set
	 */
	public void setExport_date(Timestamp export_date) {
		this.export_date = export_date;
	}

	/**
	 * @return the start_date
	 */
	public Timestamp getStart_date() {
		return start_date;
	}

	/**
	 * @param start_date
	 *            the start_date to set
	 */
	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}

	/**
	 * @return the end_date
	 */
	public Timestamp getEnd_date() {
		return end_date;
	}

	/**
	 * @param end_date
	 *            the end_date to set
	 */
	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}

	/**
	 * @return the exportperiodtype
	 */
	public String getExportperiodtype() {
		return exportperiodtype;
	}

	/**
	 * @param exportperiodtype
	 *            the exportperiodtype to set
	 */
	public void setExportperiodtype(String exportperiodtype) {
		this.exportperiodtype = exportperiodtype;
	}

	/**
	 * @return the exportdirective
	 */
	public String getExportdirective() {
		return exportdirective;
	}

	/**
	 * @param exportdirective
	 *            the exportdirective to set
	 */
	public void setExportdirective(String exportdirective) {
		this.exportdirective = exportdirective;
	}

	/**
	 * @return the source_id
	 */
	public UUID getSource_id() {
		return source_id;
	}

	/**
	 * @param source_id
	 *            the source_id to set
	 */
	public void setSource_id(UUID source_id) {
		this.source_id = source_id;
	}

}
