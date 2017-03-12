package com.servinglynk.report.csv;

import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;
import com.servinglynk.report.bean.Q05aHMISComparableDBDataQualityDataBean;

public class Q5aGenerator extends CsvReportGenerator{
	/***
	 * Generates data for Q4aBean.
	 * @param bean
	 * @throws IOException
	 */
	public static void  buildReport(Q05aHMISComparableDBDataQualityDataBean bean) {
		String csv = "q5a.csv";
		try {
	    CSVWriter csvWriter = new CSVWriter(new FileWriter(csv, false));
		csvWriter.writeNext(new String[] {"Category","Client Doesn't Know or Client Refused","Data not collected"});
		csvWriter.writeNext(new String[] {"First name",getStringValue(bean.getQ05aFirstName()),getStringValue(bean.getQ05aDNCFirstName())});
		csvWriter.writeNext(new String[] {"Last name", getStringValue(bean.getQ05aLastName()),getStringValue(bean.getQ05aDNCLastName())});
		//using custom delimiter and quote character
		csvWriter.close();
		}catch(IOException e) {
			
		}
	}
	
}
