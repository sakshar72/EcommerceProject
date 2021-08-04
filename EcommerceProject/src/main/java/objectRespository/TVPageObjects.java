package objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TVPageObjects {
	WebDriver driverObject;

	public TVPageObjects(WebDriver driverObj) {
		this.driverObject = driverObj;
		PageFactory.initElements(driverObj, this);
	}

	@FindBy(xpath = "//li[@class='item last'][1]/div/div[@class='actions']/ul/li[1]")
	WebElement addToWishlistBtn;

	public WebElement sendObjectAddToWishlistBtn() {
		return addToWishlistBtn;
	}

}
