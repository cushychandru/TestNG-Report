package report_genarator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlWriter {
	final static String	filepathFailedSuit	= "Report\\Failed_Test_Suite.xml";
	final static String	filepathJSON	= "Report\\data\\datafile.js";
	
	
	public static void FailedSuitWriter(String _class) throws Exception {

		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepathFailedSuit);
			doc.normalize();
			Element testcases = null;
			NodeList testSuit = doc.getElementsByTagName("classes");
			testcases = (Element) testSuit.item(0);
            Element testcase = doc.createElement("class");
            testcase.setAttribute("name", _class);
            testcases.appendChild(testcase);
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			StreamResult result = new StreamResult(new File(filepathFailedSuit));
			DOMSource source = new DOMSource(doc);
			transformer.transform(source, result);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
	}
	
	public static void Create() {
		try {
			File dir = new File("Report");
			dir.mkdirs();
			File dir1 = new File("Report\\data");
			dir1.mkdirs();
			FileWriter fw = new FileWriter(filepathFailedSuit);
			fw.write("<?xml version = \"1.0\" encoding = \"UTF-8\"?>\n<!-- <!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\">-->\n<suite name=\"selenium_suit\" verbose=\"10\">\n\t<listeners>\n\t\t<listener class-name=\"report_genarator.Listener\"></listener>\n\t</listeners>\n\t<test name=\"selenium_test\" preserve-order=\"true\"> \n\t\t<classes>\n\t\t</classes>\n\t</test>\n</suite>");
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
	public static void JSON_report(String report){
		try {
			FileWriter fw = new FileWriter(filepathJSON);
			fw.write("var data = "+report+";");
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}