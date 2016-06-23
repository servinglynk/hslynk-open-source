/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.WorstHousingSituation;
import com.servinglynk.hmis.warehouse.enums.WorsthousingsituationWorsthousingsituationEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation;
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
		hydrateBulkUploadActivityStaging(worstHousingSituationList, com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation.class.getSimpleName(), domain);
		int i=0;
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
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
				worsthousingsituationModel.setExport(exportEntity);
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(worstHousingSituation.getProjectEntryID()));
				worsthousingsituationModel.setEnrollmentid(enrollmentModel);
				exportEntity.addWorsthousingsituation(worsthousingsituationModel);
				i++;
				hydrateCommonFields(worsthousingsituationModel, domain, worstHousingSituation.getWorstHousingSituationID(),i);
			}
		}
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation createWorsthousingsituation(com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation worsthousingsituation){
	       worsthousingsituation.setId(UUID.randomUUID()); 
	       insert(worsthousingsituation);
	       return worsthousingsituation;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation updateWorsthousingsituation(com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation worsthousingsituation){
	       update(worsthousingsituation);
	       return worsthousingsituation;
	   }
	   public void deleteWorsthousingsituation(com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation worsthousingsituation){
	       delete(worsthousingsituation);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation getWorsthousingsituationById(UUID worsthousingsituationId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation) get(com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation.class, worsthousingsituationId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation> getAllEnrollmentWorsthousingsituations(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentWorsthousingsituationsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
