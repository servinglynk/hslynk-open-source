package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.NonCashBenefit;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsBenefitsfromanysourceEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsOthersourceEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsOthertanfEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsRentalassistanceongoingEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsRentalassistancetempEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsSnapEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsTanfchildcareEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsTanftransportationEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsWicEnum;
public class NonCashBenefitConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits modelToEntity (NonCashBenefit model ,com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits();
       entity.setId(model.getNonCashBenefitId());
       entity.setOthersource(NoncashbenefitsOthersourceEnum.valueOf(model.getOthersource()));
       entity.setOthersourceidentify(model.getOthersourceidentify());
       entity.setOthertanf(NoncashbenefitsOthertanfEnum.valueOf(model.getOthertanf()));
       entity.setRentalassistanceongoing(NoncashbenefitsRentalassistanceongoingEnum.valueOf(model.getRentalassistanceongoing()));
       entity.setRentalassistancetemp(NoncashbenefitsRentalassistancetempEnum.valueOf(model.getRentalassistancetemp()));
       entity.setSnap(NoncashbenefitsSnapEnum.valueOf(model.getSnap()));
       entity.setTanfchildcare(NoncashbenefitsTanfchildcareEnum.valueOf(model.getTanfchildcare()));
       entity.setTanftransportation(NoncashbenefitsTanftransportationEnum.valueOf(model.getTanftransportation()));
       entity.setWic(NoncashbenefitsWicEnum.valueOf(model.getWic()));
       entity.setBenefitsfromanysource(NoncashbenefitsBenefitsfromanysourceEnum.valueOf(model.getBenefitsfromanysource()));
       return entity;    
   }


   public static NonCashBenefit entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits entity) {
       NonCashBenefit model = new NonCashBenefit();
       model.setNonCashBenefitId(entity.getId());
       model.setOthersource(entity.getOthersource().name());
       model.setOthersourceidentify(entity.getOthersourceidentify());
       model.setOthertanf(entity.getOthertanf().name());
       model.setRentalassistanceongoing(entity.getRentalassistanceongoing().name());
       model.setRentalassistancetemp(entity.getRentalassistancetemp().name());
       model.setSnap(entity.getSnap().name());
       model.setTanfchildcare(entity.getTanfchildcare().name());
       model.setTanftransportation(entity.getTanftransportation().name());
       model.setWic(entity.getWic().name());
       model.setBenefitsfromanysource(entity.getBenefitsfromanysource().name());
       return model;
   }


}
