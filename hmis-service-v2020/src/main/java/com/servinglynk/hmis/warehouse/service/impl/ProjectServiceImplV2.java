package com.servinglynk.hmis.warehouse.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.core.model.Projects;
import com.servinglynk.hmis.warehouse.service.ProjectServiceV2;
import com.servinglynk.hmis.warehouse.service.converter.ProjectConverter;
import com.servinglynk.hmis.warehouse.service.exception.ProjectNotFoundException;


public class ProjectServiceImplV2 extends ServiceBase implements ProjectServiceV2  {


   @Transactional
   public Project getProjectById(UUID projectId){
       com.servinglynk.hmis.warehouse.model.v2020.Project pProject = daoFactory.getProjectDao().getProjectById(projectId);
       if(pProject==null) throw new ProjectNotFoundException();

       return ProjectConverter.entityToModelV2( pProject );
   }

   @Transactional
   public Projects getAllProjects(String projectGroupCode,Integer startIndex, Integer maxItems){
       Projects projects = new Projects();
        List<com.servinglynk.hmis.warehouse.model.v2020.Project> entities = daoFactory.getProjectDao().getAllProjects(projectGroupCode,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2020.Project entity : entities){
           projects.addProject(ProjectConverter.entityToModelV2(entity));
        }
        long count = daoFactory.getProjectDao().getProjectCount(projectGroupCode);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(projects.getProjects().size());
        pagination.setTotal((int)count);
        projects.setPagination(pagination);
        return projects;
   }


}
