package com.ask.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Ask_member")
public class LoginUser implements Serializable{
	
	@Id	
	@Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
	
	@Column(name = "name")	
	private String name;
	
	@Column(name = "email")	
	private String email;
	
	@Column(name = "password")	
	private String password;

	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
