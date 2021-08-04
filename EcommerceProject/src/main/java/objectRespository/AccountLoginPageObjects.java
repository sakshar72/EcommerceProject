package objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountLoginPageObjects {
	WebDriver driverObject;

	public AccountLoginPageObjects(WebDriver driverObj) {
		this.driverObject = driverObj;
		PageFactory.initElements(driverObj, this);
	}

	@FindBy(xpath = "//a[@title='Create an Account']")
	WebElement createAccountBtn;

	public WebElement sendObjectCreateAccountBtn() {
		return createAccountBtn;
	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailIdInputField;

	public WebElement sendObjectEmailIdInputField() {
		return emailIdInputField;
	}

	@FindBy(xpath = "//input[@id='pass']")
	WebElement passwordInputField;

	public WebElement sendObjectPassowrdInputField() {
		return passwordInputField;
	}

	@FindBy(xpath = "//button[@id='send2']")
	WebElement loginBtn;

	public WebElement sendObjectLoginBtn() {
		return loginBtn;
	}

	@FindBy(xpath = "//li[@class='error-msg']/ul/li/span")
	WebElement loginDetailsInvalidMessage;

	public WebElement sendObjectLoginDetailsInvalidMessage() {
		return loginDetailsInvalidMessage;
	}

}
