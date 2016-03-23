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
public class YouthCriticalIssuesConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues modelToEntity (YouthCriticalIssue model ,com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues();
       if(model.getAbuseandneglectfam()!=null)
       entity.setId(model.getYouthCriticalIssuesId());
       if(model.getAbuseandneglectfam()!=null)
       entity.setAbuseandneglectfam(YouthcriticalissuesAbuseandneglectfamEnum.lookupEnum(model.getAbuseandneglectfam().toString()));
       if(model.getAbuseandneglectyouth()!=null)
       entity.setAbuseandneglectyouth(YouthcriticalissuesAbuseandneglectyouthEnum.lookupEnum(model.getAbuseandneglectyouth().toString()));
       if(model.getActivemilitaryparent()!=null)
       entity.setActivemilitaryparent(YouthcriticalissuesActivemilitaryparentEnum.lookupEnum(model.getActivemilitaryparent().toString()));
       if(model.getAlcoholdrugabusefam()!=null)
       entity.setAlcoholdrugabusefam(YouthcriticalissuesAlcoholdrugabusefamEnum.lookupEnum(model.getAlcoholdrugabusefam().toString()));
       if(model.getAlcoholdrugabuseyouth()!=null)
       entity.setAlcoholdrugabuseyouth(YouthcriticalissuesAlcoholdrugabuseyouthEnum.lookupEnum(model.getAlcoholdrugabuseyouth().toString()));
       if(model.getHealthissuesfam()!=null)
       entity.setHealthissuesfam(YouthcriticalissuesHealthissuesfamEnum.lookupEnum(model.getHealthissuesfam().toString()));
       if(model.getHealthissuesyouth()!=null)
       entity.setHealthissuesyouth(YouthcriticalissuesHealthissuesyouthEnum.lookupEnum(model.getHealthissuesyouth().toString()));
       if(model.getHealthissuesyouth()!=null)
       entity.setHouseholddynamics(YouthcriticalissuesHouseholddynamicsEnum.lookupEnum(model.getHouseholddynamics().toString()));
       if(model.getHousingissuesfam()!=null)
       entity.setHousingissuesfam(YouthcriticalissuesHousingissuesfamEnum.lookupEnum(model.getHousingissuesfam().toString()));
       if(model.getHousingissuesyouth()!=null)
       entity.setHousingissuesyouth(YouthcriticalissuesHousingissuesyouthEnum.lookupEnum(model.getHousingissuesyouth().toString()));
       if(model.getIncarceratedparent()!=null)
       entity.setIncarceratedparent(YouthcriticalissuesIncarceratedparentEnum.lookupEnum(model.getIncarceratedparent().toString()));
       if(model.getIncarceratedparentstatus()!=null)
       entity.setIncarceratedparentstatus(YouthcriticalissuesIncarceratedparentstatusEnum.lookupEnum(model.getIncarceratedparentstatus().toString()));
       if(model.getInsufficientincome()!=null)
       entity.setInsufficientincome(YouthcriticalissuesInsufficientincomeEnum.lookupEnum(model.getInsufficientincome().toString()));
       if(model.getInsufficientincome()!=null)
       entity.setMentaldisabilityfam(YouthcriticalissuesMentaldisabilityfamEnum.lookupEnum(model.getMentaldisabilityfam().toString()));
       if(model.getMentaldisabilityyouth()!=null)
       entity.setMentaldisabilityyouth(YouthcriticalissuesMentaldisabilityyouthEnum.lookupEnum(model.getMentaldisabilityyouth().toString()));
       if(model.getMentalhealthissuesfam()!=null)
       entity.setMentalhealthissuesfam(YouthcriticalissuesMentalhealthissuesfamEnum.lookupEnum(model.getMentalhealthissuesfam().toString()));
       if(model.getMentalhealthissuesyouth()!=null)
       entity.setMentalhealthissuesyouth(YouthcriticalissuesMentalhealthissuesyouthEnum.lookupEnum(model.getMentalhealthissuesyouth().toString()));
       if(model.getPhysicaldisabilityfam()!=null)
       entity.setPhysicaldisabilityfam(YouthcriticalissuesPhysicaldisabilityfamEnum.lookupEnum(model.getPhysicaldisabilityfam().toString()));
       if(model.getPhysicaldisabilityyouth()!=null)
       entity.setPhysicaldisabilityyouth(YouthcriticalissuesPhysicaldisabilityyouthEnum.lookupEnum(model.getPhysicaldisabilityyouth().toString()));
       if(model.getSchooleducationalissuesfam()!=null)
       entity.setSchooleducationalissuesfam(YouthcriticalissuesSchooleducationalissuesfamEnum.lookupEnum(model.getSchooleducationalissuesfam().toString()));
       if(model.getSchooleducationalissuesyouth().toString()!=null)
       entity.setSchooleducationalissuesyouth(YouthcriticalissuesSchooleducationalissuesyouthEnum.lookupEnum(model.getSchooleducationalissuesyouth().toString()));
       if(model.getSexualorientationgenderidfam()!=null)
       entity.setSexualorientationgenderidfam(YouthcriticalissuesSexualorientationgenderidfamEnum.lookupEnum(model.getSexualorientationgenderidfam().toString()));
       if(model.getSexualorientationgenderidyouth()!=null)
       entity.setSexualorientationgenderidyouth(YouthcriticalissuesSexualorientationgenderidyouthEnum.lookupEnum(model.getSexualorientationgenderidyouth().toString()));
       if(model.getUnemploymentfam()!=null)
       entity.setUnemploymentfam(YouthcriticalissuesUnemploymentfamEnum.lookupEnum(model.getUnemploymentfam().toString()));
       if(model.getUnemploymentyouth()!=null)
       entity.setUnemploymentyouth(YouthcriticalissuesUnemploymentyouthEnum.lookupEnum(model.getUnemploymentyouth().toString()));
       return entity;    
   }


   public static YouthCriticalIssue entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues entity) {
       YouthCriticalIssue model = new YouthCriticalIssue();
       if(entity.getId()!=null)
       model.setYouthCriticalIssuesId(entity.getId());
       if(entity.getAbuseandneglectfam()!=null)
       model.setAbuseandneglectfam(Integer.parseInt(entity.getAbuseandneglectfam().getValue()));
       if(entity.getAbuseandneglectyouth()!=null)
       model.setAbuseandneglectyouth(Integer.parseInt(entity.getAbuseandneglectyouth().getValue()));
       if(entity.getActivemilitaryparent()!=null)
       model.setActivemilitaryparent(Integer.parseInt(entity.getActivemilitaryparent().getValue()));
       if(entity.getAlcoholdrugabusefam()!=null)
       model.setAlcoholdrugabusefam(Integer.parseInt(entity.getAlcoholdrugabusefam().getValue()));
       if(entity.getAlcoholdrugabuseyouth()!=null)
       model.setAlcoholdrugabuseyouth(Integer.parseInt(entity.getAlcoholdrugabuseyouth().getValue()));
       if(entity.getHealthissuesfam()!=null)
       model.setHealthissuesfam(Integer.parseInt(entity.getHealthissuesfam().getValue()));
       if(entity.getHealthissuesyouth()!=null)
       model.setHealthissuesyouth(Integer.parseInt(entity.getHealthissuesyouth().getValue()));
       if(entity.getHouseholddynamics()!=null)
       model.setHouseholddynamics(Integer.parseInt(entity.getHouseholddynamics().getValue()));
       if(entity.getHousingissuesfam()!=null)
       model.setHousingissuesfam(Integer.parseInt(entity.getHousingissuesfam().getValue()));
       if(entity.getHousingissuesyouth()!=null)
       model.setHousingissuesyouth(Integer.parseInt(entity.getHousingissuesyouth().getValue()));
       if(entity.getIncarceratedparent()!=null)
       model.setIncarceratedparent(Integer.parseInt(entity.getIncarceratedparent().getValue()));
       if(entity.getIncarceratedparentstatus()!=null)
       model.setIncarceratedparentstatus(Integer.parseInt(entity.getIncarceratedparentstatus().getValue()));
       if(entity.getInsufficientincome()!=null)
       model.setInsufficientincome(Integer.parseInt(entity.getInsufficientincome().getValue()));
       if(entity.getMentaldisabilityfam()!=null)
       model.setMentaldisabilityfam(Integer.parseInt(entity.getMentaldisabilityfam().getValue()));
       if(entity.getMentaldisabilityyouth()!=null)
       model.setMentaldisabilityyouth(Integer.parseInt(entity.getMentaldisabilityyouth().getValue()));
       if(entity.getMentalhealthissuesfam()!=null)
       model.setMentalhealthissuesfam(Integer.parseInt(entity.getMentalhealthissuesfam().getValue()));
       if(entity.getMentalhealthissuesyouth()!=null)
       model.setMentalhealthissuesyouth(Integer.parseInt(entity.getMentalhealthissuesyouth().getValue()));
       if(entity.getPhysicaldisabilityfam()!=null)
       model.setPhysicaldisabilityfam(Integer.parseInt(entity.getPhysicaldisabilityfam().getValue()));
       if(entity.getPhysicaldisabilityyouth()!=null)
       model.setPhysicaldisabilityyouth(Integer.parseInt(entity.getPhysicaldisabilityyouth().getValue()));
       if(entity.getSchooleducationalissuesfam()!=null)
       model.setSchooleducationalissuesfam(Integer.parseInt(entity.getSchooleducationalissuesfam().getValue()));
       if(entity.getSchooleducationalissuesyouth()!=null)
       model.setSchooleducationalissuesyouth(Integer.parseInt(entity.getSchooleducationalissuesyouth().getValue()));
       if(entity.getSexualorientationgenderidfam()!=null)
       model.setSexualorientationgenderidfam(Integer.parseInt(entity.getSexualorientationgenderidfam().getValue()));
       if(entity.getSexualorientationgenderidyouth()!=null)
       model.setSexualorientationgenderidyouth(Integer.parseInt(entity.getSexualorientationgenderidyouth().getValue()));
       if(entity.getUnemploymentfam()!=null)
       model.setUnemploymentfam(Integer.parseInt(entity.getUnemploymentfam().getValue()));
       if(entity.getUnemploymentyouth()!=null)
       model.setUnemploymentyouth(Integer.parseInt(entity.getUnemploymentyouth().getValue()));
       copyBeanProperties(entity, model);
       return model;
   }


}
