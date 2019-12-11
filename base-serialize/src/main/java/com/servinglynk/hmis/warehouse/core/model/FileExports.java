package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.servinglynk.hmis.warehouse.PaginatedModel;

public class FileExports  extends PaginatedModel {
	@JsonProperty("fileExports")
	private List<FileExport> fileExports = new ArrayList<FileExport>();

	/**
	 * @return the fileExports
	 */
	public List<FileExport> getFileExports() {
		return fileExports;
	}

	/**
	 * @param fileExports the fileExports to set
	 */
	public void setFileExports(List<FileExport> fileExports) {
		this.fileExports = fileExports;
	}

	public void addFileExports(FileExport fileExport) {
		this.fileExports.add(fileExport);
	}
}