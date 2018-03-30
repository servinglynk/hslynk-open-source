package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q06fDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.ProjectModel;

public class Q06fDataBeanMaker extends BaseBeanMaker {


	public static List<Q06fDataBean> getQ06fDataBeanList(ReportData data){
		
		List<EnrollmentModel> enrollments = data.getEnrollments();
		List<String> clientIds = new ArrayList<String>(); 
		List<String> enrollmentIds = new ArrayList<String>(); 
		enrollments.parallelStream().forEach(enrollment -> { clientIds.add(enrollment.getPersonalID()); enrollmentIds.add(enrollment.getProjectEntryID());});
	
		List<ProjectModel> projects = data.getProjects();
		
		List<ProjectModel> filteredProjects = projects.parallelStream().filter(project -> (StringUtils.equals("3",project.getProjectType()) && StringUtils.equals("3", project.getTrackingMethod())) || StringUtils.equals("4",project.getProjectType())).collect(Collectors.toList());
		List<String> projectIds = new ArrayList<String>(); 
		filteredProjects.parallelStream().forEach(project -> { projectIds.add(project.getProjectId()); });
		enrollments.parallelStream().forEach(enrollment -> { 
			if (projectIds.contains(enrollment.getProjectID()))  {
			enrollmentIds.add(enrollment.getProjectEntryID());
			}
		});
        // select count(*) from client c, enrollment e, project p where c.personal_id = e.client_id and e.projectid =p.project_id and  ((p.project_type='1'
		// and p.trackingMethod = 3) or project_ype=4
		
		Q06fDataBean q06fDataBean =new Q06fDataBean();
		
		q06fDataBean.setContactNumberOfRecords(BigInteger.valueOf(0));
		q06fDataBean.setContactNumberOfInactiveRecords(BigInteger.valueOf(0));
		q06fDataBean.setContactPercentOfInactiveRecords(BigInteger.valueOf(0));
		q06fDataBean.setBedNightNumberOfRecords(BigInteger.valueOf(0));
		q06fDataBean.setBedNightNumberOfInactiveRecords(BigInteger.valueOf(0));
		q06fDataBean.setBedNightPercentOfInactiveRecords(BigInteger.valueOf(0));
		
		return Arrays.asList(q06fDataBean);
	}
	



	


}
