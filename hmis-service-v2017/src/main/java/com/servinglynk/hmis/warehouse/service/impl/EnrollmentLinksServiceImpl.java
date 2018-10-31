package com.servinglynk.hmis.warehouse.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentEntryLinks;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentExitLinks;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentLinks;
import com.servinglynk.hmis.warehouse.core.model.ExitActionLink;
import com.servinglynk.hmis.warehouse.model.v2017.Contact;
import com.servinglynk.hmis.warehouse.model.v2017.Dateofengagement;
import com.servinglynk.hmis.warehouse.model.v2017.Disabilities;
import com.servinglynk.hmis.warehouse.model.v2017.Domesticviolence;
import com.servinglynk.hmis.warehouse.model.v2017.Education;
import com.servinglynk.hmis.warehouse.model.v2017.Employment;
import com.servinglynk.hmis.warehouse.model.v2017.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.model.v2017.Entryrhsp;
import com.servinglynk.hmis.warehouse.model.v2017.Entryrhy;
import com.servinglynk.hmis.warehouse.model.v2017.Entryssvf;
import com.servinglynk.hmis.warehouse.model.v2017.Exit;
import com.servinglynk.hmis.warehouse.model.v2017.Exithousingassessment;
import com.servinglynk.hmis.warehouse.model.v2017.Exitrhy;
import com.servinglynk.hmis.warehouse.model.v2017.HealthStatus;
import com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance;
import com.servinglynk.hmis.warehouse.model.v2017.Housingassessmentdisposition;
import com.servinglynk.hmis.warehouse.model.v2017.Incomeandsources;
import com.servinglynk.hmis.warehouse.model.v2017.Medicalassistance;
import com.servinglynk.hmis.warehouse.model.v2017.Moveindate;
import com.servinglynk.hmis.warehouse.model.v2017.Noncashbenefits;
import com.servinglynk.hmis.warehouse.model.v2017.Pathstatus;
import com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral;
import com.servinglynk.hmis.warehouse.service.EnrollmentLinksService;

public class EnrollmentLinksServiceImpl extends ServiceBase implements EnrollmentLinksService{
	
	Map<String,Map<String, List<UUID>>> data = new HashMap<>();
		
	public void linksGroupByDate(LocalDateTime dateTime,String entity,UUID id) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");

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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");

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
		
