package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Healthinsurance;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
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
import com.servinglynk.hmis.warehouse.enums.NoYesEnum;

public class HealthinsuranceConverter extends BaseConverter {

	public static com.servinglynk.hmis.warehouse.model.v2016.Healthinsurance modelToEntity(Healthinsurance model,
			com.servinglynk.hmis.warehouse.model.v2016.Healthinsurance entity) {
		if (entity == null)
			entity = new com.servinglynk.hmis.warehouse.model.v2016.Healthinsurance();
		entity.setId(model.getHealthinsuranceId());
		if(model.getInsurancefromanysource()!=null)
		entity.setInsurancefromanysource(HealthinsuranceInsurancefromanysourceEnum.lookupEnum(model.getInsurancefromanysource().toString()));
		if(model.getMedicaid()!=null)
		entity.setMedicaid(HealthinsuranceMedicaidEnum.lookupEnum(model.getMedicaid().toString()));
		if (model.getNomedicaidreason() != null)
			entity.setNomedicaidreason(
					HealthinsuranceNomedicaidreasonEnum.lookupEnum(model.getNomedicaidreason().toString()));
		if (model.getMedicare() != null)
			entity.setMedicare(HealthinsuranceMedicareEnum.lookupEnum(model.getMedicare().toString()));
		if (model.getNomedicarereason() != null)
			entity.setNomedicarereason(
					HealthinsuranceNomedicarereasonEnum.lookupEnum(model.getNomedicarereason().toString()));
		if (model.getSchip() != null)
			entity.setSchip(HealthinsuranceSchipEnum.lookupEnum(model.getSchip().toString()));
		if (model.getNoschipreason() != null)
			entity.setNoschipreason(HealthinsuranceNoschipreasonEnum.lookupEnum(model.getNoschipreason().toString()));
		if (model.getVamedicalservices() != null)
			entity.setVamedicalservices(
					HealthinsuranceVamedicalservicesEnum.lookupEnum(model.getVamedicalservices().toString()));
		if (model.getNovamedreason() != null)
			entity.setNovamedreason(HealthinsuranceNovamedreasonEnum.lookupEnum(model.getNovamedreason().toString()));
		entity.setEmployerprovided(model.getEmployerprovided());
		if (model.getNoemployerprovidedreason() != null)
			entity.setNoemployerprovidedreason(HealthinsuranceNoemployerprovidedreasonEnum
					.lookupEnum(model.getNoemployerprovidedreason().toString()));
		entity.setCobra(model.getCobra());
		if (model.getNocobrareason() != null)
			entity.setNocobrareason(HealthinsuranceNocobrareasonEnum.lookupEnum(model.getNocobrareason().toString()));
		if (model.getPrivatepay() != null)
			entity.setPrivatepay(HealthinsurancePrivatepayEnum.lookupEnum(model.getPrivatepay().toString()));
		if (model.getNoprivatepayreason() != null)
			entity.setNoprivatepayreason(
					HealthinsuranceNoprivatepayreasonEnum.lookupEnum(model.getNoprivatepayreason().toString()));
		if (model.getStatehealthinadults() != null)
			entity.setStatehealthinadults(
					HealthinsuranceStatehealthinsEnum.lookupEnum(model.getStatehealthinadults().toString()));
		if (model.getNostatehealthinsreason() != null)
			entity.setNostatehealthinsreason(
					HealthinsuranceNostatehealthinsreasonEnum.lookupEnum(model.getNostatehealthinsreason().toString()));
		if (model.getOtherInsurance() != null)
		entity.setOtherInsurance(NoYesEnum.lookupEnum(model.getOtherInsurance()+""));
//		if (model.getOtherInsuranceIdentify() != null)
//		entity.setOtherInsuranceIdentify(model.getOtherInsuranceIdentify());
		if(model.getIndianHealthServices()!=null)
			entity.setIndianHealthServices(NoYesEnum.lookupEnum(model.getIndianHealthServices()+""));
		if(model.getNoIndianHealthServicesReason()!=null)
			entity.setNoIndianHealthServicesReason(HealthinsuranceNomedicaidreasonEnum.lookupEnum(model.getNoIndianHealthServicesReason()+""));
		 if(model.getDataCollectionStage() !=null)
			   	entity.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(model.getDataCollectionStage().toString()));

