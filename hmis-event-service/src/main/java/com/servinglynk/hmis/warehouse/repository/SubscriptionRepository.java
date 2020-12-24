package com.servinglynk.hmis.warehouse.repository;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.entity.SubscriptionEntity;

public interface SubscriptionRepository extends BaseRepository<SubscriptionEntity, UUID> {

   List<SubscriptionEntity>	findByCriteriaUrlAndProjectGroupCodeAndDeleted(String criteriaUrl,String projectGroupCode,Boolean deleted);
	
}
