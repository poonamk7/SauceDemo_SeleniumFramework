package com.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import annotations.FrameworkAnnotation;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;
import utils.ExcelUtils;

public class AddAllItemsToCartTest extends BaseTest {
	
	List<String> login;

	@FrameworkAnnotation(author = "Poonam")
	@Test(description = "To check whether user is able to add all products to the cart")
	public void addAllItemsToCartTest() {

		try {
			login = ExcelUtils.readData("addAllItemsToCartTest"); // pass test case name as an argument so that data
																	// would be fetched from excel based on test case
																	// name
		} catch (Exception e) {
			e.printStackTrace();
		}

		LoginPage loginPage = new LoginPage();
		loginPage.performLogin(login.get(0), login.get(1));

		ProductsPage productsPage = new ProductsPage();
		productsPage.addAllItemsToCart();
		
		Assert.assertEquals(productsPage.getNoOfItemsAddedToCart(), 6, "items count mismatched");
		
		productsPage.clickOnShoppingCart();
		
		YourCartPage cartPage = new YourCartPage();
		
		Assert.assertEquals(cartPage.getCountOfItemsAdded(), 6, "items added to cart count mismatched");
		
		cartPage.removeAllItems();
		cartPage.clickOnContinueShopping();
	}

}
