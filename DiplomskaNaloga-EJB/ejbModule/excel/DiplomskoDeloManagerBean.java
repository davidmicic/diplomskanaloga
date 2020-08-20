package excel;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import dto.CheckboxesDTO;
import dto.DiplomskoDeloDTO;
import dto.DiplomskoDeloExcelDTO;
import entities.DiplomskaDela;
import entities.Profesor;
import entities.Program;
import entities.VrstaStudija;
import entities.Zavod;

@Stateless
public class DiplomskoDeloManagerBean {

	@PersistenceContext(unitName = "DiplomskaNaloga-JPA")
	protected EntityManager em;
	
	private int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void saveAllDiplomskaDelaToDatabase(DiplomskoDeloExcelDTO dto) throws IOException {
		String vpisnaStevilka = dto.getVpisnaStevilka();
		DiplomskaDela dd = new DiplomskaDela();
		Profesor profesor = (Profesor) em.createQuery("select p from Profesor p where p.imePriimek = :imePriimek")
				.setParameter("imePriimek", dto.getImeProf()).getSingleResult();

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

	@SuppressWarnings("unchecked")
	public List<DiplomskoDeloDTO> getAllDiplomskaDelaFromDatabase() throws ParseException {
		List<DiplomskoDeloDTO> dtoList = new LinkedList<DiplomskoDeloDTO>();

		List<DiplomskaDela> listDD = em.createQuery("select dd from DiplomskaDela dd").getResultList();

		for (DiplomskaDela dd : listDD) {
			DiplomskoDeloDTO dto = new DiplomskoDeloDTO();
			dto.setDijak(dd.getPriimekIme());

			SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
			dto.setDatum(dt1.format(dd.getDatum()));
			dto.setProfesor(dd.getProfesor().getImePriimek());
			dto.setProgram(dd.getProgram().getVrsta());
			dto.setVrstaStudija(dd.getVrstastudija().getVrsta());
			dto.setZavod(dd.getZavod().getZavod());
			dto.setNaslov(dd.getNaslov());
			dtoList.add(dto);
		}

		return dtoList;
	}
	
	public List<Predicate> filtersDiplZavod(CheckboxesDTO filter, Root<DiplomskaDela> c, CriteriaBuilder cb) {
		boolean solskiCK = filter.isSolskiCenterKranj();
		boolean tsolskiCK = filter.isTehniskiSolskiCenterKranj();
		boolean esic = filter.isEsic();
		
		List<Predicate> prd = new ArrayList<Predicate>();
		
		if(solskiCK == true) {
			prd.add(cb.equal(c.get("zavod"), em.find(Zavod.class, "1231")));
		}
		if(tsolskiCK == true) {
			prd.add(cb.equal(c.get("zavod"), em.find(Zavod.class, "1222")));
		}
		if(esic == true) {
			prd.add(cb.equal(c.get("zavod"), em.find(Zavod.class, "1146")));
		}
		
		return prd;
	}
	
	public List<Predicate> filtersDiplVrstaStudija(CheckboxesDTO filter, Root<DiplomskaDela> c, CriteriaBuilder cb) {
		boolean izredni = filter.isIzredni();
		boolean redni = filter.isRedni();
		
		List<Predicate> prd = new ArrayList<Predicate>();
		
		if(redni == true) {
			prd.add(cb.equal(c.get("vrstastudija"), em.find(VrstaStudija.class, 0)));
		}
		if(izredni == true) {
			prd.add(cb.equal(c.get("vrstastudija"), em.find(VrstaStudija.class, 5)));
		}
		
		return prd;
	}
	
	public List<Predicate> filtersDiplProgram(CheckboxesDTO filter, Root<DiplomskaDela> c, CriteriaBuilder cb) {
		boolean meh = filter.isMeh();
		boolean ene = filter.isEne();
		boolean var = filter.isVar();
		boolean osm = filter.isOsm();
		boolean ps = filter.isPs();
		boolean inf = filter.isInf();
		boolean ekn = filter.isEkn();
		
		List<Predicate> prd = new ArrayList<Predicate>();
		
		if(meh == true) {
			prd.add(cb.equal(c.get("program"), em.find(Program.class, "022")));
		}
		if(ene == true) {
			prd.add(cb.equal(c.get("program"), em.find(Program.class, "005")));
		}
		if(var == true) {
			prd.add(cb.equal(c.get("program"), em.find(Program.class, "035")));
		}
		if(osm == true) {
			prd.add(cb.equal(c.get("program"), em.find(Program.class, "025")));
		}
		if(ps == true) {
			prd.add(cb.equal(c.get("program"), em.find(Program.class, "009")));
		}
		if(inf == true) {
			prd.add(cb.equal(c.get("program"), em.find(Program.class, "019")));
		}
		if(ekn == true) {
			prd.add(cb.equal(c.get("program"), em.find(Program.class, "026")));
		}
		
		return prd;
	}
	
//	private List<Predicate> filtersDiplProgram(CheckboxesDTO filter, Root<DiplomskaDela> c, CriteriaBuilder cb) {
//		List<Predicate> prd = new ArrayList<Predicate>();
//		
//		if(filter.getYear() != null && filter.getYear().length() > 0) {
//			prd.add(cb.equal());
//		}
//		
//	}
	
	public TypedQuery<DiplomskaDela> buildQuery(CheckboxesDTO filter) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DiplomskaDela> criteriaQuery = cb.createQuery(DiplomskaDela.class);
		Root<DiplomskaDela> c = criteriaQuery.from(DiplomskaDela.class);
		
		List<Predicate> prdPro = filtersDiplProgram(filter, c, cb);
		List<Predicate> prdVs = filtersDiplVrstaStudija(filter, c, cb);
		List<Predicate> prdZa = filtersDiplZavod(filter, c, cb);
		
		
		
		criteriaQuery.select(c)
		.where(cb.and
		(cb.or((prdPro.toArray(new Predicate[prdPro.size()])))), cb.or((prdVs.toArray(new Predicate[prdVs.size()]))), cb.or(prdZa.toArray(new Predicate[prdZa.size()])));
		
//		String year = filter.getYear();
//		if(year != null && year.length() > 0) {
//			Date date = (Date) c.get("datum");
//			SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
//			String date2 = dt1.format(date);
//			
//			boolean yearBoolean = (year == date2) ? true : false;
//			
//			criteriaQuery.select(c)
//			.where(cb.and
//			(cb.or((prdPro.toArray(new Predicate[prdPro.size()])))), cb.or((prdVs.toArray(new Predicate[prdVs.size()]))), cb.or(prdZa.toArray(new Predicate[prdZa.size()])));
//		}
//		else {
//			criteriaQuery.select(c)
//			.where(cb.and
//			(cb.or((prdPro.toArray(new Predicate[prdPro.size()])))), cb.or((prdVs.toArray(new Predicate[prdVs.size()]))), cb.or(prdZa.toArray(new Predicate[prdZa.size()])));
//		}
		TypedQuery<DiplomskaDela> qry = em.createQuery(criteriaQuery);
		return qry;
	}

