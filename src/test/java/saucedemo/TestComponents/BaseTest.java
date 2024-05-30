package saucedemo.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import saucedemo.pageObjects.LoginPage;

/**
 * This class serves as the base for all test classes.
 * It provides common setup and teardown methods to initialize and clean up the WebDriver.
 */
public class BaseTest {

    public WebDriver driver;
    public LoginPage loginPage;

    /**
     * Initializes the WebDriver for Chrome browser.
     * It sets up the ChromeDriver, maximizes the browser window, and returns the WebDriver instance.
     * 
     * @return WebDriver instance
     */
    public WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * This method is executed before each test method.
     * It initializes the WebDriver, navigates to the application login page, and returns the LoginPage instance.
     * 
     * @return LoginPage instance
     * @throws IOException if an I/O error occurs
     */
    @BeforeMethod
    public LoginPage launchApplication() throws IOException {
        driver = initializeDriver();
        loginPage = new LoginPage(driver);
        loginPage.goTo();
        return loginPage;
    }

    /**
     * This method is executed after each test method.
     * It quits the WebDriver, closing all associated browser windows.
     */
    @AfterMethod
    public void finishBrowser() {
        driver.quit();
    }
}
