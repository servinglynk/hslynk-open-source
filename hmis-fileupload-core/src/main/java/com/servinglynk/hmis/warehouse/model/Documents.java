package com.servinglynk.hmis.warehouse.model;

import java.util.ArrayList;
import java.util.List;

public class Documents {
	
	List<Document> documents = new ArrayList<>();

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	
	public void addDocument(Document document) {
		this.documents.add(document);
	}
}