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
public class IncomeAndSourceConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources modelToEntity (IncomeAndSource model ,com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources();
       entity.setId(model.getIncomeAndSourceId());
       entity.setAlimony(IncomeandsourcesAlimonyEnum.lookupEnum(model.getAlimony().toString()));
       entity.setAlimonyamount(new BigDecimal(model.getAlimonyamount()));
       entity.setChildsupport(IncomeandsourcesChildsupportEnum.lookupEnum(model.getChildsupport().toString()));
       entity.setChildsupportamount(new BigDecimal(model.getChildsupportamount()));
       entity.setEarned(IncomeandsourcesEarnedEnum.lookupEnum(model.getEarned().toString()));
       entity.setEarnedamount(new BigDecimal(model.getEarnedamount()));
       entity.setGa(IncomeandsourcesGaEnum.lookupEnum(model.getGa().toString()));
       entity.setGaamount(new BigDecimal(model.getGaamount()));
       entity.setIncomefromanysource(IncomeandsourcesIncomefromanysourceEnum.lookupEnum(model.getIncomefromanysource().toString()));
       entity.setOthersource(IncomeandsourcesOthersourceEnum.lookupEnum(model.getOthersource().toString()));
       entity.setOthersourceamount(new BigDecimal(model.getOthersourceamount()));
       entity.setOthersourceidentify(model.getOthersourceidentify());
       entity.setPension(IncomeandsourcesPensionEnum.lookupEnum(model.getPension().toString()));
       entity.setPensionamount(new BigDecimal(model.getPensionamount()));
       entity.setPrivatedisability(IncomeandsourcesPrivatedisabilityEnum.lookupEnum(model.getPrivatedisability().toString()));
       entity.setPrivatedisabilityamount(new BigDecimal(model.getPrivatedisabilityamount()));
       entity.setSocsecretirement(IncomeandsourcesSocsecretirementEnum.lookupEnum(model.getSocsecretirement().toString()));
       entity.setSocsecretirementamount(new BigDecimal(model.getSocsecretirementamount()));
       entity.setSsdi(IncomeandsourcesSsdiEnum.lookupEnum(model.getSsdi().toString()));
       entity.setSsdiamount(new BigDecimal(model.getSsdiamount()));
       entity.setSsi(IncomeandsourcesSsiEnum.lookupEnum(model.getSsi().toString()));
       entity.setSsiamount(new BigDecimal(model.getSsiamount()));
       entity.setTanf(IncomeandsourcesTanfEnum.lookupEnum(model.getTanf().toString()));
       entity.setTanfamount(new BigDecimal(model.getTanfamount()));
       entity.setTotalmonthlyincome(new BigDecimal(model.getTotalmonthlyincome()));
       entity.setUnemployment(IncomeandsourcesUnemploymentEnum.lookupEnum(model.getUnemployment().toString()));
       entity.setUnemploymentamount(new BigDecimal(model.getUnemploymentamount()));
       entity.setVadisabilitynonservice(IncomeandsourcesVadisabilitynonserviceEnum.lookupEnum(model.getVadisabilitynonservice().toString()));
       entity.setVadisabilitynonserviceamount(new BigDecimal(model.getVadisabilitynonserviceamount()));
       entity.setVadisabilityservice(IncomeandsourcesVadisabilityserviceEnum.lookupEnum(model.getVadisabilityservice().toString()));
       entity.setVadisabilityserviceamount(new BigDecimal(model.getVadisabilityserviceamount()));
       entity.setWorkerscomp(IncomeandsourcesWorkerscompEnum.lookupEnum(model.getWorkerscomp().toString()));
       entity.setWorkerscompamount(new BigDecimal(model.getWorkerscompamount()));
       return entity;    
   }


   public static IncomeAndSource entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources entity) {
       IncomeAndSource model = new IncomeAndSource();
       model.setIncomeAndSourceId(entity.getId());
       model.setAlimony(Integer.parseInt(entity.getAlimony().getValue()));
       model.setAlimonyamount(entity.getAlimonyamount().floatValue());
       model.setChildsupport(Integer.parseInt(entity.getChildsupport().getValue()));
       model.setChildsupportamount(entity.getChildsupportamount().floatValue());
       model.setEarned(Integer.parseInt(entity.getEarned().getValue()));
       model.setEarnedamount(entity.getEarnedamount().floatValue());
       model.setGa(Integer.parseInt(entity.getGa().getValue()));
       model.setGaamount(entity.getGaamount().floatValue());
       model.setIncomefromanysource(Integer.parseInt(entity.getIncomefromanysource().getValue()));
       model.setOthersource(Integer.parseInt(entity.getOthersource().getValue()));
       model.setOthersourceamount(entity.getOthersourceamount().floatValue());
       model.setOthersourceidentify(entity.getOthersourceidentify());
       model.setPension(Integer.parseInt(entity.getPension().getValue()));
       model.setPensionamount(entity.getPensionamount().floatValue());
       model.setPrivatedisability(Integer.parseInt(entity.getPrivatedisability().getValue()));
       model.setPrivatedisabilityamount(entity.getPrivatedisabilityamount().floatValue());
       model.setSocsecretirement(Integer.parseInt(entity.getSocsecretirement().getValue()));
       model.setSocsecretirementamount(entity.getSocsecretirementamount().floatValue());
       model.setSsdi(Integer.parseInt(entity.getSsdi().getValue()));
       model.setSsdiamount(entity.getSsdiamount().floatValue());
       model.setSsi(Integer.parseInt(entity.getSsi().getValue()));
       model.setSsiamount(entity.getSsiamount().floatValue());
       model.setTanf(Integer.parseInt(entity.getTanf().getValue()));
       model.setTanfamount(entity.getTanfamount().floatValue());
       model.setTotalmonthlyincome(entity.getTotalmonthlyincome().floatValue());
       model.setUnemployment(Integer.parseInt(entity.getUnemployment().getValue()));
       model.setUnemploymentamount(entity.getUnemploymentamount().floatValue());
       model.setVadisabilitynonservice(Integer.parseInt(entity.getVadisabilitynonservice().getValue()));
       model.setVadisabilitynonserviceamount(entity.getVadisabilitynonserviceamount().floatValue());
       model.setVadisabilityservice(Integer.parseInt(entity.getVadisabilityservice().getValue()));
       model.setVadisabilityserviceamount(entity.getVadisabilityserviceamount().floatValue());
       model.setWorkerscomp(Integer.parseInt(entity.getWorkerscomp().getValue()));
       model.setWorkerscompamount(entity.getWorkerscompamount().floatValue());
       copyBeanProperties(entity, model);
       return model;
   }


}
