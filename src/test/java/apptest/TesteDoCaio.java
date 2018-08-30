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


public class TesteDoCaio extends BaseTest implements GlobalConstants { 
	protected AndroidDriver<AndroidElement> driver = null;
	protected SeeTestClient client;
	
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		init(deviceQuery);
		// Init application / device capabilities
		/*dc.setCapability(MobileCapabilityType.APP, "cloud:com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.consul.android.smartbeer.staging");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.whirlpool.ted.View.SplashActivity");*/
		dc.setCapability("testName", "wp_BBLEND");
		dc.setCapability("deviceQuery",Huawei+/*"or"+A8Plus+*/"or"+S7Edge+"or"+S8+"or"+S7+"or"+LGE5X);
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
		
	}
		
	@Test
	 public void testeBBlend() {
		  driver.installApp("cloud:br.com.whirlpool.bblend/.ui.activities.MainActivity");
		  client.launch("br.com.whirlpool.bblend/.ui.activities.MainActivity", false, true);
		  driver.findElement(By.xpath("//*[@text='Pular']")).click();
		  driver.findElement(By.xpath("//*[@resource-id='br.com.whirlpool.bblend:id/ivProfile']")).click();
		  try{Thread.sleep(1000);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@id='edtUser']")).sendKeys("segoca@zippiex.com");
		  driver.findElement(By.xpath("//*[@id='edtPassword']")).sendKeys("Zupit1234");
		  try{Thread.sleep(1000);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@text='Entrar']")).click();
		  try{Thread.sleep(10000);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@text='Compre']")).click();
		       driver.findElement(By.xpath("//*[@text='Acessórios']")).click();
		       driver.findElement(By.xpath("//*[@id='rlQuantity' and @width>0 and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[./*[./*[@text='Cilindro de Gás CO2 B.blend 45 L']]]]]]")).click();
		       driver.findElement(By.xpath("//*[@text='ADICIONAR']")).click();
		       try{Thread.sleep(4000);} catch(Exception ignore){}
		       driver.findElement(By.xpath("//*[@id='bottom_navigation_item_icon' and (./preceding-sibling::* | ./following-sibling::*)[@text='1']]")).click();
		       try{Thread.sleep(4000);} catch(Exception ignore){}
		       driver.findElement(By.xpath("//*[@text='Continuar']")).click();
		       try{Thread.sleep(4000);} catch(Exception ignore){}
		       driver.swipe(712, 1215, 690, -78, 1090);
		       try{Thread.sleep(4000);} catch(Exception ignore){}
		       driver.findElement(By.xpath("//*[@id='rlTitle' and ./*[@text='Selecione a forma de pagamento']]")).click();
		       try{Thread.sleep(4000);} catch(Exception ignore){}
		       driver.swipe(775, 915, 765, 543, 838);
		       try{Thread.sleep(4000);} catch(Exception ignore){}
		       driver.findElement(By.xpath("//*[@text='Boleto bancário']")).click();
		       new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='bottom_navigation_item_icon' and (./preceding-sibling::* | ./following-sibling::*)[@text='Início']]")));
		       driver.findElement(By.xpath("//*[@id='bottom_navigation_item_icon' and (./preceding-sibling::* | ./following-sibling::*)[@text='Início']]")).click();
		       try{Thread.sleep(4000);} catch(Exception ignore){}
		       driver.findElement(By.xpath("//*[@id='ivProfile']")).click();
		  
	}
	@AfterMethod
	public void tearDown(ITestResult tr){
		driver.removeApp("br.com.whirlpool.bblend/.ui.activities.MainActivity");
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