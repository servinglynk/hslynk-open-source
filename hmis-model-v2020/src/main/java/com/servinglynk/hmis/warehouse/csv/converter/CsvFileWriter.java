package com.servinglynk.hmis.warehouse.csv.converter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.annotations.MapToColumn;
import com.googlecode.jcsv.writer.CSVEntryConverter;
import com.googlecode.jcsv.writer.CSVWriter;
import com.googlecode.jcsv.writer.internal.CSVWriterBuilder;
import com.servinglynk.hmis.warehouse.csv.Affiliation;
import com.servinglynk.hmis.warehouse.csv.BaseCSV;

public class CsvFileWriter  {
	/***
	 *  This method takes care of writing the objects to a CSV File.
	 * @param fileName
	 * @param csvs
	 * @throws IOException
	 */
	public static void writeToCsv(final String fileName,List<BaseCSV> csvs) throws IOException {
		File file = new File(fileName);
		CSVEntryConverter<BaseCSV> entryConverter = new CSVEntryConverter<BaseCSV>() {
            @Override
            public String[] convertEntry(BaseCSV csv) {
            	Field[] fields = csv.getClass().getDeclaredFields();
                String[] columns = new String[fields.length];
                try {
                	for(Field field : fields) {
                		MapToColumn annotation = field.getAnnotation(com.googlecode.jcsv.annotations.MapToColumn.class);
    					int column = annotation.column();
    					  field.setAccessible(true);
    					Object object = field.get(csv);
    					if(object != null) {
    						columns[column] = String.valueOf(object);
    					}else {
    						columns[column] = "";
    					}
    					
    				}
					} catch ( SecurityException | IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                return columns;
            }
        };
        
        CSVWriter<BaseCSV> csvWriter = new CSVWriterBuilder<BaseCSV>(new FileWriter(file,true))
                .entryConverter(entryConverter)
                .strategy(new CSVStrategy(',', '"', '#', false, true))
                .build();
        csvWriter.writeAll(csvs);
        csvWriter.close();
	}

	
	public static void main(String args[]) throws IOException, IllegalArgumentException, IllegalAccessException {
		
		List<BaseCSV> projects = new ArrayList<>();
		Affiliation obj = new Affiliation();
		Field[] fields = obj.getClass().getDeclaredFields();
		for(Field field : fields) {
			field.setAccessible(true);
			field.set(obj, field.getName());
		}
		Affiliation obj1 = new Affiliation();
		obj1.setAffiliationID("SDD");
		obj1.setProjectID("RS");
		
		projects.add(obj);
		projects.add(obj1);
		writeToCsv("affiliation.csv", projects);
	}
	
}
