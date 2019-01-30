package com.bonc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bonc.entity.Test01;
@Repository
public interface TestJpaRepository extends JpaRepository<Test01,Long> {

	//nativeQuery本地查询，非HQL查询。
	@Modifying
	@Query(value="insert into test01 (name) values ('Who are you?')",nativeQuery=true)
	public int insert();
}
