

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.experitest.appium.SeeTestClient;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class WP_CadastroEmBranco extends BaseTest {
	protected AndroidDriver<AndroidElement> driver = null;
	protected SeeTestClient client;
	
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		init(deviceQuery);
		// Init application / device capabilities
		dc.setCapability(MobileCapabilityType.APP, "cloud:com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.consul.android.smartbeer.staging");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.whirlpool.ted.View.SplashActivity");
		//dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
		//dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
		//dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
		dc.setCapability("testName", "WP_CadastroEmBrancoGalaxys8Android7.0");
		dc.setCapability("deviceQuery", "@serialnumber='ce061716ba5f3cdd0d7e'");
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
		
	}
	
//	@Test(enabled=false) 
//	public void uninstall()
//	{
//		client.uninstall("com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity");
//		client.install("cloud:com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity", false, false);
//		client.applicationClearData("com.consul.android.smartbeer.staging");
//	}
		
	@Test
	 public void testTeste_de_cadastro_campos_em_branco() {
      client.applicationClearData("com.consul.android.smartbeer.staging");
	  driver.startActivity("com.consul.android.smartbeer.staging", "com.whirlpool.ted.View.SplashActivity");
	  client.setShowReport(false);
	  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Cadastre-se com seu e-mail pessoal']")));
	  client.setShowReport(true);
	  try{Thread.sleep(5000);} catch(Exception ignore){}
	  driver.findElement(By.xpath("//*[@text='Cadastre-se com seu e-mail pessoal']")).click();
	  try{Thread.sleep(3000);} catch(Exception ignore){}
	  driver.swipe(165, 759, 175, 534, 1234);
	  try{Thread.sleep(3000);} catch(Exception ignore){}
	  driver.swipe(309, 856, 390, 406, 888);
	  try{Thread.sleep(3000);} catch(Exception ignore){}
	  driver.swipe(168, 946, 334, 615, 2240);
	  try{Thread.sleep(3000);} catch(Exception ignore){}
	  driver.swipe(84, 887, 259, 493, 1461);
	  try{Thread.sleep(3000);} catch(Exception ignore){}
	  driver.swipe(450, 812, 500, 640, 1292);
	  try{Thread.sleep(3000);} catch(Exception ignore){}
	  driver.findElement(By.xpath("//*[@text='Cadastrar']")).click();
	  try{Thread.sleep(5000);} catch(Exception ignore){}
	 }
	
	@AfterMethod
	public void tearDown(ITestResult tr){
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
			client.releaseDevice("ce061716ba5f3cdd0d7e", true, false, true);
			driver.quit();
		}
	}
}
