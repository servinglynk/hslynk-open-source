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
public class VeteranInfoConverter {

   public static com.servinglynk.hmis.warehouse.model.live.VeteranInfo modelToEntity (VeteranInfo model ,com.servinglynk.hmis.warehouse.model.live.VeteranInfo entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.VeteranInfo();

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
       entity.setWorldWar2(VeteranInfoWorldWar2Enum.valueOf(model.getWorldWar2()));
       entity.setKoreanWar(VeteranInfoKoreanWarEnum.valueOf(model.getKoreanWar()));
       entity.setVietnamWar(VeteranInfoVietnamWarEnum.valueOf(model.getVietnamWar()));
       entity.setDesertStorm(VeteranInfoDesertStormEnum.valueOf(model.getDesertStorm()));
       entity.setAfghanistanOef(VeteranInfoAfghanistanOefEnum.valueOf(model.getAfghanistanOef()));
       entity.setIraqOif(VeteranInfoIraqOifEnum.valueOf(model.getIraqOif()));
       entity.setIraqOnd(VeteranInfoIraqOndEnum.valueOf(model.getIraqOnd()));
       entity.setOtherTheater(VeteranInfoOtherTheaterEnum.valueOf(model.getOtherTheater()));
       entity.setMilitaryBranch(VeteranInfoMilitaryBranchEnum.valueOf(model.getMilitaryBranch()));
       entity.setDischargeStatus(VeteranInfoDischargeStatusEnum.valueOf(model.getDischargeStatus()));

       return entity;    
   }


   public static VeteranInfo entityToModel (com.servinglynk.hmis.warehouse.model.live.VeteranInfo entity) {
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
       model.setWorldWar2(entity.getWorldWar2().name());
       model.setKoreanWar(entity.getKoreanWar().name());
       model.setVietnamWar(entity.getVietnamWar().name());
       model.setDesertStorm(entity.getDesertStorm().name());
       model.setAfghanistanOef(entity.getAfghanistanOef().name());
       model.setIraqOif(entity.getIraqOif().name());
       model.setIraqOnd(entity.getIraqOnd().name());
       model.setOtherTheater(entity.getOtherTheater().name());
       model.setMilitaryBranch(entity.getMilitaryBranch().name());
       model.setDischargeStatus(entity.getDischargeStatus().name());
       return model;
   }


}
