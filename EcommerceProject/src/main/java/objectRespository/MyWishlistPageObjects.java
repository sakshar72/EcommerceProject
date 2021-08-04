package objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishlistPageObjects {
	WebDriver driverObject;

	public MyWishlistPageObjects(WebDriver driverObj) {
		this.driverObject = driverObj;
		PageFactory.initElements(driverObj, this);
	}

	@FindBy(xpath = "//span[text()='Share Wishlist']")
	WebElement shareWishlistBtn;

	public WebElement sendObjectShareWishlistBtn() {
		return shareWishlistBtn;
	}

	@FindBy(xpath = "//textarea[@name='emails']")
	WebElement wishListEmailBox;

	public WebElement sendObjectWishListEmailBox() {
		return wishListEmailBox;
	}

	@FindBy(xpath = "//li[@class='success-msg']/ul/li/span")
	WebElement wishlistShareSuccessMessage;

	public WebElement sendObjectWishlistShareSuccessMessage() {
		return wishlistShareSuccessMessage;
	}

	@FindBy(xpath = "//button[@title='Add to Cart']")
	WebElement addToCartBtn;

	public WebElement sendObjectAddToCartBtn() {
		return addToCartBtn;
	}

}
