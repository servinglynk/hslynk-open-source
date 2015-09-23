/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;

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
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Incomeandsources;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class IncomeandsourcesDaoImpl extends ParentDaoImpl implements
		IncomeandsourcesDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<IncomeAndSources> incomeAndSourceses = domain.getExport().getIncomeAndSources();
		if(incomeAndSourceses !=null && !incomeAndSourceses.isEmpty())
		{
			for(IncomeAndSources incomeAndSources : incomeAndSourceses)
			{
				Incomeandsources incomeAndSourcesModel = new Incomeandsources();
				incomeAndSourcesModel.setId(UUID.randomUUID());
				incomeAndSourcesModel.setAlimony(IncomeandsourcesAlimonyEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getAlimony())));
				incomeAndSourcesModel.setAlimonyamount(new BigDecimal(incomeAndSources.getAlimonyAmount()));
				incomeAndSourcesModel.setChildsupport(IncomeandsourcesChildsupportEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getChildSupport())));
				incomeAndSourcesModel.setChildsupportamount(new BigDecimal(incomeAndSources.getChildSupportAmount()));
				incomeAndSourcesModel.setEarned(IncomeandsourcesEarnedEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getEarned())));
				incomeAndSourcesModel.setGa(IncomeandsourcesGaEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getGA())));
				incomeAndSourcesModel.setGaamount(new BigDecimal(incomeAndSources.getGAAmount()));
				incomeAndSourcesModel.setIncomefromanysource(IncomeandsourcesIncomefromanysourceEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getIncomeFromAnySource())));
				incomeAndSourcesModel.setOthersource(IncomeandsourcesOthersourceEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getOtherSource())));
				incomeAndSourcesModel.setOthersourceamount(new BigDecimal(incomeAndSources.getOtherSourceAmount()));
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
				incomeAndSourcesModel.setDateCreated(BasicDataGenerator.getLocalDate(incomeAndSources.getDateCreated()));
				incomeAndSourcesModel.setDateUpdated(BasicDataGenerator.getLocalDate(incomeAndSources.getDateUpdated()));
				if(incomeAndSources.getProjectEntryID()!=null && !"".equals(incomeAndSources.getProjectEntryID())) {
					Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(incomeAndSources.getProjectEntryID()));
					incomeAndSourcesModel.setEnrollmentid(enrollmentModel);	
				}
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				incomeAndSourcesModel.setExport(exportEntity);
				exportEntity.addIncomeandsources(incomeAndSourcesModel);
				insertOrUpdate(incomeAndSourcesModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Incomeandsources> incomeandsourceses = export.getIncomeandsourceses();
		if(incomeandsourceses !=null && !incomeandsourceses.isEmpty()) {
			for(Incomeandsources incomeandsources : incomeandsourceses) {
				if(incomeandsources != null) {
					com.servinglynk.hmis.warehouse.model.live.Incomeandsources target = new com.servinglynk.hmis.warehouse.model.live.Incomeandsources();
					BeanUtils.copyProperties(incomeandsources, target,getNonCollectionFields(target));
					insert(target);
				}
			}
		}
		
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void performSave(Iface client, Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List performGet(Iface client, Object entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
