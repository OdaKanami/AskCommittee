package com.ask.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserRequest implements Serializable{

	@Id
//	@GeneratedValue
	@NotEmpty(message = "社員番号を入力してください")
	private Integer id;
	
	@NotEmpty(message = "名前を入力してください")
	private String name;
	
	@NotEmpty(message = "メールアドレスを入力してください")
	private String email;
	
	@NotEmpty(message = "パスワードを入力してください")		
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
