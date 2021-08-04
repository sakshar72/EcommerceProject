package objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductComparisonPageObjects {
	WebDriver driverObject;

	public ProductComparisonPageObjects(WebDriver driverObj) {
		this.driverObject = driverObj;
		PageFactory.initElements(driverObj, this);
	}

	@FindBy(xpath = "//table[@id='product_comparison']/tbody/tr[1]/td[1]/h2")
	WebElement firstProductHeading;

	@FindBy(xpath = "//table[@id='product_comparison']/tbody[1]/tr[1]/td[2]/h2")
	WebElement secondProductHeading;

	public WebElement sendObjectFirstProductHeading() {
		return firstProductHeading;
	}

	public WebElement sendObjectSecongProductHeading() {
		return secondProductHeading;
	}

}
