package com.tangp.springcloud.service;
 
import java.util.List;

import com.tangp.springcloud.entities.Dept;
 
public interface DeptService
{
  public boolean add(Dept dept);
  public Dept    get(Long id);
  public List<Dept> list();
}
 

