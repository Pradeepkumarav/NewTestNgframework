package MercurytoursTestscenerios;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import mercurytours_pageobjects.Mercurytours_register;

public class Mercury__TC1_register extends baseclass {

	Mercurytours_register objregister=new Mercurytours_register(baseclass.driver);
	baseclass  data=new baseclass();
	
	@Test
	public void register() throws IOException   {
	
		try {	
		
			
		 test = extent.createTest("Register the mercury tours");
		test.info("user started registering the page");

		
		objregister.clickonregister();
		test.pass("clicked on register link successfully");
		objregister.enterfirstname();
		test.pass("firstname entered successfully");
		objregister.enterlastname();
		test.pass("lastname entered successfully");
		objregister.entermobile();
		test.pass("mobile number entered successfully");
		objregister.enteremail();
		test.pass("mail id entered successfully");
	
		objregister.enterdropdown();
		test.pass("selected correct dropdown successfully");
		objregister.enterusername();
		test.pass("username entered successfully");
		objregister.entepassword();
		test.pass("password entered successfully");
		objregister.enteconfirm();
		test.pass("confirm pass entered successfully");
		objregister.submit();
		test.pass("Clicked on submit successfully");
		objregister.validateregistered();
		test.pass("validation done successfully");
		
		}
		
		catch(Exception e) {
			TakesScreenshot ts = (TakesScreenshot)driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\TC1_Registeruser.png";
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination);
	      
	        
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(dest);
			Assert.assertTrue(false);
	
		}
		
		
	}
	
}
