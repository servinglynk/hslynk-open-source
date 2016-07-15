/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.IncomeAndSources;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
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
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources;
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
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap);
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources.class, getProjectGroupCode(domain));
		if(incomeAndSourceses !=null && !incomeAndSourceses.isEmpty())
		{
			for(IncomeAndSources incomeAndSources : incomeAndSourceses)
			{
				try {
					
					Incomeandsources incomeAndSourcesModel = getModelObject(domain, incomeAndSources,data,modelMap);
					incomeAndSourcesModel.setAlimony(IncomeandsourcesAlimonyEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getAlimony())));
					incomeAndSourcesModel.setAlimonyamount(new BigDecimal(incomeAndSources.getAlimonyAmount()));
					incomeAndSourcesModel.setChildsupport(IncomeandsourcesChildsupportEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getChildSupport())));
					incomeAndSourcesModel.setChildsupportamount(new BigDecimal(incomeAndSources.getChildSupportAmount()));
					incomeAndSourcesModel.setEarned(IncomeandsourcesEarnedEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getEarned())));
					incomeAndSourcesModel.setGa(IncomeandsourcesGaEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getGA())));
					incomeAndSourcesModel.setGaamount(new BigDecimal(incomeAndSources.getGAAmount()));
					incomeAndSourcesModel.setIncomefromanysource(IncomeandsourcesIncomefromanysourceEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getIncomeFromAnySource())));
					incomeAndSourcesModel.setOthersource(IncomeandsourcesOthersourceEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getOtherSource())));
					incomeAndSourcesModel.setOthersourceamount(new BigDecimal(incomeAndSources.getOtherAmount()));
					incomeAndSourcesModel.setOthersourceidentify(incomeAndSources.getOtherSourceIdentify());
					incomeAndSourcesModel.setPension(IncomeandsourcesPensionEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getPension())));
					incomeAndSourcesModel.setPensionamount(new BigDecimal(incomeAndSources.getPensionAmount()));
					incomeAndSourcesModel.setPrivatedisability(IncomeandsourcesPrivatedisabilityEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getPrivateDisability())));
					incomeAndSourcesModel.setPrivatedisabilityamount(new BigDecimal(incomeAndSources.getPrivateDisabilityAmount()));
					incomeAndSourcesModel.setSocsecretirement(IncomeandsourcesSocsecretirementEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getSocSecRetirement())));
					incomeAndSourcesModel.setSocsecretirementamount( new BigDecimal(incomeAndSources.getSocSecRetirementAmount()));
					incomeAndSourcesModel.setSsdi(IncomeandsourcesSsdiEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getSSDI())));
					incomeAndSourcesModel.setSsdiamount(new BigDecimal(incomeAndSources.getSSIAmount()));
					incomeAndSourcesModel.setSsi(IncomeandsourcesSsiEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getSSI())));
					incomeAndSourcesModel.setSsiamount(new BigDecimal(incomeAndSources.getSSIAmount()));
					incomeAndSourcesModel.setTanf(IncomeandsourcesTanfEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getTANF())));
					incomeAndSourcesModel.setTanfamount(new BigDecimal(incomeAndSources.getTANFAmount()));
					incomeAndSourcesModel.setTotalmonthlyincome(new BigDecimal(incomeAndSources.getTotalMonthlyIncome()));
					incomeAndSourcesModel.setUnemployment(IncomeandsourcesUnemploymentEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getUnemployment())));
					incomeAndSourcesModel.setUnemploymentamount(new BigDecimal(incomeAndSources.getUnemploymentAmount()));
					incomeAndSourcesModel.setVadisabilitynonservice(IncomeandsourcesVadisabilitynonserviceEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getVADisabilityNonService())));
					incomeAndSourcesModel.setVadisabilitynonserviceamount(new BigDecimal(incomeAndSources.getVADisabilityNonServiceAmount()));
					incomeAndSourcesModel.setVadisabilityservice(IncomeandsourcesVadisabilityserviceEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getVADisabilityService())));
					incomeAndSourcesModel.setVadisabilityserviceamount(new BigDecimal(incomeAndSources.getVADisabilityServiceAmount()));
					incomeAndSourcesModel.setWorkerscomp(IncomeandsourcesWorkerscompEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getWorkersComp())));
					incomeAndSourcesModel.setWorkerscompamount(new BigDecimal(incomeAndSources.getWorkersCompAmount()));
					incomeAndSourcesModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(incomeAndSources.getDateCreated()));
					incomeAndSourcesModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(incomeAndSources.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, incomeAndSources.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap);
					incomeAndSourcesModel.setEnrollmentid(enrollmentModel);
					incomeAndSourcesModel.setExport(exportEntity);
					if(exportEntity !=null)
						exportEntity.addIncomeandsources(incomeAndSourcesModel);
					performSaveOrUpdate(incomeAndSourcesModel);
				} catch(Exception e) {
					logger.error("Exception beause of the incomeAndSources::"+incomeAndSources.getIncomeAndSourcesID() +" Exception ::"+e.getMessage());
					throw new Exception(e);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources.class.getSimpleName(), domain,exportEntity);
	}

	public com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources getModelObject(ExportDomain domain, IncomeAndSources incomeandsources ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources IncomeandsourcesModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			IncomeandsourcesModel = (com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources) getModel(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources.class, incomeandsources.getIncomeAndSourcesID(), getProjectGroupCode(domain),false,modelMap);
		
		if(IncomeandsourcesModel == null) {
			IncomeandsourcesModel = new com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources();
			IncomeandsourcesModel.setId(UUID.randomUUID());
			IncomeandsourcesModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(IncomeandsourcesModel, domain,incomeandsources.getIncomeAndSourcesID(),data.i+data.j);
		return IncomeandsourcesModel;
	}
	

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}

	   public com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources createIncomeAndSource(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources incomeAndSource){
	       incomeAndSource.setId(UUID.randomUUID());
	       insert(incomeAndSource);
	       return incomeAndSource;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources updateIncomeAndSource(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources incomeAndSource){
	       update(incomeAndSource);
	       return incomeAndSource;
	   }
	   public void deleteIncomeAndSource(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources incomeAndSource){
	       delete(incomeAndSource);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources getIncomeAndSourceById(UUID incomeAndSourceId){
	       return (com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources) get(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources.class, incomeAndSourceId);
	   }

	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources> getAllEnrollmentIncomeAndSources(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentIncomeAndSourcesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
