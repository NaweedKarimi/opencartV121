package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups={"sanity","Master"})
	public void verify_Login() { 
		logger.info("*****Starting TC002_LoginTest****");
		
//		homepage
		HomePage hp =new HomePage(driver);
		hp.MyAccount_btn();
		hp.LoginBtn();
		
//		login page
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.LogingBtn();
		
//		Myaccountpage
		
		MyAccountPage ma = new MyAccountPage(driver);
		boolean targetPage=ma.isMyAccountPageExissts();
		Assert.assertEquals(targetPage, true);
		
	}

}
