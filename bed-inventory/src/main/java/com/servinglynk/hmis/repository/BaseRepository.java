package com.servinglynk.hmis.repository;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T,UUID>  {

	void delete(T entity) ;
	
}
