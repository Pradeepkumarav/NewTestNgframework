package MercurytoursTestscenerios;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import mercurytours_pageobjects.Mercurytours_flightbooking;

public class Mercury_TC3_flightbooking extends baseclass {

	Mercurytours_flightbooking booking=new Mercurytours_flightbooking(baseclass.driver);
	
	@Test
	public void flightbooking() throws IOException {
		try
		{
		test = extent.createTest("flight booking");
	    test.info("user started flight booking");
		booking.clickonflight();
		test.pass("clicked on flight successfully");
		booking.clickononeway();
		test.pass("clicked on oneway successfully");
		booking.passengerdropdown();
		test.pass("selected passengers successfully");
		booking.Departingfrom();
		test.pass("selected departure successfully");
		booking.Departingto();
		test.pass("selected arrival successfully");
		booking.Serviceclassselect();
		test.pass("selected serviceclass successfully");
		booking.airlinedropdown();
		test.pass("selected airlines successfully");
		booking.clickcontinue();
		test.pass("Clicked conitune successfully");
		booking.valiadtionflight();
		test.pass("User able to see the flights");
		
		}
		catch(Exception e)
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\TC3_flightbooking.png";
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination);
	      
	        
			test.log(Status.FAIL, e);
			 test.addScreenCaptureFromPath(dest);
			 Assert.assertTrue(false);
		}
		
	}
}
