package objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	WebDriver driverObject;

	public HomePageObjects(WebDriver driverObj) {
		this.driverObject = driverObj;
		PageFactory.initElements(driverObj, this);
	}

	@FindBy(xpath = "//nav[@id='nav']/ol/li[1]")
	WebElement mobileNavButton;

	public WebElement sendObjectMobileNavButton() {
		return mobileNavButton;
	}

	@FindBy(xpath = "//div[@class='account-cart-wrapper']/a/span[2]")
	WebElement accountBtn;

	@FindBy(xpath = "//div[@id='header-account']/div/ul/li[1]/a")
	WebElement myAccountBtn;

	public WebElement sendObjectMyAccountBtn() {
		return myAccountBtn;
	}

	@FindBy(xpath = "//a[text()='Log In']")
	WebElement loginBtn;

	public WebElement sendObjectLoginBtn() {
		return loginBtn;
	}

	public WebElement sendObjectAccountBtn() {
		return accountBtn;
	}

	@FindBy(xpath = "//a[@title='Advanced Search']")
	WebElement advanceSearchBtn;

	public WebElement sendObjectAdvanceSearchBtn() {
		return advanceSearchBtn;
	}

	@FindBy(xpath = "//input[@id='price']")
	WebElement priceInputField;

	public WebElement sendObjectPriceInputField() {
		return priceInputField;
	}

	@FindBy(xpath = "//input[@id='price_to']")
	WebElement priceToInputField;

	public WebElement sendObjectPriceToInputField() {
		return priceToInputField;
	}

	@FindBy(xpath = "//div[@class='buttons-set']/button[@title='Search']")
	WebElement searchBtn;

	public WebElement sendObjectSearchBtn() {
		return searchBtn;
	}
}
