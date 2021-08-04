package objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrderPageObjects {
	WebDriver driverObject;

	public MyOrderPageObjects(WebDriver driverObj) {
		this.driverObject = driverObj;
		PageFactory.initElements(driverObj, this);
	}

	@FindBy(xpath = "//a[text()='View Order']")
	WebElement viewOrderLink;

	public WebElement sendObjectViewOrderLink() {
		return viewOrderLink;
	}

	@FindBy(xpath = "//table[@id='my-orders-table']/tbody/tr/td[1]/h3")
	WebElement productPurchaseName;

	public WebElement sendObjectProductPurchaseName() {
		return productPurchaseName;
	}

	@FindBy(xpath = "//a[text()='Print Order']")
	WebElement printOrderLink;

	public WebElement sendObjectPrintOrderLink() {
		return printOrderLink;
	}

}
