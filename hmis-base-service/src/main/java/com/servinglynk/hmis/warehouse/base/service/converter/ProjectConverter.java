package com.servinglynk.hmis.warehouse.base.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.BaseProject;
import com.servinglynk.hmis.warehouse.enums.ProjectContinuumprojectEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectProjecttypeEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTargetpopulationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTrackingmethodEnum;
import com.servinglynk.hmis.warehouse.model.base.Project;
public class ProjectConverter  {

   public static Project modelToEntity (BaseProject model ,Project entity) {
       if(entity==null) entity = new Project();
       if(model.getProjectName()!=null)
       entity.setProjectname(model.getProjectName());
       if(model.getContinuumProject()!=null)
       entity.setContinuumproject(ProjectContinuumprojectEnum.lookupEnum(model.getContinuumProject().toString()));
       if(model.getProjectCommonName()!=null)
       entity.setProjectcommonname(model.getProjectCommonName());
       if(model.getProjectType()!=null)
       entity.setProjecttype(ProjectProjecttypeEnum.lookupEnum(model.getProjectType().toString()));
       if(model.getTrackingMethod()!=null)
       entity.setTrackingmethod(ProjectTrackingmethodEnum.lookupEnum(model.getTrackingMethod().toString()));
       if(model.getTargetPopulation()!=null)
       entity.setTargetpopulation(ProjectTargetpopulationEnum.lookupEnum(model.getTargetPopulation().toString()));
       return entity;    
   }


   public static BaseProject entityToModel (Project entity) {
       BaseProject project= new BaseProject();
       if(entity.getContinuumproject()!=null)
       project.setContinuumProject(Integer.parseInt(entity.getContinuumproject().getValue()));
       if(entity.getProjectcommonname()!=null)
       project.setProjectCommonName(entity.getProjectcommonname());
       if(entity.getId()!=null)
       project.setProjectId(entity.getId());
       if(entity.getProjectname()!=null)
       project.setProjectName(entity.getProjectname());
       if(entity.getProjecttype()!=null)
       project.setProjectType(Integer.parseInt(entity.getProjecttype().getValue()));       
       if(entity.getTargetpopulation()!=null)
       project.setTargetPopulation(Integer.parseInt(entity.getTargetpopulation().getValue()));
       
       if(entity.getTrackingmethod()!=null)
       project.setTrackingMethod(Integer.parseInt(entity.getTrackingmethod().getValue()));
       
       if(entity.getSchemaYear()!=null)
    	   	project.setLink("/hmis-clientapi/rest/v"+entity.getSchemaYear()+"/projects/"+entity.getId());
       
       return project;
   }


}
