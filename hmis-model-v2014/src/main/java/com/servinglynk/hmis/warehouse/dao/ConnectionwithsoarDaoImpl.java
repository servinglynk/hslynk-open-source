/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ConnectionWithSOAR;
import com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar;
import com.servinglynk.hmis.warehouse.model.v2014.Exit;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ConnectionwithsoarDaoImpl extends ParentDaoImpl implements
		ConnectionwithsoarDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		java.util.List<ConnectionWithSOAR> connectionWithSOARList = domain.getExport().getConnectionWithSOAR();
		hydrateBulkUploadActivityStaging(connectionWithSOARList, com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar.class.getSimpleName(), domain);
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		if(connectionWithSOARList !=null && !connectionWithSOARList.isEmpty()) 
		{
			int i=0;
			for(ConnectionWithSOAR connectionWithSOAR:connectionWithSOARList )
			{
				Connectionwithsoar connectionwithsoarModel = new Connectionwithsoar();
				connectionwithsoarModel.setId(UUID.randomUUID());
				connectionwithsoarModel.setConnectionwithsoar(BasicDataGenerator.getIntegerValue(connectionWithSOAR.getConnectionWithSOAR()));
				connectionwithsoarModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(connectionWithSOAR.getDateCreated()));
				connectionwithsoarModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(connectionWithSOAR.getDateUpdated()));
				Exit exit = (Exit) get(Exit.class, domain.getExitMap().get(connectionWithSOAR.getExitID()));
				connectionwithsoarModel.setExitid(exit);
				connectionwithsoarModel.setExport(exportEntity);
				exportEntity.addConnectionwithsoar(connectionwithsoarModel);
				connectionwithsoarModel.setDateCreated(LocalDateTime.now());
				connectionwithsoarModel.setDateUpdated(LocalDateTime.now());
				i++;
				hydrateCommonFields(connectionwithsoarModel, domain, connectionWithSOAR.getConnectionWithSOARID(),i);
			}
		}
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
