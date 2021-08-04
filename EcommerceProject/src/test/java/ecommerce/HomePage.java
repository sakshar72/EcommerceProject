package ecommerce;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import objectRespository.BackEndLoginPageObjects;
import objectRespository.CatalogAdvancedSearchPageObjects;
import objectRespository.HomePageObjects;
//import objectRespository.MobileListingPageObjects;
import resources.UtilitiesFunction;

public class HomePage extends UtilitiesFunction {
//	UtilitiesFunction UtilitiesFunctionObject = null;
	WebDriver driverObject = null;
	Properties propertiesFileLoadObject = null;
	HomePageObjects HomePageObject = null;
//	MobileListingPageObjects MobileListingRepositoryPageObject = null;
	Actions actionObject = null;
	CatalogAdvancedSearchPageObjects CatalogAdvancedSearchPageObject = null;
	BackEndLoginPageObjects BackEndLoginPageObject = null;
	Select selectObject = null;

	@BeforeSuite
	public void initializations() throws IOException {
		driverObject = browserinitialization();
		propertiesFileLoadObject = propertiesFileLoad();
		driverObject.manage().window().maximize();
		driverObject.get(propertiesFileLoadObject.getProperty("homePageURL"));
		HomePageObject = new HomePageObjects(driverObject);
		CatalogAdvancedSearchPageObject = new CatalogAdvancedSearchPageObjects(driverObject);
		BackEndLoginPageObject = new BackEndLoginPageObjects(driverObject);

	}

	@Test
	public void verifyHomePageTitle() {
		Assert.assertTrue(propertiesFileLoadObject.getProperty("pageTitle").equals(driverObject.getTitle()),
				"Page title is not matching from properties file " + propertiesFileLoadObject.getProperty("pageTitle")
						+ "from web page" + driverObject.getTitle());
	}

	@Test
	public void verifyMobileSubPageTitle() {
		HomePageObject.sendObjectMobileNavButton().click();
		Assert.assertTrue(propertiesFileLoadObject.getProperty("MobilePageTitle").equals(driverObject.getTitle()),
				"Page title is not matching from properties file "
						+ propertiesFileLoadObject.getProperty("MobilePageTitle") + "from web page"
						+ driverObject.getTitle());

	}

	@Test
	public void searchFunctionality() {
		HomePageObject.sendObjectAdvanceSearchBtn().click();
		actionObject = ActionClass(driverObject);
		actionObject.click(HomePageObject.sendObjectPriceInputField())
				.sendKeys(propertiesFileLoadObject.getProperty("priceFrom")).sendKeys(Keys.TAB)
				.sendKeys(propertiesFileLoadObject.getProperty("priceTo")).build().perform();
		HomePageObject.sendObjectSearchBtn().click();

		int numberOfElements = CatalogAdvancedSearchPageObject.sendObjectAllProductName().size();
		for (int i = 0; i <= numberOfElements; i++) {
			System.out.println(i + " Product Name "
					+ CatalogAdvancedSearchPageObject.sendObjectAllProductName().get(i).getText() + " Product Price "
					+ CatalogAdvancedSearchPageObject.sendObjectAllProductPrice().get(i).getText());
		}

	}

	@Test
	public void verifyDisabledFields() {
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
		actionObject.moveToElement(BackEndLoginPageObject.sendObjectCustomerNavLink())
				.click(BackEndLoginPageObject.sendObjectManageCustomerNavLink()).build().perform();
		BackEndLoginPageObject.sendObjectCustomerName().click();
		BackEndLoginPageObject.sendObjectAccountInformationLink().click();
		selectObject = selectObject(BackEndLoginPageObject.sendObjectAssociateToWebsiteDropdown());
		selectObject.selectByIndex(0);
		

	}
}
