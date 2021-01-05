package rest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import dto.DiplomskoDeloDTO;
import dto.DiplomskoDeloExcel2DTO;
import dto.DiplomskoDeloExcelDTO;
import dto.FilterPagesDTO;
import dto.SearchListDTO;
import server.AManager;
import server.DiplomskoDeloManagerBean;

@Path("diplomskaDela")
@Stateless
@Produces("application/json")
public class DiplomskoDeloServiceImpl extends AManager{

	@EJB
	private DiplomskoDeloManagerBean ddmb;
	
//	private @Context SecurityContext securityContext;

	@POST
	@Path("count")
	public int getAllDiplomskaDela(FilterPagesDTO dto) throws ParseException {
		int size = ddmb.getDiplomskaDelaCount(dto.getPrograms(),dto.getZavods(),  dto.getVrste(), dto.getProfesors(), dto.getLeto());
		return size;
	}

	@GET
	@Path("leto")
	public List<Date> getLetaDiplomskaDela() throws ParseException {
		List<Date> datumi = ddmb.getDiplomskaDelaLetoIzdelave();
		return datumi;
	}
	
	@POST
	@Path("filter")
	@Consumes("application/json")
	public List<DiplomskoDeloDTO> getFilteredData(FilterPagesDTO dto) throws ParseException {
		List<DiplomskoDeloDTO> listDto = ddmb.getDiplomskaDelaByPage(dto.getPrograms(),dto.getZavods(),  dto.getVrste(), dto.getProfesors(), dto.getLeto(), dto.getPage());
		return listDto;
	}
	
	@POST
	@Path("search")
	@Consumes("text/html")
	public SearchListDTO getSearch(String search) throws ParseException {
		List<String> searchStrings = ddmb.search(search);
		SearchListDTO dto = new SearchListDTO();
		dto.setStrings(searchStrings);
		return dto;
	}
	
	@POST
	@Path("getDiplomskoDeloByIme")
	@Consumes("text/html")
	public List<DiplomskoDeloDTO> getDiplomskoDelo(String imePriimek) throws ParseException {
		List<DiplomskoDeloDTO> dipl = ddmb.getDiplomskoDeloByName(imePriimek);
		return dipl;
	}
	
	@POST
	@Path("saveDiplomskoDeloById")
	@Consumes("application/json")
	public int saveDiplomskoDeloById(DiplomskoDeloDTO dto) throws ParseException {
		int id = ddmb.updateDiplomskoDeloById(dto);
		return id;
	}
	
	@POST
	@Path("addDiplomskoDelo")
	@Consumes("application/json")
	public void addDiplomskoDelo(DiplomskoDeloExcel2DTO dto) throws ParseException, IOException {
		DiplomskoDeloExcelDTO d = new DiplomskoDeloExcelDTO();
		d.setDatumDiplome(new SimpleDateFormat("dd/MM/yyyy").parse(dto.getDatumDiplome()));
		d.setImeDijaka(dto.getImeDijaka());
		d.setImeDiplome(dto.getImeDiplome());
		d.setImeProf(dto.getImeProf());
		d.setVpisnaStevilka(dto.getVpisnaStevilka());
		ddmb.saveAllDiplomskaDelaToDatabaseTEST(d);
	}
}
