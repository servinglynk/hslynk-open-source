package com.servinglynk.hmis.warehouse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.base.dao.BaseDaoFactoryImpl;
import com.servinglynk.hmis.warehouse.csv.converter.AffiliationCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.AssessmentCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.AssessmentQuestionsCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.AssessmentResultsCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.ClientCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.CurrentLivingSituationCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.DisabilitiesCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.EmploymentEducationCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.EnrollmentCocCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.EnrollmentCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.EventCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.ExitCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.ExportCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.FunderCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.HealthAndDvCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.IncomeBenefitsCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.InventoryCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.OrganizationCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.ProjectCocCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.ProjectCsvConverter;
import com.servinglynk.hmis.warehouse.csv.converter.ServicesCsvConverter;

@Component
public class ParentDaoFactoryImpl extends BaseDaoFactoryImpl implements ParentDaoFactory {
	@Autowired
	private BulkUploaderDao bulkUploaderDao;
	@Autowired
	private DateofengagementDao dateofengagementDao;
	@Autowired
	private AffiliationDao affiliationDao;
	@Autowired
	private DisabilitiesDao disabilitiesDao;
	@Autowired
	private DomesticviolenceDao domesticviolenceDao;
	@Autowired
	private EmploymentDao employmentDao;
	@Autowired
	private EnrollmentDao enrollmentDao;
	@Autowired
	private EnrollmentCocDao enrollmentCocDao;
	@Autowired
	private ExitDao exitDao;
	@Autowired
	private ExithousingassessmentDao exithousingassessmentDao;
	@Autowired
	private FunderDao funderDao;
	@Autowired
	private HealthinsuranceDao healthinsuranceDao;
	@Autowired
	private HealthStatusDao healthStatusDao;
	// private HmisTypeDao
	// private HmisUserDao
	@Autowired
	private IncomeandsourcesDao incomeandsourcesDao;
	@Autowired
	private InventoryDao inventoryDao;
	@Autowired
	private MedicalassistanceDao medicalassistanceDao;
	@Autowired
	private NoncashbenefitsDao noncashbenefitsDao;
	@Autowired
	private PathstatusDao pathstatusDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private MoveindateDao residentialmoveindateDao;
	@Autowired
	private RhybcpstatusDao rhybcpstatusDao;
	@Autowired
	private SourceDao sourceDao;
	// private SyncDao
	@Autowired
	private ClientVeteranInfoDao veteranInfoDao;
	@Autowired
	private ExportDao exportDao;
	@Autowired
	private CocDao cocDao;
	@Autowired
	private ContactDao contactDao;
	@Autowired
	private EntryrhspDao entryrhspDao;
	@Autowired
	private EntryrhyDao entryrhyDao;
	@Autowired
	private EntryssvfDao entryssvfDao;
	@Autowired
	private ExitrhyDao exitrhyDao;
	@Autowired
	private ServiceFaReferralDao serviceFaReferralDao;
	@Autowired
	private OrganizationDao organizationDao;
	@Autowired
	private EducationDao educationDao; 
	@Autowired
	private VASHExitReasonDao vashExitReasonDao;
	@Autowired
	private RHYAfterCareDao rhyAfterCareDao;
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private ConnectionWithSoarDao connectionWithSoarDao;
	
	@Autowired
	private BulkUploadActivityDao bulkUploadActivityDao;
	
	@Autowired
	private BulkUploadErrorDao bulkUploadErrorDao;
	
	@Autowired private QuestionDao questionDao;
	
	@Autowired private HmisTypeDao hmisTypeDao; 
	
	@Autowired private AssessmentDao assessmentDao;
	
	@Autowired private AssessmentQuestionsDao assessmentQuestionsDao;
	
	@Autowired private AssessmentResultsDao assessmentResultsDao;

	@Autowired private CurrentLivingSituationDao currentLivingSituationDao;
	
	@Autowired private EventDao eventDao;
	
