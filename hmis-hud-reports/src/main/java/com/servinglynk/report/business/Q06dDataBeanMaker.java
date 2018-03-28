package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q06dDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.ProjectModel;

/***
 * https://www.hudexchange.info/resources/documents/HMIS-Standard-Reporting-Terminology-Glossary.pdf
 * Rules
• This question applies to adults and heads of household active in the date range who started in the project
any time after 10/1/2016, which was when element 3.917 was restructured to improve data entry. Apply an
extra filter of [project start date] >= 10/1/2016 to all records for this question.
• Row 2 reports on adults and heads of household active in Street Outreach, Emergency Shelter or Safe Haven
([Project Type] = 1, 4, 8).
• Row 3 reports on adults and heads of household active in Transitional Housing ([Project Type] = 2).
• Row 4 reports on adults and heads of household active in all Permanent Housing types ([Project Type] = 3, 9,
10, 13).
• Column B: Count the total number of adults and heads of household.
• Column C: Count the number of adults and heads of household entering from institution who are missing
their [Length of stay]:
o [Type of residence] = 15, 6, 7, 24, 4, 5 AND
o [Length of stay in prior living situation] = 8, 9, missing.
• Column D: Count the number of adults and heads of household entering from housing and other situations
who are missing their [Length of stay]:
o [Type of residence] = 14, 23, 21, 3, 22, 19, 25, 20, 26, 12, 13, 2, 8, 9, missing AND
o [Length of stay in prior living situation] = 8, 9, missing.
• Columns E, F and G report only on adults and heads of household expected to have answers in fields
3.917.3, .4, and .5 respectively.
o Row 2 – all active adults and heads of household.
o Rows 3 and 4 – active adults and heads of household where one of the following is true:
▪ [Type of Residence] = 16, 1, 18, 27.
▪ ([Type of residence] = 15, 6, 7, 24, 4, 5) AND ([Length of stay in prior living situation] = 10,
11, 2, or 3) AND ([On the night before did you stay on streets, ES, or SH] = 1).
▪ ([Type of residence] = 14, 23, 21, 3, 22, 19, 25, 20, 26, 12, 13, 2, 8, 9, missing) AND ([Length
of stay in prior living situation] = 10, 11) AND ([On the night before did you stay on streets,
ES, or SH] = 1).
• Column E: Count the number of adults and heads of household with responses 8, 9, or missing in
[approximate date started] (3.917.3).
• Column F: Count the number of adults and heads of household with responses 8, 9, or missing in [number
of times…] (3.917.4).
• Column G: Count the number of adults and heads of household with responses 8, 9, or missing in [number
of months...] (3.917.5).
• Column H: Count the unique number of adults and heads of household missing one or more responses in
columns C through G and divide by the total records in column B.
 * @return
 */
public class Q06dDataBeanMaker extends BaseBeanMaker{
	


