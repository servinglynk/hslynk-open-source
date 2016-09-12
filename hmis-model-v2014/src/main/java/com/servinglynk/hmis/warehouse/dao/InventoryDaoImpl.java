/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory.BedInventory;
import com.servinglynk.hmis.warehouse.enums.BedinventoryYouthAgeGroupEnum;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryAvailabiltyEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryBedtypeEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryHouseholdtypeEnum;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Projectcoc;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class InventoryDaoImpl extends ParentDaoImpl implements InventoryDao {

	private static final Logger logger = LoggerFactory
			.getLogger(InventoryDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Autowired
	private ParentDaoFactory parentDaoFactory;
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<Inventory> inventories = domain.getExport().getInventory();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Inventory.class, getProjectGroupCode(domain));
		Long i=new Long(0L);
		Data data =new Data();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Inventory.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(inventories != null && !inventories.isEmpty())
		{
			for(Inventory inventory : inventories)
			{
				com.servinglynk.hmis.warehouse.model.v2014.Inventory model = null;
				try {
					model = getModelObject(domain, inventory,data,modelMap);
					model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(inventory.getDateCreated()));
					model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(inventory.getDateUpdated()));
					model.setAvailabilty(InventoryAvailabiltyEnum.lookupEnum(BasicDataGenerator.getStringValue(inventory.getAvailabilty())));
					model.setBedtype(InventoryBedtypeEnum.lookupEnum(BasicDataGenerator.getStringValue(inventory.getBedType())));
					model.setUnitinventory(inventory.getUnitInventory());
					model.setHouseholdtype(InventoryHouseholdtypeEnum.lookupEnum(BasicDataGenerator.getStringValue(inventory.getHouseholdType())));
					model.setHmisparticipatingbeds(inventory.getHMISParticipatingBeds());
					model.setInventoryenddate(BasicDataGenerator.getLocalDateTime(inventory.getInventoryEndDate()));
					model.setInventorystartdate(BasicDataGenerator.getLocalDateTime(inventory.getInventoryStartDate()));
					BedInventory bedInventory = inventory.getBedInventory();
					if(bedInventory !=null) {
						model.setBedInventory(new Integer(bedInventory.getBedInventory()));
						model.setChBedInventory(new Integer(bedInventory.getCHBedInventory()));
						model.setVetBedInventory(new Integer(bedInventory.getVetBedInventory()));
						model.setYouthAgeGroup(BedinventoryYouthAgeGroupEnum.lookupEnum(BasicDataGenerator.getStringValue(bedInventory.getYouthAgeGroup())));
						model.setYouthBedInventory(new Long(bedInventory.getYouthBedInventory()));
					}
					Projectcoc projectCocModel = (Projectcoc) getModel(com.servinglynk.hmis.warehouse.model.v2014.Inventory.class.getSimpleName(),Projectcoc.class,inventory.getProjectCoCID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					model.setProjectCoc(projectCocModel);
					model.setExport(exportEntity);
					model.setInformationDate(BasicDataGenerator.getLocalDateTime(inventory.getInformationDate()));
					model.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(BasicDataGenerator.getStringValue(inventory.getDataCollectionStage())));
					if(!isFullRefresh(domain)) {
						HmisBaseModel hmisBaseModel = modelMap.get(model.getSourceSystemId());
						if(hmisBaseModel !=null) {
							modelMatch(hmisBaseModel, model);
						}	
						if(!model.isRecordToBoInserted() && !model.isIgnored()) {
							++data.j;
						}
					}
					performSaveOrUpdate(model);
				}catch(Exception e) {
					String errorMessage = "Failure in Inventory:::"+inventory.toString()+ " with exception"+e.getLocalizedMessage();
					if (model != null) {
						Error2014 error = new Error2014();
						error.model_id = model.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = model.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = model.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Inventory.class.getSimpleName(), domain,exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Inventory getModelObject(ExportDomain domain,Inventory inventory ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Inventory inventoryModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			inventoryModel = (com.servinglynk.hmis.warehouse.model.v2014.Inventory) getModel(com.servinglynk.hmis.warehouse.model.v2014.Inventory.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Inventory.class, inventory.getInventoryID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(inventoryModel == null) {
			inventoryModel = new com.servinglynk.hmis.warehouse.model.v2014.Inventory();
			inventoryModel.setId(UUID.randomUUID());
			inventoryModel.setRecordToBeInserted(true);
			++data.i;
		}
		hydrateCommonFields(inventoryModel, domain,inventory.getInventoryID(),data.i+data.j);
		return inventoryModel;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Inventory createInventory(com.servinglynk.hmis.warehouse.model.v2014.Inventory inventory){
	       inventory.setId(UUID.randomUUID()); 
	       insert(inventory);
	       return inventory;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Inventory updateInventory(com.servinglynk.hmis.warehouse.model.v2014.Inventory inventory){
	       update(inventory);
	       return inventory;
	   }
	   public void deleteInventory(com.servinglynk.hmis.warehouse.model.v2014.Inventory inventory){
	       delete(inventory);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Inventory getInventoryById(UUID inventoryId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Inventory) get(com.servinglynk.hmis.warehouse.model.v2014.Inventory.class, inventoryId);
	   }																
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Inventory> getAllProjectCocInventories(UUID projectCocId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Inventory.class);
	       criteria.createAlias("projectCoc", "projectCoc");
	       criteria.add(Restrictions.eq("projectCoc.id", projectCocId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Inventory>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectCocInventoriesCount(UUID projectCocId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Inventory.class);
	       criteria.createAlias("projectCoc", "projectCoc");
	       criteria.add(Restrictions.eq("projectCoc.id", projectCocId));
	       return countRows(criteria);
	   }

}
