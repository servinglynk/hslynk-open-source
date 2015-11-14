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
public class HealthInsuranceConverter {

   public static com.servinglynk.hmis.warehouse.model.live.Healthinsurance modelToEntity (HealthInsurance model ,com.servinglynk.hmis.warehouse.model.live.Healthinsurance entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Healthinsurance();
       entity.setId(model.getHealthInsuranceId());
       entity.setCobra(model.getCobra());
       entity.setEmployerprovided(model.getEmployerprovided());
       entity.setInsurancefromanysource(HealthinsuranceInsurancefromanysourceEnum.valueOf(model.getInsurancefromanysource()));
       entity.setMedicaid(HealthinsuranceMedicaidEnum.valueOf(model.getMedicaid()));
       entity.setMedicare(HealthinsuranceMedicareEnum.valueOf(model.getMedicare()));
       entity.setNocobrareason(HealthinsuranceNocobrareasonEnum.valueOf(model.getNocobrareason()));
       entity.setNoemployerprovidedreason(HealthinsuranceNoemployerprovidedreasonEnum.valueOf(model.getNoemployerprovidedreason()));
       entity.setNomedicaidreason(HealthinsuranceNomedicaidreasonEnum.valueOf(model.getNomedicaidreason()));
       entity.setNomedicarereason(HealthinsuranceNomedicarereasonEnum.valueOf(model.getNomedicarereason()));
       entity.setNoprivatepayreason(HealthinsuranceNoprivatepayreasonEnum.valueOf(model.getNoprivatepayreason()));
       entity.setNoschipreason(HealthinsuranceNoschipreasonEnum.valueOf(model.getNoschipreason()));
       entity.setNostatehealthinsreason(HealthinsuranceNostatehealthinsreasonEnum.valueOf(model.getNostatehealthinsreason()));
       entity.setNovamedreason(HealthinsuranceNovamedreasonEnum.valueOf(model.getNovamedreason()));
       entity.setPrivatepay(HealthinsurancePrivatepayEnum.valueOf(model.getPrivatepay()));
       entity.setSchip(HealthinsuranceSchipEnum.valueOf(model.getSchip()));
       entity.setStatehealthins(HealthinsuranceStatehealthinsEnum.valueOf(model.getStatehealthins()));
       entity.setVamedicalservices(HealthinsuranceVamedicalservicesEnum.valueOf(model.getVamedicalservices()));
       return entity;    
   }


   public static HealthInsurance entityToModel (com.servinglynk.hmis.warehouse.model.live.Healthinsurance entity) {
       HealthInsurance model = new HealthInsurance();
       model.setHealthInsuranceId(entity.getId());
       model.setCobra(entity.getCobra());
       model.setEmployerprovided(entity.getEmployerprovided());
       model.setInsurancefromanysource(entity.getInsurancefromanysource().name());
       model.setMedicaid(entity.getMedicaid().name());
       model.setMedicare(entity.getMedicare().name());
       model.setNocobrareason(entity.getNocobrareason().name());
       model.setNoemployerprovidedreason(entity.getNoemployerprovidedreason().name());
       model.setNomedicaidreason(entity.getNomedicaidreason().name());
       model.setNomedicarereason(entity.getNomedicarereason().name());
       model.setNoprivatepayreason(entity.getNoprivatepayreason().name());
       model.setNoschipreason(entity.getNoschipreason().name());
       model.setNostatehealthinsreason(entity.getNostatehealthinsreason().name());
       model.setNovamedreason(entity.getNovamedreason().name());
       model.setPrivatepay(entity.getPrivatepay().name());
       model.setSchip(entity.getSchip().name());
       model.setStatehealthins(entity.getStatehealthins().name());
       model.setVamedicalservices(entity.getVamedicalservices().name());
       return model;
   }


}
