package saucedemo.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import saucedemo.TestComponents.BaseTest;
import saucedemo.pageObjects.ProductPage;

/**
 * This class contains test cases related to the Product Page of the SauceDemo application.
 * It extends the BaseTest class to utilize common test setup and teardown methods.
 */
public class ProductTest extends BaseTest {

    private ProductPage productPage;

    /**
     * This method is executed before each test case. It performs the login action and initializes the ProductPage object.
     */
    @BeforeMethod
    public void setUp() {
        productPage = loginPage.loginInApp("standard_user", "secret_sauce");
        String titleProductPage = productPage.getTitleElement().getText();
        boolean match = titleProductPage.equalsIgnoreCase("Products");
        Assert.assertTrue(match, "Failed to navigate to the Product Page after login");
    }

    /**
     * Test case to verify sorting products by name in ascending order.
     */
    @Test
    public void orderProductsAscending() {
        productPage.orderByName("Name Ascending");
        String orderSelected = productPage.getOptionChosen().getText();
        Assert.assertEquals(orderSelected, "Name (A to Z)", "Products are not sorted in ascending order by name");
    }

    /**
     * Test case to verify sorting products by name in descending order.
     */
    @Test
    public void orderProductsDescending() {
        productPage.orderByName("Name Descending");
        String orderSelected = productPage.getOptionChosen().getText();
        Assert.assertEquals(orderSelected, "Name (Z to A)", "Products are not sorted in descending order by name");
    }

    /**
     * Test case to verify adding a specific product to the cart.
     */
    @Test
    public void selectProduct() {
        productPage.selectProduct("Labs Onesie");
        productPage.addProductToCart("Labs Onesie");
        String buttonText = productPage.getAddedProduct("Labs Onesie");
        Assert.assertEquals(buttonText, "Remove", "The product was not added to the cart successfully");
    }
}
