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

public class EnrollmentConveter extends BaseConveter {
	

	
	
	public static com.servinglynk.hmis.warehouse.model.v2014.Enrollment modelToEntity(Enrollment enrollment,com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment){
		if(pEnrollment==null) pEnrollment = new com.servinglynk.hmis.warehouse.model.v2014.Enrollment();

		pEnrollment.setContinuouslyhomelessoneyear(EnrollmentContinuouslyhomelessoneyearEnum.lookupEnum(enrollment.getContinuouslyhomelessoneyear().toString()));
		pEnrollment.setDisablingcondition(EnrollmentDisablingconditionEnum.lookupEnum(enrollment.getDisablingcondition().toString()));
		pEnrollment.setEntrydate(enrollment.getEntrydate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		pEnrollment.setHouseholdid(enrollment.getHouseholdid());
		pEnrollment.setHousingstatus(EnrollmentHousingstatusEnum.lookupEnum(enrollment.getHousingstatus().toString()));
		pEnrollment.setMonthshomelesspastthreeyears(EnrollmentMonthshomelesspastthreeyearsEnum.lookupEnum(enrollment.getMonthshomelesspastthreeyears().toString()));
		pEnrollment.setMonthshomelessthistime(EnrollmentMonthshomelessthistimeEnum.lookupEnum(enrollment.getMonthshomelessthistime().toString()));
		pEnrollment.setOtherresidenceprior(enrollment.getOtherresidenceprior());
		pEnrollment.setPersonalid(enrollment.getPersonalid());
		pEnrollment.setProjectentryid(enrollment.getProjectentryid());
		pEnrollment.setProjectid(enrollment.getProjectid());
		pEnrollment.setRelationshiptohoh(EnrollmentRelationshiptohohEnum.lookupEnum(enrollment.getRelationshiptohoh().toString()));
		pEnrollment.setResidenceprior(EnrollmentResidencepriorEnum.lookupEnum(enrollment.getResidenceprior().toString()));
		pEnrollment.setResidencepriorlengthofstay(EnrollmentResidencepriorlengthofstayEnum.lookupEnum(enrollment.getResidencepriorlengthofstay().toString()));
		pEnrollment.setStatusdocumented(EnrollmentStatusdocumentedEnum.lookupEnum(enrollment.getStatusdocumented().toString()));
		pEnrollment.setTimeshomelesspastthreeyears(EnrollmentTimeshomelesspastthreeyearsEnum.lookupEnum(enrollment.getTimeshomelesspastthreeyears().toString()));
		pEnrollment.setYearshomeless(enrollment.getYearshomeless());
		pEnrollment.setMonthshomelesspastthreeyears(EnrollmentMonthshomelesspastthreeyearsEnum.lookupEnum(enrollment.getMonthshomelesspastthreeyears().toString()));
		
		return pEnrollment;
	}
	
	
	public static Enrollment entityToModel(com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment){
		Enrollment enrollment = new Enrollment();
		
		
		enrollment.setContinuouslyhomelessoneyear(Integer.parseInt(pEnrollment.getContinuouslyhomelessoneyear().getValue()));
		if(pEnrollment.getDisablingcondition()!=null)		enrollment.setDisablingcondition(Integer.parseInt(pEnrollment.getDisablingcondition().getValue()));
		if(pEnrollment.getEntrydate()!=null) enrollment.setEntrydate(Date.from(pEnrollment.getEntrydate().atZone(ZoneId.systemDefault()).toInstant()));
		if(pEnrollment.getHouseholdid()!=null) enrollment.setHouseholdid(pEnrollment.getHouseholdid());
		if(pEnrollment.getHousingstatus()!=null) enrollment.setHousingstatus(Integer.parseInt(pEnrollment.getHousingstatus().getValue()));
		if(pEnrollment.getMonthshomelesspastthreeyears()!=null) enrollment.setMonthshomelesspastthreeyears(Integer.parseInt(pEnrollment.getMonthshomelesspastthreeyears().getValue()));
		if(pEnrollment.getMonthshomelessthistime()!=null) enrollment.setMonthshomelessthistime(Integer.parseInt(pEnrollment.getMonthshomelessthistime().getValue()));
		if(pEnrollment.getOtherresidenceprior()!=null) enrollment.setOtherresidenceprior(pEnrollment.getOtherresidenceprior());
		if(pEnrollment.getPersonalid()!=null) enrollment.setPersonalid(pEnrollment.getPersonalid());
		if(pEnrollment.getProjectentryid()!=null) enrollment.setProjectentryid(pEnrollment.getProjectentryid());
		if(pEnrollment.getRelationshiptohoh()!=null) enrollment.setRelationshiptohoh(Integer.parseInt(pEnrollment.getRelationshiptohoh().getValue()));
		if(pEnrollment.getResidenceprior()!=null) enrollment.setResidenceprior(Integer.parseInt(pEnrollment.getResidenceprior().getValue()));
		if(pEnrollment.getResidencepriorlengthofstay()!=null) enrollment.setResidencepriorlengthofstay(Integer.parseInt(pEnrollment.getResidencepriorlengthofstay().getValue()));
		if(pEnrollment.getStatusdocumented()!=null) enrollment.setStatusdocumented(Integer.parseInt(pEnrollment.getStatusdocumented().getValue()));
		if(pEnrollment.getTimeshomelesspastthreeyears()!=null) enrollment.setTimeshomelesspastthreeyears(Integer.parseInt(pEnrollment.getTimeshomelesspastthreeyears().getValue()));
		if(pEnrollment.getYearshomeless()!=null) enrollment.setYearshomeless(pEnrollment.getYearshomeless());
		enrollment.setEnrollmentId(pEnrollment.getId());
		copyBeanProperties(pEnrollment, enrollment);
		
		return enrollment;
	}
}
