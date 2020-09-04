package report_genarator;

import java.awt.Desktop;
import java.io.File;
import java.util.Date;
import java.util.HashSet;

import org.openqa.selenium.WebDriver;

import com.google.gson.Gson;

public class Reporter {
	static private String _time = "";
	static private String _class = "";
	static private String _method = "";
	static private Date d1;
	static private Date d2;
	static private int no_of_test = 1;
	static private boolean reportDisplay = false;
	static private String excepetion = "--";
	private static String status;
	HashSet<String> faildClasses = new HashSet<String>();

	/**
	 *  Set up for new suit run 
	 */
	public static void suiteStart() {
		ZipUtils.CreateBackUpReoprt();
		Files file = new Files();
		Files.createDir();
		try {
			file.writeFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	/**
	 * call each time before a test will be invoked
	 */
	public static void testStart() {
		d1 = new Date();
		if (no_of_test == 1) {
			suiteStart();
		}
	}

	/**
	 * call when each test case pass.
	 *
	 * @param moduleName the module name
	 * @param testCaseID the test case ID
	 */
	public static void onTestPass(String moduleName, String testCaseID) {
		d2 = new Date();
		long sec = 0;
		try {
			sec = (d2.getTime() - d1.getTime());
		} catch (Exception e) {
		}
		_time = String.valueOf(sec);
		status = "SUCCESS";
		_class = moduleName;
		_method = testCaseID;
		ReportWriter();
	}

	/**
	 * call when each test case failed.
	 *
	 * @param moduleName the module name
	 * @param testCaseID the test case ID
	 * @param exceptionDetails the exception details
	 * @throws Exception 
	 */
	public static void onTestFailed(String moduleName, String testCaseID, String exceptionDetails)  {
		Files.takeSnapShot(no_of_test);
		d2 = new Date();
		long sec = 0;
		try {
			sec = (d2.getTime() - d1.getTime());
		} catch (Exception e) {
			// TODO: handle exception
		}
		_time = String.valueOf(sec);
		status = "FAILED";
		_class = moduleName;
		_method = testCaseID;
		excepetion = exceptionDetails;
		ReportWriter();
	}

	/**
	 * On test failed with exception.
	 *
	 * @param moduleName the module name
	 * @param testCaseID the test case ID
	 * @param exception the exception
	 * @throws Exception the exception
	 */
	public static void onTestFailedWithException(String moduleName, String testCaseID, Exception exception) {
		Files.takeSnapShot(no_of_test);
		d2 = new Date();
		long sec = 0;
		try {
			sec = (d2.getTime() - d1.getTime());
		} catch (Exception ex) {
		}
		_time = String.valueOf(sec);
		status = "FAILED";
		_class = moduleName;
		_method = testCaseID;
		excepetion = exception.getMessage();
		ReportWriter();
	}
	

	/**
	 * On test failed with throwable.
	 *
	 * @param moduleName the module name
	 * @param testCaseID the test case ID
	 * @param throwable the throwable
	 * @throws Exception the exception
	 */
	public static void onTestFailedWithThrowable(String moduleName, String testCaseID, Throwable throwable){
		Files.takeSnapShot(no_of_test);
		d2 = new Date();
		long sec = 0;
		try {
			sec = (d2.getTime() - d1.getTime());
		} catch (Exception ex) {
		}
		_time = String.valueOf(sec);
		status = "FAILED";
		_class = moduleName;
		_method = testCaseID;
		excepetion = throwable.getMessage();
		ReportWriter();
	}

	/**
	 * call when each test case skipped.
	 *
	 * @param moduleName the module name
	 * @param testCaseID the test case ID
	 */
	public static void onTestSkiped(String moduleName, String testCaseID) {
		status = "SKIPED";
		_class = moduleName;
		_method = testCaseID;
		_time = "0";
		ReportWriter();
	}

	/**
	 * Sets the web driver.
	 *
	 * @param driver the new web driver
	 */
	public static void setWebDriver(WebDriver driver) {
		Files.webdriver = driver;
	}

	/**
	 * Report writer.
	 */
	static private void ReportWriter() {
		try {
			Report repo = new Report(String.valueOf(no_of_test), _class, _method, _time, status, excepetion);
			Report.report.add(repo);
			Files.JSON_report(new Gson().toJson(Report.report));
			// open document in default browser
			if (!reportDisplay) {
				File htmlFile = new File("Report/Report.html");
				Desktop.getDesktop().browse(htmlFile.toURI());
				reportDisplay = !reportDisplay;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		no_of_test++;
	}

}
