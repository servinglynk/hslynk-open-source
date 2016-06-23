/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.FormerWardChildWelfare;
import com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareChildwelfareyearsEnum;
import com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareFormerwardchildwelfareEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class FormerwardchildwelfareDaoImpl extends ParentDaoImpl implements
		FormerwardchildwelfareDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<FormerWardChildWelfare> formerWardChildWelfares = domain.getExport().getFormerWardChildWelfare();
		hydrateBulkUploadActivityStaging(formerWardChildWelfares, com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare.class.getSimpleName(), domain);
		int i=0;
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		if(formerWardChildWelfares !=null && !formerWardChildWelfares.isEmpty() ) 
		{
			for(FormerWardChildWelfare formerWardChildWelfare : formerWardChildWelfares)
			{
				Formerwardchildwelfare formerwardchildwelfareModel = new Formerwardchildwelfare();
				formerwardchildwelfareModel.setId(UUID.randomUUID());
				formerwardchildwelfareModel.setChildwelfaremonths(BasicDataGenerator.getIntegerValue(formerWardChildWelfare.getChildWelfareMonths()));
				formerwardchildwelfareModel.setChildwelfareyears(FormerwardchildwelfareChildwelfareyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardChildWelfare.getChildWelfareYears())));
				formerwardchildwelfareModel.setFormerwardchildwelfare(FormerwardchildwelfareFormerwardchildwelfareEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardChildWelfare.getFormerWardChildWelfare())));
				formerwardchildwelfareModel.setDateCreated(LocalDateTime.now());
				formerwardchildwelfareModel.setDateUpdated(LocalDateTime.now());
				formerwardchildwelfareModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(formerWardChildWelfare.getDateCreated()));
				formerwardchildwelfareModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(formerWardChildWelfare.getDateUpdated()));
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(formerWardChildWelfare.getProjectEntryID()));
				formerwardchildwelfareModel.setExport(exportEntity);
				formerwardchildwelfareModel.setEnrollmentid(enrollmentModel);
				exportEntity.addFormerwardchildwelfare(formerwardchildwelfareModel);
				i++;
				hydrateCommonFields(formerwardchildwelfareModel, domain, formerWardChildWelfare.getFormerWardChildWelfareID(),i);
			}
		}
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare createFormerWardChildWelfare(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare formerWardChildWelfare){
	       formerWardChildWelfare.setId(UUID.randomUUID()); 
	       insert(formerWardChildWelfare);
	       return formerWardChildWelfare;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare updateFormerWardChildWelfare(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare formerWardChildWelfare){
	       update(formerWardChildWelfare);
	       return formerWardChildWelfare;
	   }
	   public void deleteFormerWardChildWelfare(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare formerWardChildWelfare){
	       delete(formerWardChildWelfare);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare getFormerWardChildWelfareById(UUID formerWardChildWelfareId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare) get(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare.class, formerWardChildWelfareId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare> getAllEnrollmentFormerWardChildWelfares(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentFormerWardChildWelfaresCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
