package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.dao.ParentDao;
import com.servinglynk.hmis.warehouse.model.v2020.Contact;

public interface ContactDao extends ParentDao {

	Contact createContact(Contact contact);

	Contact updateContact(Contact contact);

	void deleteContact(Contact contact);

	Contact getContactById(UUID cocId);

	List<Contact> getAllContact(Integer startIndex, Integer maxItems);

	long getContactCount();

	public com.servinglynk.hmis.warehouse.model.v2020.Contact getContactByDedupContactId(UUID id,
			String projectGroupCode);

	void hydrateLive(com.servinglynk.hmis.warehouse.model.v2020.Contact contact);

	List<com.servinglynk.hmis.warehouse.model.v2020.Contact> getAllEnrollmentContacts(UUID enrollmentId,
			Integer startIndex, Integer maxItems);

	long getEnrollmentContactsCount(UUID enrollmentId);
}
