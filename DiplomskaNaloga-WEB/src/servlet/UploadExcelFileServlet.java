package servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UploadExcelFileServlet
 */
@WebServlet("/UploadExcelFileServlet")
public class UploadExcelFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			boolean userInRole = request.isUserInRole("administrator");
			if (userInRole) {
				InputStream is = null;
				
//				if (ServletFileUpload.isMultipartContent(request)) {
//				    ServletFileUpload fileUpload = new ServletFileUpload();
//				    FileItemIterator items = fileUpload.getItemIterator(request);
//				    // iterate items
//				    while (items.hasNext()) {
//				        FileItemStream item = items.next();
//				        if (!item.isFormField()) {
//				            is = item.openStream();
//				        }
//				    }
//				}
				
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("User not logged " + e);
			response.setStatus(401);
		}
	}

}
