package com.servinglynk.hmis.warehouse;

public class SortedPagination
{
  private Integer from = Integer.valueOf(0);
  private Integer returned;
  private Integer total;
  private Integer maximum = Integer.valueOf(30);
  private Sort sort;
  
  public Integer getMaximum()
  {
    return this.maximum;
  }
  
  public void setMaximum(Integer maximum)
  {
    this.maximum = maximum;
  }
  
  public Integer getFrom()
  {
    return this.from;
  }
  
  public void setFrom(Integer from)
  {
    this.from = from;
  }
  
  public Integer getReturned()
  {
    return this.returned;
  }
  
  public void setReturned(Integer returned)
  {
    this.returned = returned;
  }
  
  public Integer getTotal()
  {
    return this.total;
  }
  
  public void setTotal(Integer total)
  {
    this.total = total;
  }
  
  public Sort getSort()
  {
    if (this.sort == null) {
      return new Sort();
    }
    return this.sort;
  }
  
  public void setSort(Sort sort)
  {
    this.sort = sort;
  }
}
