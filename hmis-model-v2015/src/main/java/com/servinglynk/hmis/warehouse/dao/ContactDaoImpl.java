package com.servinglynk.hmis.warehouse.dao;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class ContactDaoImpl extends ParentDaoImpl implements ContactDao {

	private static final Logger logger = LoggerFactory
			.getLogger(ContactDaoImpl.class);
	
	@Autowired
	private ParentDaoFactory factory;
	
	@Override
	public void hydrateStaging(ExportDomain domain) throws Exception {
		
		com.servinglynk.hmis.warehouse.domain.Sources.Source.Export export = domain.getExport();
		List<Contact> contact = export.getContact();
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false);
		Data data =new Data();
		if (contact != null && contact.size() > 0) {
			for (Contact contacts : contact) {
				try {
					com.servinglynk.hmis.warehouse.model.v2015.Contact contactModel = getModelObject(domain, contacts, data);
					contactModel.setContactDate(BasicDataGenerator.getLocalDateTime(contacts.getContactDate()));
					contactModel.setContactLocation(ContactLocationEnum.lookupEnum(BasicDataGenerator.getStringValue(contacts
							.getContactLocation())));
					contactModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(contacts.getDateCreated()));
					contactModel.setDateUpdated(LocalDateTime.now());
					contactModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(contacts.getDateUpdated()));
					contactModel.setDeleted(false);
					
					Enrollment enrollment = (Enrollment) getModel(Enrollment.class,contacts.getProjectEntryID(),getProjectGroupCode(domain),true);
					contactModel.setExport(exportEntity);
					exportEntity.addContact(contactModel);
					contactModel.setEnrollmentid(enrollment);
					
					contactModel.setSync(false);
					contactModel.setUserId(exportEntity.getUserId());
					performSaveOrUpdate(contactModel);
				 } catch(Exception e) {
					 logger.error("Exception beause of the Contact::"+contacts.getContactID() +" Exception ::"+e.getMessage());
					 throw new Exception(e);
				 }
				}
			}
		hydrateBulkUploadActivityStaging(data.i, data.j, com.servinglynk.hmis.warehouse.model.v2015.Contact.class.getSimpleName(), domain, exportEntity);
	}


	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.v2015.Contact contact) {
			if(contact !=null) {
				com.servinglynk.hmis.warehouse.model.v2015.Contact target = new com.servinglynk.hmis.warehouse.model.v2015.Contact();
				BeanUtils.copyProperties(contact, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, contact.getExport().getId());
				exportEntity.addContact(target);
				target.setExport(exportEntity);
				com.servinglynk.hmis.warehouse.model.v2015.Contact contactByDedupContactId = getContactByDedupContactId(contact.getId(),contact.getProjectGroupCode());
				if(contactByDedupContactId ==null) {
					insert(target);	
				}
			}
	}
	
	public  com.servinglynk.hmis.warehouse.model.v2015.Contact getModelObject(ExportDomain domain, Contact Contact,Data data) {
		com.servinglynk.hmis.warehouse.model.v2015.Contact contactModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			contactModel = (com.servinglynk.hmis.warehouse.model.v2015.Contact) getModel(com.servinglynk.hmis.warehouse.model.v2015.Contact.class, Contact.getContactID(), getProjectGroupCode(domain),false);
		
		if(contactModel == null) {
			contactModel = new com.servinglynk.hmis.warehouse.model.v2015.Contact();
			contactModel.setId(UUID.randomUUID());
			contactModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(contactModel, domain,Contact.getContactID(),data.i+data.j);
		return contactModel;
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
	public com.servinglynk.hmis.warehouse.model.v2015.Contact createContact(
			com.servinglynk.hmis.warehouse.model.v2015.Contact contact) {
			contact.setId(UUID.randomUUID());
			insert(contact);
		return contact;
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Contact updateContact(
			com.servinglynk.hmis.warehouse.model.v2015.Contact contact) {
			update(contact);
		return contact;
	}


	@Override
	public void deleteContact(
			com.servinglynk.hmis.warehouse.model.v2015.Contact contact) {
			delete(contact);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Contact getContactById(UUID contactId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Contact.class);
		criteria.add(Restrictions.eq("id", contactId));
		List<com.servinglynk.hmis.warehouse.model.v2015.Contact> contact = (List<com.servinglynk.hmis.warehouse.model.v2015.Contact>) findByCriteria(criteria);
		if(contact.size()>0) return contact.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Contact getContactByDedupContactId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Contact.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2015.Contact> contact = (List<com.servinglynk.hmis.warehouse.model.v2015.Contact>) findByCriteria(criteria);
		if(contact !=null && contact.size()>0) return contact.get(0);
		return null;
	}
	public com.servinglynk.hmis.warehouse.model.v2015.Contact getContactByDedupContactId(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Contact.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.v2015.Contact> contact = (List<com.servinglynk.hmis.warehouse.model.v2015.Contact>) findByCriteria(criteria);
		if(contact !=null && contact.size()>0) return contact.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2015.Contact> getAllContact(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Contact.class);	
		List<com.servinglynk.hmis.warehouse.model.v2015.Contact> contact = (List<com.servinglynk.hmis.warehouse.model.v2015.Contact>) findByCriteria(criteria,startIndex,maxItems);
		return contact;
	}
	
	
	public long getContactCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Contact.class);	
		return countRows(criteria);
	}

	   public List<com.servinglynk.hmis.warehouse.model.v2015.Contact> getAllEnrollmentContacts(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Contact.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Contact>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentContactsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Contact.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
