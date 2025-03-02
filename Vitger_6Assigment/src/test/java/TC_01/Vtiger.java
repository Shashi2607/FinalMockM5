package TC_01;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.javaUtility.GenrateRandomNumbers;

import fileutility.ReadFromExeclFile;


import pom.Home_Page;
import pom.Organization;
import vitgerBAsee.BaseClass;

@Listeners(listners.ExtentReport.class)

public class Vtiger extends BaseClass {

	@Test
	  public void testCase_1() throws EncryptedDocumentException, IOException, InterruptedException {
		   Home_Page  home= new Home_Page(driver);
		   assertTrue(home.home().isDisplayed(),"IAm not in vitger home page");
		   Reporter.log("Iam in Vtiger Home Page...!");
		   home.organization();
		   Organization org= new Organization(driver);
		   org.plus_Org();
		   String org_Name = ReadFromExeclFile.readExecl("Organization", 0, 0);
		   int dynamicNumber= GenrateRandomNumbers.random();
		   String expected_Org = org_Name+dynamicNumber;
		   org.accountName(org_Name+dynamicNumber);
		   org.save();
		   String actual_Org=org.header().getText();
		   assertTrue(actual_Org.contains(expected_Org));
		   Thread.sleep(4000);
	   }
}
