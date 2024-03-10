package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.DriverManager;
import enums.WaitType;
import utils.SeleniumUtils;

public class YourCartPage {

	private static final By BTN_CONTINUESHOPPING = By.cssSelector("button#continue-shopping");
	private static final By BTN_CHCKOUT = By.cssSelector("button#checkout");
	private static final By BTN_REMOVE = By.xpath("//button[text()='Remove']");
	private static final By CART_ITEM = By.xpath("//div[@class='cart_item_label']");

	public void clickOnRemove() {
		SeleniumUtils.click(BTN_REMOVE, WaitType.CLICKABLE, "Remove button");
	}

	public void clickOnCheckout() {
		SeleniumUtils.click(BTN_CHCKOUT, WaitType.CLICKABLE, "Checkout button");
	}

	public void clickOnContinueShopping() {
		SeleniumUtils.click(BTN_CONTINUESHOPPING, WaitType.CLICKABLE, "Continue Shopping button");
	}

	public int getCountOfItemsAdded() {
		List<WebElement> count = DriverManager.getDriver().findElements(CART_ITEM);
		return count.size();
	}

	public void removeAllItems() {
		List<WebElement> removeButtons = DriverManager.getDriver().findElements(BTN_REMOVE);
		for (WebElement remove : removeButtons) {
			remove.click();

		}
	}

}
