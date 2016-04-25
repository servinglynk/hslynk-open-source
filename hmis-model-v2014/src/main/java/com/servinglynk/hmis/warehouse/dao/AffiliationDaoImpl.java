package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Affiliation;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.v2014.Project;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class AffiliationDaoImpl extends ParentDaoImpl implements AffiliationDao {

		@Override
		public void hydrateStaging(ExportDomain domain) 
		{
			Export export = domain.getExport();
			List<Affiliation> affiliations = export.getAffiliation();
			hydrateBulkUploadActivityStaging(affiliations, com.servinglynk.hmis.warehouse.model.v2014.Affiliation.class.getSimpleName(), domain);
			if(affiliations!=null && !affiliations.isEmpty())
			{
				int i=0;
				for(Affiliation affiliation :affiliations )
				{
					com.servinglynk.hmis.warehouse.model.v2014.Affiliation affiliationModel = new com.servinglynk.hmis.warehouse.model.v2014.Affiliation();
					affiliationModel.setId(UUID.randomUUID());
					affiliationModel.setResprojectid(affiliation.getResProjectID());
					affiliationModel.setDateCreated(LocalDateTime.now());
					affiliationModel.setDateUpdated(LocalDateTime.now());
					Project project = (Project) get(Project.class,domain.getAffiliationProjectMap().get(affiliation.getProjectID()));
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
					affiliationModel.setExport(exportEntity);
					affiliationModel.setProjectid(project);
					exportEntity.addAffiliation(affiliationModel);
					affiliationModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(affiliation.getDateCreated()));
					affiliationModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(affiliation.getDateUpdated()));
					i++;
					hydrateCommonFields(affiliationModel, domain,affiliation.getAffiliationID(),i);
					insert(affiliationModel);
				}
			}
		}

		@Override
		public void hydrateLive(
				com.servinglynk.hmis.warehouse.model.v2014.Export export, Long id) {
			Set<com.servinglynk.hmis.warehouse.model.v2014.Affiliation> affiliations = export.getAffiliations();
			hydrateBulkUploadActivity(affiliations, com.servinglynk.hmis.warehouse.model.v2014.Affiliation.class.getSimpleName(), export,id);
			if(affiliations !=null && !affiliations.isEmpty()) {
				for(com.servinglynk.hmis.warehouse.model.v2014.Affiliation affiliation : affiliations ) {
					 com.servinglynk.hmis.warehouse.model.v2014.Affiliation target = new com.servinglynk.hmis.warehouse.model.v2014.Affiliation();
					 BeanUtils.copyProperties(affiliation, target,getNonCollectionFields(target));
					 com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getId());
					 target.setExport(exportEntity);
					 com.servinglynk.hmis.warehouse.model.v2014.Project projectModel = (com.servinglynk.hmis.warehouse.model.v2014.Project) get(com.servinglynk.hmis.warehouse.model.v2014.Project.class,affiliation.getProjectid().getId());
					 target.setProjectid(projectModel);
					 target.setDateCreated(LocalDateTime.now());
					 target.setDateUpdated(LocalDateTime.now());
					 insert(target);
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
		
		   public com.servinglynk.hmis.warehouse.model.v2014.Affiliation createAffiliation(com.servinglynk.hmis.warehouse.model.v2014.Affiliation affiliation){
		       affiliation.setId(UUID.randomUUID()); 
		       insert(affiliation);
		       return affiliation;
		   }
		   public com.servinglynk.hmis.warehouse.model.v2014.Affiliation updateAffiliation(com.servinglynk.hmis.warehouse.model.v2014.Affiliation affiliation){
		       update(affiliation);
		       return affiliation;
		   }
		   public void deleteAffiliation(com.servinglynk.hmis.warehouse.model.v2014.Affiliation affiliation){
		       delete(affiliation);
		   }
		   public com.servinglynk.hmis.warehouse.model.v2014.Affiliation getAffiliationById(UUID affiliationId){ 
		       return (com.servinglynk.hmis.warehouse.model.v2014.Affiliation) get(com.servinglynk.hmis.warehouse.model.v2014.Affiliation.class, affiliationId);
		   }
		   public List<com.servinglynk.hmis.warehouse.model.v2014.Affiliation> getAllProjectAffiliations(UUID projectId,Integer startIndex, Integer maxItems){
		       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Affiliation.class);
		       criteria.createAlias("projectid", "projectid");
		       criteria.add(Restrictions.eq("projectid.id", projectId));
		       return (List<com.servinglynk.hmis.warehouse.model.v2014.Affiliation>) findByCriteria(criteria,startIndex,maxItems);
		   }
		   public long getProjectAffiliationsCount(UUID projectId){
		       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Affiliation.class);
		       criteria.createAlias("projectid", "projectid");
		       criteria.add(Restrictions.eq("projectid.id", projectId));
		       return countRows(criteria);
		   }
		
}