	@Autowired private ProjectCsvConverter projectCsvConverter;
	
	@Autowired private AffiliationCsvConverter affiliationCsvConverter;
	
	@Autowired private FunderCsvConverter funderCsvConverter;
	@Autowired private EnrollmentCsvConverter enrollmentCsvConverter;
	
	@Autowired private AssessmentCsvConverter assessmentCsvConverter;
	@Autowired private AssessmentQuestionsCsvConverter  assessmentQuestionsCsvConverter;
	@Autowired private AssessmentResultsCsvConverter  assessmentResultsCsvConverter;
	@Autowired private ClientCsvConverter clientCsvConverter;
	@Autowired private CurrentLivingSituationCsvConverter currentLivingSituationCsvConverter;
	@Autowired private DisabilitiesCsvConverter disabilitiesCsvConverter;
	@Autowired private EmploymentEducationCsvConverter employmentEducationCsvConverter;
	@Autowired private EnrollmentCocCsvConverter enrollmentCocCsvConverter;
	@Autowired private EventCsvConverter eventCsvConverter;
	@Autowired private ExitCsvConverter  exitCsvConverter;
	@Autowired private ExportCsvConverter exportCsvConverter;
	@Autowired private HealthAndDvCsvConverter healthAndDvCsvConverter;
	@Autowired private IncomeBenefitsCsvConverter incomeBenefitsCsvConverter;
	@Autowired private InventoryCsvConverter  inventoryCsvConverter;
	@Autowired private OrganizationCsvConverter organizationCsvConverter;
	@Autowired private ProjectCocCsvConverter projectCocCsvConverter;
	@Autowired private ServicesCsvConverter servicesCsvConverter;
	 

	/**
	 * @return the bulkUploaderDao
	 */
	public BulkUploaderDao getBulkUploaderDao() {
		return bulkUploaderDao;
	}

	/**
	 * @param bulkUploaderDao
	 *            the bulkUploaderDao to set
	 */
	public void setBulkUploaderDao(BulkUploaderDao bulkUploaderDao) {
		this.bulkUploaderDao = bulkUploaderDao;
	}


	/**
	 * @return the dateofengagementDao
	 */
	public DateofengagementDao getDateofengagementDao() {
		return dateofengagementDao;
	}

	/**
	 * @param dateofengagementDao
	 *            the dateofengagementDao to set
	 */
	public void setDateofengagementDao(DateofengagementDao dateofengagementDao) {
		this.dateofengagementDao = dateofengagementDao;
	}
	/**
	 * @return the connectionWithSoarDao
	 */
	public ConnectionWithSoarDao getConnectionWithSoarDao() {
		return connectionWithSoarDao;
	}

	/**
	 * @param connectionWithSoarDao the connectionWithSoarDao to set
	 */
	public void setConnectionWithSoarDao(ConnectionWithSoarDao connectionWithSoarDao) {
		this.connectionWithSoarDao = connectionWithSoarDao;
	}

	/**
	 * @return the affiliationDao
	 */
	public AffiliationDao getAffiliationDao() {
		return affiliationDao;
	}

	/**
	 * @param affiliationDao
	 *            the affiliationDao to set
	 */
	public void setAffiliationDao(AffiliationDao affiliationDao) {
		this.affiliationDao = affiliationDao;
	}

	
	/**
	 * @return the disabilitiesDao
	 */
	public DisabilitiesDao getDisabilitiesDao() {
		return disabilitiesDao;
	}

	/**
	 * @param disabilitiesDao
	 *            the disabilitiesDao to set
	 */
	public void setDisabilitiesDao(DisabilitiesDao disabilitiesDao) {
		this.disabilitiesDao = disabilitiesDao;
	}

	/**
	 * @return the domesticviolenceDao
	 */
	public DomesticviolenceDao getDomesticviolenceDao() {
		return domesticviolenceDao;
	}

