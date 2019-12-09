package stepDefinition;

import java.io.IOException;

import org.junit.Assert;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import pageObjects.DressesPageObject;
import pageObjects.HomePageObject;

public class DressesPageSteps {

	DressesPageObject dp;

	public DressesPageSteps() {
		dp = new DressesPageObject();
	}

	@Before
	public void beforeScenario() {
		System.out.println("Executing before scenario");
	}

	@After
	public void afterScenario(Scenario sc) throws IOException {
		if (sc.isFailed()) {
			String testName = sc.getName();
			dp.captureSnapshot(testName);
		}
	}

	@Then("^User should see the same number of products count matching with the product header count displayed$")
	public void user_should_see_the_same_number_of_products_count_matching_with_the_product_header_count_displayed()
			throws Throwable {

	}

	@When("^the click on Add to cart button for the product \"(.*?)\"$")
	public void the_click_on_Add_to_cart_button_for_the_product(String arg1) throws Throwable {
		dp.clickProuct(arg1);

	}

	@Then("^the product should added to cart page$")
	public void the_product_should_added_to_cart_page() throws Throwable {
		Assert.assertTrue("Failed: Not added", dp.verifyCheckoutButton());
	}

}
