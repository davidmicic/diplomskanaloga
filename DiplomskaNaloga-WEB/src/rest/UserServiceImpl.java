package rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import dto.UserRole;
import entities.Role;
import entities.Uporabnik;
import server.AManager;
import server.UporabnikManagerBean;

@Path("uporabnik")
@Stateless
@Produces("application/json")
public class UserServiceImpl extends AManager {
	
	@EJB
	UporabnikManagerBean umb;
	
	@GET
	@Path("getAll")
	//@RolesAllowed({})
	public List<Uporabnik> getAll() {
		List<Uporabnik> list = umb.getAllUporabniki();
		return list;
	}
	
	@POST
	@Path("byUsername")
	//@RolesAllowed({})
	public Uporabnik byId(String username) {
		Uporabnik uporabnik = em.find(Uporabnik.class, username);
		return uporabnik;
	}
	
	@POST
	@Path("saveByUsername")
	//@RolesAllowed({})
	public void changePassword(Uporabnik uporabnik) {
		Uporabnik up = em.find(Uporabnik.class, uporabnik.getUsername());
		up.setPassword(uporabnik.getPassword());
		em.merge(up);
	}
	
	@POST
	@Path("saveNewUser")
	//@RolesAllowed({})
	public void saveNewUser(Uporabnik uporabnik) {
		em.persist(uporabnik);
	}
	
	@POST
	@Path("add")
//	@RolesAllowed({UserRoles.Program.addProgram})
	public void addRole(UserRole userRole) {
		String username = userRole.getUsername();
		String rolename = userRole.getRole();
		
		
		Role role = (Role) em.createNativeQuery("select * from Role where ime = :rolename", Role.class).setParameter("rolename", rolename).getSingleResult();
		
		Query query = em.createNativeQuery("insert into uporabnik_role (username, id_role) values (:username, :roleId)");
		query.setParameter("username", username);
		query.setParameter("roleId", role.getId());
		query.executeUpdate();
	}
	
	@POST
	@Path("remove")
//	@RolesAllowed({UserRoles.Program.addProgram})
	public void removeRole(UserRole userRole) {
		String username = userRole.getUsername();
		String rolename = userRole.getRole();
		
		
		Role role = (Role) em.createNativeQuery("select * from Role where ime = :rolename", Role.class).setParameter("rolename", rolename).getSingleResult();
		
		Query query = em.createNativeQuery("delete from uporabnik_role where username = :username and id_role = :roleId");
		query.setParameter("username", username);
		query.setParameter("roleId", role.getId());
		query.executeUpdate();
	}
}
