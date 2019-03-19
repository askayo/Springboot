package s4.spring.td5.entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String login;
	private String email;
	private String password;
	private String identity;
	
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
		

	}
	public int getId() {
		return id;
	}
	public String getLogin() {
		return login;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getIdentity() {
		return identity;
	}
	
	
	
	
	
	
	
	
	

}
