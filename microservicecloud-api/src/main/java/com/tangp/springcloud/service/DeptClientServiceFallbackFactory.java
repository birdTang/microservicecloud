package com.tangp.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tangp.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable cause) {
		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				return null;
			}
			
			@Override
			public Dept get(long id) {
				Dept dept = new Dept();
				dept.setDeptno(id);
				dept.setDname("该ID："+id+"没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
				dept.setDb_source("no this database in MySQL");
				return dept;

			}
			
			@Override
			public boolean add(Dept dept) {
				return false;
			}
		};
	}

}
