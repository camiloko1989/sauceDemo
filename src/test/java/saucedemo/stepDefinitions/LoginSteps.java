package saucedemo.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemo.TestComponents.BaseTest;
import saucedemo.pageObjects.LoginPage;
import saucedemo.pageObjects.ProductPage;

/**
 * Step definitions for login-related scenarios in the SauceDemo application.
 * Extends BaseTest for common test setup and teardown.
 */
public class LoginSteps extends BaseTest {
    
    public ProductPage productPage;
    public LoginPage loginPage;

    /**
     * Step: Navigate to the Login Page.
     * @throws IOException if an I/O error occurs
     */
    @Given("I am placed in the Login Page")
    public void loginPage() throws IOException {
        loginPage = launchApplication();
    }
    
    /**
     * Step: Perform login with valid credentials.
     * @param userName the username to be entered
     * @param password the password to be entered
     */
    @When("^I write a valid username (.+) and a valid password (.+)$")
    public void loginWithValidCredentials(String userName, String password) {
        productPage = loginPage.loginInApp(userName, password);
    }
    
    /**
     * Step: Validate the Product Page title.
     * @param title the expected title of the product page
     */
    @Then("^I validate the Product Page title (.+)$")
    public void validateProductPage(String title) {
        // Get the title of the product page
        String titleProductPage = productPage.getTitleElement().getText();        
        // Verify if the title matches the expected title
        boolean match = titleProductPage.equals(title);
        Assert.assertTrue(match, "Title mismatch: Expected '" + title + "', but found '" + titleProductPage + "'");
        driver.close(); // Close the browser session
    }
    
    @When("^I write an invalid username (.+) or an invalid password (.+)$") 
    public void loginWithInvalidCredentials(String userName, String password) {
    	productPage = loginPage.loginInApp(userName, password);
    }
    
    @Then("^I validate the error (.+) message$") 
    public void validateErrorMessage(String message) {
    	String expectedMessage = loginPage.getErrorMessage().getText();
    	Assert.assertEquals(expectedMessage, "Epic sadface: Username and password do not match any user in this service");
    	driver.close(); // Close the browser session
    }
}
