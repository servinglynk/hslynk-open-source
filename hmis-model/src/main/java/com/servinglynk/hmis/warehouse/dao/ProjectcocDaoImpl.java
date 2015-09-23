/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ProjectCoC;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Project;
import com.servinglynk.hmis.warehouse.model.staging.Projectcoc;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ProjectcocDaoImpl extends ParentDaoImpl implements ProjectcocDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	
	@Autowired
	private ParentDaoFactory factory;
	
	@Override
	public void hydrateStaging(ExportDomain domain) {
		
		List<ProjectCoC> projectCoCs = domain.getExport().getProjectCoC();
		for(ProjectCoC projectCoc : projectCoCs)
		{
			UUID id = UUID.randomUUID();
			Projectcoc projectcocModel = new Projectcoc();
			projectcocModel.setId(id);
			projectcocModel.setCoccode(projectCoc.getCoCCode());
			projectcocModel.setDateCreated(BasicDataGenerator.getLocalDate(projectCoc.getDateCreated()));
			projectcocModel.setDateUpdated(BasicDataGenerator.getLocalDate(projectCoc.getDateUpdated()));
			if(projectCoc.getProjectID()!=null && !"".equals(projectCoc.getProjectID())) {
				Project projectModel = (Project) get(Project.class, domain.getEnrollmentProjectEntryIDMap().get(projectCoc.getProjectID()));
				projectcocModel.setProjectid(projectModel);
				domain.getProjectCocMap().put(String.valueOf(projectCoc.getProjectCoCID()), id);
			}
			com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
			projectcocModel.setExport(exportEntity);
			exportEntity.addProjectcoc(projectcocModel);
			insertOrUpdate(projectcocModel);
		}
		factory.getInventoryDao().hydrateStaging(domain);
		factory.getSiteDao().hydrateStaging(domain);
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Projectcoc> projectcocs = export.getProjectcocs();
		if(projectcocs != null && !projectcocs.isEmpty()) {
			for(Projectcoc projectcoc : projectcocs) {
				if(projectcoc != null) {
					com.servinglynk.hmis.warehouse.model.live.Projectcoc target = new com.servinglynk.hmis.warehouse.model.live.Projectcoc();
					BeanUtils.copyProperties(projectcoc, target,getNonCollectionFields(target));
					insert(target);
				}
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
