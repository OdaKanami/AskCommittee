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
	
	
}
