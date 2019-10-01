package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Contact;
import com.servinglynk.hmis.warehouse.enums.ContactLocationEnum;
public class ContactConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2020.Contact modelToEntity (Contact model ,com.servinglynk.hmis.warehouse.model.v2020.Contact entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2020.Contact();
       entity.setId(model.getContactId());
 if(model.getContactLocation()!=null)
       entity.setContactLocation(ContactLocationEnum.lookupEnum(model.getContactLocation().toString()));
       entity.setContactDate(model.getContactDate());
		if(model.getSubmissionDate()!=null) entity.setSubmissionDate(model.getSubmissionDate());
       return entity;
   }


   public static Contact entityToModel (com.servinglynk.hmis.warehouse.model.v2020.Contact entity) {
       Contact model = new Contact();
       model.setContactId(entity.getId());
       if(entity.getContactLocation()!=null)
       model.setContactLocation(Integer.parseInt(entity.getContactLocation().getValue()));
       model.setContactDate(entity.getContactDate());
       if(entity.getSubmissionDate()!=null) model.setSubmissionDate(entity.getSubmissionDate());
       return model;
   }


}
