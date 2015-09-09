package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.entity.DeveloperCompanyEntity;
import com.servinglynk.hmis.warehouse.entity.DeveloperCompanyStatus;


 public class DeveloperCompanyDaoImpl extends QueryExecutorImpl implements DeveloperCompanyDao  {


public DeveloperCompanyEntity createDeveloperCompany(DeveloperCompanyEntity developerCompany){
	insert(developerCompany);
	return developerCompany;
}

public DeveloperCompanyStatus createDeveloperCompanyStatus(DeveloperCompanyStatus developerCompanyStatus){
	insert(developerCompanyStatus);
	return developerCompanyStatus;
}
	
	public DeveloperCompanyEntity updateDeveloperCompany(
			DeveloperCompanyEntity developerCompany) {
		update(developerCompany);
		return developerCompany;
	}


	public void deleteDeveloperCompany(
			DeveloperCompanyEntity developerCompany) {
		delete(developerCompany);
	}
	
	
	
	public DeveloperCompanyStatus updateCompanyStatus(
			DeveloperCompanyStatus developerCompanyStatus) {
		update(developerCompanyStatus);
		return developerCompanyStatus;
	}

	public DeveloperCompanyEntity findByExternalId(String externalId) {
		DetachedCriteria criteria= DetachedCriteria.forClass(DeveloperCompanyEntity.class);
		criteria.add(Restrictions.eq("externalId",externalId));
		List<DeveloperCompanyEntity> developerCompanies = (List<DeveloperCompanyEntity>) findByCriteria(criteria); 
		if(developerCompanies.size()>0) return developerCompanies.get(0);
		return null;
	}

	public List<DeveloperCompanyEntity> findAllDeveloperCompanies(
			String serviceStatus, String clientStatus, Integer iStartIndex,
			Integer iMaxItems) {
			DetachedCriteria criteria = DetachedCriteria.forClass(DeveloperCompanyEntity.class);
			criteria.createAlias("services","services");
			criteria.add(Restrictions.eq("services.status",serviceStatus));
			List<DeveloperCompanyEntity> developerCompanies = (List<DeveloperCompanyEntity>) findByCriteria(criteria);
			
			if(developerCompanies.size()>0) return developerCompanies;
			return null;
	}


	@Override
	public int findAllDeveloperCompaniesCount(String serviceStatus,
			String clientStatus) {
		
			DetachedCriteria criteria = DetachedCriteria.forClass(DeveloperCompanyEntity.class);
			criteria.createAlias("services","services");
			criteria.add(Restrictions.eq("services.status",serviceStatus));
		return (int) countRows(criteria);
	}

	

}
