package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("incomeAndSource")
public class IncomeAndSource extends ClientModel{


      private UUID incomeAndSourceId;

      private Integer alimony;

      private float alimonyamount;
      @JsonProperty("childSupport")
      private Integer childsupport;

      @JsonProperty("childSupportAmount")
      private float childsupportamount;

      private Integer earned;
      @JsonProperty("earnedAmount")
      private float earnedamount;

      private Integer ga;
      @JsonProperty("gaAmount")
      private float gaamount;
      @JsonProperty("incomeFromAnySource")
      private Integer incomefromanysource;
      @JsonProperty("otherSource")
      private Integer othersource;
      @JsonProperty("otherSourceAmount")
      private float othersourceamount;

      @JsonProperty("otherSourceIdentify")
      private String othersourceidentify;

      private Integer pension;

      @JsonProperty("pensionAmount")
      private float pensionamount;
      @JsonProperty("privateDisability")
      private Integer privatedisability;
      @JsonProperty("privateDisabilityAmount")
      private float privatedisabilityamount;

      @JsonProperty("socsecRetirement")
      private Integer socsecretirement;
      
      @JsonProperty("socSecRetirementAmount")
      private float socsecretirementamount;

      private Integer ssdi;
      @JsonProperty("ssdiAmount")
      private float ssdiamount;

      private Integer ssi;
      @JsonProperty("ssiAmount")
      private float ssiamount;

      private Integer tanf;
      @JsonProperty("tanfAmount")
      private float tanfamount;
      
      
      @JsonProperty("totalMonthlyIncome")
      private float totalmonthlyincome;

      private Integer unemployment;

      @JsonProperty("unemploymentAmount")
      private float unemploymentamount;
      
      @JsonProperty("vaDisabilityNonService")
      private Integer vadisabilitynonservice;
      
      @JsonProperty("vaDisabilityNonServiceAmount")
      private float vadisabilitynonserviceamount;
      
      @JsonProperty("vaDisabilityService")
      private Integer vadisabilityservice;
      
      @JsonProperty("vaDisabilityServiceAmount")
      private float vadisabilityserviceamount;
      
      @JsonProperty("workersComp")
      private Integer workerscomp;

      @JsonProperty("workersCompAmount")
      private float workerscompamount;

      private LocalDateTime informationDate;
      
      private Integer dataCollectionStage;

      public LocalDateTime getInformationDate() {
		return informationDate;
	}
	public void setInformationDate(LocalDateTime informationDate) {
		this.informationDate = informationDate;
	}
	public Integer getDataCollectionStage() {
		return dataCollectionStage;
	}
	public void setDataCollectionStage(Integer dataCollectionStage) {
		this.dataCollectionStage = dataCollectionStage;
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
