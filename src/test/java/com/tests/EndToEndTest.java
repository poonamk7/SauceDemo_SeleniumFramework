package com.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import annotations.FrameworkAnnotation;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutYourInformationPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;
import utils.ExcelUtils;

public class EndToEndTest extends BaseTest {
	
	List<String> login;

	@FrameworkAnnotation(author = "Poonam")
	@Test(description = "Validate user is able to select a specific item and complete purchase via end to end flow")
	public void endToEndValidationTest() {

		try {
			login = ExcelUtils.readData("endToEndValidationTest"); // pass test case name as an argument so that data
																	// would be fetched from excel based on test case
																	// name
		} catch (Exception e) {
			e.printStackTrace();
		}

		LoginPage loginPage = new LoginPage();
		loginPage.performLogin(login.get(0), login.get(1));

		ProductsPage productsPage = new ProductsPage();
		productsPage.addSpecificItemToCart(login.get(2));
		productsPage.clickOnShoppingCart();
		
		YourCartPage cartPage = new YourCartPage();
		cartPage.clickOnContinueShopping();
		productsPage.addSpecificItemToCart(login.get(3));
		productsPage.clickOnShoppingCart();
		cartPage.clickOnCheckout();
		
		CheckoutYourInformationPage informationPage = new CheckoutYourInformationPage();
		informationPage.performContinue();
		
		CheckoutOverviewPage overviewPage = new CheckoutOverviewPage();
		overviewPage.clickOnFinish();
		
		CheckoutCompletePage completePage = new CheckoutCompletePage();
		
		Assert.assertEquals(completePage.getOrderplacedtext(), login.get(4), "Incorrect validation message");
		Assert.assertEquals(completePage.getOrderDispatchedtext(), login.get(5), "Incorrect validation message");
		
		completePage.clickOnBackHome();
		
		productsPage.clickHamburgerMenu();
		productsPage.clickOnLogout();
		
	}

}
 