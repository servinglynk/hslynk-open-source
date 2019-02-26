package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("incomeAndSource")
public class IncomeAndSource extends ClientModel{


      private UUID incomeAndSourceId;

      private Integer alimony;

      private float alimonyamount;

      private Integer childsupport;

      private float childsupportamount;

      private Integer earned;

      private float earnedamount;

      private Integer ga;

      private float gaamount;

      private Integer incomefromanysource;

      private Integer othersource;

      private float othersourceamount;

      private String othersourceidentify;

      private Integer pension;

      private float pensionamount;

      private Integer privatedisability;

      private float privatedisabilityamount;

      private Integer socsecretirement;

      private float socsecretirementamount;

      private Integer ssdi;

      private float ssdiamount;

      private Integer ssi;

      private float ssiamount;

      private Integer tanf;

      private float tanfamount;

      private float totalmonthlyincome;

      private Integer unemployment;

      private float unemploymentamount;

      private Integer vadisabilitynonservice;

      private float vadisabilitynonserviceamount;

      private Integer vadisabilityservice;

      private float vadisabilityserviceamount;

      private Integer workerscomp;

      private float workerscompamount;

      private LocalDateTime informationDate;
      private Integer dataCollectionStage;


	public Integer getDataCollectionStage() {
		return dataCollectionStage;
	}
	public void setDataCollectionStage(Integer dataCollectionStage) {
		this.dataCollectionStage = dataCollectionStage;
}

         public LocalDateTime getInformationDate() {
    		return informationDate;
    	}
    	public void setInformationDate(LocalDateTime informationDate) {
    		this.informationDate = informationDate;
}

      public UUID getIncomeAndSourceId(){
          return incomeAndSourceId;
      }
      public void setIncomeAndSourceId(UUID incomeAndSourceId){
          this.incomeAndSourceId = incomeAndSourceId;
      }
      public Integer getAlimony(){
          return alimony;
      }
      public void setAlimony(Integer alimony){
          this.alimony = alimony;
      }
      public float getAlimonyamount(){
          return alimonyamount;
      }
      public void setAlimonyamount(float alimonyamount){
          this.alimonyamount = alimonyamount;
      }
      public Integer getChildsupport(){
          return childsupport;
      }
      public void setChildsupport(Integer childsupport){
          this.childsupport = childsupport;
      }
      public float getChildsupportamount(){
          return childsupportamount;
      }
      public void setChildsupportamount(float childsupportamount){
          this.childsupportamount = childsupportamount;
      }
      public Integer getEarned(){
          return earned;
      }
      public void setEarned(Integer earned){
          this.earned = earned;
      }
      public float getEarnedamount(){
          return earnedamount;
      }
      public void setEarnedamount(float earnedamount){
          this.earnedamount = earnedamount;
      }
      public Integer getGa(){
          return ga;
      }
      public void setGa(Integer ga){
          this.ga = ga;
      }
      public float getGaamount(){
          return gaamount;
      }
      public void setGaamount(float gaamount){
          this.gaamount = gaamount;
      }
      public Integer getIncomefromanysource(){
          return incomefromanysource;
      }
      public void setIncomefromanysource(Integer incomefromanysource){
          this.incomefromanysource = incomefromanysource;
      }
      public Integer getOthersource(){
          return othersource;
      }
      public void setOthersource(Integer othersource){
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
      public Integer getPension(){
          return pension;
      }
      public void setPension(Integer pension){
          this.pension = pension;
      }
      public float getPensionamount(){
          return pensionamount;
      }
      public void setPensionamount(float pensionamount){
          this.pensionamount = pensionamount;
      }
      public Integer getPrivatedisability(){
          return privatedisability;
      }
      public void setPrivatedisability(Integer privatedisability){
          this.privatedisability = privatedisability;
      }
      public float getPrivatedisabilityamount(){
          return privatedisabilityamount;
      }
      public void setPrivatedisabilityamount(float privatedisabilityamount){
          this.privatedisabilityamount = privatedisabilityamount;
      }
      public Integer getSocsecretirement(){
          return socsecretirement;
      }
      public void setSocsecretirement(Integer socsecretirement){
          this.socsecretirement = socsecretirement;
      }
      public float getSocsecretirementamount(){
          return socsecretirementamount;
      }
      public void setSocsecretirementamount(float socsecretirementamount){
          this.socsecretirementamount = socsecretirementamount;
      }
      public Integer getSsdi(){
          return ssdi;
      }
      public void setSsdi(Integer ssdi){
          this.ssdi = ssdi;
      }
      public float getSsdiamount(){
          return ssdiamount;
      }
      public void setSsdiamount(float ssdiamount){
          this.ssdiamount = ssdiamount;
      }
      public Integer getSsi(){
          return ssi;
      }
      public void setSsi(Integer ssi){
          this.ssi = ssi;
      }
      public float getSsiamount(){
          return ssiamount;
      }
      public void setSsiamount(float ssiamount){
          this.ssiamount = ssiamount;
      }
      public Integer getTanf(){
          return tanf;
      }
      public void setTanf(Integer tanf){
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
      public Integer getUnemployment(){
          return unemployment;
      }
      public void setUnemployment(Integer unemployment){
          this.unemployment = unemployment;
      }
      public float getUnemploymentamount(){
          return unemploymentamount;
      }
      public void setUnemploymentamount(float unemploymentamount){
          this.unemploymentamount = unemploymentamount;
      }
      public Integer getVadisabilitynonservice(){
          return vadisabilitynonservice;
      }
      public void setVadisabilitynonservice(Integer vadisabilitynonservice){
          this.vadisabilitynonservice = vadisabilitynonservice;
      }
      public float getVadisabilitynonserviceamount(){
          return vadisabilitynonserviceamount;
      }
      public void setVadisabilitynonserviceamount(float vadisabilitynonserviceamount){
          this.vadisabilitynonserviceamount = vadisabilitynonserviceamount;
      }
      public Integer getVadisabilityservice(){
          return vadisabilityservice;
      }
      public void setVadisabilityservice(Integer vadisabilityservice){
          this.vadisabilityservice = vadisabilityservice;
      }
      public float getVadisabilityserviceamount(){
          return vadisabilityserviceamount;
      }
      public void setVadisabilityserviceamount(float vadisabilityserviceamount){
          this.vadisabilityserviceamount = vadisabilityserviceamount;
      }
      public Integer getWorkerscomp(){
          return workerscomp;
      }
      public void setWorkerscomp(Integer workerscomp){
          this.workerscomp = workerscomp;
      }
      public float getWorkerscompamount(){
          return workerscompamount;
      }
      public void setWorkerscompamount(float workerscompamount){
          this.workerscompamount = workerscompamount;
      }

 }
