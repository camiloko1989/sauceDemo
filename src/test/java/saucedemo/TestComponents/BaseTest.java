package saucedemo.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import saucedemo.pageObjects.LoginPage;


public class BaseTest {
	
	public WebDriver driver;
	public LoginPage loginPage;
	
	public WebDriver initializeDriver() {
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
	}

	@BeforeMethod
	public LoginPage launchApplication() throws IOException {
		driver = initializeDriver();
		loginPage = new LoginPage(driver);
		loginPage.goTo();
		
		return loginPage;
	}
	
	@AfterMethod
	public void finishBrowser() {
		driver.quit();
	}

}
