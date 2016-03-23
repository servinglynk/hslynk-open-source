package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.enums.ProjectContinuumprojectEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectProjecttypeEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectResidentialaffiliationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTargetpopulationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTrackingmethodEnum;
public class ProjectConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Project modelToEntity (Project model ,com.servinglynk.hmis.warehouse.model.v2014.Project entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Project();
       
       entity.setProjectname(model.getProjectName());
       entity.setContinuumproject(ProjectContinuumprojectEnum.lookupEnum(model.getContinuumProject().toString()));
       entity.setProjectcommonname(model.getProjectCommonName());
       entity.setProjecttype(ProjectProjecttypeEnum.lookupEnum(model.getProjectType().toString()));
       entity.setResidentialaffiliation(ProjectResidentialaffiliationEnum.lookupEnum(model.getResidentialAffiliation().toString()));
       entity.setTrackingmethod(ProjectTrackingmethodEnum.lookupEnum(model.getTrackingMethod().toString()));
       entity.setTargetpopulation(ProjectTargetpopulationEnum.lookupEnum(model.getTargetPopulation().toString()));
       return entity;    
   }


   public static Project entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Project entity) {
       Project project= new Project();
       if(entity.getContinuumproject()!=null)
       project.setContinuumProject(Integer.parseInt(entity.getContinuumproject().getValue()));
       project.setProjectCommonName(entity.getProjectcommonname());
       project.setProjectId(entity.getId());
       project.setProjectName(entity.getProjectname());
       if(entity.getProjecttype()!=null)
       project.setProjectType(Integer.parseInt(entity.getProjecttype().getValue()));
       if(entity.getResidentialaffiliation()!=null)
       project.setResidentialAffiliation(Integer.parseInt(entity.getResidentialaffiliation().getValue()));
       
       if(entity.getTargetpopulation()!=null)
       project.setTargetPopulation(Integer.parseInt(entity.getTargetpopulation().getValue()));
       
       if(entity.getTrackingmethod()!=null)
       project.setTrackingMethod(Integer.parseInt(entity.getTrackingmethod().getValue()));
       
       copyBeanProperties(entity, project);
       return project;
   }


}
