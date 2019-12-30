package com.tangp.springcloud.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tangp.springcloud.entities.Dept;
import com.tangp.springcloud.service.DeptClientService;
 
@RestController
public class DeptController_Consumer
{
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT"; //集成eureka后通过服务名访问服务
    
    @Autowired
    private DeptClientService deptClientService ;
    
    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept)
    {
         return deptClientService.add(dept);
    }
    
    @RequestMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
         return deptClientService.get(id);
    }
    
    @SuppressWarnings("unchecked")
    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list()
    {
         return deptClientService.list();
    }   
}
 
 
 

