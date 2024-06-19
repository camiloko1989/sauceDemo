package saucedemo.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import saucedemo.AbstractComponents.AbstractComponents;

public class OverviewPage extends AbstractComponents{

	WebDriver driver;
	
	public OverviewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "cart_item")
	private List<WebElement> cartItems;
	
	@FindBy(className = "summary_subtotal_label")
	private WebElement subTotal;
	
	@FindBy(className = "summary_tax_label")
	private WebElement taxTotal;
	
	@FindBy(className = "summary_total_label")
	private WebElement total;
	
	@FindBy(id = "finish")
	private WebElement finishButton;
	
	@FindBy(id = "cancel")
	private WebElement cancelButton;
	
	@FindBy(className = "inventory_item_price")
	List<WebElement> itemPrices;

	public List<WebElement> getCartItems() {
		return cartItems;
	}

	public WebElement getSubTotal() {
		return subTotal;
	}

	public WebElement getTaxTotal() {
		return taxTotal;
	}

	public WebElement getTotal() {
		return total;
	}

	public WebElement getFinishButton() {
		return finishButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}
	
	public double getTax() {
		Double taxValue = Double.parseDouble(taxTotal.getText().replace("Tax: $", ""));
		return taxValue;
	}
	
	public double getItemsPrice() {
		double itemsPrice = 0;
		double price;
		for (WebElement webElement : itemPrices) {
			price = Double.parseDouble(webElement.getText().replace("$", ""));
			itemsPrice += price;
		}
		return itemsPrice + getTax();
	}
	
	
	
	public double getTotalPrice() {
		double totalPrice;
		totalPrice = Double.parseDouble(total.getText().split("\\$")[1]);
		System.out.println("Total Price: "+totalPrice);
		return totalPrice;
	}
	
}
