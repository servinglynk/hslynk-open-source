package com.servinglynk.hmis.warehouse.core.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnrollmentEntryLinks {
	
	Map<String, List<ActionLink>> rhsps = new HashMap<>();

	Map<String, List<ActionLink>> entryrhys = new HashMap<>();
	Map<String, List<ActionLink>> entryssvfs = new HashMap<>();
	
	public Map<String, List<ActionLink>> getRhsps() {
		return rhsps;
	}
	public void setRhsps(Map<String, List<ActionLink>> rhsps) {
		this.rhsps = rhsps;
	}
	public Map<String, List<ActionLink>> getEntryrhys() {
		return entryrhys;
	}
	public void setEntryrhys(Map<String, List<ActionLink>> entryrhys) {
		this.entryrhys = entryrhys;
	}
	public Map<String, List<ActionLink>> getEntryssvfs() {
		return entryssvfs;
	}
	public void setEntryssvfs(Map<String, List<ActionLink>> entryssvfs) {
		this.entryssvfs = entryssvfs;
	}	
}