package objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountPageObjects {
	WebDriver driverObject;

	public UserAccountPageObjects(WebDriver driverObj) {
		this.driverObject = driverObj;
		PageFactory.initElements(driverObj, this);
	}

	@FindBy(xpath = "//div[@class='col-left sidebar col-left-first']/div[1]/div[2]/ul/li[8]/a")
	WebElement myWishListLink;

	public WebElement sendObjectMyWishListLink() {
		return myWishListLink;
	}

	@FindBy(xpath = "//div[@class='col-left sidebar col-left-first']/div[1]/div[2]/ul/li[4]/a")
	WebElement myOrderLink;

	public WebElement sendObjectMyOrderLink() {
		return myOrderLink;
	}

	@FindBy(xpath = "//a[text()='Reorder']")
	WebElement reOrderLink;

	public WebElement sendObjectReOrderLink() {
		return reOrderLink;
	}

	@FindBy(xpath = "//div[@class='fieldset']/p")
	WebElement wishListEmptyMessage;

	public WebElement sendObjectWishListEmptyMessage() {
		return wishListEmptyMessage;
	}

	@FindBy(xpath = "//div[@class='col-main']/div/div/div[3]/div[2]/div[1]/div/div[2]/p")
	WebElement userEmailId;

	public WebElement sendObjectUserEmailId() {
		return userEmailId;
	}

}
