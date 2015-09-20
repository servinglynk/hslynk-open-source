package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;
														
																


public class Exit {
	@MapToColumn(column=0)
	private String ExitID;
	@MapToColumn(column=1)
	private String ProjectEntryID;
	@MapToColumn(column=2)
	private String PersonalID;
	@MapToColumn(column=3)
	private String ExitDate;
	@MapToColumn(column=4)
	private String Destination;
	@MapToColumn(column=5)
	private String OtherDestination;
	@MapToColumn(column=6)
	private String AssessmentDisposition;
	@MapToColumn(column=7)
	private String OtherDisposition;
	@MapToColumn(column=8)
	private String HousingAssessment;
	@MapToColumn(column=9)
	private String SubsidyInformation;
	@MapToColumn(column=10)
	private String ConnectionWithSOAR;
	@MapToColumn(column=11)
	private String WrittenAftercarePlan;
	@MapToColumn(column=12)
	private String AssistanceMainstreamBenefits;
	@MapToColumn(column=13)
	private String PermanentHousingPlacement;
	@MapToColumn(column=14)
	private String TemporaryShelterPlacement;
	@MapToColumn(column=15)
	private String ExitCounseling;
	@MapToColumn(column=16)
	private String FurtherFollowUpServices;
	@MapToColumn(column=17)
	private String ScheduledFollowupContacts;
	@MapToColumn(column=18)
	private String ResourcePackage;
	@MapToColumn(column=19)
	private String OtherAftercarePlanOrAction;
	@MapToColumn(column=20)
	private String ProjectCompletionStatus;
	@MapToColumn(column=21)
	private String EarlyExitReason;
	@MapToColumn(column=22)
	private String FamilyReunificationAchieved;
	@MapToColumn(column=23)
	private String DateCreated;
	@MapToColumn(column=24)
	private String DateUpdated;
	@MapToColumn(column=25)
	private String UserID;
	@MapToColumn(column=26)
	private String DateDeleted;
	@MapToColumn(column=27)
	private String ExportID;
		
}
