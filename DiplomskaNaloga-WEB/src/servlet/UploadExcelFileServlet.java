package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dto.DiplomskoDeloDTO;
import excel.ExcelManagerBean;

/**
 * Servlet implementation class UploadExcelFileServlet
 */
@WebServlet("/UploadExcelFileServlet")
@MultipartConfig
public class UploadExcelFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ExcelManagerBean emb;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
//			boolean userInRole = request.isUserInRole("administrator");
//			if (userInRole) {
			Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
			InputStream fileContent = filePart.getInputStream();
			XSSFWorkbook wb = new XSSFWorkbook(fileContent);
			int numberOfSheets = wb.getNumberOfSheets();
			DataFormatter df = new DataFormatter();
			for (int i = 0; i < numberOfSheets; i++) {
				XSSFSheet sheet = wb.getSheetAt(i);
				Iterator<Row> itr = sheet.iterator();
				while (itr.hasNext()) {
					Row row = itr.next();
					Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
					DiplomskoDeloDTO dto = new DiplomskoDeloDTO();
					int poljeVvrstici = 0;

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (poljeVvrstici) {
						case 1:
							dto.setImeDijaka(cell.getStringCellValue());
							break;
						case 2:
							dto.setImeDiplome(cell.getStringCellValue());
							break;
						case 3:
							dto.setDatumDiplome(cell.getDateCellValue());
							break;
						case 4:
							dto.setImeProf(cell.getStringCellValue());
							break;
						case 5:
							dto.setVpisnaStevilka(df.formatCellValue(cell));
							break;
						}
						poljeVvrstici++;
//							switch (cell.getCellType()) {
//							case STRING: // field that represents string cell type
//								System.out.print(cell.getStringCellValue() + "\t\t\t");
//								break;
//							case NUMERIC: // field that represents number cell type
//								System.out.print(cell.getNumericCellValue() + "\t\t\t");
//								break;
//							default:
//							}
					}
					emb.saveDataToDatabase(dto);
				}
			}
		} catch (Exception e) {
			System.out.println("User not logged " + e);
			response.setStatus(401);
		}
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

}
