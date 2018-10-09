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

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class WP_CadastroEmBrancoIOS extends BaseTest implements GlobalConstants {
	protected IOSDriver<IOSElement> driver = null;
	protected SeeTestClient client;


	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='ios'") String deviceQuery) throws Exception{
		init(deviceQuery);
		dc.setCapability(MobileCapabilityType.APP, "cloud:com.consul.smartbeer-staging");
		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.consul.smartbeer-staging");
		dc.setCapability("testName", "wp_TED_Iphone6CadastroBranco");
		dc.setCapability("deviceQuery", "@serialnumber='5f354f456c655f1cfa05be9a63139072f9e67fe2'");
		driver = new IOSDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
	}
	
	@Test
	public void testecadastroembrancoIOS(){
		  //client.applicationClearData("com.consul.android.smartbeer.staging");
		  /*client.setShowReport(false);
	  	  new WebDriverWait(driver, 30, esperandogif).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Allow']"))).click();
	  	  new WebDriverWait(driver, 30, esperandogif).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Cancel']"))).click();
	  	  client.setShowReport(true);*/
		  //driver.installApp("com.consul.android.smartbeer.staging", "com.whirlpool.ted.View.SplashActivity");
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
		  System.out.println("report URL : " + driver.getCapabilities().getCapability("reportUrl"));
		  //client.releaseDevice("5f354f456c655f1cfa05be9a63139072f9e67fe2", true, false, true);
		  driver.quit();
		  
		 
			
					
					
				
			
	}
	

}
