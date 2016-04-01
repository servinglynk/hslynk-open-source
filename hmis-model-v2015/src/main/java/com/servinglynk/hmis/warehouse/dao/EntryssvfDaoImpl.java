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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EntrySSVF;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.stagv2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.Entryssvf;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class EntryssvfDaoImpl extends ParentDaoImpl implements EntryssvfDao{

	@Override
	public void hydrateStaging(ExportDomain domain) {
		
	    com.servinglynk.hmis.warehouse.domain.Sources.Source.Export export = domain.getExport();
		List<EntrySSVF> entrySSVFs = export.getEntrySSVF();
		if (entrySSVFs != null && entrySSVFs.size() > 0) {
			for (EntrySSVF entrySSVF : entrySSVFs) {
				com.servinglynk.hmis.warehouse.model.stagv2015.Entryssvf entrySsvfModel = new com.servinglynk.hmis.warehouse.model.stagv2015.Entryssvf();
				UUID entrySSVFUUID = UUID.randomUUID();
				entrySsvfModel.setId(entrySSVFUUID);
				entrySsvfModel.setAddressDataQuality(new Integer(entrySSVF.getAddressDataQuality()).intValue());
				entrySsvfModel.setDeleted(false);
				entrySsvfModel.setHpScreeningScore(new Integer(entrySSVF.getHPScreeningScore()).intValue());
				entrySsvfModel.setLastPermanentCity(entrySSVF.getLastPermanentCity());
				entrySsvfModel.setLastPermanentState(entrySSVF.getLastPermanentState());
				entrySsvfModel.setLastPermanentStreet(entrySSVF.getLastPermanentStreet());
				entrySsvfModel.setLastPermanentZip(new Integer(entrySSVF.getLastPermanentZIP()).toString());
				entrySsvfModel.setPercentami(new Integer(entrySSVF.getPercentAMI()).intValue());
				entrySsvfModel.setDateCreated(LocalDateTime.now());
				entrySsvfModel.setDateUpdated(LocalDateTime.now());
				entrySsvfModel.setVamcStation(entrySSVF.getVAMCStation());
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(entrySSVF.getProjectEntryID()));
				entrySsvfModel.setEnrollmentid(enrollmentModel);
				com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, domain.getExportId());
				exportEntity.addEntryssvf(entrySsvfModel);
				entrySsvfModel.setUserId(exportEntity.getUserId());
				entrySsvfModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(entrySSVF.getDateCreated()));
				entrySsvfModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(entrySSVF.getDateUpdated()));
				hydrateCommonFields(entrySsvfModel, domain);
				entrySsvfModel.setExport(exportEntity);
				entrySsvfModel.setProjectGroupCode(entrySSVF.getProjectEntryID());
				entrySsvfModel.setSync(false);
				insertOrUpdate(entrySsvfModel);
			}
	}
	
	}


	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.stagv2015.Export export) {
		Set<com.servinglynk.hmis.warehouse.model.stagv2015.Entryssvf> entrySsvf = export.getEntryssvfs();
		if(entrySsvf !=null && !entrySsvf.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.stagv2015.Entryssvf entrySsvfs : entrySsvf) {
				com.servinglynk.hmis.warehouse.model.v2015.Entryssvf entryssvfByDedupCliendId = getEntryssvfByDedupEntryssvfId(entrySsvfs.getId(),entrySsvfs.getProjectGroupCode());
				if(entryssvfByDedupCliendId ==null) {
					com.servinglynk.hmis.warehouse.model.v2015.Entryssvf target = new com.servinglynk.hmis.warehouse.model.v2015.Entryssvf();
					BeanUtils.copyProperties(entrySsvfs, target, new String[] {"enrollments","veteranInfoes"});
					com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, export.getId());
					exportEntity.addEntryssvf(target);
					target.setExport(exportEntity);
					insertOrUpdate(target);
				}
			}
		}
	}
	
	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.stagv2015.Entryssvf entrySsvf) {
			if(entrySsvf !=null) {
				com.servinglynk.hmis.warehouse.model.v2015.Entryssvf target = new com.servinglynk.hmis.warehouse.model.v2015.Entryssvf();
				BeanUtils.copyProperties(entrySsvf, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, entrySsvf.getExport().getId());
				exportEntity.addEntryssvf(target);
				target.setExport(exportEntity);
				com.servinglynk.hmis.warehouse.model.v2015.Entryssvf entryssvfByDedupCliendId = getEntryssvfByDedupEntryssvfId(entrySsvf.getId(),entrySsvf.getProjectGroupCode());
				if(entryssvfByDedupCliendId ==null) {
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
	public Entryssvf createEntryssvf(Entryssvf entryssvf) {
		entryssvf.setId(UUID.randomUUID());
			insert(entryssvf);
		return entryssvf;
	}


	@Override
	public Entryssvf updateEntryssvf(com.servinglynk.hmis.warehouse.model.v2015.Entryssvf entryssvf) {
			update(entryssvf);
		return entryssvf;
	}


	@Override
	public void deleteEntryssvf(com.servinglynk.hmis.warehouse.model.v2015.Entryssvf entryssvf) {
			delete(entryssvf);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Entryssvf getEntryssvfById(UUID entrySsvfId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryssvf.class);
		criteria.add(Restrictions.eq("id", entrySsvfId));
		List<com.servinglynk.hmis.warehouse.model.v2015.Entryssvf> entrySsvf = (List<com.servinglynk.hmis.warehouse.model.v2015.Entryssvf>) findByCriteria(criteria);
		if(entrySsvf.size()>0) return entrySsvf.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Entryssvf getEntryssvfByDedupEntryssvfId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryssvf.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2015.Entryssvf> entryssvf = (List<com.servinglynk.hmis.warehouse.model.v2015.Entryssvf>) findByCriteria(criteria);
		if(entryssvf !=null && entryssvf.size()>0) return entryssvf.get(0);
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
	public List<com.servinglynk.hmis.warehouse.model.v2015.Entryssvf> getAllEntryssvf(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryssvf.class);	
		List<com.servinglynk.hmis.warehouse.model.v2015.Entryssvf> entryssvf = (List<com.servinglynk.hmis.warehouse.model.v2015.Entryssvf>) findByCriteria(criteria,startIndex,maxItems);
		return entryssvf;
	}
	
	
	public long getEntryssvfCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryssvf.class);	
		return countRows(criteria);
	}

}
