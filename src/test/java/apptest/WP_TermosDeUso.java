package apptest;


import java.net.URL;

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
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class WP_TermosDeUso extends BaseTest implements GlobalConstants { 
	protected AndroidDriver<AndroidElement> driver = null;
	protected SeeTestClient client;
	protected String ReportURL = System.getenv("ReportURL");
	protected String TestName = System.getenv("testName");
	
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		init(deviceQuery);
		// Init application / device capabilities
		dc.setCapability("testName", "wp_TED_TermosDeUsoPoliticaPrivacidade");
		dc.setCapability("deviceQuery",S7Edge+"or"+S8+"or"+S7+"or"+S6Edge+"or"+Xiaomi);
		//dc.setCapability("deviceQuery",androidnuvem);
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
		
		
	}
		
	@Test
	 public void testetermosdeuso() {
		  driver.installApp("cloud:com.consul.smartbeer/com.whirlpool.ted.View.SplashActivity");
		  client.launch("com.consul.smartbeer/com.whirlpool.ted.View.SplashActivity", false, true);
		  try{Thread.sleep(esperandogifintermediario);} catch(Exception ignore){}
    	  driver.findElement(By.xpath("//*[@text='Acesse sua conta']")).click();
    	  driver.findElement(By.xpath("//*[@id='edEmail']")).sendKeys("tedmonitoramento@gmail.com");
    	  driver.findElement(By.xpath("//*[@id='edPassword']")).sendKeys("Smart2000");
    	  driver.findElement(By.xpath("//*[@text='Entrar']")).click();
    	  try{Thread.sleep(esperandogifinicial+4500);} catch(Exception ignore){}
    	  driver.findElement(By.xpath("//*[@id='imgUser']")).click();
          driver.findElement(By.xpath("//*[@text='Termos de uso']")).click();
    	  new WebDriverWait(driver, 30, esperandogifintermediario).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='ALLOW']"))).click();
    	  try{Thread.sleep(esperandogifinicial+2500);} catch(Exception ignore){}
    	  Boolean Drive = driver.findElements(By.xpath("//*[@text='Drive PDF Viewer']")).size()>0;
		  if (Drive) {
			  try{Thread.sleep(esperarminigifs);} catch(Exception ignore){}
			  driver.findElement(By.xpath("//*[@text='Drive PDF Viewer']")).click();
		  }
		  Boolean Allow = driver.findElements(By.xpath("//*[@text='ALLOW']")).size()>0;
		  if (Allow) {
			  try{Thread.sleep(esperarminigifs);} catch(Exception ignore){}
			  new WebDriverWait(driver, 30, esperandogifintermediario).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='ALLOW']"))).click();
		  }
          driver.pressKeyCode(AndroidKeyCode.BACK);
          try{Thread.sleep(2000);} catch(Exception ignore){}
          driver.findElement(By.xpath("//*[@text='Política de privacidade']")).click();
          }
	
	@Test
	 public void testetermosdeusoQA() {
	 driver.installApp("cloud:com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity");
		  client.launch("com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity", false, true);
		  try{Thread.sleep(esperandogifintermediario);} catch(Exception ignore){}
   	  driver.findElement(By.xpath("//*[@text='Acesse sua conta']")).click();
   	  driver.findElement(By.xpath("//*[@id='edEmail']")).sendKeys("tedmonitoramento@gmail.com");
   	  driver.findElement(By.xpath("//*[@id='edPassword']")).sendKeys("Smart2000");
   	  driver.findElement(By.xpath("//*[@text='Entrar']")).click();
   	  try{Thread.sleep(esperandogifinicial+2500);} catch(Exception ignore){}
   	  driver.findElement(By.xpath("//*[@id='imgUser']")).click();
         driver.findElement(By.xpath("//*[@text='Termos de uso']")).click();
   	  new WebDriverWait(driver, 30, esperandogifintermediario).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='ALLOW']"))).click();
   	  try{Thread.sleep(esperandogifinicial+2500);} catch(Exception ignore){}
   	  Boolean Drive = driver.findElements(By.xpath("//*[@text='Drive PDF Viewer']")).size()>0;
		  if (Drive) {
			  try{Thread.sleep(esperarminigifs);} catch(Exception ignore){}
			  driver.findElement(By.xpath("//*[@text='Drive PDF Viewer']")).click();
		  }
		  Boolean Allow = driver.findElements(By.xpath("//*[@text='ALLOW']")).size()>0;
		  if (Allow) {
			  try{Thread.sleep(esperarminigifs);} catch(Exception ignore){}
			  new WebDriverWait(driver, 30, esperandogifintermediario).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='ALLOW']"))).click();
		  }
         driver.pressKeyCode(AndroidKeyCode.BACK);
         try{Thread.sleep(2000);} catch(Exception ignore){}
         driver.findElement(By.xpath("//*[@text='Política de privacidade']")).click();
         }

	@AfterMethod
	public void tearDown(ITestResult tr) throws AddressException, MessagingException{
		driver.removeApp("com.consul.android.smartbeer.staging");
		System.out.println(""+ ReportURL);
		TestName = "wp_TED_TermosDeUso";
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


