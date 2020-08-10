package com.servinglynk.hmis.warehouse.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.ActionLinks;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentEntryLinks;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentExitLinks;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentLinks;
import com.servinglynk.hmis.warehouse.core.model.ExitActionLink;
import com.servinglynk.hmis.warehouse.core.model.ExitActionLinks;
import com.servinglynk.hmis.warehouse.model.v2020.Assessment;
import com.servinglynk.hmis.warehouse.model.v2020.Contact;
import com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement;
import com.servinglynk.hmis.warehouse.model.v2020.Disabilities;
import com.servinglynk.hmis.warehouse.model.v2020.Domesticviolence;
import com.servinglynk.hmis.warehouse.model.v2020.Education;
import com.servinglynk.hmis.warehouse.model.v2020.Employment;
import com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.model.v2020.Entryrhsp;
import com.servinglynk.hmis.warehouse.model.v2020.Entryrhy;
import com.servinglynk.hmis.warehouse.model.v2020.Entryssvf;
import com.servinglynk.hmis.warehouse.model.v2020.Event;
import com.servinglynk.hmis.warehouse.model.v2020.Exit;
import com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment;
import com.servinglynk.hmis.warehouse.model.v2020.Exitrhy;
import com.servinglynk.hmis.warehouse.model.v2020.HealthStatus;
import com.servinglynk.hmis.warehouse.model.v2020.Healthinsurance;
import com.servinglynk.hmis.warehouse.model.v2020.Incomeandsources;
import com.servinglynk.hmis.warehouse.model.v2020.Medicalassistance;
import com.servinglynk.hmis.warehouse.model.v2020.Moveindate;
import com.servinglynk.hmis.warehouse.model.v2020.Noncashbenefits;
import com.servinglynk.hmis.warehouse.model.v2020.Pathstatus;
import com.servinglynk.hmis.warehouse.model.v2020.ServiceFaReferral;
import com.servinglynk.hmis.warehouse.service.EnrollmentLinksService;

public class EnrollmentLinksServiceImpl extends ServiceBase implements EnrollmentLinksService{
	
	Map<String,Map<String, List<UUID>>> data = new HashMap<>();
		
	public void linksGroupByDate(LocalDateTime dateTime,String entity,UUID id) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

		String date = formatter.format(dateTime);
		
