package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Site;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.SitePrincipalSiteEnum;
import com.servinglynk.hmis.warehouse.enums.StateEnum;
import com.servinglynk.hmis.warehouse.model.stagv2014.Export;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class SiteDaoImpl extends ParentDaoImpl implements SiteDao {

	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<Site> sites = domain.getExport().getSite();
		hydrateBulkUploadActivityStaging(sites, com.servinglynk.hmis.warehouse.model.v2014.Site.class.getSimpleName(), domain);
		if(sites !=null && !sites.isEmpty()) {
			int i=0;
			for(Site site :sites) {
				if(site !=null) {
					com.servinglynk.hmis.warehouse.model.stagv2014.Site siteModel = new com.servinglynk.hmis.warehouse.model.stagv2014.Site();
					siteModel.setAddress(site.getAddress());
					siteModel.setCity(site.getCity());
					siteModel.setDateCreated(BasicDataGenerator.getLocalDateTime(site.getDateCreated()));
					siteModel.setDateUpdated(BasicDataGenerator.getLocalDateTime(site.getDateUpdated()));
					siteModel.setGeocode(site.getGeocode());
					siteModel.setPrincipalSite(SitePrincipalSiteEnum.lookupEnum(BasicDataGenerator.getStringValue(site.getPrincipalSite())));
//					Projectcoc projectCoc = (Projectcoc) get(Projectcoc.class,domain.getProjectCocMap().get(site.getProjectCoCID()));
//					siteModel.setProjectCoc(projectCoc);
					siteModel.setState(StateEnum.lookupEnum(site.getState()));
					com.servinglynk.hmis.warehouse.model.stagv2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2014.Export) get(com.servinglynk.hmis.warehouse.model.stagv2014.Export.class, domain.getExportId());
					siteModel.setExport(exportEntity);
					siteModel.setId(UUID.randomUUID());
					//site.getUserID()
					siteModel.setZip(String.valueOf(site.getZIP()));
					exportEntity.addSite(siteModel);
					hydrateCommonFields(siteModel, domain,String.valueOf(site.getSiteID()));
					insert(siteModel);
					i++;
					  if(i % batchSize() == 0 && i > 0) {
		                    getCurrentSession().flush();
		                    getCurrentSession().clear();
		                }
				}
			}
			
		}
	}

	@Override
	public void hydrateLive(Export export, Long id) {
		Set<com.servinglynk.hmis.warehouse.model.stagv2014.Site> sites = export.getSites();
		hydrateBulkUploadActivity(sites,com.servinglynk.hmis.warehouse.model.v2014.Site.class.getSimpleName(), export,id);
		if(sites !=null && !sites.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.stagv2014.Site site : sites) {
				if(site !=null) {
					com.servinglynk.hmis.warehouse.model.v2014.Site target = new com.servinglynk.hmis.warehouse.model.v2014.Site();
					BeanUtils.copyProperties(site, target, getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, site.getExport().getId());
					target.setExport(exportEntity);
					 target.setDateCreated(LocalDateTime.now());
					 target.setDateUpdated(LocalDateTime.now());
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
	
	   public com.servinglynk.hmis.warehouse.model.v2014.Site createSite(com.servinglynk.hmis.warehouse.model.v2014.Site site){
	       site.setId(UUID.randomUUID()); 
	       insert(site);
	       return site;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Site updateSite(com.servinglynk.hmis.warehouse.model.v2014.Site site){
	       update(site);
	       return site;
	   }
	   public void deleteSite(com.servinglynk.hmis.warehouse.model.v2014.Site site){
	       delete(site);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Site getSiteById(UUID siteId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Site) get(com.servinglynk.hmis.warehouse.model.v2014.Site.class, siteId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Site> getAllProjectCOCSites(UUID projectCocId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Site.class);
	       criteria.createAlias("projectCoc", "projectCoc");
	       criteria.add(Restrictions.eq("projectCoc.id", projectCocId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Site>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectCOCSitesCount(UUID projectCocId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Site.class);
	       criteria.createAlias("projectCoc", "projectCoc");
	       criteria.add(Restrictions.eq("projectCoc.id", projectCocId));
	       return countRows(criteria);
	   }

}
