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
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.dao.ParentDaoFactory;
import com.servinglynk.hmis.warehouse.model.live.Export;
import com.servinglynk.hmis.warehouse.model.staging.BulkUpload;
import com.servinglynk.hmis.warehouse.upload.business.exception.ReportCreationException;
import com.servinglynk.hmis.warehouse.upload.business.service.core.ParentService;
import com.servinglynk.hmis.warehouse.upload.business.util.UploadStatus;


@Component
@Service
public class BulkUploadWorker  extends ParentService implements IBulkUploadWorker  {
	
	final static Logger logger = Logger.getLogger(BulkUploadWorker.class);

	@Autowired
	Environment env;

	@Autowired
	private ParentDaoFactory factory;
	
	@Transactional
	@Scheduled(initialDelay=20,fixedDelay=10000)
	public void processWorkerLine() throws ReportCreationException{
		
		try {
			
			File[] files = new File(env.getProperty("upload.loc")).listFiles();
			//If this pathname does not denote a directory, then listFiles() returns null. 
			if(files !=null && files.length > 0 )
			for (File file : files) {
			    if (file.isFile()) {
			        moveFile(file.getAbsolutePath(),env.getProperty("upload.backup.loc") + file.getName());
			        BulkUpload upload = new BulkUpload();
					upload.setInputPath(env.getProperty("upload.backup.loc")+file.getName());
					upload.setStatus("INITIAL");
					upload.setInsertAt(new Date());
					upload.setUpdateAt(new Date());
					upload.setInsertBy("ADMIN");
					upload.setUpdateBy("ADMIN");
					daoFactory.getBulkUploaderWorkerDao().insert(upload);
			    }
			}
			
			List<BulkUpload> uploadEntities=  factory.getBulkUploaderWorkerDao().findBulkUploadByStatus(UploadStatus.INITIAL.getStatus());
			
			if(uploadEntities!=null && uploadEntities.size() >0 ) {
				for(BulkUpload bullkUpload : uploadEntities) {
					factory.getBulkUploaderDao().performBulkUpload(bullkUpload);
					//bullkUpload.setStatus("COMPLETE");
				//	factory.getBulkUploaderWorkerDao().update(bullkUpload);
					new File(bullkUpload.getInputPath()).delete();
				}
			}
			
			List<BulkUpload> stagingUploadEntities=  factory.getBulkUploaderWorkerDao().findBulkUploadByStatus(UploadStatus.STAGING.getStatus());
			if(stagingUploadEntities!=null && stagingUploadEntities.size() >0 ) {
				for(BulkUpload bulkUpload : stagingUploadEntities) {
					factory.getBulkUploaderDao().moveFromStagingToLive(bulkUpload.getExport().getId());
				/*	com.servinglynk.hmis.warehouse.model.live.BulkUpload target  = new com.servinglynk.hmis.warehouse.model.live.BulkUpload();
					BeanUtils.copyProperties(bulkUpload, target,getNonCollectionFields(target));
					target.setStatus(UploadStatus.LIVE.getStatus());
					 com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) factory.getExportDao().get(com.servinglynk.hmis.warehouse.model.live.Export.class, bulkUpload.getExport().getId());
					target.setExport(exportEntity);
					factory.getBulkUploaderWorkerDao().insertOrUpdate(target); */
				}
			}
			
			
			logger.info("Sandeep Testing");
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
	    			aLine = aLine.replaceAll("hmis:", "");
	    			out.write(aLine);
	    			out.newLine();
	    		}
	     
	    		// do not forget to close the buffer reader
	    		in.close();
	     
	    		// close buffer writer
	    		out.close();

	    	    //delete the original file
	    		fin.delete();
	    	    //output.renameTo(new File("C:\\HMISTEstDev\\XMLGen\\src\\com\\servinglynk\\hmis\\warehouse\\jaxb\\output\\" + output.getName()));
	    	    System.out.println("File is copied successful!");
	 
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
//	@Transactional
//	@Scheduled(initialDelay=20,fixedDelay=10000)
//	public void movetoLive() throws ReportCreationException{
//		
//		try {
//			
//			List<BulkUpload> uploadEntities=  factory.getBulkUploaderWorkerDao().findUnProcessedUploads(UploadStatus.STAGING.getStatus());
//			
//			if(uploadEntities!=null && uploadEntities.size() >0 ) {
//				for(BulkUpload bullkUpload : uploadEntities) {
//					//factory.getBulkUploaderDao().performBulkUpload();
//					bullkUpload.setStatus("COMPLETE");
//					factory.getBulkUploaderWorkerDao().update(bullkUpload);
//				}
//			}
//			logger.info("Sandeep Testing");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//	}

}
