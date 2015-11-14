package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("incomeAndSource")
public class IncomeAndSource extends ClientModel{


      private UUID incomeAndSourceId;

      private String alimony;

      private float alimonyamount;

      private String childsupport;

      private float childsupportamount;

      private String earned;

      private float earnedamount;

      private String ga;

      private float gaamount;

      private String incomefromanysource;

      private String othersource;

      private float othersourceamount;

      private String othersourceidentify;

      private String pension;

      private float pensionamount;

      private String privatedisability;

      private float privatedisabilityamount;

      private String socsecretirement;

      private float socsecretirementamount;

      private String ssdi;

      private float ssdiamount;

      private String ssi;

      private float ssiamount;

      private String tanf;

      private float tanfamount;

      private float totalmonthlyincome;

      private String unemployment;

      private float unemploymentamount;

      private String vadisabilitynonservice;

      private float vadisabilitynonserviceamount;

      private String vadisabilityservice;

      private float vadisabilityserviceamount;

      private String workerscomp;

      private float workerscompamount;



      public UUID getIncomeAndSourceId(){
          return incomeAndSourceId;
      }
      public void setIncomeAndSourceId(UUID incomeAndSourceId){
          this.incomeAndSourceId = incomeAndSourceId;
      }
      public String getAlimony(){
          return alimony;
      }
      public void setAlimony(String alimony){
          this.alimony = alimony;
      }
      public float getAlimonyamount(){
          return alimonyamount;
      }
      public void setAlimonyamount(float alimonyamount){
          this.alimonyamount = alimonyamount;
      }
      public String getChildsupport(){
          return childsupport;
      }
      public void setChildsupport(String childsupport){
          this.childsupport = childsupport;
      }
      public float getChildsupportamount(){
          return childsupportamount;
      }
      public void setChildsupportamount(float childsupportamount){
          this.childsupportamount = childsupportamount;
      }
      public String getEarned(){
          return earned;
      }
      public void setEarned(String earned){
          this.earned = earned;
      }
      public float getEarnedamount(){
          return earnedamount;
      }
      public void setEarnedamount(float earnedamount){
          this.earnedamount = earnedamount;
      }
      public String getGa(){
          return ga;
      }
      public void setGa(String ga){
          this.ga = ga;
      }
      public float getGaamount(){
          return gaamount;
      }
      public void setGaamount(float gaamount){
          this.gaamount = gaamount;
      }
      public String getIncomefromanysource(){
          return incomefromanysource;
      }
      public void setIncomefromanysource(String incomefromanysource){
          this.incomefromanysource = incomefromanysource;
      }
      public String getOthersource(){
          return othersource;
      }
      public void setOthersource(String othersource){
          this.othersource = othersource;
      }
      public float getOthersourceamount(){
          return othersourceamount;
      }
      public void setOthersourceamount(float othersourceamount){
          this.othersourceamount = othersourceamount;
      }
      public String getOthersourceidentify(){
          return othersourceidentify;
      }
      public void setOthersourceidentify(String othersourceidentify){
          this.othersourceidentify = othersourceidentify;
      }
      public String getPension(){
          return pension;
      }
      public void setPension(String pension){
          this.pension = pension;
      }
      public float getPensionamount(){
          return pensionamount;
      }
      public void setPensionamount(float pensionamount){
          this.pensionamount = pensionamount;
      }
      public String getPrivatedisability(){
          return privatedisability;
      }
      public void setPrivatedisability(String privatedisability){
          this.privatedisability = privatedisability;
      }
      public float getPrivatedisabilityamount(){
          return privatedisabilityamount;
      }
      public void setPrivatedisabilityamount(float privatedisabilityamount){
          this.privatedisabilityamount = privatedisabilityamount;
      }
      public String getSocsecretirement(){
          return socsecretirement;
      }
      public void setSocsecretirement(String socsecretirement){
          this.socsecretirement = socsecretirement;
      }
      public float getSocsecretirementamount(){
          return socsecretirementamount;
      }
      public void setSocsecretirementamount(float socsecretirementamount){
          this.socsecretirementamount = socsecretirementamount;
      }
      public String getSsdi(){
          return ssdi;
      }
      public void setSsdi(String ssdi){
          this.ssdi = ssdi;
      }
      public float getSsdiamount(){
          return ssdiamount;
      }
      public void setSsdiamount(float ssdiamount){
          this.ssdiamount = ssdiamount;
      }
      public String getSsi(){
          return ssi;
      }
      public void setSsi(String ssi){
          this.ssi = ssi;
      }
      public float getSsiamount(){
          return ssiamount;
      }
      public void setSsiamount(float ssiamount){
          this.ssiamount = ssiamount;
      }
      public String getTanf(){
          return tanf;
      }
      public void setTanf(String tanf){
          this.tanf = tanf;
      }
      public float getTanfamount(){
          return tanfamount;
      }
      public void setTanfamount(float tanfamount){
          this.tanfamount = tanfamount;
      }
      public float getTotalmonthlyincome(){
          return totalmonthlyincome;
      }
      public void setTotalmonthlyincome(float totalmonthlyincome){
          this.totalmonthlyincome = totalmonthlyincome;
      }
      public String getUnemployment(){
          return unemployment;
      }
      public void setUnemployment(String unemployment){
          this.unemployment = unemployment;
      }
      public float getUnemploymentamount(){
          return unemploymentamount;
      }
      public void setUnemploymentamount(float unemploymentamount){
          this.unemploymentamount = unemploymentamount;
      }
      public String getVadisabilitynonservice(){
          return vadisabilitynonservice;
      }
      public void setVadisabilitynonservice(String vadisabilitynonservice){
          this.vadisabilitynonservice = vadisabilitynonservice;
      }
      public float getVadisabilitynonserviceamount(){
          return vadisabilitynonserviceamount;
      }
      public void setVadisabilitynonserviceamount(float vadisabilitynonserviceamount){
          this.vadisabilitynonserviceamount = vadisabilitynonserviceamount;
      }
      public String getVadisabilityservice(){
          return vadisabilityservice;
      }
      public void setVadisabilityservice(String vadisabilityservice){
          this.vadisabilityservice = vadisabilityservice;
      }
      public float getVadisabilityserviceamount(){
          return vadisabilityserviceamount;
      }
      public void setVadisabilityserviceamount(float vadisabilityserviceamount){
          this.vadisabilityserviceamount = vadisabilityserviceamount;
      }
      public String getWorkerscomp(){
          return workerscomp;
      }
      public void setWorkerscomp(String workerscomp){
          this.workerscomp = workerscomp;
      }
      public float getWorkerscompamount(){
          return workerscompamount;
      }
      public void setWorkerscompamount(float workerscompamount){
          this.workerscompamount = workerscompamount;
      }

 }
