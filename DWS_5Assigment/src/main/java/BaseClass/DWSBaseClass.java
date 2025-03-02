package BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import POMFile.Loginpage;
import fileUtility.ReadFromDWS;

public class DWSBaseClass {

	public static WebDriver driver=null;
	
	@BeforeClass
	public void preCondition() throws IOException {
		String expected_Url="https://demowebshop.tricentis.com/";
		String browser=ReadFromDWS.getData("browser");
		String url=ReadFromDWS.getData("url");
		
		if (browser.equalsIgnoreCase("chrome")) {
			 driver= new ChromeDriver();	
			}
			else if (browser.equalsIgnoreCase("edge")) {
				driver= new EdgeDriver();
			}
			else if (browser.equalsIgnoreCase("firefox")) {
				driver= new FirefoxDriver();
			}
			else {
				driver= new ChromeDriver();
			}
		//maximize the window
		driver.manage().window().maximize();
		//waiting condition
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//enter into dws page
		driver.get(url);
		String actual_Url=driver.getCurrentUrl();
		if (actual_Url.equals(expected_Url)) {
			Reporter.log("iam in DWS page");
			
		}
	}
	
	@BeforeMethod
	public void login() throws IOException {
		
		String userName=ReadFromDWS.getData("username");
		String password=ReadFromDWS.getData("password");
		
		Loginpage log= new Loginpage(driver);
		log.login_Click();
		log.userName(userName);
		log.password(password);
		log.checkbox();
		log.submmit();
	}
	
	@AfterMethod
	public void logout() {
		Loginpage log= new Loginpage(driver);
		log.logout();
	}
	
	@AfterClass
	public void postCondition() {
		driver.quit();
	}
}
