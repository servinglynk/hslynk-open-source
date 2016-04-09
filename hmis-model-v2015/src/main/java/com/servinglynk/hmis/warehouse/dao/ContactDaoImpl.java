package com.servinglynk.hmis.warehouse.dao;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.dao.helper.DedupHelper;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Contact;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ClientSsnDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ContactLocationEnum;
import com.servinglynk.hmis.warehouse.model.stagv2015.Enrollment;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class ContactDaoImpl extends ParentDaoImpl implements ContactDao {


	@Autowired
	DedupHelper dedupHelper;
		
	@Autowired
	private ParentDaoFactory factory;
	
	@Override
	public void hydrateStaging(ExportDomain domain) {
		
		com.servinglynk.hmis.warehouse.domain.Sources.Source.Export export = domain.getExport();
		List<Contact> contact = export.getContact();
		hydrateBulkUploadActivityStaging(contact, com.servinglynk.hmis.warehouse.model.v2015.Contact.class.getSimpleName(), domain);
		if (contact != null && contact.size() > 0) {
			for (Contact contacts : contact) {
				com.servinglynk.hmis.warehouse.model.stagv2015.Contact contactModel = new com.servinglynk.hmis.warehouse.model.stagv2015.Contact();
				UUID contactUUID = UUID.randomUUID();
				contactModel.setId(contactUUID);
				contactModel.setContactDate(BasicDataGenerator.getLocalDateTime(contacts.getContactDate()));
				contactModel.setContactLocation(ContactLocationEnum.lookupEnum(BasicDataGenerator.getStringValue(contacts
								.getContactLocation())));
				contactModel.setDateCreated(LocalDateTime.now());
				contactModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(contacts.getDateCreated()));
				contactModel.setDateUpdated(LocalDateTime.now());
				contactModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(contacts.getDateUpdated()));
				contactModel.setDeleted(false);
				
				Enrollment enrollment = (Enrollment) get(Enrollment.class,domain.getEnrollmentProjectEntryIDMap().get(contacts.getProjectEntryID()));
				com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, domain.getExportId());
				contactModel.setExport(exportEntity);
				exportEntity.addContact(contactModel);
				contactModel.setEnrollmentid(enrollment);
			
				contactModel.setProjectGroupCode(contacts.getProjectEntryID());
				contactModel.setSync(false);
				contactModel.setUserId(exportEntity.getUserId());
				insertOrUpdate(contactModel);
				
				}
			}
	}



	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.stagv2015.Export export, Long id) {
		Set<com.servinglynk.hmis.warehouse.model.stagv2015.Contact> contact = export.getContacts();
		hydrateBulkUploadActivity(contact, com.servinglynk.hmis.warehouse.model.v2015.Contact.class.getSimpleName(), export, id );
		if(contact !=null && !contact.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.stagv2015.Contact contacts : contact) {
			//	com.servinglynk.hmis.warehouse.model.v2015.Contact contactByDedupContactId = getContactByDedupContactId(contacts.getId(),contacts.getProjectGroupCode());
			//	if(contactByDedupContactId ==null) {
					com.servinglynk.hmis.warehouse.model.v2015.Contact target = new com.servinglynk.hmis.warehouse.model.v2015.Contact();
					BeanUtils.copyProperties(contacts, target, new String[] {"enrollments","veteranInfoes"});
					com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, export.getId());
					exportEntity.addContact(target);
					target.setExport(exportEntity);
					insertOrUpdate(target);
				}
		//	}
		}
	}
	
	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.stagv2015.Contact contact) {
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
	protected void performSave(Iface contact, Object entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected List performGet(Iface contact, Object entity) {
		// TODO Auto-generated method stub
		return null;
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
	public com.servinglynk.hmis.warehouse.model.stagv2015.Contact getContactByDedupContactId(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.stagv2015.Contact.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.stagv2015.Contact> contact = (List<com.servinglynk.hmis.warehouse.model.stagv2015.Contact>) findByCriteria(criteria);
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



}
