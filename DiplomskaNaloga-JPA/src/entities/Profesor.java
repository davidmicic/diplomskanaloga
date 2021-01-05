package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor {
	
	@Id
	@Column(name = "id", unique = true)
	private int id;
	
	@Column(name = "imePriimek", unique = true)
	private String imePriimek;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImePriimek() {
		return imePriimek;
	}

	public void setImePriimek(String imePriimek) {
		this.imePriimek = imePriimek;
	}



}
