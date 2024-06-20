package saucedemo.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemo.TestComponents.BaseTest;
import saucedemo.pageObjects.ItemPage;
import saucedemo.pageObjects.LoginPage;
import saucedemo.pageObjects.ProductPage;
import saucedemo.pageObjects.CartPage;

/**
 * Step definitions for product-related scenarios in the SauceDemo application.
 * Extends BaseTest to utilize common setup and teardown methods.
 */
public class ProductSteps extends BaseTest {

    // Page objects 
    public ProductPage productPage;
    public ItemPage itemPage;
    public CartPage cartPage;
    public LoginPage loginPage;
    
    /**
     * Given step to initialize the browser, navigate to the login page, and perform login.
     * Ensures the user is on the product page.
     * @throws IOException 
     */
    @Given("I am on the product page")
    public void productPage() throws IOException {
        // Initialize the WebDriver
        driver = initializeDriver();
        
        // Initialize the login page
        loginPage = new LoginPage(driver);
        
        // Navigate to the SauceDemo login page
        driver.get("https://www.saucedemo.com/");
        
        // Perform login and navigate to the product page
        productPage = loginPage.loginInApp("standard_user", "secret_sauce");
    }
    
    /**
     * When step to click on the ascending name order option on the product page.
     */
    @When("I click on the ascending name order option")
    public void orderProductsByNameAscending() {
        // Order products by name in ascending order
        productPage.orderByName("Name Ascending");
    }
    
    /**
     * Then step to validate that the products are ordered by name in ascending order.
     */
    @Then("I see the products ordered by name in ascending way")
    public void validateOrderedNameAscending() {
        // Get the selected order option text
        String orderSelected = productPage.getOptionChosen().getText();
        
        // Assert that the products are ordered by name in ascending order
        Assert.assertEquals(orderSelected, "Name (A to Z)", "Products are not sorted in ascending order by name");
        
        // Close the browser
        driver.close();
    }
    
    /**
     * When step to click on the descending name order option on the product page.
     */
    @When("I click on the descending name order option")
    public void orderProductsByNameDescending() {
        // Order products by name in descending order
        productPage.orderByName("Name Descending");
    }
    
    /**
     * Then step to validate that the products are ordered by name in descending order.
     */
    @Then("I see the products ordered by name in descending way")
    public void validateOrderedNameDescending() {
        // Get the selected order option text
        String orderSelected = productPage.getOptionChosen().getText();
        
        // Assert that the products are ordered by name in descending order
        Assert.assertEquals(orderSelected, "Name (Z to A)", "Products are not sorted in descending order by name");
        
        // Close the browser
        driver.close();
    }
    
    /**
     * When step to click on the ascending price order option on the product page.
     */
    @When("I click on the ascending price order option")
    public void orderProductsByPriceAscending() {
        // Order products by price in ascending order
        productPage.orderByName("Price Ascending");
    }
    
    /**
     * Then step to validate that the products are ordered by price in ascending order.
     */
    @Then("I see the products ordered by price in ascending way")
    public void validateOrderedPriceAscending() {
        // Get the selected order option text
        String orderSelected = productPage.getOptionChosen().getText();
        
        // Assert that the products are ordered by price in ascending order
        Assert.assertEquals(orderSelected, "Price (low to high)", "Products are not sorted in ascending order by price");
        
        // Close the browser
        driver.close();
    }
    
    /**
     * When step to click on the descending price order option on the product page.
     */
    @When("I click on the descending price order option")
    public void orderProductsByPriceDescending() {
        // Order products by price in descending order
        productPage.orderByName("Price Descending");
    }
    
    /**
     * Then step to validate that the products are ordered by price in descending order.
     */
    @Then("I see the products ordered by price in descending way")
    public void validateOrderedPriceDescending() {
        // Get the selected order option text
        String orderSelected = productPage.getOptionChosen().getText();
        
        // Assert that the products are ordered by price in descending order
        Assert.assertEquals(orderSelected, "Price (high to low)", "Products are not sorted in descending order by price");
        
        // Close the browser
        driver.close();
    }
    
    /**
     * When step to select a product by name and add it to the cart.
     * @param product the name of the product to be selected
     */
    @When("^I select a product \"([^\"]*)\" and add it to the cart$")
    public void selectProduct(String product) {
        // Select the specified product
        productPage.selectProduct(product);
        
        // Add the selected product to the cart
        productPage.addProductToCart(product);
    }
    
    
    @When("I select the following products and add it to the cart")
    public void selectProductsAndAddToCart(DataTable dataTable) {
    	List<String> products = dataTable.asList(String.class);
    	for (int i=1; i<=products.size(); i++) {
            productPage.selectProduct(products.get(i));
            productPage.addProductToCart(products.get(i));
            i++;
        }
    }
    
    /**
     * Then step to validate that the selected product is added to the cart.
     */
    @Then("The product is added to the cart")
    public void validateProductIsAdded() {
        // Get the text of the button for the added product
        String buttonText = productPage.getAddedProduct("Labs Backpack");
        
        // Assert that the product was successfully added to the cart
        Assert.assertEquals(buttonText, "Remove", "The product was not added to the cart successfully");
        
        // Close the browser
        driver.close();
    }
    
    @When("^I select a product (.+) and I open it$")
    public void openItempage(String product) {
    	itemPage = productPage.openProduct(product);
    	
    }
    
    @Then("The item page is displayed")
    public void itemPageOpens() {
    	String itemPageTitle = itemPage.getBackButton().getText();
    	Assert.assertEquals(itemPageTitle, "Back to products");
    	driver.close();
    	
    }
    
    @When("I click on the cart icon")
	public void openCart() {
    	System.out.println("antes de crear Cart");
		cartPage = productPage.goToCart();
		System.out.println("despues de crear Cart");
	}
}
