package saucedemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import saucedemo.AbstractComponents.AbstractComponents;

public class ItemPage extends AbstractComponents {

	public ItemPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}

	@FindBy(id = "add-to-cart")
	private WebElement addButton;
	
	@FindBy(id="remove")
	private WebElement removeButton;
	
	@FindBy(className = "header_secondary_container")
	private WebElement backButton;

	public WebElement getBackButton() {
		return backButton;
	}
	
	public WebElement getRemoveButton() {
		return removeButton;
	}

	public WebElement getAddButton() {
		return addButton;
	}
	
	public void addProduct() {
		addButton.click();
	}
	
}
