package com.servinglynk.hmis.warehouse.service.converter;

import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.enums.EnrollmentDisablingconditionEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentHousingstatusEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentMonthshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentRelationshiptohohEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorlengthofstayEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentTimeshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.enums.NoYesEnum;

public class EnrollmentConveter extends BaseConverter {




	public static com.servinglynk.hmis.warehouse.model.v2020.Enrollment modelToEntity(Enrollment enrollment,com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment){
		if(pEnrollment==null) {
			pEnrollment = new com.servinglynk.hmis.warehouse.model.v2020.Enrollment();
			pEnrollment.setSource("2020");
		}
		if(enrollment.getDisablingcondition()!=null)
		pEnrollment.setDisablingcondition(EnrollmentDisablingconditionEnum.lookupEnum(enrollment.getDisablingcondition().toString()));
		if(enrollment.getEntryDate()!=null)
		pEnrollment.setEntrydate(enrollment.getEntryDate());
		if(enrollment.getHouseholdid()!=null)
		pEnrollment.setHouseholdid(enrollment.getHouseholdid());
		if(enrollment.getMonthshomelesspastthreeyears()!=null)
		pEnrollment.setMonthshomelesspastthreeyears(EnrollmentMonthshomelesspastthreeyearsEnum.lookupEnum(enrollment.getMonthshomelesspastthreeyears().toString()));
	/*	if(enrollment.getProjectentryid()!=null)
		pEnrollment.setProjectentryid(enrollment.getProjectentryid());*/
		if(enrollment.getLivingSituation()!=null)
			
		if(enrollment.getRelationshiptohoh()!=null)
		pEnrollment.setRelationshiptohoh(EnrollmentRelationshiptohohEnum.lookupEnum(enrollment.getRelationshiptohoh().toString()));
		if(enrollment.getTimeshomelesspastthreeyears()!=null)
		pEnrollment.setTimeshomelesspastthreeyears(EnrollmentTimeshomelesspastthreeyearsEnum.lookupEnum(enrollment.getTimeshomelesspastthreeyears().toString()));
		if(enrollment.getMonthshomelesspastthreeyears()!=null)
		pEnrollment.setMonthshomelesspastthreeyears(EnrollmentMonthshomelesspastthreeyearsEnum.lookupEnum(enrollment.getMonthshomelesspastthreeyears().toString()));
		if(enrollment.getLosunderthreshold()!=null)
		pEnrollment.setLosunderthreshold(NoYesEnum.lookupEnum(enrollment.getLosunderthreshold().toString()));
		if(enrollment.getPreviousStreetESSH()!=null)
		pEnrollment.setPreviousStreetESSH(NoYesEnum.lookupEnum(enrollment.getPreviousStreetESSH().toString()));
		if(enrollment.getDateToStreetESSH() != null) 
			pEnrollment.setEntrydate(enrollment.getDateToStreetESSH());

		return pEnrollment;
	}


