package report_genarator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;


/**
 * @author Chandrashekhar G
 * 
 */
public class Files {

	Properties	prop	= new Properties();
	
	public void writeFile() throws IOException, PropertiesFileNotFound{
		getProperties();
		readFromJARFile("Chart.min.js", "Report//data//Chart.min.js");
		readFromJARFile("Chart.PieceLabel.js", "Report//data//Chart.PieceLabel.js");
		readFromJARFile("report.css", "Report//data//report.css");
		readFromJARFile("report.js", "Report//data//report.js");
		readFromJARFile("sortable.css", "Report//data//sortable.css");
		readFromJARFile("sortable.js", "Report//data//sortable.js");
		readFromJARFile("Report.html", "Report//Report.html");
		writeStyle();
	}

	public void readFromJARFile(String filename, String dest) throws IOException {
		InputStream is = getClass().getResourceAsStream(filename);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		File f = new File(dest);
		FileWriter fr = new FileWriter(f);
		BufferedWriter writer = new BufferedWriter(fr);
		String line;
		while ((line = br.readLine()) != null) {
			writer.write(line);
			writer.newLine();
		}
		br.close();
		writer.close();
		isr.close();
		fr.close();
		is.close();
	}

	public void getProperties() {
		
		try {
			URL url = ClassLoader.getSystemResource("report.properties");
			prop.load(url.openStream());
		} catch (Exception e) {			
			try {
				writeProperties();
				throw new PropertiesFileNotFound("Properties File Not Found in Source location\nPlease download , customize and add in source folder");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public void writeProperties() throws IOException {
		
		prop.setProperty("background-color", "white");
		prop.setProperty("report-title-background", "white");
		prop.setProperty("report-title", "Selenium Testing Result");
		prop.setProperty("title-fontsize", "50px");
		prop.setProperty("title-color", "black");
		prop.setProperty("footer-background", "white");
		prop.setProperty("footer-text", "@testNG");
		prop.setProperty("footer-fontsize", "20px");
		prop.setProperty("footer-color", "black");		
		
	}
	
	public void writeStyle() throws IOException {
		try {
			FileWriter fw = new FileWriter("Report//data//reportStyle.js");
			fw.write("document.getElementById('main_table').style.backgroundColor = '"+prop.getProperty("background-color")+"';document.getElementById('AplicationDetails').style.backgroundColor = '"+prop.getProperty("report-title-background")+"';document.getElementById('AplicationDetails').innerHTML = '"+prop.getProperty("report-title")+"';document.getElementById('AplicationDetails').style.fontSize = '"+prop.getProperty("title-fontsize")+"';document.getElementById('AplicationDetails').style.color = '"+prop.getProperty("title-color")+"';document.getElementById('footer').style.backgroundColor = '"+prop.getProperty("footer-background")+"';document.getElementById('footer').innerHTML = '"+prop.getProperty("footer-text")+"';document.getElementById('footer').style.fontSize = '"+prop.getProperty("footer-fontsize")+"';document.getElementById('footer').style.color = '"+prop.getProperty("footer-color")+"';");
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
}
@SuppressWarnings("serial")
class PropertiesFileNotFound extends Exception {
	 
    public PropertiesFileNotFound(String message) {
        super(message);
    }
}