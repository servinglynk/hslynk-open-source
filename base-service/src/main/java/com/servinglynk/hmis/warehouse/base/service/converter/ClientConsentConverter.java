package com.servinglynk.hmis.warehouse.base.service.converter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.hmis.warehouse.core.model.ClientConsent;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentEntityModel;
import com.servinglynk.hmis.warehouse.core.model.GlobalProject;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjectMap;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjectsMap;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentEntitiesEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentProjectMapEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalProjectEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalProjectMapEntity;

public class ClientConsentConverter {

	public static ClientConsentEntity modelToEntity(ClientConsent model,ClientConsentEntity entity){
		if(entity==null) entity = new ClientConsentEntity();
		entity.setClientId(model.getClientId());
		entity.setStartTime(LocalDateTime.ofInstant(model.getStartTime().toInstant(), ZoneId.systemDefault()));
		entity.setEndTime(LocalDateTime.ofInstant(model.getEndTime().toInstant(), ZoneId.systemDefault()));
		entity.setConsentGroupId(model.getConsentGroupId());
	//	entity.setConsentDocument(model.getConsentDocumentLink());
		return entity;
	}

	public static ClientConsent entityToModel(ClientConsentEntity entity){
		ClientConsent model = new ClientConsent();
		model.setClientId(entity.getClientId());
		model.setStartTime(Date.from(entity.getStartTime().atZone(ZoneId.systemDefault()).toInstant()));
		model.setEndTime(Date.from(entity.getEndTime().atZone(ZoneId.systemDefault()).toInstant()));
	//	model.setConsentDocumentLink(entity.getConsentDocument());
		model.setStatus(entity.getStatus());
		model.setConsentGroupId(entity.getConsentGroupId());
		
		List<GlobalProject> globalProjects = new ArrayList<GlobalProject>();
		List<ClientConsentProjectMapEntity> consentProjects = entity.getConsentProjects();
		if(CollectionUtils.isNotEmpty(consentProjects)) {
			Iterator<ClientConsentProjectMapEntity> iterator = consentProjects.iterator();
			while(iterator.hasNext()) {
				ClientConsentProjectMapEntity next = iterator.next();
				GlobalProject globalProject = new GlobalProject();
				GlobalProjectEntity globalProject2 = next.getGlobalProject();
				if(globalProject2 != null) {
					globalProject.setId(globalProject2.getId());
					globalProject.setDescription(globalProject2.getDescription());
					globalProject.setDateCreated(globalProject2.getDateCreated());
					globalProject.setDateUpdated(globalProject2.getDateUpdated());
					globalProject.setProjectCommonName(globalProject2.getProjectCommonName());
					globalProject.setProjectName(globalProject2.getProjectName());
					globalProject.setSourceSystemId(globalProject2.getSourceSystemId());
					List<GlobalProjectMapEntity> projectsMap = globalProject2.getProjects();
					if(CollectionUtils.isNotEmpty(projectsMap)) {
						GlobalProjectsMap map = new GlobalProjectsMap();
						List<GlobalProjectMap> projectModel = new ArrayList<GlobalProjectMap>();
						for(GlobalProjectMapEntity projectEntity : projectsMap) {
							GlobalProjectMap project = new GlobalProjectMap();
							project.setProjectId(projectEntity.getId());
							project.setSource(projectEntity.getSource());
							projectModel.add(project);
							//project.setLink(link);
						}
						map.setGlobalProjectMaps(projectModel);
						globalProject.setProjects(map);
					}
					
				}
				
			}
			
		}
		model.setGlobalProjects(globalProjects);
		model.setId(entity.getId());
		
		return model;
	}

	
	
	public static ClientConsentEntitiesEntity modelToEntity(ClientConsentEntityModel model,ClientConsentEntitiesEntity entity){
		if(entity ==null) entity = new ClientConsentEntitiesEntity();		
		entity.setConsentEntityId(model.getConsentEntityId());
		entity.setConsentTypeId(model.getConsentTypeId());
		
		return entity;
	}
	
	
	public static ClientConsentEntityModel entityToModel(ClientConsentEntitiesEntity entity){
		ClientConsentEntityModel model = new 		ClientConsentEntityModel();
		model.setId(entity.getId());
		model.setConsentEntityId(entity.getConsentEntityId());
		model.setConsentTypeId(entity.getConsentTypeId());
		
		return model;
	}
	
}