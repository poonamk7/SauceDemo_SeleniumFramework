package com.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import annotations.FrameworkAnnotation;
import pages.LoginPage;
import utils.ExcelUtils;

public class LoginForLockedOutUserTest extends BaseTest {
	
List<String> login;
	
	@FrameworkAnnotation(author = "Poonam")
	@Test(description = "To validate login functionality for locked out user")
	public void loginForLockedOutUserTest() {
		
		try {
			login = ExcelUtils.readData("loginForLockedOutUserTest");  //pass test case name as an argument so that data would be fetched from excel based on test case name
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		LoginPage loginPage = new LoginPage();
		loginPage.performLogin(login.get(0), login.get(1));
		
		Assert.assertEquals(loginPage.getErrorMessage(), login.get(4), "Incorrect Error message");
		
	}

}
