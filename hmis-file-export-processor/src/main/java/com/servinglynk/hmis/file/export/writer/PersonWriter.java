package com.servinglynk.hmis.file.export.writer;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.ClassPathResource;

import com.servinglynk.hmis.file.export.Person;

public class PersonWriter extends FlatFileItemWriter<Person> {

	public FlatFileItemWriter<Person> writer(){
	     FlatFileItemWriter<Person> writer = new FlatFileItemWriter<Person>();
	     writer.setResource(new ClassPathResource("users.csv"));
	     writer.setLineAggregator(new DelimitedLineAggregator<Person>() {{
	      setDelimiter(",");
	      setFieldExtractor(new BeanWrapperFieldExtractor<Person>() {{
	       setNames(new String[] { "id", "name" });
	      }});
	     }});
	     
	     return writer;
	    }
}
