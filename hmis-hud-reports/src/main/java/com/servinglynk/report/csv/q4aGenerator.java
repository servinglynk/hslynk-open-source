package com.servinglynk.report.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVWriter;

public class q4aGenerator {
	public static void main(String[] args) throws IOException {
		StringWriter writer = new StringWriter();
		  String csv = "q4a.csv";
	      CSVWriter csvWriter = new CSVWriter(new FileWriter(csv, false));
		//using custom delimiter and quote character
		List<String[]> data = toStringArray(generateData());

		csvWriter.writeAll(data);

		csvWriter.close();
		
		System.out.println(writer);
	}

	public static List<q4a> generateData() {
		List<q4a> q4as = new ArrayList<q4a>();
		q4a q4a = new q4a("Organization name","");
		q4a q4a1 = new q4a("Organization ID","");
		q4a q4a2 = new q4a("Project name","");
		q4a q4a3 = new q4a("Project ID","");
		q4a q4a4 = new q4a("HMIS Project Type","");
		q4a q4a5 = new q4a("Method of tracking ES","");
		q4a q4a6 = new q4a("If HMIS Project ID = 6 (S Only), is the Services Only (HMIS Project Type 6) affiliated with a residential project?","");
		q4a q4a7 = new q4a("Identify the Project ID's of the housing projects this project is affiliated with","");
		q4as.add(q4a);
		q4as.add(q4a1);
		q4as.add(q4a2);
		q4as.add(q4a3);
		q4as.add(q4a4);
		q4as.add(q4a5);
		q4as.add(q4a6);
		q4as.add(q4a7);
		return q4as;
	}
	private static List<String[]> toStringArray(List<q4a> emps) {
		List<String[]> records = new ArrayList<String[]>();
		// adding header record
	//	records.add(new String[] { "ID", "Name", "Age", "Country" });
		Iterator<q4a> it = emps.iterator();
		while (it.hasNext()) {
			q4a emp = it.next();
			records.add(new String[] { emp.getTitle(), emp.getValue()});
		}
		return records;
	}

}