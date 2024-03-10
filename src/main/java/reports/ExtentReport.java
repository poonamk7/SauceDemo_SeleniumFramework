package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.FrameworkConstants;

public final class ExtentReport {

	private ExtentReport() {
	}

	static ExtentReports extentReports;
	static ExtentTest extentTest;

	public static void initReports() {

		extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FrameworkConstants.getReportPath());
		extentReports.attachReporter(sparkReporter);

	}

	public static void flushReports() {
		extentReports.flush();
	}

	public static void createTest(String testCaseName) {
		extentTest = extentReports.createTest(testCaseName);
		ExtentManager.setExtentTest(extentTest);
	}

	public static void assignAthor(String author) {
		ExtentManager.getExtentTest().assignAuthor(author);
	}

}
