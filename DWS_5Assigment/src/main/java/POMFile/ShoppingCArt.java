package POMFile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.DWSBaseClass;

public class ShoppingCArt extends DWSBaseClass {
	
	public  ShoppingCArt(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[text()='Shopping cart']")
	private WebElement shopping;
	
	
	public void shopping() throws InterruptedException {
		shopping.click();
		List <WebElement> price = driver.findElements(By.xpath("//span[@class='product-subtotal']"));
		double highest = 0.0;
		int i =0;
		for(int j=0;j<price.size();j++)
		{
			double amt = Double.parseDouble(price.get(j).getText());
			if(amt>highest)
			{
				highest = amt;
				i=j;
			}
		}
		Thread.sleep(2000);
		List <WebElement> checkbox = driver.findElements(By.xpath("//input[@name='removefromcart']"));
		for(int j=0;j<checkbox.size();j++)
		{
			if(j==i)
			{
				checkbox.get(j).click();
				driver.findElement(By.xpath("//input[@name='updatecart']")).click();
			}
		}
		Thread.sleep(2000);
		
		System.out.println(highest);
		
		}
	}

