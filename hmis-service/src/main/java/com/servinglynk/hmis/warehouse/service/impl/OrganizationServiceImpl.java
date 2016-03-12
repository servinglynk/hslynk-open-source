package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.core.model.Organization;
import com.servinglynk.hmis.warehouse.service.OrganizationService;
import com.servinglynk.hmis.warehouse.service.converter.OrganizationConverter;
import com.servinglynk.hmis.warehouse.core.model.Organizations;
import com.servinglynk.hmis.warehouse.service.exception.OrganizationNotFoundException;
import com.servinglynk.hmis.warehouse.SortedPagination;


public class OrganizationServiceImpl extends ServiceBase implements OrganizationService  {

   @Transactional
   public Organization createOrganization(Organization organization,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Organization pOrganization = OrganizationConverter.modelToEntity(organization, null);
       pOrganization.setDateCreated((new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
  //     pOrganization.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getOrganizationDao().createOrganization(pOrganization);
       organization.setOrganizationId(pOrganization.getId());
       return organization;
   }

   @Transactional
   public Organization updateOrganization(Organization organization,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Organization pOrganization = daoFactory.getOrganizationDao().getOrganizationById(organization.getOrganizationId());
       if(pOrganization==null) throw new OrganizationNotFoundException();

       OrganizationConverter.modelToEntity(organization, pOrganization);
       daoFactory.getOrganizationDao().updateOrganization(pOrganization);
       organization.setOrganizationId(pOrganization.getId());
       return organization;
   }

   @Transactional
   public Organization deleteOrganization(UUID organizationId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Organization pOrganization = daoFactory.getOrganizationDao().getOrganizationById(organizationId);
       if(pOrganization==null) throw new OrganizationNotFoundException();

       daoFactory.getOrganizationDao().deleteOrganization(pOrganization);
       return new Organization();
   }

   @Transactional
   public Organization getOrganizationById(UUID organizationId){
       com.servinglynk.hmis.warehouse.model.v2014.Organization pOrganization = daoFactory.getOrganizationDao().getOrganizationById(organizationId);
       if(pOrganization==null) throw new OrganizationNotFoundException();

       return OrganizationConverter.entityToModel( pOrganization );
   }

   @Transactional
   public Organizations getAllOrganizations(Integer startIndex, Integer maxItems){
       Organizations organizations = new Organizations();
        List<com.servinglynk.hmis.warehouse.model.v2014.Organization> entities = daoFactory.getOrganizationDao().getAllOrganizations(startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2014.Organization entity : entities){
           organizations.addOrganization(OrganizationConverter.entityToModel(entity));
        }
        long count = daoFactory.getOrganizationDao().getOrganizationCount();
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(organizations.getOrganizations().size());
        pagination.setTotal((int)count);
        organizations.setPagination(pagination);
        return organizations; 
   }


}
