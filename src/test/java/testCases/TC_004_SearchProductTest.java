package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_004_SearchProductTest extends BaseClass {

	@Test(groups = { "master" })
	public void verify_pruductSearch() throws InterruptedException {
		logger.info(" Starting TC_004_SearchProductTest ");

		try {

			HomePage hm = new HomePage(driver);

			// hm.enterProductName("iPhone");
			hm.enterProductName("mac");
			logger.info("Product name entered in search box");

			hm.clickSearch();
			logger.info("Search button clicked");
			SearchPage sp = new SearchPage(driver);
			boolean searchProductExist = sp.isProductExist("MacBook");
			logger.info("The searched product is exist");
			Assert.assertEquals(searchProductExist, true, "The searched product exist");
			logger.info("The Assertion passed");

		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
			logger.info("The Assertion failed");
		}

		logger.info(" Finished TC_004_SearchProductTest ");

	}
}
