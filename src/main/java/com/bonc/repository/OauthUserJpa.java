package com.bonc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bonc.entity.OauthUser;

public interface OauthUserJpa extends JpaRepository<OauthUser, String> {
	@Query(value="select u from OauthUser u where lower(u.username)=lower(:username)",nativeQuery=false)
	public OauthUser findByUsernameCaseInsensitive(@Param("username") String username);
}
