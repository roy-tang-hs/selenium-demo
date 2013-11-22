package airgames.airg.DrunkenTreasures;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.thoughtworks.selenium.Selenium;

//@Listeners (airgames.standalone.TestNGScreenShot.class)

public class BaseTest {
	
	protected static Selenium selenium;
	
	protected static WebDriver driver;

	protected static DesiredCapabilities capabilities ;
	
	public String key = "zijunt";
	

@BeforeSuite(alwaysRun = true)
  protected void startWebDriver() throws InterruptedException {
	  		  
	  
	  	//set up webdriver address for linux, win and mac
	  	String chromeBinary = System.getProperty(" ");
	  	
		//System.out.println(chromeBinary);

	  	if (chromeBinary == null || chromeBinary.equals("")) {

	  	 String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
	     chromeBinary = "lib/webdriver/chromedriver-" + os + (os.equals("win") ? ".exe" : "");
	     System.setProperty("webdriver.chrome.driver",chromeBinary);
	     System.out.println(chromeBinary);
	     
	     capabilities = DesiredCapabilities.chrome();
	     ChromeOptions options = new ChromeOptions();
	     options.addArguments("--window-size=480,700");
	     options.addArguments("--user-agent=Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A543a Safari/419.3");
	     capabilities.setCapability(ChromeOptions.CAPABILITY,options);
	  	}
	  	
	  	driver = new ChromeDriver(capabilities);

 
	  driver.get("http://test.airgames.com");
	 // Assert.assertEquals("airG",driver.getTitle());
	  Thread.sleep(4000);
	  
	
	 
	 
      
  }
  


  
 @AfterSuite (alwaysRun = true)
 protected void closeSession(){
	
	// driver.close();
 }
 

}