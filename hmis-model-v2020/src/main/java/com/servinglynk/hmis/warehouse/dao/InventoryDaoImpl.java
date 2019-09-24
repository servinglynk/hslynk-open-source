/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.InventoryAvailabiltyEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryBedtypeEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryHouseholdtypeEnum;
import com.servinglynk.hmis.warehouse.model.v2020.Coc;
import com.servinglynk.hmis.warehouse.model.v2020.Error2017;
import com.servinglynk.hmis.warehouse.model.v2020.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2020.Project;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class InventoryDaoImpl extends ParentDaoImpl implements InventoryDao {
	private static final Logger logger = LoggerFactory
			.getLogger(InventoryDaoImpl.class);
	@Autowired
	ParentDaoFactory parentDaoFactory;

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	/*@Autowired
	private ParentDaoFactory parentDaoFactory;*/

	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		
	    com.servinglynk.hmis.warehouse.domain.Sources.Source.Export export = domain.getExport();
	    com.servinglynk.hmis.warehouse.model.v2020.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2020.Export) getModel(com.servinglynk.hmis.warehouse.model.v2020.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Inventory.class, getProjectGroupCode(domain));
		Map<String,HmisBaseModel> projectModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Project.class, getProjectGroupCode(domain));
		
		List<Inventory> inventories = export.getInventory();
		if (inventories != null && inventories.size() > 0) {
			for (Inventory inventory : inventories) {
				com.servinglynk.hmis.warehouse.model.v2020.Inventory inventoryModel = null;
				try {
					inventoryModel = getModelObject(domain, inventory,data,modelMap);
					inventoryModel.setAvailabilty(InventoryAvailabiltyEnum.lookupEnum((inventory.getAvailability())));
					inventoryModel.setBedtype(InventoryBedtypeEnum.lookupEnum((inventory.getBedType())));
					inventoryModel.setChBedInventory(inventory.getChBedInventory());
					inventoryModel.setHmisparticipatingbeds(inventory.getHMISParticipatingBeds() );
					inventoryModel.setHouseholdtype(InventoryHouseholdtypeEnum.lookupEnum((inventory.getHouseholdType())));
					inventoryModel.setInformationdate(BasicDataGenerator.getLocalDateTime(inventory.getInformationDate()));
					inventoryModel.setInventoryenddate(BasicDataGenerator.getLocalDateTime(inventory.getInventoryEndDate()));
					inventoryModel.setInventorystartdate(BasicDataGenerator.getLocalDateTime(inventory.getInventoryStartDate()));
					inventoryModel.setUnitinventory(inventory.getUnitInventory());
					inventoryModel.setVetBedInventory(inventory.getVetBedInventory());
					inventoryModel.setYouthBedInventory(inventory.getYouthBedInventory());
					inventoryModel.setDeleted(false);
					/*Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(entryRhsps.getEntryRHSPID()));
				entryRhspModel.setEnrollmentid(enrollmentModel);*/
					inventoryModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(inventory.getDateCreated()));
					inventoryModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(inventory.getDateUpdated()));
					inventoryModel.setExport(exportEntity);
					inventoryModel.setSync(false);
					Coc coc = (Coc) getModel(Coc.class,inventory.getCoCCode(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					inventoryModel.setCoc(coc);
					Project project = (Project) getModel(Project.class,inventory.getProjectID(),getProjectGroupCode(domain),true,projectModelMap, domain.getUpload().getId());
					inventoryModel.setProjectid(project);
					performSaveOrUpdate(inventoryModel,domain);
				} catch(Exception e) {
					String errorMessage = "Exception beause of the inventory::"+inventory.getInventoryID() +" Exception ::"+e.getMessage();
					if(inventoryModel != null){
						Error2017 error = new Error2017();
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
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2020.Inventory.class.getSimpleName(), domain,exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2020.Inventory getModelObject(ExportDomain domain, Inventory inventory ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2020.Inventory modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2020.Inventory) getModel(com.servinglynk.hmis.warehouse.model.v2020.Inventory.class, inventory.getInventoryID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(domain.isReUpload()) {
			if(modelFromDB != null) {
				return modelFromDB;
			}
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.Inventory();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			return modelFromDB;
		}
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.Inventory();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2020.Inventory model = new com.servinglynk.hmis.warehouse.model.v2020.Inventory();
		// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(inventory.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,inventory.getInventoryID(),data);
		return model;
	}
	
	
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public com.servinglynk.hmis.warehouse.model.v2020.Inventory createInventory(com.servinglynk.hmis.warehouse.model.v2020.Inventory inventory) {
		inventory.setId(UUID.randomUUID());
			insert(inventory);
		return inventory;
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.v2020.Inventory updateInventory(com.servinglynk.hmis.warehouse.model.v2020.Inventory inventory) {
			update(inventory);
		return inventory;
	}


	@Override
	public void deleteInventory(com.servinglynk.hmis.warehouse.model.v2020.Inventory inventory) {
			delete(inventory);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2020.Inventory getInventoryById(UUID inventoryId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Inventory.class);
		criteria.add(Restrictions.eq("id", inventoryId));
		List<com.servinglynk.hmis.warehouse.model.v2020.Inventory> inventory = (List<com.servinglynk.hmis.warehouse.model.v2020.Inventory>) findByCriteria(criteria);
		if(inventory.size()>0) return inventory.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2020.Inventory getInventoryByDedupInventoryId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Inventory.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2020.Inventory> inventory = (List<com.servinglynk.hmis.warehouse.model.v2020.Inventory>) findByCriteria(criteria);
		if(inventory !=null && inventory.size()>0) return inventory.get(0);
		return null;
	}
	/*public com.servinglynk.hmis.warehouse.model.stagv2015.Coc getCocByDedupCliendIdFromStaging(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.stagv2015.Coc.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.stagv2015.Coc> coc = (List<com.servinglynk.hmis.warehouse.model.stagv2015.Coc>) findByCriteria(criteria);
		if(coc !=null && coc.size()>0) return coc.get(0);
		return null;
	}*/

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2020.Inventory> getAllInventories(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Inventory.class);	
		List<com.servinglynk.hmis.warehouse.model.v2020.Inventory> inventory = (List<com.servinglynk.hmis.warehouse.model.v2020.Inventory>) findByCriteria(criteria,startIndex,maxItems);
		return inventory;
	}
	
	@Override
	public long getIventoriesCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Exitrhy.class);	
		return countRows(criteria);
	}


	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2020.Inventory> getAllCocInventories(UUID projectCocId,
			Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Inventory.class);
	       criteria.createAlias("coc", "coc");
	       criteria.add(Restrictions.eq("coc.id", projectCocId));
	       List<com.servinglynk.hmis.warehouse.model.v2020.Inventory> inventories = (List<com.servinglynk.hmis.warehouse.model.v2020.Inventory>) findByCriteria(criteria,startIndex,maxItems);
	       if(inventories.size()>0) return inventories;
	       else return new ArrayList<com.servinglynk.hmis.warehouse.model.v2020.Inventory>(); 
	}


	@Override
	public long getCocInventoriesCount(UUID projectCocId) {
		 DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Inventory.class);
	       criteria.createAlias("coc", "coc");
	       criteria.add(Restrictions.eq("coc.id", projectCocId));
	       return countRows(criteria);
	}
}
