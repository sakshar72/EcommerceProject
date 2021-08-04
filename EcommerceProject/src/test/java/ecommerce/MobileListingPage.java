package ecommerce;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ReporterConfig.Property;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objectRespository.CheckoutPageObjects;
import objectRespository.HomePageObjects;
import objectRespository.MobileListingPageObjects;
import objectRespository.ProductComparisonPageObjects;
import objectRespository.XperiaProductDescriptionPageObjects;
import resources.UtilitiesFunction;

public class MobileListingPage extends UtilitiesFunction {

	MobileListingPageObjects MobileListingRepositoryPageObject = null;
	Select selectObj = null;
	String productPrice = null;
	XperiaProductDescriptionPageObjects XperiaProductDescriptionPageObjectss;
	ProductComparisonPageObjects ProductComparisonPageObject = null;
	HomePageObjects HomePageObject = null;
	CheckoutPageObjects CheckoutPageObject = null;
	Properties propertyObject = null;

	@BeforeTest
	public void objectInitialization() throws IOException {
		MobileListingRepositoryPageObject = new MobileListingPageObjects(driverObject);
		XperiaProductDescriptionPageObjectss = new XperiaProductDescriptionPageObjects(driverObject);
		ProductComparisonPageObject = new ProductComparisonPageObjects(driverObject);
		HomePageObject = new HomePageObjects(driverObject);
		CheckoutPageObject = new CheckoutPageObjects(driverObject);
		propertyObject = propertiesFileLoad();

	}

	@Test
	public void sortProductByName() {
		selectObj = selectObject(MobileListingRepositoryPageObject.sendObjectSortByDropdown());
		selectObj.selectByIndex(1);
	}

	@Test
	public void validateProductPrice() {
		selectObj = selectObject(MobileListingRepositoryPageObject.sendObjectSortByDropdown());
		selectObj.selectByIndex(0);
		productPrice = MobileListingRepositoryPageObject.sendProductPrice().getText();
		MobileListingRepositoryPageObject.sendObjectProductName().click();
		System.out.println("Inside mobiel listing " + XperiaProductDescriptionPageObjectss);
		Assert.assertTrue(
				XperiaProductDescriptionPageObjectss.sendObjectXperiaProductPrice().getText().equals(productPrice),
				"Product Price is not matching ");

	}

	@Test
	public void compareProducts() {
		MobileListingRepositoryPageObject.sendObjectXperiaAddToCompareBtn().click();
		MobileListingRepositoryPageObject.sendObjectIphoneAddToCompareBtn().click();
		String firstProductName = MobileListingRepositoryPageObject.sendObjectFirstProductName().getText();
		String secondProductName = MobileListingRepositoryPageObject.sendObjectSecondProductName().getText();
		MobileListingRepositoryPageObject.sendObjectCompareBtn().click();
		String mainWindowHandle = handlingMultipleWindows(driverObject);
		Assert.assertEquals(firstProductName, ProductComparisonPageObject.sendObjectFirstProductHeading().getText());
		Assert.assertEquals(secondProductName, ProductComparisonPageObject.sendObjectSecongProductHeading().getText());
		browserClose();
		driverObject.switchTo().window(mainWindowHandle);
	}

	@Test
	public void applyCouponCode() {
		HomePageObject.sendObjectMobileNavButton().click();
		MobileListingRepositoryPageObject.sendObjectIphoneAddToCart().click();
		CheckoutPageObject.sendObjectDiscountCodeInputField().sendKeys(propertyObject.getProperty("discountCode"));
		CheckoutPageObject.sendObjectDiscountCodeApplyBtn().click();
		try {
			Assert.assertFalse(CheckoutPageObject.sendObjectCouponCodeErrorMessage().isDisplayed(),
					"Error Code is Incorrect");

		} catch (NoSuchElementException e) {
			Assert.assertFalse(CheckoutPageObject.sendObjectTotalPrice().getText().equalsIgnoreCase(
					CheckoutPageObject.sendObjectDiscountedPrice().getText()), "Discount Code is not applied ");
		}

	}
}
