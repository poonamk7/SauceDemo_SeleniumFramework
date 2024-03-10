package com.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import annotations.FrameworkAnnotation;
import driver.DriverManager;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutYourInformationPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;
import utils.ExcelUtils;

public class LoginForErrorUserTest extends BaseTest {

	List<String> login;

	@FrameworkAnnotation(author = "Poonam")
	@Test(description = "To validate login functionality for Error user")
	public void loginForErrorUserTest() {

		try {
			login = ExcelUtils.readData("loginForErrorUserTest"); // pass test case name as an argument so that data
																	// would be fetched from excel based on test case
																	// name
		} catch (Exception e) {
			e.printStackTrace();
		}

		LoginPage loginPage = new LoginPage();
		loginPage.performLogin(login.get(0), login.get(1));

		Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(), login.get(4), "Incorrect URL");

		ProductsPage productsPage = new ProductsPage();
		productsPage.addSpecificItemToCart(login.get(2)); // to get product name from testdata excel using column index
		productsPage.clickOnShoppingCart();

		YourCartPage cartPage = new YourCartPage();
		cartPage.clickOnCheckout();

		CheckoutYourInformationPage informationPage = new CheckoutYourInformationPage();
		informationPage.performContinue();

		CheckoutOverviewPage overviewPage = new CheckoutOverviewPage();
		overviewPage.clickOnFinish();

		CheckoutCompletePage completePage = new CheckoutCompletePage();
		completePage.clickOnBackHome();
		
		productsPage.clickHamburgerMenu();
		productsPage.clickOnLogout();

	}

}
