package com.servinglynk.hmis.warehouse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.base.dao.BaseDaoFactoryImpl;
import com.servinglynk.hmis.warehouse.base.dao.BulkUploaderWorkerDao;
import com.servinglynk.hmis.warehouse.dao.helper.ChronicHomelessCalcHelper;

@Component
public class ParentDaoFactoryImpl extends BaseDaoFactoryImpl implements ParentDaoFactory {
	@Autowired
	private SyncListDao syncListDao;
	@Autowired
	private BulkUploaderDao bulkUploaderDao;
	@Autowired
	private CommercialsexualexploitationDao commercialsexualexploitationDao;
	@Autowired
	private DateofengagementDao dateofengagementDao;
	@Autowired
	private AffiliationDao affiliationDao;
	@Autowired
	private ConnectionwithsoarDao connectionwithsoarDao;
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
	private ExitplansactionsDao exitplansactionsDao;
	@Autowired
	private FamilyreunificationDao familyreunificationDao;
	@Autowired
	private FormerwardchildwelfareDao formerwardchildwelfareDao;
	@Autowired
	private FormerwardjuvenilejusticeDao formerwardjuvenilejusticeDao;
	@Autowired
	private FunderDao funderDao;
	@Autowired
	private HealthinsuranceDao healthinsuranceDao;
	@Autowired
	private HealthStatusDao healthStatusDao;
	@Autowired
	private HousingassessmentdispositionDao housingassessmentdispositionDao;
	@Autowired
	private IncomeandsourcesDao incomeandsourcesDao;
	@Autowired
	private InventoryDao inventoryDao;
	@Autowired
	private LastgradecompletedDao lastgradecompletedDao;
	@Autowired
	private LastPermAddressDao lastPermAddressDao;
	@Autowired
	private MedicalassistanceDao medicalassistanceDao;
	@Autowired
	private NoncashbenefitsDao noncashbenefitsDao;
	@Autowired
	private PathstatusDao pathstatusDao;
	@Autowired
	private PercentamiDao percentamiDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private ProjectcocDao projectcocDao;
	@Autowired
	private ProjectcompletionstatusDao projectcompletionstatusDao;
	@Autowired
	private ReferralsourceDao referralsourceDao;
	@Autowired
	private ResidentialmoveindateDao residentialmoveindateDao;
	@Autowired
	private RhybcpstatusDao rhybcpstatusDao;
	@Autowired
	private SchoolstatusDao schoolstatusDao;
	@Autowired
	private ServicesDao servicesDao;
	@Autowired
	private SexualorientationDao sexualorientationDao;
	@Autowired
	private SiteDao siteDao;
	@Autowired
	private SourceDao sourceDao;
	@Autowired
	private VeteranInfoDao veteranInfoDao;
	@Autowired
	private WorsthousingsituationDao worsthousingsituationDao;
	@Autowired
	private YouthcriticalissuesDao youthcriticalissuesDao;
	@Autowired
	private BulkUploaderWorkerDao bulkUploaderWorkerDao;
	@Autowired
	private ExportDao exportDao;
	@Autowired
	public InformationReleasesDao informationReleasesDao;
	@Autowired
	public BulkUploadActivityDao bulkUploadActivityDao;
	@Autowired
	public BulkUploadErrorDao bulkUploadErrorDao;

	@Autowired
	private OrganizationDao organizationDao;
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private HmisTypeDao hmisTypeDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired private ChronicHomelessCalcHelper chronicHomelessCalcHelper;

	/**
	 * @return the chronicHomelessCalcHelper
	 */
	public ChronicHomelessCalcHelper getChronicHomelessCalcHelper() {
		return chronicHomelessCalcHelper;
	}

	/**
	 * @param chronicHomelessCalcHelper the chronicHomelessCalcHelper to set
	 */
	public void setChronicHomelessCalcHelper(ChronicHomelessCalcHelper chronicHomelessCalcHelper) {
		this.chronicHomelessCalcHelper = chronicHomelessCalcHelper;
	}
	
