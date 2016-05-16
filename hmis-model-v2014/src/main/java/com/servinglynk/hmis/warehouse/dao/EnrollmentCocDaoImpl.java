/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EnrollmentCoC;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.model.v2014.Export;
import com.servinglynk.hmis.warehouse.model.v2014.Projectcoc;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class EnrollmentCocDaoImpl extends ParentDaoImpl implements
		EnrollmentCocDao {
	@Autowired
	private ParentDaoFactory factory;

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		
		List<EnrollmentCoC> enrollmentCoCs = domain.getExport().getEnrollmentCoC();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		if(enrollmentCoCs!=null)
		{
			int i=0;
			hydrateBulkUploadActivityStaging(enrollmentCoCs, com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc.class.getSimpleName(), domain);
			for(EnrollmentCoC enrollmentCoc : enrollmentCoCs)
			{
				EnrollmentCoc enrollmentCocModel = new EnrollmentCoc();
				enrollmentCocModel.setId(UUID.randomUUID());
				enrollmentCocModel.setExport(exportEntity);
				enrollmentCocModel.setDateCreated(BasicDataGenerator.getLocalDateTime(enrollmentCoc.getDateCreated()));
				enrollmentCocModel.setDateUpdated(BasicDataGenerator.getLocalDateTime(enrollmentCoc.getDateUpdated()));
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(enrollmentCoc.getProjectEntryID()));
				enrollmentCocModel.setEnrollmentid(enrollmentModel);
				UUID projectCocId = domain.getProjectCocMap().get(enrollmentCoc.getProjectCoCID());
				if(projectCocId !=null) {
					Projectcoc projectCoc = (Projectcoc) get(Projectcoc.class,projectCocId);
					enrollmentCocModel.setProjectCoc(projectCoc);	
				}
				//enrollmentCocModel.setCocCode(enrollmentCoc.get);
				exportEntity.addEnrollmentCoc(enrollmentCocModel);
				i++;
				hydrateCommonFields(enrollmentCocModel, domain, String.valueOf(enrollmentCoc.getEnrollmentCoCID()), i);
				insert(enrollmentCocModel);
				
			}
		}
	}

	@Override
	public void hydrateLive(Export export, Long id) {
		Set<EnrollmentCoc> enrollmentCocs = export.getEnrollmentCocs();
		if(enrollmentCocs !=null && !enrollmentCocs.isEmpty()) {
			hydrateBulkUploadActivity(enrollmentCocs, com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc.class.getSimpleName(), export,id);
			for(EnrollmentCoc enrollmentCoc : enrollmentCocs) {
				if(enrollmentCoc != null) {
					com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc target = new com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc();
					BeanUtils.copyProperties(enrollmentCoc, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2014.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2014.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, enrollmentCoc.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addEnrollmentCoc(target);
					target.setDateCreated(LocalDateTime.now());
					target.setDateUpdated(LocalDateTime.now());
					insertOrUpdate(target);
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

}
