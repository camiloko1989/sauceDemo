package saucedemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import saucedemo.AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents{

	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	WebElement nameInput;
	
	@FindBy(id = "password")
	WebElement passwordInput;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	
	public void getCrendentials() {
		
	}
	
	public ProductPage loginInApp(String username, String password) {
		nameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginButton.click();
		ProductPage productPage = new ProductPage(driver);
		return productPage;
	}
	
	public void goTo() {
		System.out.println("LLego aca");
		driver.get("https://www.saucedemo.com/");
	}
	
	
	
	
}
