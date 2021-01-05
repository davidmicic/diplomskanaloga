package server;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

import entities.VrstaStudija;
import util.UserRoles;

@Stateless
public class VrstaStudijaManagerBean extends AManager{
	
	@SuppressWarnings("unchecked")
//	@RolesAllowed({UserRoles.VrstaStudija.getVrstaStudija})
	public List<VrstaStudija> getAllVrstaStudija() {
		List<VrstaStudija> profesors = em.createQuery("select v from VrstaStudija v").getResultList();
		return profesors;
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getAllInteger() {
		List<Integer> vrstaStudija = em.createQuery("select v.id from VrstaStudija v").getResultList();
		return vrstaStudija;
	}
}
