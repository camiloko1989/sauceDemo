package saucedemo.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import saucedemo.TestComponents.BaseTest;
import saucedemo.pageObjects.ProductPage;

public class ProductTest extends BaseTest{
	//WebDriver driver;
	


	@Test
	public void orderProductsAscending() {
		ProductPage productPage = loginPage.loginInApp("standard_user", "secret_sauce");
		String titleProductPage = productPage.getTitleElement().getText();
		boolean match = titleProductPage.equalsIgnoreCase("Products");
		Assert.assertTrue(match, "Products");
		productPage.orderByName("Name Ascending");
		String orderSelected = productPage.getOptionChosen().getText();
		Assert.assertEquals(orderSelected, "Name (A to Z)");
	}
	
	@Test
	public void orderProductsDescending() {
		ProductPage productPage = loginPage.loginInApp("standard_user", "secret_sauce");
		String titleProductPage = productPage.getTitleElement().getText();
		boolean match = titleProductPage.equalsIgnoreCase("Products");
		Assert.assertTrue(match, "Products");
		productPage.orderByName("Name Descending");
		String orderSelected = productPage.getOptionChosen().getText();
		Assert.assertEquals(orderSelected, "Name (Z to A)");
	}
	
	@Test
	public void selectProduct() {
		ProductPage productPage = loginPage.loginInApp("standard_user", "secret_sauce");
		String titleProductPage = productPage.getTitleElement().getText();
		boolean match = titleProductPage.equalsIgnoreCase("Products");
		Assert.assertTrue(match, "Products");
		productPage.selectProduct("Labs Onesie");
		productPage.addProductToCart("Labs Onesie");
		String buttonTextString = productPage.getAddedProduct("Labs Onesie");
		Assert.assertEquals(buttonTextString, "Remove");
		
	}
	
}
