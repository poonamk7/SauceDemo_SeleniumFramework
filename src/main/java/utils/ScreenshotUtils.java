package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.DriverManager;

public final class ScreenshotUtils {
	
	private ScreenshotUtils() {}
	
	public static String getScreenshot() {
		
		TakesScreenshot screenshot  =(TakesScreenshot)DriverManager.getDriver();
		return screenshot.getScreenshotAs(OutputType.BASE64);
		
	}

}
