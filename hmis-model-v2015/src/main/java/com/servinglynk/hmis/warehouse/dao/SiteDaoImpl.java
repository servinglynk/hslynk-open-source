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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Site;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.SitePrincipalSiteEnum;
import com.servinglynk.hmis.warehouse.enums.StateEnum;
import com.servinglynk.hmis.warehouse.model.stagv2015.Coc;
import com.servinglynk.hmis.warehouse.model.stagv2015.Export;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class SiteDaoImpl extends ParentDaoImpl implements SiteDao {

	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<Site> sites = domain.getExport().getSite();
		if(sites !=null && !sites.isEmpty()) {
			for(Site site :sites) {
				if(site !=null) {
					com.servinglynk.hmis.warehouse.model.stagv2015.Site siteModel = new com.servinglynk.hmis.warehouse.model.stagv2015.Site();
					siteModel.setAddress(site.getAddress());
					siteModel.setCity(site.getCity());
					siteModel.setDateCreated(BasicDataGenerator.getLocalDateTime(site.getDateCreated()));
					siteModel.setDateUpdated(BasicDataGenerator.getLocalDateTime(site.getDateUpdated()));
					siteModel.setGeocode(site.getGeocode());
					siteModel.setPrincipalSite(SitePrincipalSiteEnum.lookupEnum(BasicDataGenerator.getStringValue(site.getPrincipalSite())));
					UUID uuid = domain.getCocCodeMap().get(site.getCoCCode());
					if(uuid !=null) {
						Coc coc = (Coc) get(Coc.class,uuid);
						siteModel.setCoc(coc);
					}
					siteModel.setState(StateEnum.lookupEnum(site.getState()));
					com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, domain.getExportId());
					siteModel.setExport(exportEntity);
					siteModel.setId(UUID.randomUUID());
					//site.getUserID()
					siteModel.setZip(String.valueOf(site.getZIP()));
					exportEntity.addSite(siteModel);
					insertOrUpdate(siteModel);
				}
			}

		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<com.servinglynk.hmis.warehouse.model.stagv2015.Site> sites = export.getSites();
		if(sites !=null && !sites.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.stagv2015.Site site : sites) {
				if(site !=null) {
					com.servinglynk.hmis.warehouse.model.v2015.Site target = new com.servinglynk.hmis.warehouse.model.v2015.Site();
					BeanUtils.copyProperties(site, target, getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, site.getExport().getId());
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

	   public com.servinglynk.hmis.warehouse.model.v2015.Site createSite(com.servinglynk.hmis.warehouse.model.v2015.Site site){
	       site.setId(UUID.randomUUID());
	       insert(site);
	       return site;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Site updateSite(com.servinglynk.hmis.warehouse.model.v2015.Site site){
	       update(site);
	       return site;
	   }
	   public void deleteSite(com.servinglynk.hmis.warehouse.model.v2015.Site site){
	       delete(site);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Site getSiteById(UUID siteId){
	       return (com.servinglynk.hmis.warehouse.model.v2015.Site) get(com.servinglynk.hmis.warehouse.model.v2015.Site.class, siteId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Site> getAllProjectCOCSites(UUID projectCocId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Site.class);
	       criteria.createAlias("projectCoc", "projectCoc");
	       criteria.add(Restrictions.eq("projectCoc.id", projectCocId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Site>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectCOCSitesCount(UUID projectCocId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Site.class);
	       criteria.createAlias("projectCoc", "projectCoc");
	       criteria.add(Restrictions.eq("projectCoc.id", projectCocId));
	       return countRows(criteria);
	   }

}
