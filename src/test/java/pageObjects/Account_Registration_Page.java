package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Account_Registration_Page extends BasePage {

	public Account_Registration_Page(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id="input-firstname")
	WebElement First_name_filed;
	
	@FindBy(xpath = "//input[@name='lastname']")
	WebElement Last_name_filed;
	
	@FindBy(id = "input-email")
	WebElement Email_filed;
	
	@FindBy(xpath = "//input[@name='telephone']")
	WebElement Telphone_filed;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement Password_filed;
	
	@FindBy(xpath = "//input[@name='confirm']")
	WebElement Confirm_Password;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement privacy_Check_box_btn;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement Continue_Btn;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement Confirmation_Msg;
	
	
	public void set_name(String name) {
		First_name_filed.sendKeys(name);
	}
	
	public void set_Lastname(String last_name) {
		Last_name_filed.sendKeys(last_name);
	}
	
	public void set_email(String email) {
		Email_filed.sendKeys(email);
	}
	
	public void set_Telphone(String phone) {
		Telphone_filed.sendKeys(phone);
	}
	
	public void set_password(String password) {
		Password_filed.sendKeys(password);
	}
	
	public void set_confirm_password(String confirm_password) {
		Confirm_Password.sendKeys(confirm_password);
	}
	
	public void PrivacyPolicy() {
		privacy_Check_box_btn.click();
	}
	public void Continue() {
		Continue_Btn.click();
	}
	
	public String Confirmation_Message() {
		try {
		return Confirmation_Msg.getText();
		}catch (Exception e) {
			return (e.getMessage());
		}
	}
	

}
