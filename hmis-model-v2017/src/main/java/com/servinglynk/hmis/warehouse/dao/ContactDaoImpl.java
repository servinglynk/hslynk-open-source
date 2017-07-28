package com.servinglynk.hmis.warehouse.dao;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Contact;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ContactLocationEnum;
import com.servinglynk.hmis.warehouse.model.v2017.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2017.Error2016;
import com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class ContactDaoImpl extends ParentDaoImpl implements ContactDao {

	private static final Logger logger = LoggerFactory
			.getLogger(ContactDaoImpl.class);
	
	@Autowired
	private ParentDaoFactory factory;
	
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {

		com.servinglynk.hmis.warehouse.domain.Sources.Source.Export export = domain.getExport();
/*		List<Contact> contact = export.getContact();
		com.servinglynk.hmis.warehouse.model.v2016.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2016.Export) getModel(com.servinglynk.hmis.warehouse.model.v2016.Export.class, String.valueOf(domain.getExport().getExportID()), getProjectGroupCode(domain), false, exportModelMap, domain.getUpload().getId());
		Map<String, HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2016.Contact.class, getProjectGroupCode(domain));
		Data data = new Data();
		if (contact != null && contact.size() > 0) {
			for (Contact contacts : contact) {
				com.servinglynk.hmis.warehouse.model.v2016.Contact contactModel = null;
				try {
					contactModel = getModelObject(domain, contacts, data, modelMap);
					contactModel.setContactDate(BasicDataGenerator.getLocalDateTime(contacts.getContactDate()));
					contactModel.setContactLocation(ContactLocationEnum.lookupEnum(BasicDataGenerator.getStringValue(contacts
							.getContactLocation())));
					contactModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(contacts.getDateCreated()));
					contactModel.setDateUpdated(LocalDateTime.now());
					contactModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(contacts.getDateUpdated()));
					contactModel.setDeleted(false);

					Enrollment enrollment = (Enrollment) getModel(Enrollment.class, contacts.getProjectEntryID(), getProjectGroupCode(domain), true, relatedModelMap, domain.getUpload().getId());
					contactModel.setExport(exportEntity);
					contactModel.setEnrollmentid(enrollment);
					contactModel.setSync(false);
					performSaveOrUpdate(contactModel);
				} catch (Exception e) {
					String errorMessage = "Exception beause of the Contact::" + contacts.getContactID() + " Exception ::" + e.getMessage();
					if (contactModel != null) {
						Error2016 error = new Error2016();
						error.model_id = contactModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = contactModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = contactModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2016.Contact.class.getSimpleName(), domain, exportEntity);
	*/
	}


	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.v2017.Contact contact) {
			if(contact !=null) {
				com.servinglynk.hmis.warehouse.model.v2017.Contact target = new com.servinglynk.hmis.warehouse.model.v2017.Contact();
				BeanUtils.copyProperties(contact, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.v2017.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2017.Export) get(com.servinglynk.hmis.warehouse.model.v2017.Export.class, contact.getExport().getId());
				exportEntity.addContact(target);
				target.setExport(exportEntity);
				com.servinglynk.hmis.warehouse.model.v2017.Contact contactByDedupContactId = getContactByDedupContactId(contact.getId(),contact.getProjectGroupCode());
				if(contactByDedupContactId ==null) {
					insert(target);	
				}
			}
	}
	
	public  com.servinglynk.hmis.warehouse.model.v2017.Contact getModelObject(ExportDomain domain, Contact contact,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2017.Contact modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2017.Contact) getModel(com.servinglynk.hmis.warehouse.model.v2017.Contact.class, contact.getContactID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2017.Contact();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2017.Contact model = new com.servinglynk.hmis.warehouse.model.v2017.Contact();
		// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(contact.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,contact.getContactID(),data);
		return model;
	}

	
    
	private Date getDateInFormat(String dob) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
        	formatter = new SimpleDateFormat("yyyy-MM-dd");
              date = (Date)((DateFormat) formatter).parse(dob);
            
            String s = formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.Contact createContact(
			com.servinglynk.hmis.warehouse.model.v2017.Contact contact) {
			contact.setId(UUID.randomUUID());
			insert(contact);
		return contact;
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.Contact updateContact(
			com.servinglynk.hmis.warehouse.model.v2017.Contact contact) {
			update(contact);
		return contact;
	}


	@Override
	public void deleteContact(
			com.servinglynk.hmis.warehouse.model.v2017.Contact contact) {
			delete(contact);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.Contact getContactById(UUID contactId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Contact.class);
		criteria.add(Restrictions.eq("id", contactId));
		List<com.servinglynk.hmis.warehouse.model.v2017.Contact> contact = (List<com.servinglynk.hmis.warehouse.model.v2017.Contact>) findByCriteria(criteria);
		if(contact.size()>0) return contact.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.Contact getContactByDedupContactId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Contact.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2017.Contact> contact = (List<com.servinglynk.hmis.warehouse.model.v2017.Contact>) findByCriteria(criteria);
		if(contact !=null && contact.size()>0) return contact.get(0);
		return null;
	}
	public com.servinglynk.hmis.warehouse.model.v2017.Contact getContactByDedupContactId(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Contact.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.v2017.Contact> contact = (List<com.servinglynk.hmis.warehouse.model.v2017.Contact>) findByCriteria(criteria);
		if(contact !=null && contact.size()>0) return contact.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2017.Contact> getAllContact(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Contact.class);	
		List<com.servinglynk.hmis.warehouse.model.v2017.Contact> contact = (List<com.servinglynk.hmis.warehouse.model.v2017.Contact>) findByCriteria(criteria,startIndex,maxItems);
		return contact;
	}
	
	
	public long getContactCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Contact.class);	
		return countRows(criteria);
	}

	   public List<com.servinglynk.hmis.warehouse.model.v2017.Contact> getAllEnrollmentContacts(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Contact.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2017.Contact>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentContactsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Contact.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
