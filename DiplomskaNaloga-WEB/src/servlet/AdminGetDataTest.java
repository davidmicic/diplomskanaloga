package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotAllowedException;

/**
 * Servlet implementation class AdminGetDataTest
 */
@WebServlet("/getDataAdmin")
public class AdminGetDataTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			boolean userInRole = request.isUserInRole("administrator");
			if (userInRole) {
				response.setContentType("text/html");

				PrintWriter out = response.getWriter();
				out.println("<h1>" + "admin" + "</h1>");
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("User not logged " + e);
			response.setStatus(401);
		}

	}

}
