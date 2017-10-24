package com.servinglynk.hmis.warehouse.dao.helper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.enums.DisabilitiesIndefiniteandimpairsEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentDisablingconditionEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentMonthshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorlengthofstayEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentTimeshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectProjecttypeEnum;
import com.servinglynk.hmis.warehouse.model.v2016.Disabilities;
import com.servinglynk.hmis.warehouse.model.v2016.Enrollment;

@Component
public class ChronicHomelessCalcHelper{
	
	/*
	 * [Age @ Entry]>=18 AND ( [DisablingCondition] = 1 or [expected to be of
	 * long–continued and indefinite duration and substantially impairs ability
	 * to live independently] = “Yes” (1) for any of the following: physical
	 * disability, developmental disability, chronic health condition, HIV/AIDS,
	 * mental health problem, substance abuse ) and ( [client entering from the
	 * streets, es or sh] = yes or [ProjectType] = 1 or 4 or 8 ) and (
	 * [approximate date started] <= [project entry date] – 365 days or (
	 * [TimesHomelessPastThreeYears] = 4 AND [MonthsHomelessPastThreeYears] = 7
	 * ) )
	 */
	public boolean isEnrollmentChronicHomeless(Enrollment enrollment) {
		if(enrollment !=null) {
			if((EnrollmentDisablingconditionEnum.ONE.equals(enrollment.getDisablingcondition()))) {
				if(enrollment.getProject() !=null && (ProjectProjecttypeEnum.ONE.equals(enrollment.getProject().getProjecttype()) || ProjectProjecttypeEnum.FOUR.equals(enrollment.getProject().getProjecttype()) || ProjectProjecttypeEnum.EIGHT.equals(enrollment.getProject().getProjecttype()))) {
					return validateDiffInDays(enrollment);
				}
			}
			if(enrollment.getResidenceprior() !=null &&   ( EnrollmentResidencepriorEnum.EIGHT.equals(enrollment.getResidenceprior()) 
			  || EnrollmentResidencepriorEnum.NINE.equals(enrollment.getResidenceprior())
			  || EnrollmentResidencepriorEnum.NINTY_NINE.equals(enrollment.getResidenceprior()))){
				return false;
			}else {
				if(EnrollmentResidencepriorEnum.ONE.equals(enrollment.getResidenceprior())
				  || EnrollmentResidencepriorEnum.SIXTEEN.equals(enrollment.getResidenceprior())
				  || EnrollmentResidencepriorEnum.EIGHTEEN.equals(enrollment.getResidenceprior())
				  || EnrollmentResidencepriorEnum.TWENTY_SEVEN.equals(enrollment.getResidenceprior())) {
					return validateDiffInDays(enrollment);
				}else if(EnrollmentResidencepriorEnum.FIFTEEN.equals(enrollment.getResidenceprior())
						|| EnrollmentResidencepriorEnum.SIX.equals(enrollment.getResidenceprior())
						|| EnrollmentResidencepriorEnum.SEVEN.equals(enrollment.getResidenceprior())
						|| EnrollmentResidencepriorEnum.TWENTY_FOUR.equals(enrollment.getResidenceprior())
						|| EnrollmentResidencepriorEnum.FOUR.equals(enrollment.getResidenceprior())
						|| EnrollmentResidencepriorEnum.FIVE.equals(enrollment.getResidenceprior())) {
					if(enrollment.getResidencepriorlengthofstay() !=null 
							&& EnrollmentResidencepriorlengthofstayEnum.THREE.equals(enrollment.getResidencepriorlengthofstay())
							) {
						 return validateDiffInDays(enrollment);
					}
						
					
				}
				
				
			}
			
		}
		return false;
	}
	
	private long diffInDays(LocalDateTime a, LocalDateTime localDateTime) {
		  return ChronoUnit.DAYS.between(a, localDateTime);
		}
	
	private boolean validateDiffInDays(Enrollment enrollment) {
		if(diffInDays(LocalDateTime.now(),enrollment.getEntrydate()) > 365) {
			return true;
		}else {
			return validateTimesHomeless(enrollment);
		}
	}
	
	private boolean validateTimesHomeless(Enrollment enrollment) {
		if(enrollment.getTimeshomelesspastthreeyears() !=null && EnrollmentTimeshomelesspastthreeyearsEnum.FOUR.equals(enrollment.getTimeshomelesspastthreeyears())) {
			if(enrollment.getMonthshomelesspastthreeyears() !=null && Integer.parseInt(enrollment.getMonthshomelesspastthreeyears().getValue()) > 12) {
				return true;
			}
		}else {
			return false;
		}
		return false;
	}
	private boolean isChronicDisAbilities(Enrollment enrollment) {
		Set<Disabilities> disabilitieses = enrollment.getDisabilitieses();
		if(disabilitieses !=null) {
			for(Disabilities disabilities : disabilitieses) {
				Integer disabilityType = new Integer(disabilities.getDisabilitytype().getValue()) ;
				if(disabilityType >= 5 && disabilityType <= 10  &&
				 DisabilitiesIndefiniteandimpairsEnum.ONE.equals(disabilities.getDisabilitytype())) {
					return true;
				} 
			}
		}
		return false;
	}
}
