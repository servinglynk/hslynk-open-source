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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Funder;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.FunderFunderEnum;
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2015.Project;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class FunderDaoImpl extends ParentDaoImpl implements FunderDao {
	private static final Logger logger = LoggerFactory
			.getLogger(FunderDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<Funder> funders = domain.getExport().getFunder();
	    com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap);
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Funder.class, getProjectGroupCode(domain));
		if(funders!=null && funders.size() > 0)
		{
			for(Funder funder : funders)
			{
				try {
					com.servinglynk.hmis.warehouse.model.v2015.Funder funderModel = getModelObject(domain, funder,data,modelMap);
					funderModel.setFunder(FunderFunderEnum.lookupEnum(BasicDataGenerator.getStringValue(funder.getFunder())));
					//funderModel.setGrantid(funder.getGrantID());
					funderModel.setStartdate(BasicDataGenerator.getLocalDateTime(funder.getStartDate()));
					funderModel.setEnddate(BasicDataGenerator.getLocalDateTime(funder.getEndDate()));
					funderModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(funder.getDateCreated()));
					funderModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(funder.getDateUpdated()));
					Project project = (Project) getModel(Project.class,funder.getProjectID(),getProjectGroupCode(domain),true,relatedModelMap);
					funderModel.setProjectid(project);
					funderModel.setExport(exportEntity);
					performSaveOrUpdate(funderModel);
				} catch(Exception e) {
					logger.error("Exception beause of the funder::"+funder.getFunderID() +" Exception ::"+e.getMessage());
					throw new Exception(e);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2015.Funder.class.getSimpleName(), domain,exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2015.Funder getModelObject(ExportDomain domain, Funder funder ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2015.Funder funderModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			funderModel = (com.servinglynk.hmis.warehouse.model.v2015.Funder) getModel(com.servinglynk.hmis.warehouse.model.v2015.Funder.class, funder.getFunderID(), getProjectGroupCode(domain),false,modelMap);
		
		if(funderModel == null) {
			funderModel = new com.servinglynk.hmis.warehouse.model.v2015.Funder();
			funderModel.setId(UUID.randomUUID());
			funderModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(funderModel, domain,funder.getFunderID(),data.i+data.j);
		return funderModel;
	}

	public void hydrateHBASE(SyncDomain domain) {
		/**
		 * Get the Last Synced record from the Sync table.
		 * Then fetch data between last sync date time and between the time Sync Began.
		 */
	}

	   public com.servinglynk.hmis.warehouse.model.v2015.Funder createFunder(com.servinglynk.hmis.warehouse.model.v2015.Funder funder){
	       funder.setId(UUID.randomUUID());
	       insert(funder);
	       return funder;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Funder updateFunder(com.servinglynk.hmis.warehouse.model.v2015.Funder funder){
	       update(funder);
	       return funder;
	   }
	   public void deleteFunder(com.servinglynk.hmis.warehouse.model.v2015.Funder funder){
	       delete(funder);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Funder getFunderById(UUID funderId){
	       return (com.servinglynk.hmis.warehouse.model.v2015.Funder) get(com.servinglynk.hmis.warehouse.model.v2015.Funder.class, funderId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Funder> getAllProjectFunders(UUID projectId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Funder.class);
	       criteria.createAlias("projectid", "projectid");
	       criteria.add(Restrictions.eq("projectid.id", projectId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Funder>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectFundersCount(UUID projectId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Funder.class);
	       criteria.createAlias("projectid", "projectid");
	       criteria.add(Restrictions.eq("projectid.id", projectId));
	       return countRows(criteria);
	   }

}
