/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.WorstHousingSituation;
import com.servinglynk.hmis.warehouse.enums.WorsthousingsituationWorsthousingsituationEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class WorsthousingsituationDaoImpl extends ParentDaoImpl implements
		WorsthousingsituationDao {
	private static final Logger logger = LoggerFactory
			.getLogger(WorsthousingsituationDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<WorstHousingSituation> worstHousingSituationList = domain.getExport().getWorstHousingSituation();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap);
		if(worstHousingSituationList !=null && !worstHousingSituationList.isEmpty())
		{
			for(WorstHousingSituation worstHousingSituation : worstHousingSituationList)
			{
				try {
					Worsthousingsituation worsthousingsituationModel= getModelObject(domain, worstHousingSituation,data,modelMap);
					worsthousingsituationModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(worstHousingSituation.getDateCreated()));
					worsthousingsituationModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(worstHousingSituation.getDateUpdated()));
					worsthousingsituationModel.setWorsthousingsituation(WorsthousingsituationWorsthousingsituationEnum.lookupEnum(BasicDataGenerator.getStringValue(worstHousingSituation.getWorstHousingSituation())));
					worsthousingsituationModel.setExport(exportEntity);
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class,worstHousingSituation.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap);
					worsthousingsituationModel.setEnrollmentid(enrollmentModel);
					performSaveOrUpdate(worsthousingsituationModel);
				}catch(Exception e) {
					logger.error("Exception in worstHousingSituation:"+worstHousingSituation.getProjectEntryID()+  ":: Exception" +e.getLocalizedMessage());
					throw new Exception(e);
				}
			
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, Worsthousingsituation.class.getSimpleName(), domain, exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation getModelObject(ExportDomain domain, WorstHousingSituation worsthousingsituation ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation worsthousingsituationModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			worsthousingsituationModel = (com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation) getModel(com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation.class, worsthousingsituation.getWorstHousingSituationID(), getProjectGroupCode(domain),false,modelMap);
		
		if(worsthousingsituationModel == null) {
			worsthousingsituationModel = new com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation();
			worsthousingsituationModel.setId(UUID.randomUUID());
			worsthousingsituationModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(worsthousingsituationModel, domain,worsthousingsituation.getWorstHousingSituationID(),data.i+data.j);
		return worsthousingsituationModel;
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
