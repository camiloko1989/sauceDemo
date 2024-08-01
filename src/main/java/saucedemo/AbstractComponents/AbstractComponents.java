package saucedemo.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import saucedemo.pageObjects.CartPage;



/**
 * AbstractComponents class provides common functionalities that can be used
 * across different page objects in the SauceDemo application.
 * It includes methods to handle common web interactions such as waiting for
 * elements to appear.
 */
public class AbstractComponents {

    protected WebDriver driver;

    /**
     * Constructor to initialize AbstractComponents.
     *
     * @param driver The WebDriver instance to interact with the browser.
     */
    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCart;
    
    @FindBy(id = "react-burger-menu-btn")
    WebElement mainMenu;
    
    
    public WebElement getShoppingCart() {
		return shoppingCart;
	}

	/**
     * Waits for an element to appear on the page.
     *
     * @param findBy The locator used to find the element.
     */
    public void waitForElementToAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    
    public CartPage goToCart() {
    	shoppingCart.click();
    	CartPage cartPage = new CartPage(driver);
		return cartPage;
    }
    
    public void logOut() {
    	WebElement logOut = driver.findElement(By.xpath("//a[@id=\"logout_sidebar_link\"]"));
    	mainMenu.click();
    	logOut.click();
    }
    
}
