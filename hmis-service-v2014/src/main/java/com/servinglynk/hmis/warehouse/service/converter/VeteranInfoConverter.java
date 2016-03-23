package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.VeteranInfo;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoAfghanistanOefEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoDesertStormEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoDischargeStatusEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoIraqOifEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoIraqOndEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoKoreanWarEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoMilitaryBranchEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoOtherTheaterEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoVietnamWarEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoWorldWar2Enum;
public class VeteranInfoConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo modelToEntity (VeteranInfo model ,com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo();

/*       entity.setAfghanistanOef(VeteranInfoAfghanistanOefEnum.valueOf(model.getAfghanistanOef()));
       entity.setDesertStorm(VeteranInfoDesertStormEnum.valueOf(model.getDesertStorm()));
       entity.setIraqOif(VeteranInfoIraqOifEnum.valueOf(model.getIraqOif()));
       entity.setIraqOnd(VeteranInfoIraqOndEnum.valueOf(model.getIraqOnd()));
       entity.setKoreanWar(VeteranInfoKoreanWarEnum.valueOf(model.getKoreanWar()));
       entity.setMilitaryBranch(VeteranInfoMilitaryBranchEnum.valueOf(model.getMilitaryBranch()));
       entity.setOtherTheater(VeteranInfoOtherTheaterEnum.valueOf(model.getOtherTheater()));
       entity.setVietnamWar(VeteranInfoVietnamWarEnum.valueOf(model.getVietnamWar()));
       entity.setWorldWar2(VeteranInfoWorldWar2Enum.valueOf(model.getWorldWar2()));
       entity.setYearEntrdService(model.getYearEntrdService());
       entity.setYearSeperated(model.getYearSeperated());*/
       
       entity.setYearEntrdService(model.getYearEntrdService());
       entity.setYearSeperated(model.getYearSeperated());
       entity.setWorldWar2(VeteranInfoWorldWar2Enum.lookupEnum(model.getWorldWar2().toString()));
       entity.setKoreanWar(VeteranInfoKoreanWarEnum.lookupEnum(model.getKoreanWar().toString()));
       entity.setVietnamWar(VeteranInfoVietnamWarEnum.lookupEnum(model.getVietnamWar().toString()));
       entity.setDesertStorm(VeteranInfoDesertStormEnum.lookupEnum(model.getDesertStorm().toString()));
       entity.setAfghanistanOef(VeteranInfoAfghanistanOefEnum.lookupEnum(model.getAfghanistanOef().toString()));
       entity.setIraqOif(VeteranInfoIraqOifEnum.lookupEnum(model.getIraqOif().toString()));
       entity.setIraqOnd(VeteranInfoIraqOndEnum.lookupEnum(model.getIraqOnd().toString()));
       entity.setOtherTheater(VeteranInfoOtherTheaterEnum.lookupEnum(model.getOtherTheater().toString()));
       entity.setMilitaryBranch(VeteranInfoMilitaryBranchEnum.lookupEnum(model.getMilitaryBranch().toString()));
       entity.setDischargeStatus(VeteranInfoDischargeStatusEnum.lookupEnum(model.getDischargeStatus().toString()));
       copyBeanProperties(entity, model);
       return entity;    
   }


   public static VeteranInfo entityToModel (com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo entity) {
/*       VeteranInfo veteranInfo= new VeteranInfo();
       
       
       veteranInfo.setAfghanistanOef(entity.getAfghanistanOef().name());
       veteranInfo.setDesertStorm(entity.getDesertStorm().name());
       veteranInfo.setIraqOif(entity.getIraqOif().name());
       veteranInfo.setIraqOnd(entity.getIraqOnd().name());
       veteranInfo.setKoreanWar(entity.getKoreanWar().name());
       veteranInfo.setMilitaryBranch(entity.getMilitaryBranch().name());
       veteranInfo.setOtherTheater(entity.getOtherTheater().name());
       veteranInfo.setVietnamWar(entity.getVietnamWar().name());
       veteranInfo.setWorldWar2(entity.getWorldWar2().name());
       veteranInfo.setYearEntrdService(entity.getYearEntrdService());
       veteranInfo.setYearSeperated(entity.getYearSeperated());
       veteranInfo.setVeteranInfoId(entity.getId());
       return veteranInfo;*/
	   
	   VeteranInfo model = new VeteranInfo();
       model.setVeteranInfoId(entity.getId());
       model.setYearEntrdService(entity.getYearEntrdService());
       model.setYearSeperated(entity.getYearSeperated());
       model.setWorldWar2(Integer.parseInt(entity.getWorldWar2().getValue()));
       model.setKoreanWar(Integer.parseInt(entity.getKoreanWar().getValue()));
       model.setVietnamWar(Integer.parseInt(entity.getVietnamWar().getValue()));
       model.setDesertStorm(Integer.parseInt(entity.getDesertStorm().getValue()));
       model.setAfghanistanOef(Integer.parseInt(entity.getAfghanistanOef().getValue()));
       model.setIraqOif(Integer.parseInt(entity.getIraqOif().getValue()));
       model.setIraqOnd(Integer.parseInt(entity.getIraqOnd().getValue()));
       model.setOtherTheater(Integer.parseInt(entity.getOtherTheater().getValue()));
       model.setMilitaryBranch(Integer.parseInt(entity.getMilitaryBranch().getValue()));
       model.setDischargeStatus(Integer.parseInt(entity.getDischargeStatus().getValue()));
       return model;
   }


}
