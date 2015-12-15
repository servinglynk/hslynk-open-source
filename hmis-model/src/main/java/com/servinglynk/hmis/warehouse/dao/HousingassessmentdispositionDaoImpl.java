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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HousingAssessmentDisposition;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.HousingassessmentdispositionAssessmentdispositionEnum;
import com.servinglynk.hmis.warehouse.model.staging.Exit;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Housingassessmentdisposition;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class HousingassessmentdispositionDaoImpl extends ParentDaoImpl
		implements HousingassessmentdispositionDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<HousingAssessmentDisposition> housingAssessmentDispositions = domain.getExport().getHousingAssessmentDisposition();
		if(housingAssessmentDispositions !=null && !housingAssessmentDispositions.isEmpty()) 
		{
			for(HousingAssessmentDisposition housingAssessmentDisposition : housingAssessmentDispositions)
			{
				Housingassessmentdisposition housingassessmentdispositionModel = new Housingassessmentdisposition();
				housingassessmentdispositionModel.setId(UUID.randomUUID());
				housingassessmentdispositionModel.setDateCreated(BasicDataGenerator.getLocalDateTime(housingAssessmentDisposition.getDateCreated()));
				housingassessmentdispositionModel.setDateUpdated(BasicDataGenerator.getLocalDateTime(housingAssessmentDisposition.getDateUpdated()));
				housingassessmentdispositionModel.setAssessmentdisposition(HousingassessmentdispositionAssessmentdispositionEnum.lookupEnum(BasicDataGenerator.getStringValue(housingAssessmentDisposition.getAssessmentDisposition())));
				housingassessmentdispositionModel.setOtherdisposition(housingAssessmentDisposition.getOtherDisposition());
				Exit exit = (Exit) get(Exit.class, domain.getExitMap().get(housingAssessmentDisposition.getExitID()));
				housingassessmentdispositionModel.setExitid(exit);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				housingassessmentdispositionModel.setExport(exportEntity);
				exportEntity.addHousingassessmentdisposition(housingassessmentdispositionModel);
				hydrateCommonFields(housingassessmentdispositionModel, exportEntity.getUser());
				insertOrUpdate(housingassessmentdispositionModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Housingassessmentdisposition> housingassessmentdispositions = export.getHousingassessmentdispositions();
		if(housingassessmentdispositions !=null && !housingassessmentdispositions.isEmpty()) {
			for(Housingassessmentdisposition housingassessmentdisposition : housingassessmentdispositions) {
				if(housingassessmentdisposition !=null) {
					com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition target = new com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition();
					BeanUtils.copyProperties(housingassessmentdisposition, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.live.Exit exitModel = (com.servinglynk.hmis.warehouse.model.live.Exit) get(com.servinglynk.hmis.warehouse.model.live.Exit.class, housingassessmentdisposition.getExitid().getId());
					target.setExitid(exitModel);
					com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addHousingassessmentdisposition(target);
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

	   public com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition createHousingAssessmentDisposition(com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition housingAssessmentDisposition){
	       housingAssessmentDisposition.setId(UUID.randomUUID()); 
	       insert(housingAssessmentDisposition);
	       return housingAssessmentDisposition;
	   }
	   public com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition updateHousingAssessmentDisposition(com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition housingAssessmentDisposition){
	       update(housingAssessmentDisposition);
	       return housingAssessmentDisposition;
	   }
	   public void deleteHousingAssessmentDisposition(com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition housingAssessmentDisposition){
	       delete(housingAssessmentDisposition);
	   }
	   public com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition getHousingAssessmentDispositionById(UUID housingAssessmentDispositionId){ 
	       return (com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition) get(com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition.class, housingAssessmentDispositionId);
	   }
	   
	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition> getAllExitHousingAssessmentDispositions(UUID exitId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("enrollmentid.id", exitId));
	       return (List<com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getExitHousingAssessmentDispositionsCount(UUID exitId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("enrollmentid.id", exitId));
	       return countRows(criteria);
	   }
}
