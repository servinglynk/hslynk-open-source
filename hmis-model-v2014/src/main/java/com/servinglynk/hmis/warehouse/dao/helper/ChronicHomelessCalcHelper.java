package com.servinglynk.hmis.warehouse.dao.helper;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.enums.DisabilitiesDisabilitytypeEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesIndefiniteandimpairsEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentDisablingconditionEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentMonthshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentTimeshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Disabilities;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;

@Component
public class ChronicHomelessCalcHelper {
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
	public Boolean isClientChronicallyHomeless(Enrollment enrollment) {
	/*	
		boolean chronicHomeless;
		if(enrollment !=null) {
			if(enrollment.getAgeAtEntry()>=18) {
			(	if( EnrollmentDisablingconditionEnum.ONE.equals(enrollment.getDisablingcondition()))  {
					chronicHomeless = true;
					}
				or
				Set<Disabilities> disabilitieses = enrollment.getDisabilitieses();
				for(Disabilities disabilities : disabilitieses) {
					Integer disabilityType = new Integer(disabilities.getDisabilitytype().getValue()) ;
					if(disabilityType >= 5 && disabilityType <= 10  &&
					 DisabilitiesIndefiniteandimpairsEnum.ONE.equals(disabilities.getDisabilitytype())) {
						chronicHomeless = true;
					} 
					)
//					and 
//					(enrollment.getResidenceprior() should be 1 or 18 or 16 ) 
//					and
//					(enrollment.getContinuouslyhomelessoneyear() = 1 or 
					enrollment.getTimeshomelesspastthreeyears() == 4)
					
					}
				}
			}
		}
		*/
		return false;
	}
}
