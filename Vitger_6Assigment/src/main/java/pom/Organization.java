package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization {
	public Organization(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement plus_Org;
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement account_Name;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement save;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement header;
	
//	@FindBy(name="industry")
//	private WebElement industry;
	
//@FindBy(xpath="//option[value='Engineering']")
//	private WebElement element;
	
	public void plus_Org() {
		plus_Org.click();
	}
	public void accountName(String data) {
		account_Name.sendKeys(data);
	}
	
	public void save() {
		save.click();
	}
	
	public WebElement header() {
		return header;
	}
	
//	public void industry() {
//		industry.click();
//	}
	
//	public void element() {
//		element.click();
//	}
}

