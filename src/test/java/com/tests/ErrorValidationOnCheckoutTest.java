package com.tests;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import annotations.FrameworkAnnotation;
import pages.CheckoutYourInformationPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;
import utils.ExcelUtils;

public class ErrorValidationOnCheckoutTest extends BaseTest {

	List<String> login;

	@FrameworkAnnotation(author = "Poonam")
	@Test(description = "Verify Error message on Checkout: Your Information screen")
	public void errorValidationOnCheckoutTest() {

		try {
			login = ExcelUtils.readData("errorValidationOnCheckoutTest"); // pass test case name as an argument so that
																			// data
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
		cartPage.clickOnCheckout();

		CheckoutYourInformationPage informationPage = new CheckoutYourInformationPage();
		informationPage.clickOnCotinue();

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(informationPage.getErrorMessage(), login.get(4),
				"Incorrect error message");

		informationPage.enterFirstname();
		informationPage.clickOnCotinue();

		softAssert.assertEquals(informationPage.getErrorMessage(), login.get(5),
				"Incorrect error message");

		informationPage.enterLastname();
		informationPage.clickOnCotinue();

		softAssert.assertEquals(informationPage.getErrorMessage(), login.get(6),
				"Incorrect error message");

		softAssert.assertAll(); // to record any failure using test execution and throw exception at the end of
								// test execution
	}

}
