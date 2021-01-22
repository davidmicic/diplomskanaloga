package server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dto.DiplomskoDeloDTO;
import dto.DiplomskoDeloExcelDTO;
import entities.DiplomskaDela;
import entities.Profesor;
import entities.Program;
import entities.VrstaStudija;
import entities.Zavod;

@Stateless
public class DiplomskoDeloManagerBean {
	private static final Logger LOGGER = Logger.getLogger(DiplomskoDeloManagerBean.class.getName());
	@PersistenceContext(unitName = "DiplomskaNaloga-JPA")
	protected EntityManager em;

	private static List<Integer> staticVrste;
	private static List<Integer> staticPrograms;
	private static List<Integer> staticZavods;
	private static List<Integer> staticProfesors;
	private static String staticLeto;

	@SuppressWarnings("unchecked")
	public List<DiplomskoDeloDTO> getDiplomskaDelaByPage(List<Integer> programs, List<Integer> zavods,
			List<Integer> vrste, List<Integer> profesors, String leto, int page) throws ParseException {

		staticVrste = vrste;
		staticPrograms = programs;
		staticZavods = zavods;
		staticProfesors = profesors;
		staticLeto = leto;

		Query qry = generateQuery(programs, zavods, vrste, profesors, leto);

		int valueFrom = page * 30 - 30;
		qry.setFirstResult(valueFrom);
		qry.setMaxResults(30);
		List<DiplomskaDela> listDD = qry.getResultList();

		List<DiplomskoDeloDTO> dtoList = fromEntityToDTO(listDD);

		return dtoList;
	}

