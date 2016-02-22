/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.WorstHousingSituation;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.WorsthousingsituationWorsthousingsituationEnum;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Worsthousingsituation;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class WorsthousingsituationDaoImpl extends ParentDaoImpl implements
		WorsthousingsituationDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<WorstHousingSituation> worstHousingSituationList = domain.getExport().getWorstHousingSituation();
		if(worstHousingSituationList !=null && !worstHousingSituationList.isEmpty())
		{
			for(WorstHousingSituation worstHousingSituation : worstHousingSituationList)
			{
				Worsthousingsituation worsthousingsituationModel= new Worsthousingsituation();
				UUID id = UUID.randomUUID();
				worsthousingsituationModel.setId(id);
				worsthousingsituationModel.setDateCreated(LocalDateTime.now());
				worsthousingsituationModel.setDateUpdated(LocalDateTime.now());
				worsthousingsituationModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(worstHousingSituation.getDateCreated()));
				worsthousingsituationModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(worstHousingSituation.getDateUpdated()));
				worsthousingsituationModel.setWorsthousingsituation(WorsthousingsituationWorsthousingsituationEnum.lookupEnum(BasicDataGenerator.getStringValue(worstHousingSituation.getWorstHousingSituation())));
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				worsthousingsituationModel.setExport(exportEntity);
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(worstHousingSituation.getProjectEntryID()));
				worsthousingsituationModel.setEnrollmentid(enrollmentModel);
				exportEntity.addWorsthousingsituation(worsthousingsituationModel);
				hydrateCommonFields(worsthousingsituationModel, domain);
				insertOrUpdate(worsthousingsituationModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Worsthousingsituation> worsthousingsituations = export.getWorsthousingsituations();
		if(worsthousingsituations!=null && !worsthousingsituations.isEmpty()) {
			for(Worsthousingsituation worsthousingsituation : worsthousingsituations) {
				if(worsthousingsituation !=null) {
					com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation target = new com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation();
					BeanUtils.copyProperties(worsthousingsituation, target, getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.live.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.live.Enrollment) get(com.servinglynk.hmis.warehouse.model.live.Enrollment.class, worsthousingsituation.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addWorsthousingsituation(target);
					target.setDateCreated(LocalDateTime.now());
					target.setDateUpdated(LocalDateTime.now());
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
	
	
	   public com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation createWorsthousingsituation(com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation worsthousingsituation){
	       worsthousingsituation.setId(UUID.randomUUID()); 
	       insert(worsthousingsituation);
	       return worsthousingsituation;
	   }
	   public com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation updateWorsthousingsituation(com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation worsthousingsituation){
	       update(worsthousingsituation);
	       return worsthousingsituation;
	   }
	   public void deleteWorsthousingsituation(com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation worsthousingsituation){
	       delete(worsthousingsituation);
	   }
	   public com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation getWorsthousingsituationById(UUID worsthousingsituationId){ 
	       return (com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation) get(com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation.class, worsthousingsituationId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation> getAllEnrollmentWorsthousingsituations(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentWorsthousingsituationsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Worsthousingsituation.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
