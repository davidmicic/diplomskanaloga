package excel;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dto.DiplomskoDeloDTO;
import entities.DiplomskaDela;
import entities.Profesor;
import entities.Program;
import entities.VrstaStudija;
import entities.Zavod;

@Stateless
public class ExcelManagerBean {
	
	@PersistenceContext(unitName="DiplomskaNaloga-JPA")
	protected EntityManager em;
	
	public void saveDataToDatabase(DiplomskoDeloDTO dto) throws IOException {
		String vpisnaStevilka = dto.getVpisnaStevilka();
		DiplomskaDela dd = new DiplomskaDela();
//		Profesor profesor = em.find(Profesor.class, dto.getImeProf());
		Profesor profesor = (Profesor) em.createQuery("select p from Profesor p where p.imePriimek = :imePriimek").setParameter("imePriimek", dto.getImeProf()).getSingleResult();
		
		Zavod zavod = em.find(Zavod.class, vpisnaStevilka.substring(0, 4));
		Program program = em.find(Program.class, vpisnaStevilka.substring(4, 7));
		VrstaStudija vs = em.find(VrstaStudija.class, Integer.valueOf(vpisnaStevilka.substring(7, 8)));
		
		dd.setPriimekIme(dto.getImeDijaka());
		dd.setNaslov(dto.getImeDiplome());
		dd.setProfesor(profesor);
		dd.setZavod(zavod);
		dd.setVrstastudija(vs);
		dd.setProgram(program);
		dd.setDatum(dto.getDatumDiplome());
		
		em.persist(dd);
	}
}