		if(data.get(date)!=null) {
			
			Map<String,List<UUID>> content = data.get(date);
			if(content.get(entity)!=null) {
				List<UUID> ids = content.get(entity);
					if(ids!=null) {
						ids.add(id); }
					else {
						ids = new ArrayList<>();
						ids.add(id);
						
					}
					content.put(entity, ids);
					data.put(date, content);
			}else {
				List<UUID> ids = new ArrayList<>();
				ids.add(id);
				content.put(entity, ids);
				data.put(date, content);
			}
			
		}else {
			List<UUID> ids = new ArrayList<>();
			ids.add(id);
			Map<String,List<UUID>> content = new HashMap<>();
			content.put(entity,ids);
			data.put(date, content);
		}
		
	}
	
	
	public void linksDateGroup(LocalDateTime dateTime, UUID id,Map<String,List<UUID>> data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

		String date = formatter.format(dateTime);
		if(data.get(date)!=null) {
			

			if(data.get(date)!=null) {
				List<UUID> ids = data.get(date);
					if(ids!=null) {
						ids.add(id); }
					else {
						ids = new ArrayList<>();
						ids.add(id);
						
					}
					data.put(date, ids);
			}else {
				List<UUID> ids = new ArrayList<>();
				ids.add(id);
				data.put(date, ids);
			}
			
		}else {
			List<UUID> ids = new ArrayList<>();
			ids.add(id);

			data.put(date, ids);
		}

	}
	
	public void groupByDataCollectionStage(LocalDateTime dateTime,String stageId, UUID id, Map<String,Map<String, List<UUID>>> data) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

		String date = formatter.format(dateTime);


		if(data.get(stageId)!=null) {
			
				if(data.get(stageId).get(date)!=null) {
					List<UUID> ids =  data.get(stageId).get(date);
					ids.add(id);
					data.get(stageId).put(date, ids);
					
				} else {
					
					List<UUID> ids = new ArrayList<>();
					ids.add(id);
					Map<String,List<UUID>>  dateGroup = data.get(stageId);
					
					dateGroup.put(date, ids);
					
					
					data.put(stageId, dateGroup);
					
				}
			
			
		} else {
			List<UUID> ids = new ArrayList<>();
			ids.add(id);
			Map<String,List<UUID>>  dateGroup = new HashMap<>();
			
			dateGroup.put(date, ids);
			
			data.put(stageId, dateGroup);
		}
		
		
	}
	
	
	public void groupbyStage(String stage,Map<String,List<UUID>> data,UUID id) {
		if(data!=null && data.get(stage)!=null) {
			List<UUID> links =  data.get(stage);
			links.add(id);
			data.put(stage, links);
		}else {
			List<UUID> links = new ArrayList<>();
			links.add(id);
			data.put(stage, links);
		}
	}
	
	public void groupByDateField(String dateField,String stage,Map<String,Map<String,List<UUID>>> data,UUID id) {
		if(data!=null && data.get(dateField)!=null) {
			Map<String, List<UUID>> stageLinks = data.get(dateField);
			this.groupbyStage(stage, stageLinks, id);
			data = new HashMap<>();
			data.put(dateField, stageLinks);
		}else {
		//	data = new HashMap<>();
			Map<String, List<UUID>> stageLinks = new HashMap<>();
			this.groupbyStage(stage, stageLinks, id);
			data.put(dateField, stageLinks);
		}
	}
	public void groupByDateField(String dateField,Map<String,List<UUID>> data,UUID id) {
		if(data!=null && data.get(dateField)!=null) {
			List<UUID> links =  data.get(dateField);
			links.add(id);
			data.put(dateField, links);
		}else {
			List<UUID> links = new ArrayList<>();
			links.add(id);
			data.put(dateField, links);
		}
	}

	public void groupByDate1(LocalDateTime dateTime,String dateField,String stage,Map<String,Map<String,Map<String,List<UUID>>>> data,UUID id) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

		String date = formatter.format(dateTime);
		if(data.get(date)!=null) {
			Map<String,Map<String,List<UUID>>> dateFieldGroup = data.get(date);
			this.groupByDateField(dateField, stage, dateFieldGroup, id);
			data.put(date, dateFieldGroup);
		}else {
		//	data = new HashMap<>();
			Map<String,Map<String,List<UUID>>> dateFieldGroup = new HashMap<>();
			this.groupByDateField(dateField, stage,dateFieldGroup, id);
			data.put(date, dateFieldGroup);
		}
		
	}
	
	public void groupByDate(LocalDateTime dateTime,String dateField,Map<String,Map<String,List<UUID>>> data,UUID id) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

		String date = formatter.format(dateTime);
		if(data.get(date)!=null) {
			Map<String,List<UUID>> dateFieldGroup = data.get(date);
			this.groupByDateField(dateField,  dateFieldGroup, id);
			data.put(date, dateFieldGroup);
		}else {
		//	data = new HashMap<>();
			Map<String,List<UUID>> dateFieldGroup = new HashMap<>();
			this.groupByDateField(dateField, dateFieldGroup, id);
			data.put(date, dateFieldGroup);
		}
		
	}
	
	public void groupByStage(LocalDateTime dateTime,String dateField,String stage,Map<String,Map<String,Map<String,List<UUID>>>> data,UUID id) {

		if(data.get(stage)!=null) {
			Map<String,Map<String,List<UUID>>> datesLinks = data.get(stage);
			this.groupByDate(dateTime, dateField,  datesLinks, id);
			data.put(stage, datesLinks);
		}else {
			Map<String,Map<String,List<UUID>>> dateGroup = new HashMap<>();
			this.groupByDate(dateTime, dateField,  dateGroup, id);
			data.put(stage, dateGroup);
		}
		
	}
	

	
	@Transactional
	public EnrollmentEntryLinks getEntryLinks(UUID clientId,UUID enrollmentId) {
		EnrollmentEntryLinks entryLinks = new EnrollmentEntryLinks();		
			entryLinks.setRhsps(this.getEntryRhspsLinks(clientId, enrollmentId));
			entryLinks.setEntryrhys(this.getEntryrhysLinks(clientId, enrollmentId));
			entryLinks.setEntryssvfs(this.getEntryssvfsLinks(clientId, enrollmentId));
			
			if(entryLinks.getRhsps().isEmpty()) entryLinks.setRhsps(null);
			if(entryLinks.getEntryrhys().isEmpty()) entryLinks.setEntryrhys(null);
			if(entryLinks.getEntryssvfs().isEmpty()) entryLinks.setEntryssvfs(null);
			return entryLinks;
	}
	
	@Transactional
	public EnrollmentLinks getEnrollmentLinks(UUID clientId,UUID enrollmentId) {
		EnrollmentLinks enrollmentLinks = new EnrollmentLinks();
		enrollmentLinks.setContacts(getContactsLinks(clientId, enrollmentId));
		enrollmentLinks.setDateOfEngagements(getDateOfEngagementsLinks(clientId, enrollmentId));
		enrollmentLinks.setDisabilities(getDisabilitiesLinks(clientId, enrollmentId));
		enrollmentLinks.setDomesticViolences(getDomesticViolencesLinks(clientId, enrollmentId));
		enrollmentLinks.setEducations(getEducationsLinks(clientId, enrollmentId));
		enrollmentLinks.setEmployments(getEmploymentsLinks(clientId, enrollmentId));
		enrollmentLinks.setEnrollmentcocs(getEnrollmentcocsLinks(clientId, enrollmentId));
		enrollmentLinks.setHealthinsurances(getHealthinsurancesLinks(clientId, enrollmentId));
		enrollmentLinks.setHealthStatuses(getHealthStatusesLinks(clientId, enrollmentId));
		enrollmentLinks.setIncomeandsources(getIncomeandsourcesLinks(clientId, enrollmentId));
		enrollmentLinks.setMedicalassistances(getMedicalassistancesLinks(clientId, enrollmentId));
		enrollmentLinks.setNoncashbenefits(getNoncashbenefitsLinks(clientId, enrollmentId));
		enrollmentLinks.setPathstatuses(getPathstatusesLinks(clientId, enrollmentId));
		enrollmentLinks.setResidentialMoveinDates(getResidentialMoveinDatesLinks(clientId, enrollmentId));
		enrollmentLinks.setServiceFaReferrals(getServiceFaReferralsLinks(clientId, enrollmentId));
		enrollmentLinks.setEvents(getEventsLinks(clientId, enrollmentId));
		enrollmentLinks.setAssessments(getAssessmentsLinks(clientId, enrollmentId));
		
		if(enrollmentLinks.getContacts().isEmpty())  enrollmentLinks.setContacts(null);
		if(enrollmentLinks.getDateOfEngagements().isEmpty()) enrollmentLinks.setDateOfEngagements(null);
		if(enrollmentLinks.getDisabilities().isEmpty()) enrollmentLinks.setDisabilities(null);
		if(enrollmentLinks.getDomesticViolences().isEmpty()) enrollmentLinks.setDomesticViolences(null);
		if(enrollmentLinks.getEducations().isEmpty()) enrollmentLinks.setEducations(null);
		if(enrollmentLinks.getEmployments().isEmpty()) enrollmentLinks.setEmployments(null);
		if(enrollmentLinks.getEnrollmentcocs().isEmpty()) enrollmentLinks.setEnrollmentcocs(null);
		if(enrollmentLinks.getHealthinsurances().isEmpty()) enrollmentLinks.setHealthinsurances(null);
		if(enrollmentLinks.getHealthStatuses().isEmpty()) enrollmentLinks.setHealthStatuses(null);
		if(enrollmentLinks.getIncomeandsources().isEmpty()) enrollmentLinks.setIncomeandsources(null);
		if(enrollmentLinks.getMedicalassistances().isEmpty()) enrollmentLinks.setMedicalassistances(null);
		if(enrollmentLinks.getNoncashbenefits().isEmpty()) enrollmentLinks.setNoncashbenefits(null);
		if(enrollmentLinks.getPathstatuses().isEmpty()) enrollmentLinks.setPathstatuses(null);
		if(enrollmentLinks.getResidentialMoveinDates().isEmpty()) enrollmentLinks.setResidentialMoveinDates(null);
		if(enrollmentLinks.getServiceFaReferrals().isEmpty()) enrollmentLinks.setServiceFaReferrals(null);
		if(enrollmentLinks.getEvents().isEmpty()) enrollmentLinks.setEvents(null);
		if(enrollmentLinks.getAssessments().isEmpty()) enrollmentLinks.setAssessments(null);
		return enrollmentLinks;
	}
	
	public Map<String,Map<String,List<ActionLinks>>> getEntryRhspsLinks(UUID clientId,UUID enrollmentId) {
		
		
		
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<Entryrhsp> data = daoFactory.getEntryrhspDao().getAllEnrollmentEntryrhsps(enrollmentId, null,null);
		for(Entryrhsp entity : data) {
			LocalDateTime date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}	
		}
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					 
					  for(UUID id : stageLinks.getValue()) {
						  
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/entryrhsps/"+id));		
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
		
		
		return dateLinks;
	}
	
	public Map<String,Map<String,List<ActionLinks>>> getEntryrhysLinks(UUID clientId,UUID enrollmentId) {
		
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<Entryrhy> data = daoFactory.getEntryrhyDao().getAllEnrollmentEntryrhys(enrollmentId, null,null);
		for(Entryrhy entity : data) {
			LocalDateTime date = entity.getInformationDate();
			if(date == null) date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";
			if(entity.getDataCollectionStage()!=null) collectionStage = entity.getDataCollectionStage().getValue();

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			}else if(entity.getInformationDate()!=null) {
				this.groupByStage(entity.getInformationDate(),"informationDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
		}
				
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>(new DateComparator());			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					// 
					  for(UUID id : stageLinks.getValue()) {
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/entryrhys/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
					
		return dateLinks;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,Map<String,List<ActionLinks>>> getEntryssvfsLinks(UUID clientId,UUID enrollmentId) {
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<Entryssvf> data = daoFactory.getEntryssvfDao().getAllEnrollmentEntryssvfs(enrollmentId, null,null);
		for(Entryssvf entity : data) {

			LocalDateTime date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";
			

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
		}
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
					// 

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					  for(UUID id : stageLinks.getValue()) {
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/entryssvfs/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
		
	return dateLinks;

	}
	
	public Map<String,Map<String,List<ActionLinks>>> getEnrollmentcocsLinks(UUID clientId,UUID enrollmentId) {
		
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<EnrollmentCoc> data = daoFactory.getEnrollmentCocDao().getAllEnrollmentEnrollmentCocs(enrollmentId, null,null);
		for(EnrollmentCoc entity : data) {
			LocalDateTime date = entity.getInformationDate();
			if(date == null) date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";
			if(entity.getDataCollectionStage()!=null) collectionStage = entity.getDataCollectionStage().getValue();

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			}else if(entity.getInformationDate()!=null) {
				this.groupByStage(entity.getInformationDate(),"informationDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
		}
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					 
					  for(UUID id : stageLinks.getValue()) {
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
		
	return dateLinks;
	}
	
	public Map<String,Map<String,List<ActionLinks>>> getEducationsLinks(UUID clientId,UUID enrollmentId) {
		
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<Education> data = daoFactory.getEducationDao().getAllEnrollmentEducations(enrollmentId, null,null);
		for(Education entity : data) {
			LocalDateTime date = entity.getInformationDate();
			if(date == null) date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";
			if(entity.getDataCollectionStage()!=null) collectionStage = entity.getDataCollectionStage().getValue();

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			}else if(entity.getInformationDate()!=null) {
				this.groupByStage(entity.getInformationDate(),"informationDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
		}
		
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>(new DateComparator());			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					  for(UUID id : stageLinks.getValue()) {
						  	actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/educations/"+id));
//							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/educations/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
					
	return dateLinks;


	}
	public Map<String,Map<String,List<ActionLinks>>> getContactsLinks(UUID clientId,UUID enrollmentId) {
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<Contact> data = daoFactory.getContactDao().getAllEnrollmentContacts(enrollmentId, null,null);
		for(Contact entity : data) {

			LocalDateTime date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
	}
		
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
					// 

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					  for(UUID id : stageLinks.getValue()) {
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/contacts/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
			
	return dateLinks;


	}
	public Map<String,Map<String,List<ActionLinks>>> getDateOfEngagementsLinks(UUID clientId,UUID enrollmentId) {
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<Dateofengagement> data = daoFactory.getDateofengagementDao().getAllEnrollmentDateofengagements(enrollmentId, null,null);
		for(Dateofengagement entity : data) {

			LocalDateTime date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
	}
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
					 

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					  for(UUID id : stageLinks.getValue()) {
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
		
	
	return dateLinks;


	}
	
	public Map<String,Map<String,List<ActionLinks>>> getDisabilitiesLinks(UUID clientId,UUID enrollmentId) {
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<Disabilities> data = daoFactory.getDisabilitiesDao().getAllEnrollmentDisabilitiess(enrollmentId, null,null);
		for(Disabilities entity : data) {
			LocalDateTime date = entity.getInformationDate();
			if(date == null) date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";
			if(entity.getDataCollectionStage()!=null) collectionStage = entity.getDataCollectionStage().getValue();

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			}else if(entity.getInformationDate()!=null) {
				this.groupByStage(entity.getInformationDate(),"informationDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
		}
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
					 

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					  for(UUID id : stageLinks.getValue()) {
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilities/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
	
	return dateLinks;
	}
	
	public Map<String,Map<String,List<ActionLinks>>> getDomesticViolencesLinks(UUID clientId,UUID enrollmentId) {
		
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<Domesticviolence> data = daoFactory.getDomesticviolenceDao().getAllEnrollmentDomesticViolences(enrollmentId, null,null);
		for(Domesticviolence entity : data) {
			LocalDateTime date = entity.getInformationDate();
			if(date == null) date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";
			if(entity.getDataCollectionStage()!=null) collectionStage = entity.getDataCollectionStage().getValue();

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			}else if(entity.getInformationDate()!=null) {
				this.groupByStage(entity.getInformationDate(),"informationDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
		}
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
					 

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					  for(UUID id : stageLinks.getValue()) {
						  
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
			
	return dateLinks;

	}
	public Map<String,Map<String,List<ActionLinks>>> getEmploymentsLinks(UUID clientId,UUID enrollmentId) {
		
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<Employment> data = daoFactory.getEmploymentDao().getAllEnrollmentEmployments(enrollmentId, null,null);
		for(Employment entity : data) {
			LocalDateTime date = entity.getInformationDate();
			if(date == null) date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";
			if(entity.getDataCollectionStage()!=null) collectionStage = entity.getDataCollectionStage().getValue();

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			}else if(entity.getInformationDate()!=null) {
				this.groupByStage(entity.getInformationDate(),"informationDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
		}
		
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					  for(UUID id : stageLinks.getValue()) {
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
					
	return dateLinks;

	}
	public Map<String,Map<String,List<ActionLinks>>> getHealthinsurancesLinks(UUID clientId,UUID enrollmentId) {
		
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<Healthinsurance> data = daoFactory.getHealthinsuranceDao().getAllEnrollmentHealthInsurances(enrollmentId, null,null);
		for(Healthinsurance entity : data) {
			LocalDateTime date = entity.getInformationDate();
			if(date == null) date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";
			if(entity.getDataCollectionStage()!=null) collectionStage = entity.getDataCollectionStage().getValue();

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			}else if(entity.getInformationDate()!=null) {
				this.groupByStage(entity.getInformationDate(),"informationDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
		}
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
					 

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					  for(UUID id : stageLinks.getValue()) {
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
		

	return dateLinks;
	}
	
	public Map<String,Map<String,List<ActionLinks>>> getHealthStatusesLinks(UUID clientId,UUID enrollmentId) {
			
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<HealthStatus> data = daoFactory.getHealthStatusDao().getAllEnrollmentHealthStatuses(enrollmentId, null,null);
		for(HealthStatus entity : data) {
			LocalDateTime date = entity.getInformationDate();
			if(date == null) date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";
			if(entity.getDataCollectionStage()!=null) collectionStage = entity.getDataCollectionStage().getValue();

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			}else if(entity.getInformationDate()!=null) {
				this.groupByStage(entity.getInformationDate(),"informationDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
		}
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
					 

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					  for(UUID id : stageLinks.getValue()) {
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuses/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
				
	return dateLinks;
			
	}
	
	public Map<String,Map<String,List<ActionLinks>>> getIncomeandsourcesLinks(UUID clientId,UUID enrollmentId) {
		
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<Incomeandsources> data = daoFactory.getIncomeandsourcesDao().getAllEnrollmentIncomeAndSources(enrollmentId, null,null);
		for(Incomeandsources entity : data) {
			LocalDateTime date = entity.getInformationDate();
			if(date == null) date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";
			if(entity.getDataCollectionStage()!=null) collectionStage = entity.getDataCollectionStage().getValue();

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			}else if(entity.getInformationDate()!=null) {
				this.groupByStage(entity.getInformationDate(),"informationDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
		}
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
					 

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					  for(UUID id : stageLinks.getValue()) {
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeandsources/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
			
	return dateLinks;
	}

	public Map<String,Map<String,List<ActionLinks>>> getMedicalassistancesLinks(UUID clientId,UUID enrollmentId) {
		
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<Medicalassistance> data = daoFactory.getMedicalassistanceDao().getAllEnrollmentMedicalassistances(enrollmentId, null,null);
		for(Medicalassistance entity : data) {
			LocalDateTime date = entity.getInformationDate();
			if(date == null) date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";
			if(entity.getDataCollectionStage()!=null) collectionStage = entity.getDataCollectionStage().getValue();

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			}else if(entity.getInformationDate()!=null) {
				this.groupByStage(entity.getInformationDate(),"informationDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
		}
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
					 

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					  for(UUID id : stageLinks.getValue()) {
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
			
	return dateLinks;
	}

	public Map<String,Map<String,List<ActionLinks>>> getNoncashbenefitsLinks(UUID clientId,UUID enrollmentId) {
		
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<Noncashbenefits> data = daoFactory.getNoncashbenefitsDao().getAllEnrollmentNoncashbenefits(enrollmentId, null,null);
		for(Noncashbenefits entity : data) {
			LocalDateTime date = entity.getInformationDate();
			if(date == null) date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";
			if(entity.getDataCollectionStage()!=null) collectionStage = entity.getDataCollectionStage().getValue();

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			}else if(entity.getInformationDate()!=null) {
				this.groupByStage(entity.getInformationDate(),"informationDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
		}
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
					 

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					  for(UUID id : stageLinks.getValue()) {
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefits/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
			
	return dateLinks;


	}
	public Map<String,Map<String,List<ActionLinks>>> getResidentialMoveinDatesLinks(UUID clientId,UUID enrollmentId) {
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<Moveindate> data = daoFactory.getResidentialmoveindateDao().getAllEnrollmentResidentialmoveindates(enrollmentId, null,null);
		for(Moveindate entity : data) {

			LocalDateTime date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";


			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
		}
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
					 

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					  for(UUID id : stageLinks.getValue()) {
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
			
	return dateLinks;
	}
	public Map<String,Map<String,List<ActionLinks>>> getPathstatusesLinks(UUID clientId,UUID enrollmentId) {
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<Pathstatus> data = daoFactory.getPathstatusDao().getAllEnrollmentPathstatuss(enrollmentId, null,null);
		for(Pathstatus entity : data) {

			LocalDateTime date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
		}
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
					 

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					  for(UUID id : stageLinks.getValue()) {
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/pathstatuses/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
		
	
	return dateLinks;
	}
	
	public Map<String,Map<String,List<ActionLinks>>> getServiceFaReferralsLinks(UUID clientId,UUID enrollmentId) {
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<ServiceFaReferral> data = daoFactory.getServiceFaReferralDao().getAllEnrollmentServiceFaReferrals(enrollmentId, null,null);
		for(ServiceFaReferral entity : data) {

			LocalDateTime date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
		}
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
					 

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					  for(UUID id : stageLinks.getValue()) {
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/servicefareferrals/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
		
	
	return dateLinks;
	}
	
	public Map<String,Map<String,List<ActionLinks>>> getEventsLinks(UUID clientId,UUID enrollmentId) {
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<Event> data = daoFactory.getEventDao().getAllEnrollmentEvents(enrollmentId, null,null);
		for(Event entity : data) {

			LocalDateTime date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";

				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
		}
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
					 

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					  for(UUID id : stageLinks.getValue()) {
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/events/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
		
	
	return dateLinks;
	}
	
	
	public Map<String,Map<String,List<ActionLinks>>> getAssessmentsLinks(UUID clientId,UUID enrollmentId) {
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<Assessment> data = daoFactory.getAssessmentDao().getAllEnrollmentAssessments(enrollmentId, null,null);
		for(Assessment entity : data) {

			LocalDateTime date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";

				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
		}
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
					 

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					  for(UUID id : stageLinks.getValue()) {
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/assessments/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
		
	
	return dateLinks;
	}
	
	@Transactional
	public Map<String,Map<String,List<ExitActionLinks>>> getExitLinks(UUID clientId,UUID enrollmentId){
		//List<ExitActionLink> actionLinks = new ArrayList<ExitActionLink>();
		
		List<Exit> data = daoFactory.getExitDao().getAllEnrollmentExits(enrollmentId, null, null);
		Map<String,Map<String,List<ExitActionLinks>>> dateLinks = new HashMap();
		
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		for(Exit entity : data) {
			String collectionStage = "unspecified_stage";

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
		}			
			for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
				Map<String,List<ExitActionLinks>> stagesLinkMap = new TreeMap<>();			

				for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

					Map<String,List<ExitActionLinks>> linksMap = new HashMap<>();

					List<ExitActionLinks> links = new ArrayList<>();
					for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
						ExitActionLinks actionLinks = new ExitActionLinks();
						actionLinks.setGroupBy(stageLinks.getKey());
						  for(UUID id : stageLinks.getValue()) {
							  ExitActionLink actionLink = new ExitActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+id); 
								EnrollmentExitLinks exitLinks = new EnrollmentExitLinks();
								actionLink.setExitHousingAssessments(this.getExitHousingAssessmentsLinks(clientId, enrollmentId, id));
								//actionLink.setExitPaths(this.getExitPathsLinks(clientId, enrollmentId, entity.getId()));
								actionLink.setExitrhys(this.getExitrhysLinks(clientId, enrollmentId, id));
								if(actionLink.getExitHousingAssessments().isEmpty())  actionLink.setExitHousingAssessments(null);
								if(actionLink.getExitPaths().isEmpty()) actionLink.setExitPaths(null);
								if(actionLink.getExitrhys().isEmpty()) actionLink.setExitrhys(null);
								if(actionLink.getHousingAssessmentDispositions().isEmpty()) actionLink.setHousingAssessmentDispositions(null);
								actionLinks.add(actionLink);
						  }
						  links.add(actionLinks);
						  linksMap.put(stageLinks.getKey(), links);
					}
					stagesLinkMap.put(dateInfoLinks.getKey(), links);
				}
				dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
			}

			
			
		return dateLinks;
	}
	
	@Transactional
	public Map<String,Map<String,List<ExitActionLinks>>> getExitLinks(UUID clientId,UUID enrollmentId,UUID exitId){
		//List<ExitActionLink> actionLinks = new ArrayList<ExitActionLink>();
		
		Exit entity = daoFactory.getExitDao().getExitById(exitId);
		Map<String,Map<String,List<ExitActionLinks>>> dateLinks = new HashMap();
		
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
	
			String collectionStage = "unspecified_stage";

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
				
			for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
				Map<String,List<ExitActionLinks>> stagesLinkMap = new TreeMap<>();			

				for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

					Map<String,List<ExitActionLinks>> linksMap = new HashMap<>();

					List<ExitActionLinks> links = new ArrayList<>();
					for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
						ExitActionLinks actionLinks = new ExitActionLinks();
						actionLinks.setGroupBy(stageLinks.getKey());
						  for(UUID id : stageLinks.getValue()) {
							  ExitActionLink actionLink = new ExitActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+id); 
								EnrollmentExitLinks exitLinks = new EnrollmentExitLinks();
								actionLink.setExitHousingAssessments(this.getExitHousingAssessmentsLinks(clientId, enrollmentId, id));
								//actionLink.setExitPaths(this.getExitPathsLinks(clientId, enrollmentId, entity.getId()));
								actionLink.setExitrhys(this.getExitrhysLinks(clientId, enrollmentId, id));
								if(actionLink.getExitHousingAssessments().isEmpty())  actionLink.setExitHousingAssessments(null);
								if(actionLink.getExitPaths().isEmpty()) actionLink.setExitPaths(null);
								if(actionLink.getExitrhys().isEmpty()) actionLink.setExitrhys(null);
								if(actionLink.getHousingAssessmentDispositions().isEmpty()) actionLink.setHousingAssessmentDispositions(null);
								actionLinks.add(actionLink);
						  }
						  links.add(actionLinks);
						  linksMap.put(stageLinks.getKey(), links);
					}
					stagesLinkMap.put(dateInfoLinks.getKey(), links);
				}
				dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
			}

			
			
		return dateLinks;
	}
	
	public Map<String,Map<String,List<ActionLinks>>> getExitHousingAssessmentsLinks(UUID clientId,UUID enrollmentId,UUID exitId) {
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<Exithousingassessment> data = daoFactory.getExithousingassessmentDao().getAllExitExithousingassessments(exitId, null,null);
		for(Exithousingassessment entity : data) {

			LocalDateTime date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
		}
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
					 

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					  for(UUID id : stageLinks.getValue()) {
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+exitId+"/exithousingassessments/"+id));	  
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
			
	return dateLinks;

	}
	
	//API not implemented
/*	List<ActionLink> getExitPathsLinks(UUID clientId,UUID enrollmentId,UUID exitId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<ServiceFaReferral> data = daoFactory.get.getAllEnrollmentServiceFaReferrals(enrollmentId, null,null);
		for(ServiceFaReferral entity : data) {
			actionLinks.addLink(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+exitId+"/serviceFaReferrals/"+entity.getId()));
		}
		return links;
	}*/
	
	public Map<String,Map<String,List<ActionLinks>>> getExitrhysLinks(UUID clientId,UUID enrollmentId,UUID exitId) {
		Map<String,Map<String,List<ActionLinks>>> dateLinks = new TreeMap<>();
		Map<String,Map<String,Map<String,List<UUID>>>> content = new TreeMap<>();
		List<Exitrhy> data = daoFactory.getExitrhyDao().getAllExitExitrhys(exitId, null,null);
		for(Exitrhy entity : data) {
			LocalDateTime date = entity.getDateUpdated();
			
			String collectionStage = "unspecified_stage";

			if(entity.getSubmissionDate()!=null) {
				this.groupByStage(entity.getSubmissionDate(),"submissionDate",collectionStage,content, entity.getId());
			} else {
				this.groupByStage(entity.getDateUpdated(),"dateUpdated",collectionStage,content, entity.getId());
			}
		}
		
		for(Map.Entry<String,Map<String,Map<String,List<UUID>>>> datesLinks : content.entrySet()) {
			Map<String,List<ActionLinks>> stagesLinkMap = new TreeMap<>();			
			for(Map.Entry<String,Map<String,List<UUID>>> dateInfoLinks : datesLinks.getValue().entrySet()) {

				Map<String,List<ActionLinks>> linksMap = new HashMap<>();
				List<ActionLinks> links = new ArrayList<>();
				for(Map.Entry<String,List<UUID>> stageLinks : dateInfoLinks.getValue().entrySet()) {
					 

					ActionLinks actionLinks = new ActionLinks();
					actionLinks.setGroupBy(stageLinks.getKey());
					  for(UUID id : stageLinks.getValue()) {
							actionLinks.addLink(new ActionLink(id+"", "/hmis-clientapi/rest/v2020/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+exitId+"/exitrhys/"+id));
					  }
					  links.add(actionLinks);
					  linksMap.put(stageLinks.getKey(), links);
				}
				stagesLinkMap.put(dateInfoLinks.getKey(), links);
			}
			dateLinks.put(datesLinks.getKey(), stagesLinkMap);			
		}
		
	
	return dateLinks;

	}

	class DateComparator implements Comparator<String> {
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");//or your pattern
        @Override
        public int compare(String o1, String o2) {
            try {
                return f.parse(o1).compareTo(f.parse(o2));
            } catch (ParseException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }
	
	
}