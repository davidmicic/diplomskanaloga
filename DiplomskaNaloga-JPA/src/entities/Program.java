package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "program")
public class Program {

	@Id
	@Column(name = "id", unique = true)
	private int id;

	@Column(name = "code", unique = true)
	private String code;

	@Column(name = "vrsta", unique = true)
	private String vrsta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getVrsta() {
		return vrsta;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

}
