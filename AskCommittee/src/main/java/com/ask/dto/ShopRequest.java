package com.ask.dto;

import java.io.Serializable;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class ShopRequest implements Serializable {
	
	@Id
    @GeneratedValue	
	private int id;
	
	@NotBlank(message = "店名が未入力です")
	private String name;
	
	private String url;
	
	@Pattern(regexp = "0[0-9]{9,11}", message="電話番号を入力してください(ハイフンなし・半角)")
	private String phone_number;
	
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
