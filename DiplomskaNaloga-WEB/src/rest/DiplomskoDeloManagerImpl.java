package rest;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.CheckboxesDTO;
import dto.DiplomskoDeloDTO;
import excel.DiplomskoDeloManagerBean;

@Path("diplomskaDela")
@Stateless
@Produces("application/json")
//@RolesAllowed({"administrator"})
public class DiplomskoDeloManagerImpl {

	@EJB
	DiplomskoDeloManagerBean ddmb;

	@GET
	@Path("all")
	public List<DiplomskoDeloDTO> getAllDiplomskaDela() throws ParseException {
		List<DiplomskoDeloDTO> listDto = ddmb.getAllDiplomskaDelaFromDatabase();
		return listDto;
	}

//	@GET
//	@Path("page/{pageNum}")
//	public List<DiplomskoDeloDTO> getDiplomskaDelaByPage(@PathParam("pageNum") int page) throws ParseException {
//		List<DiplomskoDeloDTO> listDto = ddmb.getDiplomskaDelaByPage(page);
//		return listDto;
//	}

	@POST
	@Path("count")
	public int getCountDiplomskaDela(String str) {
		JSONObject obj = new JSONObject(str);
		CheckboxesDTO dto = new CheckboxesDTO(); 
		if(obj != null ) {
			JSONObject objSel = obj.getJSONObject("selectedCheckboxes");
			JSONArray keys = objSel.names();
			dto = calculateDTO(objSel, keys);
		}
		
		int count = ddmb.getCountDiplomskaDela(dto);
		return count;
	}

	private CheckboxesDTO calculateDTO(JSONObject objSel, JSONArray keys) {
		CheckboxesDTO dto = new CheckboxesDTO();
		for(Object key : keys) {
			switch(key.toString()) {
			case "REDNI":  dto.setRedni(objSel.getBoolean("REDNI"));
			case "IZREDNI":  dto.setIzredni(objSel.getBoolean("IZREDNI"));
			case "MEH":  dto.setMeh(objSel.getBoolean("MEH"));
			case "ENE":  dto.setEne(objSel.getBoolean("ENE"));
			case "VAR":  dto.setVar(objSel.getBoolean("VAR"));
			case "INF":  dto.setInf(objSel.getBoolean("INF"));
			case "OSM":  dto.setOsm(objSel.getBoolean("OSM"));
			case "PS":  dto.setPs(objSel.getBoolean("PS"));
			case "EKN":  dto.setEkn(objSel.getBoolean("EKN"));
			case "SCKR":  dto.setSolskiCenterKranj(objSel.getBoolean("SCKR"));
			case "TSCKR":  dto.setTehniskiSolskiCenterKranj(objSel.getBoolean("TSCKR"));
			case "ESIC":  dto.setEsic(objSel.getBoolean("ESIC"));
			case "YEAR": dto.setYear(objSel.getString("YEAR"));
			}
		}
		
		return dto;
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
	public List<DiplomskoDeloDTO> getFilteredData(String str ) throws ParseException {
		JSONObject obj = new JSONObject(str);
		int page = obj.getInt("page");
		CheckboxesDTO dto = new CheckboxesDTO(); 
		if(obj != null ) {
			JSONObject objSel = obj.getJSONObject("selectedCheckboxes");
			JSONArray keys = objSel.names();
			dto = calculateDTO(objSel, keys);
		}
		
		List<DiplomskoDeloDTO> listDto = ddmb.getDiplomskaDelaByPage(dto, page);
		return listDto;
	}
}
