/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Funder;
import com.servinglynk.hmis.warehouse.enums.FunderFunderEnum;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Project;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class FunderDaoImpl extends ParentDaoImpl implements FunderDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<Funder> funders = domain.getExport().getFunder();
		if(funders!=null && funders.size() > 0)
		{
			for(Funder funder : funders)
			{
				com.servinglynk.hmis.warehouse.model.staging.Funder funderModel = new com.servinglynk.hmis.warehouse.model.staging.Funder();
				UUID id = UUID.randomUUID();
				funderModel.setId(id);
				funderModel.setFunder(FunderFunderEnum.lookupEnum(BasicDataGenerator.getStringValue(funder.getFunder())));
				//funderModel.setGrantid(under.getGrantID());
				funderModel.setStartdate(BasicDataGenerator.getLocalDate(funder.getStartDate()));
				funderModel.setEnddate(BasicDataGenerator.getLocalDate(funder.getEndDate()));
				funderModel.setDateCreated(BasicDataGenerator.getLocalDate(funder.getDateCreated()));
				funderModel.setDateUpdated(BasicDataGenerator.getLocalDate(funder.getDateUpdated()));
				Project project = (Project) get(Project.class,domain.getAffiliationProjectMap().get(funder.getProjectID()));
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				funderModel.setExport(exportEntity);
				funderModel.setProjectid(project);
				exportEntity.addFunder(funderModel);
				insertOrUpdate(funderModel);
			}
		}

	}

	@Override
	public void hydrateLive(Export export) {
		Set<com.servinglynk.hmis.warehouse.model.staging.Funder> funders = export.getFunders();
		if(funders !=null && !funders.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.staging.Funder funder : funders) {
				if(funder != null) {
					com.servinglynk.hmis.warehouse.model.live.Funder target = new com.servinglynk.hmis.warehouse.model.live.Funder();
					BeanUtils.copyProperties(funder, target,getNonCollectionFields(target));
					insert(target);
				}
			}
		}
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

	@Override
	public void hydrateHBASE(SyncDomain domain) {
		/**
		 * Get the Last Synced record from the Sync table.
		 * Then fetch data between last sync date time and between the time Sync Began.
		 */
	}

}
