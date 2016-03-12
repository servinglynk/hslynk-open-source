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
public class YouthCriticalIssuesConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues modelToEntity (YouthCriticalIssue model ,com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues();
       entity.setId(model.getYouthCriticalIssuesId());
       entity.setAbuseandneglectfam(YouthcriticalissuesAbuseandneglectfamEnum.valueOf(model.getAbuseandneglectfam()));
       entity.setAbuseandneglectyouth(YouthcriticalissuesAbuseandneglectyouthEnum.valueOf(model.getAbuseandneglectyouth()));
       entity.setActivemilitaryparent(YouthcriticalissuesActivemilitaryparentEnum.valueOf(model.getActivemilitaryparent()));
       entity.setAlcoholdrugabusefam(YouthcriticalissuesAlcoholdrugabusefamEnum.valueOf(model.getAlcoholdrugabusefam()));
       entity.setAlcoholdrugabuseyouth(YouthcriticalissuesAlcoholdrugabuseyouthEnum.valueOf(model.getAlcoholdrugabuseyouth()));
       entity.setHealthissuesfam(YouthcriticalissuesHealthissuesfamEnum.valueOf(model.getHealthissuesfam()));
       entity.setHealthissuesyouth(YouthcriticalissuesHealthissuesyouthEnum.valueOf(model.getHealthissuesyouth()));
       entity.setHouseholddynamics(YouthcriticalissuesHouseholddynamicsEnum.valueOf(model.getHouseholddynamics()));
       entity.setHousingissuesfam(YouthcriticalissuesHousingissuesfamEnum.valueOf(model.getHousingissuesfam()));
       entity.setHousingissuesyouth(YouthcriticalissuesHousingissuesyouthEnum.valueOf(model.getHousingissuesyouth()));
       entity.setIncarceratedparent(YouthcriticalissuesIncarceratedparentEnum.valueOf(model.getIncarceratedparent()));
       entity.setIncarceratedparentstatus(YouthcriticalissuesIncarceratedparentstatusEnum.valueOf(model.getIncarceratedparentstatus()));
       entity.setInsufficientincome(YouthcriticalissuesInsufficientincomeEnum.valueOf(model.getInsufficientincome()));
       entity.setMentaldisabilityfam(YouthcriticalissuesMentaldisabilityfamEnum.valueOf(model.getMentaldisabilityfam()));
       entity.setMentaldisabilityyouth(YouthcriticalissuesMentaldisabilityyouthEnum.valueOf(model.getMentaldisabilityyouth()));
       entity.setMentalhealthissuesfam(YouthcriticalissuesMentalhealthissuesfamEnum.valueOf(model.getMentalhealthissuesfam()));
       entity.setMentalhealthissuesyouth(YouthcriticalissuesMentalhealthissuesyouthEnum.valueOf(model.getMentalhealthissuesyouth()));
       entity.setPhysicaldisabilityfam(YouthcriticalissuesPhysicaldisabilityfamEnum.valueOf(model.getPhysicaldisabilityfam()));
       entity.setPhysicaldisabilityyouth(YouthcriticalissuesPhysicaldisabilityyouthEnum.valueOf(model.getPhysicaldisabilityyouth()));
       entity.setSchooleducationalissuesfam(YouthcriticalissuesSchooleducationalissuesfamEnum.valueOf(model.getSchooleducationalissuesfam()));
       entity.setSchooleducationalissuesyouth(YouthcriticalissuesSchooleducationalissuesyouthEnum.valueOf(model.getSchooleducationalissuesyouth()));
       entity.setSexualorientationgenderidfam(YouthcriticalissuesSexualorientationgenderidfamEnum.valueOf(model.getSexualorientationgenderidfam()));
       entity.setSexualorientationgenderidyouth(YouthcriticalissuesSexualorientationgenderidyouthEnum.valueOf(model.getSexualorientationgenderidyouth()));
       entity.setUnemploymentfam(YouthcriticalissuesUnemploymentfamEnum.valueOf(model.getUnemploymentfam()));
       entity.setUnemploymentyouth(YouthcriticalissuesUnemploymentyouthEnum.valueOf(model.getUnemploymentyouth()));
       return entity;    
   }


   public static YouthCriticalIssue entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues entity) {
       YouthCriticalIssue model = new YouthCriticalIssue();
       model.setYouthCriticalIssuesId(entity.getId());
       model.setAbuseandneglectfam(entity.getAbuseandneglectfam().name());
       model.setAbuseandneglectyouth(entity.getAbuseandneglectyouth().name());
       model.setActivemilitaryparent(entity.getActivemilitaryparent().name());
       model.setAlcoholdrugabusefam(entity.getAlcoholdrugabusefam().name());
       model.setAlcoholdrugabuseyouth(entity.getAlcoholdrugabuseyouth().name());
       model.setHealthissuesfam(entity.getHealthissuesfam().name());
       model.setHealthissuesyouth(entity.getHealthissuesyouth().name());
       model.setHouseholddynamics(entity.getHouseholddynamics().name());
       model.setHousingissuesfam(entity.getHousingissuesfam().name());
       model.setHousingissuesyouth(entity.getHousingissuesyouth().name());
       model.setIncarceratedparent(entity.getIncarceratedparent().name());
       model.setIncarceratedparentstatus(entity.getIncarceratedparentstatus().name());
       model.setInsufficientincome(entity.getInsufficientincome().name());
       model.setMentaldisabilityfam(entity.getMentaldisabilityfam().name());
       model.setMentaldisabilityyouth(entity.getMentaldisabilityyouth().name());
       model.setMentalhealthissuesfam(entity.getMentalhealthissuesfam().name());
       model.setMentalhealthissuesyouth(entity.getMentalhealthissuesyouth().name());
       model.setPhysicaldisabilityfam(entity.getPhysicaldisabilityfam().name());
       model.setPhysicaldisabilityyouth(entity.getPhysicaldisabilityyouth().name());
       model.setSchooleducationalissuesfam(entity.getSchooleducationalissuesfam().name());
       model.setSchooleducationalissuesyouth(entity.getSchooleducationalissuesyouth().name());
       model.setSexualorientationgenderidfam(entity.getSexualorientationgenderidfam().name());
       model.setSexualorientationgenderidyouth(entity.getSexualorientationgenderidyouth().name());
       model.setUnemploymentfam(entity.getUnemploymentfam().name());
       model.setUnemploymentyouth(entity.getUnemploymentyouth().name());
       return model;
   }


}
