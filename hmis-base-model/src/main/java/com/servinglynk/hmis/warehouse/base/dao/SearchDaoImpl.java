package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;

import org.apache.lucene.search.Query;
import org.apache.lucene.search.SortField;
import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.query.dsl.TermMatchingContext;

import com.servinglynk.hmis.warehouse.SearchRequest;

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
        org.apache.lucene.search.Sort sort = new org.apache.lucene.search.Sort(new SortField(searchVO.getPagination().getSort().getField(), 3, reverse));
        hibernateQuery.setSort(sort);
      }
    }
    return hibernateQuery.list();
  }
  
  public boolean indexing()
  {
    boolean status = true;
    
    Session session = getCurrentSession();
    
    FullTextSession fullTextSession = Search.getFullTextSession(session);
    
    String indexClassList = "com.servinglynk.hmis.warehouse.model.v2015.Client";
    System.out.println(indexClassList);
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
      indexing();
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
