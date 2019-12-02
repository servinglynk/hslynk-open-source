package com.servinglynk.hmis.file.export.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.servinglynk.hmis.file.export.User;

public class UserRowMapper implements RowMapper<User>{

	  @Override
	  public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	   User user = new User();
	   user.setFirstName(rs.getString("first_name"));
	   user.setLastName(rs.getString("last_name"));
	   
	   return user;
	  }
	  
	 }