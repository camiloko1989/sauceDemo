package saucedemo.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import saucedemo.AbstractComponents.AbstractComponents;

public class ProductPage extends AbstractComponents{

	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "title" )
	private WebElement titleElement;
	
	@FindBy(className = "product_sort_container")
	private WebElement orderDropdown;
	
	@FindBy(className = "active_option")
	private WebElement optionChosen;
	
	@FindBy(xpath = "//div[@class=\"inventory_item\"]")
	private List<WebElement> products;
	
	
	public WebElement getTitleElement() {
		return titleElement;
	}

	public WebElement getOrderDropdownElement() {
		return orderDropdown;
	}
	
	public WebElement getOptionChosen() {
		return optionChosen;
	}
	
	public List<WebElement> getProducts() {
		waitForElementToAppear(By.xpath("//div[@class='inventory_item']"));
		return products;
	}
	
	public void orderByName(String option) {
		waitForElementToAppear(By.className("product_sort_container"));
		Select dropdownSelect = new Select(orderDropdown);
		switch (option) {
		case "Name Ascending":
			dropdownSelect.selectByValue("az");
			break;
		case "Name Descending":
			dropdownSelect.selectByValue("za");
			break;
		case "Price Descending":
			dropdownSelect.selectByValue("lohi");
			break;
		case "Price Ascending":
			dropdownSelect.selectByValue("hilo");
			break;
		default:
			break;
		}			
	}
	
	public WebElement selectProduct(String productName) {
		
		WebElement selectedProduct = getProducts().stream().filter(product ->
		product.findElement(By.className("inventory_item_name")).getText().contains(productName)).findFirst().orElse(null);
		return selectedProduct;
		
	}
	
	public void addProductToCart(String productName) {
		WebElement selectedProduct = selectProduct(productName);
		selectedProduct.findElement(By.xpath("//div[@class='pricebar']/button")).click();
		
	}
	
	public String getAddedProduct(String productName) {
		WebElement selectedProduct = selectProduct(productName);
		String buttonText = selectedProduct.findElement(By.xpath("//div[@class='pricebar']/button")).getText();
		System.out.println(buttonText);
		return buttonText;
	}
	
}
