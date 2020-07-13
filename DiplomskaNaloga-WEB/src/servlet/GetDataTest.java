package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/getDataTest")
//@DeclareRoles("administrator")
public class GetDataTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message;

//	@EJB
//	CityManagerBean cmb;

//	@Resource
//	private WebServiceContext context;

	public void init() throws ServletException {
		message = "Hello World";
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		cmb.getCities();
//		boolean isInRole = context.getContext().isUserInRole("administrator");
		boolean isInRole = request.isUserInRole("administrator");

		if (isInRole) {
			response.setContentType("text/html");

			PrintWriter out = response.getWriter();
			out.println("<h1>" + message + "</h1>");
		} else {
			response.setStatus(405);
		}
	}
}
