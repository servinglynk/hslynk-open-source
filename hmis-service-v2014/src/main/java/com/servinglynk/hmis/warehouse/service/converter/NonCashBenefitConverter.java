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
public class NonCashBenefitConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits modelToEntity (NonCashBenefit model ,com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits();
       entity.setId(model.getNonCashBenefitId());
       entity.setOthersource(NoncashbenefitsOthersourceEnum.lookupEnum(model.getOthersource().toString()));
       entity.setOthersourceidentify(model.getOthersourceidentify());
       entity.setOthertanf(NoncashbenefitsOthertanfEnum.lookupEnum(model.getOthertanf().toString()));
       entity.setRentalassistanceongoing(NoncashbenefitsRentalassistanceongoingEnum.lookupEnum(model.getRentalassistanceongoing().toString()));
       entity.setRentalassistancetemp(NoncashbenefitsRentalassistancetempEnum.lookupEnum(model.getRentalassistancetemp().toString()));
       entity.setSnap(NoncashbenefitsSnapEnum.lookupEnum(model.getSnap().toString()));
       entity.setTanfchildcare(NoncashbenefitsTanfchildcareEnum.lookupEnum(model.getTanfchildcare().toString()));
       entity.setTanftransportation(NoncashbenefitsTanftransportationEnum.lookupEnum(model.getTanftransportation().toString()));
       entity.setWic(NoncashbenefitsWicEnum.lookupEnum(model.getWic().toString()));
       entity.setBenefitsfromanysource(NoncashbenefitsBenefitsfromanysourceEnum.lookupEnum(model.getBenefitsfromanysource().toString()));
       return entity;    
   }


   public static NonCashBenefit entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits entity) {
       NonCashBenefit model = new NonCashBenefit();
       model.setNonCashBenefitId(entity.getId());
       model.setOthersource(Integer.parseInt(entity.getOthersource().getValue()));
       model.setOthersourceidentify(entity.getOthersourceidentify());
       model.setOthertanf(Integer.parseInt(entity.getOthertanf().getValue()));
       model.setRentalassistanceongoing(Integer.parseInt(entity.getRentalassistanceongoing().getValue()));
       model.setRentalassistancetemp(Integer.parseInt(entity.getRentalassistancetemp().getValue()));
       model.setSnap(Integer.parseInt(entity.getSnap().getValue()));
       model.setTanfchildcare(Integer.parseInt(entity.getTanfchildcare().getValue()));
       model.setTanftransportation(Integer.parseInt(entity.getTanftransportation().getValue()));
       model.setWic(Integer.parseInt(entity.getWic().getValue()));
       model.setBenefitsfromanysource(Integer.parseInt(entity.getBenefitsfromanysource().getValue()));
       copyBeanProperties(entity, model);
       return model;
   }


}
