package com.servinglynk.hmis.warehouse;

public class SyncParams {
	
	private String projectGroupCode;
	private String schemaName;
	private String tableName;
	private String deleteandRefresh;
	/**
	 * @return the schemaName
	 */
	public String getSchemaName() {
		return schemaName;
	}
	/**
	 * @param schemaName the schemaName to set
	 */
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}
	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}
	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/**
	 * @return the projectGroupCode
	 */
	public String getProjectGroupCode() {
		return projectGroupCode;
	}
	/**
	 * @param projectGroupCode the projectGroupCode to set
	 */
	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}
	/**
	 * @return the deleteandRefresh
	 */
	public String getDeleteandRefresh() {
		return deleteandRefresh;
	}
	/**
	 * @param deleteandRefresh the deleteandRefresh to set
	 */
	public void setDeleteandRefresh(String deleteandRefresh) {
		this.deleteandRefresh = deleteandRefresh;
	}
	
}
