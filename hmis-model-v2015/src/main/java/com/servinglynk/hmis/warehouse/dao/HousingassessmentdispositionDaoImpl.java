/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HousingAssessmentDisposition;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.HousingassessmentdispositionAssessmentdispositionEnum;
import com.servinglynk.hmis.warehouse.model.v2015.Exit;
import com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class HousingassessmentdispositionDaoImpl extends ParentDaoImpl
		implements HousingassessmentdispositionDao {
	private static final Logger logger = LoggerFactory
			.getLogger(HousingassessmentdispositionDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) throws Exception {
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false);
		Data data =new Data();
		List<HousingAssessmentDisposition> housingAssessmentDispositions = domain.getExport().getHousingAssessmentDisposition();
		if(housingAssessmentDispositions !=null && !housingAssessmentDispositions.isEmpty())
		{
			for(HousingAssessmentDisposition housingAssessmentDisposition : housingAssessmentDispositions)
			{
				try {
					Housingassessmentdisposition housingassessmentdispositionModel = getModelObject(domain, housingAssessmentDisposition, data);
					housingassessmentdispositionModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(housingAssessmentDisposition.getDateCreated()));
					housingassessmentdispositionModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(housingAssessmentDisposition.getDateUpdated()));
					housingassessmentdispositionModel.setAssessmentdisposition(HousingassessmentdispositionAssessmentdispositionEnum.lookupEnum(BasicDataGenerator.getStringValue(housingAssessmentDisposition.getAssessmentDisposition())));
					housingassessmentdispositionModel.setOtherdisposition(housingAssessmentDisposition.getOtherDisposition());
					Exit exit = (Exit) getModel(Exit.class,housingAssessmentDisposition.getExitID(),getProjectGroupCode(domain),true);
					housingassessmentdispositionModel.setExitid(exit);
					housingassessmentdispositionModel.setExport(exportEntity);
					if(exportEntity !=null)
						exportEntity.addHousingassessmentdisposition(housingassessmentdispositionModel);
					performSaveOrUpdate(housingassessmentdispositionModel);
				}catch(Exception e){
					logger.error("Exception beause of the housingAssessmentDisposition::"+housingAssessmentDisposition.getHousingAssessmentDispositionID() +" Exception ::"+e.getMessage());
					throw new Exception(e);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition.class.getSimpleName(), domain,exportEntity);
	}

	public com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition getModelObject(ExportDomain domain, HousingAssessmentDisposition housingassessmentdisposition ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition housingassessmentdispositionModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			housingassessmentdispositionModel = (com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition) getModel(com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition.class, housingassessmentdisposition.getHousingAssessmentDispositionID(), getProjectGroupCode(domain),false);
		
		if(housingassessmentdispositionModel == null) {
			housingassessmentdispositionModel = new com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition();
			housingassessmentdispositionModel.setId(UUID.randomUUID());
			housingassessmentdispositionModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(housingassessmentdispositionModel, domain,housingassessmentdisposition.getHousingAssessmentDispositionID(),data.i+data.j);
		return housingassessmentdispositionModel;
	}
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

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
