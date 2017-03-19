package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("contacts")
public class Contacts extends PaginatedModel{


       @JsonProperty("contacts") 
       List<Contact>contacts = new ArrayList<Contact>();
       public List<Contact> getContacts() {
           return contacts;
       }

        public void setContacts(List<Contact> contacts) {
           this.contacts = contacts;
       }
 
       public void addContact(Contact contact) {
           this.contacts.add(contact);
       }
 }
