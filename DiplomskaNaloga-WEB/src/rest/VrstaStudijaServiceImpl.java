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

import dto.VrstaStudijaDTO;
import dto.ZavodDTO;
import entities.VrstaStudija;
import entities.Zavod;
import server.AManager;
import server.VrstaStudijaManagerBean;
import util.UserRoles;

@Path("vrstaStudija")
@Stateless
@Produces("application/json")
public class VrstaStudijaServiceImpl extends AManager {

	@EJB
	VrstaStudijaManagerBean vmb;

	@GET
	@Path("getAll")
//	@RolesAllowed({UserRoles.VrstaStudija.getVrstaStudija})
	public List<VrstaStudija> getAllVrstaStudija() throws ParseException {
		List<VrstaStudija> vrstaStudija = vmb.getAllVrstaStudija();
		return vrstaStudija;
	}
	
	@GET
	@Path("getListOfIds")
	public List<Integer> getAllIds() throws ParseException {
		List<Integer> vrstaStudija = vmb.getAllInteger();
		return vrstaStudija;
	}
	
	
	@POST
	@Path("add")
//	@RolesAllowed({UserRoles.VrstaStudija.addVrstaStudija})
	public void addVrstaStudija(VrstaStudija vs) {
		em.persist(vs);
	}
	
	@DELETE
	@Path("remove")
//	@RolesAllowed({UserRoles.Program.addProgram})
	public void deleteZavod(VrstaStudija vs) {
		Query query = em.createQuery("Select vs from VrstaStudija vs where vs.vrsta = :vrsta");
		query.setParameter("vrsta", vs.getVrsta());
		VrstaStudija vrstaS = (VrstaStudija) query.getSingleResult();
		em.remove(vrstaS);
	}
}
