package pages;

import org.openqa.selenium.By;

import driver.DriverManager;
import enums.WaitType;
import utils.SeleniumUtils;

public class LoginPage {

	private static final By TXTBOX_USERNAME = By.id("user-name");
	private static final By TXTBOX_PASSWORD = By.id("password");
	private static final By BTN_LOGIN = By.id("login-button");
	private static final By TXT_ERROR = By.xpath("//div[contains(@class,'error-message')]/h3");

	private LoginPage setUsername(String username) {
		SeleniumUtils.sendKeys(TXTBOX_USERNAME, username, "Username");
		return this;
	}

	private LoginPage setPassword(String password) {
		SeleniumUtils.sendKeys(TXTBOX_PASSWORD, password, "Password");
		return this;
	}

	private ProductsPage login() {
		SeleniumUtils.click(BTN_LOGIN, WaitType.CLICKABLE, "Login Button");
		return new ProductsPage();
	}

	public String getErrorMessage() {
		return DriverManager.getDriver().findElement(TXT_ERROR).getText();
	}

	public ProductsPage performLogin(String username, String password) {
		return setUsername(username).setPassword(password).login();
	}

}
