package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import driver.DriverManager;
import enums.SortValue;
import enums.WaitType;
import pages.pagecomponents.HamburerMenuComponents;
import utils.SeleniumUtils;

public class ProductsPage {

	private HamburerMenuComponents hamburgerMenuOptions;

	private static final By BTN_ADDTOCART = By.xpath("//button[text()='Add to cart']");
	private static final By BTN_HAMBURGERMENU = By.id("react-burger-menu-btn");
	private static final By LNK_SHOPPINGCART = By.cssSelector("a.shopping_cart_link");
	private static final By SHOPPING_CART_BADGE = By.xpath("//a[@class='shopping_cart_link']/span");
	private static final By DRPDWN_NAME = By.xpath("//select[@class='product_sort_container']");

	public ProductsPage() {

		hamburgerMenuOptions = new HamburerMenuComponents(); // composition concept as Products page contains hamburger
																// menu
	}

	public void clickAddToCart() {
//		DriverManager.getDriver().findElement(BTN_ADDTOCART).click();
		SeleniumUtils.click(BTN_ADDTOCART, WaitType.CLICKABLE, "Add to cart button");
	}

	public void addAllItemsToCart() {

		List<WebElement> buttons = DriverManager.getDriver().findElements(BTN_ADDTOCART);
		for (WebElement button : buttons) {
			button.click();
		}
	}

	public void addSpecificItemToCart(String itemName) {

		SeleniumUtils.click(
				By.xpath("//div[@class='inventory_item_description']/div/a/div[text()='"+itemName+"']/../../following-sibling::div/button[text()='Add to cart']"),
				WaitType.CLICKABLE, "Add to cart button");

	}

	public void clickHamburgerMenu() {
		DriverManager.getDriver().findElement(BTN_HAMBURGERMENU).click();
	}

	public void clickOnLogout() {
		hamburgerMenuOptions.clickLogout();
	}

	public void clickOnShoppingCart() {
		SeleniumUtils.click(LNK_SHOPPINGCART, "Shopping Cart link");
	}

	public int getNoOfItemsAddedToCart() {
		String count = DriverManager.getDriver().findElement(SHOPPING_CART_BADGE).getText();
//		Integer.parseInt(count);
		@SuppressWarnings("removal")
		Integer num = new Integer(count);
		return num;

	}

	public void sortItems(SortValue sortValue) {
		Select select = new Select(DriverManager.getDriver().findElement(DRPDWN_NAME));

		if (sortValue == SortValue.NAME_A_TO_Z) {
			select.selectByVisibleText("Name (A to Z)");
		} else if (sortValue == SortValue.NAME_Z_TO_A) {
			select.selectByVisibleText("Name (Z to A)");
		} else if (sortValue == SortValue.PRICE_LOW_TO_HIGH) {
			select.selectByVisibleText("Price (low to high)");
		} else if (sortValue == SortValue.PRICE_HIGH_TO_LOW) {
			select.selectByVisibleText("Price (high to low)");
		}
	}

}
