/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.NonCashBenefits;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsBenefitsfromanysourceEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsOthersourceEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsOthertanfEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsRentalassistanceongoingEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsRentalassistancetempEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsSnapEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsTanfchildcareEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsTanftransportationEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsWicEnum;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Noncashbenefits;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class NoncashbenefitsDaoImpl extends ParentDaoImpl implements
		NoncashbenefitsDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<NonCashBenefits> nonCashBenefitsList = domain.getExport().getNonCashBenefits();
		if(nonCashBenefitsList !=null && !nonCashBenefitsList.isEmpty())
		{
			for(NonCashBenefits nonCashBenefits : nonCashBenefitsList)
			{
				Noncashbenefits noncashbenefitsModel = new Noncashbenefits();
				UUID id = UUID.randomUUID();
				noncashbenefitsModel.setId(id);
				noncashbenefitsModel.setDateCreated(BasicDataGenerator.getLocalDate(nonCashBenefits.getDateCreated()));
				noncashbenefitsModel.setDateUpdated(BasicDataGenerator.getLocalDate(nonCashBenefits.getDateUpdated()));
				noncashbenefitsModel.setBenefitsfromanysource(NoncashbenefitsBenefitsfromanysourceEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getBenefitsFromAnySource())));
				noncashbenefitsModel.setOthersource(NoncashbenefitsOthersourceEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getOtherSource())));
				noncashbenefitsModel.setOthersourceidentify(nonCashBenefits.getOtherSourceIdentify());
				noncashbenefitsModel.setOthertanf(NoncashbenefitsOthertanfEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getOtherTANF())));
				noncashbenefitsModel.setRentalassistanceongoing(NoncashbenefitsRentalassistanceongoingEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getRentalAssistanceOngoing())));
				noncashbenefitsModel.setRentalassistancetemp(NoncashbenefitsRentalassistancetempEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getRentalAssistanceTemp())));
				noncashbenefitsModel.setSnap(NoncashbenefitsSnapEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getSNAP())));
				noncashbenefitsModel.setTanfchildcare(NoncashbenefitsTanfchildcareEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getTANFChildCare())));
				noncashbenefitsModel.setTanftransportation(NoncashbenefitsTanftransportationEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getTANFTransportation())));
				noncashbenefitsModel.setWic(NoncashbenefitsWicEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getWIC())));
				if(nonCashBenefits.getProjectEntryID() !=null && !"".equals(nonCashBenefits.getProjectEntryID())) {
					UUID uuid = domain.getEnrollmentProjectEntryIDMap().get(nonCashBenefits.getProjectEntryID());
					if(uuid !=null) {
						Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, uuid);
						noncashbenefitsModel.setEnrollmentid(enrollmentModel);
					}
				}
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				noncashbenefitsModel.setExport(exportEntity);
				exportEntity.addNoncashbenefits(noncashbenefitsModel);
				insertOrUpdate(noncashbenefitsModel);
			}
		}

	}

	@Override
	public void hydrateLive(Export export) {
		Set<Noncashbenefits> noncashbenefitss = export.getNoncashbenefitss();
		if(noncashbenefitss != null && !noncashbenefitss.isEmpty()) {
			for(Noncashbenefits noncashbenefits : noncashbenefitss) {
				if(noncashbenefits != null) {
					com.servinglynk.hmis.warehouse.model.live.Noncashbenefits target = new com.servinglynk.hmis.warehouse.model.live.Noncashbenefits();
					BeanUtils.copyProperties(noncashbenefits, target,getNonCollectionFields(target));
					if(noncashbenefits.getEnrollmentid() !=null && noncashbenefits.getEnrollmentid().getId() !=null) {
						com.servinglynk.hmis.warehouse.model.live.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.live.Enrollment) get(com.servinglynk.hmis.warehouse.model.live.Enrollment.class, noncashbenefits.getEnrollmentid().getId());
						target.setEnrollmentid(enrollmentModel);
					}
					com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addNoncashbenefits(target);
					insertOrUpdate(target);
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
