package com.servinglynk.hmis.warehouse.base.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.lucene.search.Query;
import org.apache.lucene.search.SortField;
import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.query.dsl.TermMatchingContext;

import com.servinglynk.hmis.warehouse.SearchRequest;
import com.servinglynk.hmis.warehouse.model.base.Client;

public class SearchDaoImpl
  extends QueryExecutorImpl
  implements SearchDao
{
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
  
  
  public List<?> search(SearchRequest searchVO,boolean isIndexSearch){
	  if(isIndexSearch){
		  return this.search(searchVO);
	  }else{
		  return this.searchData(searchVO);
	  }
  }
  
  
  public List<?> searchData(SearchRequest searchRequest){
	  
	  Pattern pattern = Pattern.compile("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$");
	  Matcher matcher = pattern.matcher(searchRequest.getFreeText());
	  
	  DetachedCriteria criteria = DetachedCriteria.forClass(Client.class);
	  
	  if(!matcher.matches()) {
			  Criterion firstName = Restrictions.like("firstName",searchRequest.getFreeText(),MatchMode.ANYWHERE);
			  Criterion lastName = Restrictions.like("lastName",searchRequest.getFreeText(),MatchMode.ANYWHERE);
			  Criterion middleName = Restrictions.like("middleName",searchRequest.getFreeText(),MatchMode.ANYWHERE);
			  Criterion sourceSystemId = Restrictions.like("sourceSystemId",searchRequest.getFreeText(),MatchMode.ANYWHERE);
			  Criterion ssn = Restrictions.like("ssn",searchRequest.getFreeText(),MatchMode.ANYWHERE);
			  
			  criteria.add(Restrictions.or(firstName,lastName,middleName,sourceSystemId,ssn));
	  }else{
		  DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		  Date date=null;
		try {
			date = formatter.parse(searchRequest.getFreeText());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" "+date);
		System.out.println("  "+LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()));
		  criteria.add(Restrictions.eq("dob", LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())));
	  }
	  searchRequest.getPagination().setTotal((int) countRows(criteria));
	  
	  if(searchRequest.getSort().getOrder().equals("asc"))
		  criteria.addOrder(Order.asc(searchRequest.getSort().getField()));
	  else
		  criteria.addOrder(Order.desc(searchRequest.getSort().getField())); 
	  
	  return findByCriteria(criteria,searchRequest.getPagination().getFrom(),searchRequest.getPagination().getMaximum());
  }
  
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
}
