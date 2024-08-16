package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='content']//h2[text()='My Account']")
	WebElement MyAccount_Text_My_Account_Page;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement LogoutBtn;
	
	public boolean isMyAccountPageExissts() {
		try {
		return MyAccount_Text_My_Account_Page.isDisplayed();
		}catch (Exception e) {
			return false;
		}
	}
	
	public void ClickLougout() {
		LogoutBtn.click();
	}
	
	

}
