package apptest;


import java.net.URL;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

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


public class WP_Configuracoes extends BaseTest implements GlobalConstants { 
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
		dc.setCapability("testName", "wp_TED_Configuracao");
		//dc.setCapability("deviceQuery",androidnuvem);
		dc.setCapability("deviceQuery",S7Edge+"or"+S8+"or"+S7+"or"+S6Edge+"or"+Xiaomi);
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
		
	}
		
	@Test
	 public void testedeconfiguracoesbasicas() {
		  driver.installApp("cloud:com.consul.smartbeer/com.whirlpool.ted.View.SplashActivity");
		  client.launch("com.consul.smartbeer/com.whirlpool.ted.View.SplashActivity", false, true);
		  try{Thread.sleep(esperandogifintermediario);} catch(Exception ignore){}
    	  driver.findElement(By.xpath("//*[@text='Acesse sua conta']")).click();
    	  driver.findElement(By.xpath("//*[@id='edEmail']")).sendKeys("tedmonitoramento@gmail.com");
    	  driver.findElement(By.xpath("//*[@id='edPassword']")).sendKeys("Smart2000");
    	  driver.findElement(By.xpath("//*[@text='Entrar']")).click();
    	  try{Thread.sleep(esperandogifinicial+2800);} catch(Exception ignore){}
    	  driver.findElement(By.xpath("//*[@id='imgUser']")).click();
          driver.findElement(By.xpath("//*[@text='Configurações da smartbeer_']")).click();
    	  Boolean Drive = driver.findElements(By.xpath("//*[@text='Conectado']")).size()>0;
		  if (Drive) {
			  try{Thread.sleep(esperarminigifs);} catch(Exception ignore){}
			  client.report("A cervejeira está conectada", true);
		  }
		  Boolean Allow = driver.findElements(By.xpath("//*[@text='03/08/2018']")).size()>0;
		  String data = "03/08/2018";
		  if (Allow) {
			  try{Thread.sleep(esperarminigifs);} catch(Exception ignore){}
			  client.report("A cervejeira foi calibrada em" +data, true);
		  }
		  driver.findElement(By.xpath("//*[@text='Descadastrar smartbeer_']")).click();
		  driver.findElement(By.xpath("//*[@text='CANCELAR']")).click();
		  driver.findElement(By.xpath("//*[@id='left_icon']")).click();
      	 }

	@Test
	 public void testedeconfiguracoesbasicasQA() {
		  driver.installApp("cloud:com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity");
		  client.launch("com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity", false, true);
		  try{Thread.sleep(esperandogifintermediario);} catch(Exception ignore){}
   	  driver.findElement(By.xpath("//*[@text='Acesse sua conta']")).click();
   	  driver.findElement(By.xpath("//*[@id='edEmail']")).sendKeys("tedmonitoramento@gmail.com");
   	  driver.findElement(By.xpath("//*[@id='edPassword']")).sendKeys("Smart2000");
   	  driver.findElement(By.xpath("//*[@text='Entrar']")).click();
   	  try{Thread.sleep(esperandogifinicial+2500);} catch(Exception ignore){}
   	  driver.findElement(By.xpath("//*[@id='imgUser']")).click();
         driver.findElement(By.xpath("//*[@text='Configurações da smartbeer_']")).click();
   	  Boolean Drive = driver.findElements(By.xpath("//*[@text='Conectado']")).size()>0;
		  if (Drive) {
			  try{Thread.sleep(esperarminigifs);} catch(Exception ignore){}
			  client.report("A cervejeira está conectada", true);
		  }
		  Boolean Allow = driver.findElements(By.xpath("//*[@text='03/08/2018']")).size()>0;
		  String data = "03/08/2018";
		  if (Allow) {
			  try{Thread.sleep(esperarminigifs);} catch(Exception ignore){}
			  client.report("A cervejeira foi calibrada em" +data, true);
		  }
		  driver.findElement(By.xpath("//*[@text='Descadastrar smartbeer_']")).click();
		  driver.findElement(By.xpath("//*[@text='CANCELAR']")).click();
		  driver.findElement(By.xpath("//*[@id='left_icon']")).click();
     	 }
	
	@AfterMethod
	public void tearDown(ITestResult tr) throws AddressException, MessagingException{
		driver.removeApp("com.consul.android.smartbeer.staging");
		System.out.println(""+ ReportURL);
		TestName = "wp_TED_Configurações";
		if (driver!=null)
		{
			
			if (tr.isSuccess()) 
			{
				String result = "passou";
				client.report("Test has passed", true);
				Email e = new Email();
				e.setMailServerProperties();
				e.createEmailMessage(ReportURL, TestName, result);
				e.sendEmail();
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


