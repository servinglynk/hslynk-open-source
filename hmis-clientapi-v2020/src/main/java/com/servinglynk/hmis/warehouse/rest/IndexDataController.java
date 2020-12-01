package com.servinglynk.hmis.warehouse.rest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.apache.activemq.command.ActiveMQQueue;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Parent;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.base.dao.QueryExecutorImpl;
import com.servinglynk.hmis.warehouse.common.JsonUtil;
import com.servinglynk.hmis.warehouse.dao.ParentDaoFactory;
import com.servinglynk.hmis.warehouse.model.base.ClientMetaDataEntity;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;


@RestController
public class IndexDataController extends ControllerBase {
	
	@Autowired ParentDaoFactory parentDaoFactory;
	
	@Autowired JmsTemplate jmsMessagingTemplate;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@RequestMapping(value = "/index",method = RequestMethod.POST)
	@Transactional
	@APIMapping(checkSessionToken = false,checkTrustedApp = false,value = "CLIENT_API_CREATE_CLIENT")
	public void indexEnrollments() {
		this.index();
	}
	
	@Transactional
	public void index() {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Enrollment.class);
		criteria.add(Restrictions.eq("projectGroupCode","TT0013"));
		criteria.add(Restrictions.eq("deleted",false));
		criteria.add(Restrictions.sqlRestriction(" date_created >  CURRENT_DATE - INTERVAL '3 months' "));
		List<Enrollment> enrollments =	(List<Enrollment>)criteria.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
		for(Enrollment enrollment : enrollments) {
			ClientMetaDataEntity metaDataEntity = new ClientMetaDataEntity();
			metaDataEntity.setId(UUID.randomUUID());
			metaDataEntity.setClientId(enrollment.getClient().getId());
			metaDataEntity.setClientDedupId(enrollment.getClient().getDedupClientId());
			metaDataEntity.setDate(LocalDateTime.now());
			metaDataEntity.setDateCreated(LocalDateTime.now());
			metaDataEntity.setDateUpdated(LocalDateTime.now());
			metaDataEntity.setDeleted(false);
			metaDataEntity.setMetaDataIdentifier(enrollment.getId());
			metaDataEntity.setType("enrollments");
			metaDataEntity.setProjectGroupCode(enrollment.getProjectGroupCode());
			metaDataEntity.setUserId(enrollment.getUserId());
			metaDataEntity.setAdditionalInfo("{\"enrollmentId\":\""+enrollment.getId()+"\",\"schemaYear\":\"2020\",\"clientId\":\""+enrollment.getClient().getId()+"\"}");
			ClientMetaDataEntity entity = parentDaoFactory.getClientMetaDataDao().findByIdentifier(enrollment.getId());
			if(entity==null) {
				parentDaoFactory.getClientMetaDataDao().createClientMetaData(metaDataEntity);
			}
			
			
			ActiveMQQueue queue = new ActiveMQQueue("cache.cleint.metadtata");
			try {
				jmsMessagingTemplate.convertAndSend(queue,JsonUtil.coneveterObejctToString(metaDataEntity));
			} catch (JmsException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
