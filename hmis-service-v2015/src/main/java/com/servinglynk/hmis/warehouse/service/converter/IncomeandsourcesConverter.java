package com.servinglynk.hmis.warehouse.service.converter;

import java.math.BigDecimal;

import com.servinglynk.hmis.warehouse.core.model.Incomeandsources;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesAlimonyEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesChildsupportEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesEarnedEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesGaEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesIncomefromanysourceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesOthersourceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesPensionEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesPrivatedisabilityEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSocsecretirementEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSsdiEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSsiEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesTanfEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesUnemploymentEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesVadisabilitynonserviceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesVadisabilityserviceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesWorkerscompEnum;

public class IncomeandsourcesConverter extends BaseConverter {

	public static com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources modelToEntity(Incomeandsources model,
			com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources entity) {
		if (entity == null)
			entity = new com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources();
		entity.setId(model.getIncomeandsourcesId());
		if (model.getAlimony() != null)
			entity.setAlimony(IncomeandsourcesAlimonyEnum.lookupEnum(model.getAlimony().toString()));
		entity.setAlimonyamount(model.getAlimonyamount());
		if (model.getChildsupport() != null)
			entity.setChildsupport(IncomeandsourcesChildsupportEnum.lookupEnum(model.getChildsupport().toString()));
		entity.setChildsupportamount(new BigDecimal(model.getChildsupportamount()));
		if (model.getEarned() != null)
			entity.setEarned(IncomeandsourcesEarnedEnum.lookupEnum(model.getEarned().toString()));
		entity.setEarnedamount(new BigDecimal(model.getEarnedamount()));
		if (model.getGa() != null)
			entity.setGa(IncomeandsourcesGaEnum.lookupEnum(model.getGa().toString()));
		entity.setGaamount(new BigDecimal(model.getGaamount()));
		if (model.getIncomefromanysource() != null)
			entity.setIncomefromanysource(
					IncomeandsourcesIncomefromanysourceEnum.lookupEnum(model.getIncomefromanysource().toString()));
		if (model.getOthersource() != null)
			entity.setOthersource(IncomeandsourcesOthersourceEnum.lookupEnum(model.getOthersource().toString()));
		entity.setOthersourceamount(new BigDecimal(model.getOthersourceamount()));
		entity.setOthersourceidentify(model.getOthersourceidentify());
		if (model.getPension() != null)
			entity.setPension(IncomeandsourcesPensionEnum.lookupEnum(model.getPension().toString()));
		entity.setPensionamount(new BigDecimal(model.getPensionamount()));
		if (model.getPrivatedisability() != null)
			entity.setPrivatedisability(
					IncomeandsourcesPrivatedisabilityEnum.lookupEnum(model.getPrivatedisability().toString()));
		entity.setPrivatedisabilityamount(new BigDecimal(model.getPrivatedisabilityamount()));
		if (model.getSocsecretirement() != null)
			entity.setSocsecretirement(
					IncomeandsourcesSocsecretirementEnum.lookupEnum(model.getSocsecretirement().toString()));
		entity.setSocsecretirementamount(new BigDecimal(model.getSocsecretirementamount()));
		if (model.getSsdi() != null)
			entity.setSsdi(IncomeandsourcesSsdiEnum.lookupEnum(model.getSsdi().toString()));
		entity.setSsdiamount(new BigDecimal(model.getSsdiamount()));
		if (model.getSsi() != null)
			entity.setSsi(IncomeandsourcesSsiEnum.lookupEnum(model.getSsi().toString()));
		entity.setSsiamount(new BigDecimal(model.getSsiamount()));
		if (model.getTanf() != null)
			entity.setTanf(IncomeandsourcesTanfEnum.lookupEnum(model.getTanf().toString()));
		entity.setTanfamount(new BigDecimal(model.getTanfamount()));
		entity.setTotalmonthlyincome(new BigDecimal(model.getTotalmonthlyincome()));
		if (model.getUnemployment() != null)
			entity.setUnemployment(IncomeandsourcesUnemploymentEnum.lookupEnum(model.getUnemployment().toString()));
		entity.setUnemploymentamount(new BigDecimal(model.getUnemploymentamount()));
		if (model.getVadisabilitynonservice() != null)
			entity.setVadisabilitynonservice(IncomeandsourcesVadisabilitynonserviceEnum
					.lookupEnum(model.getVadisabilitynonservice().toString()));
		entity.setVadisabilitynonserviceamount(new BigDecimal(model.getVadisabilitynonserviceamount()));
		if (model.getVadisabilityservice() != null)
			entity.setVadisabilityservice(
					IncomeandsourcesVadisabilityserviceEnum.lookupEnum(model.getVadisabilityservice().toString()));
		entity.setVadisabilityserviceamount(new BigDecimal(model.getVadisabilityserviceamount()));
		if (model.getWorkerscomp() != null)
			entity.setWorkerscomp(IncomeandsourcesWorkerscompEnum.lookupEnum(model.getWorkerscomp().toString()));
		entity.setWorkerscompamount(new BigDecimal(model.getWorkerscompamount()));
		return entity;
	}

