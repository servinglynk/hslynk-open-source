package com.servinglynk.report.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class CompileReports {

	public static void main(String args[]) {
		try {
			
		ClassLoader classLoader = CompileReports.class.getClassLoader();
    	List<String> files = new ArrayList<String>();
//    	files.add("q13a1_Physical_and_Mental_Health_Conditions_at_Entry.jrxml");
//    	files.add("q13a2_Number_Of_Conditions_At_Entry.jrxml");
//    	files.add("q13b1_Physical_And_Mental_Health_Conditions_At_Exit.jrxml");
//    	files.add("q13b2_Number_Of_Conditions_at_Exit.jrxml");
//    	files.add("q13c1_Physical_And_Mental_Health_Conditions_For_Stayers.jrxml");
//    	files.add("q13c2_Number_Of_Conditions_For_Stayer.jrxml");
//    	files.add("q14a_Domestic_Violence_History.jrxml");
//    	files.add("q14b_Persons_Fleeing_Domestic_Violence.jrxml");
    //	files.add("q16_Cash_Income_Ranges.jrxml");
//    	files.add("q19a3_Client_Cash_Income_Change_Income_Source_By_Entry.jrxml");
//    	files.add("q19a2_Client_Cash_Income_Change_Income_Source_By_Entry.jrxml");
//    	
    	files.add("q19a2.jrxml");
    	files.add("q19a3.jrxml");
    	
    	//files.add("q12b_Ethnicity.jrxml");
    	for(String fileName : files) {
    	System.out.println("File name:"+fileName);
		File file = new File(classLoader.getResource(fileName).getFile());
		InputStream inputStream = new FileInputStream(file);
	    JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
	    String destFile = fileName.replace("jrxml", "jasper");
	    JasperCompileManager.compileReportToFile("/Users/sdolia/github/hmis-lynk-open-source/hmis-hud-reports/src/main/csvresources/"+fileName,"/Users/sdolia/github/hmis-lynk-open-source/hmis-hud-reports/src/main/csvresources/"+destFile);
	    
    	}
		}
	catch (Exception e) {
		e.printStackTrace();
}
}
}
