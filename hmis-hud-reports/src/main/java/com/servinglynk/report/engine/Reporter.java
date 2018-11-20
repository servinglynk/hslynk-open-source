package com.servinglynk.report.engine;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.servinglynk.hmis.warehouse.Properties;
import com.servinglynk.report.bean.HomePageDataBean;
import com.servinglynk.report.business.HomePageDataBeanMaker;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class Reporter {
	
		private Logger logger = Logger.getLogger(Reporter.class);
		
        @SuppressWarnings("unchecked")
        
    private void exportToPDF(boolean sageReport) {
        try {         
        	Properties props = new Properties();
    		props.generatePropValues();
        
			List<String> projects = new ArrayList<>();
//			projects.add("4055e079-fbef-42cd-9f58-43a90be60b47");
//			projects.add("468b31e4-3492-4043-a917-53b66b3cf617");
//			projects.add("538948f4-3c13-4907-9174-2078c4408ce7");
//			
//			projects.add("5cc34dce-e603-4cb6-8d95-4cd3fb164098");
//			projects.add("5e63e036-50fc-4ce1-bc88-6b61bbedd539");
//			projects.add("8ce3bcf7-cea0-4735-9330-bb7f04b71a40");
//			
//			projects.add("913f65e5-d9d0-4312-b0ee-d94920bed6c2");
//			projects.add("c31f3f53-0b9f-480e-8da8-ffe8c7b931ed");
//			projects.add("e6ccebeb-2b03-47aa-96dc-e63b9d2c4fc1");
//			projects.add("6eec300a-20a8-4e0f-9e00-ae8fc47fd677");
//			
			projects.add("007b8db8-66c4-4967-8d04-672cfa75dcbc");
			projects.add("04882e7f-3e3a-47a6-a46c-f6e9b14982f5");
			projects.add("106646c2-9618-4b96-bbb8-17acd6acf4c9");
			projects.add("121f4319-2bf6-4a51-b314-c2fec62a1c42");
			projects.add("16b61411-53a4-4075-9641-8cc1d7392a36");
			projects.add("19ab947d-d7bd-456a-ad03-73cee64cf4cc");
			projects.add("2bbc54d6-19fb-48ca-b891-c451301f761f");
			projects.add("338ceda0-5d3d-4edb-9b11-ea8fb2b65292");
			projects.add("3763bd78-dabe-41bc-999e-e7f6a197aefe");
			projects.add("4055e079-fbef-42cd-9f58-43a90be60b47");
			projects.add("468b31e4-3492-4043-a917-53b66b3cf617");
			projects.add("4acf19f6-f2d3-4bb7-bc8d-7ce23934e2f9");
			projects.add("537d3c78-4cb8-49cf-aa37-b6ffafebd453");
			projects.add("538948f4-3c13-4907-9174-2078c4408ce7");
			projects.add("5cc34dce-e603-4cb6-8d95-4cd3fb164098");
			projects.add("5d36df7a-3189-49c4-af16-af8c86c1f6d5");
//			projects.add("5e63e036-50fc-4ce1-bc88-6b61bbedd539");
//			projects.add("5eb8c3a1-71bb-417a-8823-aa11918fa6c3");
//			projects.add("5eecd952-4815-432c-a218-86732e125a74");
//			projects.add("6c8529d9-94ed-4472-9176-4416867fa45d");
//			projects.add("6eec300a-20a8-4e0f-9e00-ae8fc47fd677");
//			projects.add("7aa8a05c-c045-4a59-9cfb-54eb8017b9d6");
//			projects.add("7fbdd50a-cf93-4bc6-909b-92c046b58c30");
//			projects.add("8ce3bcf7-cea0-4735-9330-bb7f04b71a40");
//			projects.add("913f65e5-d9d0-4312-b0ee-d94920bed6c2");
//			projects.add("94e8eb77-3352-489a-ada9-246647783734");
//			projects.add("95104b76-17fd-4672-a304-8a83d80584b0");
//			projects.add("a10b493a-dc24-4921-8eaa-14f042d0d8c2");
//			projects.add("acc5499f-2205-4ea6-bfde-204b46bf41d8");
//			projects.add("af899a81-18c6-49ac-b4be-39e56d4d570f");
//			projects.add("afe83755-344d-432b-85f5-26678ddf1f2f");
//			projects.add("b5b77dd3-29b1-4478-a5de-f216bfacd298");
//			projects.add("bae8e0ab-caaf-46dc-83ba-b28bbeeb067f");
//			projects.add("bce99331-9fb4-4e01-9c39-70a30c8e3d2c");
//			projects.add("c31f3f53-0b9f-480e-8da8-ffe8c7b931ed");
//			projects.add("dc58b445-0eab-4656-b9d1-fa95a0ea0850");
//			projects.add("e00ef1e1-cc79-4480-ae9c-3af431911bd9");
//			projects.add("e274f1cc-6442-4092-baef-fd929b49c91a");
//			projects.add("e6ccebeb-2b03-47aa-96dc-e63b9d2c4fc1");
//			projects.add("e86319a3-aae0-4183-8455-2020aeff1a03");
//			projects.add("eac3d5a4-cfac-4d44-94b2-8ea56e0042b5");
//			projects.add("ee01027c-49d6-4e0e-b2e2-b7ae3bda310d");
			
			ClassLoader classLoader = Reporter.class.getClassLoader();
			File file = new File(classLoader.getResource("q17.jrxml").getFile());
			InputStream inputStream = new FileInputStream(file);
		    JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
		    String jasperReport = JasperCompileManager.compileReportToFile("/Users/sdolia/github/hmis-lynk-open-source/hmis-hud-reports/src/main/csvresources/q17.jrxml");
		    
        	List<HomePageDataBean> dataBeanList = HomePageDataBeanMaker.getHomePageDataList("sr0012",null,sageReport, new Date(), new Date(),projects);
        	if(!sageReport) {
                JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
                Map parameters = new HashMap();
//            	ClassLoader classLoader = Reporter.class.getClassLoader();
//    			File file = new File(classLoader.getResource("pdfGenerator.jrxml").getFile());
//    			InputStream inputStream = new FileInputStream(file);
//    		    JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
//    		    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//    		 
    		    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
    		    JasperExportManager.exportReportToPdfFile(jasperPrint, "HMISREPORT_testing.pdf"); 
        	}
        } catch (Exception e) {
            logger.error(e, e);
        }
    }

        public static void main(String[] args) throws Exception {
//        	ClassLoader classLoader = Reporter.class.getClassLoader();
//        	   File file1 = new File(classLoader.getResource("q21_Health_Insurance.jrxml").getFile());
//   			InputStream inputStream1 = new FileInputStream(file1);
//   		    JasperDesign jasperDesign1 = JRXmlLoader.load(inputStream1);
//   		    JasperReport jasperReport1 = JasperCompileManager.compileReportToFile("q21_Health_Insurance.jrxml","q21_Health_Insurance.jasper");
//   		    
   		    
    	 boolean sageReport=true;
        Reporter main = new Reporter();
        main.exportToPDF(sageReport);
    }
	
	
}