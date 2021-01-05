package servlet;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopConfParser;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.FopFactoryBuilder;
import org.apache.fop.apps.MimeConstants;

import server.DiplomskoDeloManagerBean;

//https://www.netjstech.com/2015/07/how-to-create-pdf-from-xml-using-apache-fop.html#:~:text=To%20produce%20a%20PDF%20file,it%20to%20a%20PDF%20document. //source code

//https://pages.lip6.fr/Jean-Francois.Perrot/XML-Int/Session6/FOPFonts/index.html config file

//https://www.mulberrytech.com/papers/Intro2XSL-FO/Intro2XSL-FO.pdf xslt object description

/**
 * Servlet implementation class PDFServlet
 */
@WebServlet("servlet/DiplomskaDela")
public class PDFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	DiplomskoDeloManagerBean diplomskoDeloManagerBean;
	
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{

        	diplomskoDeloManagerBean.getAllDiplomskaDela();
        	
        	String configPath = System.getProperty("jboss.home.dir") + "\\fop\\config.xml";
			String templatePath = System.getProperty("jboss.home.dir") + "\\fop\\template.xsl";
			String filePath = System.getProperty("jboss.home.dir") + "\\fop\\Employee.xml";

        	File xconf = new File(configPath); 
        	FopConfParser parser = new FopConfParser(xconf); //parsing configuration  
        	FopFactoryBuilder builder = parser.getFopFactoryBuilder(); //building the factory with the user options
        	FopFactory fopFactory = builder.build();
        	
//        	FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        	
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(templatePath));
            Result res = new SAXResult(fop.getDefaultHandler());

            Source xmlStream = new StreamSource(new File(filePath));
//            JAXBContext context = JAXBContext.newInstance(DiplomskaDelaDTO.class);
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            StringWriter sw = new StringWriter();
//            marshaller.marshal(dtoList, sw);
//            String xmlString = sw.toString();
//            StreamSource xmlStream = new StreamSource(new StringReader(xmlString));

            transformer.transform(xmlStream, res);
            //Prepare response
            response.setContentType("application/pdf");
            response.setContentLength(out.size());
            //Send content to Browser
            response.getOutputStream().write(out.toByteArray());
            response.getOutputStream().flush();   
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
