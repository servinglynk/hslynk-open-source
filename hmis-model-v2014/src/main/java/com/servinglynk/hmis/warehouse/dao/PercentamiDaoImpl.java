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

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<PercentAMI> percentAMIs = domain.getExport().getPercentAMI();
		hydrateBulkUploadActivityStaging(percentAMIs, com.servinglynk.hmis.warehouse.model.v2014.Percentami.class.getSimpleName(), domain);
		int i=0;
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		if(percentAMIs !=null && !percentAMIs.isEmpty())
		{
			for(PercentAMI percentAMI :percentAMIs)
			{
				Percentami percentamoModel = new Percentami();
				UUID id = UUID.randomUUID();
				percentamoModel.setId(id);

				percentamoModel.setDateCreated(LocalDateTime.now());
				percentamoModel.setDateUpdated(LocalDateTime.now());
				percentamoModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(percentAMI.getDateCreated()));
				percentamoModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(percentAMI.getDateUpdated()));
				percentamoModel.setPercentage(BasicDataGenerator.getIntegerValue(percentAMI.getPercentAMI()));
				if(StringUtils.isNotBlank(percentAMI.getProjectEntryID())) {
					UUID uuid = domain.getEnrollmentProjectEntryIDMap().get((percentAMI.getProjectEntryID()));
					if(uuid !=null) {
						Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, uuid);
						percentamoModel.setEnrollmentid(enrollmentModel);
					}
				}
				percentamoModel.setExport(exportEntity);
				exportEntity.addPercentami(percentamoModel);
				i++;
				hydrateCommonFields(percentamoModel, domain, percentAMI.getPercentAMIID(),i);
			}
		}

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
