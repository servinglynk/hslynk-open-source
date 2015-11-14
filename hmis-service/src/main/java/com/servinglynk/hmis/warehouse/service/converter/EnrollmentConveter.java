package com.servinglynk.hmis.warehouse.service.converter;

import java.time.ZoneId;
import java.util.Date;

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

public class EnrollmentConveter {
	

	
	
	public static com.servinglynk.hmis.warehouse.model.live.Enrollment modelToEntity(Enrollment enrollment,com.servinglynk.hmis.warehouse.model.live.Enrollment pEnrollment){
		if(pEnrollment==null) pEnrollment = new com.servinglynk.hmis.warehouse.model.live.Enrollment();

		pEnrollment.setContinuouslyhomelessoneyear(EnrollmentContinuouslyhomelessoneyearEnum.valueOf(enrollment.getContinuouslyhomelessoneyear()));
		pEnrollment.setDisablingcondition(EnrollmentDisablingconditionEnum.valueOf(enrollment.getDisablingcondition()));
		pEnrollment.setEntrydate(enrollment.getEntrydate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		pEnrollment.setHouseholdid(enrollment.getHouseholdid());
		pEnrollment.setHousingstatus(EnrollmentHousingstatusEnum.valueOf(enrollment.getHousingstatus()));
		pEnrollment.setMonthshomelesspastthreeyears(EnrollmentMonthshomelesspastthreeyearsEnum.valueOf(enrollment.getMonthshomelesspastthreeyears()));
		pEnrollment.setMonthshomelessthistime(EnrollmentMonthshomelessthistimeEnum.valueOf(enrollment.getMonthshomelessthistime()));
		pEnrollment.setOtherresidenceprior(enrollment.getOtherresidenceprior());
		pEnrollment.setPersonalid(enrollment.getPersonalid());
		pEnrollment.setProjectentryid(enrollment.getProjectentryid());
		pEnrollment.setProjectid(enrollment.getProjectid());
		pEnrollment.setRelationshiptohoh(EnrollmentRelationshiptohohEnum.valueOf(enrollment.getRelationshiptohoh()));
		pEnrollment.setResidenceprior(EnrollmentResidencepriorEnum.valueOf(enrollment.getResidenceprior()));
		pEnrollment.setResidencepriorlengthofstay(EnrollmentResidencepriorlengthofstayEnum.valueOf(enrollment.getResidencepriorlengthofstay()));
		pEnrollment.setStatusdocumented(EnrollmentStatusdocumentedEnum.valueOf(enrollment.getStatusdocumented()));
		pEnrollment.setTimeshomelesspastthreeyears(EnrollmentTimeshomelesspastthreeyearsEnum.valueOf(enrollment.getTimeshomelesspastthreeyears()));
		pEnrollment.setYearshomeless(enrollment.getYearshomeless());
		pEnrollment.setMonthshomelesspastthreeyears(EnrollmentMonthshomelesspastthreeyearsEnum.valueOf(enrollment.getMonthshomelesspastthreeyears()));
		
		return pEnrollment;
	}
	
	
	public static Enrollment entityToModel(com.servinglynk.hmis.warehouse.model.live.Enrollment pEnrollment){
		Enrollment enrollment = new Enrollment();
		
		
		enrollment.setContinuouslyhomelessoneyear(pEnrollment.getContinuouslyhomelessoneyear().name());
		if(pEnrollment.getDisablingcondition()!=null)		enrollment.setDisablingcondition(pEnrollment.getDisablingcondition().name());
		if(pEnrollment.getEntrydate()!=null) enrollment.setEntrydate(Date.from(pEnrollment.getEntrydate().atZone(ZoneId.systemDefault()).toInstant()));
		if(pEnrollment.getHouseholdid()!=null) enrollment.setHouseholdid(pEnrollment.getHouseholdid());
		if(pEnrollment.getHousingstatus()!=null) enrollment.setHousingstatus(pEnrollment.getHousingstatus().name());
		if(pEnrollment.getMonthshomelesspastthreeyears()!=null) enrollment.setMonthshomelesspastthreeyears(pEnrollment.getMonthshomelesspastthreeyears().name());
		if(pEnrollment.getMonthshomelessthistime()!=null) enrollment.setMonthshomelessthistime(pEnrollment.getMonthshomelessthistime().name());
		if(pEnrollment.getOtherresidenceprior()!=null) enrollment.setOtherresidenceprior(pEnrollment.getOtherresidenceprior());
		if(pEnrollment.getPersonalid()!=null) enrollment.setPersonalid(pEnrollment.getPersonalid());
		if(pEnrollment.getProjectentryid()!=null) enrollment.setProjectentryid(pEnrollment.getProjectentryid());
		if(pEnrollment.getRelationshiptohoh()!=null) enrollment.setRelationshiptohoh(pEnrollment.getRelationshiptohoh().name());
		if(pEnrollment.getResidenceprior()!=null) enrollment.setResidenceprior(pEnrollment.getResidenceprior().name());
		if(pEnrollment.getResidencepriorlengthofstay()!=null) enrollment.setResidencepriorlengthofstay(pEnrollment.getResidencepriorlengthofstay().name());
		if(pEnrollment.getStatusdocumented()!=null) enrollment.setStatusdocumented(pEnrollment.getStatusdocumented().name());
		if(pEnrollment.getTimeshomelesspastthreeyears()!=null) enrollment.setTimeshomelesspastthreeyears(pEnrollment.getTimeshomelesspastthreeyears().name());
		if(pEnrollment.getYearshomeless()!=null) enrollment.setYearshomeless(pEnrollment.getYearshomeless());
		enrollment.setEnrollmentId(pEnrollment.getId());
		
		
		return enrollment;
	}
}
