package apptest;

import java.net.URL;
import java.lang.Thread;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.experitest.appium.SeeTestClient;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class WP_Marketplace extends BaseTest implements GlobalConstants {
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
		dc.setCapability("testName", "wp_TED_GalaxyS6PlusMarketPlace");
		dc.setCapability("deviceQuery", "@serialnumber='1115fbd4746c2f05'");
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
	}
	
	 @Test
	 public void testeMarketplace() {
	  client.applicationClearData("com.consul.android.smartbeer.staging");
	  driver.startActivity("com.consul.android.smartbeer.staging", "com.whirlpool.ted.View.SplashActivity");
	  client.setShowReport(false);
  	  new WebDriverWait(driver, 30, esperandogif).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Acesse sua conta']"))).click();
  	  client.setShowReport(true);
  	  driver.findElement(By.xpath("//*[@id='edEmail']")).sendKeys("tedmonitoramento@gmail.com");
	  driver.findElement(By.xpath("//*[@id='edPassword']")).sendKeys("Smart2000");
	  driver.findElement(By.xpath("//*[@text='Entrar']")).click();
	  client.setShowReport(false);
	  new WebDriverWait(driver, 30, esperandogif).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='imgCart']"))).click();
	  client.setShowReport(true);
	  driver.findElement(By.xpath("//*[@id='ze_delivery_store_button']")).click();
	  new WebDriverWait(driver, 30, esperandogif).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='ALLOW']"))).click();
	  client.setShowReport(false);
	  new WebDriverWait(driver, 30, esperandogif).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='addQuantityView' and @height>0 and ./parent::*[./parent::*[./preceding-sibling::*[@text='Skol 300ml | Apenas o Líquido.']]]]")));
	  client.setShowReport(true);
	  driver.findElement(By.xpath("//*[@id='addQuantityView' and @height>0 and ./parent::*[./parent::*[./preceding-sibling::*[@text='Skol 300ml | Apenas o Líquido.']]]]")).click();
	  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
	  driver.findElement(By.xpath("//*[@id='addQuantityView' and @height>0 and ./preceding-sibling::*[@text='1']]")).click();
	  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
	  driver.findElement(By.xpath("//*[@id='addQuantityView' and @height>0 and ./preceding-sibling::*[@text='2']]")).click();
	  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
	  driver.findElement(By.xpath("//*[@id='bottomView']")).click();
	  client.setShowReport(false);
	  new WebDriverWait(driver, 30, esperandogif).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='myDataTitleView']")));
	  client.setShowReport(true);
	  driver.swipe(512, 1281, 478, 546, 1320);
	  driver.swipe(521, 1218, 475, 650, 644);
	  driver.swipe(531, 1215, 478, 550, 596);
	  driver.swipe(571, 1090, 496, 121, 673);
	  driver.findElement(By.xpath("//*[@id='totalPriceView']")).click();
	  new WebDriverWait(driver, 30, esperandogif).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='CONFIRMAR']"))).click();
	  client.setShowReport(false);
	  new WebDriverWait(driver, 30, esperandogif).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Pagina inicial']")));
	  client.setShowReport(true);
	  driver.findElement(By.xpath("//*[@text='Pagina inicial']")).click();
	  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
	  driver.findElement(By.xpath("//*[@id='imgCart']")).click();
	  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
	  driver.findElement(By.xpath("//*[@id='cerveja_store_button']")).click();
	  client.setShowReport(false);
	  new WebDriverWait(driver, 30, esperandogif).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='details_button' and @height>0 and ./parent::*[./preceding-sibling::*[@text='Cerveja Wals Evita 375ml']]]")));
	  client.setShowReport(true);
	  driver.findElement(By.xpath("//*[@id='details_button' and @height>0 and ./parent::*[./preceding-sibling::*[@text='Cerveja Wals Evita 375ml']]]")).click();
	  client.setShowReport(false);
	  new WebDriverWait(driver, 30, esperandogif).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='addQuantityView']")));
	  client.setShowReport(true);
	  driver.findElement(By.xpath("//*[@id='addQuantityView']")).click();
	  driver.findElement(By.xpath("//*[@text='Adicionar ao carrinho']")).click();
	  client.setShowReport(false);
	  new WebDriverWait(driver, 30, esperandogif).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@contentDescription='TODO']")));
	  client.setShowReport(true);
	  driver.findElement(By.xpath("//*[@contentDescription='TODO']")).click();
	  client.setShowReport(false);
	  new WebDriverWait(driver, 30, esperandogif).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='deliveryAddressTitleView']")));
	  client.setShowReport(false);
	  driver.swipe(546, 1412, 506, 365, 464);
	  driver.findElement(By.xpath("//*[@id='radio_view1']")).click();
	  driver.swipe(700, 1400, 550, 309, 578);
	  driver.swipe(662, 1515, 718, 487, 574);
	  driver.findElement(By.xpath("//*[@id='totalPriceView']")).click();
	  driver.findElement(By.xpath("//*[@text='CONFIRMAR']")).click();
	  client.setShowReport(false);
	  new WebDriverWait(driver, 30, esperandogif).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Ver meus pedidos']")));
	  client.setShowReport(true);
	  driver.findElement(By.xpath("//*[@text='Ver meus pedidos']")).click();
	 }

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
