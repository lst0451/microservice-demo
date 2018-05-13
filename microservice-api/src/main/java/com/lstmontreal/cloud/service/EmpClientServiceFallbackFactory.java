package com.lstmontreal.cloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lstmontreal.cloud.entity.Emp;

import feign.hystrix.FallbackFactory;

@Component//非常重要
public class EmpClientServiceFallbackFactory implements FallbackFactory<EmpClientService> {

	@Override
	public EmpClientService create(Throwable arg0) {
		return new EmpClientService() {

			@Override
			public boolean add(Emp emp) {
				return false;
			}

			@Override
			public Emp get(Long id) {
				return new Emp().setEmpno(id).setLastName("服务目前不可用，无法提供ID为：["+id+"]的员工信息");
			}

			@Override
			public List<Emp> list() {
				return null;
			}
			
		};
	}

}
