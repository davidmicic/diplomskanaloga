package rest;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("test")
@Stateless
@RolesAllowed({"administrator"})
public class RestEndpoint {

	   @GET
	   @Path("book")
	   public String getBook() {
		   return "test";
	   }
}
