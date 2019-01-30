package com.bonc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bonc.repository.TestJpaRepository;
import com.bonc.service.TestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	TestJpaRepository test;

	@Override
	public Object findById(Long id) {
		// TODO Auto-generated method stub
		return test.findOne(id);
	}

	@Override
	@Transactional
	public int testNativeInsert() {
		return test.insert();
	}

	@Override
	public Object testPageAndSort(int type) {
		Pageable p;
		switch(type) {
		case 1://分页
			p = new PageRequest(0,3);
			return test.findAll(p);
		case 2://分页排序
			p = new PageRequest(0,3,Sort.Direction.ASC,"name");
			return test.findAll(p);
		case 3://排序
			Sort s = new Sort(Sort.Direction.DESC,"name");
			return test.findAll(s);
		case 4://分页排序
			PageHelper.startPage(1,2,"name");
			return new PageInfo<>(test.findAll());
		case 5://分页
			PageHelper.startPage(1,2);
			return new PageInfo<>(test.findAll());
		default:
			return null;
		}
	}
	
	
	
}
