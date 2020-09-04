package report_genarator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author Chandrashekhar G
 * 
 */
class Files {

	static WebDriver webdriver = null;
	Properties prop = new Properties();
	final static String	filepathJSON	= "Report\\data\\datafile.js";

	/**
	 * Write all the files.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws PropertiesFileNotFound the properties file not found
	 */
	public void writeFile() throws IOException, PropertiesFileNotFound {
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

	/**
	 * Read from JAR file and write resource location.
	 *
	 * @param filename the filename
	 * @param dest the destination
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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

	/**
	 * Gets the properties.
	 *
	 * @return the properties
	 */
	public void getProperties() {

		try {
			URL url = ClassLoader.getSystemResource("report.properties");
			prop.load(url.openStream());
		} catch (Exception e) {
			try {
				writeProperties();
			//	throw new PropertiesFileNotFound(
				//		"Properties File Not Found in Source location\nPlease download , customize and add in source folder");
			System.err.println("Properties File Not Found in Source location\nPlease download , customize and add in source folder");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * Write properties.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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

	/**
	 * Write reportStyle.js using prop.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void writeStyle() throws IOException {
		try {
			FileWriter fw = new FileWriter("Report//data//reportStyle.js");
			fw.write("document.getElementById('main_table').style.backgroundColor = '"
					+ prop.getProperty("background-color")
					+ "';document.getElementById('AplicationDetails').style.backgroundColor = '"
					+ prop.getProperty("report-title-background")
					+ "';document.getElementById('AplicationDetails').innerHTML = '" + prop.getProperty("report-title")
					+ "';document.getElementById('AplicationDetails').style.fontSize = '"
					+ prop.getProperty("title-fontsize")
					+ "';document.getElementById('AplicationDetails').style.color = '" + prop.getProperty("title-color")
					+ "';document.getElementById('footer').style.backgroundColor = '"
					+ prop.getProperty("footer-background") + "';document.getElementById('footer').innerHTML = '"
					+ prop.getProperty("footer-text") + "';document.getElementById('footer').style.fontSize = '"
					+ prop.getProperty("footer-fontsize") + "';document.getElementById('footer').style.color = '"
					+ prop.getProperty("footer-color") + "';");
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * Take snap shot.
	 *
	 * @param count the count
	 * @throws Exception the exception
	 */
	public static void takeSnapShot(int count) {
		try {
			if(webdriver!=null){
			TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File("Report//screen_shot//" + count + ".png");
			java.nio.file.Files.copy(SrcFile.toPath(), DestFile.toPath());
		}} catch (Exception e) {
			System.out.println("********** Error While Taking Screen Shot ***********");
		}

	}

	/**
	 * Creates the directories.
	 */
	public static void createDir() {
		File dir = new File("Report");
		dir.mkdirs();
		File dir1 = new File("Report\\data");
		dir1.mkdirs();
		File dir2 = new File("Report\\screen_shot");
		dir2.mkdirs();
		final File[] files = dir2.listFiles();
		for (File f : files)
			f.delete();
	}
	
	/**
	 * JSON report write.
	 *
	 * @param report the report
	 */
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

@SuppressWarnings("serial")
class PropertiesFileNotFound extends Exception {

	/**
	 * Instantiates a new properties file not found.
	 *
	 * @param message the message
	 */
	public PropertiesFileNotFound(String message) {
		super(message);
	}

}
