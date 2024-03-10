package pages.pagecomponents;

import org.openqa.selenium.By;

import driver.DriverManager;
import enums.WaitType;
import utils.SeleniumUtils;

public class HamburerMenuComponents {
	
	private static final By LNK_ALLITEMS = By.id("inventory_sidebar_link");
	private static final By LNK_ABOUT = By.id("about_sidebar_link");
	private static final By LNK_LOGOUT = By.id("logout_sidebar_link");
	private static final By LNK_RESETAPPSTATE = By.id("reset_sidebar_link");
	
	public void clickAllItems() {
		DriverManager.getDriver().findElement(LNK_ALLITEMS).click();
	}
	
	public void clickAbout() {
		DriverManager.getDriver().findElement(LNK_ABOUT).click();
	}
	
	public void clickLogout() {
		SeleniumUtils.click(LNK_LOGOUT, WaitType.CLICKABLE, "Logout");
	}
	
	public void clickResetAppState() {
		DriverManager.getDriver().findElement(LNK_RESETAPPSTATE).click();
	}

}
