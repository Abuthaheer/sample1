package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BasePage;

public class LoginPageObjects extends BasePage {

	@FindBy(id = "username")
	private WebElement txtBoxUser;

	@FindBy(id = "password")
	private WebElement txtBoxPassWord;

	@FindBy(id = "login")
	private WebElement btnLogin;

	public LoginPageObjects() {
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String name) {
		setText(txtBoxUser, name);
	}

	public String getEnteredUserName() {
		return txtBoxUser.getAttribute("value");
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public void logintoApp(String name, String pass) {
		setText(txtBoxUser, name);
		setText(txtBoxPassWord, pass);
	}

}
