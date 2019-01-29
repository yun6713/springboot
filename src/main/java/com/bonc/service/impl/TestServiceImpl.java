package com.bonc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bonc.TestJpaRepository;
import com.bonc.service.TestService;
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestJpaRepository test;

	@Override
	public Object findById(Long id) {
		// TODO Auto-generated method stub
		return test.findOne(id);
	}
	
	
	
}
