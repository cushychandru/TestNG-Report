package report_genarator;

import java.awt.Desktop;
import java.io.File;
import java.util.Date;
import java.util.HashSet;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.google.gson.Gson;

public class Listener implements ITestListener, ISuiteListener, IInvokedMethodListener {

	static private String _time = "";
	static private String _class = "";
	static private String _method = "";
	static private Date d1;
	static private Date d2;
	static private int no_of_test = 1;
	static private boolean reportDisplay = false;
	HashSet<String> faildClasses = new HashSet<String>();

	/*
	 * This method is invoked before the SuiteRunner starts
	 * 
	 * @see org.testng.ISuiteListener#onStart(org.testng.ISuite)
	 */
	public void onStart(ISuite arg0) {
		ZipUtils.CreateBackUpReoprt();
		
		Files file = new Files();
		Files.createDir();
		XmlWriter.Create();
		try {
			file.writeFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * This method is invoked after the SuiteRunner has run all the test suites.
	 * 
	 * @see org.testng.ISuiteListener#onFinish(org.testng.ISuite)
	 */
	public void onFinish(ISuite arg0) {

	}

	/**
	 * Invoked after the test class is instantiated and before any configuration
	 * method is called.
	 * 
	 * @see org.testng.ITestListener#onStart(org.testng.ITestContext)
	 */
	public void onStart(ITestContext arg0) {

	}

	/*
	 * Invoked after all the tests have run and all their Configuration methods
	 * have been called.
	 * 
	 * @see org.testng.ITestListener#onFinish(org.testng.ITestContext)
	 */
	public void onFinish(ITestContext arg0) {

	}

	/*
	 * Invoked each time a test succeeds.
	 * 
	 * @see org.testng.ITestListener#onTestSuccess(org.testng.ITestResult)
	 */
	public void onTestSuccess(ITestResult arg0) {
		printTestResults(arg0);
	}

	/*
	 * Invoked each time a test fails.
	 * 
	 * @see org.testng.ITestListener#onTestFailure(org.testng.ITestResult)
	 */
	public void onTestFailure(ITestResult arg0) {
		printTestResults(arg0);
	}

	/*
	 * Invoked each time before a test will be invoked. The ITestResult is only
	 * partially filled with the references to class, method, start millis and
	 * status.
	 * 
	 * @see org.testng.ITestListener#onTestStart(org.testng.ITestResult)
	 */
	public void onTestStart(ITestResult arg0) {
		d1 = new Date();
	}

	public void onTestSkipped(ITestResult arg0) {
		printTestResults(arg0);
	}

	/**
	 * Prints the test results.
	 *
	 * @param result the result
	 */
	private void printTestResults(ITestResult result) {
		Files.takeSnapShot(no_of_test);
		_class = result.getTestClass().getName();
		d2 = new Date();
		long sec = 0;
		try{
			 sec = (d2.getTime() - d1.getTime());
		}catch (Exception e) {
			// TODO: handle exception
		}
		_time = String.valueOf(sec);

		String status = null;
		switch (result.getStatus()) {
		case ITestResult.SUCCESS:
			status = "SUCCESS";
			break;
		case ITestResult.FAILURE:
			status = "FAILED";
			break;
		case ITestResult.SKIP:
			status = "SKIPED";
		}

		String excepetion = "--";
		try {
			if (status.equals("FAILED") && result.getThrowable().getMessage() != null) {
				excepetion = "Error Explanation : " + result.getThrowable().getMessage().toString();
				if (excepetion.contains("Build info: version")) {
					excepetion = excepetion.substring(0, excepetion.indexOf("Build info: version"));
				}
				StackTraceElement[] excepetion2 = result.getThrowable().getStackTrace();
				for (int i = 0; i < excepetion2.length; i++) {
					if (excepetion2[i].getClassName().equalsIgnoreCase(_class)) {
						excepetion += "<br> Class Name :  " + _class + "<br> File Name :  "
								+ excepetion2[i].getFileName() + "<br> Error Line Number :  "
								+ excepetion2[i].getLineNumber();
					}
				}
				if (faildClasses.contains(_class) == false) {
					//Files.takeSnapShot(no_of_test);
					//XmlWriter.FailedSuitWriter(_class);
					faildClasses.add(_class);
				}
			} else if (status.equals("SKIPED") && result.getThrowable().getMessage() != null) {
				excepetion = result.getThrowable().getMessage();

				if (faildClasses.contains(_class) == false) {
					//Files.takeSnapShot(no_of_test);
					//XmlWriter.FailedSuitWriter(_class);
					faildClasses.add(_class);
				}
			} else if ((status.equals("FAILED") || status.equals("SKIPED")) && faildClasses.contains(_class) == false) {
				//Files.takeSnapShot(no_of_test);
				//XmlWriter.FailedSuitWriter(_class);
				faildClasses.add(_class);
			}
		} catch (Exception e) {
			try {
				//XmlWriter.FailedSuitWriter(_class);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			faildClasses.add(_class);
		}

		try {
			Report repo = new Report(String.valueOf(no_of_test), _class, _method, _time, status, excepetion);
			Report.report.add(repo);
			Files.JSON_report(new Gson().toJson(Report.report));
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

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {

	}

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		_method = returnMethodName(arg0.getTestMethod()) + getTestInputArguments(arg1);
		;
	}

	private String returnMethodName(ITestNGMethod method) {
		return method.getMethodName();
	}

	/*
	 * Invoked each time a method fails but has been annotated with
	 * successPercentage and this failure still keeps it within the success
	 * percentage requested
	 * 
	 * @see org.testng.ITestListener#onTestFailedButWithinSuccessPercentage(org.
	 * testng.ITestResult)
	 */
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	/**
	 * Gets the test input arguments.
	 *
	 * @param result the result
	 * @return the test input arguments
	 */
	private String getTestInputArguments(ITestResult result) {

		StringBuilder inputArguments = new StringBuilder();

		Object[] inputArgs = result.getParameters();
		inputArguments.append("(");
		if (inputArgs != null && inputArgs.length > 0) {
			for (Object inputArg : inputArgs) {
				if (inputArg == null) {
					inputArguments.append("null");
				} else {
					inputArguments.append(inputArg.toString());
				}
				inputArguments.append(", ");
			}
		}
		String arg = inputArguments.toString();
		if (arg.length() > 2) {
			arg = arg.substring(0, arg.length() - 2);
		}
		String args = arg + ")";
		return args;
	}

}