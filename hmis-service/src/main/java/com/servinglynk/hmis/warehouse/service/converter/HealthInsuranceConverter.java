package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.HealthInsurance;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceInsurancefromanysourceEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceMedicaidEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceMedicareEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNocobrareasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNoemployerprovidedreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNomedicaidreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNomedicarereasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNoprivatepayreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNoschipreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNostatehealthinsreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNovamedreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsurancePrivatepayEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceSchipEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceStatehealthinsEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceVamedicalservicesEnum;
public class HealthInsuranceConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance modelToEntity (HealthInsurance model ,com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance();
       entity.setId(model.getHealthInsuranceId());
       entity.setCobra(model.getCobra());
       entity.setEmployerprovided(model.getEmployerprovided());
       entity.setInsurancefromanysource(HealthinsuranceInsurancefromanysourceEnum.lookupEnum(model.getInsurancefromanysource().toString()));
       entity.setMedicaid(HealthinsuranceMedicaidEnum.lookupEnum(model.getMedicaid().toString()));
       entity.setMedicare(HealthinsuranceMedicareEnum.lookupEnum(model.getMedicare().toString()));
       entity.setNocobrareason(HealthinsuranceNocobrareasonEnum.lookupEnum(model.getNocobrareason().toString()));
       entity.setNoemployerprovidedreason(HealthinsuranceNoemployerprovidedreasonEnum.lookupEnum(model.getNoemployerprovidedreason().toString()));
       entity.setNomedicaidreason(HealthinsuranceNomedicaidreasonEnum.lookupEnum(model.getNomedicaidreason().toString()));
       entity.setNomedicarereason(HealthinsuranceNomedicarereasonEnum.lookupEnum(model.getNomedicarereason().toString()));
       entity.setNoprivatepayreason(HealthinsuranceNoprivatepayreasonEnum.lookupEnum(model.getNoprivatepayreason().toString()));
       entity.setNoschipreason(HealthinsuranceNoschipreasonEnum.lookupEnum(model.getNoschipreason().toString()));
       entity.setNostatehealthinsreason(HealthinsuranceNostatehealthinsreasonEnum.lookupEnum(model.getNostatehealthinsreason().toString()));
       entity.setNovamedreason(HealthinsuranceNovamedreasonEnum.lookupEnum(model.getNovamedreason().toString()));
       entity.setPrivatepay(HealthinsurancePrivatepayEnum.lookupEnum(model.getPrivatepay().toString()));
       entity.setSchip(HealthinsuranceSchipEnum.lookupEnum(model.getSchip().toString()));
       entity.setStatehealthins(HealthinsuranceStatehealthinsEnum.lookupEnum(model.getStatehealthins().toString()));
       entity.setVamedicalservices(HealthinsuranceVamedicalservicesEnum.lookupEnum(model.getVamedicalservices().toString()));
       return entity;    
   }


   public static HealthInsurance entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance entity) {
       HealthInsurance model = new HealthInsurance();
       model.setHealthInsuranceId(entity.getId());
       model.setCobra(entity.getCobra());
       model.setEmployerprovided(entity.getEmployerprovided());
       model.setInsurancefromanysource(Integer.parseInt(entity.getInsurancefromanysource().getValue()));
       model.setMedicaid(Integer.parseInt(entity.getMedicaid().getValue()));
       model.setMedicare(Integer.parseInt(entity.getMedicare().getValue()));
       model.setNocobrareason(Integer.parseInt(entity.getNocobrareason().getValue()));
       model.setNoemployerprovidedreason(Integer.parseInt(entity.getNoemployerprovidedreason().getValue()));
       model.setNomedicaidreason(Integer.parseInt(entity.getNomedicaidreason().getValue()));
       model.setNomedicarereason(Integer.parseInt(entity.getNomedicarereason().getValue()));
       model.setNoprivatepayreason(Integer.parseInt(entity.getNoprivatepayreason().getValue()));
       model.setNoschipreason(Integer.parseInt(entity.getNoschipreason().getValue()));
       model.setNostatehealthinsreason(Integer.parseInt(entity.getNostatehealthinsreason().getValue()));
       model.setNovamedreason(Integer.parseInt(entity.getNovamedreason().getValue()));
       model.setPrivatepay(Integer.parseInt(entity.getPrivatepay().getValue()));
       model.setSchip(Integer.parseInt(entity.getSchip().getValue()));
       model.setStatehealthins(Integer.parseInt(entity.getStatehealthins().getValue()));
       model.setVamedicalservices(Integer.parseInt(entity.getVamedicalservices().getValue()));
       copyBeanProperties(entity, model);
       return model;
   }


}
