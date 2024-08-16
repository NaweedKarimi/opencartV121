package testCases;

import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.Account_Registration_Page;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{


	@Test(groups={"Reression","Master"})
	public void Verify_account_registation() throws InterruptedException {
		
		logger.info("*** Starting TC001_AcountRegistrating TesT****");
		
		try {
		HomePage hp = new HomePage(driver);
		
		hp.MyAccount_btn();
		
		logger.info("Click on My Account Link!");
	
		hp.Register_Btn();
		logger.info("Click on Register Link!");

		Thread.sleep(10000);
		
		logger.info("Providing Customer Information!");
		Account_Registration_Page a= new Account_Registration_Page(driver);
		
		a.set_name(randomString());
		a.set_Lastname(randomString());
		a.set_email(randomString()+"@gmail.com");
		a.set_Telphone(randonNumberic());
		
		String password=RandonAlphaNumberic();
		a.set_password(password);
		a.set_confirm_password(password);
		a.PrivacyPolicy();
		a.Continue();
		
		logger.info("Validating expected massage!");
		String msg=a.Confirmation_Message();
		Assert.assertEquals(msg, "Your Account Has Been Created!");
		
		}catch(Exception e) {
			logger.error("Test Faild...");
//			logger.debug("Dubug logs..");
			Assert.fail();
		}
		
	}

}