	public static Incomeandsources entityToModel(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources entity) {
		Incomeandsources model = new Incomeandsources();
		model.setIncomeandsourcesId(entity.getId());
		if (entity.getAlimony() != null)
			model.setAlimony(Integer.parseInt(entity.getAlimony().getValue()));
		model.setAlimonyamount(entity.getAlimonyamount());
		if (entity.getChildsupport() != null)
			model.setChildsupport(Integer.parseInt(entity.getChildsupport().getValue()));
		model.setChildsupportamount(entity.getChildsupportamount().floatValue());
		if (entity.getEarned() != null)
			model.setEarned(Integer.parseInt(entity.getEarned().getValue()));
		model.setEarnedamount(entity.getEarnedamount().floatValue());
		if (entity.getGa() != null)
			model.setGa(Integer.parseInt(entity.getGa().getValue()));
		model.setGaamount(entity.getGaamount().floatValue());
		if (entity.getIncomefromanysource() != null)
			model.setIncomefromanysource(Integer.parseInt(entity.getIncomefromanysource().getValue()));
		if (entity.getOthersource() != null)
			model.setOthersource(Integer.parseInt(entity.getOthersource().getValue()));
		model.setOthersourceamount(entity.getOthersourceamount().floatValue());
		model.setOthersourceidentify(entity.getOthersourceidentify());
		if (entity.getPension() != null)
			model.setPension(Integer.parseInt(entity.getPension().getValue()));
		model.setPensionamount(entity.getPensionamount().floatValue());
		if (entity.getPrivatedisability() != null)
			model.setPrivatedisability(Integer.parseInt(entity.getPrivatedisability().getValue()));
		model.setPrivatedisabilityamount(entity.getPrivatedisabilityamount().floatValue());
		if (entity.getSocsecretirement() != null)
			model.setSocsecretirement(Integer.parseInt(entity.getSocsecretirement().getValue()));
		model.setSocsecretirementamount(entity.getSocsecretirementamount().floatValue());
		if (entity.getSsdi() != null)
			model.setSsdi(Integer.parseInt(entity.getSsdi().getValue()));
		model.setSsdiamount(entity.getSsdiamount().floatValue());
		if (entity.getSsi() != null)
			model.setSsi(Integer.parseInt(entity.getSsi().getValue()));
		model.setSsiamount(entity.getSsiamount().floatValue());
		if (entity.getTanf() != null)
			model.setTanf(Integer.parseInt(entity.getTanf().getValue()));
		model.setTanfamount(entity.getTanfamount().floatValue());
		model.setTotalmonthlyincome(entity.getTotalmonthlyincome().floatValue());
		if (entity.getUnemployment() != null)
			model.setUnemployment(Integer.parseInt(entity.getUnemployment().getValue()));
		model.setUnemploymentamount(entity.getUnemploymentamount().intValue());
		if (entity.getVadisabilitynonservice() != null)
			model.setVadisabilitynonservice(Integer.parseInt(entity.getVadisabilitynonservice().getValue()));
		model.setVadisabilitynonserviceamount(entity.getVadisabilitynonserviceamount().intValue());
		if (entity.getVadisabilityservice() != null)
			model.setVadisabilityservice(Integer.parseInt(entity.getVadisabilityservice().getValue()));
		model.setVadisabilityserviceamount(entity.getVadisabilityserviceamount().intValue());
		if (entity.getWorkerscomp() != null)
			model.setWorkerscomp(Integer.parseInt(entity.getWorkerscomp().getValue()));
		model.setWorkerscompamount(entity.getWorkerscompamount().floatValue());
		return model;
	}

}
