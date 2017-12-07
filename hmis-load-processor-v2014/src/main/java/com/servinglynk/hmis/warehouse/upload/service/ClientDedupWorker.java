package com.servinglynk.hmis.warehouse.upload.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.util.DedupHelper;
import com.servinglynk.hmis.warehouse.dao.ParentDaoFactory;
import com.servinglynk.hmis.warehouse.model.v2014.Client;


@Component
public class ClientDedupWorker implements IClientDedupWorker  {
	
	final static Logger logger = Logger.getLogger(ClientWorkerChildren.class);

	@Autowired
	Environment env;

	@Autowired
	private ParentDaoFactory factory;
	
	@Autowired
	private DedupHelper dedupHelper;
	
	@Transactional
	@Scheduled(initialDelay=20,fixedDelay=10000)
	public void processWorkerLine() {
		try {
			List<Client> clients =  factory.getClientDao().getAllNullDedupIdClients();
			if(CollectionUtils.isNotEmpty(clients)) {
				String dedupSessionKey = dedupHelper.getAuthenticationHeader();;
				for(Client client : clients) {
					FileAppender appender = new FileAppender();
					appender.setName("client-dedup-2014");
					appender.setFile("logs/client-dedup-2014.log");
					appender.setImmediateFlush(true);
					appender.setAppend(true);
					appender.setLayout(new PatternLayout());
					appender.activateOptions();
					logger.addAppender(appender);
					/** Perform full refresh base on Project group */
					factory.getClientDao().updateDedupClient(client,dedupSessionKey);
 					logger.removeAppender(appender);
				}
			}
			logger.info("======== Client Dedup Id Populator processed ======");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
