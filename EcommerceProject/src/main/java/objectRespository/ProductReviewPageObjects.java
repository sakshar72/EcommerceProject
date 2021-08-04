package objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductReviewPageObjects {

	WebDriver driverObject;

	public ProductReviewPageObjects(WebDriver driverObject) {
		this.driverObject = driverObject;
		PageFactory.initElements(driverObject, this);

	}

	@FindBy(xpath = "//textarea[@id='review_field']")
	WebElement reviewField;

	public WebElement sendObjectReviewField() {
		return reviewField;
	}

	@FindBy(xpath = "//input[@id='Quality 1_4']")
	WebElement qualityCheckBox;

	public WebElement sendObjectQualityCheckBox() {
		return qualityCheckBox;
	}

	@FindBy(xpath = "//input[@id='summary_field']")
	WebElement summaryField;

	public WebElement sendObjectSummaryField() {
		return summaryField;
	}

	@FindBy(xpath = "//input[@id='nickname_field']")
	WebElement nickNameField;

	public WebElement sendObjectNicknameField() {
		return nickNameField;
	}

	@FindBy(xpath = "//button[@title='Submit Review']")
	WebElement submitReviewBtn;

	public WebElement sendObjectSubmitReviewBtn() {
		return submitReviewBtn;
	}

	@FindBy(xpath = "//ul[@id='nav']/li[2]")
	WebElement catalogNavLink;

	public WebElement sendObjectCatalogNavLink() {
		return catalogNavLink;
	}

	@FindBy(xpath = "//ul[@id='nav']/li[2]/ul/li")
	WebElement reviewRatingLink;

	public WebElement sendObjectReviewRatingLink() {
		return reviewRatingLink;
	}

	@FindBy(xpath = "//ul[@id='nav']/li[2]/ul/li/ul/li[1]")
	WebElement customerReviewLink;

	public WebElement sendObjectCustomerReviewLink() {
		return customerReviewLink;
	}

	@FindBy(xpath = "//ul[@id='nav']/li[2]/ul/li/ul/li[1]/ul/li[1]")
	WebElement reviewPendingLink;

	public WebElement sendObjectReviewPendingLink() {
		return reviewPendingLink;
	}


}
