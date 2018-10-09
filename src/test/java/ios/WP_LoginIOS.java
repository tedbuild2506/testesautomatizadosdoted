package ios;

import java.net.URL;

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
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class WP_LoginIOS extends BaseTest implements GlobalConstants {
	protected IOSDriver<IOSElement> driver = null;
	protected SeeTestClient client;


	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='ios'") String deviceQuery) throws Exception{
		init(deviceQuery);
		dc.setCapability(MobileCapabilityType.APP, "cloud:com.consul.smartbeer-staging");
		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.consul.smartbeer-staging");
		dc.setCapability("testName", "wp_TED_Iphone8CadastroBranco");
		dc.setCapability("deviceQuery", "@serialnumber='2ef16f1e7b475b9e6aa09392efb67735b1b57b08'");		
		driver = new IOSDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
	}
	
	@Test
	 public void testeloginios() {
		Boolean Allow = driver.findElements(By.xpath("//*[@value='Allow']")).size()>0;
		  if (Allow) {
			  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
			  driver.findElement(By.xpath("//*[@value='Allow']")).click();
			  //client.launch("com.apple.mobilesafari\"", false, false);
			  try{Thread.sleep(esperarminigifs);} catch(Exception ignore){}
			  driver.findElement(By.xpath("(//*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAView']]]]/*[@class='UIAButton'])[4]")).click();
			  driver.findElement(By.xpath("//*[@placeholder='Email']")).sendKeys("tedmonitoramento@gmail.com");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='Senha']")));
			  driver.findElement(By.xpath("//*[@placeholder='Senha']")).sendKeys("Smart2000");
			  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='UIAKeyboard']")));
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.findElement(By.xpath("//*[@text='Entrar']")).click();
			  }
		  else  {
			  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
			  driver.findElement(By.xpath("(//*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAView']]]]/*[@class='UIAButton'])[4]")).click();
			  driver.findElement(By.xpath("//*[@placeholder='Email']")).sendKeys("tedmonitoramento@gmail.com");
			  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='Senha']")));
			  driver.findElement(By.xpath("//*[@placeholder='Senha']")).sendKeys("Smart2000");
			  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='UIAKeyboard']")));
			  driver.findElement(By.xpath("//*[@class='UIAKeyboard']")).click();
			  driver.findElement(By.xpath("//*[@text='Entrar']")).click();
			  		}
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
			driver.quit();
		}
	}
}