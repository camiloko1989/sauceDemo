package saucedemo.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import saucedemo.pageObjects.LoginPage;


/**
 * This class serves as the base for all test classes.
 * It provides common setup and teardown methods to initialize and clean up the WebDriver.
 */
public class BaseTest {

    public static WebDriver driver;
    public LoginPage loginPage; 
    public ExtentReports extent;
    public ExtentTest test;
    

    /**
     * Initializes the WebDriver for Chrome browser.
     * It sets up the ChromeDriver, maximizes the browser window, and returns the WebDriver instance.
     * 
     * @return WebDriver instance
     * @throws IOException 
     */
    public WebDriver initializeDriver() throws IOException {
    	Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ 
				"\\src\\main\\java\\saucedemo\\resources\\GlobalData.properties");
		properties.load(fis);
		String browserType = System.getProperty("browser")!= null ? System.getProperty("browser") : properties.getProperty("browser");
		
	    switch (browserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type: " + browserType);
        }
        driver.manage().window().maximize();
        return driver;
    }
    
    public BaseTest() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentSpark.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }
    
    
    /**
     * This method is executed before each test method.
     * It initializes the WebDriver, navigates to the application login page, and returns the LoginPage instance.
     * 
     * @return LoginPage instance
     * @throws IOException if an I/O error occurs
     */
    @BeforeClass
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
    @AfterClass
    public void finishBrowser() {
    	if (driver != null) {
            driver.quit();
        }
    }
    
    /**
     * Takes a screenshot of the current browser window.
     *
     * @param testName the name of the test method
     * @throws IOException if an I/O error occurs during saving the screenshot
     */
    //public void takeScreenshot(String testName) throws IOException {
    //    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    //  String destPath = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
    //  File destFile = new File(destPath);
    //  FileUtils.copyFile(srcFile, destFile);
    //}
    
    public void flushReports() {
        extent.flush();
    }
    
    public static WebDriver getDriver() {
        if (driver == null) {
            // Initialize WebDriver
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized"); // Example option
            driver = new ChromeDriver(options);
        }
        return driver;
    }
}
