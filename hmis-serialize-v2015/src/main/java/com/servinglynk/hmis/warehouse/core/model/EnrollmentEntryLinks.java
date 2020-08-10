package com.servinglynk.hmis.warehouse.core.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnrollmentEntryLinks {
	
	Map<String,Map<String,List<ActionLinks>>> rhsps = new HashMap<>();

	Map<String,Map<String,List<ActionLinks>>> entryrhys = new HashMap<>();
	Map<String,Map<String,List<ActionLinks>>> entryssvfs = new HashMap<>();
	
	public Map<String,Map<String,List<ActionLinks>>> getRhsps() {
		return rhsps;
	}
	public void setRhsps(Map<String,Map<String,List<ActionLinks>>> rhsps) {
		this.rhsps = rhsps;
	}
	public Map<String,Map<String,List<ActionLinks>>> getEntryrhys() {
		return entryrhys;
	}
	public void setEntryrhys(Map<String,Map<String,List<ActionLinks>>> entryrhys) {
		this.entryrhys = entryrhys;
	}
	public Map<String,Map<String,List<ActionLinks>>> getEntryssvfs() {
		return entryssvfs;
	}
	public void setEntryssvfs(Map<String,Map<String,List<ActionLinks>>> entryssvfs) {
		this.entryssvfs = entryssvfs;
	}	
}