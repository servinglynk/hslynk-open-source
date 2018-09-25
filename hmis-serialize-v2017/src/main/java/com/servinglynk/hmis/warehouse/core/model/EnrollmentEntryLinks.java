package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentEntryLinks {
	
	List<ActionLink> rhsps = new ArrayList<>();
	List<ActionLink> entryrhys = new ArrayList<>();
	List<ActionLink> entryssvfs = new ArrayList<>();

	public List<ActionLink> getRhsps() {
		return rhsps;
	}

	public void setRhsps(List<ActionLink> rhsps) {
		this.rhsps = rhsps;
	}

	public List<ActionLink> getEntryrhys() {
		return entryrhys;
	}

	public void setEntryrhys(List<ActionLink> entryrhys) {
		this.entryrhys = entryrhys;
	}

	public List<ActionLink> getEntryssvfs() {
		return entryssvfs;
	}

	public void setEntryssvfs(List<ActionLink> entryssvfs) {
		this.entryssvfs = entryssvfs;
	}
}