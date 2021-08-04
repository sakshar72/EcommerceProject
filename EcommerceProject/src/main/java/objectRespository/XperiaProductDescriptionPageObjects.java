package objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class XperiaProductDescriptionPageObjects {
	WebDriver driverObject;

	public XperiaProductDescriptionPageObjects(WebDriver driverObj) {
		this.driverObject = driverObj;
		PageFactory.initElements(driverObj, this);
	}

	@FindBy(xpath = "//span[@id='product-price-1']/span")
	WebElement xperiaProductPrice;

	@FindBy(xpath = "//button[@title='Add to Cart']")
	WebElement addToCart;

	public WebElement sendObjectXperiaProductPrice() {
		return xperiaProductPrice;
	}

	public WebElement sendObjectAddToCart() {
		return addToCart;
	}
}
