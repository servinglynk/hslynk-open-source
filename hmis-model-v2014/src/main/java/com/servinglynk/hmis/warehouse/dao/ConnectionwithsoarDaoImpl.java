/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ConnectionWithSOAR;
import com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar;
import com.servinglynk.hmis.warehouse.model.v2014.Exit;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ConnectionwithsoarDaoImpl extends ParentDaoImpl implements
		ConnectionwithsoarDao {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ConnectionwithsoarDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		java.util.List<ConnectionWithSOAR> connectionWithSOARList = domain.getExport().getConnectionWithSOAR();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap);
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar.class, getProjectGroupCode(domain));
		if(connectionWithSOARList !=null && !connectionWithSOARList.isEmpty()) 
		{
			for(ConnectionWithSOAR connectionWithSOAR:connectionWithSOARList )
			{
				try {
					Connectionwithsoar connectionwithsoarModel = getModelObject(domain, connectionWithSOAR,data,modelMap);
					connectionwithsoarModel.setConnectionwithsoar(BasicDataGenerator.getIntegerValue(connectionWithSOAR.getConnectionWithSOAR()));
					connectionwithsoarModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(connectionWithSOAR.getDateCreated()));
					connectionwithsoarModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(connectionWithSOAR.getDateUpdated()));
					Exit exit = (Exit) getModel(Exit.class, connectionWithSOAR.getExitID(), getProjectGroupCode(domain),true,relatedModelMap);
					connectionwithsoarModel.setExitid(exit);
					connectionwithsoarModel.setExport(exportEntity);
					performSaveOrUpdate(connectionwithsoarModel);
				} catch(Exception e) {
					logger.error("Exception in:"+connectionWithSOAR.getConnectionWithSOARID()+ ":: Exception" +e.getLocalizedMessage());
					throw new Exception(e);
				}
				
			}
		}
		hydrateBulkUploadActivityStaging(data.i, data.j, Connectionwithsoar.class.getSimpleName(), domain, exportEntity);
	}
	public  com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar getModelObject(ExportDomain domain, ConnectionWithSOAR connectionWithSOAR ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar connectionwithsoarModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			connectionwithsoarModel = (com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar) getModel(com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar.class, connectionWithSOAR.getConnectionWithSOARID(), getProjectGroupCode(domain),false,modelMap);
		
		if(connectionwithsoarModel == null) {
			connectionwithsoarModel = new com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar();
			connectionwithsoarModel.setId(UUID.randomUUID());
			connectionwithsoarModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(connectionwithsoarModel, domain,connectionWithSOAR.getConnectionWithSOARID(),data.i+data.j);
		return connectionwithsoarModel;
	}
	

	   public com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar createConnectionwithsoar(com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar connectionwithsoar){
	       connectionwithsoar.setId(UUID.randomUUID()); 
	       insert(connectionwithsoar);
	       return connectionwithsoar;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar updateConnectionwithsoar(com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar connectionwithsoar){
	       update(connectionwithsoar);
	       return connectionwithsoar;
	   }
	   public void deleteConnectionwithsoar(com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar connectionwithsoar){
	       delete(connectionwithsoar);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar getConnectionwithsoarById(UUID connectionwithsoarId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar) get(com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar.class, connectionwithsoarId);
	   }
	   
	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar> getAllExitConnectionwithsoars(UUID exitId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getExitConnectionwithsoarsCount(UUID exitId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return countRows(criteria);
	   }
}
