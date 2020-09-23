package com.servinglynk.hmis.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {

	void delete(T entity) throws Exception ;
	T findOne(ID id);

	
}
