package saucedemo.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import saucedemo.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "continue-shopping")
	private WebElement continueShopingButton;
	
	@FindBy(css = "#checkout")
	private WebElement checkoutButton;
	
	@FindBy(xpath = "//div[@class='cart_item']")
	private List<WebElement> productsAdded;
	
	@FindBy(css = ".inventory_item_price")
	private List<WebElement> productPrices;
	
	public WebElement getContinueShopingButton() {
		return continueShopingButton;
	}

	public WebElement getCheckoutButton() {
		return checkoutButton;
	}
	
	public List<WebElement> getProductsAdded() {
		return productsAdded;
	}

	public List<WebElement> getProductPrices() {
		return productPrices;
	}

	public void continueShopping() {
		continueShopingButton.click();
	}
	
	public CheckoutPage goToCheckout() {
		System.out.println("Cart Page antes de checkout");
		checkoutButton.click();
		System.out.println("clicked checkout button");
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}

	
}
