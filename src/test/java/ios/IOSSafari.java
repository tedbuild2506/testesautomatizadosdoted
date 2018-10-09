package ios;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSSafari extends BaseTest implements GlobalConstants {
	protected IOSDriver<IOSElement> driver = null;
	protected SeeTestClient client;


	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='ios'") String deviceQuery) throws Exception{
		init(deviceQuery);
		dc.setCapability(MobileCapabilityType.APP, "cloud:com.consul.smartbeer-staging");
		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.consul.smartbeer-staging");
		dc.setCapability("testName", "wp_TED_Iphone8CadastroBranco");
		dc.setCapability("deviceQuery", "@serialnumber='09a0e7c71ee24ebb50eae0a811b2e4dff009cc65'");
		driver = new IOSDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
	}
	
	@Test
	public void testecadastroinvalidoIOS(){
			  client.launch("com.apple.mobilesafari", false, false);
			  driver.context("WEBVIEW_1");
			  driver.findElement(By.xpath("//*[@id='URL']")).sendKeys("www.mailinator.com/v2/inbox.jsp?zone=public&query=carton");
			  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
			  driver.getKeyboard().sendKeys("{ENTER}");
			  driver.executeScript("client:client.swipeWhileNotFound(\"Right\", 0, 2000, \"NATIVE\", \"xpath=//*[@text='Instruções de confirmação']\", 0, 3000, 2, true)");
			  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
			  driver.executeScript("client:client.swipeWhileNotFound(\"Right\", 0, 2000, \"NATIVE\", \"xpath=//*[@text='Ativar']\", 0, 6000, 7, true)");
			  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
			  driver.executeScript("client:client.deviceAction(\"Home\")");
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