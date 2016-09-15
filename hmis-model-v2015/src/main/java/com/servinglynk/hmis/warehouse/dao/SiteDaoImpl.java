package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.model.v2015.Error2015;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Site;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.SitePrincipalSiteEnum;
import com.servinglynk.hmis.warehouse.enums.StateEnum;
import com.servinglynk.hmis.warehouse.model.v2015.Coc;
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class SiteDaoImpl extends ParentDaoImpl implements SiteDao {
	private static final Logger logger = LoggerFactory
			.getLogger(SiteDaoImpl.class);
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<Site> sites = domain.getExport().getSite();
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Site.class, getProjectGroupCode(domain));
		if(sites !=null && !sites.isEmpty()) {
			for(Site site :sites) {
				if(site !=null) {
					com.servinglynk.hmis.warehouse.model.v2015.Site siteModel = null;
					try{
						siteModel = getModelObject(domain, site,data,modelMap);
						siteModel.setAddress(site.getAddress());
						siteModel.setCity(site.getCity());
						siteModel.setDateCreated(BasicDataGenerator.getLocalDateTime(site.getDateCreated()));
						siteModel.setDateUpdated(BasicDataGenerator.getLocalDateTime(site.getDateUpdated()));
						siteModel.setGeocode(site.getGeocode());
						siteModel.setPrincipalSite(SitePrincipalSiteEnum.lookupEnum(BasicDataGenerator.getStringValue(site.getPrincipalSite())));
						Coc coc = (Coc) getModel(Coc.class,site.getCoCCode(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
						siteModel.setCoc(coc);
						siteModel.setState(StateEnum.lookupEnum(site.getState()));
						siteModel.setExport(exportEntity);
						//site.getUserID()
						siteModel.setZip(String.valueOf(site.getZIP()));
						performSaveOrUpdate(siteModel);
					} catch(Exception e){
						String errorMessage = "Exception beause of the site::"+site.getSiteID() +" Exception ::"+e.getMessage();
						if(siteModel != null){
							Error2015 error = new Error2015();
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
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2015.Site.class.getSimpleName(), domain,exportEntity);
	}

	public com.servinglynk.hmis.warehouse.model.v2015.Site getModelObject(ExportDomain domain, Site site ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2015.Site SiteModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			SiteModel = (com.servinglynk.hmis.warehouse.model.v2015.Site) getModel(com.servinglynk.hmis.warehouse.model.v2015.Site.class, site.getSiteID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(SiteModel == null) {
			SiteModel = new com.servinglynk.hmis.warehouse.model.v2015.Site();
			SiteModel.setId(UUID.randomUUID());
			SiteModel.setRecordToBeInserted(true);
			
		}else{
			++data.j;
		}
		hydrateCommonFields(SiteModel, domain,site.getSiteID(),data);
		return SiteModel;
	}
	
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

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
	       criteria.createAlias("coc", "coc");
	       criteria.add(Restrictions.eq("coc.id", projectCocId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Site>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectCOCSitesCount(UUID projectCocId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Site.class);
	       criteria.createAlias("coc", "coc");
	       criteria.add(Restrictions.eq("coc.id", projectCocId));
	       return countRows(criteria);
	   }

}
