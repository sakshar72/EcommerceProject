package ecommerce;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;
import objectRespository.AccountLoginPageObjects;
import objectRespository.BackEndLoginPageObjects;
import objectRespository.CheckoutPageObjects;
import objectRespository.UserAccountPageObjects;
import objectRespository.CreateAccountPageObjects;
import objectRespository.HomePageObjects;
import objectRespository.MyOrderPageObjects;
import objectRespository.MyWishlistPageObjects;
import objectRespository.ShoppingCartPageObjects;
import objectRespository.TVPageObjects;
import resources.UtilitiesFunction;

@SuppressWarnings("deprecation")
public class AccountPage extends UtilitiesFunction {

	UserAccountPageObjects AccountPageObject = null;
	HomePageObjects HomePageObject = null;
	AccountLoginPageObjects AccountLoginPageObject = null;
	CreateAccountPageObjects CreateAccountPageObject = null;
	Properties propertiesFileLoadObject = null;
	TVPageObjects TVPageObject = null;
	MyWishlistPageObjects MyWishlistPageObject = null;
	UserAccountPageObjects UserAccountPageObject = null;
	ShoppingCartPageObjects ShoppingCartPageObject = null;
	CheckoutPageObjects CheckoutPageObject = null;
	Actions actionObject = null;
	Select selectObject = null;
	MyOrderPageObjects MyOrderPageObject = null;
	String productPurchaseName = null;
	String intialPrice = null;
	String finalPrice = null;
	String orderSuccessMesssage = null;
	String orderId = null;
	BackEndLoginPageObjects BackEndLoginPageObject = null;
	File lastModifiedFile1 = null;
	File lastModifiedFile = null;

	@BeforeTest
	public void objectInitialization() throws IOException {
		AccountPageObject = new UserAccountPageObjects(driverObject);
		HomePageObject = new HomePageObjects(driverObject);
		AccountLoginPageObject = new AccountLoginPageObjects(driverObject);
		CreateAccountPageObject = new CreateAccountPageObjects(driverObject);
		propertiesFileLoadObject = propertiesFileLoad();
		TVPageObject = new TVPageObjects(driverObject);
		MyWishlistPageObject = new MyWishlistPageObjects(driverObject);
		UserAccountPageObject = new UserAccountPageObjects(driverObject);
		ShoppingCartPageObject = new ShoppingCartPageObjects(driverObject);
		CheckoutPageObject = new CheckoutPageObjects(driverObject);
		MyOrderPageObject = new MyOrderPageObjects(driverObject);
		BackEndLoginPageObject = new BackEndLoginPageObjects(driverObject);

	}

	@Test
	public void accountCreation() throws InterruptedException {
		HomePageObject.sendObjectAccountBtn().click();
		HomePageObject.sendObjectMyAccountBtn().click();
		AccountLoginPageObject.sendObjectCreateAccountBtn().click();
		formFillingDetails(CreateAccountPageObject, propertiesFileLoadObject);
		try {
			CreateAccountPageObject.sendObjectLoginFailedErrorMessage().isDisplayed();
			System.out.println("Account already Exist");

		} catch (NoSuchElementException e) {
			String accountCreatedSuccessMessage = CreateAccountPageObject.sendObjectAccountCreatedMessage().getText();
			Assert.assertTrue("account not created", accountCreatedSuccessMessage
					.equalsIgnoreCase(propertiesFileLoadObject.getProperty("accountCreatedMessage")));
			CreateAccountPageObject.sendObjectTvNavLink().click();
			TVPageObject.sendObjectAddToWishlistBtn().click();
			MyWishlistPageObject.sendObjectShareWishlistBtn().click();
			MyWishlistPageObject.sendObjectWishListEmailBox()
					.sendKeys(propertiesFileLoadObject.getProperty("sendWishlistEmail"));
			MyWishlistPageObject.sendObjectShareWishlistBtn().click();
			String WishlistShareSuccessMessage = MyWishlistPageObject.sendObjectWishlistShareSuccessMessage().getText();
			Assert.assertTrue("Wishlist not hsared successfully", WishlistShareSuccessMessage
					.equalsIgnoreCase(propertiesFileLoadObject.getProperty("WishlistShareSuccessMessage")));

		}

	}

