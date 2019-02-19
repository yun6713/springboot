package com.bonc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bonc.entity.OauthAuthority;

public interface OauthAuthorityJpa extends JpaRepository<OauthAuthority, String> {

}
