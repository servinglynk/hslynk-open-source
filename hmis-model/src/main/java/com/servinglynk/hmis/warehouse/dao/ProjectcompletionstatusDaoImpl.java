/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ProjectCompletionStatus;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusEarlyexitreasonEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusProjectcompletionstatusEnum;
import com.servinglynk.hmis.warehouse.model.staging.Exit;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Projectcompletionstatus;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ProjectcompletionstatusDaoImpl extends ParentDaoImpl implements
		ProjectcompletionstatusDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<ProjectCompletionStatus> projectCompletionStatusList = domain.getExport().getProjectCompletionStatus();
		if(projectCompletionStatusList !=null && !projectCompletionStatusList.isEmpty()) 
		{
			for(ProjectCompletionStatus projectCompletionStatus : projectCompletionStatusList)
			{
				Projectcompletionstatus projectcompletionstatusModel = new Projectcompletionstatus();
				projectcompletionstatusModel.setId(UUID.randomUUID());
				projectcompletionstatusModel.setEarlyexitreason(ProjectcompletionstatusEarlyexitreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(projectCompletionStatus.getEarlyExitReason())));
				projectcompletionstatusModel.setProjectcompletionstatus(ProjectcompletionstatusProjectcompletionstatusEnum.lookupEnum(BasicDataGenerator.getStringValue(projectCompletionStatus.getProjectCompletionStatus())));
				projectcompletionstatusModel.setDateCreated(BasicDataGenerator.getLocalDate(projectCompletionStatus.getDateCreated()));
				projectcompletionstatusModel.setDateUpdated(BasicDataGenerator.getLocalDate(projectCompletionStatus.getDateUpdated()));
				Exit exit = (Exit) get(Exit.class, domain.getExitMap().get(projectCompletionStatus.getExitID()));
				projectcompletionstatusModel.setExitid(exit);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				projectcompletionstatusModel.setExport(exportEntity);
				exportEntity.addProjectcompletionstatus(projectcompletionstatusModel);
				insertOrUpdate(projectcompletionstatusModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Projectcompletionstatus> projectcompletionstatuses = export.getProjectcompletionstatuses();
		if(projectcompletionstatuses != null && !projectcompletionstatuses.isEmpty()) {
			for(Projectcompletionstatus projectcompletionstatus : projectcompletionstatuses) {
				if(projectcompletionstatus != null) {
					com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus target = new com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus();
					BeanUtils.copyProperties(projectcompletionstatus, target,getNonCollectionFields(target));
					insert(target);
				}
			}
		}
	}

}
