package MercurytoursTestscenerios;

import java.io.File;

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
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import mercurytours_pageobjects.Mercurytourpage_login;

public class Mercury_TC2_Login extends baseclass {

	Mercurytourpage_login loginpage=new Mercurytourpage_login(baseclass.driver);
	

	 
	@Test
	public void Loginpage() throws Exception {
		try {
	    
		test = extent.createTest("Login the mercury tours");
	    test.info("user started login the page");
		loginpage.clickonsignon();
		test.pass("clicked on sign on successfully");
		loginpage.enterusernamelogin();
		test.pass("enter username successfully");
		loginpage.enterpasslogin();
		test.pass("entered passlogin successfully");
		loginpage.loginsubmit();
		test.pass("clicked login submit successfully");
		loginpage.loginvalidation();
		test.pass("user successfully login the page");
		}
		
		
		catch(Exception e)
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\TC2_Login.png";
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination);
	      
	        
			test.log(Status.FAIL, e);
			 test.addScreenCaptureFromPath(dest);
			 Assert.assertTrue(false);
		}
	}
}
