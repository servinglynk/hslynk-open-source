package com.servinglynk.hmis.warehouse.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.model.Client;


@Component
public class EnrollmentDaoImpl implements EnrollmentDao {

	@Autowired EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Client> getGenericHousehold(UUID genericHouseholdId,String projectGroupCode,String schemaYear) {
		List<Client> clients = new ArrayList<Client>();
		Session session = entityManager.unwrap(Session.class);
		String query = "select global_client_id as \"clientId\",schema_year as \"schemaYear\", client_link  as \"clientLink\" from housing_inventory.household_membership where global_household_id = '"+genericHouseholdId+"' and  project_group_code = '"+projectGroupCode+"'";
		System.out.println("households query "+query);
		List<Client> data =  session.createSQLQuery(query)
				.addScalar("clientId",org.hibernate.type.PostgresUUIDType.INSTANCE)
				  .addScalar("clientLink")
				  .addScalar("schemaYear")
				.setResultTransformer(Transformers.aliasToBean(Client.class))
				.list();
		
		return data;
	}
}