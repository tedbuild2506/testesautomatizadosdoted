package apptest;


import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.experitest.appium.SeeTestClient;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class WP_Login extends BaseTest implements GlobalConstants { 
	protected AndroidDriver<AndroidElement> driver = null;
	protected SeeTestClient client;
	protected String ReportURL = System.getenv("ReportURL");
	
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		init(deviceQuery);
		// Init application / device capabilities
		/*dc.setCapability(MobileCapabilityType.APP, "cloud:com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.consul.android.smartbeer.staging");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.whirlpool.ted.View.SplashActivity");*/
		dc.setCapability("testName", "wp_TED_Login");
		dc.setCapability("deviceQuery",S7Edge+"or"+S8+"or"+S7+"or"+S6Edge);
		//dc.setCapability("deviceQuery",androidnuvem);
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
		
	}
		
	@Test
	 public void testeLogin() {
		  driver.installApp("cloud:com.consul.smartbeer/com.whirlpool.ted.View.SplashActivity");
		  client.launch("com.consul.smartbeer/com.whirlpool.ted.View.SplashActivity", false, true);
		  try{Thread.sleep(esperandogifinicial);} catch(Exception ignore){}
    	  driver.findElement(By.xpath("//*[@text='Acesse sua conta']")).click();
    	  driver.findElement(By.xpath("//*[@id='edEmail']")).sendKeys("tedmonitoramento@gmail.com");
    	  driver.findElement(By.xpath("//*[@id='edPassword']")).sendKeys("Smart2000");
    	  driver.findElement(By.xpath("//*[@text='Entrar']")).click();
    	  try{Thread.sleep(esperandogifinicial+2600);} catch(Exception ignore){}
    	  driver.findElement(By.xpath("//*[@id='imgCart']")).click();
	}
	
	@Test
	 public void testeLoginQA() {
	  driver.installApp("cloud:com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity");
	  client.launch("com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity", false, true);
      try{Thread.sleep(esperandogifinicial);} catch(Exception ignore){}
   	  driver.findElement(By.xpath("//*[@text='Acesse sua conta']")).click();
   	  driver.findElement(By.xpath("//*[@id='edEmail']")).sendKeys("tedmonitoramento@gmail.com");
   	  driver.findElement(By.xpath("//*[@id='edPassword']")).sendKeys("Smart2000");
   	  driver.findElement(By.xpath("//*[@text='Entrar']")).click();
   	  try{Thread.sleep(esperandogifinicial+2500);} catch(Exception ignore){}
   	  driver.findElement(By.xpath("//*[@id='imgCart']")).click();
	}
	
	@AfterMethod
	public void tearDown(ITestResult tr){
		driver.removeApp("com.consul.android.smartbeer.staging");
		if (driver!=null)
		{
			if (tr.isSuccess()) 
			{
				client.report("Test has passed", true);
			}
			else {
				client.report("Test has failed", false);
			}
			System.out.println("report URL : " + driver.getCapabilities().getCapability("reportUrl"));
			//System.getenv(driver.getCapabilities().getCapability("reportUrl"));
			System.setProperty(ReportURL, driver.getCapabilities().getCapability("reportUrl").toString());
			driver.quit();
		}
	}
}