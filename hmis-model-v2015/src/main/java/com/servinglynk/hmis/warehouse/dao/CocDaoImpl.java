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
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.dao.helper.DedupHelper;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.CoC;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class CocDaoImpl  extends ParentDaoImpl implements CocDao{
	
	@Autowired
	DedupHelper dedupHelper;
		
	@Autowired
	private ParentDaoFactory factory;
	
	@Override
	public void hydrateStaging(ExportDomain domain) {
		
	    Export export = domain.getExport();
		List<CoC> cocs = export.getCoC();
		if (cocs != null && cocs.size() > 0) {
			for (CoC coc : cocs) {
				com.servinglynk.hmis.warehouse.model.stagv2015.Coc cocModel = new com.servinglynk.hmis.warehouse.model.stagv2015.Coc();
				UUID cocUUID = UUID.randomUUID();
				cocModel.setId(cocUUID);
				cocModel.setCoccode(coc.getCoCCode());
				cocModel.setDateCreated(LocalDateTime.now());
				cocModel.setDateUpdated(LocalDateTime.now());
//				factory.getInventoryDao().hydrateStaging(domain);
				com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, domain.getExportId());
				exportEntity.addCoc(cocModel);
				cocModel.setUserId(exportEntity.getUserId());
				cocModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(coc.getDateCreated()));
				cocModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(coc.getDateUpdated()));
				hydrateCommonFields(cocModel, domain);
				cocModel.setExport(exportEntity);
				cocModel.setProjectGroupCode(coc.getProjectID());
				factory.getSiteDao().hydrateStaging(domain);
				insertOrUpdate(cocModel);
				
			}
	}
	
	}



	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.stagv2015.Export export) {
		Set<com.servinglynk.hmis.warehouse.model.stagv2015.Coc> coc = export.getCocs();
		if(coc !=null && !coc.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.stagv2015.Coc cocs : coc) {
				com.servinglynk.hmis.warehouse.model.v2015.Coc cocByDedupCliendId = getCocByDedupCliendId(cocs.getId(),cocs.getProjectGroupCode());
				if(cocByDedupCliendId ==null) {
					com.servinglynk.hmis.warehouse.model.v2015.Coc target = new com.servinglynk.hmis.warehouse.model.v2015.Coc();
					BeanUtils.copyProperties(cocs, target, new String[] {"enrollments","veteranInfoes"});
					com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, export.getId());
					exportEntity.addCoc(target);
					target.setExport(exportEntity);
					insertOrUpdate(target);
				}
			}
		}
	}
	
	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.stagv2015.Coc coc) {
			if(coc !=null) {
				com.servinglynk.hmis.warehouse.model.v2015.Coc target = new com.servinglynk.hmis.warehouse.model.v2015.Coc();
				BeanUtils.copyProperties(coc, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, coc.getExport().getId());
				exportEntity.addCoc(target);
				target.setExport(exportEntity);
				com.servinglynk.hmis.warehouse.model.v2015.Coc clientByDedupCliendId = getCocByDedupCliendId(coc.getId(),coc.getProjectGroupCode());
				if(clientByDedupCliendId ==null) {
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
	public com.servinglynk.hmis.warehouse.model.v2015.Coc createCoc(
			com.servinglynk.hmis.warehouse.model.v2015.Coc coc) {
			coc.setId(UUID.randomUUID());
			insert(coc);
		return coc;
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Coc updateCoc(
			com.servinglynk.hmis.warehouse.model.v2015.Coc coc) {
			update(coc);
		return coc;
	}


	@Override
	public void deleteCoc(
			com.servinglynk.hmis.warehouse.model.v2015.Coc coc) {
			delete(coc);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Coc getCocById(UUID cocId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Coc.class);
		criteria.add(Restrictions.eq("id", cocId));
		List<com.servinglynk.hmis.warehouse.model.v2015.Coc> coc = (List<com.servinglynk.hmis.warehouse.model.v2015.Coc>) findByCriteria(criteria);
		if(coc.size()>0) return coc.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Coc getCocByDedupCliendId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Coc.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2015.Coc> coc = (List<com.servinglynk.hmis.warehouse.model.v2015.Coc>) findByCriteria(criteria);
		if(coc !=null && coc.size()>0) return coc.get(0);
		return null;
	}
	public com.servinglynk.hmis.warehouse.model.stagv2015.Coc getCocByDedupCliendIdFromStaging(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.stagv2015.Coc.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.stagv2015.Coc> coc = (List<com.servinglynk.hmis.warehouse.model.stagv2015.Coc>) findByCriteria(criteria);
		if(coc !=null && coc.size()>0) return coc.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2015.Coc> getAllCoc(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Coc.class);	
		List<com.servinglynk.hmis.warehouse.model.v2015.Coc> coc = (List<com.servinglynk.hmis.warehouse.model.v2015.Coc>) findByCriteria(criteria,startIndex,maxItems);
		return coc;
	}
	
	
	public long getCocCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Coc.class);	
		return countRows(criteria);
	}

}
