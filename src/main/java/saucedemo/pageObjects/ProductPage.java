package saucedemo.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import saucedemo.AbstractComponents.AbstractComponents;

/**
 * This class represents the Product Page of the SauceDemo application.
 * It provides methods to interact with the product page elements and perform various actions such as sorting products and adding products to the cart.
 */
public class ProductPage extends AbstractComponents {

    private WebDriver driver;

    /**
     * Constructor to initialize the ProductPage.
     *
     * @param driver The WebDriver instance to interact with the browser.
     */
    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    private WebElement titleElement;

    @FindBy(className = "product_sort_container")
    private WebElement orderDropdown;

    @FindBy(className = "active_option")
    private WebElement optionChosen;

    @FindBy(xpath = "//div[@class=\"inventory_item\"]")
    private List<WebElement> products;

    /**
     * Gets the title element of the product page.
     *
     * @return The WebElement representing the title.
     */
    public WebElement getTitleElement() {
        return titleElement;
    }

    /**
     * Gets the dropdown element for sorting products.
     *
     * @return The WebElement representing the sort dropdown.
     */
    public WebElement getOrderDropdownElement() {
        return orderDropdown;
    }

    /**
     * Gets the element representing the currently chosen sort option.
     *
     * @return The WebElement representing the chosen sort option.
     */
    public WebElement getOptionChosen() {
        return optionChosen;
    }

    /**
     * Gets the list of product elements displayed on the page.
     * Waits for the product elements to be visible before returning them.
     *
     * @return A list of WebElements representing the products.
     */
    public List<WebElement> getProducts() {
        waitForElementToAppear(By.xpath("//div[@class='inventory_item']"));
        return products;
    }

    /**
     * Sorts the products by the specified option.
     *
     * @param option The sort option (e.g., "Name Ascending", "Name Descending", "Price Ascending", "Price Descending").
     */
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
            case "Price Ascending":
                dropdownSelect.selectByValue("lohi");
                break;
            case "Price Descending":
                dropdownSelect.selectByValue("hilo");
                break;
            default:
                throw new IllegalArgumentException("Invalid sort option: " + option);
        }
    }

    /**
     * Selects a product based on its name.
     *
     * @param productName The name of the product to select.
     * @return The WebElement representing the selected product.
     */
    public WebElement selectProduct(String productName) {
        return getProducts().stream()
            .filter(product -> product.findElement(By.className("inventory_item_name")).getText().contains(productName))
            .findFirst()
            .orElse(null);
    }

    /**
     * Adds a product to the cart based on its name.
     *
     * @param productName The name of the product to add to the cart.
     */
    public void addProductToCart(String productName) {
        WebElement selectedProduct = selectProduct(productName);
        if (selectedProduct != null) {
            selectedProduct.findElement(By.xpath("//div[@class='pricebar']/button")).click();
        }
    }

    /**
     * Gets the text of the button for the specified product, typically used to verify if the product is added to the cart.
     *
     * @param productName The name of the product.
     * @return The text of the button associated with the product.
     */
    public String getAddedProduct(String productName) {
        WebElement selectedProduct = selectProduct(productName);
        if (selectedProduct != null) {
            return selectedProduct.findElement(By.xpath("//div[@class='pricebar']/button")).getText();
        }
        return null;
    }
    
    public ItemPage openProduct(String productName) {
    	WebElement selectedProductElement = getProducts().stream()
        .filter(product -> product.findElement(By.className("inventory_item_name")).getText().contains(productName))
        .findFirst()
        .orElse(null);
    	selectedProductElement.findElement(By.className("inventory_item_label")).click();
    	return new ItemPage(driver);
    	
    	
    }
}
