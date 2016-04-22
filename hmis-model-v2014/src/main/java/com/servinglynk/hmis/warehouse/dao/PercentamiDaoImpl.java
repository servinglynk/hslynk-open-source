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
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.PercentAMI;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.stagv2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.stagv2014.Export;
import com.servinglynk.hmis.warehouse.model.stagv2014.Percentami;
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
				
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(percentAMI.getProjectEntryID()));
				percentamoModel.setEnrollmentid(enrollmentModel);
				com.servinglynk.hmis.warehouse.model.stagv2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2014.Export) get(com.servinglynk.hmis.warehouse.model.stagv2014.Export.class, domain.getExportId());
				percentamoModel.setExport(exportEntity);
				exportEntity.addPercentami(percentamoModel);
				hydrateCommonFields(percentamoModel, domain, percentAMI.getPercentAMIID());
				insert(percentamoModel);
				i++;
				  if(i % batchSize() == 0 && i > 0) {
	                    getCurrentSession().flush();
	                    getCurrentSession().clear();
	                }
			}
		}

	}

	@Override
	public void hydrateLive(Export export, Long id) {
		Set<Percentami> percentamis = export.getPercentamis();
		hydrateBulkUploadActivity(percentamis, com.servinglynk.hmis.warehouse.model.v2014.Percentami.class.getSimpleName(), export,id);
		if(percentamis !=null && !percentamis.isEmpty()) {
			for(Percentami percentami : percentamis) {
				if(percentami != null) {
					com.servinglynk.hmis.warehouse.model.v2014.Percentami  target = new com.servinglynk.hmis.warehouse.model.v2014.Percentami();
					BeanUtils.copyProperties(percentami, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2014.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2014.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, percentami.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addPercentami(target);
					target.setDateCreated(LocalDateTime.now());
					target.setDateUpdated(LocalDateTime.now());
					insertOrUpdate(target);
				}
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
