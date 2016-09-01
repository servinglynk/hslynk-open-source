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
				com.servinglynk.hmis.warehouse.model.v2014.Inventory inventoryModel = null;
				try {
					inventoryModel = getModelObject(domain, inventory,data,modelMap);
					inventoryModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(inventory.getDateCreated()));
					inventoryModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(inventory.getDateUpdated()));
					inventoryModel.setAvailabilty(InventoryAvailabiltyEnum.lookupEnum(BasicDataGenerator.getStringValue(inventory.getAvailabilty())));
					inventoryModel.setBedtype(InventoryBedtypeEnum.lookupEnum(BasicDataGenerator.getStringValue(inventory.getBedType())));
					inventoryModel.setUnitinventory(inventory.getUnitInventory());
					inventoryModel.setHouseholdtype(InventoryHouseholdtypeEnum.lookupEnum(BasicDataGenerator.getStringValue(inventory.getHouseholdType())));
					inventoryModel.setHmisparticipatingbeds(inventory.getHMISParticipatingBeds());
					inventoryModel.setInventoryenddate(BasicDataGenerator.getLocalDateTime(inventory.getInventoryEndDate()));
					inventoryModel.setInventorystartdate(BasicDataGenerator.getLocalDateTime(inventory.getInventoryStartDate()));
					BedInventory bedInventory = inventory.getBedInventory();
					if(bedInventory !=null) {
						inventoryModel.setBedInventory(new Integer(bedInventory.getBedInventory()));
						inventoryModel.setChBedInventory(new Integer(bedInventory.getCHBedInventory()));
						inventoryModel.setVetBedInventory(new Integer(bedInventory.getVetBedInventory()));
						inventoryModel.setYouthAgeGroup(BedinventoryYouthAgeGroupEnum.lookupEnum(BasicDataGenerator.getStringValue(bedInventory.getYouthAgeGroup())));
						inventoryModel.setYouthBedInventory(new Long(bedInventory.getYouthBedInventory()));
					}
					Projectcoc projectCocModel = (Projectcoc) getModel(com.servinglynk.hmis.warehouse.model.v2014.Inventory.class.getSimpleName(),Projectcoc.class,inventory.getProjectCoCID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					inventoryModel.setProjectCoc(projectCocModel);
					inventoryModel.setExport(exportEntity);
					inventoryModel.setInformationDate(BasicDataGenerator.getLocalDateTime(inventory.getInformationDate()));
					inventoryModel.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(BasicDataGenerator.getStringValue(inventory.getDataCollectionStage())));
					performSaveOrUpdate(inventoryModel);
				}catch(Exception e) {
					String errorMessage = "Failure in Inventory:::"+inventory.toString()+ " with exception"+e.getLocalizedMessage();
					if (inventoryModel != null) {
						Error2014 error = new Error2014();
						error.model_id = inventoryModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = inventoryModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = inventoryModel.getDateCreated();
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
			inventoryModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
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
