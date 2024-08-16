package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
 * Data is valid  -login success test passed -->logout
 * Data is valid --> login failled --> test faild
 * 
 * Data is invalid -- login success -- test fail logout
 * Data is invalid login failed test passed
 */

public class TC_003_LoginDDT extends BaseClass {

//	not if data provider is in other class we two above step otherwise first is ok

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups="Datadriven")
	public void verify_LoginDDT(String email, String password, String exp) {

		logger.info("***Start TC_003_LoginDDT***");

		try {
//		homepage
			HomePage hp = new HomePage(driver);
			hp.MyAccount_btn();
			hp.LoginBtn();

//		login page

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.LogingBtn();

//		Myaccountpage

			MyAccountPage ma = new MyAccountPage(driver);
			boolean targetPage = ma.isMyAccountPageExissts();

			if (exp.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					ma.ClickLougout();
					Assert.assertTrue(true);

				} else {
					Assert.assertTrue(false);
				}

			}

			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					ma.ClickLougout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("***Finished TC_003_LoginDDT***");

	}
}
