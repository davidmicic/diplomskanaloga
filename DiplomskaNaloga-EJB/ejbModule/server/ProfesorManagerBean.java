package server;

import java.text.ParseException;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import dto.SearchListDTO;
import entities.Profesor;
import util.UserRoles;

@Stateless
public class ProfesorManagerBean extends AManager{
	
	@SuppressWarnings("unchecked")
//	@RolesAllowed({UserRoles.Profesor.getProfesor})
	public List<Profesor> getAllProfesor() {
		List<Profesor> profesors = em.createQuery("select p from Profesor p order by p.id").getResultList();
		return profesors;
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getAllInteger() {
		List<Integer> program = em.createQuery("select p.id from Profesor p").getResultList();
		return program;
	}
	
	public List<String> search(String search) {
		Query qry = em.createNativeQuery("select imePriimek from Profesor p where MATCH(imePriimek)" + 
				" AGAINST ('" + search + "*' IN BOOLEAN MODE)");
		
		List<String> searchStrings = qry.getResultList();
		return searchStrings;
	}
	
}
