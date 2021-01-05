package rest;

import java.lang.reflect.Field;
import java.security.Principal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import dto.CatalogueDTO;
import dto.ProfesorDTO;
import dto.ProgramDTO;
import dto.VrstaStudijaDTO;
import dto.ZavodDTO;
import entities.Profesor;
import entities.Program;
import entities.Role;
import entities.VrstaStudija;
import entities.Zavod;
import server.AManager;
import server.ProfesorManagerBean;
import server.ProgramManagerBean;
import server.VrstaStudijaManagerBean;
import server.ZavodManagerBean;
import util.UserRoles;

@Path("catalogue")
@Stateless
@Produces("application/json")
public class CatalogueServiceImpl extends AManager {

	@EJB
	ProfesorManagerBean pmb;

	@EJB
	ZavodManagerBean zmb;

	@EJB
	ProgramManagerBean promb;

	@EJB
	VrstaStudijaManagerBean vmb;

	@GET
	@Path("getAll")
//	@RolesAllowed({ UserRoles.Admin.admin })
	public CatalogueDTO getCatalogue(@Context SecurityContext ctx) {
		CatalogueDTO dto = new CatalogueDTO();
		dto.setProfesor(profesorEntityToDTO(pmb.getAllProfesor()));
		dto.setProgram(programEntityToDto(promb.getAllPrograms()));
		dto.setZavod(zavodEntityToDTO(zmb.getAllZavod()));
		dto.setVrstaStudija(vrstaEntityToDTO(vmb.getAllVrstaStudija()));
		dto.setAllRoles(getAllRoles(ctx));

		Principal userPrincipal = ctx.getUserPrincipal();
		if (userPrincipal != null) {
			dto.setRoles(rolesForUser(ctx));
			dto.setUser(userPrincipal.getName());
		} else {
			dto.setRoles(null);
			dto.setUser(null);
		}

		return dto;
	}

	@SuppressWarnings("unchecked")
	@POST
	@Path("getAllRolesForUser")
	public List<String> getAllRolesForUser(String username) {
		Query query = em.createNativeQuery("select ime from role as r2 "
				+ "inner join uporabnik_role as ur on ur.id_role = r2.id " + "where ur.username = :username");
		query.setParameter("username", username);
		List<String> roles = query.getResultList();
		return roles;
	}

	public List<String> getAllRoles(@Context SecurityContext ctx) {
		Class<UserRoles> clazz = UserRoles.class;
		List<String> strings = new ArrayList<String>();
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field f : declaredFields) {
			f.setAccessible(true);
			String role = null;
			try {
				role = f.get(f).toString();
				strings.add(role);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return strings;
	}

	public List<String> rolesForUser(@Context SecurityContext ctx) {
		Class<UserRoles> clazz = UserRoles.class;
		List<String> strings = new ArrayList<String>();
//		for(Class c : classes) {
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field f : declaredFields) {
//				if(!f.isSynthetic()) {
			f.setAccessible(true);
			String role = null;
			try {
				role = f.get(f).toString();
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			if (ctx.isUserInRole(role)) {
				strings.add(role);
			}
//				}
		}
//		}
		return strings;
	}

	private List<ProfesorDTO> profesorEntityToDTO(List<Profesor> profesor) {
		List<ProfesorDTO> dtoList = new ArrayList<ProfesorDTO>();
		for (Profesor prof : profesor) {
			ProfesorDTO dto = new ProfesorDTO();
			dto.setId(prof.getId());
			dto.setCode(prof.getImePriimek());
			dtoList.add(dto);
		}
		return dtoList;
	}

	private List<ProgramDTO> programEntityToDto(List<Program> program) {
		List<ProgramDTO> dtoList = new ArrayList<ProgramDTO>();
		for (Program prog : program) {
			ProgramDTO dto = new ProgramDTO();
			dto.setId(prog.getId());
			dto.setCode(prog.getVrsta());
			dtoList.add(dto);
		}
		return dtoList;
	}

	private List<ZavodDTO> zavodEntityToDTO(List<Zavod> zavod) {
		List<ZavodDTO> dtoList = new ArrayList<ZavodDTO>();
		for (Zavod z : zavod) {
			ZavodDTO dto = new ZavodDTO();
			dto.setId(z.getId());
			dto.setCode(z.getZavod());
			dtoList.add(dto);
		}
		return dtoList;
	}

	private List<VrstaStudijaDTO> vrstaEntityToDTO(List<VrstaStudija> vrstaStudija) {
		List<VrstaStudijaDTO> dtoList = new ArrayList<VrstaStudijaDTO>();
		for (VrstaStudija vrsta : vrstaStudija) {
			VrstaStudijaDTO dto = new VrstaStudijaDTO();
			dto.setId(vrsta.getId());
			dto.setCode(vrsta.getVrsta());
			dtoList.add(dto);
		}
		return dtoList;
	}
}
