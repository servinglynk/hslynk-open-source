package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
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
public class VeteranInfoConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2017.ClientVeteranInfo modelToEntity (VeteranInfo model ,com.servinglynk.hmis.warehouse.model.v2017.ClientVeteranInfo entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2017.ClientVeteranInfo();

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
       if(model.getYearEntrdService()!=null)
       entity.setYearEntrdService(model.getYearEntrdService());
       if(model.getYearSeperated()!=null)
       entity.setYearSeperated(model.getYearSeperated());
       if(model.getWorldWar2()!=null)
       entity.setWorldWar2(VeteranInfoWorldWar2Enum.lookupEnum(model.getWorldWar2().toString()));
       if(model.getKoreanWar()!=null)
       entity.setKoreanWar(VeteranInfoKoreanWarEnum.lookupEnum(model.getKoreanWar().toString()));
       if(model.getVietnamWar()!=null)
       entity.setVietnamWar(VeteranInfoVietnamWarEnum.lookupEnum(model.getVietnamWar().toString()));
       if(model.getDesertStorm()!=null)
       entity.setDesertStorm(VeteranInfoDesertStormEnum.lookupEnum(model.getDesertStorm().toString()));
       if(model.getAfghanistanOef()!=null)
       entity.setAfghanistanOef(VeteranInfoAfghanistanOefEnum.lookupEnum(model.getAfghanistanOef().toString()));
       if(model.getIraqOif()!=null)
       entity.setIraqOif(VeteranInfoIraqOifEnum.lookupEnum(model.getIraqOif().toString()));
       if(model.getIraqOnd()!=null)
       entity.setIraqOnd(VeteranInfoIraqOndEnum.lookupEnum(model.getIraqOnd().toString()));
       if(model.getOtherTheater()!=null)
       entity.setOtherTheater(VeteranInfoOtherTheaterEnum.lookupEnum(model.getOtherTheater().toString()));
       if(model.getMilitaryBranch()!=null)
       entity.setMilitaryBranch(VeteranInfoMilitaryBranchEnum.lookupEnum(model.getMilitaryBranch().toString()));
       if(model.getDischargeStatus()!=null)
       entity.setDischargeStatus(VeteranInfoDischargeStatusEnum.lookupEnum(model.getDischargeStatus().toString()));
       copyBeanProperties(entity, model);
       return entity;
   }


   public static VeteranInfo entityToModel (com.servinglynk.hmis.warehouse.model.v2017.ClientVeteranInfo entity) {
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
	   if(entity.getId()!=null)
       model.setVeteranInfoId(entity.getId());
	   if(entity.getYearEntrdService()!=null)
       model.setYearEntrdService(entity.getYearEntrdService());
	   if(entity.getYearSeperated()!=null)
       model.setYearSeperated(entity.getYearSeperated());
	   if(entity.getWorldWar2()!=null)
       model.setWorldWar2(Integer.parseInt(entity.getWorldWar2().getValue()));
	   if(entity.getKoreanWar()!=null)
       model.setKoreanWar(Integer.parseInt(entity.getKoreanWar().getValue()));
	   if(entity.getVietnamWar()!=null)
       model.setVietnamWar(Integer.parseInt(entity.getVietnamWar().getValue()));
	   if(entity.getDesertStorm()!=null)
       model.setDesertStorm(Integer.parseInt(entity.getDesertStorm().getValue()));
	   if(entity.getAfghanistanOef()!=null)
       model.setAfghanistanOef(Integer.parseInt(entity.getAfghanistanOef().getValue()));
	   if(entity.getIraqOif()!=null)
       model.setIraqOif(Integer.parseInt(entity.getIraqOif().getValue()));
	   if(entity.getIraqOnd()!=null)
       model.setIraqOnd(Integer.parseInt(entity.getIraqOnd().getValue()));
	   if(entity.getOtherTheater()!=null)
       model.setOtherTheater(Integer.parseInt(entity.getOtherTheater().getValue()));
	   if(entity.getMilitaryBranch()!=null)
       model.setMilitaryBranch(Integer.parseInt(entity.getMilitaryBranch().getValue()));
	   if(entity.getDischargeStatus()!=null)
       model.setDischargeStatus(Integer.parseInt(entity.getDischargeStatus().getValue()));
       if(entity.getParentId() ==null && entity.getClient()!=null) {
    	   model.addLink(new ActionLink("history","/clients/"+entity.getClient().getId()+"/veteraninfos/"+entity.getId()+"/history"));
       }
       return model;
   }


}
