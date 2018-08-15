package apptest;


import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
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

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class WP_EmporioDaCerveja extends BaseTest implements GlobalConstants {
	protected AndroidDriver<AndroidElement> driver = null;
	protected SeeTestClient client;
	
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		init(deviceQuery);
		// Init application / device capabilities
		dc.setCapability("testName", "wp_TED_ValorMinimo");
		//dc.setCapability("deviceQuery",Huawei+/*"or"+A8Plus+*/"or"+S7Edge+"or"+S8+"or"+S7+"or"+LGE5X);
		dc.setCapability("deviceQuery",LGE5X);
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
		
	}
	
	@Test 
	public void testeemporiodacerveja() {
		driver.installApp("cloud:com.consul.smartbeer/com.whirlpool.ted.View.SplashActivity");
		client.launch("com.consul.smartbeer/com.whirlpool.ted.View.SplashActivity", false, true);
		try{Thread.sleep(esperandogifinicial);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@text='Acesse sua conta']")).click();
		driver.findElement(By.xpath("//*[@id='edEmail']")).sendKeys("tedmonitoramento@gmail.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='edPassword']")));
		driver.findElement(By.xpath("//*[@id='edPassword']")).sendKeys("Smart2000");
		driver.findElement(By.xpath("//*[@text='Entrar']")).click();
		try{Thread.sleep(esperandogifinicial+3500);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@id='imgCart']")).click();
		driver.findElement(By.xpath("//*[@id='cerveja_store_button']")).click();
		try{Thread.sleep(esperandogifintermediario);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@text='Ordenar por']")).click();
		driver.findElement(By.xpath("//*[@text='Menor preco']")).click();
		try{Thread.sleep(esperandogifintermediario);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@id='userNameView']")).click();
		try{Thread.sleep(threadSleep);} catch(Exception ignore){}
	    driver.findElement(By.xpath("//*[@id='addToCartView']")).click();
	    try{Thread.sleep(esperandogifintermediario);} catch(Exception ignore){}
	    driver.findElement(By.xpath("//*[@id='cartQuantity']")).click();
	    try{Thread.sleep(esperandogifintermediario);} catch(Exception ignore){}
	    driver.swipe(675, 1243, 665, 743, 253);
	    driver.swipe(675, 1243, 665, 743, 253);
	    driver.swipe(675, 1243, 665, 743, 253);
		driver.findElement(By.xpath("//*[@id='changeCardButton']")).click();
		try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@id='tvRegNewCard']")).click();
		try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@id='creditCardNoView']")).sendKeys("4551-8310-2111-3207");
		driver.findElement(By.xpath("//*[@id='creditCardName']")).sendKeys("LUCAS M DOS SANTOS");
		driver.findElement(By.xpath("//*[@id='month']")).sendKeys("10");
		driver.findElement(By.xpath("//*[@id='year']")).sendKeys("19");
		driver.findElement(By.xpath("//*[@id='cvv']")).sendKeys("114");
		driver.findElement(By.xpath("//*[@id='saveCardCheckBox']")).click();
		driver.findElement(By.xpath("//*[@id='saveButton']")).click();
		try{Thread.sleep(esperandogifintermediario);} catch(Exception ignore){}
		driver.swipe(675, 1243, 665, 743, 253);
		driver.swipe(675, 1243, 665, 743, 253);
		driver.swipe(675, 1243, 665, 743, 253);
		driver.swipe(675, 1243, 665, 743, 253);
		driver.swipe(675, 1243, 665, 743, 253);
		driver.swipe(675, 1243, 665, 743, 253);
		driver.swipe(675, 1243, 665, 743, 253);
		driver.swipe(675, 1243, 665, 743, 253);
		driver.findElement(By.xpath("//*[@id='totalPriceView']")).click();
		driver.findElement(By.xpath("//*[@text='CONFIRMAR']")).click();
		try{Thread.sleep(esperandogifinicial);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@id='ok']")).click();
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
