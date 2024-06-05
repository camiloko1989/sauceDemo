package saucedemo.stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemo.TestComponents.BaseTest;
import saucedemo.pageObjects.ItemPage;
import saucedemo.pageObjects.LoginPage;
import saucedemo.pageObjects.ProductPage;

public class ItemSteps extends BaseTest{
	
	public ItemPage itemPage;
	public ProductPage productPage;
	public LoginPage loginPage;

	@Given("^I am on the item (.+) page$") 
	public void itemPage(String product) {
		// Initialize the WebDriver
        driver = initializeDriver();
        
        // Initialize the login page
        loginPage = new LoginPage(driver);
        
        // Navigate to the SauceDemo login page
        driver.get("https://www.saucedemo.com/");
        
        // Perform login and navigate to the product page
        productPage = loginPage.loginInApp("standard_user", "secret_sauce");
        
        
        
        // Open item
        itemPage = productPage.openProduct(product);
	}
	
	@When("^I click on Add to Cart on the product (.+)$")
	public void clickAddtoCart(String product) {
	    //itemPage =	productPage.openProduct(product);
	    itemPage.addProduct();
	}
	
	@Then("The item is added to the cart")
	public void validateAddedItem() {
		String buttonText = itemPage.getRemoveButton().getText();
		Assert.assertEquals(buttonText, "Remove");
		driver.close();
	}
	
}