		return enrollmentLinks;
	}
	
	public Map<String,List<ActionLink>> getEntryRhspsLinks(UUID clientId,UUID enrollmentId) {
		
		
		
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<Entryrhsp> data = daoFactory.getEntryrhspDao().getAllEnrollmentEntryrhsps(enrollmentId, null,null);
		for(Entryrhsp entity : data) {
				this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
		}
		for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
			List<ActionLink> links = new ArrayList<>();
			  for(UUID id : entry.getValue()) {
					links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/entryrhsps/"+id));		  
			  }
			  dateLinks.put(entry.getKey(),links);
		}
		
		return dateLinks;
	}
	
	public Map<String,List<ActionLink>> getEntryrhysLinks(UUID clientId,UUID enrollmentId) {
		
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());

		List<Entryrhy> data = daoFactory.getEntryrhyDao().getAllEnrollmentEntryrhys(enrollmentId, null,null);
		for(Entryrhy entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
				links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/entryrhys/"+id));		  
		  }
		  dateLinks.put(entry.getKey(),links);
	}	
			
		return dateLinks;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,List<ActionLink>> getEntryssvfsLinks(UUID clientId,UUID enrollmentId) {
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<Entryssvf> data = daoFactory.getEntryssvfDao().getAllEnrollmentEntryssvfs(enrollmentId, null,null);
		for(Entryssvf entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
				links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/entryssvfs/"+id));
		  }
		  dateLinks.put(entry.getKey(),links);
	}
	
	return dateLinks;

	}
	
	public Map<String,List<ActionLink>> getEnrollmentcocsLinks(UUID clientId,UUID enrollmentId) {
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<EnrollmentCoc> data = daoFactory.getEnrollmentCocDao().getAllEnrollmentEnrollmentCocs(enrollmentId, null,null);
		for(EnrollmentCoc entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
				links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs/"+id));
		  }
		  dateLinks.put(entry.getKey(),links);
	}
	
	return dateLinks;


	}
	public Map<String,List<ActionLink>> getEducationsLinks(UUID clientId,UUID enrollmentId) {
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<Education> data = daoFactory.getEducationDao().getAllEnrollmentEducations(enrollmentId, null,null);
		for(Education entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
				links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/educations/"+id));
		  }
		  dateLinks.put(entry.getKey(),links);
	}
	
	return dateLinks;


	}
	public Map<String,List<ActionLink>> getContactsLinks(UUID clientId,UUID enrollmentId) {
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<Contact> data = daoFactory.getContactDao().getAllEnrollmentContacts(enrollmentId, null,null);
		for(Contact entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
				links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/contacts/"+id));
		  }
		  dateLinks.put(entry.getKey(),links);
	}
	
	return dateLinks;


	}
	public Map<String,List<ActionLink>> getDateOfEngagementsLinks(UUID clientId,UUID enrollmentId) {
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<Dateofengagement> data = daoFactory.getDateofengagementDao().getAllEnrollmentDateofengagements(enrollmentId, null,null);
		for(Dateofengagement entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
				links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements/"+id));
		  }
		  dateLinks.put(entry.getKey(),links);
	}
	
	return dateLinks;


	}
	public Map<String,List<ActionLink>> getDisabilitiesLinks(UUID clientId,UUID enrollmentId) {
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<Disabilities> data = daoFactory.getDisabilitiesDao().getAllEnrollmentDisabilitiess(enrollmentId, null,null);
		for(Disabilities entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
				links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilities/"+id));
		  }
		  dateLinks.put(entry.getKey(),links);
	}
	
	return dateLinks;

	}
	public Map<String,List<ActionLink>> getDomesticViolencesLinks(UUID clientId,UUID enrollmentId) {
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<Domesticviolence> data = daoFactory.getDomesticviolenceDao().getAllEnrollmentDomesticViolences(enrollmentId, null,null);
		for(Domesticviolence entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
				links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences/"+id));
		  }
		  dateLinks.put(entry.getKey(),links);
	}
	
	return dateLinks;

	}
	public Map<String,List<ActionLink>> getEmploymentsLinks(UUID clientId,UUID enrollmentId) {
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<Employment> data = daoFactory.getEmploymentDao().getAllEnrollmentEmployments(enrollmentId, null,null);
		for(Employment entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
				links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+id));
		  }
		  dateLinks.put(entry.getKey(),links);
	}
	
	return dateLinks;

	}
	public Map<String,List<ActionLink>> getHealthinsurancesLinks(UUID clientId,UUID enrollmentId) {
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<Healthinsurance> data = daoFactory.getHealthinsuranceDao().getAllEnrollmentHealthInsurances(enrollmentId, null,null);
		for(Healthinsurance entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
				links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances/"+id));
		  }
		  dateLinks.put(entry.getKey(),links);
	}
	
	return dateLinks;
	}
	public Map<String,List<ActionLink>> getHealthStatusesLinks(UUID clientId,UUID enrollmentId) {
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<HealthStatus> data = daoFactory.getHealthStatusDao().getAllEnrollmentHealthStatuses(enrollmentId, null,null);
		for(HealthStatus entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
			  links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuses/"+id));		  
		  }
		  dateLinks.put(entry.getKey(),links);
	}
	
	return dateLinks;
			
	}
	public Map<String,List<ActionLink>> getIncomeandsourcesLinks(UUID clientId,UUID enrollmentId) {
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<Incomeandsources> data = daoFactory.getIncomeandsourcesDao().getAllEnrollmentIncomeAndSources(enrollmentId, null,null);
		for(Incomeandsources entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
				links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeandsources/"+id));
		  }
		  dateLinks.put(entry.getKey(),links);
	}
	
	return dateLinks;
	}
	public Map<String,List<ActionLink>> getMedicalassistancesLinks(UUID clientId,UUID enrollmentId) {
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<Medicalassistance> data = daoFactory.getMedicalassistanceDao().getAllEnrollmentMedicalassistances(enrollmentId, null,null);
		for(Medicalassistance entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
				links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances/"+id));
		  }
		  dateLinks.put(entry.getKey(),links);
	}
	
	return dateLinks;
	}
	public Map<String,List<ActionLink>> getNoncashbenefitsLinks(UUID clientId,UUID enrollmentId) {
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<Noncashbenefits> data = daoFactory.getNoncashbenefitsDao().getAllEnrollmentNoncashbenefits(enrollmentId, null,null);
		for(Noncashbenefits entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
				links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefits/"+id));
		  }
		  dateLinks.put(entry.getKey(),links);
	}
	
	return dateLinks;


	}
	public Map<String,List<ActionLink>> getResidentialMoveinDatesLinks(UUID clientId,UUID enrollmentId) {
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<Moveindate> data = daoFactory.getResidentialmoveindateDao().getAllEnrollmentResidentialmoveindates(enrollmentId, null,null);
		for(Moveindate entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
				links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+id));
		  }
		  dateLinks.put(entry.getKey(),links);
	}
	
	return dateLinks;
	}
	public Map<String,List<ActionLink>> getPathstatusesLinks(UUID clientId,UUID enrollmentId) {
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<Pathstatus> data = daoFactory.getPathstatusDao().getAllEnrollmentPathstatuss(enrollmentId, null,null);
		for(Pathstatus entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
				links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/pathstatuses/"+id));
		  }
		  dateLinks.put(entry.getKey(),links);
	}
	
	return dateLinks;
	}
	public Map<String,List<ActionLink>> getServiceFaReferralsLinks(UUID clientId,UUID enrollmentId) {
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<ServiceFaReferral> data = daoFactory.getServiceFaReferralDao().getAllEnrollmentServiceFaReferrals(enrollmentId, null,null);
		for(ServiceFaReferral entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
				links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/servicefareferrals/"+id));  
		  }
		  dateLinks.put(entry.getKey(),links);
	}
	
	return dateLinks;
	}
	
	@Transactional
	public Map<String,List<ExitActionLink>> getExitLinks(UUID clientId,UUID enrollmentId){
		List<ExitActionLink> actionLinks = new ArrayList<ExitActionLink>();
		
		List<Exit> data = daoFactory.getExitDao().getAllEnrollmentExits(enrollmentId, null, null);
		Map<String,List<ExitActionLink>> dateLinks = new HashMap<String,List<ExitActionLink>>();
		
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		for(Exit entity : data) {
				this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
		}


			for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
				List<ExitActionLink> links = new ArrayList<>();
				  for(UUID id : entry.getValue()) {
					  ExitActionLink actionLink = new ExitActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+id); 
						EnrollmentExitLinks exitLinks = new EnrollmentExitLinks();
						actionLink.setExitHousingAssessments(this.getExitHousingAssessmentsLinks(clientId, enrollmentId, id));
						//actionLink.setExitPaths(this.getExitPathsLinks(clientId, enrollmentId, entity.getId()));
						actionLink.setExitrhys(this.getExitrhysLinks(clientId, enrollmentId, id));
						actionLink.setHousingAssessmentDispositions(this.getHousingAssessmentDispositionsLinks(clientId, enrollmentId, id));
						
						if(actionLink.getExitHousingAssessments().isEmpty())  actionLink.setExitHousingAssessments(null);
						if(actionLink.getExitPaths().isEmpty()) actionLink.setExitPaths(null);
						if(actionLink.getExitrhys().isEmpty()) actionLink.setExitrhys(null);
						if(actionLink.getHousingAssessmentDispositions().isEmpty()) actionLink.setHousingAssessmentDispositions(null);
						links.add(actionLink);
						
				  }
				  dateLinks.put(entry.getKey(),links);
				

			}
			
			
		return dateLinks;
	}
	
	Map<String,List<ActionLink>> getExitHousingAssessmentsLinks(UUID clientId,UUID enrollmentId,UUID exitId) {
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<Exithousingassessment> data = daoFactory.getExithousingassessmentDao().getAllExitExithousingassessments(exitId, null,null);
		for(Exithousingassessment entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
				links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+exitId+"/exithousingassessments/"+id));	  
		  }
		  dateLinks.put(entry.getKey(),links);
	}
	
	return dateLinks;

	}
	
	Map<String,List<ActionLink>> getHousingAssessmentDispositionsLinks(UUID clientId,UUID enrollmentId,UUID exitId) {
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<Housingassessmentdisposition> data = daoFactory.getHousingassessmentdispositionDao().getAllExitHousingAssessmentDispositions(exitId, null,null);
		for(Housingassessmentdisposition entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
				links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+exitId+"/housingassessmentdispositions/"+id));	  
		  }
		  dateLinks.put(entry.getKey(),links);
	}
	
	return dateLinks;
	}
	
	//API not implemented
