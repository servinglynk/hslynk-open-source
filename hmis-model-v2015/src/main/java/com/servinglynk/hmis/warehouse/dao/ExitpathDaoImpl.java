package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitPATH;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.v2015.Exitpath;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class ExitpathDaoImpl extends ParentDaoImpl implements ExitpathDao{

	@Override
	public void hydrateStaging(ExportDomain domain) {
		
	    com.servinglynk.hmis.warehouse.domain.Sources.Source.Export export = domain.getExport();
		List<ExitPATH> exitpath = export.getExitPATH();
		if (exitpath != null && exitpath.size() > 0) {
			for (ExitPATH exitpaths : exitpath) {
				com.servinglynk.hmis.warehouse.model.stagv2015.Exitpath exitpathModel = new com.servinglynk.hmis.warehouse.model.stagv2015.Exitpath();
				UUID exitpathUUID = UUID.randomUUID();
				exitpathModel.setId(exitpathUUID);
				exitpathModel.setConnectionWithSoar(new Integer(exitpaths.getConnectionWithSOAR()).intValue());
				com.servinglynk.hmis.warehouse.model.stagv2015.Exit exit = (com.servinglynk.hmis.warehouse.model.stagv2015.Exit) get(com.servinglynk.hmis.warehouse.model.stagv2015.Exit.class, domain.getExitMap().get(exitpaths.getExitID()));
				exitpathModel.setExitid(exit);
				exitpathModel.setDeleted(false);
				exitpathModel.setDateCreated(LocalDateTime.now());
				exitpathModel.setDateUpdated(LocalDateTime.now());
				/*Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(entryRhsps.getEntryRHSPID()));
				entryRhspModel.setEnrollmentid(enrollmentModel);*/
				com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, domain.getExportId());
				exportEntity.addExitpath(exitpathModel);
				exitpathModel.setUserId(exportEntity.getUserId());
				exitpathModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(exitpaths.getDateCreated()));
				exitpathModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exitpaths.getDateUpdated()));
				hydrateCommonFields(exitpathModel, domain);
				exitpathModel.setExport(exportEntity);
				exitpathModel.setProjectGroupCode(exitpaths.getExitID());
				exitpathModel.setSync(false);
				insertOrUpdate(exitpathModel);
			}
		}
	
	}


	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.stagv2015.Export export) {
		Set<com.servinglynk.hmis.warehouse.model.stagv2015.Exitpath> exitpath = export.getExitpaths();
		if(exitpath !=null && !exitpath.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.stagv2015.Exitpath exitpaths : exitpath) {
				com.servinglynk.hmis.warehouse.model.v2015.Exitpath exitpathByDedupCliendId = getExitpathByDedupExitpathId(exitpaths.getId(),exitpaths.getProjectGroupCode());
				if(exitpathByDedupCliendId ==null) {
					com.servinglynk.hmis.warehouse.model.v2015.Exitpath target = new com.servinglynk.hmis.warehouse.model.v2015.Exitpath();
					BeanUtils.copyProperties(exitpaths, target, new String[] {"enrollments","veteranInfoes"});
					com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, export.getId());
					exportEntity.addExitpath(target);
					target.setExport(exportEntity);
					insertOrUpdate(target);
				}
			}
		}
	}
	
	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.stagv2015.Exitpath exitpath) {
			if(exitpath !=null) {
				com.servinglynk.hmis.warehouse.model.v2015.Exitpath target = new com.servinglynk.hmis.warehouse.model.v2015.Exitpath();
				BeanUtils.copyProperties(exitpath, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, exitpath.getExport().getId());
				exportEntity.addExitpath(target);
				target.setExport(exportEntity);
				com.servinglynk.hmis.warehouse.model.v2015.Exitpath exitpathByDedupCliendId = getExitpathByDedupExitpathId(exitpath.getId(),exitpath.getProjectGroupCode());
				if(exitpathByDedupCliendId ==null) {
					insert(target);	
				}
			}
	}
	
	
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void performSave(Iface coc, Object entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected List performGet(Iface coc, Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exitpath createExitpath(Exitpath exitpath) {
		exitpath.setId(UUID.randomUUID());
			insert(exitpath);
		return exitpath;
	}


	@Override
	public Exitpath updateExitpath(com.servinglynk.hmis.warehouse.model.v2015.Exitpath exitpath) {
			update(exitpath);
		return exitpath;
	}


	@Override
	public void deleteExitpath(com.servinglynk.hmis.warehouse.model.v2015.Exitpath exitpath) {
			delete(exitpath);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Exitpath getExitpathById(UUID exitpathId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exitpath.class);
		criteria.add(Restrictions.eq("id", exitpathId));
		List<com.servinglynk.hmis.warehouse.model.v2015.Exitpath> exitpath = (List<com.servinglynk.hmis.warehouse.model.v2015.Exitpath>) findByCriteria(criteria);
		if(exitpath.size()>0) return exitpath.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Exitpath getExitpathByDedupExitpathId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exitpath.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2015.Exitpath> exitpath = (List<com.servinglynk.hmis.warehouse.model.v2015.Exitpath>) findByCriteria(criteria);
		if(exitpath !=null && exitpath.size()>0) return exitpath.get(0);
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
	public List<com.servinglynk.hmis.warehouse.model.v2015.Exitpath> getAllExitpath(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exitpath.class);	
		List<com.servinglynk.hmis.warehouse.model.v2015.Exitpath> exitpath = (List<com.servinglynk.hmis.warehouse.model.v2015.Exitpath>) findByCriteria(criteria,startIndex,maxItems);
		return exitpath;
	}
	
	
	public long getExitpathCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exitpath.class);	
		return countRows(criteria);
	}

}
