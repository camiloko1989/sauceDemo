package saucedemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import saucedemo.AbstractComponents.AbstractComponents;

/**
 * This class represents the login page of the SauceDemo application.
 * It provides methods to interact with the login page elements and perform login actions.
 */
public class LoginPage extends AbstractComponents {

    private WebDriver driver;

    /**
     * Constructor to initialize the LoginPage.
     * 
     * @param driver The WebDriver instance to interact with the browser.
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement nameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;
    
    @FindBy(css = "div.error-message-container.error h3")
    private WebElement errorMessage;
    
    

    public WebElement getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(WebElement errorButton) {
		this.errorMessage = errorButton;
	}

	/**
     * Logs into the application using the provided username and password.
     * 
     * @param username The username to login with.
     * @param password The password to login with.
     * @return ProductPage The page object representing the product page after successful login.
     */
    public ProductPage loginInApp(String username, String password) {
        nameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ProductPage(driver);
    }

    /**
     * Navigates to the login page of the SauceDemo application.
     */
    public void goTo() {
        driver.get("https://www.saucedemo.com/");
    }
}
