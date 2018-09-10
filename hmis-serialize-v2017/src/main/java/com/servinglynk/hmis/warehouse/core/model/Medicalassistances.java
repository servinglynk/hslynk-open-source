package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("medicalAssistances")
public class Medicalassistances extends PaginatedModel{


       @JsonProperty("medicalAssistances") 
       List<Medicalassistance>medicalassistances = new ArrayList<Medicalassistance>();
       public List<Medicalassistance> getMedicalassistances() {
           return medicalassistances;
       }

        public void setMedicalassistances(List<Medicalassistance> medicalassistances) {
           this.medicalassistances = medicalassistances;
       }
 
       public void addMedicalassistance(Medicalassistance medicalassistance) {
           this.medicalassistances.add(medicalassistance);
       }
 }
