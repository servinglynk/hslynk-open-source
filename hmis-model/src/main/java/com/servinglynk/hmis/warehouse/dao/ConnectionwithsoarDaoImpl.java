/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ConnectionWithSOAR;
import com.servinglynk.hmis.warehouse.model.staging.Connectionwithsoar;
import com.servinglynk.hmis.warehouse.model.staging.Exit;
import com.servinglynk.hmis.warehouse.model.staging.Export;
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
		if(connectionWithSOARList !=null && !connectionWithSOARList.isEmpty()) 
		{
			for(ConnectionWithSOAR connectionWithSOAR:connectionWithSOARList )
			{
				Connectionwithsoar connectionwithsoarModel = new Connectionwithsoar();
				connectionwithsoarModel.setId(UUID.randomUUID());
				connectionwithsoarModel.setConnectionwithsoar(BasicDataGenerator.getIntegerValue(connectionWithSOAR.getConnectionWithSOAR()));
				connectionwithsoarModel.setDateCreated(BasicDataGenerator.getLocalDate(connectionWithSOAR.getDateCreated()));
				connectionwithsoarModel.setDateUpdated(BasicDataGenerator.getLocalDate(connectionWithSOAR.getDateUpdated()));
				Exit exit = (Exit) get(Exit.class, domain.getExitMap().get(connectionWithSOAR.getExitID()));
				connectionwithsoarModel.setExitid(exit);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				connectionwithsoarModel.setExport(exportEntity);
				exportEntity.addConnectionwithsoar(connectionwithsoarModel);
				insertOrUpdate(connectionwithsoarModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Connectionwithsoar> connectionwithsoars = export.getConnectionwithsoars();
		if(connectionwithsoars != null && !connectionwithsoars.isEmpty()) {
			for(Connectionwithsoar connectionwithsoar : connectionwithsoars) {
				com.servinglynk.hmis.warehouse.model.live.Connectionwithsoar target = new com.servinglynk.hmis.warehouse.model.live.Connectionwithsoar();
				BeanUtils.copyProperties(connectionwithsoar, target,getNonCollectionFields(target));
				insert(target);
			}
		}
		
		
	}

}
