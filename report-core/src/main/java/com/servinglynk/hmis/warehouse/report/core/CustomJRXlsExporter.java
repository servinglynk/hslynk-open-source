package com.servinglynk.hmis.warehouse.report.core;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import net.sf.jasperreports.engine.export.JRXlsExporter;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.servinglynk.hmis.warehouse.report.service.ReportService;
 

public class CustomJRXlsExporter extends JRXlsExporter {
	private static final  Logger logger = Logger.getLogger(CustomJRXlsExporter.class);
	     
	    private InputStream is;
	     
	    public InputStream getIs() {
	        return is;
	    }
	 
	    public void setIs(InputStream is) {
	        this.is = is;
	    }
	 
	    @Override
	    protected void openWorkbook(OutputStream os) {
	        if(is != null) {
	            try {
	                workbook = new HSSFWorkbook(is);
	                emptyCellStyle = workbook.createCellStyle();
	                emptyCellStyle.setFillForegroundColor((new HSSFColor.WHITE()).getIndex());
	                emptyCellStyle.setFillPattern(backgroundMode);
	                dataFormat = workbook.createDataFormat();
	                createHelper = workbook.getCreationHelper();
	                workbook.setActiveSheet(1);
	                return;
	            } catch (IOException e) {
	                logger.error("Creating a new Workbook when I was supposed to use an existing one.", e);
	            }
	        }
	        super.openWorkbook(os);
	    }
	}


