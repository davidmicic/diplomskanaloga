package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminGetDataTest
 */
@WebServlet("/getDataAdmin")
public class AdminGetDataTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@RolesAllowed({"administrator"})
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean yes = request.isUserInRole("administrator");
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<h1>" + "admin" + "</h1>");

	}

}
