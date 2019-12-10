package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.BaseCSV;
import com.servinglynk.hmis.warehouse.csv.IncomeBenefits;
import com.servinglynk.hmis.warehouse.model.v2020.Client;
import com.servinglynk.hmis.warehouse.model.v2020.ConnectionWithSoar;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2020.Healthinsurance;
import com.servinglynk.hmis.warehouse.model.v2020.Medicalassistance;
import com.servinglynk.hmis.warehouse.model.v2020.Noncashbenefits;

@Component
public class IncomeBenefitsCsvConverter extends BaseCsvConverter {

	public IncomeBenefits entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.Incomeandsources entity) {
		IncomeBenefits model = new IncomeBenefits();
		model.setIncomeBenefitsID(getId(entity.getId()));
		if (entity.getInformationDate() != null)
			model.setInformationDate(getDate(entity.getInformationDate()));
		if (entity.getDataCollectionStage() != null)
			model.setDataCollectionStage(entity.getDataCollectionStage().getValue());

		if (entity.getAlimony() != null)
			model.setAlimony(entity.getAlimony().getValue());
		if (entity.getAlimonyamount() != null)
			model.setAlimonyAmount(String.valueOf(entity.getAlimonyamount().floatValue()));
		if (entity.getChildsupport() != null)
			model.setChildSupport(entity.getChildsupport().getValue());
		if (entity.getChildsupportamount() != null)
			model.setChildSupportAmount(String.valueOf(entity.getChildsupportamount().floatValue()));
		if (entity.getEarned() != null)
			model.setEarned(entity.getEarned().getValue());
		if (entity.getEarnedamount() != null)
			model.setEarnedAmount(String.valueOf(entity.getEarnedamount().floatValue()));
		if (entity.getGa() != null)
			model.setGA(entity.getGa().getValue());
		if (entity.getGaamount() != null)
			model.setGAAmount(String.valueOf(entity.getGaamount().floatValue()));
		if (entity.getIncomefromanysource() != null)
			model.setIncomeFromAnySource(entity.getIncomefromanysource().getValue());
		if (entity.getOthersource() != null)
			model.setOtherIncomeSource(entity.getOthersource().getValue());
		if (entity.getOthersourceamount() != null)
			model.setOtherIncomeAmount(String.valueOf(entity.getOthersourceamount().floatValue()));
		if (entity.getOthersourceidentify() != null)
			model.setOtherIncomeSourceIdentify(entity.getOthersourceidentify());
		if (entity.getPension() != null)
			model.setPension(entity.getPension().getValue());
		if (entity.getPensionamount() != null)
			model.setPensionAmount(String.valueOf(entity.getPensionamount().floatValue()));
		if (entity.getPrivatedisability() != null)
			model.setPrivateDisability(String.valueOf(entity.getPrivatedisability().getValue()));
		if (entity.getPrivatedisabilityamount() != null)
			model.setPrivateDisabilityAmount(String.valueOf(entity.getPrivatedisabilityamount().floatValue()));
		if (entity.getSocsecretirement() != null)
			model.setSocSecRetirement(entity.getSocsecretirement().getValue());
		if (entity.getSocsecretirementamount() != null)
			model.setSocSecRetirementAmount(String.valueOf(entity.getSocsecretirementamount().floatValue()));
		if (entity.getSsdi() != null)
			model.setSSDI(entity.getSsdi().getValue());
		if (entity.getSsdiamount() != null)
			model.setSSDIAmount(String.valueOf(entity.getSsdiamount().floatValue()));
		if (entity.getSsi() != null)
			model.setSSI(entity.getSsi().getValue());
		if (entity.getSsiamount() != null)
			model.setSSIAmount(String.valueOf(entity.getSsiamount().floatValue()));
		if (entity.getTanf() != null)
			model.setTANF(entity.getTanf().getValue());
		if (entity.getTanfamount() != null)
			model.setTANFAmount(String.valueOf(entity.getTanfamount().floatValue()));
		if (entity.getTotalmonthlyincome() != null)
			model.setTotalMonthlyIncome(String.valueOf(entity.getTotalmonthlyincome().floatValue()));
		if (entity.getUnemployment() != null)
			model.setUnemployment(entity.getUnemployment().getValue());
		if (entity.getUnemploymentamount() != null)
			model.setUnemploymentAmount(String.valueOf(entity.getUnemploymentamount().floatValue()));
		if (entity.getVadisabilitynonservice() != null)
			model.setVADisabilityNonService(entity.getVadisabilitynonservice().getValue());
		if (entity.getVadisabilitynonserviceamount() != null)
			model.setVADisabilityNonServiceAmount(
					String.valueOf(entity.getVadisabilitynonserviceamount().floatValue()));
		if (entity.getVadisabilityservice() != null)
			model.setVADisabilityService(entity.getVadisabilityservice().getValue());
		if (entity.getVadisabilityserviceamount() != null)
			model.setVADisabilityServiceAmount(String.valueOf(entity.getVadisabilityserviceamount().floatValue()));
		if (entity.getWorkerscomp() != null)
			model.setWorkersComp(entity.getWorkerscomp().getValue());
		if (entity.getWorkerscompamount() != null)
			model.setWorkersCompAmount(String.valueOf(entity.getWorkerscompamount().floatValue()));

		Enrollment enrollmentid = entity.getEnrollmentid();
		if (enrollmentid != null) {
			model.setEnrollmentID(getId(enrollmentid.getId()));

			Client client = enrollmentid.getClient();
			if (client != null)
				model.setPersonalID(getId(client.getId()));
		}
		if (entity.getUserId() != null)
			model.setUserID(entity.getUserId().toString());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if (entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());

		return model;
	}

	public IncomeBenefits connectionWithSoarToCsv(
			com.servinglynk.hmis.warehouse.model.v2020.ConnectionWithSoar entity) {
		IncomeBenefits model = new IncomeBenefits();
		model.setIncomeBenefitsID(getId(entity.getId()));

		if (entity.getConnectionwithsoar() != null)
			model.setConnectionWithSOAR(entity.getConnectionwithsoar().getValue());

		Enrollment enrollmentid = entity.getEnrollmentid();
		if (enrollmentid != null) {
			model.setEnrollmentID(getId(enrollmentid.getId()));

			Client client = enrollmentid.getClient();
			if (client != null)
				model.setPersonalID(getId(client.getId()));
		}
		if (entity.getUserId() != null)
			model.setUserID(entity.getUserId().toString());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if (entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());

		return model;
	}

	public IncomeBenefits noncashbenefitsToCsv(com.servinglynk.hmis.warehouse.model.v2020.Noncashbenefits entity) {
		IncomeBenefits model = new IncomeBenefits();
		model.setIncomeBenefitsID(getId(entity.getId()));

		if (entity.getBenefitsfromanysource() != null)
			model.setBenefitsFromAnySource(entity.getBenefitsfromanysource().getValue());
		if (entity.getOthersource() != null)
			model.setOtherBenefitsSource(entity.getOthersource().getValue());
		model.setOtherBenefitsSourceIdentify(entity.getOthersourceidentify());
		if (entity.getOthertanf() != null)
			model.setOtherTANF(entity.getOthertanf().getValue());

		// TODO: What happened to the below field
//		if(entity.getRentalassistanceongoing()!=null)
//		       model.set(entity.getRentalassistanceongoing().getValue()));

		if (entity.getSnap() != null)
			model.setSNAP(entity.getSnap().getValue());
		if (entity.getTanfchildcare() != null)
			model.setTANFChildCare(entity.getTanfchildcare().getValue());
		if (entity.getTanftransportation() != null)
			model.setTANFTransportation(entity.getTanftransportation().getValue());
		if (entity.getWic() != null)
			model.setWIC(entity.getWic().getValue());
		if (entity.getInformationDate() != null)
			model.setInformationDate(getDate(entity.getInformationDate()));
		if (entity.getDataCollectionStage() != null)
			model.setDataCollectionStage(entity.getDataCollectionStage().getValue());

		Enrollment enrollmentid = entity.getEnrollmentid();
		if (enrollmentid != null) {
			model.setEnrollmentID(getId(enrollmentid.getId()));

			Client client = enrollmentid.getClient();
			if (client != null)
				model.setPersonalID(getId(client.getId()));
		}
		if (entity.getUserId() != null)
			model.setUserID(entity.getUserId().toString());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if (entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());

		return model;
	}

	public IncomeBenefits healthinsuranceToCsv(com.servinglynk.hmis.warehouse.model.v2020.Healthinsurance entity) {
		IncomeBenefits model = new IncomeBenefits();
		model.setIncomeBenefitsID(getId(entity.getId()));

		if (entity.getInsurancefromanysource() != null)
			model.setIncomeFromAnySource(entity.getInsurancefromanysource().getValue());
		if (entity.getMedicaid() != null)
			model.setMedicaid(entity.getMedicaid().getValue());
		if (entity.getNomedicaidreason() != null)
			model.setNoMedicaidReason(entity.getNomedicaidreason().getValue());
		if (entity.getMedicare() != null)
			model.setMedicare(entity.getMedicare().getValue());
		if (entity.getNomedicarereason() != null)
			model.setNoMedicareReason(entity.getNomedicarereason().getValue());
		if (entity.getSchip() != null)
			model.setSCHIP(entity.getSchip().getValue());
		if (entity.getNoschipreason() != null)
			model.setNoSCHIPReason(entity.getNoschipreason().getValue());
		if (entity.getVamedicalservices() != null)
			model.setVAMedicalServices(entity.getVamedicalservices().getValue());
		if (entity.getNovamedreason() != null)
			model.setNoVAMedReason(entity.getNovamedreason().getValue());
		model.setEmployerProvided(String.valueOf(entity.getEmployerprovided()));
		if (entity.getNoemployerprovidedreason() != null)
			model.setNoEmployerProvidedReason(entity.getNoemployerprovidedreason().getValue());
		model.setCOBRA(String.valueOf(entity.getCobra()));
		if (entity.getNocobrareason() != null)
			model.setNoCOBRAReason(entity.getNocobrareason().getValue());
		if (entity.getPrivatepay() != null)
			model.setPrivatePay(entity.getPrivatepay().getValue());
		if (entity.getNoprivatepayreason() != null)
			model.setNoPrivatePayReason(entity.getNoprivatepayreason().getValue());
		if (entity.getStatehealthinadults() != null)
			model.setStateHealthIns(entity.getStatehealthinadults().getValue());
		if (entity.getNostatehealthinsreason() != null)
			model.setNoStateHealthInsReason(entity.getNostatehealthinsreason().getValue());
		if (entity.getOtherInsurance() != null)
			model.setOtherInsurance(entity.getOtherInsurance().getValue());
//				if (entity.getOtherInsuranceIdentify() != null)
//				model.setOtherInsuranceIdentify(entity.getOtherInsuranceIdentify());
		if (entity.getIndianHealthServices() != null)
			model.setIndianHealthServices(entity.getIndianHealthServices().getValue());
		if (entity.getNoIndianHealthServicesReason() != null)
			model.setNoIndianHealthServicesReason(entity.getNoIndianHealthServicesReason().getValue());

		if (entity.getInformationDate() != null)
			model.setInformationDate(getDate(entity.getInformationDate()));
		if (entity.getDataCollectionStage() != null)
			model.setDataCollectionStage(entity.getDataCollectionStage().getValue());

		Enrollment enrollmentid = entity.getEnrollmentid();
		if (enrollmentid != null) {
			model.setEnrollmentID(getId(enrollmentid.getId()));

			Client client = enrollmentid.getClient();
			if (client != null)
				model.setPersonalID(getId(client.getId()));
		}
		if (entity.getUserId() != null)
			model.setUserID(entity.getUserId().toString());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if (entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());

		return model;
	}

	public void writeToCSV(com.servinglynk.hmis.warehouse.model.v2020.Enrollment enrollment, boolean fillHeaders) {
		Set<com.servinglynk.hmis.warehouse.model.v2020.Incomeandsources> incomeAndSources = enrollment
				.getIncomeandsourceses();
		List<BaseCSV> baseCSVs = null;
		if (fillHeaders) {
			baseCSVs = getBaseCSVs(new IncomeBenefits());
		} else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		try {

			if (CollectionUtils.isNotEmpty(incomeAndSources)) {
				for (com.servinglynk.hmis.warehouse.model.v2020.Incomeandsources incomeAndSource : incomeAndSources) {
					baseCSVs.add(entityToCsv(incomeAndSource));
				}
			}
			Set<ConnectionWithSoar> connectionWithSoars = enrollment.getConnectionWithSoars();
			if (CollectionUtils.isNotEmpty(connectionWithSoars)) {
				for (com.servinglynk.hmis.warehouse.model.v2020.ConnectionWithSoar connectionWithSoar : connectionWithSoars) {
					baseCSVs.add(connectionWithSoarToCsv(connectionWithSoar));
				}
			}

			Set<Noncashbenefits> noncashbenefits = enrollment.getNoncashbenefitss();
			if (CollectionUtils.isNotEmpty(noncashbenefits)) {
				for (com.servinglynk.hmis.warehouse.model.v2020.Noncashbenefits noncashbenefit : noncashbenefits) {
					baseCSVs.add(noncashbenefitsToCsv(noncashbenefit));
				}
			}

			Set<Healthinsurance> healthinsurances = enrollment.getHealthinsurances();
			if (CollectionUtils.isNotEmpty(healthinsurances)) {
				for (com.servinglynk.hmis.warehouse.model.v2020.Healthinsurance healthinsurance : healthinsurances) {
					baseCSVs.add(healthinsuranceToCsv(healthinsurance));
				}
			}

			Set<Medicalassistance> medicalassistances = enrollment.getMedicalassistances();
			if (CollectionUtils.isNotEmpty(medicalassistances)) {
				for (com.servinglynk.hmis.warehouse.model.v2020.Medicalassistance medicalassistance : medicalassistances) {
					baseCSVs.add(medicalassistanceToCsv(medicalassistance));
				}
			}
			CsvFileWriter.writeToCsv("IncomeBenefits.csv", baseCSVs);
			fillHeaders = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

	private BaseCSV medicalassistanceToCsv(Medicalassistance entity) {

		IncomeBenefits model = new IncomeBenefits();
		model.setIncomeBenefitsID(getId(entity.getId()));

		if (entity.getHivaidsassistance() != null)
			model.setHIVAIDSAssistance(entity.getHivaidsassistance().getValue());
		if (entity.getNohivaidsassistancereason() != null)
			model.setNoHIVAIDSAssistanceReason(entity.getNohivaidsassistancereason().getValue());
		if (entity.getAdap() != null)
			model.setADAP(entity.getAdap().getValue());
		if (entity.getNoadapreason() != null)
			model.setNoADAPReason(entity.getNoadapreason().getValue());
		if (entity.getInformationDate() != null)
			model.setInformationDate(getDate(entity.getInformationDate()));
		if (entity.getDataCollectionStage() != null)
			model.setDataCollectionStage(entity.getDataCollectionStage().getValue());

		Enrollment enrollmentid = entity.getEnrollmentid();
		if (enrollmentid != null) {
			model.setEnrollmentID(getId(enrollmentid.getId()));

			Client client = enrollmentid.getClient();
			if (client != null)
				model.setPersonalID(getId(client.getId()));
		}
		if (entity.getUserId() != null)
			model.setUserID(entity.getUserId().toString());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if (entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());
		
		return model;
	}

}
