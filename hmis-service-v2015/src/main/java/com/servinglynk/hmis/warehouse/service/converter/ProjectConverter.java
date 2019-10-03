package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.GlobalProject;
import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.enums.ProjectContinuumprojectEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectProjecttypeEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTargetpopulationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTrackingmethodEnum;
public class ProjectConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2015.Project modelToEntity (Project model ,com.servinglynk.hmis.warehouse.model.v2015.Project entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2015.Project();
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
       entity.setSource("2015");
       if(model.getSourceSystemId()!=null)
    	   entity.setSourceSystemId(model.getSourceSystemId());
       return entity;    
   }


   public static Project entityToModel (com.servinglynk.hmis.warehouse.model.v2015.Project entity) {
       Project project= new Project();
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
       
       project.setProjectGroup(entity.getProjectGroupCode());
       project.setSourceSystemId(entity.getSourceSystemId());
       copyBeanProperties(entity, project);
       return project;
   }
   
   public static Project entityToModelV2 (com.servinglynk.hmis.warehouse.model.v2015.Project entity) {
       Project project= new Project();
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
       
       project.setProjectGroup(entity.getProjectGroupCode());
       project.setSource(entity.getSource());
       project.setSourceSystemId(entity.getSourceSystemId());
       copyBeanProperties(entity, project);
       if(entity.getParentId() ==null ) {
    	   project.addLink(new ActionLink("history","/projects/"+entity.getId()+"/history"));
       }
       return project;
   }
   
   public static GlobalProject modelToGlobalProject(Project project) {
	   GlobalProject globalProject = new GlobalProject();
	   globalProject.setId(project.getProjectId());
	   globalProject.setProjectCommonName(project.getProjectCommonName());
	   globalProject.setProjectName(project.getProjectName());
	   globalProject.setSourceSystemId(project.getSourceSystemId());
	   return globalProject;
   }



}
