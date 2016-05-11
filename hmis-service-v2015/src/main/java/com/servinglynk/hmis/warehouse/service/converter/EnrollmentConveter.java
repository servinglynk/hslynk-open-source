package com.servinglynk.hmis.warehouse.service.converter;

import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.enums.EnrollmentDisablingconditionEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentHousingstatusEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentMonthshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentRelationshiptohohEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorlengthofstayEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentTimeshomelesspastthreeyearsEnum;

public class EnrollmentConveter extends BaseConverter {
	

	
	
	public static com.servinglynk.hmis.warehouse.model.v2015.Enrollment modelToEntity(Enrollment enrollment,com.servinglynk.hmis.warehouse.model.v2015.Enrollment pEnrollment){
		if(pEnrollment==null) pEnrollment = new com.servinglynk.hmis.warehouse.model.v2015.Enrollment();
		if(enrollment.getDisablingcondition()!=null)
		pEnrollment.setDisablingcondition(EnrollmentDisablingconditionEnum.lookupEnum(enrollment.getDisablingcondition().toString()));
		if(enrollment.getEntrydate()!=null)
		pEnrollment.setEntrydate(enrollment.getEntrydate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		if(enrollment.getHouseholdid()!=null)
		pEnrollment.setHouseholdid(enrollment.getHouseholdid());
		if(enrollment.getHousingstatus()!=null)
		pEnrollment.setHousingstatus(EnrollmentHousingstatusEnum.lookupEnum(enrollment.getHousingstatus().toString()));
		if(enrollment.getMonthshomelesspastthreeyears()!=null)
		pEnrollment.setMonthshomelesspastthreeyears(EnrollmentMonthshomelesspastthreeyearsEnum.lookupEnum(enrollment.getMonthshomelesspastthreeyears().toString()));
		if(enrollment.getOtherresidenceprior()!=null)
		pEnrollment.setOtherresidenceprior(enrollment.getOtherresidenceprior());
	/*	if(enrollment.getProjectentryid()!=null)
		pEnrollment.setProjectentryid(enrollment.getProjectentryid());*/
		if(enrollment.getRelationshiptohoh()!=null)
		pEnrollment.setRelationshiptohoh(EnrollmentRelationshiptohohEnum.lookupEnum(enrollment.getRelationshiptohoh().toString()));
		if(enrollment.getTimeshomelesspastthreeyears()!=null)
		pEnrollment.setTimeshomelesspastthreeyears(EnrollmentTimeshomelesspastthreeyearsEnum.lookupEnum(enrollment.getTimeshomelesspastthreeyears().toString()));
		if(enrollment.getMonthshomelesspastthreeyears()!=null)
		pEnrollment.setMonthshomelesspastthreeyears(EnrollmentMonthshomelesspastthreeyearsEnum.lookupEnum(enrollment.getMonthshomelesspastthreeyears().toString()));
		if(enrollment.getResidenceprior()!=null)
		pEnrollment.setResidenceprior(EnrollmentResidencepriorEnum.lookupEnum(enrollment.getResidenceprior().toString()));
		if(enrollment.getResidencepriorlengthofstay()!=null)
		pEnrollment.setResidencepriorlengthofstay(EnrollmentResidencepriorlengthofstayEnum.lookupEnum(enrollment.getResidencepriorlengthofstay().toString()));
		if(enrollment.getHousingstatus()!=null)
		pEnrollment.setHousingstatus(EnrollmentHousingstatusEnum.lookupEnum(enrollment.getHousingstatus().toString()));
		if(enrollment.getEntryfromstreetessh()!=null)
		pEnrollment.setEntryfromstreetessh(enrollment.getEntryfromstreetessh());
		if(enrollment.getDatetostreetessh()!=null)
		pEnrollment.setEntryfromstreetessh(enrollment.getDatetostreetessh());
					
		return pEnrollment;
	}
	
	
	public static Enrollment entityToModel(com.servinglynk.hmis.warehouse.model.v2015.Enrollment pEnrollment){
		Enrollment enrollment = new Enrollment();	
		if(pEnrollment.getDisablingcondition()!=null)		enrollment.setDisablingcondition(Integer.parseInt(pEnrollment.getDisablingcondition().getValue()));
		if(pEnrollment.getEntrydate()!=null) enrollment.setEntrydate(Date.from(pEnrollment.getEntrydate().atZone(ZoneId.systemDefault()).toInstant()));
		if(pEnrollment.getHouseholdid()!=null) enrollment.setHouseholdid(pEnrollment.getHouseholdid());
		if(pEnrollment.getHousingstatus()!=null) enrollment.setHousingstatus(Integer.parseInt(pEnrollment.getHousingstatus().getValue()));
		if(pEnrollment.getMonthshomelesspastthreeyears()!=null) enrollment.setMonthshomelesspastthreeyears(Integer.parseInt(pEnrollment.getMonthshomelesspastthreeyears().getValue()));
		if(pEnrollment.getOtherresidenceprior()!=null) enrollment.setOtherresidenceprior(pEnrollment.getOtherresidenceprior());
/*		if(pEnrollment.getProjectentryid()!=null) enrollment.setProjectentryid(pEnrollment.getProjectentryid());
*/		if(pEnrollment.getRelationshiptohoh()!=null) enrollment.setRelationshiptohoh(Integer.parseInt(pEnrollment.getRelationshiptohoh().getValue()));
		if(pEnrollment.getTimeshomelesspastthreeyears()!=null) enrollment.setTimeshomelesspastthreeyears(Integer.parseInt(pEnrollment.getTimeshomelesspastthreeyears().getValue()));
		enrollment.setEnrollmentId(pEnrollment.getId());
		if(pEnrollment.getResidenceprior()!=null) enrollment.setResidenceprior(Integer.parseInt(pEnrollment.getResidenceprior().getValue()));
		enrollment.setEnrollmentId(pEnrollment.getId());
		if(pEnrollment.getResidencepriorlengthofstay()!=null) enrollment.setResidencepriorlengthofstay(Integer.parseInt(pEnrollment.getResidencepriorlengthofstay().getValue()));
		enrollment.setEnrollmentId(pEnrollment.getId());
		if(pEnrollment.getHousingstatus()!=null) enrollment.setHousingstatus(Integer.parseInt(pEnrollment.getHousingstatus().getValue()));
		enrollment.setEnrollmentId(pEnrollment.getId());
		if(pEnrollment.getEntryfromstreetessh()!=null) enrollment.setEntryfromstreetessh(Integer.parseInt(pEnrollment.getEntryfromstreetessh().toString()));
		enrollment.setEnrollmentId(pEnrollment.getId());
		if(pEnrollment.getDatetostreetessh()!=null) enrollment.setDatetostreetessh(Integer.parseInt(pEnrollment.getDatetostreetessh().toString()));
		enrollment.setEnrollmentId(pEnrollment.getId());
		copyBeanProperties(pEnrollment, enrollment);
		
		return enrollment;
	}
}