	/**
	 * @param domesticviolenceDao
	 *            the domesticviolenceDao to set
	 */
	public void setDomesticviolenceDao(DomesticviolenceDao domesticviolenceDao) {
		this.domesticviolenceDao = domesticviolenceDao;
	}

	/**
	 * @return the employmentDao
	 */
	public EmploymentDao getEmploymentDao() {
		return employmentDao;
	}

	/**
	 * @param employmentDao
	 *            the employmentDao to set
	 */
	public void setEmploymentDao(EmploymentDao employmentDao) {
		this.employmentDao = employmentDao;
	}

	/**
	 * @return the enrollmentDao
	 */
	public EnrollmentDao getEnrollmentDao() {
		return enrollmentDao;
	}

	/**
	 * @param enrollmentDao
	 *            the enrollmentDao to set
	 */
	public void setEnrollmentDao(EnrollmentDao enrollmentDao) {
		this.enrollmentDao = enrollmentDao;
	}

	/**
	 * @return the enrollmentCocDao
	 */
	public EnrollmentCocDao getEnrollmentCocDao() {
		return enrollmentCocDao;
	}

	/**
	 * @param enrollmentCocDao
	 *            the enrollmentCocDao to set
	 */
	public void setEnrollmentCocDao(EnrollmentCocDao enrollmentCocDao) {
		this.enrollmentCocDao = enrollmentCocDao;
	}

	/**
	 * @return the exitDao
	 */
	public ExitDao getExitDao() {
		return exitDao;
	}

	/**
	 * @param exitDao
	 *            the exitDao to set
	 */
	public void setExitDao(ExitDao exitDao) {
		this.exitDao = exitDao;
	}

	/**
	 * @return the exithousingassessmentDao
	 */
	public ExithousingassessmentDao getExithousingassessmentDao() {
		return exithousingassessmentDao;
	}

	/**
	 * @param exithousingassessmentDao
	 *            the exithousingassessmentDao to set
	 */
	public void setExithousingassessmentDao(
			ExithousingassessmentDao exithousingassessmentDao) {
		this.exithousingassessmentDao = exithousingassessmentDao;
	}

	/**
	 * @return the funderDao
	 */
	public FunderDao getFunderDao() {
		return funderDao;
	}

	/**
	 * @param funderDao
	 *            the funderDao to set
	 */
	public void setFunderDao(FunderDao funderDao) {
		this.funderDao = funderDao;
	}

	/**
	 * @return the healthinsuranceDao
	 */
	public HealthinsuranceDao getHealthinsuranceDao() {
		return healthinsuranceDao;
	}

	/**
	 * @param healthinsuranceDao
	 *            the healthinsuranceDao to set
	 */
	public void setHealthinsuranceDao(HealthinsuranceDao healthinsuranceDao) {
		this.healthinsuranceDao = healthinsuranceDao;
	}

	/**
	 * @return the healthStatusDao
	 */
	public HealthStatusDao getHealthStatusDao() {
		return healthStatusDao;
	}

	/**
	 * @param healthStatusDao
	 *            the healthStatusDao to set
	 */
	public void setHealthStatusDao(HealthStatusDao healthStatusDao) {
		this.healthStatusDao = healthStatusDao;
	}

	/**
	 * @return the incomeandsourcesDao
	 */
	public IncomeandsourcesDao getIncomeandsourcesDao() {
		return incomeandsourcesDao;
	}

	/**
	 * @param incomeandsourcesDao
	 *            the incomeandsourcesDao to set
	 */
	public void setIncomeandsourcesDao(IncomeandsourcesDao incomeandsourcesDao) {
		this.incomeandsourcesDao = incomeandsourcesDao;
	}

	/**
	 * @return the inventoryDao
	 */
	public InventoryDao getInventoryDao() {
		return inventoryDao;
	}

