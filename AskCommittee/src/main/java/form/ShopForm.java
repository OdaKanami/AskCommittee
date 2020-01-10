package form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ShopForm implements Serializable{

	@NotBlank(message = "店名が未入力です")
	private String name;
	
	private String url;
	
	private String phoneNumber;
	
	private String remark;

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public ShopForm(){
		
	}
	
	ShopForm(String name, String url, String phoneNumber, String remark){
		this.name = name;
		this.url = url;
		this.phoneNumber = phoneNumber;
		this.remark = remark;
	}
	
}
