package dto;

import java.util.List;

import entities.Profesor;
import entities.Program;
import entities.VrstaStudija;
import entities.Zavod;

public class CatalogueDTO {

	private List<VrstaStudijaDTO> vrstaStudija;
	private List<ZavodDTO> zavod;
	private List<ProgramDTO> program;
	private List<ProfesorDTO> profesor;
	private List<String> roles;
	private List<String> allRoles;
	private String user;

	public List<String> getAllRoles() {
		return allRoles;
	}

	public void setAllRoles(List<String> allRoles) {
		this.allRoles = allRoles;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<VrstaStudijaDTO> getVrstaStudija() {
		return vrstaStudija;
	}

	public void setVrstaStudija(List<VrstaStudijaDTO> vrstaStudija) {
		this.vrstaStudija = vrstaStudija;
	}

	public List<ZavodDTO> getZavod() {
		return zavod;
	}

	public void setZavod(List<ZavodDTO> zavod) {
		this.zavod = zavod;
	}

	public List<ProgramDTO> getProgram() {
		return program;
	}

	public void setProgram(List<ProgramDTO> program) {
		this.program = program;
	}

	public List<ProfesorDTO> getProfesor() {
		return profesor;
	}

	public void setProfesor(List<ProfesorDTO> profesor) {
		this.profesor = profesor;
	}

}
