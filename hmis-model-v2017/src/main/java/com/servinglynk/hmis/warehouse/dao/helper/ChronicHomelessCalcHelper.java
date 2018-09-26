package com.servinglynk.hmis.warehouse.dao.helper;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.enums.DisabilitiesIndefiniteandimpairsEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentDisablingconditionEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorlengthofstayEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentTimeshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectProjecttypeEnum;
import com.servinglynk.hmis.warehouse.enums.RecordTypeEnum;
import com.servinglynk.hmis.warehouse.model.v2017.Disabilities;
import com.servinglynk.hmis.warehouse.model.v2017.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral;

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
					return validateDiffInDays(enrollment,enrollment.getEntrydate());
				}
				
			    if(EnrollmentResidencepriorEnum.ONE.equals(enrollment.getLivingSituation())
					  || EnrollmentResidencepriorEnum.SIXTEEN.equals(enrollment.getLivingSituation())
					  || EnrollmentResidencepriorEnum.EIGHTEEN.equals(enrollment.getLivingSituation())
					  || EnrollmentResidencepriorEnum.TWENTY_SEVEN.equals(enrollment.getLivingSituation())) {
						return validateDiffInDays(enrollment,enrollment.getEntrydate());
				}
			    
			    if(EnrollmentResidencepriorEnum.FIFTEEN.equals(enrollment.getLivingSituation())
							|| EnrollmentResidencepriorEnum.SIX.equals(enrollment.getLivingSituation())
							|| EnrollmentResidencepriorEnum.SEVEN.equals(enrollment.getLivingSituation())
							|| EnrollmentResidencepriorEnum.TWENTY_FOUR.equals(enrollment.getLivingSituation())
							|| EnrollmentResidencepriorEnum.FOUR.equals(enrollment.getLivingSituation())
							|| EnrollmentResidencepriorEnum.FIVE.equals(enrollment.getLivingSituation())) {
						if(enrollment.getLengthOfStay() !=null 
								&& ( EnrollmentResidencepriorlengthofstayEnum.TWO.equals(enrollment.getLengthOfStay()) 
								  || EnrollmentResidencepriorlengthofstayEnum.THREE.equals(enrollment.getLengthOfStay()) 
								  || EnrollmentResidencepriorlengthofstayEnum.TEN.equals(enrollment.getLengthOfStay()) 
								  || EnrollmentResidencepriorlengthofstayEnum.ELEVEN.equals(enrollment.getLengthOfStay()))) {
							return oNightBeforeESSH(enrollment);
						}
				}

			    if(EnrollmentResidencepriorEnum.THREE.equals(enrollment.getLivingSituation())
						|| EnrollmentResidencepriorEnum.TWO.equals(enrollment.getLivingSituation())
						|| EnrollmentResidencepriorEnum.TWELVE.equals(enrollment.getLivingSituation())
						|| EnrollmentResidencepriorEnum.THIRTEEN.equals(enrollment.getLivingSituation())
						|| EnrollmentResidencepriorEnum.FOURTEEN.equals(enrollment.getLivingSituation())
						|| EnrollmentResidencepriorEnum.NINTEEN.equals(enrollment.getLivingSituation())
						|| EnrollmentResidencepriorEnum.TWENTY.equals(enrollment.getLivingSituation())
						|| EnrollmentResidencepriorEnum.TWENTY_ONE.equals(enrollment.getLivingSituation())
						|| EnrollmentResidencepriorEnum.TWENTY_TWO.equals(enrollment.getLivingSituation())
						|| EnrollmentResidencepriorEnum.TWENTY_THREE.equals(enrollment.getLivingSituation())
						|| EnrollmentResidencepriorEnum.TWENTY_FIVE.equals(enrollment.getLivingSituation())
						|| EnrollmentResidencepriorEnum.TWENTY_SIX.equals(enrollment.getLivingSituation())
						|| EnrollmentResidencepriorEnum.EIGHT.equals(enrollment.getLivingSituation()) 
						|| EnrollmentResidencepriorEnum.NINE.equals(enrollment.getLivingSituation())
						|| EnrollmentResidencepriorEnum.NINTY_NINE.equals(enrollment.getLivingSituation())) {
						if(enrollment.getLengthOfStay() !=null 
								&& ( EnrollmentResidencepriorlengthofstayEnum.TEN.equals(enrollment.getLengthOfStay()) 
								  || EnrollmentResidencepriorlengthofstayEnum.ELEVEN.equals(enrollment.getLengthOfStay()) )) {
									return oNightBeforeESSH(enrollment);
						     }
			    	}
		  	  }
			}
		return false;
	}
	

	private boolean oNightBeforeESSH(Enrollment enrollment) {
		for(ServiceFaReferral service : enrollment.getServiceFaReferrals()) {
			RecordTypeEnum recordType = service.getRecordType();
			if(RecordTypeEnum.THIRTEEN.equals(recordType)) {
				Integer typeProvided = service.getTypeProvided();
				if(typeProvided != null) {
					if(typeProvided == 1) {
						return validateDiffInDays(enrollment,enrollment.getEntrydate());
					}
				}
			}
		}
		return false;
	}
	
	private long diffInDays(LocalDateTime a, LocalDateTime localDateTime) {
		  return ChronoUnit.DAYS.between(a, localDateTime);
		}
	
	private boolean validateDiffInDays(Enrollment enrollment, LocalDateTime date) {
		if(enrollment.getEntrydate() !=null && diffInDays(LocalDateTime.now(),date) > 365) {
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
