package com.servinglynk.hmis.warehouse.service.converter; 

import java.math.BigDecimal;

import com.servinglynk.hmis.warehouse.core.model.IncomeAndSource;
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
public class IncomeAndSourceConverter {

   public static com.servinglynk.hmis.warehouse.model.live.Incomeandsources modelToEntity (IncomeAndSource model ,com.servinglynk.hmis.warehouse.model.live.Incomeandsources entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Incomeandsources();
       entity.setId(model.getIncomeAndSourceId());
       entity.setAlimony(IncomeandsourcesAlimonyEnum.valueOf(model.getAlimony()));
       entity.setAlimonyamount(new BigDecimal(model.getAlimonyamount()));
       entity.setChildsupport(IncomeandsourcesChildsupportEnum.valueOf(model.getChildsupport()));
       entity.setChildsupportamount(new BigDecimal(model.getChildsupportamount()));
       entity.setEarned(IncomeandsourcesEarnedEnum.valueOf(model.getEarned()));
       entity.setEarnedamount(new BigDecimal(model.getEarnedamount()));
       entity.setGa(IncomeandsourcesGaEnum.valueOf(model.getGa()));
       entity.setGaamount(new BigDecimal(model.getGaamount()));
       entity.setIncomefromanysource(IncomeandsourcesIncomefromanysourceEnum.valueOf(model.getIncomefromanysource()));
       entity.setOthersource(IncomeandsourcesOthersourceEnum.valueOf(model.getOthersource()));
       entity.setOthersourceamount(new BigDecimal(model.getOthersourceamount()));
       entity.setOthersourceidentify(model.getOthersourceidentify());
       entity.setPension(IncomeandsourcesPensionEnum.valueOf(model.getPension()));
       entity.setPensionamount(new BigDecimal(model.getPensionamount()));
       entity.setPrivatedisability(IncomeandsourcesPrivatedisabilityEnum.valueOf(model.getPrivatedisability()));
       entity.setPrivatedisabilityamount(new BigDecimal(model.getPrivatedisabilityamount()));
       entity.setSocsecretirement(IncomeandsourcesSocsecretirementEnum.valueOf(model.getSocsecretirement()));
       entity.setSocsecretirementamount(new BigDecimal(model.getSocsecretirementamount()));
       entity.setSsdi(IncomeandsourcesSsdiEnum.valueOf(model.getSsdi()));
       entity.setSsdiamount(new BigDecimal(model.getSsdiamount()));
       entity.setSsi(IncomeandsourcesSsiEnum.valueOf(model.getSsi()));
       entity.setSsiamount(new BigDecimal(model.getSsiamount()));
       entity.setTanf(IncomeandsourcesTanfEnum.valueOf(model.getTanf()));
       entity.setTanfamount(new BigDecimal(model.getTanfamount()));
       entity.setTotalmonthlyincome(new BigDecimal(model.getTotalmonthlyincome()));
       entity.setUnemployment(IncomeandsourcesUnemploymentEnum.valueOf(model.getUnemployment()));
       entity.setUnemploymentamount(new BigDecimal(model.getUnemploymentamount()));
       entity.setVadisabilitynonservice(IncomeandsourcesVadisabilitynonserviceEnum.valueOf(model.getVadisabilitynonservice()));
       entity.setVadisabilitynonserviceamount(new BigDecimal(model.getVadisabilitynonserviceamount()));
       entity.setVadisabilityservice(IncomeandsourcesVadisabilityserviceEnum.valueOf(model.getVadisabilityservice()));
       entity.setVadisabilityserviceamount(new BigDecimal(model.getVadisabilityserviceamount()));
       entity.setWorkerscomp(IncomeandsourcesWorkerscompEnum.valueOf(model.getWorkerscomp()));
       entity.setWorkerscompamount(new BigDecimal(model.getWorkerscompamount()));
       return entity;    
   }


   public static IncomeAndSource entityToModel (com.servinglynk.hmis.warehouse.model.live.Incomeandsources entity) {
       IncomeAndSource model = new IncomeAndSource();
       model.setIncomeAndSourceId(entity.getId());
       model.setAlimony(entity.getAlimony().name());
       model.setAlimonyamount(entity.getAlimonyamount().floatValue());
       model.setChildsupport(entity.getChildsupport().name());
       model.setChildsupportamount(entity.getChildsupportamount().floatValue());
       model.setEarned(entity.getEarned().name());
       model.setEarnedamount(entity.getEarnedamount().floatValue());
       model.setGa(entity.getGa().name());
       model.setGaamount(entity.getGaamount().floatValue());
       model.setIncomefromanysource(entity.getIncomefromanysource().name());
       model.setOthersource(entity.getOthersource().name());
       model.setOthersourceamount(entity.getOthersourceamount().floatValue());
       model.setOthersourceidentify(entity.getOthersourceidentify());
       model.setPension(entity.getPension().name());
       model.setPensionamount(entity.getPensionamount().floatValue());
       model.setPrivatedisability(entity.getPrivatedisability().name());
       model.setPrivatedisabilityamount(entity.getPrivatedisabilityamount().floatValue());
       model.setSocsecretirement(entity.getSocsecretirement().name());
       model.setSocsecretirementamount(entity.getSocsecretirementamount().floatValue());
       model.setSsdi(entity.getSsdi().name());
       model.setSsdiamount(entity.getSsdiamount().floatValue());
       model.setSsi(entity.getSsi().name());
       model.setSsiamount(entity.getSsiamount().floatValue());
       model.setTanf(entity.getTanf().name());
       model.setTanfamount(entity.getTanfamount().floatValue());
       model.setTotalmonthlyincome(entity.getTotalmonthlyincome().floatValue());
       model.setUnemployment(entity.getUnemployment().name());
       model.setUnemploymentamount(entity.getUnemploymentamount().floatValue());
       model.setVadisabilitynonservice(entity.getVadisabilitynonservice().name());
       model.setVadisabilitynonserviceamount(entity.getVadisabilitynonserviceamount().floatValue());
       model.setVadisabilityservice(entity.getVadisabilityservice().name());
       model.setVadisabilityserviceamount(entity.getVadisabilityserviceamount().floatValue());
       model.setWorkerscomp(entity.getWorkerscomp().name());
       model.setWorkerscompamount(entity.getWorkerscompamount().floatValue());
       return model;
   }


}