	/**
	 * @param inventoryDao
	 *            the inventoryDao to set
	 */
	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}

	/**
	 * @return the medicalassistanceDao
	 */
	public MedicalassistanceDao getMedicalassistanceDao() {
		return medicalassistanceDao;
	}

	/**
	 * @param medicalassistanceDao
	 *            the medicalassistanceDao to set
	 */
	public void setMedicalassistanceDao(
			MedicalassistanceDao medicalassistanceDao) {
		this.medicalassistanceDao = medicalassistanceDao;
	}

	/**
	 * @return the noncashbenefitsDao
	 */
	public NoncashbenefitsDao getNoncashbenefitsDao() {
		return noncashbenefitsDao;
	}

	/**
	 * @param noncashbenefitsDao
	 *            the noncashbenefitsDao to set
	 */
	public void setNoncashbenefitsDao(NoncashbenefitsDao noncashbenefitsDao) {
		this.noncashbenefitsDao = noncashbenefitsDao;
	}

	/**
	 * @return the pathstatusDao
	 */
	public PathstatusDao getPathstatusDao() {
		return pathstatusDao;
	}

	/**
	 * @param pathstatusDao
	 *            the pathstatusDao to set
	 */
	public void setPathstatusDao(PathstatusDao pathstatusDao) {
		this.pathstatusDao = pathstatusDao;
	}


	/**
	 * @return the projectDao
	 */
	public ProjectDao getProjectDao() {
		return projectDao;
	}

	/**
	 * @param projectDao
	 *            the projectDao to set
	 */
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	/**
	 * @return the residentialmoveindateDao
	 */
	public MoveindateDao getResidentialmoveindateDao() {
		return residentialmoveindateDao;
	}

	/**
	 * @param residentialmoveindateDao
	 *            the residentialmoveindateDao to set
	 */
	public void setResidentialmoveindateDao(MoveindateDao residentialmoveindateDao) {
		this.residentialmoveindateDao = residentialmoveindateDao;
	}

	/**
	 * @return the rhybcpstatusDao
	 */
	public RhybcpstatusDao getRhybcpstatusDao() {
		return rhybcpstatusDao;
	}

	/**
	 * @param rhybcpstatusDao
	 *            the rhybcpstatusDao to set
	 */
	public void setRhybcpstatusDao(RhybcpstatusDao rhybcpstatusDao) {
		this.rhybcpstatusDao = rhybcpstatusDao;
	}

	/**
	 * @return the sourceDao
	 */
	public SourceDao getSourceDao() {
		return sourceDao;
	}

	/**
	 * @param sourceDao
	 *            the sourceDao to set
	 */
	public void setSourceDao(SourceDao sourceDao) {
		this.sourceDao = sourceDao;
	}
	/**
	 * @return the veteranInfoDao
	 */
	public ClientVeteranInfoDao getVeteranInfoDao() {
		return veteranInfoDao;
	}

	/**
	 * @param veteranInfoDao
	 *            the veteranInfoDao to set
	 */
	public void setVeteranInfoDao(ClientVeteranInfoDao veteranInfoDao) {
		this.veteranInfoDao = veteranInfoDao;
	}

	@Override
	public ExportDao getExportDao() {
		return exportDao;
	}
	
	public void setExportDao(ExportDao exportDao) {
		this.exportDao = exportDao;
	}
	public CocDao getCocDao() {
		return cocDao;
	}

	public void setCocDao(CocDao cocDao) {
		this.cocDao = cocDao;
	}

	public ContactDao getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public EntryrhspDao getEntryrhspDao() {
		return entryrhspDao;
	}

	public void setEntryrhspDao(EntryrhspDao entryrhspDao) {
		this.entryrhspDao = entryrhspDao;
	}

	public EntryrhyDao getEntryrhyDao() {
		return entryrhyDao;
	}

	public void setEntryrhyDao(EntryrhyDao entryrhyDao) {
		this.entryrhyDao = entryrhyDao;
	}

	public EntryssvfDao getEntryssvfDao() {
		return entryssvfDao;
	}

	public void setEntryssvfDao(EntryssvfDao entryssvfDao) {
		this.entryssvfDao = entryssvfDao;
	}

	public ExitrhyDao getExitrhyDao() {
		return exitrhyDao;
	}

	public void setExitrhyDao(ExitrhyDao exitrhyDao) {
		this.exitrhyDao = exitrhyDao;
	}

	public ServiceFaReferralDao getServiceFaReferralDao() {
		return serviceFaReferralDao;
	}

	public void setServiceFaReferralDao(ServiceFaReferralDao serviceFaReferralDao) {
		this.serviceFaReferralDao = serviceFaReferralDao;
	}

	public OrganizationDao getOrganizationDao() {
		return organizationDao;
	}

	public void setOrganizationDao(OrganizationDao organizationDao) {
		this.organizationDao = organizationDao;
	}

	public EducationDao getEducationDao() {
		return educationDao;
	}

	public void setEducationDao(EducationDao educationDao) {
		this.educationDao = educationDao;
	}

	public ClientDao getClientDao() {
		return clientDao;
	}

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	public BulkUploadActivityDao getBulkUploadActivityDao() {
		return bulkUploadActivityDao;
	}

	public void setBulkUploadActivityDao(BulkUploadActivityDao bulkUploadActivityDao) {
		this.bulkUploadActivityDao = bulkUploadActivityDao;
	}

	public BulkUploadErrorDao getBulkUploadErrorDao() {
		return bulkUploadErrorDao;
	}

	public void setBulkUploadErrorDao(BulkUploadErrorDao bulkUploadErrorDao) {
		this.bulkUploadErrorDao = bulkUploadErrorDao;
	}

	/**
	 * @return the vashExitReasonDao
	 */
	public VASHExitReasonDao getVashExitReasonDao() {
		return vashExitReasonDao;
	}

	/**
	 * @param vashExitReasonDao the vashExitReasonDao to set
	 */
	public void setVashExitReasonDao(VASHExitReasonDao vashExitReasonDao) {
		this.vashExitReasonDao = vashExitReasonDao;
	}

	/**
	 * @return the rhyAfterCareDao
	 */
	public RHYAfterCareDao getRhyAfterCareDao() {
		return rhyAfterCareDao;
	}

	/**
	 * @param rhyAfterCareDao the rhyAfterCareDao to set
	 */
	public void setRhyAfterCareDao(RHYAfterCareDao rhyAfterCareDao) {
		this.rhyAfterCareDao = rhyAfterCareDao;
	}
	public QuestionDao getQuestionDao() {
		return questionDao;
	}

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	public HmisTypeDao getHmisTypeDao() {
		return hmisTypeDao;
	}

	public void setHmisTypeDao(HmisTypeDao hmisTypeDao) {
		this.hmisTypeDao = hmisTypeDao;
	}

	/**
	 * @return the assessmentDao
	 */
	public AssessmentDao getAssessmentDao() {
		return assessmentDao;
	}

	/**
	 * @param assessmentDao the assessmentDao to set
	 */
	public void setAssessmentDao(AssessmentDao assessmentDao) {
		this.assessmentDao = assessmentDao;
	}

	/**
	 * @return the assessmentQuestionsDao
	 */
	public AssessmentQuestionsDao getAssessmentQuestionsDao() {
		return assessmentQuestionsDao;
	}

	/**
	 * @param assessmentQuestionsDao the assessmentQuestionsDao to set
	 */
	public void setAssessmentQuestionsDao(AssessmentQuestionsDao assessmentQuestionsDao) {
		this.assessmentQuestionsDao = assessmentQuestionsDao;
	}

	/**
	 * @return the assessmentResultsDao
	 */
	public AssessmentResultsDao getAssessmentResultsDao() {
		return assessmentResultsDao;
	}

	/**
	 * @param assessmentResultsDao the assessmentResultsDao to set
	 */
	public void setAssessmentResultsDao(AssessmentResultsDao assessmentResultsDao) {
		this.assessmentResultsDao = assessmentResultsDao;
	}

	/**
	 * @return the currentLivingSituationDao
	 */
	public CurrentLivingSituationDao getCurrentLivingSituationDao() {
		return currentLivingSituationDao;
	}

	/**
	 * @param currentLivingSituationDao the currentLivingSituationDao to set
	 */
	public void setCurrentLivingSituationDao(CurrentLivingSituationDao currentLivingSituationDao) {
		this.currentLivingSituationDao = currentLivingSituationDao;
	}

	/**
	 * @return the eventDao
	 */
	public EventDao getEventDao() {
		return eventDao;
	}

	/**
	 * @param eventDao the eventDao to set
	 */
	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}
	

	@Autowired HistoryDao historyDao;

	public HistoryDao getHistoryDao() {
		return historyDao;
	}
	public void setHistoryDao(HistoryDao historyDao) {
		this.historyDao = historyDao;
	}

	public ProjectCsvConverter getProjectCsvConverter() {
		return projectCsvConverter;
	}

	public void setProjectCsvConverter(ProjectCsvConverter projectCsvConverter) {
		this.projectCsvConverter = projectCsvConverter;
	}

	public AffiliationCsvConverter getAffiliationCsvConverter() {
		return affiliationCsvConverter;
	}

	public void setAffiliationCsvConverter(AffiliationCsvConverter affiliationCsvConverter) {
		this.affiliationCsvConverter = affiliationCsvConverter;
	}

	public FunderCsvConverter getFunderCsvConverter() {
		return funderCsvConverter;
	}

	public void setFunderCsvConverter(FunderCsvConverter funderCsvConverter) {
		this.funderCsvConverter = funderCsvConverter;
	}

	public EnrollmentCsvConverter getEnrollmentCsvConverter() {
		return enrollmentCsvConverter;
	}

	public void setEnrollmentCsvConverter(EnrollmentCsvConverter enrollmentCsvConverter) {
		this.enrollmentCsvConverter = enrollmentCsvConverter;
	}

	public AssessmentCsvConverter getAssessmentCsvConverter() {
		return assessmentCsvConverter;
	}

	public void setAssessmentCsvConverter(AssessmentCsvConverter assessmentCsvConverter) {
		this.assessmentCsvConverter = assessmentCsvConverter;
	}

	public AssessmentQuestionsCsvConverter getAssessmentQuestionsCsvConverter() {
		return assessmentQuestionsCsvConverter;
	}

	public void setAssessmentQuestionsCsvConverter(AssessmentQuestionsCsvConverter assessmentQuestionsCsvConverter) {
		this.assessmentQuestionsCsvConverter = assessmentQuestionsCsvConverter;
	}

	public AssessmentResultsCsvConverter getAssessmentResultsCsvConverter() {
		return assessmentResultsCsvConverter;
	}

	public void setAssessmentResultsCsvConverter(AssessmentResultsCsvConverter assessmentResultsCsvConverter) {
		this.assessmentResultsCsvConverter = assessmentResultsCsvConverter;
	}

	public ClientCsvConverter getClientCsvConverter() {
		return clientCsvConverter;
	}

	public void setClientCsvConverter(ClientCsvConverter clientCsvConverter) {
		this.clientCsvConverter = clientCsvConverter;
	}

	public CurrentLivingSituationCsvConverter getCurrentLivingSituationCsvConverter() {
		return currentLivingSituationCsvConverter;
	}

	public void setCurrentLivingSituationCsvConverter(
			CurrentLivingSituationCsvConverter currentLivingSituationCsvConverter) {
		this.currentLivingSituationCsvConverter = currentLivingSituationCsvConverter;
	}

	public DisabilitiesCsvConverter getDisabilitiesCsvConverter() {
		return disabilitiesCsvConverter;
	}

	public void setDisabilitiesCsvConverter(DisabilitiesCsvConverter disabilitiesCsvConverter) {
		this.disabilitiesCsvConverter = disabilitiesCsvConverter;
	}

	public EmploymentEducationCsvConverter getEmploymentEducationCsvConverter() {
		return employmentEducationCsvConverter;
	}

	public void setEmploymentEducationCsvConverter(EmploymentEducationCsvConverter employmentEducationCsvConverter) {
		this.employmentEducationCsvConverter = employmentEducationCsvConverter;
	}

	public EnrollmentCocCsvConverter getEnrollmentCocCsvConverter() {
		return enrollmentCocCsvConverter;
	}

	public void setEnrollmentCocCsvConverter(EnrollmentCocCsvConverter enrollmentCocCsvConverter) {
		this.enrollmentCocCsvConverter = enrollmentCocCsvConverter;
	}

	public EventCsvConverter getEventCsvConverter() {
		return eventCsvConverter;
	}

	public void setEventCsvConverter(EventCsvConverter eventCsvConverter) {
		this.eventCsvConverter = eventCsvConverter;
	}

	public ExitCsvConverter getExitCsvConverter() {
		return exitCsvConverter;
	}

	public void setExitCsvConverter(ExitCsvConverter exitCsvConverter) {
		this.exitCsvConverter = exitCsvConverter;
	}

	public ExportCsvConverter getExportCsvConverter() {
		return exportCsvConverter;
	}

	public void setExportCsvConverter(ExportCsvConverter exportCsvConverter) {
		this.exportCsvConverter = exportCsvConverter;
	}

	public HealthAndDvCsvConverter getHealthAndDvCsvConverter() {
		return healthAndDvCsvConverter;
	}

	public void setHealthAndDvCsvConverter(HealthAndDvCsvConverter healthAndDvCsvConverter) {
		this.healthAndDvCsvConverter = healthAndDvCsvConverter;
	}

	public IncomeBenefitsCsvConverter getIncomeBenefitsCsvConverter() {
		return incomeBenefitsCsvConverter;
	}

	public void setIncomeBenefitsCsvConverter(IncomeBenefitsCsvConverter incomeBenefitsCsvConverter) {
		this.incomeBenefitsCsvConverter = incomeBenefitsCsvConverter;
	}

	public InventoryCsvConverter getInventoryCsvConverter() {
		return inventoryCsvConverter;
	}

	public void setInventoryCsvConverter(InventoryCsvConverter inventoryCsvConverter) {
		this.inventoryCsvConverter = inventoryCsvConverter;
	}

	public OrganizationCsvConverter getOrganizationCsvConverter() {
		return organizationCsvConverter;
	}

	public void setOrganizationCsvConverter(OrganizationCsvConverter organizationCsvConverter) {
		this.organizationCsvConverter = organizationCsvConverter;
	}

	public ProjectCocCsvConverter getProjectCocCsvConverter() {
		return projectCocCsvConverter;
	}

	public void setProjectCocCsvConverter(ProjectCocCsvConverter projectCocCsvConverter) {
		this.projectCocCsvConverter = projectCocCsvConverter;
	}

	public ServicesCsvConverter getServicesCsvConverter() {
		return servicesCsvConverter;
	}

	public void setServicesCsvConverter(ServicesCsvConverter servicesCsvConverter) {
		this.servicesCsvConverter = servicesCsvConverter;
	}
	
    @Autowired private HmisHouseholdDao hmisHouseholdDao;

	public HmisHouseholdDao getHmisHouseholdDao() {
		return hmisHouseholdDao;
	}
	public void setHmisHouseholdDao(HmisHouseholdDao hmisHouseholdDao) {
		this.hmisHouseholdDao = hmisHouseholdDao;
	}
}
