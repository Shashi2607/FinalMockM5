package POMFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class Loginpage {

	public  Loginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "ico-login")
	private WebElement login_Click;
	
	@FindBy(xpath="//input[@id='Email']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='Password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='RememberMe']")
	private WebElement checkbox;
	
	@FindBy(xpath="//input[@value='Log in']")
	private WebElement login_Button;
	
	@FindBy(className = "ico-logout")
	private WebElement logout_Button;

	public void login_Click() {
		login_Click.click();
	}
	
	public void userName(String data) {
		username.sendKeys(data);
	}
	
	public void password(String data) {
		password.sendKeys(data);
	}
	
	public void checkbox() {
		checkbox.click();
	}
	public void submmit() {
		login_Button.click();
	}
	
	public void logout() {
		logout_Button.click();
	}
}
