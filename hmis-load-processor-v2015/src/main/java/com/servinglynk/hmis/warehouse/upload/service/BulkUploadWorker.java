package com.servinglynk.hmis.warehouse.upload.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.dao.ParentDaoFactory;
import com.servinglynk.hmis.warehouse.model.base.BulkUpload;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.upload.business.exception.BulkUploadException;
import com.servinglynk.hmis.warehouse.upload.business.util.UploadStatus;


@Component
@Service
public class BulkUploadWorker implements IBulkUploadWorker  {
	
	final static Logger logger = Logger.getLogger(BulkUploadWorker.class);

	@Autowired
	Environment env;

	@Autowired
	private ParentDaoFactory factory;
	
	@Transactional
	@Scheduled(initialDelay=20,fixedDelay=10000)
	public void processWorkerLine() throws BulkUploadException{
		try {
			List<BulkUpload> uploadEntities=  factory.getBulkUploaderWorkerDao().findBulkUploadByStatusAndYear(UploadStatus.INITIAL.getStatus(),new Long(2015));
			if(uploadEntities!=null && uploadEntities.size() >0 ) {
				for(BulkUpload upload : uploadEntities) {
					FileAppender appender = new FileAppender();
					appender.setName("" + upload.getId());
					appender.setFile("logs/" + upload.getId() + ".log");
					appender.setImmediateFlush(true);
					appender.setAppend(true);
					appender.setLayout(new PatternLayout());
					appender.activateOptions();
					/** Perform full refresh base on Project group */
					if(upload.getProjectGroupCode() !=null) {
						List<BulkUpload> uploads = factory.getBulkUploaderWorkerDao().findBulkUploadByProjectGroupCodeAndYear(upload.getProjectGroupCode(),new Long(2015));
						for(BulkUpload  bulkUpload : uploads) {
						//	factory.getBulkUploaderDao().deleteLiveByProjectGroupCode(bulkUpload.getProjectGroupCode(),upload.getExportId());
							bulkUpload.setStatus("DELETED");
							factory.getBulkUploaderWorkerDao().delete(bulkUpload);
						}
					}
					upload.setStatus(UploadStatus.INPROGRESS.getStatus());
					factory.getBulkUploaderWorkerDao().insertOrUpdate(upload);
					File file = new File(upload.getInputpath());
					ProjectGroupEntity projectGroupEntity = factory.getProjectGroupDao().getProjectGroupByGroupCode(upload.getProjectGroupCode());
					factory.getBulkUploaderDao().performBulkUpload(upload,projectGroupEntity,appender,true);
					if (file.isFile()) {
				        moveFile(file.getAbsolutePath(),env.getProperty("upload.backup.loc") + file.getName());
				      //  new File(bullkUpload.getInputPath()).delete();
					}
				}
			}
			logger.info("========Bulk Uploader processed ======");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void moveFile(String inputPath,String outputPath) throws IOException
	{
		
		if(inputPath.contains(".zip")) {
			moveZipFile(inputPath, outputPath);
		}
		else{
			moveXMLFile(inputPath, outputPath);
		}
	}
	private void moveZipFile(String inputPath, String outputPath) {
		FileOutputStream foutOutput = null;
        File f = new File(inputPath);
        f.renameTo(new File(outputPath));
	}
	private void moveXMLFile(String inputPath, String outputPath) throws IOException {
		File fin = null;
		FileInputStream fis =null;
		FileWriter fstream = null;
	    	try{
	 
	    	    fin = new File(inputPath);
	    		fis = new FileInputStream(fin);
	    		BufferedReader in = new BufferedReader(new InputStreamReader(fis));
	     
	    		fstream = new FileWriter(outputPath, true);
	    		BufferedWriter out = new BufferedWriter(fstream);
	     
	    		String aLine = null;
	    		while ((aLine = in.readLine()) != null) {
	    			//Process each line and add output to Dest.txt file
	    			out.write(aLine);
	    			out.newLine();
	    		}
	     
	    		// do not forget to close the buffer reader
	    		in.close();
	     
	    		// close buffer writer
	    		out.close();

	    	    //delete the original file
	    	//	fin.delete();
	 
	    	}catch(IOException e){
	    	    e.printStackTrace();
	    	}
	    	finally {
	    		 if (fis != null) fis.close();
	    		 if (fstream !=null) fstream.close();
	    	}

	}
	
	protected String[] getNonCollectionFields(Object obj) {
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		//System.out.println(declaredFields[0].getName() + " type of the field "+declaredFields[0].getGenericType() );
		String[] fieldsArray = new String[100];
		
		int i=0;
		for(Field field : declaredFields) {
			Type genericType = field.getGenericType();
			if(genericType != null ){
				String fieldName = field.getName();
				if(fieldName !=null && genericType.getTypeName().contains("Set")){
						fieldsArray[++i]= field.getName();	
				}
				if("serialVersionUID".equals(fieldName) || "SAVED_HASHES".equals(fieldName) || "hashCode".equals(fieldName)) {
					fieldsArray[++i]= field.getName();	
				}
				
			}
		}
		return fieldsArray;
	}

}
