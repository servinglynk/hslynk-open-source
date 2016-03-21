package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.YouthCriticalIssue;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAbuseandneglectfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAbuseandneglectyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesActivemilitaryparentEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAlcoholdrugabusefamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAlcoholdrugabuseyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHealthissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHealthissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHouseholddynamicsEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHousingissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHousingissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesIncarceratedparentEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesIncarceratedparentstatusEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesInsufficientincomeEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentaldisabilityfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentaldisabilityyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentalhealthissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentalhealthissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesPhysicaldisabilityfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesPhysicaldisabilityyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSchooleducationalissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSchooleducationalissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSexualorientationgenderidfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSexualorientationgenderidyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesUnemploymentfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesUnemploymentyouthEnum;
public class YouthCriticalIssuesConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues modelToEntity (YouthCriticalIssue model ,com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues();
       entity.setId(model.getYouthCriticalIssuesId());
       entity.setAbuseandneglectfam(YouthcriticalissuesAbuseandneglectfamEnum.lookupEnum(model.getAbuseandneglectfam().toString()));
       entity.setAbuseandneglectyouth(YouthcriticalissuesAbuseandneglectyouthEnum.lookupEnum(model.getAbuseandneglectyouth().toString()));
       entity.setActivemilitaryparent(YouthcriticalissuesActivemilitaryparentEnum.lookupEnum(model.getActivemilitaryparent().toString()));
       entity.setAlcoholdrugabusefam(YouthcriticalissuesAlcoholdrugabusefamEnum.lookupEnum(model.getAlcoholdrugabusefam().toString()));
       entity.setAlcoholdrugabuseyouth(YouthcriticalissuesAlcoholdrugabuseyouthEnum.lookupEnum(model.getAlcoholdrugabuseyouth().toString()));
       entity.setHealthissuesfam(YouthcriticalissuesHealthissuesfamEnum.lookupEnum(model.getHealthissuesfam().toString()));
       entity.setHealthissuesyouth(YouthcriticalissuesHealthissuesyouthEnum.lookupEnum(model.getHealthissuesyouth().toString()));
       entity.setHouseholddynamics(YouthcriticalissuesHouseholddynamicsEnum.lookupEnum(model.getHouseholddynamics().toString()));
       entity.setHousingissuesfam(YouthcriticalissuesHousingissuesfamEnum.lookupEnum(model.getHousingissuesfam().toString()));
       entity.setHousingissuesyouth(YouthcriticalissuesHousingissuesyouthEnum.lookupEnum(model.getHousingissuesyouth().toString()));
       entity.setIncarceratedparent(YouthcriticalissuesIncarceratedparentEnum.lookupEnum(model.getIncarceratedparent().toString()));
       entity.setIncarceratedparentstatus(YouthcriticalissuesIncarceratedparentstatusEnum.lookupEnum(model.getIncarceratedparentstatus().toString()));
       entity.setInsufficientincome(YouthcriticalissuesInsufficientincomeEnum.lookupEnum(model.getInsufficientincome().toString()));
       entity.setMentaldisabilityfam(YouthcriticalissuesMentaldisabilityfamEnum.lookupEnum(model.getMentaldisabilityfam().toString()));
       entity.setMentaldisabilityyouth(YouthcriticalissuesMentaldisabilityyouthEnum.lookupEnum(model.getMentaldisabilityyouth().toString()));
       entity.setMentalhealthissuesfam(YouthcriticalissuesMentalhealthissuesfamEnum.lookupEnum(model.getMentalhealthissuesfam().toString()));
       entity.setMentalhealthissuesyouth(YouthcriticalissuesMentalhealthissuesyouthEnum.lookupEnum(model.getMentalhealthissuesyouth().toString()));
       entity.setPhysicaldisabilityfam(YouthcriticalissuesPhysicaldisabilityfamEnum.lookupEnum(model.getPhysicaldisabilityfam().toString()));
       entity.setPhysicaldisabilityyouth(YouthcriticalissuesPhysicaldisabilityyouthEnum.lookupEnum(model.getPhysicaldisabilityyouth().toString()));
       entity.setSchooleducationalissuesfam(YouthcriticalissuesSchooleducationalissuesfamEnum.lookupEnum(model.getSchooleducationalissuesfam().toString()));
       entity.setSchooleducationalissuesyouth(YouthcriticalissuesSchooleducationalissuesyouthEnum.lookupEnum(model.getSchooleducationalissuesyouth().toString()));
       entity.setSexualorientationgenderidfam(YouthcriticalissuesSexualorientationgenderidfamEnum.lookupEnum(model.getSexualorientationgenderidfam().toString()));
       entity.setSexualorientationgenderidyouth(YouthcriticalissuesSexualorientationgenderidyouthEnum.lookupEnum(model.getSexualorientationgenderidyouth().toString()));
       entity.setUnemploymentfam(YouthcriticalissuesUnemploymentfamEnum.lookupEnum(model.getUnemploymentfam().toString()));
       entity.setUnemploymentyouth(YouthcriticalissuesUnemploymentyouthEnum.lookupEnum(model.getUnemploymentyouth().toString()));
       return entity;    
   }


   public static YouthCriticalIssue entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues entity) {
       YouthCriticalIssue model = new YouthCriticalIssue();
       model.setYouthCriticalIssuesId(entity.getId());
       model.setAbuseandneglectfam(Integer.parseInt(entity.getAbuseandneglectfam().getValue()));
       model.setAbuseandneglectyouth(Integer.parseInt(entity.getAbuseandneglectyouth().getValue()));
       model.setActivemilitaryparent(Integer.parseInt(entity.getActivemilitaryparent().getValue()));
       model.setAlcoholdrugabusefam(Integer.parseInt(entity.getAlcoholdrugabusefam().getValue()));
       model.setAlcoholdrugabuseyouth(Integer.parseInt(entity.getAlcoholdrugabuseyouth().getValue()));
       model.setHealthissuesfam(Integer.parseInt(entity.getHealthissuesfam().getValue()));
       model.setHealthissuesyouth(Integer.parseInt(entity.getHealthissuesyouth().getValue()));
       model.setHouseholddynamics(Integer.parseInt(entity.getHouseholddynamics().getValue()));
       model.setHousingissuesfam(Integer.parseInt(entity.getHousingissuesfam().getValue()));
       model.setHousingissuesyouth(Integer.parseInt(entity.getHousingissuesyouth().getValue()));
       model.setIncarceratedparent(Integer.parseInt(entity.getIncarceratedparent().getValue()));
       model.setIncarceratedparentstatus(Integer.parseInt(entity.getIncarceratedparentstatus().getValue()));
       model.setInsufficientincome(Integer.parseInt(entity.getInsufficientincome().getValue()));
       model.setMentaldisabilityfam(Integer.parseInt(entity.getMentaldisabilityfam().getValue()));
       model.setMentaldisabilityyouth(Integer.parseInt(entity.getMentaldisabilityyouth().getValue()));
       model.setMentalhealthissuesfam(Integer.parseInt(entity.getMentalhealthissuesfam().getValue()));
       model.setMentalhealthissuesyouth(Integer.parseInt(entity.getMentalhealthissuesyouth().getValue()));
       model.setPhysicaldisabilityfam(Integer.parseInt(entity.getPhysicaldisabilityfam().getValue()));
       model.setPhysicaldisabilityyouth(Integer.parseInt(entity.getPhysicaldisabilityyouth().getValue()));
       model.setSchooleducationalissuesfam(Integer.parseInt(entity.getSchooleducationalissuesfam().getValue()));
       model.setSchooleducationalissuesyouth(Integer.parseInt(entity.getSchooleducationalissuesyouth().getValue()));
       model.setSexualorientationgenderidfam(Integer.parseInt(entity.getSexualorientationgenderidfam().getValue()));
       model.setSexualorientationgenderidyouth(Integer.parseInt(entity.getSexualorientationgenderidyouth().getValue()));
       model.setUnemploymentfam(Integer.parseInt(entity.getUnemploymentfam().getValue()));
       model.setUnemploymentyouth(Integer.parseInt(entity.getUnemploymentyouth().getValue()));
       copyBeanProperties(entity, model);
       return model;
   }


}
