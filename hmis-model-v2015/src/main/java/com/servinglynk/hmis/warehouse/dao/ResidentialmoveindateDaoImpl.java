/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ResidentialMoveInDate;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ResidentialmoveindateInpermanenthousingEnum;
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ResidentialmoveindateDaoImpl extends ParentDaoImpl implements
		ResidentialmoveindateDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ResidentialmoveindateDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) throws Exception {
		List<ResidentialMoveInDate> residentialMoveInDates = domain.getExport().getResidentialMoveInDate();
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false);
		Data data =new Data();
		if(residentialMoveInDates != null && !residentialMoveInDates.isEmpty())
		{
			for( ResidentialMoveInDate residentialMoveInDate : residentialMoveInDates)
			{
				try {
					Residentialmoveindate residentialmoveindateModel = getModelObject(domain, residentialMoveInDate, data);
					residentialmoveindateModel.setInpermanenthousing(ResidentialmoveindateInpermanenthousingEnum.lookupEnum(BasicDataGenerator.getStringValue(residentialMoveInDate.getInPermanentHousing())));
					residentialmoveindateModel.setResidentialmoveindate(BasicDataGenerator.getLocalDateTime(residentialMoveInDate.getResidentialMoveInDate()));
					residentialmoveindateModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(residentialMoveInDate.getDateCreated()));
					residentialmoveindateModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(residentialMoveInDate.getDateUpdated()));
					Enrollment enrollment = (Enrollment) getModel(Enrollment.class, residentialMoveInDate.getResidentialMoveInDateID(),getProjectGroupCode(domain),true);
					residentialmoveindateModel.setEnrollmentid(enrollment);
					residentialmoveindateModel.setExport(exportEntity);
					if(exportEntity !=null)
						exportEntity.addResidentialmoveindate(residentialmoveindateModel);
					performSaveOrUpdate(residentialmoveindateModel);
				}catch(Exception e) {
					logger.error("Exception beause of the residentialMoveInDate::"+residentialMoveInDate.getResidentialMoveInDateID() +" Exception ::"+e.getMessage());
					throw new Exception(e);
				}
			}
			hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate.class.getSimpleName(), domain,exportEntity);
		}
	}

	public com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate getModelObject(ExportDomain domain, ResidentialMoveInDate residentialmoveindate ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate residentialmoveindateModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			residentialmoveindateModel = (com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate) getModel(com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate.class, residentialmoveindate.getResidentialMoveInDateID(), getProjectGroupCode(domain),false);
		
		if(residentialmoveindateModel == null) {
			residentialmoveindateModel = new com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate();
			residentialmoveindateModel.setId(UUID.randomUUID());
			residentialmoveindateModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(residentialmoveindateModel, domain,residentialmoveindate.getResidentialMoveInDateID(),data.i+data.j);
		return residentialmoveindateModel;
	}
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}


	   public com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate createResidentialmoveindate(com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate residentialmoveindate){
	       residentialmoveindate.setId(UUID.randomUUID());
	       insert(residentialmoveindate);
	       return residentialmoveindate;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate updateResidentialmoveindate(com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate residentialmoveindate){
	       update(residentialmoveindate);
	       return residentialmoveindate;
	   }
	   public void deleteResidentialmoveindate(com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate residentialmoveindate){
	       delete(residentialmoveindate);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate getResidentialmoveindateById(UUID residentialmoveindateId){
	       return (com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate) get(com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate.class, residentialmoveindateId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate> getAllEnrollmentResidentialmoveindates(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentResidentialmoveindatesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
