package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;
import com.servinglynk.hmis.warehouse.PaginatedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("entryssvfs")
public class Entryssvfs extends PaginatedModel{


       @JsonProperty("entryssvfs") 
       List<Entryssvf>entryssvfs = new ArrayList<Entryssvf>();
       public List<Entryssvf> getEntryssvfs() {
           return entryssvfs;
       }

        public void setEntryssvfs(List<Entryssvf> entryssvfs) {
           this.entryssvfs = entryssvfs;
       }
 
       public void addEntryssvf(Entryssvf entryssvf) {
           this.entryssvfs.add(entryssvf);
       }
 }
