package saucedemo.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemo.TestComponents.BaseTest;
import saucedemo.pageObjects.CartPage;
import saucedemo.pageObjects.CheckoutPage;


public class CheckoutSteps extends BaseTest{
	
	private CheckoutPage checkoutPage;
	
	public CheckoutSteps() {
        this.checkoutPage = new CheckoutPage(driver);
    }
	
	@When("^I fill the form with name \"([^\"]*)\" last name \"([^\"]*)\" and zip code \"([^\"]*)\"$")
	public void fillForm(String firstName, String lastName, String zipCode) {
		checkoutPage = new CheckoutPage(driver);
	    checkoutPage.fillFirstName(firstName);
	    checkoutPage.fillLastName(lastName);
	    checkoutPage.fillPostalCode(zipCode);
	}
	
	@When("I go to overview page")
	public void goToOverViewPage() {
		checkoutPage.continuePurchase();
	}

}