/*	List<ActionLink> getExitPathsLinks(UUID clientId,UUID enrollmentId,UUID exitId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<ServiceFaReferral> data = daoFactory.get.getAllEnrollmentServiceFaReferrals(enrollmentId, null,null);
		for(ServiceFaReferral entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+exitId+"/serviceFaReferrals/"+entity.getId()));
		}
		return links;
	}*/
	
	Map<String,List<ActionLink>> getExitrhysLinks(UUID clientId,UUID enrollmentId,UUID exitId) {
		Map<String,List<ActionLink>> dateLinks = new TreeMap<String,List<ActionLink>>(new DateComparator());
		Map<String,List<UUID>> content = new TreeMap<>(new DateComparator());
		List<Exitrhy> data = daoFactory.getExitrhyDao().getAllExitExitrhys(exitId, null,null);
		for(Exitrhy entity : data) {
			this.linksDateGroup(entity.getDateCreated(), entity.getId(),content);		
	}
	for(Map.Entry<String, List<UUID>> entry : content.entrySet()) {
		List<ActionLink> links = new ArrayList<>();
		  for(UUID id : entry.getValue()) {
				links.add(new ActionLink(id+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+exitId+"/exitrhys/"+id));
		  }
		  dateLinks.put(entry.getKey(),links);
	}
	
	return dateLinks;

	}

	class DateComparator implements Comparator<String> {
        DateFormat f = new SimpleDateFormat("MM-dd-yyyy HH:mm");//or your pattern
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