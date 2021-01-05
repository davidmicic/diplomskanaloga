package dto;

import java.util.List;

import entities.Program;
import entities.VrstaStudija;
import entities.Zavod;

public class FilterPagesDTO {
	private int page;
	List<Integer> programs;
	List<Integer> zavods;
	List<Integer> vrste;
	List<Integer> profesors;
	String leto;

	
	public String getLeto() {
		return leto;
	}

	public void setLeto(String leto) {
		this.leto = leto;
	}

	public List<Integer> getProfesors() {
		return profesors;
	}

	public void setProfesors(List<Integer> profesors) {
		this.profesors = profesors;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<Integer> getPrograms() {
		return programs;
	}

	public void setPrograms(List<Integer> programs) {
		this.programs = programs;
	}

	public List<Integer> getZavods() {
		return zavods;
	}

	public void setZavods(List<Integer> zavods) {
		this.zavods = zavods;
	}

	public List<Integer> getVrste() {
		return vrste;
	}

	public void setVrste(List<Integer> vrste) {
		this.vrste = vrste;
	}

}
