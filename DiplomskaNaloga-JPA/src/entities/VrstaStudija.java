package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vrstastudija")
public class VrstaStudija {

	@Id
	@Column(name = "id", unique = true)
	private int id;

	@Column(name = "vrsta", unique = true)
	private String vrsta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVrsta() {
		return vrsta;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}


}
