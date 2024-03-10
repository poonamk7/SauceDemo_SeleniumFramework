package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.ConfigFactory;

import driver.DriverManager;
import enums.WaitType;
import reports.ExtentLogger;

public class SeleniumUtils {
	
	public static void click(By by, String elementName) {

		WebElement element = waitUntilElementClickable(by);
		element.click();
		ExtentLogger.pass(elementName + " is clicked successfully");

	}
	
	public static void click(WebElement webElement) {
		webElement.click();
	}
	
	public static void click(By by, WaitType waitType, String element) {
		
		WebElement webElement = null;
		if(waitType == WaitType.PRESENCE) {
			webElement = waitUntilElementPresent(by);
		}
		else if(waitType == WaitType.CLICKABLE) {
			webElement = waitUntilElementClickable(by);
		}
		else if(waitType == WaitType.VISIBLE) {
			webElement = waitUntilElementToBeVisible(by);
		}
		webElement.click();
		ExtentLogger.pass(element+" is clicked successfully");
	}
	
	public static void sendKeys(By by, String value, String elementName) {
		
		WebElement element = waitUntilElementPresent(by);
		element.sendKeys(value);
		ExtentLogger.pass(value+" is entered successfully in "+elementName);	
	}
	
	public static WebElement waitUntilElementPresent(By by) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 
				Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public static WebElement waitUntilElementClickable(By by) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 
				Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
		
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public static WebElement waitUntilElementToBeVisible(By by) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 
				Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	

}
