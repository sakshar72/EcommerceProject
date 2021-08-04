package objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileListingPageObjects {
	WebDriver driverObject;

	public MobileListingPageObjects(WebDriver driverObj) {
		this.driverObject = driverObj;
		PageFactory.initElements(driverObj, this);
	}

	@FindBy(xpath = "//div[@class='col-wrapper']/div[1]/div[3]/div[1]/div[1]/div/select")
	WebElement sortByDropdown;

	@FindBy(xpath = "//a[@title='Site Map']")
	WebElement linkText;

	@FindBy(xpath = "//span[@id='product-price-1']/span")
	WebElement productPrice;

	@FindBy(xpath = "//div[@class='category-products']/ul/li[1]/div/h2/a")
	WebElement productName;

	@FindBy(xpath = "//li[@class='item last'][1]/div/div[@class='actions']/ul/li[2]")
	WebElement xperiaAddToCompareBtn;

	@FindBy(xpath = "//li[@class='item last'][2]/div/div[@class='actions']/ul/li[2]")
	WebElement iphoneAddToCompareBtn;

	@FindBy(xpath = "//button[@title='Compare']")
	WebElement compareBtn;

	@FindBy(xpath = "//div[@class='block-content']/ol/li[1]/p/a")
	WebElement firstProductName;

	@FindBy(xpath = "//div[@class='block-content']/ol/li[2]/p/a")
	WebElement secondProductName;

	public WebElement sendObjectFirstProductName() {
		return firstProductName;
	}

	@FindBy(xpath = "//img[@id='product-collection-image-1']")
	WebElement sonyXperiaSelectProduct;

	public WebElement sendObjectSonyXperiaSelectProduct() {
		return sonyXperiaSelectProduct;
	}

	public WebElement sendObjectSecondProductName() {
		return secondProductName;
	}

	public WebElement sendObjectCompareBtn() {
		return compareBtn;
	}

	public WebElement sendObjectXperiaAddToCompareBtn() {
		return xperiaAddToCompareBtn;
	}

	public WebElement sendObjectIphoneAddToCompareBtn() {
		return iphoneAddToCompareBtn;
	}

	public WebElement sendObjectSortByDropdown() {
		return sortByDropdown;
	}

	public WebElement sendObjectLinkText() {
		return linkText;
	}

	public WebElement sendProductPrice() {
		return productPrice;
	}

	public WebElement sendObjectProductName() {
		return productName;
	}
	
	

	@FindBy(xpath = "//li[@class='item last'][2]/div/div[@class='actions']/button")
	WebElement iphoneAddToCart;

	public WebElement sendObjectIphoneAddToCart() {
		return iphoneAddToCart;
	}

}
