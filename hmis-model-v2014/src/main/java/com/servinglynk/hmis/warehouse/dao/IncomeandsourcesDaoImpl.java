/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.IncomeAndSources;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesAlimonyEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesChildsupportEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesEarnedEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesGaEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesIncomefromanysourceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesOthersourceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesPensionEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesPrivatedisabilityEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSocsecretirementEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSsdiEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSsiEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesTanfEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesUnemploymentEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesVadisabilitynonserviceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesVadisabilityserviceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesWorkerscompEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class IncomeandsourcesDaoImpl extends ParentDaoImpl implements
		IncomeandsourcesDao {

	private static final Logger logger = LoggerFactory
			.getLogger(IncomeandsourcesDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<IncomeAndSources> incomeAndSourceses = domain.getExport().getIncomeAndSources();
		Data data = new Data();
		Map<String, HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Incomeandsources.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class, String.valueOf(domain.getExport().getExportID()), getProjectGroupCode(domain), false, exportModelMap, domain.getUpload().getId());
		if (incomeAndSourceses != null && !incomeAndSourceses.isEmpty()) {
			for (IncomeAndSources incomeAndSources : incomeAndSourceses) {
				Incomeandsources model = null;
				try {
					model = getModelObject(domain, incomeAndSources, data, modelMap);
					model.setAlimony(IncomeandsourcesAlimonyEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getAlimony())));
					model.setAlimonyamount(new BigDecimal(incomeAndSources.getAlimonyAmount()));
					model.setChildsupport(IncomeandsourcesChildsupportEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getChildSupport())));
					model.setChildsupportamount(new BigDecimal(incomeAndSources.getChildSupportAmount()));
					model.setEarned(IncomeandsourcesEarnedEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getEarned())));
					model.setGa(IncomeandsourcesGaEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getGA())));
					model.setGaamount(new BigDecimal(incomeAndSources.getGAAmount()));
					model.setIncomefromanysource(IncomeandsourcesIncomefromanysourceEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getIncomeFromAnySource())));
					model.setOthersource(IncomeandsourcesOthersourceEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getOtherSource())));
					model.setOthersourceamount(new BigDecimal(incomeAndSources.getOtherSourceAmount()));
					model.setOthersourceidentify(incomeAndSources.getOtherSourceIdentify());
					model.setPension(IncomeandsourcesPensionEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getPension())));
					model.setPensionamount(new BigDecimal(incomeAndSources.getPensionAmount()));
					model.setPrivatedisability(IncomeandsourcesPrivatedisabilityEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getPrivateDisability())));
					model.setPrivatedisabilityamount(new BigDecimal(incomeAndSources.getPrivateDisabilityAmount()));
					model.setSocsecretirement(IncomeandsourcesSocsecretirementEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getSocSecRetirement())));
					model.setSocsecretirementamount(new BigDecimal(incomeAndSources.getSocSecRetirementAmount()));
					model.setSsdi(IncomeandsourcesSsdiEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getSSDI())));
					model.setSsdiamount(new BigDecimal(incomeAndSources.getSSIAmount()));
					model.setSsi(IncomeandsourcesSsiEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getSSI())));
					model.setSsiamount(new BigDecimal(incomeAndSources.getSSIAmount()));
					model.setTanf(IncomeandsourcesTanfEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getTANF())));
					model.setTanfamount(new BigDecimal(incomeAndSources.getTANFAmount()));
					model.setTotalmonthlyincome(BigDecimal.valueOf(incomeAndSources.getTotalMonthlyIncome()));
					model.setUnemployment(IncomeandsourcesUnemploymentEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getUnemployment())));
					model.setUnemploymentamount(new BigDecimal(incomeAndSources.getUnemploymentAmount()));
					model.setVadisabilitynonservice(IncomeandsourcesVadisabilitynonserviceEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getVADisabilityNonService())));
					model.setVadisabilitynonserviceamount(new BigDecimal(incomeAndSources.getVADisabilityNonServiceAmount()));
					model.setVadisabilityservice(IncomeandsourcesVadisabilityserviceEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getVADisabilityService())));
					model.setVadisabilityserviceamount(new BigDecimal(incomeAndSources.getVADisabilityServiceAmount()));
					model.setWorkerscomp(IncomeandsourcesWorkerscompEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getWorkersComp())));
					model.setWorkerscompamount(new BigDecimal(incomeAndSources.getWorkersCompAmount()));
					model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(incomeAndSources.getDateCreated()));
					model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(incomeAndSources.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(Incomeandsources.class.getSimpleName(),Enrollment.class, incomeAndSources.getProjectEntryID(), getProjectGroupCode(domain), true, relatedModelMap, domain.getUpload().getId());
					model.setEnrollmentid(enrollmentModel);
					model.setExport(exportEntity);
					model.setInformationDate(BasicDataGenerator.getLocalDateTime(incomeAndSources.getInformationDate()));
					model.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getDataCollectionStage())));
					HmisBaseModel hmisBaseModel = modelMap.get(model.getSourceSystemId());
					if(hmisBaseModel !=null ) {
						modelMatch(hmisBaseModel, model);
					}
					performSaveOrUpdate(model);
				} catch (Exception e) {
					String errorMessage = "Failure in Incomeandsources:::" + incomeAndSources.toString() + " with exception" + e.getLocalizedMessage();
					if (model != null) {
						Error2014 error = new Error2014();
						error.model_id = model.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = model.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = model.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
			hydrateBulkUploadActivityStaging(data.i, data.j, com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources.class.getSimpleName(), domain, exportEntity);
		}
	}
		
		public com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources getModelObject(ExportDomain domain,IncomeAndSources incomeAndSources ,Data data, Map<String,HmisBaseModel> modelMap) {
			com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources incomeandsourcesModel = null;
			// We always insert for a Full refresh and update if the record exists for Delta refresh
			if(!isFullRefresh(domain))
				incomeandsourcesModel = (com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources) getModel(Incomeandsources.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources.class, incomeAndSources.getIncomeAndSourcesID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
			
			if(incomeandsourcesModel == null) {
				incomeandsourcesModel = new com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources();
				incomeandsourcesModel.setId(UUID.randomUUID());
				incomeandsourcesModel.setRecordToBeInserted(true);
				++data.i;
			}else{
				++data.j;
			}
			hydrateCommonFields(incomeandsourcesModel, domain,incomeAndSources.getIncomeAndSourcesID(),data.i+data.j);
			return incomeandsourcesModel;
		}
	   public com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources createIncomeAndSource(com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources incomeAndSource){
	       incomeAndSource.setId(UUID.randomUUID()); 
	       insert(incomeAndSource);
	       return incomeAndSource;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources updateIncomeAndSource(com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources incomeAndSource){
	       update(incomeAndSource);
	       return incomeAndSource;
	   }
	   public void deleteIncomeAndSource(com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources incomeAndSource){
	       delete(incomeAndSource);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources getIncomeAndSourceById(UUID incomeAndSourceId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources) get(com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources.class, incomeAndSourceId);
	   }
	   
	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources> getAllEnrollmentIncomeAndSources(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentIncomeAndSourcesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
