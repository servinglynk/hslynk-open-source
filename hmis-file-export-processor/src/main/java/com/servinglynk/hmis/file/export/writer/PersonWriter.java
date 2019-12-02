package com.servinglynk.hmis.file.export.writer;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.ClassPathResource;

import com.servinglynk.hmis.file.export.User;

public class PersonWriter extends FlatFileItemWriter<User> {

	public FlatFileItemWriter<User> writer(){
	     FlatFileItemWriter<User> writer = new FlatFileItemWriter<User>();
	     writer.setResource(new ClassPathResource("users.csv"));
	     writer.setLineAggregator(new DelimitedLineAggregator<User>() {{
	      setDelimiter(",");
	      setFieldExtractor(new BeanWrapperFieldExtractor<User>() {{
	       setNames(new String[] { "firstName", "lastName" });
	      }});
	     }});
	     
	     return writer;
	    }
}
