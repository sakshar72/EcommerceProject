package ecommerce;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objectRespository.ShoppingCartPageObjects;
import objectRespository.XperiaProductDescriptionPageObjects;
import resources.UtilitiesFunction;

public class XperiaProductDescriptionPage extends UtilitiesFunction {
	XperiaProductDescriptionPageObjects XperiaProductDescriptionPageObject = null;
	ShoppingCartPageObjects ShoppingCartPageObject = null;
	Actions actionObj = null;
	Properties propertiesFileObject;
	String cartEmptyMessage = null;
	String productLimitErrorMessage = null;

	@BeforeTest
	public void objectInitializations() {
		XperiaProductDescriptionPageObject = new XperiaProductDescriptionPageObjects(driverObject);
		ShoppingCartPageObject = new ShoppingCartPageObjects(driverObject);
	}

	@Test
	public void addToCartLimitReach() throws InterruptedException, IOException {
		XperiaProductDescriptionPageObject.sendObjectAddToCart().click();
		actionObj = ActionClass(driverObject);
		propertiesFileObject = propertiesFileLoad();
		actionObj.click(ShoppingCartPageObject.sendObjectProductQuantityInputField())
				.sendKeys(ShoppingCartPageObject.sendObjectProductQuantityInputField(), "1000").build().perform();
		ShoppingCartPageObject.sendObjectProductQuantityUpdateBtn().click();
		if (ShoppingCartPageObject.sendObjectProductLimitErrorMessage().isDisplayed()) {
			productLimitErrorMessage = ShoppingCartPageObject.sendObjectProductLimitErrorMessage().getText();
			ShoppingCartPageObject.sendObjectEmptyCartBtn().click();
			cartEmptyMessage = ShoppingCartPageObject.sendObjectEmptyCartMessage().getText();
			Assert.assertTrue(propertiesFileObject.getProperty("cartEmptyMessage").equalsIgnoreCase(cartEmptyMessage),
					"Cart is not empty");
		}
	}
}
