package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Contact;
import com.servinglynk.hmis.warehouse.core.model.Contacts;
import com.servinglynk.hmis.warehouse.service.ContactService;
import com.servinglynk.hmis.warehouse.service.converter.ContactConverter;
import com.servinglynk.hmis.warehouse.service.exception.ContactNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;


public class ContactServiceImpl extends ServiceBase implements ContactService  {

   @Transactional
   public Contact createContact(Contact contact,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Contact pContact = ContactConverter.modelToEntity(contact, null);
       com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       pContact.setEnrollmentid(pEnrollment);
       pContact.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pContact, caller);
       daoFactory.getContactDao().createContact(pContact);
       contact.setContactId(pContact.getId());
       return contact;
   }


   @Transactional
   public Contact updateContact(Contact contact,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       com.servinglynk.hmis.warehouse.model.v2017.Contact pContact = daoFactory.getContactDao().getContactById(contact.getContactId());
       if(pContact==null) throw new ContactNotFoundException();

       ContactConverter.modelToEntity(contact, pContact);
       pContact.setEnrollmentid(pEnrollment);
       pContact.setDateUpdated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pContact, caller);
       daoFactory.getContactDao().updateContact(pContact);
       contact.setContactId(pContact.getId());
       return contact;
   }


   @Transactional
   public Contact deleteContact(UUID contactId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Contact pContact = daoFactory.getContactDao().getContactById(contactId);
       if(pContact==null) throw new ContactNotFoundException();

       daoFactory.getContactDao().deleteContact(pContact);
       return new Contact();
   }


   @Transactional
   public Contact getContactById(UUID contactId){
       com.servinglynk.hmis.warehouse.model.v2017.Contact pContact = daoFactory.getContactDao().getContactById(contactId);
       if(pContact==null) throw new ContactNotFoundException();

       return ContactConverter.entityToModel( pContact );
   }


   @Transactional
   public Contacts getAllEnrollmentContacts(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Contacts contacts = new Contacts();
        List<com.servinglynk.hmis.warehouse.model.v2017.Contact> entities = daoFactory.getContactDao().getAllEnrollmentContacts(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2017.Contact entity : entities){
           contacts.addContact(ContactConverter.entityToModel(entity));
        }
        long count = daoFactory.getContactDao().getEnrollmentContactsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(contacts.getContacts().size());
        pagination.setTotal((int)count);
        contacts.setPagination(pagination);
        return contacts;
   }


}
