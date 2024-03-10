package reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
	
	private ExtentManager() {}
	
	private static final ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();

	//default access modifier to restrict from using all logging methods and allow only custom methods from ExtentLogger class 
	static ExtentTest getExtentTest() {
		return threadLocal.get();
	}
	
	static void setExtentTest(ExtentTest extentTest) {
		threadLocal.set(extentTest);
	}
}
