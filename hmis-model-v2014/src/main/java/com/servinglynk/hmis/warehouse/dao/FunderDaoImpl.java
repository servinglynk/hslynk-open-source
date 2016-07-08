/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Funder;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Funder;
import com.servinglynk.hmis.warehouse.enums.FunderFunderEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Project;
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
	public void hydrateStaging(ExportDomain domain) throws Exception {
		List<Funder> funders = domain.getExport().getFunder();
		Long i=new Long(0L);
		Data data =new Data();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false);
		if(funders!=null && funders.size() > 0)
		{
			for(Funder funder : funders)
			{
				try{
				com.servinglynk.hmis.warehouse.model.v2014.Funder funderModel = getModelObject(domain, funder,data);
				funderModel.setFunder(FunderFunderEnum.lookupEnum(BasicDataGenerator.getStringValue(funder.getFunder())));
				funderModel.setGrantid(funder.getGrantID());
				funderModel.setStartdate(BasicDataGenerator.getLocalDateTime(funder.getStartDate()));
				funderModel.setEnddate(BasicDataGenerator.getLocalDateTime(funder.getEndDate()));
				funderModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(funder.getDateCreated()));
				funderModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(funder.getDateUpdated()));
				Project project = (Project) getModel(Project.class,funder.getFunderID(),getProjectGroupCode(domain),false);
				funderModel.setExport(exportEntity);
				funderModel.setProjectid(project);
				if(exportEntity != null)
					exportEntity.addFunder(funderModel);
				performSaveOrUpdate(funderModel);
			}catch (Exception e) {
				logger.error("Exception in Funder :"+funder.getFunderID()+  ":: Exception" +e.getLocalizedMessage());
				throw new Exception(e);
			}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Funder.class.getSimpleName(), domain,exportEntity);
	}
	
	public  com.servinglynk.hmis.warehouse.model.v2014.Funder getModelObject(ExportDomain domain, Funder funder ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2014.Funder funderModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			funderModel = (com.servinglynk.hmis.warehouse.model.v2014.Funder) getModel(com.servinglynk.hmis.warehouse.model.v2014.Funder.class, funder.getFunderID(), getProjectGroupCode(domain),false);
		
		if(funderModel == null) {
			funderModel = new com.servinglynk.hmis.warehouse.model.v2014.Funder();
			funderModel.setId(UUID.randomUUID());
			funderModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(funderModel, domain,funder.getFunderID(),data.i+data.j);
		return funderModel;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Funder createFunder(com.servinglynk.hmis.warehouse.model.v2014.Funder funder){
	       funder.setId(UUID.randomUUID()); 
	       insert(funder);
	       return funder;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Funder updateFunder(com.servinglynk.hmis.warehouse.model.v2014.Funder funder){
	       update(funder);
	       return funder;
	   }
	   public void deleteFunder(com.servinglynk.hmis.warehouse.model.v2014.Funder funder){
	       delete(funder);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Funder getFunderById(UUID funderId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Funder) get(com.servinglynk.hmis.warehouse.model.v2014.Funder.class, funderId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Funder> getAllProjectFunders(UUID projectId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Funder.class);
	       criteria.createAlias("projectid", "projectid");
	       criteria.add(Restrictions.eq("projectid.id", projectId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Funder>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectFundersCount(UUID projectId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Funder.class);
	       criteria.createAlias("projectid", "projectid");
	       criteria.add(Restrictions.eq("projectid.id", projectId));
	       return countRows(criteria);
	   }

}
