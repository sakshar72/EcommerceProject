package ecommerce;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objectRespository.BackEndLoginPageObjects;
import objectRespository.HomePageObjects;
import objectRespository.MobileListingPageObjects;
import objectRespository.ProductReviewPageObjects;
import objectRespository.SonyXperiaProductPageObjects;
import resources.UtilitiesFunction;

public class ProductReviewPage extends UtilitiesFunction {
	Properties propertiesFileLoadObject = null;
	ProductReviewPageObjects ProductReviewPageObject = null;
	Actions actionObject = null;
	BackEndLoginPageObjects BackEndLoginPageObject = null;
	Select selectObject = null;
	HomePageObjects HomePageObject = null;
	MobileListingPageObjects mobileListingPageObject = null;
	SonyXperiaProductPageObjects SonyXperiaProductPageObject = null;

	@BeforeTest
	public void objectInitialization() throws IOException {
		propertiesFileLoadObject = propertiesFileLoad();
		ProductReviewPageObject = new ProductReviewPageObjects(driverObject);
		BackEndLoginPageObject = new BackEndLoginPageObjects(driverObject);
		HomePageObject = new HomePageObjects(driverObject);
		mobileListingPageObject = new MobileListingPageObjects(driverObject);
		SonyXperiaProductPageObject = new SonyXperiaProductPageObjects(driverObject);
	}

	@Test
	public void verfiyProductReviewMech() {
		driverObject.get(propertiesFileLoadObject.getProperty("reviewPageURL"));
		ProductReviewPageObject.sendObjectQualityCheckBox().click();
		actionObject = ActionClass(driverObject);
		actionObject.click(ProductReviewPageObject.sendObjectReviewField())
				.sendKeys(propertiesFileLoadObject.getProperty("productReviewField")).sendKeys(Keys.TAB).build()
				.perform();
		actionObject.sendKeys(propertiesFileLoadObject.getProperty("summaryReviewField")).sendKeys(Keys.TAB).build()
				.perform();
		ProductReviewPageObject.sendObjectNicknameField()
				.sendKeys(propertiesFileLoadObject.getProperty("nicknamefield"));
		ProductReviewPageObject.sendObjectSubmitReviewBtn().click();
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
		actionObject.moveToElement(ProductReviewPageObject.sendObjectCatalogNavLink())
				.moveToElement(ProductReviewPageObject.sendObjectReviewRatingLink())
				.moveToElement(ProductReviewPageObject.sendObjectCustomerReviewLink())
				.moveToElement(ProductReviewPageObject.sendObjectReviewPendingLink()).click().build().perform();
		BackEndLoginPageObject.sendObjectEditCommentLink().click();
		selectObject = selectObject(BackEndLoginPageObject.sendObjectStatusDropdown());
		selectObject.selectByVisibleText("Approved");
		BackEndLoginPageObject.sendObjectSaveReviewBtn().click();
		SoftAssert softAssertObject = new SoftAssert();
		softAssertObject.assertEquals(BackEndLoginPageObject.sendObjectErrorMessage().getText(),
				propertiesFileLoadObject.getProperty("reviewSavedMessage"));
		driverObject.get(propertiesFileLoadObject.getProperty("homePageURL"));
		HomePageObject.sendObjectMobileNavButton().click();
		mobileListingPageObject.sendObjectSonyXperiaSelectProduct().click();
		SonyXperiaProductPageObject.sendObjectReviewTablink().click();
		int numberOfAnchorElement = SonyXperiaProductPageObject.sendObjectAllAnchorElements().size();
		for (int i = 0; i < numberOfAnchorElement; i++) {
			if (SonyXperiaProductPageObject.sendObjectAllAnchorElements().get(i).getText()
					.equalsIgnoreCase(propertiesFileLoadObject.getProperty("summaryReviewField"))) {
				System.out.println("String Matched");
				break;
			}

		}
		softAssertObject.assertAll();
	}

}
