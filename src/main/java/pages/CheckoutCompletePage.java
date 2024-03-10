package pages;

import org.openqa.selenium.By;

import driver.DriverManager;
import enums.WaitType;
import utils.SeleniumUtils;

public class CheckoutCompletePage {

	private static final By BTN_BACKHOME = By.id("back-to-products");
	private static final By MSG_ORDERPLACED = By.xpath("//h2[contains(@class,'header')]");
	private static final By MSG_ORDERDISPATCHED = By.cssSelector("div.complete-text");

	public void clickOnBackHome() {
		SeleniumUtils.click(BTN_BACKHOME, WaitType.CLICKABLE, "Back Home button");
	}

	public String getOrderplacedtext() {
		return DriverManager.getDriver().findElement(MSG_ORDERPLACED).getText();
	}

	public String getOrderDispatchedtext() {
		return DriverManager.getDriver().findElement(MSG_ORDERDISPATCHED).getText();
	}

}