	public static List<Q06dDataBean> getQ06DataBeanList(ReportData data){
		
		// Count the number of adults and heads of household entering from housing and other situations
			//who are missing their
		String[] missingesshArray = new String[] {"16", "1", "18", "27"};
		String[] missingTimeInHousingArray = new String[] { "14", "23", "21", "3", "22", "19", "25", "20", "26", "12", "13", "2", "8", "9","99"};
		String[] missingTimeInInstitutionArray = new String[] { "15", "6", "7", "24", "4", "5" };
		
		List<String> missingTimeInInstitution = Arrays.asList(missingTimeInInstitutionArray);
		List<String> missingessh = Arrays.asList(missingesshArray);
		String[] missingLengthOfStayInPriorLivingSituationArray = new String[] {"8","9","99"};
		List<String> missingTimeInHousing = Arrays.asList(missingTimeInHousingArray);
		List<String> missingLengthOfStayInPriorLivingSituation = Arrays.asList(missingLengthOfStayInPriorLivingSituationArray);
		String[] thLengthOfStayInPriorLivingSituationArray = new String[] {"10","11", "2", "3"};
		List<String> thLengthOfStayInPriorLivingSituation = Arrays.asList(thLengthOfStayInPriorLivingSituationArray);
		String[] phLengthOfStayInPriorLivingSituationArray = new String[] {"10","11"};
		List<String> phLengthOfStayInPriorLivingSituation = Arrays.asList(phLengthOfStayInPriorLivingSituationArray);
		
		List<EnrollmentModel> enrollments = data.getEnrollments();
		List<ProjectModel> projects = data.getProjects();
		List<ProjectModel> esshProjects =  projects.parallelStream().filter(project -> StringUtils.equals("1", project.getProjectType()) || StringUtils.equals("4", project.getProjectType()) ||  StringUtils.equals("8", project.getProjectType())  ).collect(Collectors.toList());
		List<String> esshProjectIds = new ArrayList<>();
		esshProjects.forEach(project -> { esshProjectIds.add(project.getProjectId()); });
		List<ProjectModel> transitionalHousingProjects = projects.parallelStream().filter(project -> StringUtils.equals("2", project.getProjectType())).collect(Collectors.toList());
		List<String> transitionalHousingProjectIds = new ArrayList<>();
		transitionalHousingProjects.forEach(project -> { transitionalHousingProjectIds.add(project.getProjectId()); });
		List<ProjectModel> permanentHousingProjects = projects.parallelStream().filter(project -> StringUtils.equals("3", project.getProjectType()) || StringUtils.equals("9", project.getProjectType()) || StringUtils.equals("10", project.getProjectType()) || StringUtils.equals("13", project.getProjectType()) ).collect(Collectors.toList());
		List<String> permanentHousingProjectIds = new ArrayList<>();
		permanentHousingProjects.forEach(project -> { permanentHousingProjectIds.add(project.getProjectId()); });
	
		List<EnrollmentModel> adultAndHoh = enrollments.parallelStream().filter(enrollment -> enrollment.getEntrydate().compareTo(chCutoffDate) > 0  && (StringUtils.equals("1", enrollment.getRelationshiptohoh()) || enrollment.getAgeatentry() > 18)).collect(Collectors.toList());
		
		//Adults and HOH belonging to esshProjects
		//select e.* from enrollment e, project p, coc c where e.project_id = p.project_id and p.project_id =c.projectid and p.projecttype in ('1','4','8') and c.source_system_id='CA-506'
		//Column B
		List<EnrollmentModel> b2 = adultAndHoh.parallelStream().filter(enrollment -> esshProjectIds.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> b3 = adultAndHoh.parallelStream().filter(enrollment -> transitionalHousingProjects.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> b4 = adultAndHoh.parallelStream().filter(enrollment -> permanentHousingProjects.contains(enrollment.getProjectID())).collect(Collectors.toList());
		//Column C
		// 15, 6, 7, 24, 4, 5 
		List<EnrollmentModel> c2 = b2.parallelStream().filter(enrollment -> missingTimeInInstitution.contains(enrollment.getLivingSituation()) && missingLengthOfStayInPriorLivingSituation.contains(enrollment.getResidencepriorlengthofstay())).collect(Collectors.toList());
		List<EnrollmentModel> c3 = b3.parallelStream().filter(enrollment -> missingTimeInInstitution.contains(enrollment.getLivingSituation()) && missingLengthOfStayInPriorLivingSituation.contains(enrollment.getResidencepriorlengthofstay())).collect(Collectors.toList());
		List<EnrollmentModel> c4 = b4.parallelStream().filter(enrollment -> missingTimeInInstitution.contains(enrollment.getLivingSituation()) && missingLengthOfStayInPriorLivingSituation.contains(enrollment.getResidencepriorlengthofstay())).collect(Collectors.toList());
		//Column D
		// 14, 23, 21, 3, 22, 19, 25, 20, 26, 12, 13, 2, 8, 9, missing AND
		List<EnrollmentModel> d2 = b2.parallelStream().filter(enrollment -> missingTimeInHousing.contains(enrollment.getLivingSituation()) && missingLengthOfStayInPriorLivingSituation.contains(enrollment.getResidencepriorlengthofstay())).collect(Collectors.toList());
		List<EnrollmentModel> d3 = b3.parallelStream().filter(enrollment -> missingTimeInHousing.contains(enrollment.getLivingSituation()) && missingLengthOfStayInPriorLivingSituation.contains(enrollment.getResidencepriorlengthofstay())).collect(Collectors.toList());
		List<EnrollmentModel> d4  = b4.parallelStream().filter(enrollment -> missingTimeInHousing.contains(enrollment.getLivingSituation()) && missingLengthOfStayInPriorLivingSituation.contains(enrollment.getResidencepriorlengthofstay())).collect(Collectors.toList());
		//Column E 
		//3.917.3 (Approximate Date started) missing 
		// row 2  = 
		List<EnrollmentModel> e2 = adultAndHoh.parallelStream().filter(enrollment -> enrollment.getDatetostreetessh() == null && missingessh.contains(enrollment.getLivingSituation())).collect(Collectors.toList());
		//row 3
		List<EnrollmentModel> e3 = adultAndHoh.parallelStream().filter(enrollment -> enrollment.getDatetostreetessh() ==null && thLengthOfStayInPriorLivingSituation.contains(enrollment.getResidencepriorlengthofstay()) && missingTimeInHousing.contains(enrollment.getLivingSituation()) ).collect(Collectors.toList());
		//row 4
		List<EnrollmentModel> e4 = adultAndHoh.parallelStream().filter(enrollment -> enrollment.getDatetostreetessh() ==null && missingTimeInHousing.contains(enrollment.getLivingSituation())).collect(Collectors.toList());
		
		//Column F
		//3.917.4 (TimeHomeless) missing 
		//row 2
		List<EnrollmentModel> f2 = adultAndHoh.parallelStream().filter(enrollment -> (enrollment.getTimeshomelesspastthreeyears() == null  || missingLengthOfStayInPriorLivingSituation.contains(enrollment.getTimeshomelesspastthreeyears())) && missingessh.contains(enrollment.getLivingSituation())).collect(Collectors.toList());
		//row 3
		List<EnrollmentModel> f3 = adultAndHoh.parallelStream().filter(enrollment -> (enrollment.getTimeshomelesspastthreeyears() == null  || missingLengthOfStayInPriorLivingSituation.contains(enrollment.getTimeshomelesspastthreeyears()))  && missingTimeInInstitution.contains(enrollment.getLivingSituation()) &&  thLengthOfStayInPriorLivingSituation.contains(enrollment.getTimeshomelesspastthreeyears())).collect(Collectors.toList());
		//row 4
		List<EnrollmentModel> f4 = adultAndHoh.parallelStream().filter(enrollment -> (enrollment.getTimeshomelesspastthreeyears() == null  || missingLengthOfStayInPriorLivingSituation.contains(enrollment.getTimeshomelesspastthreeyears()))  && missingTimeInHousing.contains(enrollment.getLivingSituation()) && phLengthOfStayInPriorLivingSituation.contains(enrollment.getResidencepriorlengthofstay())).collect(Collectors.toList());
			
		//Column G
		//3.917.5 (Months Homeless in the past 3 years) missing 
		//row 2
		List<EnrollmentModel> g2 = adultAndHoh.parallelStream().filter(enrollment ->  (enrollment.getMonthshomelesspastthreeyears() == null  || missingLengthOfStayInPriorLivingSituation.contains(enrollment.getMonthshomelesspastthreeyears())) && missingessh.contains(enrollment.getLivingSituation())).collect(Collectors.toList());
		//row 3
		List<EnrollmentModel> g3 = adultAndHoh.parallelStream().filter(enrollment -> (enrollment.getMonthshomelesspastthreeyears() == null  || missingLengthOfStayInPriorLivingSituation.contains(enrollment.getMonthshomelesspastthreeyears()))  && missingTimeInInstitution.contains(enrollment.getLivingSituation()) && thLengthOfStayInPriorLivingSituation.contains(enrollment.getTimeshomelesspastthreeyears())).collect(Collectors.toList());
		//row 4
		List<EnrollmentModel> g4 = adultAndHoh.parallelStream().filter(enrollment -> enrollment.getMonthshomelesspastthreeyears() == null  || missingLengthOfStayInPriorLivingSituation.contains(enrollment.getMonthshomelesspastthreeyears()) && missingTimeInHousing.contains(enrollment.getLivingSituation()) && phLengthOfStayInPriorLivingSituation.contains(enrollment.getResidencepriorlengthofstay())).collect(Collectors.toList());
		
		int b2Value = b2 !=null ? b2.size() : 0;
		int b3Value = b3 !=null ? b3.size() : 0;
		int b4Value = b4 !=null ? b4.size() : 0;
		
		int c2Value = c2 != null? c2.size() : 0;
		int c3Value = c3 != null? c3.size() : 0;
		int c4Value = c4 != null? c4.size() : 0;
		
		int d2Value = d2 != null? d2.size() : 0;
		int d3Value = d3 != null? d3.size() : 0;
		int d4Value = d4 != null? d4.size() : 0;
		
		int e2Value = e2 != null? e2.size() : 0;
		int e3Value = e3 != null? e3.size() : 0;
		int e4Value = e4 != null? e4.size() : 0;
		
		int f2Value = f2 != null? f2.size() : 0;
		int f3Value = f3 != null? f3.size() : 0;
		int f4Value = f4 != null? f4.size() : 0;
		
		int g2Value = g2 != null? g2.size() : 0;
		int g3Value = g3 != null? g3.size() : 0;
		int g4Value = g4 != null? g4.size() : 0;
		
		int b5Value = b2Value + b3Value + b4Value;
	
		int h2Value = b2Value != 0 ? (c2Value+d2Value+e2Value+f2Value+g2Value)/b2Value : 0;
		int h3Value = b3Value !=0 ? (c3Value+d3Value+e3Value+f3Value+g3Value)/b3Value : 0;
		int h4Value = b4Value !=0 ? (c4Value+d4Value+e4Value+f4Value+g4Value)/b4Value : 0;
		
		Q06dDataBean q06dDataBean =new Q06dDataBean();
		q06dDataBean.setEsshCountOfTotalRecords(BigInteger.valueOf(b2Value));
		q06dDataBean.setEsshMissingTimeInInstitution(BigInteger.valueOf(c2Value));
		q06dDataBean.setEsshMissingTimeInHousing(BigInteger.valueOf(d2Value));
		q06dDataBean.setEsshApproximateDateStarted(BigInteger.valueOf(e2Value));
		q06dDataBean.setEsshnumberOfTimesDKR(BigInteger.valueOf(f2Value));
		q06dDataBean.setEsshNumberOfMonthsDKR(BigInteger.valueOf(g2Value));
		q06dDataBean.setEsshPercentOfRecords(BigInteger.valueOf(h2Value));
		q06dDataBean.setThCountOfTotalRecords(BigInteger.valueOf(b3Value));
		q06dDataBean.setThMissingTimeInInstitution(BigInteger.valueOf(c3Value));
		q06dDataBean.setThMissingTimeInHousing(BigInteger.valueOf(d3Value));
		q06dDataBean.setThApproximateDateStarted(BigInteger.valueOf(e3Value));
		q06dDataBean.setThnumberOfTimesDKR(BigInteger.valueOf(f3Value));
		q06dDataBean.setThNumberOfMonthsDKR(BigInteger.valueOf(g3Value));
		q06dDataBean.setThPercentOfRecords(BigInteger.valueOf(h3Value));
		q06dDataBean.setPhCountOfTotalRecords(BigInteger.valueOf(b4Value));
		q06dDataBean.setPhMissingTimeInInstitution(BigInteger.valueOf(c4Value));
		q06dDataBean.setPhMissingTimeInHousing(BigInteger.valueOf(d4Value));
		q06dDataBean.setPhApproximateDateStarted(BigInteger.valueOf(e4Value));
		q06dDataBean.setPhnumberOfTimesDKR(BigInteger.valueOf(f4Value));
		q06dDataBean.setPhNumberOfMonthsDKR(BigInteger.valueOf(g4Value ));
		q06dDataBean.setPhPercentOfRecords(BigInteger.valueOf(h4Value));
		
		q06dDataBean.setTotalCountOfTotalRecords(BigInteger.valueOf(b5Value));
		q06dDataBean.setTotalMissingTimeInInstitution(BigInteger.valueOf(0));
		q06dDataBean.setTotalMissingTimeInHousing(BigInteger.valueOf(0));
		q06dDataBean.setTotalApproximateDateStarted(BigInteger.valueOf(0));
		q06dDataBean.setTotalnumberOfTimesDKR(BigInteger.valueOf(0));
		q06dDataBean.setTotalNumberOfMonthsDKR(BigInteger.valueOf(0));
		q06dDataBean.setTotalPercentOfRecords(BigInteger.valueOf(0));	
		
		
		return Arrays.asList(q06dDataBean);
	}

}
