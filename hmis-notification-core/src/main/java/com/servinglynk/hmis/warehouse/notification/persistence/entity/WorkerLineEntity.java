package com.servinglynk.hmis.warehouse.notification.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "HMIS_WORKER_LINE" )
public class WorkerLineEntity extends ParentEntity {

	
	private Long id;
	private WorkerHeaderEntity workerHeader;
	private String lineInput;
	private String lineOutput;
	private String status;
	private int maxRetry;
	private int currRetry;
	private int retryInterval;
	private String externalId;
	
	@Id
	@SequenceGenerator(name="pk_sequence",sequenceName="hmis_worker_line_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "external_id")
	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "WORKER_HEADER_ID", nullable = false, referencedColumnName = "id")
	public WorkerHeaderEntity getWorkerHeader() {
		return workerHeader;
	}

	public void setWorkerHeader(WorkerHeaderEntity workerHeader) {
		this.workerHeader = workerHeader;
	}
	
	@Column(name = "line_input")
	public String getLineInput() {
		return lineInput;
	}

	public void setLineInput(String lineInput) {
		this.lineInput = lineInput;
	}

	@Column(name = "line_output")
	public String getLineOutput() {
		return lineOutput;
	}

	public void setLineOutput(String lineOutput) {
		this.lineOutput = lineOutput;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "max_retry")
	public int getMaxRetry() {
		return maxRetry;
	}

	public void setMaxRetry(int maxRetry) {
		this.maxRetry = maxRetry;
	}

	@Column(name = "curr_retry")
	public int getCurrRetry() {
		return currRetry;
	}

	public void setCurrRetry(int currRetry) {
		this.currRetry = currRetry;
	}

	@Column(name = "retry_interval")
	public int getRetryInterval() {
		//in seconds
		return retryInterval;
	}

	public void setRetryInterval(int retryInterval) {
		this.retryInterval = retryInterval;
	}


	
}
