package saucedemo.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import saucedemo.TestComponents.BaseTest;
import saucedemo.pageObjects.LoginPage;
import saucedemo.pageObjects.ProductPage;


public class LoginTest extends BaseTest{
	
	@Test
	public void successfullLogin() {
		ProductPage productPage = loginPage.loginInApp("standard_user", "secret_sauce");
		String titleProductPage = productPage.getTitleElement().getText();
		boolean match = titleProductPage.equalsIgnoreCase("Products");
		Assert.assertTrue(match, "Products");
	}
	
	
	
	
	
}
