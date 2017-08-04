package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Contact;
import com.servinglynk.hmis.warehouse.core.model.Contacts;
public interface ContactService {

   Contact createContact(Contact contact,UUID enrollmentId,String caller);
   Contact updateContact(Contact contact,UUID enrollmentId,String caller);
   Contact deleteContact(UUID contactId,String caller);
   Contact getContactById(UUID contactId);
   Contacts getAllEnrollmentContacts(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