	@Test
	public void productPurchase() throws InterruptedException {
		HomePageObject.sendObjectAccountBtn().click();
		HomePageObject.sendObjectLoginBtn().click();
		AccountLoginPageObject.sendObjectEmailIdInputField()
				.sendKeys(propertiesFileLoadObject.getProperty("emailAddress"));
		AccountLoginPageObject.sendObjectEmailIdInputField().sendKeys(Keys.TAB);
		AccountLoginPageObject.sendObjectPassowrdInputField()
				.sendKeys(propertiesFileLoadObject.getProperty("password"));
		AccountLoginPageObject.sendObjectLoginBtn().click();
		UserAccountPageObject.sendObjectMyWishListLink().click();
		Assert.assertFalse("WishList Empty", UserAccountPageObject.sendObjectMyWishListLink().isDisplayed());
		MyWishlistPageObject.sendObjectAddToCartBtn().click();
		ShoppingCartPageObject.sendObjectCheckoutBtn().click();
		CheckoutPageObject.sendObjectBillingAddressInputField().click();
		CheckoutPageObject.sendObjectBillingAddressInputField()
				.sendKeys(propertiesFileLoadObject.getProperty("billingAddress"));
		CheckoutPageObject.sendObjectBillingAddressInputField().sendKeys(Keys.TAB);
		CheckoutPageObject.sendObjectBillingAddressSecondField().sendKeys(Keys.TAB);
		CheckoutPageObject.sendObjectBillingCityInputField().sendKeys(propertiesFileLoadObject.getProperty("city"));
		CheckoutPageObject.sendObjectBillingCityInputField().sendKeys(Keys.TAB);
		selectObject = selectObject(CheckoutPageObject.sendObjectStateDropdown());
		selectObject.selectByIndex(5);
		CheckoutPageObject.sendObjectStateDropdown().sendKeys(Keys.TAB);
		CheckoutPageObject.sendObjectPincodeInputField().sendKeys(propertiesFileLoadObject.getProperty("pincode"));
		CheckoutPageObject.sendObjectPincodeInputField().sendKeys(Keys.TAB);
//		selectObject = selectObject(CheckoutPageObject.sendObjectCountrySelector());
		CheckoutPageObject.sendObjectCountrySelector().sendKeys(Keys.TAB);
		CheckoutPageObject.sendObjectTelephoneInputField().sendKeys(propertiesFileLoadObject.getProperty("telephone"));
		CheckoutPageObject.sendObjectTelephoneInputField().sendKeys(Keys.TAB);
		CheckoutPageObject.sendObjectBillingContainerContinueBtn().click();
		CheckoutPageObject.sendObjectShippingContinueBtn().click();
		CheckoutPageObject.sendObjectCheckMoneyPayment().click();
		CheckoutPageObject.sendObjectPaymentContinueBtn().click();
		CheckoutPageObject.sendObjectPlaceOrderBtn().click();
		orderSuccessMesssage = CheckoutPageObject.sendObjectOrderSuccessMessage().getText();
		System.out.println(orderSuccessMesssage);
		System.out.println(propertiesFileLoadObject.getProperty("orderSuccessMessage"));
		Assert.assertTrue("Order place is not successfull",
				orderSuccessMesssage.equalsIgnoreCase(propertiesFileLoadObject.getProperty("orderSuccessMessage")));

	}

	@Test
	public void saveOrder() throws IOException {
		HomePageObject.sendObjectAccountBtn().click();
		HomePageObject.sendObjectLoginBtn().click();
		AccountLoginPageObject.sendObjectEmailIdInputField()
				.sendKeys(propertiesFileLoadObject.getProperty("emailAddress"));
		AccountLoginPageObject.sendObjectEmailIdInputField().sendKeys(Keys.TAB);
		AccountLoginPageObject.sendObjectPassowrdInputField()
				.sendKeys(propertiesFileLoadObject.getProperty("password"));
		AccountLoginPageObject.sendObjectLoginBtn().click();
		UserAccountPageObject.sendObjectMyOrderLink().click();
		MyOrderPageObject.sendObjectViewOrderLink().click();
		productPurchaseName = MyOrderPageObject.sendObjectProductPurchaseName().getText();
		MyOrderPageObject.sendObjectPrintOrderLink().click();
	}

	@Test
	public void reorder() {
		HomePageObject.sendObjectAccountBtn().click();
		HomePageObject.sendObjectLoginBtn().click();
		AccountLoginPageObject.sendObjectEmailIdInputField()
				.sendKeys(propertiesFileLoadObject.getProperty("emailAddress"));
		AccountLoginPageObject.sendObjectEmailIdInputField().sendKeys(Keys.TAB);
		AccountLoginPageObject.sendObjectPassowrdInputField()
				.sendKeys(propertiesFileLoadObject.getProperty("password"));
		AccountLoginPageObject.sendObjectLoginBtn().click();
		UserAccountPageObject.sendObjectReOrderLink().click();
		intialPrice = ShoppingCartPageObject.sendObjectTotalCost().getText();

		actionObject = ActionClass(driverObject);
		actionObject.click(ShoppingCartPageObject.sendObjectQuantityInputField()).sendKeys("2").build().perform();
		ShoppingCartPageObject.sendObjectUpdateBtn().click();
		finalPrice = ShoppingCartPageObject.sendObjectTotalCost().getText();
		Assert.assertFalse("Price Equal.Price not updated", finalPrice.equalsIgnoreCase(intialPrice));
		ShoppingCartPageObject.sendObjectProceedToCheckoutBtn().click();
		CheckoutPageObject.sendObjectBillingContainerContinueBtn().click();
		CheckoutPageObject.sendObjectShippingContinueBtn().click();
		CheckoutPageObject.sendObjectCheckMoneyPayment().click();
		CheckoutPageObject.sendObjectPaymentContinueBtn().click();
		CheckoutPageObject.sendObjectPlaceOrderBtn().click();
		orderSuccessMesssage = CheckoutPageObject.sendObjectOrderSuccessMessage().getText();
		System.out.println(orderSuccessMesssage);
		System.out.println(propertiesFileLoadObject.getProperty("orderSuccessMessage"));
		Assert.assertTrue("Order place is not successfull",
				orderSuccessMesssage.equalsIgnoreCase(propertiesFileLoadObject.getProperty("orderSuccessMessage")));
		orderId = CheckoutPageObject.sendObjectOrderID().getText().substring(17);
		System.out.println(orderId);
	}

