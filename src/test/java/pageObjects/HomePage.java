package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage  extends BasePage{
	

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement MyAccount_btn;
	
	@FindBy(xpath ="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']" )
	WebElement Register_btn;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")
	WebElement LoginBtn;
	
	public void MyAccount_btn() {
		MyAccount_btn.click();
	}
	
	public void Register_Btn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement MyAccount_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']")));
		MyAccount_btn.click();
	}
	
	public void LoginBtn() {
		LoginBtn.click();
	}
	
	

}
