package saucedemo.stepDefinitions;

import io.cucumber.java.en.When;
import saucedemo.TestComponents.BaseTest;
import saucedemo.pageObjects.CartPage;
import saucedemo.pageObjects.CheckoutPage;

public class CartSteps extends BaseTest{
	
	CheckoutPage checkoutPage;
	CartPage cartPage;

	public CartSteps() {
        cartPage = new CartPage(driver);
    }
	
	@When("I go the checkout page")
	public void goToCheckout() {
		System.out.println("antes de Checkout");
		cartPage.goToCheckout();
		System.out.println("despues de Checkout");
	}
}
