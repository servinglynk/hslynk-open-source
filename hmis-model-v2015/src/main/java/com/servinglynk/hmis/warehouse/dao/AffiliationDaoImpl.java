package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Affiliation;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.v2015.Project;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class AffiliationDaoImpl extends ParentDaoImpl implements AffiliationDao {
	private static final Logger logger = LoggerFactory
			.getLogger(AffiliationDaoImpl.class);
		@Override
		public void hydrateStaging(ExportDomain domain) throws Exception 
		{
			Export export = domain.getExport();
			List<Affiliation> affiliations = export.getAffiliation();
			Data data =new Data();
			com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,domain.getExport().getExportID(),getProjectGroupCode(domain),false);
			if(affiliations!=null && !affiliations.isEmpty())
			{
				for(Affiliation affiliation :affiliations )
				{
					try {
						com.servinglynk.hmis.warehouse.model.v2015.Affiliation affiliationModel = getModelObject(domain, affiliation, data);
						affiliationModel.setResprojectid(affiliation.getResProjectID());
						affiliationModel.setDateCreated(LocalDateTime.now());
						affiliationModel.setDateUpdated(LocalDateTime.now());
						Project project = (Project) getModel(Project.class,affiliation.getProjectID(),getProjectGroupCode(domain),true);
						affiliationModel.setExport(exportEntity);
						affiliationModel.setProjectid(project);
						exportEntity.addAffiliation(affiliationModel);
						affiliationModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(affiliation.getDateCreated()));
						affiliationModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(affiliation.getDateUpdated()));
						performSaveOrUpdate(affiliationModel);
					} catch(Exception e) {
						logger.error("Error occured with "+affiliation.getAffiliationID() + " Execption :::"+e.getLocalizedMessage());
						throw new Exception(e);
					}
				}
			}
			hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2015.Affiliation.class.getSimpleName(), domain, exportEntity);
		}

		
		public  com.servinglynk.hmis.warehouse.model.v2015.Affiliation getModelObject(ExportDomain domain, Affiliation affiliation,Data data) {
			com.servinglynk.hmis.warehouse.model.v2015.Affiliation affiliationModel = null;
			// We always insert for a Full refresh and update if the record exists for Delta refresh
			if(!isFullRefresh(domain))
				affiliationModel = (com.servinglynk.hmis.warehouse.model.v2015.Affiliation) getModel(com.servinglynk.hmis.warehouse.model.v2015.Affiliation.class, affiliation.getAffiliationID(), getProjectGroupCode(domain),false);
			
			if(affiliationModel == null) {
				affiliationModel = new com.servinglynk.hmis.warehouse.model.v2015.Affiliation();
				affiliationModel.setId(UUID.randomUUID());
				affiliationModel.setInserted(true);
				++data.i;
			}else{
				++data.j;
			}
			hydrateCommonFields(affiliationModel, domain,affiliation.getAffiliationID(),data.i+data.j);
			return affiliationModel;
		}

		@Override
		public void hydrateHBASE(SyncDomain syncDomain) {
			// TODO Auto-generated method stub
			
		}

		   public com.servinglynk.hmis.warehouse.model.v2015.Affiliation createAffiliation(com.servinglynk.hmis.warehouse.model.v2015.Affiliation affiliation){
		       affiliation.setId(UUID.randomUUID()); 
		       insert(affiliation);
		       return affiliation;
		   }
		   public com.servinglynk.hmis.warehouse.model.v2015.Affiliation updateAffiliation(com.servinglynk.hmis.warehouse.model.v2015.Affiliation affiliation){
		       update(affiliation);
		       return affiliation;
		   }
		   public void deleteAffiliation(com.servinglynk.hmis.warehouse.model.v2015.Affiliation affiliation){
		       delete(affiliation);
		   }
		   public com.servinglynk.hmis.warehouse.model.v2015.Affiliation getAffiliationById(UUID affiliationId){ 
		       return (com.servinglynk.hmis.warehouse.model.v2015.Affiliation) get(com.servinglynk.hmis.warehouse.model.v2015.Affiliation.class, affiliationId);
		   }
		   public List<com.servinglynk.hmis.warehouse.model.v2015.Affiliation> getAllProjectAffiliations(UUID projectId,Integer startIndex, Integer maxItems){
		       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Affiliation.class);
		       criteria.createAlias("projectid", "projectid");
		       criteria.add(Restrictions.eq("projectid.id", projectId));
		       return (List<com.servinglynk.hmis.warehouse.model.v2015.Affiliation>) findByCriteria(criteria,startIndex,maxItems);
		   }
		   public long getProjectAffiliationsCount(UUID projectId){
		       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Affiliation.class);
		       criteria.createAlias("projectid", "projectid");
		       criteria.add(Restrictions.eq("projectid.id", projectId));
		       return countRows(criteria);
		   }
		
}

