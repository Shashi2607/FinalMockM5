package vitgerBAsee;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import fileutility.ReadfromProperties;
import pom.Home_Page;
import pom.Login_Page;

public class BaseClass{

	public static WebDriver driver;
	
	@BeforeClass
	public void preCondition() throws IOException {
		String browser=ReadfromProperties.getData("Browser");
      	String url= ReadfromProperties.getData("url");
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver= new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}
	@BeforeMethod
	public void login() throws IOException {
		String username=ReadfromProperties.getData("userName");
		String pass=ReadfromProperties.getData("password");
		
		Login_Page log=new Login_Page(driver);
		
		log.userName(username);
		log.password(pass);
		log.submmit();
	}
	@AfterMethod
	public void logout() {
		Home_Page home= new Home_Page(driver);
		home.profile();
		home.signOut();
	}
	@AfterClass
	public void postCondition() {
		driver.quit();
	}
}