	@SuppressWarnings("unchecked")
	public List<DiplomskoDeloDTO> getDiplomskaDelaByPage(CheckboxesDTO filter, int page) throws ParseException {
		List<DiplomskoDeloDTO> dtoList = new LinkedList<DiplomskoDeloDTO>();
		TypedQuery<DiplomskaDela> qry = buildQuery(filter);
		
		int valueFrom = page * 30 - 30;
		qry.setFirstResult(valueFrom);
		qry.setMaxResults(30);
		List<DiplomskaDela> listDD = qry.getResultList();
		
		setCount(listDD.size());
		
		for (DiplomskaDela dd : listDD) {
			DiplomskoDeloDTO dto = new DiplomskoDeloDTO();
			dto.setDijak(dd.getPriimekIme());
			
			SimpleDateFormat dt1 = new SimpleDateFormat("dd.MM.yyyy");
			dto.setDatum(dt1.format(dd.getDatum()));
			dto.setProfesor(dd.getProfesor().getImePriimek());
			dto.setProgram(dd.getProgram().getVrsta());
			dto.setVrstaStudija(dd.getVrstastudija().getVrsta());
			dto.setZavod(dd.getZavod().getZavod());
			dto.setNaslov(dd.getNaslov());
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	public int getCountDiplomskaDela(CheckboxesDTO filter) {
		TypedQuery<DiplomskaDela> qry = buildQuery(filter);
		List<DiplomskaDela> listDD = qry.getResultList();
		
		return listDD.size();
	}
	
	@SuppressWarnings("unchecked")
	public List<Date> getDiplomskaDelaLetoIzdelave() throws ParseException {

		Query query = em.createQuery("select DISTINCT year(dd.datum) from DiplomskaDela dd order by dd.datum desc");
		List<Date> listDD = query.getResultList();
		return listDD;
	}
}
