package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.BaseCSV;
import com.servinglynk.hmis.warehouse.csv.Inventory;

@Component
public class InventoryCsvConverter extends BaseCsvConverter {

	public Inventory entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.Inventory entity) {
		Inventory model = new Inventory();

		model.setInventoryID(getId(entity.getId()));
		if (entity.getAvailabilty() != null)
			model.setAvailability(entity.getAvailabilty().getValue());
		if (entity.getBedtype() != null)
			model.setBedType(entity.getBedtype().getValue());
		if (entity.getHouseholdtype() != null)
			model.setHouseholdType(entity.getHouseholdtype().getValue());
		if (entity.getInventoryenddate() != null)
			model.setInventoryEndDate(getDate(entity.getInventoryenddate()));
		if (entity.getInventorystartdate() != null)
			model.setInventoryStartDate(getDate(entity.getInventorystartdate()));
		if (entity.getUnitinventory() != null)
			model.setUnitInventory(String.valueOf(entity.getUnitinventory()));
		/*
		 * if(entity.getBedinventory()!=null)
		 * model.setBedinventory(entity.getBedinventory());
		 */
		if (entity.getChBedInventory() != null)
			model.setCHBedInventory(String.valueOf(entity.getChBedInventory()));
		if (entity.getYouthBedInventory() != null)
			model.setYouthBedInventory(String.valueOf(entity.getYouthBedInventory()));
		if (entity.getVetBedInventory() != null)
			model.setVetBedInventory(String.valueOf(entity.getVetBedInventory()));
		if (entity.getCoccode() != null)
			model.setCoCCode(entity.getCoccode());
		
//		if (entity.getInformationdate() != null)
//			model.se(entity.getInformationdate());

		if (entity.getUserId() != null)
			model.setUserID(entity.getUserId().toString());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if (entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());

		return model;
	}

	public void writeToCSV(Set<com.servinglynk.hmis.warehouse.model.v2020.Inventory> Inventorys, boolean fillHeaders) {
		List<BaseCSV> baseCSVs = null;
		if (fillHeaders) {
			baseCSVs = getBaseCSVs(new Inventory());
		} else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		try {

			if (CollectionUtils.isNotEmpty(Inventorys)) {
				for (com.servinglynk.hmis.warehouse.model.v2020.Inventory Inventory : Inventorys) {
					baseCSVs.add(entityToCsv(Inventory));
				}
			}
			CsvFileWriter.writeToCsv("Inventory.csv", baseCSVs);
			fillHeaders = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

}
