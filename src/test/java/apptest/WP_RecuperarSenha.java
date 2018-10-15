package apptest;


import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

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
	protected String ReportURL = System.getenv("ReportURL");
	protected String TestName = System.getenv("testName");
	
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		init(deviceQuery);
		// Init application / device capabilities
		/*dc.setCapability(MobileCapabilityType.APP, "cloud:com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.consul.android.smartbeer.staging");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.whirlpool.ted.View.SplashActivity");*/
		dc.setCapability("testName", "wp_TED_RecuperarSenha");
		//dc.setCapability("deviceQuery",androidnuvem);
		dc.setCapability("deviceQuery",S7Edge+"or"+S8+"or"+S7+"or"+S6Edge+"or"+Xiaomi);
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
		
	}
	
	private String getDateTime() {
	    DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	    Date date = new Date();
	    return dateFormat.format(date);
	}
		
	@Test 
	public void testTeste_recuperar_senha_e_logar() {
		String strSenha = getDateTime();
		  driver.installApp("cloud:com.consul.smartbeer/com.whirlpool.ted.View.SplashActivity");
		  client.launch("com.consul.smartbeer/com.whirlpool.ted.View.SplashActivity", false, true);
		  try{Thread.sleep(esperandogifinicial);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@text='Acesse sua conta']")).click();
		  driver.findElement(By.xpath("//*[@text='Esqueci minha senha']")).click();
		  driver.findElement(By.xpath("//*[@id='email']")).sendKeys("tedmonitoramento@gmail.com");
		  driver.swipe(821, 868, 768, 478, 448);
		  driver.findElement(By.xpath("//*[@text='Recuperar senha']")).click();
		  try{Thread.sleep(esperandogifintermediario-0200);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@text='Acessar sua conta']")).click();
		  
		 }
	
	@Test 
	public void testTeste_recuperar_senha_e_logarQA() {
		String strSenha = getDateTime();
		  driver.installApp("cloud:com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity");
		  client.launch("com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity", false, true);
		  try{Thread.sleep(esperandogifinicial);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@text='Acesse sua conta']")).click();
		  driver.findElement(By.xpath("//*[@text='Esqueci minha senha']")).click();
		  driver.findElement(By.xpath("//*[@id='email']")).sendKeys("tedmonitoramento@gmail.com");
		  driver.swipe(821, 868, 768, 478, 448);
		  driver.findElement(By.xpath("//*[@text='Recuperar senha']")).click();
		  try{Thread.sleep(esperandogifintermediario);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@text='Acessar sua conta']")).click();
		  
		 }

	
	@AfterMethod
	public void tearDown(ITestResult tr) throws AddressException, MessagingException{
		driver.removeApp("com.consul.android.smartbeer.staging");
		System.out.println(""+ ReportURL);
		TestName = "wp_TED_RecuperarSenha";
		if (driver!=null)
		{
			
			if (tr.isSuccess()) 
			{
				client.report("Test has passed", true);
				
			}
			else {
				client.report("Test has failed", false);
				/*String result = "falhou";
				Email e = new Email();
				e.setMailServerProperties();
				e.createEmailMessage(ReportURL, TestName, result);
				e.sendEmail();*/
				
			
			}
			driver.quit();
		}
	}
	
}