package Listners;

import java.io.File;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClass.DWSBaseClass;

public class ExtentsREtport extends DWSBaseClass implements ITestListener{

	public static ExtentSparkReporter spark =null;
	public static ExtentReports report=null;
	public static ExtentTest test=null;
	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test=report.createTest(name);
		test.log(Status.INFO, name+"ontestStart ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.PASS,name+"is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		LocalDateTime data = LocalDateTime.now();
		String time = data.toString().replace(':','-');
		
		Reporter.log("on test failure"+""+name,true);
		TakesScreenshot ts = (TakesScreenshot)driver;
//	    File from= ts.getScreenshotAs(OutputType.FILE);
		String from= ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(from);
//	    File to = new File(".\\src\\test\\resources\\Screeshot\\"+name+time+".png");
//	   try {
//		FileHandler.copy(from, to);
//	} catch (Exception e) {
//		// TODO: handle exception
//		e.printStackTrace();
//	}
      test.log(Status.FAIL,name+"is fail");
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {//when that independent is failed that time dependent methods is skipped. 
		String name = result.getMethod().getMethodName();
		test.log(Status.SKIP,name+"is skipped");
		
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("onstart",true);
		File path=new File(".\\src\\test\\resources\\Vtiger_Reports\\Organization_TC_01.html");
		//create ExtensSparkReport
		spark=new ExtentSparkReporter(path);
		//configure  ExtentSparkReport
		spark.config().setDocumentTitle("VtigerS");
		spark.config().setReportName("Shashi");
		spark.config().setTheme(Theme.STANDARD);
		//create ExtentReport
		report=new ExtentReports(); 
		//provide system information
		report.setSystemInfo("OS", "Window_11");
		report.setSystemInfo("Browser","Chrome");
		//attach the ExtentSparkReport to ExtentReport
		report.attachReporter(spark);
	}

	@Override
	public void onFinish(ITestContext context) {
		
		report.flush();
	}
}
