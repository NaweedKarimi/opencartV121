package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	public Properties p;

	
	@Parameters({"os","browser"})
	@BeforeClass(groups= {"sanity","Reression","Master"})
	public void setup(String os, String br) throws IOException {
		
//		Loading config.properties file
		FileReader file= new FileReader(".//src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		
		
		logger =  LogManager.getLogger(this.getClass());
		
		if(br.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver(); 
		}
		else if(br.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if(br.toLowerCase().equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid browser name..."); 
		}

		driver = new ChromeDriver();
//		driver.get("https://tutorialsninja.com/demo/"); //now we want to read from properties file
		
		driver.get(p.getProperty("appurl"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@AfterClass(groups= {"sanity","Reression","Master"})
	public void TearDown() {

		driver.close();
	}

	public String randomString() {
		String generateAlphabat = RandomStringUtils.randomAlphabetic(5);
		return generateAlphabat;
	}

	public String randonNumberic() {
		String generatedNumberic = RandomStringUtils.randomNumeric(10);
		return generatedNumberic;
	}

	public String RandonAlphaNumberic() {
		String generateAlphabat = RandomStringUtils.randomAlphabetic(3);
		String generatedNumberic = RandomStringUtils.randomNumeric(3);
		return (generateAlphabat +"@"+ generatedNumberic);
	}

}
