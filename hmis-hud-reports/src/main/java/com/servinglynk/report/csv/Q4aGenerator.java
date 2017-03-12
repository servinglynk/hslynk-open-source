package com.servinglynk.report.csv;

import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;
import com.servinglynk.report.bean.HomePageDataBean;

public class Q4aGenerator extends CsvReportGenerator{
	/***
	 * Generates data for Q4aBean.
	 * @param bean
	 * @throws IOException
	 */
	public static void  buildReport(HomePageDataBean bean) {
		String csv = "q4a.csv";
	    CSVWriter csvWriter;
		try {
			csvWriter = new CSVWriter(new FileWriter(csv, false));
			//using custom delimiter and quote character
		csvWriter.writeNext( new String[] {"Organization name",bean.getQ04aOrgName()});
		csvWriter.writeNext( new String[] {"Organization ID",bean.getQ04aOrgId()});
		csvWriter.writeNext( new String[] {"Project name",bean.getQ04aProjectName()});
		csvWriter.writeNext( new String[] {"Project ID",bean.getQ04aProjectId()});
		csvWriter.writeNext(new String[] {"HMIS Project Type",bean.getQ04aHmisProjectType()});
		csvWriter.writeNext(new String[] {"Method of tracking ES",bean.getQ04aMethodOfTracking()});
		csvWriter.writeNext(new String[] {"If HMIS Project ID = 6 (S Only), is the Services Only (HMIS Project Type 6) affiliated with a residential project?",bean.getQ04aHmisProjectType()});
		csvWriter.writeNext(new String[] {"Identify the Project ID's of the housing projects this project is affiliated with", getStringValue(bean.getQ04aIdentityProjectId()) });
		csvWriter.close();
		}catch (IOException e) {
				e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		HomePageDataBean bean = new HomePageDataBean();
		buildReport(bean);
	}

}