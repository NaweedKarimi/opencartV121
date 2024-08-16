package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='email']")
	WebElement Login_Page_Email_Field;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Login_page_Pass_Field;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement Login_page_LoginBtn;
	
	public void setEmail(String email) {
		Login_Page_Email_Field.sendKeys(email);
	}
	
	public void setPassword(String password) {
		Login_page_Pass_Field.sendKeys(password);
	}
	
	public void LogingBtn() {
		Login_page_LoginBtn.click();
	}
	
	

}
