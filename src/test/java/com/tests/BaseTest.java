package com.tests;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.Driver;

public class BaseTest {
	
	@BeforeMethod
	public void setUp(Method method) {
		Driver.initDriver();
	}
	
	@AfterMethod
	public void tearDown() {
		Driver.quitDriver();
	}

}
