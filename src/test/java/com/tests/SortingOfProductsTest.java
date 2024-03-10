package com.tests;

import java.util.List;

import org.testng.annotations.Test;

import annotations.FrameworkAnnotation;
import enums.SortValue;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ExcelUtils;

public class SortingOfProductsTest extends BaseTest {
	
	List<String> login;
	
	@FrameworkAnnotation(author = "Poonam")
	@Test(description = "Verify sorting of products based on different sort dropdown options.")
	public void sortingOfProductsTest() {
		
		try {
			login = ExcelUtils.readData("loginForProblemUserTest"); // pass test case name as an argument so that data
																	// would be fetched from excel based on test case
																	// name
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		LoginPage loginPage = new LoginPage();
		loginPage.performLogin(login.get(0), login.get(1));
		
		ProductsPage productsPage = new ProductsPage();
		productsPage.sortItems(SortValue.NAME_A_TO_Z);
		productsPage.sortItems(SortValue.NAME_Z_TO_A);
		productsPage.sortItems(SortValue.PRICE_LOW_TO_HIGH);
		productsPage.sortItems(SortValue.PRICE_HIGH_TO_LOW);
		
	}

}
