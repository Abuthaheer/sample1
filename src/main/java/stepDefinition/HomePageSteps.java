package stepDefinition;

import java.util.Random;

import org.junit.Assert;

import cucumber.api.java.en.*;
import pageObjects.HomePageObject;

public class HomePageSteps {

	HomePageObject hp;

	public HomePageSteps() {
		hp = new HomePageObject();
	}

	int random = new Random().nextInt(500000);

	@Given("^User launches the application$")
	public void user_lanuch_the_application() throws Throwable {
		hp = new HomePageObject();
	}

	@When("^User Click on the tab \"(.*?)\"$")
	public void user_Click_on_the_tab(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("dresses")) {
			hp.clickDresses();
		} else if (arg1.equalsIgnoreCase("women")) {
			hp.getWomen().click();
		} else {

		}

	}

	@When("^User enter email \"(.*?)\" in the subscription text box$")
	public void user_enter_email_in_the_subscription_text_box(String arg1) throws Throwable {
		arg1 = random + arg1;
		hp.setNewsLetter(arg1);
	}

	@Then("^User should see subscription Message$")
	public void user_should_see_subscription_Message() throws Throwable {
		Assert.assertTrue("Failed: Not Subscribed", hp.getNewsLetterMsg().contains("successfully"));
	}

	@Then("^User should see the respective details page \"(.*?)\"$")
	public void user_should_see_the_respective_details_page(String arg1) throws Throwable {
		Assert.assertTrue("Failed", hp.getTitlte().contains(arg1));
	}

}
