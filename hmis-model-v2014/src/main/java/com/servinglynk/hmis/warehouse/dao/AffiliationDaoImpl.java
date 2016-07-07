package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Affiliation;
import com.servinglynk.hmis.warehouse.model.v2014.Project;

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
			Long i=new Long(0L);
			Data data =new Data();
			com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain));
			if(affiliations!=null && !affiliations.isEmpty())
			{
				for(Affiliation affiliation :affiliations )
				{
					try {
						com.servinglynk.hmis.warehouse.model.v2014.Affiliation affiliationModel = getModelObject(domain, affiliation,data);
						Project project = (Project) getModel(Project.class, affiliation.getProjectID(), affiliationModel.getProjectGroupCode());
						affiliationModel.setProjectid(project);
						affiliationModel.setExport(exportEntity);
						if(exportEntity !=null)
							exportEntity.addAffiliation(affiliationModel);
						affiliationModel.setResprojectid(affiliation.getResProjectID());
						performSaveOrUpdate(affiliationModel);
					}catch(Exception e) {
						logger.error("Error occured with "+affiliation.toString() + " Execption :::"+e.getLocalizedMessage());
						throw new Exception(e);
					}
				}
				hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Affiliation.class.getSimpleName(), domain, exportEntity);
			}
		}
			
		public  com.servinglynk.hmis.warehouse.model.v2014.Affiliation getModelObject(ExportDomain domain, Affiliation affiliation,Data data) {
			com.servinglynk.hmis.warehouse.model.v2014.Affiliation affiliationModel = null;
			// We always insert for a Full refresh and update if the record exists for Delta refresh
			if(!isFullRefresh(domain))
				affiliationModel = (com.servinglynk.hmis.warehouse.model.v2014.Affiliation) getModel(com.servinglynk.hmis.warehouse.model.v2014.Affiliation.class, affiliation.getAffiliationID(), getProjectGroupCode(domain));
			
			if(affiliationModel == null) {
				affiliationModel = new com.servinglynk.hmis.warehouse.model.v2014.Affiliation();
				affiliationModel.setId(UUID.randomUUID());
				affiliationModel.setInserted(true);
				++data.i;
			}else{
				++data.j;
			}
			hydrateCommonFields(affiliationModel, domain,affiliation.getAffiliationID(),data.i+data.j);
			return affiliationModel;
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