	@Test
	public void orderExportBackend() {
		driverObject.get(propertiesFileLoadObject.getProperty("backEndURL"));
		actionObject = ActionClass(driverObject);
		actionObject
				.sendKeys(BackEndLoginPageObject.sendObjectUsernameLoginField(),
						propertiesFileLoadObject.getProperty("emailAddressBackEnd"))
				.sendKeys(Keys.TAB).build().perform();
		actionObject
				.sendKeys(BackEndLoginPageObject.sendObjectPasswordLoginField(),
						propertiesFileLoadObject.getProperty("passwordBackEnd"))
				.click(BackEndLoginPageObject.sendObjectLoginBtn()).build().perform();
		BackEndLoginPageObject.sendObjectPopUpCloseBtn().click();
		actionObject.moveToElement(BackEndLoginPageObject.sendObjectFirstNavLink())
				.click(BackEndLoginPageObject.sendObjectOrderLink()).build().perform();
		BackEndLoginPageObject.sendObjectExportBtn().click();

	}

	@Test
	public void verifyInvoicePrinted() throws InterruptedException {
		lastModifiedFile = getLatestFilefromDir("C:\\Users\\sakgupta1\\Downloads");
		System.out.println(lastModifiedFile);
		driverObject.get(propertiesFileLoadObject.getProperty("backEndURL"));
		actionObject = ActionClass(driverObject);
		actionObject
				.sendKeys(BackEndLoginPageObject.sendObjectUsernameLoginField(),
						propertiesFileLoadObject.getProperty("emailAddressBackEnd"))
				.sendKeys(Keys.TAB).build().perform();
		actionObject
				.sendKeys(BackEndLoginPageObject.sendObjectPasswordLoginField(),
						propertiesFileLoadObject.getProperty("passwordBackEnd"))
				.click(BackEndLoginPageObject.sendObjectLoginBtn()).build().perform();
		BackEndLoginPageObject.sendObjectPopUpCloseBtn().click();
		actionObject.moveToElement(BackEndLoginPageObject.sendObjectFirstNavLink())
				.click(BackEndLoginPageObject.sendObjectOrderLink()).build().perform();
		selectObject = selectObject(BackEndLoginPageObject.sendObjectActionDropdown());
		selectObject.selectByIndex(1);
		BackEndLoginPageObject.sendObjectSearchBtn().click();
		Thread.sleep(2000L);
		BackEndLoginPageObject.sendObjectOrderCheckBox().click();
		selectObject = selectObject(BackEndLoginPageObject.sendObjectActionInvoiceDropdown());
		selectObject.selectByIndex(4);
		BackEndLoginPageObject.sendObjectSubmitBtn().click();
		SoftAssert softAssertObj = new SoftAssert();
		softAssertObj.assertTrue(BackEndLoginPageObject.sendObjectErrorMessageBlock().isDisplayed());
		softAssertObj.assertEquals(BackEndLoginPageObject.sendObjectErrorMessage().getText(),
				propertiesFileLoadObject.getProperty("backEndErrorMessage"));
		selectObject = selectObject(BackEndLoginPageObject.sendObjectActionDropdown());
		selectObject.selectByIndex(3);
		BackEndLoginPageObject.sendObjectSearchBtn().click();
		Thread.sleep(2000L);
		BackEndLoginPageObject.sendObjectOrderCheckBox().click();
		selectObject = selectObject(BackEndLoginPageObject.sendObjectActionInvoiceDropdown());
		selectObject.selectByIndex(4);
		BackEndLoginPageObject.sendObjectSubmitBtn().click();
		Thread.sleep(7000L);
		lastModifiedFile1 = getLatestFilefromDir("C:\\Users\\sakgupta1\\Downloads");

	}
}
