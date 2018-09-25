package com.servinglynk.hmis.warehouse.service.impl;

import java.util.ArrayList;
import java.util.List;
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
	
	public List<ActionLink> getEntryRhspsLinks(UUID clientId,UUID enrollmentId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<Entryrhsp> data = daoFactory.getEntryrhspDao().getAllEnrollmentEntryrhsps(enrollmentId, null,null);
		for(Entryrhsp entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/entryrhsps/"+entity.getId()));
		}
		return links;
	}
	
	public List<ActionLink> getEntryrhysLinks(UUID clientId,UUID enrollmentId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<Entryrhy> data = daoFactory.getEntryrhyDao().getAllEnrollmentEntryrhys(enrollmentId, null,null);
		for(Entryrhy entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/entryrhys/"+entity.getId()));
		}
		return links;
	}
	
	@SuppressWarnings("unchecked")
	public List<ActionLink> getEntryssvfsLinks(UUID clientId,UUID enrollmentId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<Entryssvf> data = daoFactory.getEntryssvfDao().getAllEnrollmentEntryssvfs(enrollmentId, null,null);
		for(Entryssvf entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/entryssvfs/"+entity.getId()));
		}
		return links;
	}
	
	public List<ActionLink> getEnrollmentcocsLinks(UUID clientId,UUID enrollmentId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<EnrollmentCoc> data = daoFactory.getEnrollmentCocDao().getAllEnrollmentEnrollmentCocs(enrollmentId, null,null);
		for(EnrollmentCoc entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs/"+entity.getId()));
		}
		return links;
	}
	public List<ActionLink> getEducationsLinks(UUID clientId,UUID enrollmentId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<Education> data = daoFactory.getEducationDao().getAllEnrollmentEducations(enrollmentId, null,null);
		for(Education entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/educations/"+entity.getId()));
		}
		return links;
	}
	public List<ActionLink> getContactsLinks(UUID clientId,UUID enrollmentId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<Contact> data = daoFactory.getContactDao().getAllEnrollmentContacts(enrollmentId, null,null);
		for(Contact entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/contacts/"+entity.getId()));
		}
		return links;
	}
	public List<ActionLink> getDateOfEngagementsLinks(UUID clientId,UUID enrollmentId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<Dateofengagement> data = daoFactory.getDateofengagementDao().getAllEnrollmentDateofengagements(enrollmentId, null,null);
		for(Dateofengagement entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements/"+entity.getId()));
		}
		return links;
	}
	public List<ActionLink> getDisabilitiesLinks(UUID clientId,UUID enrollmentId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<Disabilities> data = daoFactory.getDisabilitiesDao().getAllEnrollmentDisabilitiess(enrollmentId, null,null);
		for(Disabilities entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilities/"+entity.getId()));
		}
		return links;
	}
	public List<ActionLink> getDomesticViolencesLinks(UUID clientId,UUID enrollmentId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<Domesticviolence> data = daoFactory.getDomesticviolenceDao().getAllEnrollmentDomesticViolences(enrollmentId, null,null);
		for(Domesticviolence entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences/"+entity.getId()));
		}
		return links;
	}
	public List<ActionLink> getEmploymentsLinks(UUID clientId,UUID enrollmentId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<Employment> data = daoFactory.getEmploymentDao().getAllEnrollmentEmployments(enrollmentId, null,null);
		for(Employment entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+entity.getId()));
		}
		return links;
	}
	public List<ActionLink> getHealthinsurancesLinks(UUID clientId,UUID enrollmentId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<Healthinsurance> data = daoFactory.getHealthinsuranceDao().getAllEnrollmentHealthInsurances(enrollmentId, null,null);
		for(Healthinsurance entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances/"+entity.getId()));
		}
		return links;
	}
	public List<ActionLink> getHealthStatusesLinks(UUID clientId,UUID enrollmentId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<HealthStatus> data = daoFactory.getHealthStatusDao().getAllEnrollmentHealthStatuses(enrollmentId, null,null);
		for(HealthStatus entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuses/"+entity.getId()));
		}
		return links;
	}
	public List<ActionLink> getIncomeandsourcesLinks(UUID clientId,UUID enrollmentId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<Incomeandsources> data = daoFactory.getIncomeandsourcesDao().getAllEnrollmentIncomeAndSources(enrollmentId, null,null);
		for(Incomeandsources entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeandsources/"+entity.getId()));
		}
		return links;
	}
	public List<ActionLink> getMedicalassistancesLinks(UUID clientId,UUID enrollmentId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<Medicalassistance> data = daoFactory.getMedicalassistanceDao().getAllEnrollmentMedicalassistances(enrollmentId, null,null);
		for(Medicalassistance entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances/"+entity.getId()));
		}
		return links;
	}
	public List<ActionLink> getNoncashbenefitsLinks(UUID clientId,UUID enrollmentId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<Noncashbenefits> data = daoFactory.getNoncashbenefitsDao().getAllEnrollmentNoncashbenefits(enrollmentId, null,null);
		for(Noncashbenefits entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefits/"+entity.getId()));
		}
		return links;
	}
	public List<ActionLink> getResidentialMoveinDatesLinks(UUID clientId,UUID enrollmentId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<Moveindate> data = daoFactory.getResidentialmoveindateDao().getAllEnrollmentResidentialmoveindates(enrollmentId, null,null);
		for(Moveindate entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+entity.getId()));
		}
		return links;
	}
	public List<ActionLink> getPathstatusesLinks(UUID clientId,UUID enrollmentId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<Pathstatus> data = daoFactory.getPathstatusDao().getAllEnrollmentPathstatuss(enrollmentId, null,null);
		for(Pathstatus entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/pathstatuses/"+entity.getId()));
		}
		return links;
	}
	public List<ActionLink> getServiceFaReferralsLinks(UUID clientId,UUID enrollmentId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<ServiceFaReferral> data = daoFactory.getServiceFaReferralDao().getAllEnrollmentServiceFaReferrals(enrollmentId, null,null);
		for(ServiceFaReferral entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/servicefareferrals/"+entity.getId()));
		}
		return links;
	}
	
	@Transactional
	public List<ExitActionLink> getExitLinks(UUID clientId,UUID enrollmentId){
		List<ExitActionLink> actionLinks = new ArrayList<ExitActionLink>();
		
		List<Exit> data = daoFactory.getExitDao().getAllEnrollmentExits(enrollmentId, null, null);
		for(Exit entity : data) {
			ExitActionLink actionLink = new ExitActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+entity.getId());
			EnrollmentExitLinks exitLinks = new EnrollmentExitLinks();
			actionLink.setExitHousingAssessments(this.getExitHousingAssessmentsLinks(clientId, enrollmentId, entity.getId()));
			//actionLink.setExitPaths(this.getExitPathsLinks(clientId, enrollmentId, entity.getId()));
			actionLink.setExitrhys(this.getExitrhysLinks(clientId, enrollmentId, entity.getId()));
			actionLink.setHousingAssessmentDispositions(this.getHousingAssessmentDispositionsLinks(clientId, enrollmentId, entity.getId()));
			
			if(actionLink.getExitHousingAssessments().isEmpty())  actionLink.setExitHousingAssessments(null);
			if(actionLink.getExitPaths().isEmpty()) actionLink.setExitPaths(null);
			if(actionLink.getExitrhys().isEmpty()) actionLink.setExitrhys(null);
			if(actionLink.getHousingAssessmentDispositions().isEmpty()) actionLink.setHousingAssessmentDispositions(null);
			
			actionLinks.add(actionLink);
		}
		return actionLinks;
	}
	
	List<ActionLink> getExitHousingAssessmentsLinks(UUID clientId,UUID enrollmentId,UUID exitId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<Exithousingassessment> data = daoFactory.getExithousingassessmentDao().getAllExitExithousingassessments(exitId, null,null);
		for(Exithousingassessment entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+exitId+"/exithousingassessments/"+entity.getId()));
		}
		return links;
	}
	
	List<ActionLink> getHousingAssessmentDispositionsLinks(UUID clientId,UUID enrollmentId,UUID exitId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<Housingassessmentdisposition> data = daoFactory.getHousingassessmentdispositionDao().getAllExitHousingAssessmentDispositions(exitId, null,null);
		for(Housingassessmentdisposition entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+exitId+"/housingassessmentdispositions/"+entity.getId()));
		}
		return links;
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
	
	List<ActionLink> getExitrhysLinks(UUID clientId,UUID enrollmentId,UUID exitId) {
		List<ActionLink> links = new ArrayList<ActionLink>();
		List<Exitrhy> data = daoFactory.getExitrhyDao().getAllExitExitrhys(exitId, null,null);
		for(Exitrhy entity : data) {
			links.add(new ActionLink(entity.getId()+"", "/hmis-clientapi/rest/v2017/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+exitId+"/exitrhys/"+entity.getId()));
		}
		return links;
	}
	
	
	
}