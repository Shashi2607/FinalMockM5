package DWS_MOCK;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.DWSBaseClass;
import POMFile.DigitalDownloads;
import POMFile.ShoppingCArt;

@Listeners(Listners.ExtentsREtport.class)
public class DynamicWAy extends DWSBaseClass {

	@Test
	public void run() throws InterruptedException {
		
		DigitalDownloads digi= new DigitalDownloads(driver);
		digi.digital();
		
		ShoppingCArt shop= new ShoppingCArt(driver);
		shop.shopping();
	}

}