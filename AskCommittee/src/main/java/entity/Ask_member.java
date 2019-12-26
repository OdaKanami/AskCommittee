package entity;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name="ask_member")
public class Ask_member{
	@Id
	private Integer employee_number;
	private String name;
	private String email;
	private String password;

	public Integer Employee_number() {
		return employee_number;
	}	
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}