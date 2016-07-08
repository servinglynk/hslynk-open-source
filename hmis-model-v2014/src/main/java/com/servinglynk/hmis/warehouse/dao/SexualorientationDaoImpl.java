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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.SexualOrientation;
import com.servinglynk.hmis.warehouse.enums.SexualorientationSexualorientationEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class SexualorientationDaoImpl extends ParentDaoImpl implements
		SexualorientationDao {
	private static final Logger logger = LoggerFactory
			.getLogger(SexualorientationDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) throws Exception {
		List<SexualOrientation> sexualOrientations = domain.getExport().getSexualOrientation();
		Long i=new Long(0L);
		Data data =new Data();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false);
		if(sexualOrientations !=null && !sexualOrientations.isEmpty())
		{
			for(SexualOrientation sexualOrientation : sexualOrientations)
			{
				try {
					Sexualorientation sexualorientationModel = getModelObject(domain, sexualOrientation,data);
					sexualorientationModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(sexualOrientation.getDateCreated()));
					sexualorientationModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(sexualOrientation.getDateUpdated()));
					sexualorientationModel.setSexualorientation(SexualorientationSexualorientationEnum.lookupEnum(BasicDataGenerator.getStringValue(sexualOrientation.getSexualOrientation())));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class,sexualOrientation.getProjectEntryID(),getProjectGroupCode(domain),true);
					sexualorientationModel.setEnrollmentid(enrollmentModel);
					sexualorientationModel.setExport(exportEntity);
					if(exportEntity !=null)
						exportEntity.addSexualorientation(sexualorientationModel);
					performSaveOrUpdate(sexualorientationModel);
				} catch(Exception e) {
					logger.error("Failure in Sexualorientation:::"+sexualOrientation.toString()+ " with exception"+e.getLocalizedMessage());
					throw new Exception(e);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation.class.getSimpleName(), domain,exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation getModelObject(ExportDomain domain,SexualOrientation sexualorientation ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation SexualorientationModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			SexualorientationModel = (com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation) getModel(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation.class, sexualorientation.getSexualOrientationID(), getProjectGroupCode(domain),false);
		
		if(SexualorientationModel == null) {
			SexualorientationModel = new com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation();
			SexualorientationModel.setId(UUID.randomUUID());
			SexualorientationModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(SexualorientationModel, domain,sexualorientation.getSexualOrientationID(),data.i+data.j);
		return SexualorientationModel;
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
