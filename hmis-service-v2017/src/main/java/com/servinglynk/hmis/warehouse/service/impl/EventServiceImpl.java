package com.servinglynk.hmis.warehouse.service.impl;

public class EventServiceImpl extends ServiceBase {
	
	/*
	 @Transactional
	   public void getAllEnrollmentEvents(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       EnrollmentCocs enrollmentCocs = new EnrollmentCocs();
	        List<com.servinglynk.hmis.warehouse.model.v2017.Event> entities = daoFactory.getEnrollmentCocDao().getAllEnrollmentEnrollmentCocs(enrollmentId,startIndex,maxItems);
	        for(com.servinglynk.hmis.warehouse.model.v2017.EnrollmentCoc entity : entities){
	           enrollmentCocs.addEnrollmentCoc(EnrollmentCocConverter.entityToModel(entity));
	        }
	        long count = daoFactory.getEnrollmentCocDao().getEnrollmentEnrollmentCocsCount(enrollmentId);
	        SortedPagination pagination = new SortedPagination();

	        pagination.setFrom(startIndex);
	        pagination.setReturned(enrollmentCocs.getEnrollmentCocs().size());
	        pagination.setTotal((int)count);
	        enrollmentCocs.setPagination(pagination);
	        return enrollmentCocs;
	   }
*/
}
