package com.servinglynk.hmis.warehouse.util;

import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.servinglynk.hmis.warehouse.util.ClientOperationLogger;

public class EntityInterceptor extends EmptyInterceptor {
	
	@Autowired
	ClientOperationLogger clientOperationLogger;

	public void preFlush(Iterator entities) {
		clientOperationLogger.logClientOperation(entities);
	}	
}