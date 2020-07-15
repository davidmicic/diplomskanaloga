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
	private String id;

	@Column(name = "zavod", unique = true)
	private String zavod;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getZavod() {
		return zavod;
	}

	public void setZavod(String zavod) {
		this.zavod = zavod;
	}


}
