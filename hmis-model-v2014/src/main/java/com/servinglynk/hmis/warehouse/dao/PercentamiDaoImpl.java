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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.PercentAMI;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Percentami;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class PercentamiDaoImpl extends ParentDaoImpl implements PercentamiDao {
	private static final Logger logger = LoggerFactory
			.getLogger(PercentamiDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) throws Exception {
		List<PercentAMI> percentAMIs = domain.getExport().getPercentAMI();
		Long i=new Long(0L);
		Data data =new Data();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false);
		if(percentAMIs !=null && !percentAMIs.isEmpty())
		{
			for(PercentAMI percentAMI :percentAMIs)
			{
				try {
					Percentami percentamoModel = getModelObject(domain, percentAMI,data);
					percentamoModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(percentAMI.getDateCreated()));
					percentamoModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(percentAMI.getDateUpdated()));
					percentamoModel.setPercentage(BasicDataGenerator.getIntegerValue(percentAMI.getPercentAMI()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, percentAMI.getProjectEntryID(),getProjectGroupCode(domain),true);
					percentamoModel.setEnrollmentid(enrollmentModel);
					percentamoModel.setExport(exportEntity);
					if(exportEntity !=null)
						exportEntity.addPercentami(percentamoModel);
					performSaveOrUpdate(percentamoModel);
				} catch(Exception e) {
					 logger.error("Failure in Percentami:::"+percentAMI.toString()+ " with exception"+e.getLocalizedMessage());
					 throw new Exception(e);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, Percentami.class.getSimpleName(), domain, exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Percentami getModelObject(ExportDomain domain,PercentAMI percentami ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2014.Percentami percentamiModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			percentamiModel = (com.servinglynk.hmis.warehouse.model.v2014.Percentami) getModel(com.servinglynk.hmis.warehouse.model.v2014.Percentami.class, percentami.getPercentAMIID(), getProjectGroupCode(domain),false);
		
		if(percentamiModel == null) {
			percentamiModel = new com.servinglynk.hmis.warehouse.model.v2014.Percentami();
			percentamiModel.setId(UUID.randomUUID());
			percentamiModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(percentamiModel, domain,percentami.getPercentAMIID(),data.i+data.j);
		return percentamiModel;
	}
	 public com.servinglynk.hmis.warehouse.model.v2014.Percentami createPercentami(com.servinglynk.hmis.warehouse.model.v2014.Percentami percentami){
	       percentami.setId(UUID.randomUUID()); 
	       insert(percentami);
	       return percentami;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Percentami updatePercentami(com.servinglynk.hmis.warehouse.model.v2014.Percentami percentami){
	       update(percentami);
	       return percentami;
	   }
	   public void deletePercentami(com.servinglynk.hmis.warehouse.model.v2014.Percentami percentami){
	       delete(percentami);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Percentami getPercentamiById(UUID percentamiId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Percentami) get(com.servinglynk.hmis.warehouse.model.v2014.Percentami.class, percentamiId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Percentami> getAllEnrollmentPercentamis(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Percentami.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Percentami>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentPercentamisCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Percentami.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
