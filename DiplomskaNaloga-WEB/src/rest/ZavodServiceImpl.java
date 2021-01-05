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

import dto.ZavodDTO;
import entities.Program;
import entities.Zavod;
import server.AManager;
import server.ZavodManagerBean;
import util.UserRoles;

@Path("zavod")
@Stateless
@Produces("application/json")
public class ZavodServiceImpl extends AManager{

	@EJB
	ZavodManagerBean zmb;

	@GET
	@Path("getAll")
	public List<Zavod> getAllZavod() throws ParseException {
		List<Zavod> zavods = zmb.getAllZavod();
		return zavods;
	}
	
	@GET
	@Path("getListOfIds")
	public List<Integer> getAllIds() throws ParseException {
		List<Integer> zavods = zmb.getAllInteger();
		return zavods;
	}
	
	
	@POST
	@Path("add")
//	@RolesAllowed({UserRoles.Program.addProgram})
	public void addZavod(Zavod zavod) {
		em.persist(zavod);
	}
	
	@DELETE
	@Path("remove")
//	@RolesAllowed({UserRoles.Program.addProgram})
	public void deleteZavod(Zavod zavod) {
		Query query = em.createQuery("Select z from Zavod z where z.zavod = :code");
		query.setParameter("code", zavod.getCode());
		Zavod z = (Zavod) query.getSingleResult();
		em.remove(z);
	}
}
