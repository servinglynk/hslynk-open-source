package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("familyReunification")
public class FamilyReunification extends ClientModel{


	 private UUID familyReunificationId;

     private Integer familyreunificationachieved;



     public UUID getFamilyReunificationId(){
         return familyReunificationId;
     }
     public void setFamilyReunificationId(UUID familyReunificationId){
         this.familyReunificationId = familyReunificationId;
     }
     public Integer getFamilyreunificationachieved(){
         return familyreunificationachieved;
     }
     public void setFamilyreunificationachieved(Integer familyreunificationachieved){
         this.familyreunificationachieved = familyreunificationachieved;
     }

 }
