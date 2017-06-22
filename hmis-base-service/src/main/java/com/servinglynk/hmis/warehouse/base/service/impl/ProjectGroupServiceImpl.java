package com.servinglynk.hmis.warehouse.base.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.AwsS3Client;
import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.base.service.ProjectGroupService;
import com.servinglynk.hmis.warehouse.base.service.converter.ProjectConverter;
import com.servinglynk.hmis.warehouse.base.service.converter.ProjectGroupConverter;
import com.servinglynk.hmis.warehouse.core.model.BaseProject;
import com.servinglynk.hmis.warehouse.core.model.ProjectGroup;
import com.servinglynk.hmis.warehouse.core.model.ProjectGroups;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.base.ProjectProjectGroupMapEntity;
import com.servinglynk.hmis.warehouse.service.exception.ProjectGroupNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ProjectNotFoundException;

public class ProjectGroupServiceImpl extends ServiceBase implements ProjectGroupService {
	
	@Resource
	private Environment env;

	@Transactional
	public ProjectGroup createProjectGroup(ProjectGroup projectGroup, String caller){
		
		long pgCount = daoFactory.getProjectGroupDao().getProjectGroupCount();
		
		ProjectGroupEntity projectGroupEntity = ProjectGroupConverter.modelToEntity(projectGroup,null);
		projectGroupEntity.setProjectGroupCode(generateProjectGroupCode(projectGroup.getProjectGroupName(),pgCount));
		//projectGroupEntity.setInsertAt(new Date());
		//projectGroupEntity.setInsertBy(caller);
		projectGroupEntity.setBucketName(projectGroupEntity.getProjectGroupCode().toLowerCase()+"-"+UUID.randomUUID());
		daoFactory.getProjectGroupDao().createProjectGroup(projectGroupEntity);
		AwsS3Client client = new AwsS3Client();
		client.createBucket(projectGroupEntity.getBucketName(), "");
		for(BaseProject baseProject : projectGroup.getProjects()){
			ProjectProjectGroupMapEntity entity = new ProjectProjectGroupMapEntity();
			entity.setProjectGroupEntity(projectGroupEntity);
			com.servinglynk.hmis.warehouse.model.base.Project pProject = daoFactory.getBaseProjectDao().getProjectById(baseProject.getProjectId());
			if(pProject == null) throw new ProjectNotFoundException();
			entity.setProject(pProject);
			entity.setInsertAt(LocalDateTime.now());
			entity.setInsertBy(caller);
			daoFactory.getProjectGroupDao().addProjectToProjectGroup(entity);
		}
		projectGroup.setProjectGroupCode(projectGroupEntity.getProjectGroupCode());
		projectGroup.setProjectGroupId(projectGroupEntity.getId());
		return projectGroup;
	}
	
	

	   @Transactional
	   public ProjectGroups getAllProjectGroups(Integer startIndex, Integer maxItems){
	       ProjectGroups projects = new ProjectGroups();
	       ProjectGroup projectGroup = new ProjectGroup();
	        List<ProjectGroupEntity> entities = daoFactory.getProjectGroupDao().getAllProjectGroups(startIndex,maxItems);
	        for(ProjectGroupEntity entity : entities){
	        	projectGroup = ProjectGroupConverter.entityToModel(entity);
	        	
	        	for(ProjectProjectGroupMapEntity ppgme :  entity.getProjectGroupMapEntities()){
	    			projectGroup.addProject(ProjectConverter.entityToModel(ppgme.getProject()));
 		}
	        	projects.addProjectGroup(projectGroup);
	        }
	        long count = daoFactory.getProjectGroupDao().getProjectGroupCount();
	        SortedPagination pagination = new SortedPagination();
	 
	        pagination.setFrom(startIndex);
	        pagination.setReturned(projects.getProjectGroups().size());
	        pagination.setTotal((int)count);
	        projects.setPagination(pagination);
	        return projects; 
	   }
	   
	
	@Transactional
	public ProjectGroup updateProjectGroup(UUID projectgroupid ,ProjectGroup projectGroup, String caller){
		
		ProjectGroupEntity projectGroupEntity = daoFactory.getProjectGroupDao().getProjectGroupById(projectgroupid);
		if(projectGroupEntity == null) throw new ProjectGroupNotFoundException();		
		ProjectGroupConverter.modelToEntity(projectGroup,projectGroupEntity);
		//projectGroupEntity.setInsertAt(new Date());
		//projectGroupEntity.setInsertBy(caller);
		daoFactory.getProjectGroupDao().updateProjectGroup(projectGroupEntity);
		
		for(ProjectProjectGroupMapEntity entity :  projectGroupEntity.getProjectGroupMapEntities()){
			daoFactory.getProjectGroupDao().deleteProjectGroupMap(entity);
		}
		
		
		for(BaseProject baseProject : projectGroup.getProjects()){
			ProjectProjectGroupMapEntity entity = new ProjectProjectGroupMapEntity();
			entity.setProjectGroupEntity(projectGroupEntity);
			com.servinglynk.hmis.warehouse.model.base.Project pProject = daoFactory.getBaseProjectDao().getProjectById(baseProject.getProjectId());
			if(pProject == null) throw new ProjectNotFoundException();
			entity.setProject(pProject);
			entity.setInsertAt(LocalDateTime.now());
			entity.setInsertBy(caller);
			daoFactory.getProjectGroupDao().addProjectToProjectGroup(entity);
		}
		
		projectGroup.setProjectGroupId(projectGroupEntity.getId());
		return projectGroup;
	}
	
	
	@Transactional
	public ProjectGroup deleteProjectGroup(UUID projectGroupId){
		
		ProjectGroupEntity projectGroupEntity = daoFactory.getProjectGroupDao().getProjectGroupById(projectGroupId);
		if(projectGroupEntity == null) throw new ProjectGroupNotFoundException();	
		
		for(ProjectProjectGroupMapEntity entity :  projectGroupEntity.getProjectGroupMapEntities()){
			daoFactory.getProjectGroupDao().deleteProjectGroupMap(entity);
		}
		
		daoFactory.getProjectGroupDao().deleteProjectGroup(projectGroupEntity);
		
		return new ProjectGroup();
	}
	
	@Transactional
	public ProjectGroup getProjectGroupById(UUID projectgroupid){
		ProjectGroup projectGroup = new ProjectGroup();
		ProjectGroupEntity projectGroupEntity = daoFactory.getProjectGroupDao().getProjectGroupById(projectgroupid);
		if(projectGroupEntity == null) throw new ProjectGroupNotFoundException();	
		projectGroup = ProjectGroupConverter.entityToModel(projectGroupEntity);
		for(ProjectProjectGroupMapEntity entity :  projectGroupEntity.getProjectGroupMapEntities()){
			projectGroup.addProject(ProjectConverter.entityToModel(entity.getProject()));
		}
		
		return projectGroup;
	}
	
	public String generateProjectGroupCode(String projectName,long count){
		String projectCode="";
		count++;
		String[] splited = projectName.split("\\s+");
		if(splited.length >1){
			projectCode = splited[0].substring(0,1) + splited[1].substring(0, 1);
		}else{
			projectCode = projectName.substring(0, 2);
		}

		if(count<=999){
			projectCode += String.format("%04d", count);
		}else{
			projectCode += count;
		}
		return projectCode.toUpperCase();
	}
}
