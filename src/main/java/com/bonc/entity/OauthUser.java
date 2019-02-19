package com.bonc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "oauth_user")
public class OauthUser implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "OauthUser_Generator")
	@GenericGenerator(name = "OauthUser_Generator", strategy = "identity")
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Email
	@Column(name = "email")
	private String email;
	@Column(name = "activated")
	private int activated;
	@Column(name = "activationkey")
	private String activationkey;
	@Column(name = "resetpasswordkey")
	private String resetpasswordkey;
	
	@ManyToMany
	@JoinTable(
		name="oauth_user_authority",
		joinColumns= {@JoinColumn(name="username")},
		inverseJoinColumns=@JoinColumn(name="authority")
	)
	private List<OauthAuthority> authorities;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getActivated() {
		return activated;
	}
	public void setActivated(int activated) {
		this.activated = activated;
	}
	public String getActivationkey() {
		return activationkey;
	}
	public void setActivationkey(String activationkey) {
		this.activationkey = activationkey;
	}
	public String getResetpasswordkey() {
		return resetpasswordkey;
	}
	public void setResetpasswordkey(String resetpasswordkey) {
		this.resetpasswordkey = resetpasswordkey;
	}
	
	
}
