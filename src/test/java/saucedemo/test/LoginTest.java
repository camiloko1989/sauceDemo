package saucedemo.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import saucedemo.TestComponents.BaseTest;
import saucedemo.pageObjects.LoginPage;
import saucedemo.pageObjects.ProductPage;

/**
 * This class contains test cases for the login functionality of the SauceDemo application.
 * It extends the BaseTest class to utilize common test setup and teardown methods.
 */
public class LoginTest extends BaseTest {

    /**
     * Test case to verify successful login to the SauceDemo application.
     * It logs in with valid credentials and verifies if the user is navigated to the Product Page.
     */
    @Test
    public void successfulLogin() {
        // Perform login action
        ProductPage productPage = loginPage.loginInApp("standard_user", "secret_sauce");
        
        // Get the title of the product page
        String titleProductPage = productPage.getTitleElement().getText();
        
        // Verify if the title matches "Products"
        boolean match = titleProductPage.equalsIgnoreCase("Products");
        Assert.assertTrue(match, "Products");
    }
}
