/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ConnectionWithSOAR;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
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
				connectionwithsoarModel.setDateCreated(BasicDataGenerator.getLocalDateTime(connectionWithSOAR.getDateCreated()));
				connectionwithsoarModel.setDateUpdated(BasicDataGenerator.getLocalDateTime(connectionWithSOAR.getDateUpdated()));
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
				com.servinglynk.hmis.warehouse.model.live.Exit exitModel = (com.servinglynk.hmis.warehouse.model.live.Exit) get(com.servinglynk.hmis.warehouse.model.live.Exit.class, connectionwithsoar.getExitid().getId());
				target.setExitid(exitModel);
				com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, export.getId());
				target.setExport(exportEntity);
				exportEntity.addConnectionwithsoar(target);
				target.setDateCreated(LocalDateTime.now());
				target.setDateUpdated(LocalDateTime.now());
				insertOrUpdate(target);
			}
		}
		
		
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void performSave(Iface client, Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List performGet(Iface client, Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
