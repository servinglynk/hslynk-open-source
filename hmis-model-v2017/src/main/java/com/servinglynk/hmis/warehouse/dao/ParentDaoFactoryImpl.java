package com.servinglynk.hmis.warehouse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.base.dao.BaseDaoFactoryImpl;

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
	private HousingassessmentdispositionDao housingassessmentdispositionDao;
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
	private SiteDao siteDao;
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
	private ExitpathDao exitpathDao;
	@Autowired
	private ExitrhyDao exitrhyDao;
	@Autowired
	private ServiceFaReferralDao serviceFaReferralDao;
	@Autowired
	private OrganizationDao organizationDao;
	@Autowired
	private EducationDao educationDao; 
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private BulkUploadActivityDao bulkUploadActivityDao;
	
	@Autowired
	private BulkUploadErrorDao bulkUploadErrorDao;

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
	 * @return the housingassessmentdispositionDao
	 */
	public HousingassessmentdispositionDao getHousingassessmentdispositionDao() {
		return housingassessmentdispositionDao;
	}

	/**
	 * @param housingassessmentdispositionDao
	 *            the housingassessmentdispositionDao to set
	 */
	public void setHousingassessmentdispositionDao(
			HousingassessmentdispositionDao housingassessmentdispositionDao) {
		this.housingassessmentdispositionDao = housingassessmentdispositionDao;
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
	 * @return the siteDao
	 */
	public SiteDao getSiteDao() {
		return siteDao;
	}

	/**
	 * @param siteDao
	 *            the siteDao to set
	 */
	public void setSiteDao(SiteDao siteDao) {
		this.siteDao = siteDao;
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

	public ExitpathDao getExitpathDao() {
		return exitpathDao;
	}

	public void setExitpathDao(ExitpathDao exitpathDao) {
		this.exitpathDao = exitpathDao;
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
	
}
