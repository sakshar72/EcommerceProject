package objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BackEndLoginPageObjects {
	WebDriver driverObject;

	public BackEndLoginPageObjects(WebDriver driverObj) {
		this.driverObject = driverObj;
		PageFactory.initElements(driverObj, this);
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement usernameLoginField;

	public WebElement sendObjectUsernameLoginField() {
		return usernameLoginField;
	}

	@FindBy(xpath = "//input[@id='login']")
	WebElement passwordLoginField;

	public WebElement sendObjectPasswordLoginField() {
		return passwordLoginField;
	}

	@FindBy(xpath = "//input[@title='Login']")
	WebElement loginBtn;

	public WebElement sendObjectLoginBtn() {
		return loginBtn;
	}

	@FindBy(xpath = "//a[@title='close']")
	WebElement popUpCloseBtn;

	public WebElement sendObjectPopUpCloseBtn() {
		return popUpCloseBtn;
	}

	@FindBy(xpath = "//ul[@id='nav']/li[1]")
	WebElement firstNavLink;

	public WebElement sendObjectFirstNavLink() {
		return firstNavLink;
	}

	@FindBy(xpath = "//ul[@id='nav']/li[1]/ul/li[1]/a")
	WebElement orderLink;

	public WebElement sendObjectOrderLink() {
		return orderLink;
	}

	@FindBy(xpath = "//span[text()='Export']")
	WebElement exportBtn;

	public WebElement sendObjectExportBtn() {
		return exportBtn;
	}

	@FindBy(xpath = "//select[@id='sales_order_grid_filter_status']")
	WebElement actionDropdown;

	public WebElement sendObjectActionDropdown() {
		return actionDropdown;
	}

	@FindBy(xpath = "//button[@title='Search']")
	WebElement searchBtn;

	public WebElement sendObjectSearchBtn() {
		return searchBtn;
	}

	@FindBy(xpath = "//button[@title='Submit']")
	WebElement submitBtn;

	public WebElement sendObjectSubmitBtn() {
		return submitBtn;
	}

	@FindBy(xpath = "//table[@id='sales_order_grid_table']/tbody/tr[1]/td[1]/input")
	WebElement orderCheckBox;

	public WebElement sendObjectOrderCheckBox() {
		return orderCheckBox;
	}

	@FindBy(xpath = "//select[@id='sales_order_grid_massaction-select']")
	WebElement actionInvoiceDropdown;

	public WebElement sendObjectActionInvoiceDropdown() {
		return actionInvoiceDropdown;
	}

	@FindBy(xpath = "//div[@id='messages']")
	WebElement errorMessageBlock;

	public WebElement sendObjectErrorMessageBlock() {
		return errorMessageBlock;
	}

	@FindBy(xpath = "//div[@id='messages']/ul/li/ul/li/span")
	WebElement errorMessage;

	public WebElement sendObjectErrorMessage() {
		return errorMessage;
	}

	@FindBy(xpath = "//a[@name='review_id']")
	WebElement sortByIDBtn;

	public WebElement sendObjectSortByIDBtn() {
		return sortByIDBtn;
	}

	@FindBy(xpath = "//table[@id='reviwGrid_table']/tbody/tr[1]/td[10]/a")
	WebElement editCommentLink;

	public WebElement sendObjectEditCommentLink() {
		return editCommentLink;
	}

	@FindBy(xpath = "//select[@id='status_id']")
	WebElement reviewStatusDropdown;

	public WebElement sendObjectStatusDropdown() {
		return reviewStatusDropdown;
	}

	@FindBy(xpath = "//button[@id='save_button']")
	WebElement saveReviewBtn;

	public WebElement sendObjectSaveReviewBtn() {
		return saveReviewBtn;
	}

	@FindBy(xpath = "//ul[@id='nav']/li[3]")
	WebElement customerNavLink;

	public WebElement sendObjectCustomerNavLink() {
		return customerNavLink;
	}

	@FindBy(xpath = "//ul[@id='nav']/li[3]/ul/li/a/span")
	WebElement manageCustomerNavLink;

	public WebElement sendObjectManageCustomerNavLink() {
		return manageCustomerNavLink;
	}

	@FindBy(xpath = "//table[@id='customerGrid_table']/tbody/tr[2]/td[3]")
	WebElement CustomerName;

	public WebElement sendObjectCustomerName() {
		return CustomerName;
	}

	@FindBy(xpath = "//a[@id='customer_info_tabs_account']")
	WebElement accountInformationLink;

	public WebElement sendObjectAccountInformationLink() {
		return accountInformationLink;
	}

	@FindBy(xpath = "//select[@id='_accountwebsite_id']")
	WebElement associateToWebsiteDropdown;

	public WebElement sendObjectAssociateToWebsiteDropdown() {
		return associateToWebsiteDropdown;
	}

}
