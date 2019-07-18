package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.report.bean.Q13c2NumberOfConditionsForStayerDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.DisabilitiesModel;
import com.servinglynk.report.model.EnrollmentModel;

public class Q13c2BeanMaker extends BaseBeanMaker {

	public static List<Q13c2NumberOfConditionsForStayerDataBean> getQ13c2NumberOfConditionsForStayerList(
			ReportData data) {

		Q13c2NumberOfConditionsForStayerDataBean q13c2Bean = new Q13c2NumberOfConditionsForStayerDataBean();
		if (data.isLiveMode()) {
			try {

				String query = "select dedup_client_id,count(dedup_client_id) as cnt from %s.disabilities d,%s.enrollment e where e.id = d.dedup_client_id and datacollectionstage in ('1','2','5') and ( disabilityresponse='1'  and ( disabilitytype='9' or disabilitytype='10' or  disabilitytype='7' or disabilitytype='8' or  disabilitytype='6') or  (disabilitytype='10' and disabilityresponse='3') ) and information_date <= :endDate ";

				List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
				List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
				List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
				List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();

				List<EnrollmentModel> enrollments = data.getStayers();
				List<EnrollmentModel> enrollmentsHHWithChildren = enrollments.parallelStream()
						.filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());
				List<EnrollmentModel> enrollmentsHHWithOutChildren = enrollments.parallelStream()
						.filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());
				List<EnrollmentModel> enrollmentsHHWithOneAdultChild = enrollments.parallelStream()
						.filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());
				List<EnrollmentModel> enrollmentsUnknownHouseHold = enrollments.parallelStream()
						.filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());

				BigInteger totalUHHT = BigInteger.ZERO;
				BigInteger totalWCA = BigInteger.ZERO;
				BigInteger totalWithOnlyChild = BigInteger.ZERO;
				BigInteger totalWOC = BigInteger.ZERO;
				BigInteger overallTotal = BigInteger.ZERO;
				java.sql.Date sqlDate = new java.sql.Date(data.getReportEndDate().getTime());
				List<DisabilitiesModel> disabilities = getEnrollmentFromDisabilitiesCountWithDate(data.getSchema(),
						query, data);
				List<DisabilitiesModel> just1 = disabilities.parallelStream()
						.filter(disability -> disability.getDisabilityCount() == 1).collect(Collectors.toList());
				if (CollectionUtils.isNotEmpty(just1)) {
					List<DisabilitiesModel> withChildren = just1.parallelStream()
							.filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());
					List<DisabilitiesModel> withOutChildren = just1.parallelStream().filter(
							enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());
					List<DisabilitiesModel> unknownHouseHold = just1.parallelStream().filter(
							enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());
					List<DisabilitiesModel> withOneAdultChild = just1.parallelStream().filter(
							enrollment -> enrollmentsHHWithOneAdultChild.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());

					int withOutChildrenIntSize = withOutChildren != null ? withOutChildren.size() : 0;
					int withOneAdultChildIntSize = withOneAdultChild != null ? withOneAdultChild.size() : 0;
					int withChildrenIntSize = withChildren != null ? withChildren.size() : 0;
					int unknownHouseHoldIntSize = unknownHouseHold != null ? unknownHouseHold.size() : 0;

					overallTotal = overallTotal.add(BigInteger.valueOf(just1.size()));
					totalWithOnlyChild = totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
					totalWOC = totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
					totalWCA = totalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
					totalUHHT = totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));

					q13c2Bean.setQ13c2Condition1Total(BigInteger.valueOf(just1.size()));
					q13c2Bean.setQ13c2Condition1WithoutChildren(BigInteger.valueOf(withChildrenIntSize));
					q13c2Bean.setQ13c2Condition1WithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
					q13c2Bean.setQ13c2Condition1WithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
					q13c2Bean.setQ13c2Condition1UnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
				}

				List<DisabilitiesModel> just2 = disabilities.parallelStream()
						.filter(disability -> disability.getDisabilityCount() == 2).collect(Collectors.toList());
				if (CollectionUtils.isNotEmpty(just2)) {
					List<DisabilitiesModel> withChildren = just2.parallelStream()
							.filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());
					List<DisabilitiesModel> withOutChildren = just2.parallelStream().filter(
							enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());
					List<DisabilitiesModel> unknownHouseHold = just2.parallelStream().filter(
							enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());
					List<DisabilitiesModel> withOneAdultChild = just2.parallelStream().filter(
							enrollment -> enrollmentsHHWithOneAdultChild.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());

					int withOutChildrenIntSize = withOutChildren != null ? withOutChildren.size() : 0;
					int withOneAdultChildIntSize = withOneAdultChild != null ? withOneAdultChild.size() : 0;
					int withChildrenIntSize = withChildren != null ? withChildren.size() : 0;
					int unknownHouseHoldIntSize = unknownHouseHold != null ? unknownHouseHold.size() : 0;

					overallTotal = overallTotal.add(BigInteger.valueOf(just2.size()));
					totalWithOnlyChild = totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
					totalWOC = totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
					totalWCA = totalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
					totalUHHT = totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));

					q13c2Bean.setQ13c2Condition2Total(BigInteger.valueOf(just2.size()));
					q13c2Bean.setQ13c2Condition2WithoutChildren(BigInteger.valueOf(withChildrenIntSize));
					q13c2Bean.setQ13c2Condition2WithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
					q13c2Bean.setQ13c2Condition2WithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
					q13c2Bean.setQ13c2Condition2UnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
				}

				List<DisabilitiesModel> plus3 = disabilities.parallelStream()
						.filter(disability -> disability.getDisabilityCount() >= 3).collect(Collectors.toList());
				if (CollectionUtils.isNotEmpty(plus3)) {
					List<DisabilitiesModel> withChildren = plus3.parallelStream()
							.filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());
					List<DisabilitiesModel> withOutChildren = plus3.parallelStream().filter(
							enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());
					List<DisabilitiesModel> unknownHouseHold = plus3.parallelStream().filter(
							enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());
					List<DisabilitiesModel> withOneAdultChild = plus3.parallelStream().filter(
							enrollment -> enrollmentsHHWithOneAdultChild.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());

					int withOutChildrenIntSize = withOutChildren != null ? withOutChildren.size() : 0;
					int withOneAdultChildIntSize = withOneAdultChild != null ? withOneAdultChild.size() : 0;
					int withChildrenIntSize = withChildren != null ? withChildren.size() : 0;
					int unknownHouseHoldIntSize = unknownHouseHold != null ? unknownHouseHold.size() : 0;

					overallTotal = overallTotal.add(BigInteger.valueOf(plus3.size()));
					totalWithOnlyChild = totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
					totalWOC = totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
					totalWCA = totalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
					totalUHHT = totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));

					q13c2Bean.setQ13c2Condition3PlusTotal(BigInteger.valueOf(plus3.size()));
					q13c2Bean.setQ13c2Condition3PlusWithoutChildren(BigInteger.valueOf(withChildrenIntSize));
					q13c2Bean.setQ13c2Condition3PlusWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
					q13c2Bean.setQ13c2Condition3PlusWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
					q13c2Bean.setQ13c2Condition3PlusUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
				}

				String noneQuery = "select dedup_client_id,count(dedup_client_id) as cnt from %s.disabilities d,%s.enrollment e where e.id = d.dedup_client_id and  datacollectionstage in ('1','2','5') and disabilityresponse='0'  and information_date >= :startDate and information_date <= :endDate  ";
				List<DisabilitiesModel> disabilitiesNone = getEnrollmentFromDisabilitiesCountWithDate(data.getSchema(),
						noneQuery, data);
				if (CollectionUtils.isNotEmpty(disabilitiesNone)) {
					List<DisabilitiesModel> withChildren = disabilitiesNone.parallelStream()
							.filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());
					List<DisabilitiesModel> withOutChildren = disabilitiesNone.parallelStream().filter(
							enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());
					List<DisabilitiesModel> unknownHouseHold = disabilitiesNone.parallelStream().filter(
							enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());
					List<DisabilitiesModel> withOneAdultChild = disabilitiesNone.parallelStream().filter(
							enrollment -> enrollmentsHHWithOneAdultChild.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());

					int withOutChildrenIntSize = withOutChildren != null ? withOutChildren.size() : 0;
					int withOneAdultChildIntSize = withOneAdultChild != null ? withOneAdultChild.size() : 0;
					int withChildrenIntSize = withChildren != null ? withChildren.size() : 0;
					int unknownHouseHoldIntSize = unknownHouseHold != null ? unknownHouseHold.size() : 0;

					overallTotal = overallTotal.add(BigInteger.valueOf(disabilitiesNone.size()));
					totalWithOnlyChild = totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
					totalWOC = totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
					totalWCA = totalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
					totalUHHT = totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));

					q13c2Bean.setQ13c2NoneTotal(BigInteger.valueOf(disabilitiesNone.size()));
					q13c2Bean.setQ13c2NoneWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
					q13c2Bean.setQ13c2NoneWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
					q13c2Bean.setQ13c2NoneWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
					q13c2Bean.setQ13c2NoneUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
				}

				String unknownQuery = "select dedup_client_id,count(dedup_client_id) as cnt from %s.disabilities d,%s.enrollment e where e.id = d.dedup_client_id and datacollectionstage in ('1','2','5') and ( disabilityresponse='8' or disabilityresponse='9') and information_date <= :endDate  ";
				List<DisabilitiesModel> disabilitiesUnknown = getEnrollmentFromDisabilitiesCountWithDate(
						data.getSchema(), unknownQuery, data);
				if (CollectionUtils.isNotEmpty(disabilitiesUnknown)) {
					List<DisabilitiesModel> withChildren = disabilitiesNone.parallelStream()
							.filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());
					List<DisabilitiesModel> withOutChildren = disabilitiesNone.parallelStream().filter(
							enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());
					List<DisabilitiesModel> unknownHouseHold = disabilitiesNone.parallelStream().filter(
							enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());
					List<DisabilitiesModel> withOneAdultChild = disabilitiesNone.parallelStream().filter(
							enrollment -> enrollmentsHHWithOneAdultChild.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());

					int withOutChildrenIntSize = withOutChildren != null ? withOutChildren.size() : 0;
					int withOneAdultChildIntSize = withOneAdultChild != null ? withOneAdultChild.size() : 0;
					int withChildrenIntSize = withChildren != null ? withChildren.size() : 0;
					int unknownHouseHoldIntSize = unknownHouseHold != null ? unknownHouseHold.size() : 0;

					overallTotal = overallTotal.add(BigInteger.valueOf(disabilitiesUnknown.size()));
					totalWithOnlyChild = totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
					totalWOC = totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
					totalWCA = totalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
					totalUHHT = totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));

					q13c2Bean.setQ13c2DontKnowRefusedTotal(BigInteger.valueOf(disabilitiesUnknown.size()));
					q13c2Bean.setQ13c2DontKnowRefusedWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
					q13c2Bean.setQ13c2DontKnowRefusedWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
					q13c2Bean.setQ13c2DontKnowRefusedWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
					q13c2Bean.setQ13c2DontKnowRefusedUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
				}

				String infoMissingQuery = "select dedup_client_id,count(dedup_client_id) as cnt from %s.disabilities d,%s.enrollment e where e.id = d.dedup_client_id and datacollectionstage in ('1','2','5') and disabilityresponse='99' and information_date <= :endDate ";
				List<DisabilitiesModel> disabilitiesMissing = getEnrollmentFromDisabilitiesCountWithDate(
						data.getSchema(), infoMissingQuery, data);
				if (CollectionUtils.isNotEmpty(disabilitiesMissing)) {
					List<DisabilitiesModel> withChildren = disabilitiesMissing.parallelStream()
							.filter(enrollment -> enrollmentsHHWithChildren.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());
					List<DisabilitiesModel> withOutChildren = disabilitiesMissing.parallelStream().filter(
							enrollment -> enrollmentsHHWithOutChildren.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());
					List<DisabilitiesModel> unknownHouseHold = disabilitiesMissing.parallelStream().filter(
							enrollment -> enrollmentsUnknownHouseHold.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());
					List<DisabilitiesModel> withOneAdultChild = disabilitiesMissing.parallelStream().filter(
							enrollment -> enrollmentsHHWithOneAdultChild.contains(enrollment.getDedupClientId()))
							.collect(Collectors.toList());

					int withOutChildrenIntSize = withOutChildren != null ? withOutChildren.size() : 0;
					int withOneAdultChildIntSize = withOneAdultChild != null ? withOneAdultChild.size() : 0;
					int withChildrenIntSize = withChildren != null ? withChildren.size() : 0;
					int unknownHouseHoldIntSize = unknownHouseHold != null ? unknownHouseHold.size() : 0;

					overallTotal = overallTotal.add(BigInteger.valueOf(disabilitiesMissing.size()));
					totalWithOnlyChild = totalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
					totalWOC = totalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
					totalWCA = totalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
					totalUHHT = totalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));

					q13c2Bean.setQ13c2InformationmissingTotal(BigInteger.valueOf(disabilitiesMissing.size()));
					q13c2Bean.setQ13c2InformationmissingWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
					q13c2Bean
							.setQ13c2InformationmissingWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
					q13c2Bean.setQ13c2InformationmissingWithOnlychildren(BigInteger.valueOf(withChildrenIntSize));
					q13c2Bean.setQ13c2InformationmissingUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
				}
				q13c2Bean.setQ13c2TotalSummed(BigInteger.valueOf(getSize(data.getActiveClients())));
				q13c2Bean.setQ13c2TotalWithoutChildren(totalWOC);
				q13c2Bean.setQ13c2TotalWithChildAndAdults(totalWCA);
				q13c2Bean.setQ13c2TotalWithOnlychildren(totalWithOnlyChild);
				q13c2Bean.setQ13c2TotalUnknowHousehold(totalUHHT);
			} catch (Exception e) {
				logger.error("Error in Q13c2BeanMaker:" + e);
			}
		}
		return Arrays.asList(q13c2Bean);
	}

}
