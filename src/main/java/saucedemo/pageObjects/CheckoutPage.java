package saucedemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import saucedemo.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "first-name")
	private WebElement firstNameInput;
	
	@FindBy(id = "last-name")
	private WebElement lastNameInput;
	
	@FindBy(id = "postal-code")
	private WebElement postalCodeInput;
	
	@FindBy(xpath = "//div[@class='checkout_buttons']/button")
	private WebElement cancelButton;
	
	@FindBy(id = "continue")
	private WebElement continueButton;

	public WebElement getFirstNameInput() {
		return firstNameInput;
	}

	public WebElement getLastNameInput() {
		return lastNameInput;
	}

	public WebElement getPostalCodeInput() {
		return postalCodeInput;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public void fillFirstName(String firstName) {
		firstNameInput.sendKeys(firstName);
	}
	
	public void fillLastName(String lastName) {
		lastNameInput.sendKeys(lastName);
	}
	
	public void fillPostalCode(String postalCode) {
		postalCodeInput.sendKeys(postalCode);
	}
	
	public OverviewPage continuePurchase() {
		continueButton.click();
		return new OverviewPage(driver);
	}
	
	public CartPage cancel() {
        cancelButton.click();
        return new CartPage(driver);
    }
}
