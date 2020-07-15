package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "diplomskadela")
public class DiplomskaDela {

	@Id
	@Column(name = "id", unique = true)
	private int id;

	@Column(name = "priimekIme", unique = true)
	private String priimekIme;

	@Column(name = "naslov")
	private String naslov;

	@Column(name = "datum")
	private Date datum;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "id",name = "id_zavod")
	private Zavod zavod;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "id",name = "id_profesor")
	private Profesor profesor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "id",name = "id_vrstastudija")
	private VrstaStudija vrstastudija;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "id",name = "id_program")
	private Program program;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPriimekIme() {
		return priimekIme;
	}

	public void setPriimekIme(String priimekIme) {
		this.priimekIme = priimekIme;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}


	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}


	public Zavod getZavod() {
		return zavod;
	}

	public void setZavod(Zavod zavod) {
		this.zavod = zavod;
	}


	public VrstaStudija getVrstastudija() {
		return vrstastudija;
	}

	public void setVrstastudija(VrstaStudija vrstastudija) {
		this.vrstastudija = vrstastudija;
	}


	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

}