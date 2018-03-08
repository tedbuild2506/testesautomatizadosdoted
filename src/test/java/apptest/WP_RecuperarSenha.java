package apptest;


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


public class WP_RecuperarSenha extends BaseTest implements GlobalConstants {
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
		dc.setCapability("testName", "WP_RecuperarSenhaGalaxys8");
		dc.setCapability("deviceQuery", "@serialnumber='1115fbd4746c2f05'");
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
	public void testTeste_recuperar_senha_e_logar() {
		  client.applicationClearData("com.consul.android.smartbeer.staging");
		  driver.startActivity("com.consul.android.smartbeer.staging", "com.whirlpool.ted.View.SplashActivity");
		  client.setShowReport(false);
		  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Acesse sua conta']")));
		  client.setShowReport(true);
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@text='Acesse sua conta']")).click();
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@text='Esqueci minha senha']")).click();
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@id='email']")).sendKeys("tedusp06@mailinator.com");
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.swipe(821, 868, 768, 478, 448);
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@text='Recuperar senha']")).click();
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Acessar sua conta']")));
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  client.setShowReport(false);
		  driver.findElement(By.xpath("//*[@text='Acessar sua conta']")).click();
		  client.setShowReport(true);
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.pressKeyCode(AndroidKeyCode.HOME);
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.startActivity("com.android.chrome", "com.google.android.apps.chrome.Main");
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.executeScript("client:client.swipeWhileNotFound(\"Right\", 0, 2000, \"NATIVE\", \"xpath=//*[@id='url_bar']\", 0, 6000, 2, true)");
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@id='url_bar']")).sendKeys("mailinator.com/v2/inbox.jsp?zone=public&query=tedusp06");
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.getKeyboard().sendKeys("{ENTER}");
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@text='Reset password instructions']")).click();
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.executeScript("client:client.swipeWhileNotFound(\"Right\", 0, 2000, \"NATIVE\", \"xpath=//*[@text='Mudar minha senha']\", 0, 8000, 2, true)");
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@id='new_password']")).sendKeys("Smart2001");
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.swipe(56, 1028, 53, 962, 255);
		  driver.findElement(By.xpath("//*[@id='password_confirmation']")).sendKeys("Smart2001");
		  driver.executeScript("client:client.swipeWhileNotFound(\"Up\", 0, 2000, \"NATIVE\", \"xpath=//*[@id='commit']\", 0, 6000, 2, true)");
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.pressKeyCode(AndroidKeyCode.HOME);
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.startActivity("com.consul.android.smartbeer.staging", "com.whirlpool.ted.View.SplashActivity");		  
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@text='Acesse sua conta']")).click();
		  client.setShowReport(false);
		  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='edPassword']")));
		  client.setShowReport(true);
		  driver.findElement(By.xpath("//*[@id='edEmail']")).sendKeys("tedusp06@mailinator.com");
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@id='edPassword']")).sendKeys("Smart2001");
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@text='Entrar']")).click();
		  client.setShowReport(false);
		  new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btHome']")));
		  client.setShowReport(true);
		  driver.pressKeyCode(AndroidKeyCode.HOME);
		  
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
