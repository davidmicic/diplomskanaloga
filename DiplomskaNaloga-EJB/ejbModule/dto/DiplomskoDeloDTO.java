package dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "diplomskoDelo")
@XmlAccessorType(XmlAccessType.FIELD)
public class DiplomskoDeloDTO {
	
//	@XmlElement
	private String dijak;
//	@XmlElement
	private String datum;
//	@XmlElement
	private String profesor;
//	@XmlElement
	private String zavod;
//	@XmlElement
	private String program;
//	@XmlElement
	private String vrstaStudija;
//	@XmlElement
	private String naslov;
//	@XmlElement
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDijak() {
		return dijak;
	}

	public void setDijak(String dijak) {
		this.dijak = dijak;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getZavod() {
		return zavod;
	}

	public void setZavod(String zavod) {
		this.zavod = zavod;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getVrstaStudija() {
		return vrstaStudija;
	}

	public void setVrstaStudija(String vrstaStudija) {
		this.vrstaStudija = vrstaStudija;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	@Override
	public String toString() {
		return "DiplomskoDeloDTO [dijak=" + dijak + ", datum=" + datum + ", profesor=" + profesor + ", zavod=" + zavod
				+ ", program=" + program + ", vrstaStudija=" + vrstaStudija + ", naslov=" + naslov + ", id=" + id + "]";
	}
	
}
