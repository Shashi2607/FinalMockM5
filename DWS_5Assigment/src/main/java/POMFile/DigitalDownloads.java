package POMFile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.DWSBaseClass;

public class DigitalDownloads extends DWSBaseClass{

	public  DigitalDownloads(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText ="Digital")
	private WebElement digital_Downloads;
	
	public void digital() {
		digital_Downloads.click();
		List<WebElement> addCart = driver.findElements(By.xpath("//div[@class='product-grid']"));
		for (WebElement web : addCart) {
			web.click();
		}
	}
}
