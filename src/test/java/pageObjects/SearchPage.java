package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#product-list")
	List<WebElement> searchProducts;

	@FindBy(name = "quantity")
	WebElement txtquantity;

	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement btnaddToCart;

	@FindBy(xpath = "//div[contains(text(),'Success: You have added')]")
	WebElement cnfMsg;

	public boolean isProductExist(String productName) {
		for (WebElement product : searchProducts) {
			if (product.getAttribute("title").equals(productName)) {
				return true; // Product found, return true immediately
			}
		}
		return false; // Product not found in the list
	}

	public void selectProduct(String productName) {
		for (WebElement product : searchProducts) {
			if (product.getAttribute("title").equals(productName)) {
				product.click();
			}
		}

	}

	public void setQuantity(String qty) {
		txtquantity.clear();
		txtquantity.sendKeys(qty);
	}

	public void addToCart() {
		btnaddToCart.click();
	}

	public boolean checkConfMsg() {
		try {
			return cnfMsg.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
