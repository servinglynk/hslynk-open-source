package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Event;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.EventTypeEnum;
import com.servinglynk.hmis.warehouse.enums.NoYesEnum;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2020.Error2020;
import com.servinglynk.hmis.warehouse.model.v2020.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class EventDaoImpl extends ParentDaoImpl implements EventDao {
	private static final Logger logger = LoggerFactory
			.getLogger(EventDaoImpl.class);
		@Override
		public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception 
		{
			Export export = domain.getExport();
			List<Event> events = export.getEvent();
			Data data =new Data();
			Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Event.class, getProjectGroupCode(domain));
			com.servinglynk.hmis.warehouse.model.v2020.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2020.Export) getModel(com.servinglynk.hmis.warehouse.model.v2020.Export.class,domain.getExport().getExportID(),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
			if(CollectionUtils.isNotEmpty(events))
			{
				for(Event event :events )
				{
					com.servinglynk.hmis.warehouse.model.v2020.Event eventModel = null;
					try {
						eventModel = getModelObject(domain, event,data,modelMap);
						eventModel.setEventDate(BasicDataGenerator.getLocalDateTime(event.getEventDate()));
						eventModel.setResultDate(BasicDataGenerator.getLocalDateTime(event.getResultDate()));
						eventModel.setEvent(EventTypeEnum.lookupEnum(event.getEvent()));
						eventModel.setLocationcrisisorphhousing(event.getLocationCrisisOrPHHousing());
						eventModel.setReferralCaseManageAfter(NoYesEnum.lookupEnum(event.getReferralCaseManageAfter()));
						eventModel.setReferralResult(event.getReferralResult());
						Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, event.getEnrollmentID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
						eventModel.setEnrollmentid(enrollmentModel);
						
						eventModel.setExport(exportEntity);
						eventModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(event.getDateCreated()));
						eventModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(event.getDateUpdated()));
						performSaveOrUpdate(eventModel,domain);
					} catch(Exception e) {
						String errorMessage = "Error occured with "+event.getEventID() + " Execption :::"+e.getLocalizedMessage();
						if(eventModel != null){
							Error2020 error = new Error2020();
							error.model_id = eventModel.getId();
							error.bulk_upload_ui = domain.getUpload().getId();
							error.project_group_code = domain.getUpload().getProjectGroupCode();
							error.source_system_id = eventModel.getSourceSystemId();
							error.type = ErrorType.ERROR;
							error.error_description = errorMessage;
							error.date_created = eventModel.getDateCreated();
							performSave(error);
						}
						logger.error(errorMessage);
					}
				}
			}
			hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2020.Event.class.getSimpleName(), domain, exportEntity);
		}

		
		public  com.servinglynk.hmis.warehouse.model.v2020.Event getModelObject(ExportDomain domain, Event Event,Data data, Map<String,HmisBaseModel> modelMap) {
			com.servinglynk.hmis.warehouse.model.v2020.Event modelFromDB = null;
			// We always insert for a Full refresh and update if the record exists for Delta refresh
			if(!isFullRefresh(domain))
				modelFromDB = (com.servinglynk.hmis.warehouse.model.v2020.Event) getModel(com.servinglynk.hmis.warehouse.model.v2020.Event.class, Event.getEventID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
			if(domain.isReUpload()) {
				if(modelFromDB != null) {
					return modelFromDB;
				}
				modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.Event();
				modelFromDB.setId(UUID.randomUUID());
				modelFromDB.setRecordToBeInserted(true);
				return modelFromDB;
			}
			com.servinglynk.hmis.warehouse.model.v2020.Event model = null;
			if(modelFromDB == null) {
				model = new com.servinglynk.hmis.warehouse.model.v2020.Event();
				model.setId(UUID.randomUUID());
				model.setRecordToBeInserted(true);
			}else {
				org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
				model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(Event.getDateUpdated()));
				performMatch(domain, modelFromDB, model, data);
			}
		
			hydrateCommonFields(model, domain,Event.getEventID(),data);
			return model;
		}

		@Override
		public void hydrateHBASE(SyncDomain syncDomain) {
			// TODO Auto-generated method stub
			
		}

		   public com.servinglynk.hmis.warehouse.model.v2020.Event createEvent(com.servinglynk.hmis.warehouse.model.v2020.Event Event){
		       Event.setId(UUID.randomUUID()); 
		       insert(Event);
		       return Event;
		   }
		   public com.servinglynk.hmis.warehouse.model.v2020.Event updateEvent(com.servinglynk.hmis.warehouse.model.v2020.Event Event){
		       update(Event);
		       return Event;
		   }
		   public void deleteEvent(com.servinglynk.hmis.warehouse.model.v2020.Event Event){
		       delete(Event);
		   }
		   public com.servinglynk.hmis.warehouse.model.v2020.Event getEventById(UUID EventId){ 
			      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Event.class);
			      criteria.add(Restrictions.eq("id", EventId));
			      List<com.servinglynk.hmis.warehouse.model.v2020.Event> entities = (List<com.servinglynk.hmis.warehouse.model.v2020.Event>) findByCriteria(criteria);
			      if(!entities.isEmpty()) return entities.get(0);
			      return null;
		   }
}

