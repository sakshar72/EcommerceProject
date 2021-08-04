package objectRespository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogAdvancedSearchPageObjects {
	WebDriver driverObject;

	public CatalogAdvancedSearchPageObjects(WebDriver driverObj) {
		this.driverObject = driverObj;
		PageFactory.initElements(driverObj, this);
	}

	@FindAll(@FindBy(xpath = "//ul[@class='products-grid products-grid--max-4-col first last odd']/li/div/h2/a"))
	List<WebElement> allProductName;

	public List<WebElement> sendObjectAllProductName() {
		return allProductName;
	}
	
	@FindAll(@FindBy(xpath = "//ul[@class='products-grid products-grid--max-4-col first last odd']/li/div/div[1]"))
	List<WebElement> allProductPrice;

	public List<WebElement> sendObjectAllProductPrice() {
		return allProductPrice;
	}
	

}
