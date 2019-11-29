package com.servinglynk.hmis.file.export.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.servinglynk.hmis.file.export.Person;

public class UserRowMapper implements RowMapper<Person>{

	  @Override
	  public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
	   Person user = new Person();
	   user.setFirstName(rs.getString("id"));
	   user.setLastName(rs.getString("name"));
	   
	   return user;
	  }
	  
	 }