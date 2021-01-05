package server;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import dto.UporabnikDTO;
import entities.Uporabnik;
import entities.VrstaStudija;

@Stateless
public class UporabnikManagerBean extends AManager{
	@SuppressWarnings("unchecked")
//	@RolesAllowed({UserRoles.VrstaStudija.getVrstaStudija})
	public List<Uporabnik> getAllUporabniki() {
		List<Uporabnik> uporabniki = em.createQuery("select u from Uporabnik u").getResultList();
		
//		List<Uporabnik> listDto = new ArrayList<String>();
//		for(Uporabnik u : uporabniki) {
//			listDto.add(u.getUsername());
//		}
		
		return uporabniki;
	}
}
