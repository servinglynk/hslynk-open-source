package com.servinglynk.hmis.file.export.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.file.export.Person;
import com.servinglynk.hmis.file.export.mapper.UserRowMapper;

@Component
public class PersonReader extends JdbcCursorItemReader<Person>  {

    @Autowired
    public DataSource dataSource;
    
	  public JdbcCursorItemReader<Person> reader(){
		     JdbcCursorItemReader<Person> reader = new JdbcCursorItemReader<Person>();
		     reader.setDataSource(dataSource);
		     reader.setSql("SELECT id,name FROM user");
		     reader.setRowMapper(new UserRowMapper());
		     
		     return reader;
		    }
		    
}
