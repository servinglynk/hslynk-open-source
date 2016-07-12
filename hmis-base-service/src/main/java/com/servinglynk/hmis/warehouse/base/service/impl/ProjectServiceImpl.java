package com.servinglynk.hmis.warehouse.base.service.impl; 

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.base.service.ProjectService;
import com.servinglynk.hmis.warehouse.base.service.converter.ProjectConverter;
import com.servinglynk.hmis.warehouse.core.model.BaseProject;
import com.servinglynk.hmis.warehouse.core.model.BaseProjects;
import com.servinglynk.hmis.warehouse.model.base.OrganizationEntity;
import com.servinglynk.hmis.warehouse.model.base.Project;
import com.servinglynk.hmis.warehouse.service.exception.ProjectNotFoundException;


public class ProjectServiceImpl extends ServiceBase implements ProjectService  {

   @Transactional
   public BaseProject createProject(BaseProject baseProject,UUID organizationId,String caller){
	   OrganizationEntity pOrganization = daoFactory.getHmisOrganizationDao().getOrganizationById(organizationId);
	   
       Project pBaseProject = ProjectConverter.modelToEntity(baseProject, null);
       pBaseProject.setOrganizationid(pOrganization);
       pBaseProject.setDateCreated((new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       pBaseProject.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       pBaseProject.setId(baseProject.getProjectId());
       pBaseProject.setSchemaYear(baseProject.getSchemaYear());
       daoFactory.getBaseProjectDao().createProject(pBaseProject);
       baseProject.setProjectId(pBaseProject.getId());
       return baseProject;
   }

   @Transactional
   public BaseProject updateProject(BaseProject baseProject,String caller){
       Project pBaseProject = daoFactory.getBaseProjectDao().getProjectById(baseProject.getProjectId());
       if(pBaseProject==null) throw new ProjectNotFoundException();

       ProjectConverter.modelToEntity(baseProject, pBaseProject);
       pBaseProject.setDateUpdated((new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       pBaseProject.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getBaseProjectDao().updateProject(pBaseProject);
       baseProject.setProjectId(pBaseProject.getId());
       return baseProject;
   }

   @Transactional
   public BaseProject deleteProject(UUID baseProjectId,String caller){
      Project pBaseProject = daoFactory.getBaseProjectDao().getProjectById(baseProjectId);
       if(pBaseProject==null) throw new ProjectNotFoundException();

       daoFactory.getBaseProjectDao().deleteProject(pBaseProject);
       return new BaseProject();
   }

   @Transactional
   public BaseProject getProjectById(UUID baseProjectId){
       Project pBaseProject = daoFactory.getBaseProjectDao().getProjectById(baseProjectId);
       if(pBaseProject==null) throw new ProjectNotFoundException();

       return ProjectConverter.entityToModel( pBaseProject );
   }

   @Transactional
   public BaseProjects getAllProjects(UUID organizationId,Integer startIndex, Integer maxItems){
       BaseProjects baseProjects = new BaseProjects();
        List<Project> entities = daoFactory.getBaseProjectDao().getAllProjects(organizationId,startIndex,maxItems);
        for(Project entity : entities){
           baseProjects.addProject(ProjectConverter.entityToModel(entity));
        }
        long count = daoFactory.getBaseProjectDao().getProjectCount(organizationId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(baseProjects.getProjects().size());
        pagination.setTotal((int)count);
        baseProjects.setPagination(pagination);
        return baseProjects; 
   }


}
