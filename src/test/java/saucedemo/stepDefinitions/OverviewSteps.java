package saucedemo.stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import saucedemo.TestComponents.BaseTest;
import saucedemo.pageObjects.OverviewPage;

public class OverviewSteps extends BaseTest {
	
	OverviewPage overviewPage;

	public OverviewSteps() {
		overviewPage = new OverviewPage(driver);
	}
	
	
	@Then("The total price is the same as the sum of each product price") 
	public void validateTotalPrice() {
		Double totalPriceString = overviewPage.getTotalPrice();
		Double sumPriceString = overviewPage.getItemsPrice();
		Assert.assertEquals(sumPriceString, totalPriceString);
	}
	
}
