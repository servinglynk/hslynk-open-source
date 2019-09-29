package com.servinglynk.hmis.warehouse.service.converter;

import java.math.BigDecimal;

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.IncomeAndSource;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesAlimonyEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesChildsupportEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesEarnedEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesGaEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesIncomefromanysourceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesOthersourceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesPensionEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesPrivatedisabilityEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSocsecretirementEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSsdiEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSsiEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesTanfEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesUnemploymentEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesVadisabilitynonserviceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesVadisabilityserviceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesWorkerscompEnum;
public class IncomeAndSourceConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2017.Incomeandsources modelToEntity (IncomeAndSource model ,com.servinglynk.hmis.warehouse.model.v2017.Incomeandsources entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2017.Incomeandsources();
       if(model.getIncomeAndSourceId()!=null)
       entity.setId(model.getIncomeAndSourceId());
       if(model.getAlimony()!=null)
       entity.setAlimony(IncomeandsourcesAlimonyEnum.lookupEnum(model.getAlimony().toString()));
       entity.setAlimonyamount(new BigDecimal(model.getAlimonyamount()));
       if(model.getChildsupport()!=null)
       entity.setChildsupport(IncomeandsourcesChildsupportEnum.lookupEnum(model.getChildsupport().toString()));
       entity.setChildsupportamount(new BigDecimal(model.getChildsupportamount()));
       if(model.getEarned()!=null)
       entity.setEarned(IncomeandsourcesEarnedEnum.lookupEnum(model.getEarned().toString()));
       entity.setEarnedamount(new BigDecimal(model.getEarnedamount()));
       if(model.getGa()!=null)
       entity.setGa(IncomeandsourcesGaEnum.lookupEnum(model.getGa().toString()));
       entity.setGaamount(new BigDecimal(model.getGaamount()));
       if(model.getIncomefromanysource()!=null)
       entity.setIncomefromanysource(IncomeandsourcesIncomefromanysourceEnum.lookupEnum(model.getIncomefromanysource().toString()));
       if(model.getOthersource()!=null)
       entity.setOthersource(IncomeandsourcesOthersourceEnum.lookupEnum(model.getOthersource().toString()));
       if(model.getOthersource()!=null)
       entity.setOthersourceamount(new BigDecimal(model.getOthersourceamount()));
       if(model.getOthersourceidentify()!=null)
       entity.setOthersourceidentify(model.getOthersourceidentify());
       if(model.getPension()!=null)
       entity.setPension(IncomeandsourcesPensionEnum.lookupEnum(model.getPension().toString()));
       entity.setPensionamount(new BigDecimal(model.getPensionamount()));
       if(model.getPrivatedisability()!=null)
       entity.setPrivatedisability(IncomeandsourcesPrivatedisabilityEnum.lookupEnum(model.getPrivatedisability().toString()));
       entity.setPrivatedisabilityamount(new BigDecimal(model.getPrivatedisabilityamount()));
       if(model.getSocsecretirement()!=null)
       entity.setSocsecretirement(IncomeandsourcesSocsecretirementEnum.lookupEnum(model.getSocsecretirement().toString()));
       entity.setSocsecretirementamount(new BigDecimal(model.getSocsecretirementamount()));
       if(model.getSsdi()!=null)
       entity.setSsdi(IncomeandsourcesSsdiEnum.lookupEnum(model.getSsdi().toString()));
       entity.setSsdiamount(new BigDecimal(model.getSsdiamount()));
       if(model.getSsi()!=null)
       entity.setSsi(IncomeandsourcesSsiEnum.lookupEnum(model.getSsi().toString()));
       entity.setSsiamount(new BigDecimal(model.getSsiamount()));
       if(model.getTanf()!=null)
       entity.setTanf(IncomeandsourcesTanfEnum.lookupEnum(model.getTanf().toString()));
       entity.setTanfamount(new BigDecimal(model.getTanfamount()));
       entity.setTotalmonthlyincome(new BigDecimal(model.getTotalmonthlyincome()));
       if(model.getUnemployment()!=null)
       entity.setUnemployment(IncomeandsourcesUnemploymentEnum.lookupEnum(model.getUnemployment().toString()));
       entity.setUnemploymentamount(new BigDecimal(model.getUnemploymentamount()));
       if(model.getVadisabilitynonservice()!=null)
       entity.setVadisabilitynonservice(IncomeandsourcesVadisabilitynonserviceEnum.lookupEnum(model.getVadisabilitynonservice().toString()));
       entity.setVadisabilitynonserviceamount(new BigDecimal(model.getVadisabilitynonserviceamount()));
       if(model.getVadisabilityservice()!=null)
       entity.setVadisabilityservice(IncomeandsourcesVadisabilityserviceEnum.lookupEnum(model.getVadisabilityservice().toString()));
       entity.setVadisabilityserviceamount(new BigDecimal(model.getVadisabilityserviceamount()));
       if(model.getWorkerscomp()!=null)
       entity.setWorkerscomp(IncomeandsourcesWorkerscompEnum.lookupEnum(model.getWorkerscomp().toString()));
       entity.setWorkerscompamount(new BigDecimal(model.getWorkerscompamount()));
       if(model.getDataCollectionStage() !=null)
    	   	entity.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(model.getDataCollectionStage().toString()));
       if(model.getInformationDate()!=null)
    	       entity.setInformationDate(model.getInformationDate());
       entity.setSubmissionDate(model.getSubmissionDate());
       return entity;
   }


   public static IncomeAndSource entityToModel (com.servinglynk.hmis.warehouse.model.v2017.Incomeandsources entity) {
       IncomeAndSource model = new IncomeAndSource();
       if(entity.getId()!=null)
       model.setIncomeAndSourceId(entity.getId());
       if(entity.getAlimony()!=null)
       model.setAlimony(Integer.parseInt(entity.getAlimony().getValue()));
       if(entity.getAlimonyamount()!=null)
       model.setAlimonyamount(entity.getAlimonyamount().floatValue());
       if(entity.getChildsupport()!=null)
       model.setChildsupport(Integer.parseInt(entity.getChildsupport().getValue()));
       if(entity.getChildsupportamount()!=null)
       model.setChildsupportamount(entity.getChildsupportamount().floatValue());
       if(entity.getEarned()!=null)
       model.setEarned(Integer.parseInt(entity.getEarned().getValue()));
       if(entity.getEarnedamount()!=null)
       model.setEarnedamount(entity.getEarnedamount().floatValue());
       if(entity.getGa()!=null)
       model.setGa(Integer.parseInt(entity.getGa().getValue()));
       if(entity.getGaamount()!=null)
       model.setGaamount(entity.getGaamount().floatValue());
       if(entity.getIncomefromanysource()!=null)
       model.setIncomefromanysource(Integer.parseInt(entity.getIncomefromanysource().getValue()));
       if(entity.getOthersource()!=null)
       model.setOthersource(Integer.parseInt(entity.getOthersource().getValue()));
       if(entity.getOthersourceamount()!=null)
       model.setOthersourceamount(entity.getOthersourceamount().floatValue());
       if(entity.getOthersourceidentify()!=null)
       model.setOthersourceidentify(entity.getOthersourceidentify());
       if(entity.getPension()!=null)
       model.setPension(Integer.parseInt(entity.getPension().getValue()));
       if(entity.getPensionamount()!=null)
       model.setPensionamount(entity.getPensionamount().floatValue());
       if(entity.getPrivatedisability()!=null)
       model.setPrivatedisability(Integer.parseInt(entity.getPrivatedisability().getValue()));
       if(entity.getPrivatedisabilityamount()!=null)
       model.setPrivatedisabilityamount(entity.getPrivatedisabilityamount().floatValue());
       if(entity.getSocsecretirement()!=null)
       model.setSocsecretirement(Integer.parseInt(entity.getSocsecretirement().getValue()));
       if(entity.getSocsecretirementamount()!=null)
       model.setSocsecretirementamount(entity.getSocsecretirementamount().floatValue());
       if(entity.getSsdi()!=null)
       model.setSsdi(Integer.parseInt(entity.getSsdi().getValue()));
       if(entity.getSsdiamount()!=null)
       model.setSsdiamount(entity.getSsdiamount().floatValue());
       if(entity.getSsi()!=null)
       model.setSsi(Integer.parseInt(entity.getSsi().getValue()));
       if(entity.getSsiamount()!=null)
       model.setSsiamount(entity.getSsiamount().floatValue());
       if(entity.getTanf()!=null)
       model.setTanf(Integer.parseInt(entity.getTanf().getValue()));
       if(entity.getTanfamount()!=null)
       model.setTanfamount(entity.getTanfamount().floatValue());
       if(entity.getTotalmonthlyincome()!=null)
       model.setTotalmonthlyincome(entity.getTotalmonthlyincome().floatValue());
       if(entity.getUnemployment()!=null)
       model.setUnemployment(Integer.parseInt(entity.getUnemployment().getValue()));
       if(entity.getUnemploymentamount()!=null)
       model.setUnemploymentamount(entity.getUnemploymentamount().floatValue());
       if(entity.getVadisabilitynonservice()!=null)
       model.setVadisabilitynonservice(Integer.parseInt(entity.getVadisabilitynonservice().getValue()));
       if(entity.getVadisabilitynonserviceamount()!=null)
       model.setVadisabilitynonserviceamount(entity.getVadisabilitynonserviceamount().floatValue());
       if(entity.getVadisabilityservice()!=null)
       model.setVadisabilityservice(Integer.parseInt(entity.getVadisabilityservice().getValue()));
       if(entity.getVadisabilityserviceamount()!=null)
       model.setVadisabilityserviceamount(entity.getVadisabilityserviceamount().floatValue());
       if(entity.getWorkerscomp()!=null)
       model.setWorkerscomp(Integer.parseInt(entity.getWorkerscomp().getValue()));
       if(entity.getWorkerscompamount()!=null)
       model.setWorkerscompamount(entity.getWorkerscompamount().floatValue());
       if(entity.getInformationDate()!=null)
           model.setInformationDate(entity.getInformationDate());
        if(entity.getDataCollectionStage() !=null)
            model.setDataCollectionStage(Integer.parseInt(entity.getDataCollectionStage().getValue()));
        if(entity.getSubmissionDate()!=null) model.setSubmissionDate(entity.getSubmissionDate());
        
       copyBeanProperties(entity, model);
       
       if(entity.getParentId() ==null && entity.getEnrollmentid()!=null && entity.getEnrollmentid().getClient()!=null) {
    	   model.addLink(new ActionLink("history","/clients/"+entity.getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getEnrollmentid().getId()+"/incomeandsources/"+entity.getId()+"/history"));
       }
       
       return model;
   }


}
