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


public class WP_CadastroEmBranco extends BaseTest implements GlobalConstants { 
	protected AndroidDriver<AndroidElement> driver = null;
	protected SeeTestClient client;
	
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		init(deviceQuery);
		// Init application / device capabilities
		//dc.setCapability(MobileCapabilityType.APP, "cloud:com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity");
		//dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.consul.android.smartbeer.staging");
		//dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.whirlpool.ted.View.SplashActivity");
		dc.setCapability("testName", "wp_TED_SamsungCadastroEmBranco");
		dc.setCapability("deviceQuery",S9Plus+ "or"+ S7+"or"+LGE5X+"or"+S7Edge+"or"+S8);
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
		
	}
		
	@Test
	 public void testedecadastrobranco() {
	  driver.installApp("cloud:com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity");
      client.launch("com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity", false, true);
	  try{Thread.sleep(esperandogifinicial);} catch(Exception ignore){}
	  driver.findElement(By.xpath("//*[@text='Cadastre-se com seu e-mail pessoal']")).click();
	  driver.swipe(165, 759, 175, 534, 1234);
	  driver.swipe(309, 856, 390, 406, 888);
	  driver.swipe(168, 946, 334, 615, 2240);
	  driver.swipe(84, 887, 259, 493, 1461);
	  driver.swipe(450, 812, 500, 640, 1292);
	  driver.findElement(By.xpath("//*[@text='Cadastrar']")).click();
	  Boolean isPresent = driver.findElements(By.xpath("//*[@text='Digite e-mail']")).size()<0;
	  if (isPresent.TRUE) {
		  client.report("Teste funcionou como o esperado", true);
	  }
	  else {
		  client.report("O aplicativo não bloqueiou o cadastro invalido. Teste falhou", false);
	  }
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
			driver.quit();
		}
	}
}
