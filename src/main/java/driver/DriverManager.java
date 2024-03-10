package driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	
	private DriverManager() {

	}
	
	
	private static final ThreadLocal<WebDriver> threadlocal = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return threadlocal.get();
	}
	
	public static void setDriver(WebDriver driver) {
		threadlocal.set(driver);
	}

}