	@SuppressWarnings("unchecked")
	public void getAllDiplomskaDela() throws ParseException {
		Query qry = generateQuery(staticPrograms, staticZavods, staticVrste, staticProfesors, staticLeto);

		List<DiplomskaDela> listDD = qry.getResultList();

		List<DiplomskoDeloDTO> dtoList = fromEntityToDTO(listDD);

		try {
		
			generatePDFDataXMLFile(dtoList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private List<DiplomskoDeloDTO> fromEntityToDTO(List<DiplomskaDela> listDD) {
		List<DiplomskoDeloDTO> dtoList = new LinkedList<DiplomskoDeloDTO>();
		for (DiplomskaDela dd : listDD) {
			DiplomskoDeloDTO dto = new DiplomskoDeloDTO();
			dto.setDijak(dd.getPriimekIme());
			
			LOGGER.log(Level.INFO, "WRITING TO PDF: " + dd.toString());

			SimpleDateFormat dt1 = new SimpleDateFormat("dd.MM.yyyy");
			dto.setDatum(dt1.format(dd.getDatum()));
			dto.setProfesor(dd.getProfesor().getImePriimek());
			dto.setProgram(dd.getProgram().getVrsta());
			dto.setVrstaStudija(dd.getVrstastudija().getVrsta());
			dto.setZavod(dd.getZavod().getZavod());
			dto.setNaslov(dd.getNaslov());
			dto.setId(dd.getId());
			dtoList.add(dto);
		}
		return dtoList;
	}

	private Query generateQuery(List<Integer> programs, List<Integer> zavods, List<Integer> vrste,
			List<Integer> profesors, String leto) {

		if (programs.size() == 0) {
			programs = null;
		}
		if (zavods.size() == 0) {
			zavods = null;
		}
		if (vrste.size() == 0) {
			vrste = null;
		}
		if (profesors.size() == 0) {
			profesors = null;
		}

		String qryString = "select dd from DiplomskaDela dd where 1=1" + " and dd.program.id IN (:programs) "
				+ " and dd.zavod.id IN (:zavods)" + " and dd.vrstastudija.id IN (:vrste)"
				+ " and dd.profesor.id IN (:profesors)";

		if (leto != null) {
			qryString += " and YEAR(dd.datum) = " + "\'" + leto + "\'";
		}

		Query qry = em.createQuery(qryString, DiplomskaDela.class);
		qry.setParameter("programs", programs);
		qry.setParameter("zavods", zavods);
		qry.setParameter("vrste", vrste);
		qry.setParameter("profesors", profesors);
		return qry;
	}

	@SuppressWarnings("unchecked")
	public List<Date> getDiplomskaDelaLetoIzdelave() throws ParseException {

		Query query = em
				.createQuery("select DISTINCT year(dd.datum) from DiplomskaDela dd order by year(dd.datum) desc");
		List<Date> listDD = query.getResultList();
		return listDD;
	}

	@SuppressWarnings("unchecked")
	public int getDiplomskaDelaCount(List<Integer> programs, List<Integer> zavods, List<Integer> vrste,
			List<Integer> profesors, String leto) {

		if (programs.size() == 0) {
			programs = null;
		}
		if (zavods.size() == 0) {
			zavods = null;
		}
		if (vrste.size() == 0) {
			vrste = null;
		}
		if (profesors.size() == 0) {
			profesors = null;
		}

		String qryString = "select dd from DiplomskaDela dd where 1=1" + " and dd.program.id IN (:programs) "
				+ " and dd.zavod.id IN (:zavods)" + " and dd.vrstastudija.id IN (:vrste)"
				+ " and dd.profesor.id IN (:profesors)";

		if (leto != null) {
			qryString += " and YEAR(dd.datum) = " + "\'" + leto + "\'";
		}

		Query qry = em.createQuery(qryString, DiplomskaDela.class);
		qry.setParameter("programs", programs);
		qry.setParameter("zavods", zavods);
		qry.setParameter("vrste", vrste);
		qry.setParameter("profesors", profesors);

		return qry.getResultList().size();
	}

	public void saveAllDiplomskaDelaToDatabaseTEST(DiplomskoDeloExcelDTO dto) throws IOException {
		String vpisnaStevilka = dto.getVpisnaStevilka();
		DiplomskaDela dd = new DiplomskaDela();

		System.out.print("Vpisna stevilka: " + vpisnaStevilka);
		if (vpisnaStevilka != null) {
			String zavodStevilka = vpisnaStevilka.substring(0, 4).replaceFirst("^+(?!$)", "");
			String programStevilka = vpisnaStevilka.substring(4, 7).replaceFirst("^+(?!$)", "");
			String vrstaStudijaStevilka = vpisnaStevilka.substring(7, 8).replaceFirst("^+(?!$)", "");

			Profesor profesor = (Profesor) em.createQuery("select p from Profesor p where p.imePriimek = :imePriimek")
					.setParameter("imePriimek", dto.getImeProf()).getSingleResult();

			Query q1 = em.createQuery("select p from Program p where p.code = :code");
			q1.setParameter("code", programStevilka);
			Program program = (Program) q1.getSingleResult();

			Query q2 = em.createQuery("select vs from VrstaStudija vs where vs.code = :code");
			q2.setParameter("code", vrstaStudijaStevilka);
			VrstaStudija vrstaStudija = (VrstaStudija) q2.getSingleResult();

			Query q3 = em.createQuery("select z from Zavod z where z.code = :code");
			q3.setParameter("code", zavodStevilka);
			Zavod zavod = (Zavod) q3.getSingleResult();

			dd.setPriimekIme(dto.getImeDijaka());
			dd.setNaslov(dto.getImeDiplome());
			dd.setProfesor(profesor);
			dd.setZavod(zavod);
			dd.setVrstastudija(vrstaStudija);
			dd.setProgram(program);
			dd.setDatum(dto.getDatumDiplome());

			em.persist(dd);
		}
	}

	@SuppressWarnings("unchecked")
	public List<String> search(String search) {
		Query qry = em.createNativeQuery("select priimekIme from diplomskadela d where MATCH(priimekIme)"
				+ " AGAINST ('" + search + "*' IN BOOLEAN MODE)");

		List<String> searchStrings = qry.getResultList();
		return searchStrings;
	}

	@SuppressWarnings("unchecked")
	public List<DiplomskoDeloDTO> getDiplomskoDeloByName(String priimekIme) {
		Query qry = em.createQuery("select d from DiplomskaDela d where d.priimekIme = :priimekIme");
		qry.setParameter("priimekIme", priimekIme);

		List<DiplomskoDeloDTO> listToReturn = new ArrayList<DiplomskoDeloDTO>();

		List<DiplomskaDela> listDD = qry.getResultList();
		for (DiplomskaDela dd : listDD) {
			DiplomskoDeloDTO dto = new DiplomskoDeloDTO();
			SimpleDateFormat dt1 = new SimpleDateFormat("dd.MM.yyyy");
			dto.setDatum(dt1.format(dd.getDatum()));
			dto.setProfesor(dd.getProfesor().getImePriimek());
			dto.setProgram(dd.getProgram().getVrsta());
			dto.setVrstaStudija(dd.getVrstastudija().getVrsta());
			dto.setZavod(dd.getZavod().getZavod());
			dto.setNaslov(dd.getNaslov());
			dto.setDijak(dd.getPriimekIme());
			dto.setId(dd.getId());
			listToReturn.add(dto);
		}

		return listToReturn;
	}

	public int updateDiplomskoDeloById(DiplomskoDeloDTO dto) {
		Integer id = dto.getId();
		String datum = dto.getDatum();
		String naslov = dto.getNaslov();
		String profesor = dto.getProfesor();
		String vrstaStudija = dto.getVrstaStudija();
		String zavod = dto.getZavod();

		DiplomskaDela dd = em.find(DiplomskaDela.class, id);

		if (datum != null) {
			SimpleDateFormat dt1 = new SimpleDateFormat("dd.MM.yyyy");
			dto.setDatum(dt1.format(dd.getDatum()));
		}
		if (naslov != null) {
			dd.setNaslov(naslov);
		}
		if (profesor != null) {
			Profesor prof = (Profesor) em.createQuery("select p from Profesor p where p.imePriimek = :imePriimek")
					.setParameter("imePriimek", profesor).getSingleResult();
			dd.setProfesor(prof);
		}
		String program = dto.getProgram();
		if (program != null) {

			Program prog = (Program) em.createQuery("select p from Program p where p.vrsta = :vrsta")
					.setParameter("vrsta", program).getSingleResult();
			dd.setProgram(prog);
		}
		if (vrstaStudija != null) {
			VrstaStudija vs = (VrstaStudija) em.createQuery("select vs from VrstaStudija vs where vs.vrsta = :vrsta")
					.setParameter("vrsta", vrstaStudija).getSingleResult();
			dd.setVrstastudija(vs);
		}
		if (zavod != null) {
			Zavod z = (Zavod) em.createQuery("select z from Zavod z where z.zavod = :zavod")
					.setParameter("zavod", zavod).getSingleResult();
			dd.setZavod(z);
		}
		em.persist(dd);
		return dd.getId();
	}

	private void generatePDFDataXMLFile(List<DiplomskoDeloDTO> dtoList) throws IOException {

		LOGGER.log(Level.INFO, "WRITING TO PDF XML");

		String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
		xmlString += "<diplomskaDela>";

		int count = 0;
		for (DiplomskoDeloDTO dto : dtoList) {
			count++;
			xmlString += "<diplomskoDelo>";
			xmlString += String.format("<dijak>%s</dijak>", dto.getDijak());
			xmlString += String.format("<datum>%s</datum>", dto.getDatum());
			xmlString += String.format("<zavod>%s</zavod>", dto.getZavod());
			xmlString += String.format("<program>%s</program>", dto.getProgram());
			xmlString += String.format("<vrstaStudija>%s</vrstaStudija>", dto.getVrstaStudija());
			xmlString += String.format("<profesor>%s</profesor>", dto.getProfesor());
			xmlString += String.format("<naslov>%s</naslov>", dto.getNaslov());
			xmlString += "<id>" + count + "</id>";
			xmlString += "</diplomskoDelo>";
		}

		xmlString += "</diplomskaDela>";
//		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		String filePath = System.getProperty("jboss.home.dir") + "/fop/Employee.xml";
		File file = new File(filePath);
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(xmlString);
		bw.close();

	}

}

//public void saveAllDiplomskaDelaToDatabase(DiplomskoDeloExcelDTO dto) throws IOException {
//String vpisnaStevilka = dto.getVpisnaStevilka();
//DiplomskaDela dd = new DiplomskaDela();
//Profesor profesor = (Profesor) em.createQuery("select p from Profesor p where p.imePriimek = :imePriimek")
//		.setParameter("imePriimek", dto.getImeProf()).getSingleResult();
//
//String zavodStevilka = vpisnaStevilka.substring(0, 4).replaceFirst("^0+(?!$)", "");
//String programStevilka = vpisnaStevilka.substring(4, 7).replaceFirst("^0+(?!$)", "");
//String vrstaStudijaStevilka = vpisnaStevilka.substring(7, 8).replaceFirst("^0+(?!$)", "");
//Program program = getProgram(programStevilka);
//Zavod zavod = getZavod(zavodStevilka);
//VrstaStudija vrstaStudija = getVrstaStudija(vrstaStudijaStevilka);
//
//dd.setPriimekIme(dto.getImeDijaka());
//dd.setNaslov(dto.getImeDiplome());
//dd.setProfesor(profesor);
//dd.setZavod(zavod);
//dd.setVrstastudija(vrstaStudija);
//dd.setProgram(program);
//dd.setDatum(dto.getDatumDiplome());
//
//em.persist(dd);
//}
//
//private VrstaStudija getVrstaStudija(String vrstaStevilka) {
//VrstaStudija vrstaStudija = null;
//if (Integer.parseInt(vrstaStevilka) == VrstaStudijaEnumClass.VrstaStudijaEnum.REDNI.getNumVal()) {
//	return vrstaStudija = em.find(VrstaStudija.class,
//			VrstaStudijaEnumClass.getEnum(VrstaStudijaEnumClass.VrstaStudijaEnum.REDNI));
//} else if (Integer.parseInt(vrstaStevilka) == VrstaStudijaEnumClass.VrstaStudijaEnum.IZREDNI.getNumVal()) {
//	return vrstaStudija = em.find(VrstaStudija.class,
//			VrstaStudijaEnumClass.getEnum(VrstaStudijaEnumClass.VrstaStudijaEnum.IZREDNI));
//} else
//	return vrstaStudija;
//
//}
//
//private Zavod getZavod(String zavodStevilka) {
//Zavod zavod = null;
//if (Integer.parseInt(zavodStevilka) == ZavodEnumClass.ZavodEnum.SCKR.getNumVal()) {
//	return zavod = em.find(Zavod.class, ZavodEnumClass.getEnum(ZavodEnumClass.ZavodEnum.SCKR));
//} else if (Integer.parseInt(zavodStevilka) == ZavodEnumClass.ZavodEnum.TSCKR.getNumVal()) {
//	return zavod = em.find(Zavod.class, ZavodEnumClass.getEnum(ZavodEnumClass.ZavodEnum.TSCKR));
//} else if (Integer.parseInt(zavodStevilka) == ZavodEnumClass.ZavodEnum.ESIC.getNumVal()) {
//	return zavod = em.find(Zavod.class, ZavodEnumClass.getEnum(ZavodEnumClass.ZavodEnum.ESIC));
//} else
//	return zavod;
//}
//
//private Program getProgram(String programStevilka) {
//Program program = null;
//if (Integer.parseInt(programStevilka) == ProgramEnumClass.ProgramEnum.EKN.getNumVal()) {
//	return program = em.find(Program.class, ProgramEnumClass.getEnum(ProgramEnumClass.ProgramEnum.EKN));
//} else if (Integer.parseInt(programStevilka) == ProgramEnumClass.ProgramEnum.ENE.getNumVal()) {
//	return program = em.find(Program.class, ProgramEnumClass.getEnum(ProgramEnumClass.ProgramEnum.ENE));
//} else if (Integer.parseInt(programStevilka) == ProgramEnumClass.ProgramEnum.INF.getNumVal()) {
//	return program = em.find(Program.class, ProgramEnumClass.getEnum(ProgramEnumClass.ProgramEnum.INF));
//} else if (Integer.parseInt(programStevilka) == ProgramEnumClass.ProgramEnum.MEH.getNumVal()) {
//	return program = em.find(Program.class, ProgramEnumClass.getEnum(ProgramEnumClass.ProgramEnum.MEH));
//} else if (Integer.parseInt(programStevilka) == ProgramEnumClass.ProgramEnum.OSM.getNumVal()) {
//	return program = em.find(Program.class, ProgramEnumClass.getEnum(ProgramEnumClass.ProgramEnum.OSM));
//} else if (Integer.parseInt(programStevilka) == ProgramEnumClass.ProgramEnum.PS.getNumVal()) {
//	return program = em.find(Program.class, ProgramEnumClass.getEnum(ProgramEnumClass.ProgramEnum.PS));
//} else if (Integer.parseInt(programStevilka) == ProgramEnumClass.ProgramEnum.VAR.getNumVal()) {
//	return program = em.find(Program.class, ProgramEnumClass.getEnum(ProgramEnumClass.ProgramEnum.VAR));
//} else
//	return program;
//}