package pageObjects;

import utility.BasePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class DressesPageObject extends BasePage {

	@FindBy(xpath = "//*[@class='heading-counter']")
	private WebElement txtHeading;

	@FindBys(@FindBy(xpath = "//*[@class='product_list grid row']/li"))
	private List<WebElement> lstProducts;

	@FindBy(xpath = "//ul[@class='product_list grid row']/li[1]//*[text()='Add to cart']")
	private WebElement btnFirstAddtoCart;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	private WebElement btnCheckout;

	@FindBy(xpath = "//span[@title='Close window']")
	private WebElement btnClose;

	public DressesPageObject() {
		PageFactory.initElements(driver, this);
	}

	public int getCountFromHeader() {
		return Integer.parseInt(txtHeading.getText().split(" ")[2]);
	}

	public int getProductsSize() {
		return lstProducts.size();
	}

	public void clickFirstAddToCart() {
		mouseOver(lstProducts.get(0));
		isElementVisible(btnFirstAddtoCart);
		btnFirstAddtoCart.click();
	}

	public boolean verifyCheckoutButton() {
		isElementVisible(btnCheckout);
		return elementFound(btnCheckout);
	}

	public WebElement getCloseBtn() {
		return btnClose;
	}

	public void clickProuct(String name) {

		for (WebElement element : lstProducts) {
			String prodName = element.findElement(By.xpath(".//a[@class='product-name']")).getText();
			if (prodName.equals(name)) {
				mouseOver(element);
				element.findElement(By.xpath(".//*[text()='Add to cart']")).click();
			}
		}
	}

}
