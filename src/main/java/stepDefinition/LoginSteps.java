package stepDefinition;

import java.util.List;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import pageObjects.LoginPageObjects;

public class LoginSteps {

	LoginPageObjects lg;

	public LoginSteps() {
		lg = new LoginPageObjects();
	}

	@Given("^User launch the application$")
	public void user_launch_the_application() throws Throwable {
		lg = new LoginPageObjects();
	}

	@When("^User enters user name and password$")
	public void user_enters_user_name_and_password() throws Throwable {
		lg.logintoApp("Abuthaheer123", "ouoi");
	}

	@When("^User click on Login button$")
	public void user_click_on_Login_button() throws Throwable {
		lg.clickLogin();
	}

	@Then("^User should able to login successfully$")
	public void user_should_able_to_login_successfully() throws Throwable {
		Assert.assertTrue("Login Failed", lg.getTitlte().contains("Search"));
	}

	@When("^User enters user name \"(.*?)\" and password \"(.*?)\"$")
	public void user_enters_user_name_and_password(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		lg.logintoApp(arg1, arg2);
	}

	@When("^User enters \"(.*?)\" and password \"(.*?)\"$")
	public void user_enters_and_password(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		lg.logintoApp(arg1, arg2);
	}
	
	@When("^User enters credentials and click login button$")
	public void user_enters_credentials_and_click_login_button(DataTable arg1) throws Throwable {
		List<List<String>> datas = arg1.raw();
		String user = datas.get(0).get(0);
		String pass = datas.get(0).get(1);
		lg.logintoApp(user, pass);
		
		for(int i = 0; i < datas.size(); i++){
			
		}
	  
	}


}
