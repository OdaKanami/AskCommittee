package entity;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name="ask_member")
public class Ask_member{
	@Id
	private Integer emp_num;
	private String name;
	private String email;
	private String password;

	public Integer Emp_num() {
		return emp_num;
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