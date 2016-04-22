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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.SexualOrientation;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.SexualorientationSexualorientationEnum;
import com.servinglynk.hmis.warehouse.model.stagv2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.stagv2014.Export;
import com.servinglynk.hmis.warehouse.model.stagv2014.Sexualorientation;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class SexualorientationDaoImpl extends ParentDaoImpl implements
		SexualorientationDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<SexualOrientation> sexualOrientations = domain.getExport().getSexualOrientation();
		hydrateBulkUploadActivityStaging(sexualOrientations, com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation.class.getSimpleName(), domain);
		int i=0;
		com.servinglynk.hmis.warehouse.model.stagv2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2014.Export) get(com.servinglynk.hmis.warehouse.model.stagv2014.Export.class, domain.getExportId());
		if(sexualOrientations !=null && !sexualOrientations.isEmpty())
		{
			for(SexualOrientation sexualOrientation : sexualOrientations)
			{
				Sexualorientation sexualorientationModel = new Sexualorientation();
				UUID id = UUID.randomUUID();
				sexualorientationModel.setId(id);
				sexualorientationModel.setDateCreated(LocalDateTime.now());
				sexualorientationModel.setDateUpdated(LocalDateTime.now());
				sexualorientationModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(sexualOrientation.getDateCreated()));
				sexualorientationModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(sexualOrientation.getDateUpdated()));
				sexualorientationModel.setSexualorientation(SexualorientationSexualorientationEnum.lookupEnum(BasicDataGenerator.getStringValue(sexualOrientation.getSexualOrientation())));
				
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(sexualOrientation.getProjectEntryID()));
				sexualorientationModel.setEnrollmentid(enrollmentModel);
				sexualorientationModel.setExport(exportEntity);
				exportEntity.addSexualorientation(sexualorientationModel);
				i++;
				hydrateCommonFields(sexualorientationModel, domain,sexualOrientation.getSexualOrientationID(),i++);
				insert(sexualorientationModel);
			}
		}

	}

	@Override
	public void hydrateLive(Export export, Long id) {
		Set<Sexualorientation> sexualorientations = export.getSexualorientations();
		hydrateBulkUploadActivity(sexualorientations,com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation.class.getSimpleName(), export,id);
		if(sexualorientations !=null && !sexualorientations.isEmpty()) {
			for(Sexualorientation sexualorientation : sexualorientations) {
				if(sexualorientation != null) {
					com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation target = new com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation();
					BeanUtils.copyProperties(sexualorientation,target, getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2014.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2014.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, sexualorientation.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addSexualorientation(target);
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
	
	   public com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation createSexualorientation(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation sexualorientation){
	       sexualorientation.setId(UUID.randomUUID()); 
	       insert(sexualorientation);
	       return sexualorientation;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation updateSexualorientation(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation sexualorientation){
	       update(sexualorientation);
	       return sexualorientation;
	   }
	   public void deleteSexualorientation(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation sexualorientation){
	       delete(sexualorientation);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation getSexualorientationById(UUID sexualorientationId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation) get(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation.class, sexualorientationId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation> getAllEnrollmentSexualorientations(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentSexualorientationsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
