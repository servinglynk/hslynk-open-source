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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Funder;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.FunderFunderEnum;
import com.servinglynk.hmis.warehouse.model.stagv2015.Export;
import com.servinglynk.hmis.warehouse.model.stagv2015.Project;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class FunderDaoImpl extends ParentDaoImpl implements FunderDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<Funder> funders = domain.getExport().getFunder();
		hydrateBulkUploadActivityStaging(funders, com.servinglynk.hmis.warehouse.model.v2015.Funder.class.getSimpleName(), domain);
		if(funders!=null && funders.size() > 0)
		{
			for(Funder funder : funders)
			{
				com.servinglynk.hmis.warehouse.model.stagv2015.Funder funderModel = new com.servinglynk.hmis.warehouse.model.stagv2015.Funder();
				UUID id = UUID.randomUUID();
				funderModel.setId(id);
				funderModel.setFunder(FunderFunderEnum.lookupEnum(BasicDataGenerator.getStringValue(funder.getFunder())));
				//funderModel.setGrantid(funder.getGrantID());
				funderModel.setStartdate(BasicDataGenerator.getLocalDateTime(funder.getStartDate()));
				funderModel.setEnddate(BasicDataGenerator.getLocalDateTime(funder.getEndDate()));

				funderModel.setDateCreated(LocalDateTime.now());
				funderModel.setDateUpdated(LocalDateTime.now());
				funderModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(funder.getDateCreated()));
				funderModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(funder.getDateUpdated()));
				UUID uuid = domain.getAffiliationProjectMap().get(funder.getProjectID());
				if(uuid !=null) {
					Project project = (Project) get(Project.class,uuid);
					funderModel.setProjectid(project);
				}
				com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, domain.getExportId());
				funderModel.setExport(exportEntity);
				
				hydrateCommonFields(funderModel, domain);
				exportEntity.addFunder(funderModel);
				insertOrUpdate(funderModel);
			}
		}

	}

	@Override
	public void hydrateLive(Export export) {
		Set<com.servinglynk.hmis.warehouse.model.stagv2015.Funder> funders = export.getFunders();
		hydrateBulkUploadActivity(funders, com.servinglynk.hmis.warehouse.model.v2015.Funder.class.getSimpleName(), export);
		if(funders !=null && !funders.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.stagv2015.Funder funder : funders) {
				if(funder != null) {
					com.servinglynk.hmis.warehouse.model.v2015.Funder target = new com.servinglynk.hmis.warehouse.model.v2015.Funder();
					BeanUtils.copyProperties(funder, target,getNonCollectionFields(target));
					 com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, export.getId());
					 target.setExport(exportEntity);
					 if(funder.getProjectid() !=null) {
						 com.servinglynk.hmis.warehouse.model.v2015.Project projectModel = (com.servinglynk.hmis.warehouse.model.v2015.Project) get(com.servinglynk.hmis.warehouse.model.v2015.Project.class,funder.getProjectid().getId());
						 target.setProjectid(projectModel);
					 }
					 target.setDateCreated(LocalDateTime.now());
					 target.setDateUpdated(LocalDateTime.now());
					insert(target);
				}
			}
		}
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

	@Override
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
