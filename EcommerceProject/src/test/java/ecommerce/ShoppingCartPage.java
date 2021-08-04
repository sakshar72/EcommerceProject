package ecommerce;

import org.testng.annotations.BeforeTest;

import objectRespository.ShoppingCartPageObjects;
import resources.UtilitiesFunction;

public class ShoppingCartPage extends UtilitiesFunction {
	ShoppingCartPageObjects ShoppingCartPageObject = null;

	@BeforeTest
	public void objectIntitializations() {
		ShoppingCartPageObject = new ShoppingCartPageObjects(driverObject);

	}
}
