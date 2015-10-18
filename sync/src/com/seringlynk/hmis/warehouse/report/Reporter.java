package com.seringlynk.hmis.warehouse.report;


import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



import com.servinglynk.hmis.warehouse.model.Project;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class Reporter {
        @SuppressWarnings("unchecked")
        public static void main(String[] args) throws Exception {
        		//URL path = Reporter.class.getResource("Project_Identifiers.jrxml");
        	
        	//Sandeep TODO: Need to get the rowKey from the report requested:
        	
                InputStream inputStream = new FileInputStream ("/home/ubuntu/Project_Identifiers.jrxml");
                ReportDataGenerator<Project> reportDataProject = new ReportDataGenerator<Project>();
                Project project = new Project();
                Project project1 = (Project) reportDataProject.getResult("cd2733e2-7fc1-4e33-a61e-8eb97718cbb0", "hmis", "Project", project);
                
                DataBeanMaker dataBeanMaker = new DataBeanMaker();
                ArrayList<DataBean> dataBeanList = dataBeanMaker.getDataBeanList(project1);
                
                JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
                
                Map parameters = new HashMap();
        
        JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "/home/ubuntu/report.pdf"); 
        
        // Write code to email the report.
        System.out.println("Report is generated");
        }
}