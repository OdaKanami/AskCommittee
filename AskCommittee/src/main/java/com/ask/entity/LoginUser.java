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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
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
	
}
