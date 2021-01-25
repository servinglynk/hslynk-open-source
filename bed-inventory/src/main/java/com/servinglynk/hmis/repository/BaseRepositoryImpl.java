package com.servinglynk.hmis.repository;

public class BaseRepositoryImpl<T, UUID> implements BaseRepository<T, UUID> {

	@Override
	public void delete(T entity) {
		System.out.println("Inside delete custome implementaion");		
	}

}