	public static Enrollment entityToModel(com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment){
		Enrollment enrollment = new Enrollment();
		if(pEnrollment.getDisablingcondition()!=null)		enrollment.setDisablingcondition(Integer.parseInt(pEnrollment.getDisablingcondition().getValue()));
		if(pEnrollment.getEntrydate()!=null) enrollment.setEntryDate(pEnrollment.getEntrydate());
		if(pEnrollment.getHouseholdid()!=null) enrollment.setHouseholdid(pEnrollment.getHouseholdid());
		if(pEnrollment.getMonthshomelesspastthreeyears()!=null) enrollment.setMonthshomelesspastthreeyears(Integer.parseInt(pEnrollment.getMonthshomelesspastthreeyears().getValue()));
/*		if(pEnrollment.getProjectentryid()!=null) enrollment.setProjectentryid(pEnrollment.getProjectentryid());
*/		if(pEnrollment.getRelationshiptohoh()!=null) enrollment.setRelationshiptohoh(Integer.parseInt(pEnrollment.getRelationshiptohoh().getValue()));
		if(pEnrollment.getTimeshomelesspastthreeyears()!=null) enrollment.setTimeshomelesspastthreeyears(Integer.parseInt(pEnrollment.getTimeshomelesspastthreeyears().getValue()));
		enrollment.setEnrollmentId(pEnrollment.getId());
		enrollment.setEnrollmentId(pEnrollment.getId());
		if(pEnrollment.getLivingSituation()!=null) enrollment.setLivingSituation(Integer.parseInt(pEnrollment.getLivingSituation().getValue()));
		if(pEnrollment.getLengthOfStay() != null) enrollment.setLengthOfStay(Integer.parseInt(pEnrollment.getLengthOfStay().getValue()));
		enrollment.setEnrollmentId(pEnrollment.getId());
		if(pEnrollment.getLosunderthreshold()!=null)
		enrollment.setLosunderthreshold(Integer.parseInt(pEnrollment.getLosunderthreshold().getValue()));
		if(pEnrollment.getPreviousStreetESSH()!=null)
		enrollment.setPreviousStreetESSH(Integer.parseInt(pEnrollment.getPreviousStreetESSH().getValue()));
		if(pEnrollment.getProject()!=null) enrollment.setProjectid(pEnrollment.getProject().getId());
		if(pEnrollment.getDatetostreetessh() != null) enrollment.setDateToStreetESSH(pEnrollment.getDatetostreetessh());

		copyBeanProperties(pEnrollment, enrollment);

		return enrollment;
	}
	
	public static Enrollment entityToModelv2(com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment){
		Enrollment enrollment = new Enrollment();
		if(pEnrollment.getDisablingcondition()!=null)		enrollment.setDisablingcondition(Integer.parseInt(pEnrollment.getDisablingcondition().getValue()));
		if(pEnrollment.getEntrydate()!=null) enrollment.setEntryDate(pEnrollment.getEntrydate());
		if(pEnrollment.getHouseholdid()!=null) enrollment.setHouseholdid(pEnrollment.getHouseholdid());
		if(pEnrollment.getMonthshomelesspastthreeyears()!=null) enrollment.setMonthshomelesspastthreeyears(Integer.parseInt(pEnrollment.getMonthshomelesspastthreeyears().getValue()));
/*		if(pEnrollment.getProjectentryid()!=null) enrollment.setProjectentryid(pEnrollment.getProjectentryid());
*/		if(pEnrollment.getRelationshiptohoh()!=null) enrollment.setRelationshiptohoh(Integer.parseInt(pEnrollment.getRelationshiptohoh().getValue()));
		if(pEnrollment.getTimeshomelesspastthreeyears()!=null) enrollment.setTimeshomelesspastthreeyears(Integer.parseInt(pEnrollment.getTimeshomelesspastthreeyears().getValue()));
		enrollment.setEnrollmentId(pEnrollment.getId());
		enrollment.setEnrollmentId(pEnrollment.getId());
		if(pEnrollment.getLivingSituation()!=null) enrollment.setLivingSituation(Integer.parseInt(pEnrollment.getLivingSituation().getValue()));
		if(pEnrollment.getLengthOfStay() != null) enrollment.setLengthOfStay(Integer.parseInt(pEnrollment.getLengthOfStay().getValue()));
		enrollment.setEnrollmentId(pEnrollment.getId());
		if(pEnrollment.getLosunderthreshold()!=null)
		enrollment.setLosunderthreshold(Integer.parseInt(pEnrollment.getLosunderthreshold().getValue()));
		if(pEnrollment.getPreviousStreetESSH()!=null)
		enrollment.setPreviousStreetESSH(Integer.parseInt(pEnrollment.getPreviousStreetESSH().getValue()));
		if(pEnrollment.getProject()!=null) enrollment.setProjectid(pEnrollment.getProject().getId());
		enrollment.setSource(pEnrollment.getSource());
		if(pEnrollment.getDatetostreetessh() != null) enrollment.setDateToStreetESSH(pEnrollment.getDatetostreetessh());

		copyBeanProperties(pEnrollment, enrollment);
	       if(pEnrollment.getParentId() ==null && pEnrollment.getClient()!=null) {
	    	   enrollment.addLink(new ActionLink("history","/clients/"+pEnrollment.getClient().getId()+"/enrollments/"+pEnrollment.getId()+"/history"));
	       }
		return enrollment;
	}
}
