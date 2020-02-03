package com.servinglynk.hmis.warehouse.base.dao;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.lucene.search.Query;
import org.apache.lucene.search.SortField;
import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.query.dsl.TermMatchingContext;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.SearchRequest;
import com.servinglynk.hmis.warehouse.Sort;
import com.servinglynk.hmis.warehouse.common.security.AuditUtil;
import com.servinglynk.hmis.warehouse.enums.ClientDobDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientEthnicityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientGenderEnum;
import com.servinglynk.hmis.warehouse.enums.ClientNameDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientRaceEnum;
import com.servinglynk.hmis.warehouse.enums.ClientSsnDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientVeteranStatusEnum;
import com.servinglynk.hmis.warehouse.model.SearchClient;
import com.servinglynk.hmis.warehouse.model.base.Client;

public class SearchDaoImpl
  extends QueryExecutorImpl
  implements SearchDao
{
	@Autowired
	ClientConsentDao clientConsentDao;
	
  public List<?> search(SearchRequest searchVO)
  {
    Session session = getCurrentSession();
    FullTextSession fullTextSession = Search.getFullTextSession(session);
    
    QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(searchVO.getSearchEntity()).get();
    
    Query luceneQuery = queryBuilder.all().createQuery();
    
    TermMatchingContext termMatchingContext = queryBuilder.keyword().wildcard().onField(searchVO.getDbfileds()[0]);
    for (int i = 1; i < searchVO.getDbfileds().length; i++) {
      termMatchingContext.andField(searchVO.getDbfileds()[i]);
    }
    luceneQuery = termMatchingContext.matching("*" + searchVO.getFreeText() + "*").createQuery();
    
    FullTextQuery hibernateQuery = fullTextSession.createFullTextQuery(luceneQuery, new Class[] {searchVO
      .getSearchEntity() });
    
    int resultSize = hibernateQuery.getResultSize();
    if (searchVO.getPagination() != null)
    {
      searchVO.getPagination().setTotal(Integer.valueOf(resultSize));
      hibernateQuery.setFirstResult(searchVO.getPagination().getFrom().intValue());
      hibernateQuery.setMaxResults(searchVO.getPagination().getMaximum().intValue());
      if ((searchVO.getPagination().getSort() != null) && 
        (searchVO.getPagination().getSort().getField() != null))
      {
        String order = searchVO.getPagination().getSort().getOrder();
        boolean reverse = false;
        if ("desc".equalsIgnoreCase(order)) {
          reverse = true;
        }
        org.apache.lucene.search.Sort sort = new org.apache.lucene.search.Sort(new SortField(searchVO.getPagination().getSort().getField(), SortField.STRING, reverse));
        hibernateQuery.setSort(sort);
      }
    }
    return hibernateQuery.list();
  }
  
  
  public List<?> search(SearchRequest searchVO,boolean isProcSearch){
	  if(isProcSearch){
		  return this.searchProc(searchVO);
	  }else{
		  return this.searchData(searchVO);

	  }
  }
  
  
  // If search Keyword is in date format -> search will be done on date of birth field only
  // If search Keyword is in UUID format -> search will be done on id field only.
  // If search keyword is string         -> search will be done on remaining fields.
  // In all the scenarios search results will be filtered on login user project group
  
  
  public DetachedCriteria prepareCriteria(SearchRequest searchRequest) {
	  
	  DetachedCriteria criteria = DetachedCriteria.forClass(Client.class);
	  DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	  Date date=null;
	  
		 if(!searchRequest.getClients().isEmpty()) {
			  Criterion consentGroup = Restrictions.in("id",searchRequest.getClients());
			 criteria.add(consentGroup);
		 }
	  
	try {
		date = formatter.parse(searchRequest.getFreeText());
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		
		criteria.add(Restrictions.sqlRestriction(" convert_from(dob_decrypt(dob),'UTF-8') >= ?" , date,org.hibernate.type.StandardBasicTypes.DATE));
		criteria.add(Restrictions.sqlRestriction(" convert_from(dob_decrypt(dob),'UTF-8') < ?" , new Date(date.getTime()+TimeUnit.DAYS.toMillis(1)),org.hibernate.type.StandardBasicTypes.DATE));			
		
		
		//  criteria.add(Restrictions.ge(" convert_from(hmis_decrypt(dob,'UTF8')", LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())));
		//  criteria.add(Restrictions.lt(" convert_from(hmis_decrypt(dob,'UTF8')", LocalDateTime.ofInstant(DateUtils.addDays(date,1).toInstant(), ZoneId.systemDefault())));
	} catch (ParseException e) {
		try{
			  UUID clientId = UUID.fromString(searchRequest.getFreeText());
			  Criterion clientIdCr = Restrictions.eq("id", clientId);
			  Criterion dedupClientIdCr =Restrictions.eq("dedupClientId", clientId);
			  criteria.add(Restrictions.or(clientIdCr,dedupClientIdCr));
			  //criteria.addOrder(Order.desc("dateUpdated"));
			  Sort sorting = new Sort();
			    sorting.setOrder("desc");
			    sorting.setField("dateUpdated");
			    searchRequest.setSort(sorting);
		  }catch (Exception ex) {
				 
				  Criterion firstName = Restrictions.ilike("firstName",searchRequest.getFreeText(),MatchMode.ANYWHERE);
				  Criterion lastName = Restrictions.ilike("lastName",searchRequest.getFreeText(),MatchMode.ANYWHERE);
				  Criterion middleName = Restrictions.ilike("middleName",searchRequest.getFreeText(),MatchMode.ANYWHERE);
				 Criterion sourceSystemId = Restrictions.ilike("sourceSystemId",searchRequest.getFreeText(),MatchMode.ANYWHERE);
				  Criterion ssn = Restrictions.sqlRestriction(" ( convert_from(ssn_decrypt(ssn),'UTF-8') ilike '%"+searchRequest.getFreeText().replaceAll("^ +| +$|( )+","$1")+"%') ");
				  Criterion fullName = Restrictions.sqlRestriction("(concat(first_name,' ',middle_name,' ',last_name) ilike '%"+searchRequest.getFreeText().replaceAll("^ +| +$|( )+","$1")+"%') ");
				  Criterion clientName = Restrictions.sqlRestriction("(concat(first_name,' ',last_name) ilike '%"+searchRequest.getFreeText().replaceAll("^ +| +$|( )+","$1")+"%') ");
				  if(Arrays.asList(searchRequest.getExcludeFields()).contains("ssi"))
					  criteria.add(Restrictions.or(firstName,lastName,middleName,ssn,fullName,clientName));
				  else
					  criteria.add(Restrictions.or(firstName,lastName,middleName,ssn,sourceSystemId,fullName,clientName));
				
				
				/*ProjectionList projectionList = Projections.projectionList();
				  projectionList.add(Projections.groupProperty("dedupClientId"));
				  projectionList.add(Projections.groupProperty("firstName"));
				  projectionList.add(Projections.groupProperty("lastName"));
				  projectionList.add(Projections.groupProperty("middleName"));
				  projectionList.add(Projections.groupProperty("sourceSystemId"));
				  projectionList.add(Projections.groupProperty("ssn"));
				  projectionList.add(Projections.groupProperty("dateUpdated"));
				  criteria.setProjection(projectionList);  */
				//  criteria.addOrder(Order.desc("dateUpdated"));
		  } 
  }
	criteria.add(Restrictions.isNull("parentId"));
	criteria.add(Restrictions.eq("deleted", false));
	criteria.add(Restrictions.isNotNull("dedupClientId"));

	  return criteria;
  }
  
  
  public List<?> searchData(SearchRequest searchRequest){
	  
	  if(searchRequest.getSearchParams().get("consentGroupId")!=null) {
		  String consentGroupId = (String) searchRequest.getSearchParams().get("consentGroupId");
		   List<UUID> consents =  clientConsentDao.searchClients(consentGroupId);
		 if(consents.isEmpty()) {
			 searchRequest.getPagination().setTotal(0);
			 return new ArrayList<>();
		 }else {
			 searchRequest.setClients(consents);
		 }
	  }
	  
	  searchRequest.getPagination().setTotal((int) getRowsCount(this.prepareCriteria(searchRequest)));
	  
	  
	  DetachedCriteria criteria =this.prepareCriteria(searchRequest);
	  
	  if(searchRequest.getSort().getOrder().equals("asc"))
		  criteria.addOrder(Order.asc(searchRequest.getSort().getField()));
	  else
		  criteria.addOrder(Order.desc(searchRequest.getSort().getField())); 
	  
	  criteria.addOrder(Order.desc("dateUpdated"));
	  return getByCriteria(criteria,searchRequest.getPagination().getFrom(),searchRequest.getPagination().getMaximum());
  }
  
  public List<?>  searchProc(SearchRequest searchRequest) {
	  DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

  	  String id = null;
  String name = null;
  String dob = null;
  System.out.println("search text "+searchRequest.getFreeText());
  name = "'%"+searchRequest.getFreeText().replaceAll("'", "''")+"%'";
	  
	  String queryString = "select * from base.shared_client_search_by_name('%"+searchRequest.getFreeText().replaceAll("'", "''")+"%','"+searchRequest.getProjectGroupCode()+"','"+searchRequest.getSort().getField()+"','"+searchRequest.getSort().getOrder()+"',"+ searchRequest.getPagination().getFrom()+","+searchRequest.getPagination().getMaximum()+",'"+searchRequest.getUserId()+"')";
	  
	  
	  try {
		    UUID.fromString(searchRequest.getFreeText());
			  name = null;
			  dob  = null;
			  id ="'"+ searchRequest.getFreeText()+"'";
		   queryString = "select * from base.shared_client_search_by_id('"+searchRequest.getFreeText()+"','"+searchRequest.getProjectGroupCode()+"','"+searchRequest.getSort().getField()+"','"+searchRequest.getSort().getOrder()+"',"+ searchRequest.getPagination().getFrom()+","+searchRequest.getPagination().getMaximum()+",'"+searchRequest.getUserId()+"')";
	  }catch (Exception e) {
	}
	  
	  try {
		  formatter.parse(searchRequest.getFreeText());
		  formatter.parse(searchRequest.getFreeText());
		  name = null;
		  id =null;
		  dob ="'"+ searchRequest.getFreeText()+"'";
		  queryString = "select * from base.shared_client_search_by_dob('"+searchRequest.getFreeText()+"','"+searchRequest.getProjectGroupCode()+"','"+searchRequest.getSort().getField()+"','"+searchRequest.getSort().getOrder()+"',"+ searchRequest.getPagination().getFrom()+","+searchRequest.getPagination().getMaximum()+",'"+searchRequest.getUserId()+"')";
	  }catch (Exception e) {
	}
	  
	  org.hibernate.Query query = getCurrentSession().createSQLQuery(queryString)
			  .addScalar("rId",org.hibernate.type.PostgresUUIDType.INSTANCE)
			  .addScalar("rDedupClientId",org.hibernate.type.PostgresUUIDType.INSTANCE)
			  .addScalar("rNameDataQuality", sessionFactory.getTypeHelper().custom(com.servinglynk.hmis.warehouse.enums.ClientNameDataQualityEnumType.class))
			  .addScalar("rSsnDataQuality", sessionFactory.getTypeHelper().custom(com.servinglynk.hmis.warehouse.enums.ClientSsnDataQualityEnumType.class))
			  .addScalar("rDobDataQuality", sessionFactory.getTypeHelper().custom(com.servinglynk.hmis.warehouse.enums.ClientDobDataQualityEnumType.class))
			  .addScalar("rGender", sessionFactory.getTypeHelper().custom(com.servinglynk.hmis.warehouse.enums.ClientGenderEnumType.class))
			  .addScalar("rEthnicity", sessionFactory.getTypeHelper().custom(com.servinglynk.hmis.warehouse.enums.ClientEthnicityEnumType.class))
			  .addScalar("rRace", sessionFactory.getTypeHelper().custom(com.servinglynk.hmis.warehouse.enums.ClientRaceEnumType.class))
			  .addScalar("rVeteranStatus", sessionFactory.getTypeHelper().custom(com.servinglynk.hmis.warehouse.enums.ClientVeteranStatusEnumType.class))
	  		  .addScalar("rDob",sessionFactory.getTypeHelper().custom(org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime.class))
  	  		  .addScalar("rFirstName")
	  		  .addScalar("rLastName")
	  		  .addScalar("rMiddleName")
  	  		  .addScalar("rNameSuffix")
	  		  .addScalar("rOtherGender")
	  		  .addScalar("rSsn")
	  		  .addScalar("rSourceSystemId")
	  		  .addScalar("rSchemaYear")
	  		  .addScalar("rPhoneNumber")
	  		  .addScalar("rEmailAddress")
	  		  .addScalar("rProjectGroupCode")
	  		  .setResultTransformer(Transformers.aliasToBean(SearchClient.class));

	  org.hibernate.Query countQuery = getCurrentSession().createSQLQuery("select datasize from base.search_client_count ("+id+" ,"+name+" ,"+dob+",'"+searchRequest.getProjectGroupCode()+"' ) ");
	  searchRequest.getPagination().setTotal(((BigInteger)countQuery.list().get(0)).intValue());

	  return query.list();
  }
  
/*  public List<?> searchData(SearchRequest searchRequest){

	  DetachedCriteria criteria = DetachedCriteria.forClass(Client.class);
		  DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		  Date date=null;
		  
		try {
			date = formatter.parse(searchRequest.getFreeText());
			date.setHours(0);
			date.setMinutes(0);
			date.setSeconds(0);
			
			criteria.add(Restrictions.sqlRestriction(" convert_from(dob_decrypt(dob),'UTF-8') >= ?" , date,org.hibernate.type.StandardBasicTypes.DATE));
			criteria.add(Restrictions.sqlRestriction(" convert_from(dob_decrypt(dob),'UTF-8') < ?" , new Date(date.getTime()+TimeUnit.DAYS.toMillis(1)),org.hibernate.type.StandardBasicTypes.DATE));			
			
			
			//  criteria.add(Restrictions.ge(" convert_from(hmis_decrypt(dob,'UTF8')", LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())));
			//  criteria.add(Restrictions.lt(" convert_from(hmis_decrypt(dob,'UTF8')", LocalDateTime.ofInstant(DateUtils.addDays(date,1).toInstant(), ZoneId.systemDefault())));
		} catch (ParseException e) {
			try{
				  UUID clientId = UUID.fromString(searchRequest.getFreeText());
				  Criterion clientIdCr = Restrictions.eq("id", clientId);
				  Criterion dedupClientIdCr =Restrictions.eq("dedupClientId", clientId);
				  criteria.add(Restrictions.or(clientIdCr,dedupClientIdCr));
				  //criteria.addOrder(Order.desc("dateUpdated"));
				  Sort sorting = new Sort();
				    sorting.setOrder("desc");
				    sorting.setField("dateUpdated");
				    searchRequest.setSort(sorting);
			  }catch (Exception ex) {
					  
					  Criterion firstName = Restrictions.ilike("firstName",searchRequest.getFreeText(),MatchMode.ANYWHERE);
					  Criterion lastName = Restrictions.ilike("lastName",searchRequest.getFreeText(),MatchMode.ANYWHERE);
					  Criterion middleName = Restrictions.ilike("middleName",searchRequest.getFreeText(),MatchMode.ANYWHERE);
					 Criterion sourceSystemId = Restrictions.ilike("sourceSystemId",searchRequest.getFreeText(),MatchMode.ANYWHERE);
					  Criterion ssn = Restrictions.sqlRestriction(" ( convert_from(ssn_decrypt(ssn),'UTF-8') ilike '%"+searchRequest.getFreeText().replaceAll(" ","")+"%') ");
					  Criterion fullName = Restrictions.sqlRestriction("(concat(first_name,middle_name,last_name) ilike '%"+searchRequest.getFreeText().replaceAll(" ","")+"%') ");
					  Criterion clientName = Restrictions.sqlRestriction("(concat(first_name,last_name) ilike '%"+searchRequest.getFreeText().replaceAll(" ","")+"%') ");
					  if(Arrays.asList(searchRequest.getExcludeFields()).contains("ssi"))
						  criteria.add(Restrictions.or(firstName,lastName,middleName,ssn,fullName,clientName));
					  else
						  criteria.add(Restrictions.or(firstName,lastName,middleName,ssn,sourceSystemId,fullName,clientName));
					
					
					ProjectionList projectionList = Projections.projectionList();
					  projectionList.add(Projections.groupProperty("dedupClientId"));
					  projectionList.add(Projections.groupProperty("firstName"));
					  projectionList.add(Projections.groupProperty("lastName"));
					  projectionList.add(Projections.groupProperty("middleName"));
					  projectionList.add(Projections.groupProperty("sourceSystemId"));
					  projectionList.add(Projections.groupProperty("ssn"));
					  projectionList.add(Projections.groupProperty("dateUpdated"));
					  criteria.setProjection(projectionList);  
					//  criteria.addOrder(Order.desc("dateUpdated"));
			  } 
	  }
		criteria.add(Restrictions.eq("projectGroupCode",searchRequest.getProjectGroupCode()));
		criteria.add(Restrictions.eq("deleted", false));
		criteria.add(Restrictions.isNotNull("dedupClientId"));
		DetachedCriteria countCriteria = criteria;
	  searchRequest.getPagination().setTotal((int) countRows(countCriteria));
	  
	  if(searchRequest.getSort().getOrder().equals("asc"))
		  criteria.addOrder(Order.asc(searchRequest.getSort().getField()));
	  else
		  criteria.addOrder(Order.desc(searchRequest.getSort().getField())); 
	  
	  criteria.addOrder(Order.desc("dateUpdated"));
	  return findByCriteria(criteria,searchRequest.getPagination().getFrom(),searchRequest.getPagination().getMaximum());
  }
  */
  public boolean indexing(String indexClassList)
  {
    boolean status = true;
    
    Session session = getCurrentSession();
    
    FullTextSession fullTextSession = Search.getFullTextSession(session);
    
   // String indexClassList = "com.servinglynk.hmis.warehouse.model.v2015.Client,com.servinglynk.hmis.warehouse.model.v2014.Client";

    if (indexClassList != null)
    {
      String[] indexClasses = indexClassList.split(",");
      for (String entityClassName : indexClasses) {
        try
        {
          indexing(Class.forName(entityClassName), fullTextSession);
        }
        catch (ClassNotFoundException e)
        {
          status = false;
          e.printStackTrace();
        }
      }
    }
    else
    {
      indexing(indexClassList);
    }
    return status;
  }
  
  protected void indexing(Class cls, FullTextSession fullTextSession)
  {
    fullTextSession.setFlushMode(FlushMode.MANUAL);
    fullTextSession.setCacheMode(CacheMode.IGNORE);
    
    fullTextSession.purgeAll(cls);
    
    ScrollableResults results = fullTextSession.createCriteria(cls).scroll(ScrollMode.FORWARD_ONLY);
    
    int index = 0;
    while (results.next())
    {
      index++;
      fullTextSession.index(results.get(0));
      if (index % 150 == 0)
      {
        fullTextSession.flushToIndexes();
        fullTextSession.clear();
      }
    }
  }
  public void doIndex(Object indexObject){
	  FullTextSession fullTextSession = Search.getFullTextSession(getCurrentSession());
	  Transaction tx = fullTextSession.beginTransaction();
	  fullTextSession.index(indexObject);
	  tx.commit();
  }
  
  public static void main(String args[]) {
	  String text ="   Surya      Yadavalli     ";
	  System.out.println(text.replaceAll("^ +| +$|( )+","$1"));
  }
}