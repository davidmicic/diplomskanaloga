package server;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

import entities.Program;
import util.UserRoles;

@Stateless
public class ProgramManagerBean extends AManager{

	@SuppressWarnings("unchecked")
//	@RolesAllowed({UserRoles.Program.getProgram})
	public List<Program> getAllPrograms() {
		List<Program> programs = em.createQuery("select p from Program p").getResultList();
		return programs;
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getAllInteger() {
		List<Integer> program = em.createQuery("select p.id from Program p").getResultList();
		return program;
	}
}
