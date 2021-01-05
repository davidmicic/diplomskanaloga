package rest;

import java.text.ParseException;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import dto.ProgramDTO;
import entities.Program;
import server.AManager;
import server.ProgramManagerBean;
import util.UserRoles;

@Path("program")
@Stateless
@Produces("application/json")
public class ProgramServiceImpl extends AManager {

	@EJB
	ProgramManagerBean pmb;

	@GET
	@Path("getAll")
//	@RolesAllowed({UserRoles.Program.getProgram})
	public List<Program> getAllDiplomskaDela() throws ParseException {
		List<Program> programs = pmb.getAllPrograms();
		return programs;
	}
	
	@GET
	@Path("getListOfIds")
	public List<Integer> getAllIds() throws ParseException {
		List<Integer> program = pmb.getAllInteger();
		return program;
	}
	
	@POST
	@Path("add")
//	@RolesAllowed({UserRoles.Program.addProgram})
	public int addProgram(Program program) {
		em.persist(program);
		return program.getId();
	}
	
	@DELETE
	@Path("remove")
//	@RolesAllowed({UserRoles.Program.addProgram})
	public int deleteProgram(Program program) {
		Query query = em.createQuery("Select p from Program p where p.vrsta = :code");
		query.setParameter("code", program.getCode());
		Program p = (Program) query.getSingleResult();
		em.remove(p);
		return p.getId();
	}
}
