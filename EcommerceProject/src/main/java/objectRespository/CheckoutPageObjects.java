package objectRespository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPageObjects {
	WebDriver driverObject;

	public CheckoutPageObjects(WebDriver driverObj) {
		this.driverObject = driverObj;
		PageFactory.initElements(driverObj, this);
	}

	@FindBy(xpath = "//input[@id='billing:street1']")
	WebElement billingAddressInputField;

	public WebElement sendObjectBillingAddressInputField() {
		return billingAddressInputField;
	}

	@FindBy(xpath = "//input[@id='billing:street2']")
	WebElement billingAddressSecondField;

	public WebElement sendObjectBillingAddressSecondField() {
		return billingAddressSecondField;
	}

	@FindBy(xpath = "//input[@id='billing:city']")
	WebElement BillingCityInputField;

	public WebElement sendObjectBillingCityInputField() {
		return BillingCityInputField;
	}

	@FindBy(xpath = "//select[@id='billing:region_id']")
	WebElement StateDropdown;

	public WebElement sendObjectStateDropdown() {
		return StateDropdown;
	}

	@FindBy(xpath = "//input[@id='billing:postcode']")
	WebElement pincodeInputField;

	public WebElement sendObjectPincodeInputField() {
		return pincodeInputField;
	}

	@FindBy(xpath = "//input[@id='billing:postcode']")
	WebElement countrySelector;

	public WebElement sendObjectCountrySelector() {
		return countrySelector;
	}

	@FindBy(xpath = "//input[@id='billing:telephone']")
	WebElement telephoneInputField;

	public WebElement sendObjectTelephoneInputField() {
		return telephoneInputField;
	}

	@FindBy(xpath = "//div[@id='billing-buttons-container']/button")
	WebElement billingContainerContinueBtn;

	public WebElement sendObjectBillingContainerContinueBtn() {
		return billingContainerContinueBtn;
	}

	@FindBy(xpath = "//label[text()='Check / Money order ']")
	WebElement checkMoneyPayment;

	public WebElement sendObjectCheckMoneyPayment() {
		return checkMoneyPayment;
	}

	@FindBy(xpath = "//div[@id='payment-buttons-container']/button")
	WebElement paymentContinueBtn;

	public WebElement sendObjectPaymentContinueBtn() {
		return paymentContinueBtn;
	}

	@FindBy(xpath = "//div[@id='shipping-method-buttons-container']/button")
	WebElement shippingContinueBtn;

	public WebElement sendObjectShippingContinueBtn() {
		return shippingContinueBtn;
	}

	@FindBy(xpath = "//button[@title='Place Order']")
	WebElement placeOrderBtn;

	public WebElement sendObjectPlaceOrderBtn() {
		return placeOrderBtn;
	}

	@FindBy(xpath = "//div[@class='page-title']/h1")
	WebElement orderSuccessMessage;

	public WebElement sendObjectOrderSuccessMessage() {
		return orderSuccessMessage;
	}

	@FindBy(xpath = "//div[@class='col-main']/p[1]")
	WebElement orderID;

	public WebElement sendObjectOrderID() {
		return orderID;
	}

	@FindBy(xpath = "//input[@id='coupon_code']")
	WebElement discountCodeInputField;

	public WebElement sendObjectDiscountCodeInputField() {
		return discountCodeInputField;
	}

	@FindBy(xpath = "//button[@title='Apply']")
	WebElement discountCodeApplyBtn;

	public WebElement sendObjectDiscountCodeApplyBtn() {
		return discountCodeApplyBtn;
	}

	@FindBy(xpath = "//table[@id='shopping-cart-totals-table']/tbody/tr[1]/td[2]/span")
	WebElement totalPrice;

	public WebElement sendObjectTotalPrice() {
		return totalPrice;
	}

	@FindBy(xpath = "//li[@class='error-msg']/ul/li/span")
	WebElement couponCodeErrorMessage;

	public WebElement sendObjectCouponCodeErrorMessage() {
		return couponCodeErrorMessage;
	}

	@FindBy(xpath = "//table[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")
	WebElement discountedPrice;

	public WebElement sendObjectDiscountedPrice() {
		return discountedPrice;
	}

}
