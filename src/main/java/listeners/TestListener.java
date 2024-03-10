package listeners;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import annotations.FrameworkAnnotation;
import reports.ExtentLogger;
import reports.ExtentReport;

public class TestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getDescription());
		ExtentReport.assignAthor(result.getMethod()
				.getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getName()+" is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getName()+" is failed");
		ExtentLogger.fail(result.getThrowable().getMessage());
		ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentReport.initReports();
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReport.flushReports();
	}
	
	

}
