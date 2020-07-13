package rest;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("test2")
@Stateless
@RolesAllowed({"administrator"})
public class RestEndpoint2 {

	   @GET
	   @Path("book2")
	   public String getBook() {
		   return "test2";
	   }
}
