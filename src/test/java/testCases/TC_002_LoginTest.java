package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups = { "sanity", "master" })
	public void verify_login() {
		logger.info("**** Starting TC_002_LoginTest  ****");
		logger.debug("capturing application debug logs....");
		try {
			// Home page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on myaccount link on the home page..");
			hp.clickLogin(); // Login link under MyAccount
			logger.info("clicked on login link under myaccount..");

			// Login page
			LoginPage lp = new LoginPage(driver);
			logger.info("Entering valid email and password..");
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin(); // Login button
			logger.info("clicked on ligin button..");

			// My Account Page
			MyAccountPage macc = new MyAccountPage(driver);

			boolean targetPage = macc.isMyAccountPageExists();
			if (lp.loginErrorMessage() == true) {
				Assert.fail();
			} else {
				Assert.assertEquals(targetPage, true);
			}

			logger.info("clicking mylink for logout button");
			hp.clickMyAccount();
			logger.info("logging out");
			macc.clickLogout();
			boolean homePage = hp.isHomePageExists();
			Assert.assertEquals(homePage, true, "Logout failed");
			logger.info("log out successfuly");
		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		}

		logger.info("**** Finished TC_002_LoginTest  ****");
	}
}
