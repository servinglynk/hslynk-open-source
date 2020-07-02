package com.servinglynk.hmis.warehouse.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.servinglynk.hmis.warehouse.model.base.Client;

public interface ClientCustomRepository {	
	List<Client> findByNameAndProjectgroupcode(String freeText, String projectGroupCode, Sort sort);
	
	Page<Client> findByDedupclientidOrIdAndProjectgroupcode(String freeText, String freeText2, String string,
			Pageable page);
	
	
	List<Client> findByDobBetweenAndProjectgroupcode(long startTime, long endTime, String projectgroupcode, Sort sort);

}
