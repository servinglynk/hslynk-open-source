package com.servinglynk.hmis.warehouse.service.converter;

import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.enums.EnrollmentContinuouslyhomelessoneyearEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentDisablingconditionEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentHousingstatusEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentMonthshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentMonthshomelessthistimeEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentRelationshiptohohEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorlengthofstayEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentStatusdocumentedEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentTimeshomelesspastthreeyearsEnum;

public class EnrollmentConveter extends BaseConverter {
	

	
	
	public static com.servinglynk.hmis.warehouse.model.v2014.Enrollment modelToEntity(Enrollment enrollment,com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment){
		if(pEnrollment==null) {
			pEnrollment = new com.servinglynk.hmis.warehouse.model.v2014.Enrollment();
			pEnrollment.setSource("2014");
		}
		if(enrollment.getContinuouslyhomelessoneyear()!=null)
		pEnrollment.setContinuouslyhomelessoneyear(EnrollmentContinuouslyhomelessoneyearEnum.lookupEnum(enrollment.getContinuouslyhomelessoneyear().toString()));
		if(enrollment.getDisablingcondition()!=null)
		pEnrollment.setDisablingcondition(EnrollmentDisablingconditionEnum.lookupEnum(enrollment.getDisablingcondition().toString()));
		if(enrollment.getEntrydate()!=null)
		pEnrollment.setEntrydate(enrollment.getEntrydate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		
		if(enrollment.getHousingstatus()!=null)
		pEnrollment.setHousingstatus(EnrollmentHousingstatusEnum.lookupEnum(enrollment.getHousingstatus().toString()));
		if(enrollment.getMonthshomelesspastthreeyears()!=null)
		pEnrollment.setMonthshomelesspastthreeyears(EnrollmentMonthshomelesspastthreeyearsEnum.lookupEnum(enrollment.getMonthshomelesspastthreeyears().toString()));
		if(enrollment.getMonthshomelessthistime()!=null)
		pEnrollment.setMonthshomelessthistime(EnrollmentMonthshomelessthistimeEnum.lookupEnum(enrollment.getMonthshomelessthistime().toString()));
		if(enrollment.getOtherresidenceprior()!=null)
		pEnrollment.setOtherresidenceprior(enrollment.getOtherresidenceprior());
		if(enrollment.getRelationshiptohoh()!=null)
		pEnrollment.setRelationshiptohoh(EnrollmentRelationshiptohohEnum.lookupEnum(enrollment.getRelationshiptohoh().toString()));
		if(enrollment.getResidenceprior()!=null)
		pEnrollment.setResidenceprior(EnrollmentResidencepriorEnum.lookupEnum(enrollment.getResidenceprior().toString()));
		if(enrollment.getResidencepriorlengthofstay()!=null)
		pEnrollment.setResidencepriorlengthofstay(EnrollmentResidencepriorlengthofstayEnum.lookupEnum(enrollment.getResidencepriorlengthofstay().toString()));
		if(enrollment.getStatusdocumented()!=null)
		pEnrollment.setStatusdocumented(EnrollmentStatusdocumentedEnum.lookupEnum(enrollment.getStatusdocumented().toString()));
		if(enrollment.getTimeshomelesspastthreeyears()!=null)
		pEnrollment.setTimeshomelesspastthreeyears(EnrollmentTimeshomelesspastthreeyearsEnum.lookupEnum(enrollment.getTimeshomelesspastthreeyears().toString()));
		pEnrollment.setYearshomeless(enrollment.getYearshomeless());
		if(enrollment.getMonthshomelesspastthreeyears()!=null)
		pEnrollment.setMonthshomelesspastthreeyears(EnrollmentMonthshomelesspastthreeyearsEnum.lookupEnum(enrollment.getMonthshomelesspastthreeyears().toString()));
		if(enrollment.getHouseholdid()!=null)
				pEnrollment.setHouseholdid(enrollment.getHouseholdid());
		return pEnrollment;
	}
	
	
	public static Enrollment entityToModel(com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment){
		Enrollment enrollment = new Enrollment();	
		if(pEnrollment.getContinuouslyhomelessoneyear()!=null)
		enrollment.setContinuouslyhomelessoneyear(Integer.parseInt(pEnrollment.getContinuouslyhomelessoneyear().getValue()));
		if(pEnrollment.getDisablingcondition()!=null)		enrollment.setDisablingcondition(Integer.parseInt(pEnrollment.getDisablingcondition().getValue()));
		if(pEnrollment.getEntrydate()!=null) enrollment.setEntrydate(Date.from(pEnrollment.getEntrydate().atZone(ZoneId.systemDefault()).toInstant()));
		if(pEnrollment.getHouseholdid()!=null) enrollment.setHouseholdid(pEnrollment.getHouseholdid());
		if(pEnrollment.getHousingstatus()!=null) enrollment.setHousingstatus(Integer.parseInt(pEnrollment.getHousingstatus().getValue()));
		if(pEnrollment.getMonthshomelesspastthreeyears()!=null) enrollment.setMonthshomelesspastthreeyears(Integer.parseInt(pEnrollment.getMonthshomelesspastthreeyears().getValue()));
		if(pEnrollment.getMonthshomelessthistime()!=null) enrollment.setMonthshomelessthistime(Integer.parseInt(pEnrollment.getMonthshomelessthistime().getValue()));
		if(pEnrollment.getOtherresidenceprior()!=null) enrollment.setOtherresidenceprior(pEnrollment.getOtherresidenceprior());
		if(pEnrollment.getRelationshiptohoh()!=null) enrollment.setRelationshiptohoh(Integer.parseInt(pEnrollment.getRelationshiptohoh().getValue()));
		if(pEnrollment.getResidenceprior()!=null) enrollment.setResidenceprior(Integer.parseInt(pEnrollment.getResidenceprior().getValue()));
		if(pEnrollment.getResidencepriorlengthofstay()!=null) enrollment.setResidencepriorlengthofstay(Integer.parseInt(pEnrollment.getResidencepriorlengthofstay().getValue()));
		if(pEnrollment.getStatusdocumented()!=null) enrollment.setStatusdocumented(Integer.parseInt(pEnrollment.getStatusdocumented().getValue()));
		if(pEnrollment.getTimeshomelesspastthreeyears()!=null) enrollment.setTimeshomelesspastthreeyears(Integer.parseInt(pEnrollment.getTimeshomelesspastthreeyears().getValue()));
		if(pEnrollment.getYearshomeless()!=null) enrollment.setYearshomeless(pEnrollment.getYearshomeless());
		if(pEnrollment.getProject()!=null) enrollment.setProjectid(pEnrollment.getProject().getId());
		enrollment.setChronicHomeless(pEnrollment.isChronicHomeless());
		enrollment.setEnrollmentId(pEnrollment.getId());
		copyBeanProperties(pEnrollment, enrollment);
	       if(pEnrollment.getParentId() ==null && pEnrollment.getClient()!=null) {
	    	   enrollment.addLink(new ActionLink("history","/clients/"+pEnrollment.getClient().getId()+"/enrollments/"+pEnrollment.getId()+"/history"));
	       }
			if(pEnrollment.getHmisHousehold()!=null) {
				enrollment.setHmisHouseholdId(pEnrollment.getHmisHousehold().getId());
				enrollment.addLink(new ActionLink("hmisHouseHold","/hmis-clientapi/rest/v2014/hmishouseholds/"+pEnrollment.getHmisHousehold().getId()));
			}
		return enrollment;
	}
	
	public static Enrollment entityToModelV2(com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment){
		Enrollment enrollment = new Enrollment();	
		if(pEnrollment.getContinuouslyhomelessoneyear()!=null)
		enrollment.setContinuouslyhomelessoneyear(Integer.parseInt(pEnrollment.getContinuouslyhomelessoneyear().getValue()));
		if(pEnrollment.getDisablingcondition()!=null)		enrollment.setDisablingcondition(Integer.parseInt(pEnrollment.getDisablingcondition().getValue()));
		if(pEnrollment.getEntrydate()!=null) enrollment.setEntrydate(Date.from(pEnrollment.getEntrydate().atZone(ZoneId.systemDefault()).toInstant()));
		if(pEnrollment.getHouseholdid()!=null) enrollment.setHouseholdid(pEnrollment.getHouseholdid());
		if(pEnrollment.getHousingstatus()!=null) enrollment.setHousingstatus(Integer.parseInt(pEnrollment.getHousingstatus().getValue()));
		if(pEnrollment.getMonthshomelesspastthreeyears()!=null) enrollment.setMonthshomelesspastthreeyears(Integer.parseInt(pEnrollment.getMonthshomelesspastthreeyears().getValue()));
		if(pEnrollment.getMonthshomelessthistime()!=null) enrollment.setMonthshomelessthistime(Integer.parseInt(pEnrollment.getMonthshomelessthistime().getValue()));
		if(pEnrollment.getOtherresidenceprior()!=null) enrollment.setOtherresidenceprior(pEnrollment.getOtherresidenceprior());
		if(pEnrollment.getRelationshiptohoh()!=null) enrollment.setRelationshiptohoh(Integer.parseInt(pEnrollment.getRelationshiptohoh().getValue()));
		if(pEnrollment.getResidenceprior()!=null) enrollment.setResidenceprior(Integer.parseInt(pEnrollment.getResidenceprior().getValue()));
		if(pEnrollment.getResidencepriorlengthofstay()!=null) enrollment.setResidencepriorlengthofstay(Integer.parseInt(pEnrollment.getResidencepriorlengthofstay().getValue()));
		if(pEnrollment.getStatusdocumented()!=null) enrollment.setStatusdocumented(Integer.parseInt(pEnrollment.getStatusdocumented().getValue()));
		if(pEnrollment.getTimeshomelesspastthreeyears()!=null) enrollment.setTimeshomelesspastthreeyears(Integer.parseInt(pEnrollment.getTimeshomelesspastthreeyears().getValue()));
		if(pEnrollment.getYearshomeless()!=null) enrollment.setYearshomeless(pEnrollment.getYearshomeless());
		if(pEnrollment.getProject()!=null) enrollment.setProjectid(pEnrollment.getProject().getId());
		enrollment.setChronicHomeless(pEnrollment.isChronicHomeless());
		enrollment.setEnrollmentId(pEnrollment.getId());
		copyBeanProperties(pEnrollment, enrollment);
		enrollment.setSource(pEnrollment.getSource());
		if(pEnrollment.getHmisHousehold()!=null) {
			enrollment.setHmisHouseholdId(pEnrollment.getHmisHousehold().getId());
			enrollment.addLink(new ActionLink("hmisHouseHold","/hmis-clientapi/rest/v2014/hmishouseholds/"+pEnrollment.getHmisHousehold().getId()));
		}
	       if(pEnrollment.getParentId() ==null && pEnrollment.getClient()!=null) {
	    	   enrollment.addLink(new ActionLink("history","/clients/"+pEnrollment.getClient().getId()+"/enrollments/"+pEnrollment.getId()+"/history"));
	       }
		return enrollment;
	}
}
