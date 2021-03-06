package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BasePage;

public class HomePageObject extends BasePage {

	@FindBy(xpath = "(//*[text()='Dresses'])[2]")
	private WebElement tabDresses;

	@FindBy(id = "newsletter-input")
	private WebElement txtBoxNewsLetter;

	@FindBy(name = "submitNewsletter")
	private WebElement txtBoxSubmitButton;

	@FindBy(xpath = "//*[@class='alert alert-success']")
	private WebElement msgSuccess;

	@FindBy(xpath = "(//*[text()='Women'])[2]")
	private WebElement tabWomen;

	public HomePageObject() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDresses() {
		return tabDresses;
	}

	public WebElement getWomen() {
		return tabWomen;
	}

	public void clickDresses() {
		tabDresses.click();
	}

	public void setNewsLetter(String email) {
		setText(txtBoxNewsLetter, email);
		txtBoxSubmitButton.click();
	}

	public String getNewsLetterMsg() {
		return msgSuccess.getText();
	}
}
