package saucedemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import saucedemo.AbstractComponents.AbstractComponents;

public class ProductPage extends AbstractComponents{

	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "title" )
	WebElement titleElement;
	
	
	public WebElement getTitleElement() {
		return titleElement;
	}

	public void setTitleElement(WebElement titlElement) {
		this.titleElement = titlElement;
	}
	
	
}
