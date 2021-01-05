package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zavod")
public class Zavod {

	@Id
	@Column(name = "id", unique = true)
	private int id;

	@Column(name = "code", unique = true)
	private String code;

	@Column(name = "zavod", unique = true)
	private String zavod;

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

	public String getZavod() {
		return zavod;
	}

	public void setZavod(String zavod) {
		this.zavod = zavod;
	}

}
