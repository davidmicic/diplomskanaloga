package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administratorskipodatki")
public class Administratorskipodatki {

	@Id
	@Column(name = "id", unique = true)
	private int id;
	
	@Column(name = "username", unique = true)
	private String username;
	
	@Column(name = "passw", unique = true)
	private String passw;
	
	@Column(name = "userRole", unique = true)
	private String userRole;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassw() {
		return passw;
	}

	public void setPassw(String passw) {
		this.passw = passw;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
}
