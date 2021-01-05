package server;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

import entities.Zavod;
import util.UserRoles;

@Stateless
public class ZavodManagerBean extends AManager{

	@SuppressWarnings("unchecked")
//	@RolesAllowed({UserRoles.Zavod.getZavod})
	public List<Zavod> getAllZavod() {
		List<Zavod> zavods = em.createQuery("select z from Zavod z").getResultList();
		return zavods;
	}
	
	@SuppressWarnings("unchecked")
//	@RolesAllowed({UserRoles.Zavod.getZavod})
	public List<Integer> getAllInteger() {
		List<Integer> zavods = em.createQuery("select z.id from Zavod z").getResultList();
		return zavods;
	}
	
//	@RolesAllowed({UserRoles.Zavod.addZavod})
//	public String addZavod(Zavod zavod) {
//		em.persist(zavod);
//		return zavod.getId();
//	}
}
