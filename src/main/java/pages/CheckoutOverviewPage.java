package pages;

import org.openqa.selenium.By;

import enums.WaitType;
import utils.SeleniumUtils;

public class CheckoutOverviewPage {
	
	private static final By BTN_FINISH = By.cssSelector("button#finish");
	private static final By BTN_CANCEL = By.cssSelector("button#cancel");
	
	public void clickOnFinish() {
		SeleniumUtils.click(BTN_FINISH, WaitType.CLICKABLE, "Finish button");
	}
	
	public void clickOnCancel() {
		SeleniumUtils.click(BTN_CANCEL, WaitType.CLICKABLE, "Cancel button");
	}

}
