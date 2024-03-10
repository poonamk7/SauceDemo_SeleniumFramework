package pages;

import org.openqa.selenium.By;

import com.github.javafaker.Faker;

import driver.DriverManager;
import enums.WaitType;
import utils.SeleniumUtils;

public class CheckoutYourInformationPage {

	private static final By TXT_FIRSTNAME = By.id("first-name");
	private static final By TXT_LASTNAME = By.id("last-name");
	private static final By TXT_POSTALCODE = By.id("postal-code");
	private static final By BT_CONTINUE = By.cssSelector("input#continue");
	private static final By BTN_CANCEL = By.cssSelector("button#cancel");
	private static final By MSG_ERROR = By.xpath("//div[contains(@class,'error-message')]/h3");

	Faker faker;

	public CheckoutYourInformationPage() {
		faker = new Faker();
	}

	public void enterFirstname() {
		SeleniumUtils.sendKeys(TXT_FIRSTNAME, faker.name().firstName(), "firstname");
	}

	public void enterLastname() {
		SeleniumUtils.sendKeys(TXT_LASTNAME, faker.name().lastName(), "lastname");
	}

	public void enterPostalcode() {
		SeleniumUtils.sendKeys(TXT_POSTALCODE, faker.address().zipCode(), "postal code");
	}

	public void clickOnCotinue() {
		SeleniumUtils.click(BT_CONTINUE, WaitType.CLICKABLE, "Continue button");
	}

	public void clickOnCancel() {
		SeleniumUtils.click(BTN_CANCEL, WaitType.CLICKABLE, "Cancel button");
	}

	public void performContinue() {
		enterFirstname();
		enterLastname();
		enterPostalcode();
		clickOnCotinue();
	}

	public String getErrorMessage() {
		return DriverManager.getDriver().findElement(MSG_ERROR).getText();
	}

}