	public SyncListDao getSyncListDao() {
		return syncListDao;
	}
	public void setSyncListDao(SyncListDao syncListDao) {
		this.syncListDao = syncListDao;
	}
	public BulkUploaderDao getBulkUploaderDao() {
		return bulkUploaderDao;
	}
	public void setBulkUploaderDao(BulkUploaderDao bulkUploaderDao) {
		this.bulkUploaderDao = bulkUploaderDao;
	}
	public CommercialsexualexploitationDao getCommercialsexualexploitationDao() {
		return commercialsexualexploitationDao;
	}
	public void setCommercialsexualexploitationDao(CommercialsexualexploitationDao commercialsexualexploitationDao) {
		this.commercialsexualexploitationDao = commercialsexualexploitationDao;
	}
	public DateofengagementDao getDateofengagementDao() {
		return dateofengagementDao;
	}
	public void setDateofengagementDao(DateofengagementDao dateofengagementDao) {
		this.dateofengagementDao = dateofengagementDao;
	}
	public AffiliationDao getAffiliationDao() {
		return affiliationDao;
	}
	public void setAffiliationDao(AffiliationDao affiliationDao) {
		this.affiliationDao = affiliationDao;
	}
	public ConnectionwithsoarDao getConnectionwithsoarDao() {
		return connectionwithsoarDao;
	}
	public void setConnectionwithsoarDao(ConnectionwithsoarDao connectionwithsoarDao) {
		this.connectionwithsoarDao = connectionwithsoarDao;
	}
	public DisabilitiesDao getDisabilitiesDao() {
		return disabilitiesDao;
	}
	public void setDisabilitiesDao(DisabilitiesDao disabilitiesDao) {
		this.disabilitiesDao = disabilitiesDao;
	}
	public DomesticviolenceDao getDomesticviolenceDao() {
		return domesticviolenceDao;
	}
	public void setDomesticviolenceDao(DomesticviolenceDao domesticviolenceDao) {
		this.domesticviolenceDao = domesticviolenceDao;
	}
	public EmploymentDao getEmploymentDao() {
		return employmentDao;
	}
	public void setEmploymentDao(EmploymentDao employmentDao) {
		this.employmentDao = employmentDao;
	}
	public EnrollmentDao getEnrollmentDao() {
		return enrollmentDao;
	}
	public void setEnrollmentDao(EnrollmentDao enrollmentDao) {
		this.enrollmentDao = enrollmentDao;
	}
	public EnrollmentCocDao getEnrollmentCocDao() {
		return enrollmentCocDao;
	}
	public void setEnrollmentCocDao(EnrollmentCocDao enrollmentCocDao) {
		this.enrollmentCocDao = enrollmentCocDao;
	}
	public ExitDao getExitDao() {
		return exitDao;
	}
	public void setExitDao(ExitDao exitDao) {
		this.exitDao = exitDao;
	}
	public ExithousingassessmentDao getExithousingassessmentDao() {
		return exithousingassessmentDao;
	}
	public void setExithousingassessmentDao(ExithousingassessmentDao exithousingassessmentDao) {
		this.exithousingassessmentDao = exithousingassessmentDao;
	}
	public ExitplansactionsDao getExitplansactionsDao() {
		return exitplansactionsDao;
	}
	public void setExitplansactionsDao(ExitplansactionsDao exitplansactionsDao) {
		this.exitplansactionsDao = exitplansactionsDao;
	}
	public FamilyreunificationDao getFamilyreunificationDao() {
		return familyreunificationDao;
	}
	public void setFamilyreunificationDao(FamilyreunificationDao familyreunificationDao) {
		this.familyreunificationDao = familyreunificationDao;
	}
	public FormerwardchildwelfareDao getFormerwardchildwelfareDao() {
		return formerwardchildwelfareDao;
	}
	public void setFormerwardchildwelfareDao(FormerwardchildwelfareDao formerwardchildwelfareDao) {
		this.formerwardchildwelfareDao = formerwardchildwelfareDao;
	}
	public FormerwardjuvenilejusticeDao getFormerwardjuvenilejusticeDao() {
		return formerwardjuvenilejusticeDao;
	}
	public void setFormerwardjuvenilejusticeDao(FormerwardjuvenilejusticeDao formerwardjuvenilejusticeDao) {
		this.formerwardjuvenilejusticeDao = formerwardjuvenilejusticeDao;
	}
	public FunderDao getFunderDao() {
		return funderDao;
	}
	public void setFunderDao(FunderDao funderDao) {
		this.funderDao = funderDao;
	}
	public HealthinsuranceDao getHealthinsuranceDao() {
		return healthinsuranceDao;
	}
	public void setHealthinsuranceDao(HealthinsuranceDao healthinsuranceDao) {
		this.healthinsuranceDao = healthinsuranceDao;
	}
	public HealthStatusDao getHealthStatusDao() {
		return healthStatusDao;
	}
	public void setHealthStatusDao(HealthStatusDao healthStatusDao) {
		this.healthStatusDao = healthStatusDao;
	}
	public HousingassessmentdispositionDao getHousingassessmentdispositionDao() {
		return housingassessmentdispositionDao;
	}
	public void setHousingassessmentdispositionDao(HousingassessmentdispositionDao housingassessmentdispositionDao) {
		this.housingassessmentdispositionDao = housingassessmentdispositionDao;
	}
	public IncomeandsourcesDao getIncomeandsourcesDao() {
		return incomeandsourcesDao;
	}
	public void setIncomeandsourcesDao(IncomeandsourcesDao incomeandsourcesDao) {
		this.incomeandsourcesDao = incomeandsourcesDao;
	}
	public InventoryDao getInventoryDao() {
		return inventoryDao;
	}
	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}
	public LastgradecompletedDao getLastgradecompletedDao() {
		return lastgradecompletedDao;
	}
	public void setLastgradecompletedDao(LastgradecompletedDao lastgradecompletedDao) {
		this.lastgradecompletedDao = lastgradecompletedDao;
	}
	public LastPermAddressDao getLastPermAddressDao() {
		return lastPermAddressDao;
	}
	public void setLastPermAddressDao(LastPermAddressDao lastPermAddressDao) {
		this.lastPermAddressDao = lastPermAddressDao;
	}
	public MedicalassistanceDao getMedicalassistanceDao() {
		return medicalassistanceDao;
	}
	public void setMedicalassistanceDao(MedicalassistanceDao medicalassistanceDao) {
		this.medicalassistanceDao = medicalassistanceDao;
	}
	public NoncashbenefitsDao getNoncashbenefitsDao() {
		return noncashbenefitsDao;
	}
	public void setNoncashbenefitsDao(NoncashbenefitsDao noncashbenefitsDao) {
		this.noncashbenefitsDao = noncashbenefitsDao;
	}
	public PathstatusDao getPathstatusDao() {
		return pathstatusDao;
	}
	public void setPathstatusDao(PathstatusDao pathstatusDao) {
		this.pathstatusDao = pathstatusDao;
	}
	public PercentamiDao getPercentamiDao() {
		return percentamiDao;
	}
	public void setPercentamiDao(PercentamiDao percentamiDao) {
		this.percentamiDao = percentamiDao;
	}
	public ProjectDao getProjectDao() {
		return projectDao;
	}
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}
	public ProjectcocDao getProjectcocDao() {
		return projectcocDao;
	}
	public void setProjectcocDao(ProjectcocDao projectcocDao) {
		this.projectcocDao = projectcocDao;
	}
	public ProjectcompletionstatusDao getProjectcompletionstatusDao() {
		return projectcompletionstatusDao;
	}
	public void setProjectcompletionstatusDao(ProjectcompletionstatusDao projectcompletionstatusDao) {
		this.projectcompletionstatusDao = projectcompletionstatusDao;
	}
	public ReferralsourceDao getReferralsourceDao() {
		return referralsourceDao;
	}
	public void setReferralsourceDao(ReferralsourceDao referralsourceDao) {
		this.referralsourceDao = referralsourceDao;
	}
	public ResidentialmoveindateDao getResidentialmoveindateDao() {
		return residentialmoveindateDao;
	}
	public void setResidentialmoveindateDao(ResidentialmoveindateDao residentialmoveindateDao) {
		this.residentialmoveindateDao = residentialmoveindateDao;
	}
	public RhybcpstatusDao getRhybcpstatusDao() {
		return rhybcpstatusDao;
	}
	public void setRhybcpstatusDao(RhybcpstatusDao rhybcpstatusDao) {
		this.rhybcpstatusDao = rhybcpstatusDao;
	}
	public SchoolstatusDao getSchoolstatusDao() {
		return schoolstatusDao;
	}
	public void setSchoolstatusDao(SchoolstatusDao schoolstatusDao) {
		this.schoolstatusDao = schoolstatusDao;
	}
	public ServicesDao getServicesDao() {
		return servicesDao;
	}
	public void setServicesDao(ServicesDao servicesDao) {
		this.servicesDao = servicesDao;
	}
	public SexualorientationDao getSexualorientationDao() {
		return sexualorientationDao;
	}
	public void setSexualorientationDao(SexualorientationDao sexualorientationDao) {
		this.sexualorientationDao = sexualorientationDao;
	}
	public SiteDao getSiteDao() {
		return siteDao;
	}
	public void setSiteDao(SiteDao siteDao) {
		this.siteDao = siteDao;
	}
	public SourceDao getSourceDao() {
		return sourceDao;
	}
	public void setSourceDao(SourceDao sourceDao) {
		this.sourceDao = sourceDao;
	}
	public VeteranInfoDao getVeteranInfoDao() {
		return veteranInfoDao;
	}
	public void setVeteranInfoDao(VeteranInfoDao veteranInfoDao) {
		this.veteranInfoDao = veteranInfoDao;
	}
	public WorsthousingsituationDao getWorsthousingsituationDao() {
		return worsthousingsituationDao;
	}
	public void setWorsthousingsituationDao(WorsthousingsituationDao worsthousingsituationDao) {
		this.worsthousingsituationDao = worsthousingsituationDao;
	}
	public YouthcriticalissuesDao getYouthcriticalissuesDao() {
		return youthcriticalissuesDao;
	}
	public void setYouthcriticalissuesDao(YouthcriticalissuesDao youthcriticalissuesDao) {
		this.youthcriticalissuesDao = youthcriticalissuesDao;
	}
	public BulkUploaderWorkerDao getBulkUploaderWorkerDao() {
		return bulkUploaderWorkerDao;
	}
	public void setBulkUploaderWorkerDao(BulkUploaderWorkerDao bulkUploaderWorkerDao) {
		this.bulkUploaderWorkerDao = bulkUploaderWorkerDao;
	}
	public ExportDao getExportDao() {
		return exportDao;
	}
	public void setExportDao(ExportDao exportDao) {
		this.exportDao = exportDao;
	}
	public InformationReleasesDao getInformationReleasesDao() {
		return informationReleasesDao;
	}
	public void setInformationReleasesDao(InformationReleasesDao informationReleasesDao) {
		this.informationReleasesDao = informationReleasesDao;
	}
	public OrganizationDao getOrganizationDao() {
		return organizationDao;
	}
	public void setOrganizationDao(OrganizationDao organizationDao) {
		this.organizationDao = organizationDao;
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
	public HmisTypeDao getHmisTypeDao() {
		return hmisTypeDao;
	}
	public void setHmisTypeDao(HmisTypeDao hmisTypeDao) {
		this.hmisTypeDao = hmisTypeDao;
	}
	public QuestionDao getQuestionDao() {
		return questionDao;
	}
	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}	
	
	@Autowired HistoryDao historyDao;

	public HistoryDao getHistoryDao() {
		return historyDao;
	}
	public void setHistoryDao(HistoryDao historyDao) {
		this.historyDao = historyDao;
	}	
	
    @Autowired private HmisHouseholdDao hmisHouseholdDao;

	public HmisHouseholdDao getHmisHouseholdDao() {
		return hmisHouseholdDao;
	}
	public void setHmisHouseholdDao(HmisHouseholdDao hmisHouseholdDao) {
		this.hmisHouseholdDao = hmisHouseholdDao;
	}
}