		 if(model.getInformationDate()!=null)
			    entity.setInformationDate(model.getInformationDate());


		return entity;
	}

	public static Healthinsurance entityToModel(com.servinglynk.hmis.warehouse.model.v2016.Healthinsurance entity) {
		Healthinsurance model = new Healthinsurance();
		model.setHealthinsuranceId(entity.getId());
		if(entity.getInsurancefromanysource()!=null)
		model.setInsurancefromanysource(Integer.parseInt(entity.getInsurancefromanysource().getValue()));
		if(entity.getMedicaid()!=null)
		model.setMedicaid(Integer.parseInt(entity.getMedicaid().getValue()));
		if (entity.getNomedicaidreason() != null)
			model.setNomedicaidreason(Integer.parseInt(entity.getNomedicaidreason().getValue()));
		if (entity.getMedicare() != null)
			model.setMedicare(Integer.parseInt(entity.getMedicare().getValue()));
		if (entity.getNomedicarereason() != null)
			model.setNomedicarereason(Integer.parseInt(entity.getNomedicarereason().getValue()));
		if (entity.getSchip() != null)
			model.setSchip(Integer.parseInt(entity.getSchip().getValue()));
		if (entity.getNoschipreason() != null)
			model.setNoschipreason(Integer.parseInt(entity.getNoschipreason().getValue()));
		if (entity.getVamedicalservices() != null)
			model.setVamedicalservices(Integer.parseInt(entity.getVamedicalservices().getValue()));
		if (entity.getNovamedreason() != null)
			model.setNovamedreason(Integer.parseInt(entity.getNovamedreason().getValue()));
		model.setEmployerprovided(entity.getEmployerprovided());
		if (entity.getNoemployerprovidedreason() != null)
			model.setNoemployerprovidedreason(Integer.parseInt(entity.getNoemployerprovidedreason().getValue()));
		model.setCobra(entity.getCobra());
		if (entity.getNocobrareason() != null)
			model.setNocobrareason(Integer.parseInt(entity.getNocobrareason().getValue()));
		if (entity.getPrivatepay() != null)
			model.setPrivatepay(Integer.parseInt(entity.getPrivatepay().getValue()));
		if (entity.getNoprivatepayreason() != null)
			model.setNoprivatepayreason(Integer.parseInt(entity.getNoprivatepayreason().getValue()));
		if (entity.getStatehealthinadults() != null)
			model.setStatehealthinadults(Integer.parseInt(entity.getStatehealthinadults().getValue()));
		if (entity.getNostatehealthinsreason() != null)
			model.setNostatehealthinsreason(Integer.parseInt(entity.getNostatehealthinsreason().getValue()));
		if (entity.getOtherInsurance() != null)
		model.setOtherInsurance(Integer.parseInt(entity.getOtherInsurance().getValue()));
//		if (entity.getOtherInsuranceIdentify() != null)
//		model.setOtherInsuranceIdentify(entity.getOtherInsuranceIdentify());
		if(entity.getIndianHealthServices()!=null)
			model.setIndianHealthServices(Integer.parseInt(entity.getIndianHealthServices().getValue()));
		if(entity.getNoIndianHealthServicesReason()!=null)
			model.setNoIndianHealthServicesReason(Integer.parseInt(entity.getNoIndianHealthServicesReason().getValue()));
		
	    if(entity.getInformationDate()!=null)
	        model.setInformationDate(entity.getInformationDate());
	     if(entity.getDataCollectionStage() !=null)
	         model.setDataCollectionStage(Integer.parseInt(entity.getDataCollectionStage().getValue()));
		return model;
	}

}
