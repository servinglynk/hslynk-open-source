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
import com.servinglynk.hmis.warehouse.model.v2015.Exit;
import com.servinglynk.hmis.warehouse.model.v2015.Export;
import com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition;
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
		hydrateBulkUploadActivityStaging(housingAssessmentDispositions, com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition.class.getSimpleName(), domain);
		if(housingAssessmentDispositions !=null && !housingAssessmentDispositions.isEmpty())
		{
			for(HousingAssessmentDisposition housingAssessmentDisposition : housingAssessmentDispositions)
			{
				Housingassessmentdisposition housingassessmentdispositionModel = new Housingassessmentdisposition();
				housingassessmentdispositionModel.setId(UUID.randomUUID());
				housingassessmentdispositionModel.setDateCreated(LocalDateTime.now());
				housingassessmentdispositionModel.setDateUpdated(LocalDateTime.now());
				housingassessmentdispositionModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(housingAssessmentDisposition.getDateCreated()));
				housingassessmentdispositionModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(housingAssessmentDisposition.getDateUpdated()));
				housingassessmentdispositionModel.setAssessmentdisposition(HousingassessmentdispositionAssessmentdispositionEnum.lookupEnum(BasicDataGenerator.getStringValue(housingAssessmentDisposition.getAssessmentDisposition())));
				housingassessmentdispositionModel.setOtherdisposition(housingAssessmentDisposition.getOtherDisposition());
				Exit exit = (Exit) get(Exit.class, domain.getExitMap().get(housingAssessmentDisposition.getExitID()));
				housingassessmentdispositionModel.setExitid(exit);
				com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, domain.getExportId());
				housingassessmentdispositionModel.setExport(exportEntity);
				exportEntity.addHousingassessmentdisposition(housingassessmentdispositionModel);
				hydrateCommonFields(housingassessmentdispositionModel, domain);
				insertOrUpdate(housingassessmentdispositionModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export, Long id) {
		Set<Housingassessmentdisposition> housingassessmentdispositions = export.getHousingassessmentdispositions();
		hydrateBulkUploadActivity(housingassessmentdispositions, com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition.class.getSimpleName(), export,id);
		if(housingassessmentdispositions !=null && !housingassessmentdispositions.isEmpty()) {
			for(Housingassessmentdisposition housingassessmentdisposition : housingassessmentdispositions) {
				if(housingassessmentdisposition !=null) {
					com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition target = new com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition();
					BeanUtils.copyProperties(housingassessmentdisposition, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2015.Exit exitModel = (com.servinglynk.hmis.warehouse.model.v2015.Exit) get(com.servinglynk.hmis.warehouse.model.v2015.Exit.class, housingassessmentdisposition.getExitid().getId());
					target.setExitid(exitModel);
					com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, export.getId());
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

	   public com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition createHousingAssessmentDisposition(com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition housingAssessmentDisposition){
	       housingAssessmentDisposition.setId(UUID.randomUUID());
	       insert(housingAssessmentDisposition);
	       return housingAssessmentDisposition;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition updateHousingAssessmentDisposition(com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition housingAssessmentDisposition){
	       update(housingAssessmentDisposition);
	       return housingAssessmentDisposition;
	   }
	   public void deleteHousingAssessmentDisposition(com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition housingAssessmentDisposition){
	       delete(housingAssessmentDisposition);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition getHousingAssessmentDispositionById(UUID housingAssessmentDispositionId){
	       return (com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition) get(com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition.class, housingAssessmentDispositionId);
	   }

	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition> getAllExitHousingAssessmentDispositions(UUID exitId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getExitHousingAssessmentDispositionsCount(UUID exitId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return countRows(criteria);
	   }
}
