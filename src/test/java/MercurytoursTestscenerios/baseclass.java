package MercurytoursTestscenerios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import mail.EmailReport;
import mercurytour_utilities.Readconfig;


public class baseclass {

	
	static ExtentReports extent ;
	ExtentSparkReporter sparkReporter;
	static ExtentTest test;
	
	
	@BeforeSuite 
		public void BeforeSuite() {
		extent = new ExtentReports();
		sparkReporter = new ExtentSparkReporter("mercurytoursReport.html");
		extent.attachReporter(sparkReporter);
	}
	
	@AfterSuite 
	public void AfterSuite() {
		extent.flush();
		driver.quit();
	}
	Readconfig config=new Readconfig();
	String baseUrl = config.getApplicationURL();
	String chromebrowser=config.getChromePath();
	String Firefoxpath=config.getFireFoxPath();
	String internetexplorer=config.getIEPath();
	static WebDriver driver=  new ChromeDriver();
	 
		
	 
	 EmailReport emailreport=new EmailReport();
	 
	 @AfterTest
		public void email() throws  IOException, MessagingException {
			emailreport.main();
		}
	 
	
	 @Parameters("browser")
	 @BeforeClass
	public  void name(String br) {
		
		// System.setProperty("webdriver.chrome.driver",
        //  "D:\\Java related project\\chromedriver_win32 (1)\\chromedriver.exe");
      // Instantiate a ChromeDriver class.

     /*String workingDir = System.getProperty("user.dir");
     System.setProperty("webdriver.chrome.driver",
          workingDir+"//drivers//chromedriver.exe");
      // Instantiate a ChromeDriver class.

     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      // Maximize the browser
	 driver.manage().window().maximize();
     driver.get(baseUrl);*/
      
    

      // Launch Website
 
      
      
     if(br.equals("chrome"))
		{
    	 
		//WebDriverManager.chromedriver().setup();
		 System.setProperty("webdriver.chrome.driver",chromebrowser);
		
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      // Maximize the browser
	      driver.manage().window().maximize();
	      driver.get(baseUrl); 
	      
	      
		}
		 else if(br.equals("firefox"))
		{
			 
		
			
		System.setProperty("webdriver.firefox.marionette", Firefoxpath);  
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      // Maximize the browser
	      driver.manage().window().maximize();
			
		}
		else if(br.equals("ie"))
		{
			
			
			 System.setProperty("webdriver.ie.driver", internetexplorer);  
		        WebDriver driver=new InternetExplorerDriver();  
		        
		}
		
		driver.get(baseUrl);
		
      
		
	}
	
}
