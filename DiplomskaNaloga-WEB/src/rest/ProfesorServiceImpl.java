package rest;

import java.text.ParseException;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import dto.ProfesorDTO;
import dto.SearchListDTO;
import entities.Profesor;
import entities.Zavod;
import server.AManager;
import server.ProfesorManagerBean;
import util.UserRoles;

@Path("profesor")
@Stateless
@Produces("application/json")
public class ProfesorServiceImpl extends AManager {

	@EJB
	ProfesorManagerBean pmb;

	@GET
	@Path("getAll")
//	@RolesAllowed({ UserRoles.Profesor.getProfesor })
	public List<Profesor> getAllDiplomskaDela() throws ParseException {
		List<Profesor> profesors = pmb.getAllProfesor();
		return profesors;
	}
	
	@GET
	@Path("getListOfIds")
	public List<Integer> getAllIds() throws ParseException {
		List<Integer> profesor = pmb.getAllInteger();
		return profesor;
	}

	@POST
	@Path("add")
//	@RolesAllowed({ UserRoles.Profesor.addProfesor })
	public int addProfesor(Profesor p) {
		em.persist(p);
		return p.getId();
	}
	
	@DELETE
	@Path("remove")
//	@RolesAllowed({UserRoles.Program.addProgram})
	public int deleteZavod(Profesor p) {
		Query query = em.createQuery("Select p from Profesor p where p.imePriimek = :imePriimek");
		query.setParameter("imePriimek", p.getImePriimek());
		Profesor pro = (Profesor) query.getSingleResult();
		em.remove(pro);
		return pro.getId();
	}
	
	@POST
	@Path("search")
	@Consumes("text/html")
	public SearchListDTO getSearch(String search) throws ParseException {
		List<String> searchStrings = pmb.search(search);
		SearchListDTO dto = new SearchListDTO();
		dto.setStrings(searchStrings);
		return dto;
	}
}
