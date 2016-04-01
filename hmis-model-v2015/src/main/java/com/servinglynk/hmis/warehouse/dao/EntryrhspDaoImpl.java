package com.servinglynk.hmis.warehouse.dao;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EntryRHSP;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.stagv2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class EntryrhspDaoImpl extends ParentDaoImpl implements EntryrhspDao{

	@Override
	public void hydrateStaging(ExportDomain domain) {
		
	    com.servinglynk.hmis.warehouse.domain.Sources.Source.Export export = domain.getExport();
		List<EntryRHSP> entryRhsps = export.getEntryRHSP();
		if (entryRhsps != null && entryRhsps.size() > 0) {
			for (EntryRHSP entryRhsp : entryRhsps) {
				com.servinglynk.hmis.warehouse.model.stagv2015.Entryrhsp entryRhspModel = new com.servinglynk.hmis.warehouse.model.stagv2015.Entryrhsp();
				UUID entryRhspUUID = UUID.randomUUID();
				entryRhspModel.setId(entryRhspUUID);
				entryRhspModel.setWorstHousingSituation(Integer.parseInt(entryRhsp.getWorstHousingSituation()));
				entryRhspModel.setDateCreated(LocalDateTime.now());
				entryRhspModel.setDateUpdated(LocalDateTime.now());
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(entryRhsp.getEntryRHSPID()));
				entryRhspModel.setEnrollmentid(enrollmentModel);
				com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, domain.getExportId());
				exportEntity.addEntryrhsp(entryRhspModel);
			//	entryRhspModel.setUserId(exportEntity.getUserId());
				entryRhspModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(entryRhsp.getDateCreated()));
				entryRhspModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(entryRhsp.getDateUpdated()));
				hydrateCommonFields(entryRhspModel, domain);
				entryRhspModel.setExport(exportEntity);
				entryRhspModel.setProjectGroupCode(entryRhsp.getProjectID());
				entryRhspModel.setSync(false);
				entryRhspModel.setDeleted(false);
				insertOrUpdate(entryRhspModel);
			}
	   }
	}



	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.stagv2015.Export export) {
		Set<com.servinglynk.hmis.warehouse.model.stagv2015.Entryrhsp> entryRshp = export.getEntryrhsps();
		if(entryRshp !=null && !entryRshp.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.stagv2015.Entryrhsp entryRshps : entryRshp) {
				com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp entryrhspByDedupCliendId = getEntryrhspByDedupEntryrhspId(entryRshps.getId(),entryRshps.getProjectGroupCode());
				if(entryrhspByDedupCliendId ==null) {
					com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp target = new com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp();
					BeanUtils.copyProperties(entryRshps, target, new String[] {"enrollments","veteranInfoes"});
					com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, export.getId());
					exportEntity.addEntryrhsp(target);
					target.setExport(exportEntity);
					insertOrUpdate(target);
				}
			}
		}
	}
	
	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.stagv2015.Entryrhsp entryRshp) {
			if(entryRshp !=null) {
				com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp target = new com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp();
				BeanUtils.copyProperties(entryRshp, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, entryRshp.getExport().getId());
				exportEntity.addEntryrhsp(target);
				target.setExport(exportEntity);
				com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp entryRhspByDedupCliendId = getEntryrhspByDedupEntryrhspId(entryRshp.getId(),entryRshp.getProjectGroupCode());
				if(entryRhspByDedupCliendId ==null) {
					insert(target);	
				}
			}
	}
	
	
	
    
	private Date getDateInFormat(String dob) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
        	formatter = new SimpleDateFormat("yyyy-MM-dd");
              date = (Date)((DateFormat) formatter).parse(dob);
            
            String s = formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
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
	public com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp createEntryrhsp(com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp entryRhsp) {
		entryRhsp.setId(UUID.randomUUID());
			insert(entryRhsp);
		return entryRhsp;
	}


	@Override
	public Entryrhsp updateEntryrhsp(com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp entryRhsp) {
			update(entryRhsp);
		return entryRhsp;
	}


	@Override
	public void deleteEntryrhsp(com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp entryRhsp) {
			delete(entryRhsp);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp getEntryrhspById(UUID entryrhspId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp.class);
		criteria.add(Restrictions.eq("id", entryrhspId));
		List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp> entryrhsp = (List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp>) findByCriteria(criteria);
		if(entryrhsp.size()>0) return entryrhsp.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp getEntryrhspByDedupEntryrhspId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp> entryrhsp = (List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp>) findByCriteria(criteria);
		if(entryrhsp !=null && entryrhsp.size()>0) return entryrhsp.get(0);
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
	public List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp> getAllEntryrhsp(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp.class);	
		List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp> entryrhsp = (List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp>) findByCriteria(criteria,startIndex,maxItems);
		return entryrhsp;
	}
	
	
	public long getEntryrhspCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp.class);	
		return countRows(criteria);
	}


	public List<Entryrhsp> getAllEnrollmentEntryrhsps(UUID enrollmentId, Integer startIndex, Integer maxItems) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getEnrollmentEntryrhspsCount(UUID enrollmentId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
