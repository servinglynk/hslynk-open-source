package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Site;
import com.servinglynk.hmis.warehouse.enums.SitePrincipalSiteEnum;
import com.servinglynk.hmis.warehouse.enums.StateEnum;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Projectcoc;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class SiteDaoImpl extends ParentDaoImpl implements SiteDao {
	private static final Logger logger = LoggerFactory
			.getLogger(SiteDaoImpl.class);
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<Site> sites = domain.getExport().getSite();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Site.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(sites !=null && !sites.isEmpty()) {
			for(Site site :sites) {
				if(site !=null) {
					com.servinglynk.hmis.warehouse.model.v2014.Site siteModel = null;
					try {
						siteModel = getModelObject(domain, site,data,modelMap);
						siteModel.setAddress(site.getAddress());
						siteModel.setCity(site.getCity());
						siteModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(site.getDateCreated()));
						siteModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(site.getDateUpdated()));
						siteModel.setGeocode(site.getGeocode());
						siteModel.setPrincipalSite(SitePrincipalSiteEnum.lookupEnum(BasicDataGenerator.getStringValue(site.getPrincipalSite())));
						Projectcoc projectCoc = (Projectcoc) getModel(Projectcoc.class,site.getProjectCoCID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
						siteModel.setProjectCoc(projectCoc);
						siteModel.setState(StateEnum.lookupEnum(site.getState()));
						siteModel.setExport(exportEntity);
						siteModel.setZip(String.valueOf(site.getZIP()));
						performSaveOrUpdate(siteModel);
					} catch(Exception e) {
						String errorMessage = "Exception in Site:"+site.getSiteID()+  ":: Exception" +e.getLocalizedMessage();
						if (siteModel != null) {
							Error2014 error = new Error2014();
							error.model_id = siteModel.getId();
							error.bulk_upload_ui = domain.getUpload().getId();
							error.project_group_code = domain.getUpload().getProjectGroupCode();
							error.source_system_id = siteModel.getSourceSystemId();
							error.type = ErrorType.ERROR;
							error.error_description = errorMessage;
							error.date_created = siteModel.getDateCreated();
							performSave(error);
						}
						logger.error(errorMessage);
					}
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Site.class.getSimpleName(), domain,exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Site getModelObject(ExportDomain domain, Site Site ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Site SiteModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			SiteModel = (com.servinglynk.hmis.warehouse.model.v2014.Site) getModel(com.servinglynk.hmis.warehouse.model.v2014.Site.class, Site.getSiteID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(SiteModel == null) {
			SiteModel = new com.servinglynk.hmis.warehouse.model.v2014.Site();
			SiteModel.setId(UUID.randomUUID());
			SiteModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(SiteModel, domain,Site.getSiteID(),data.i+data.j);
		return SiteModel;
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
