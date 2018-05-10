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


public class WP_ZeDeliverySemDistribuidor extends BaseTest implements GlobalConstants {
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
		dc.setCapability("testName", "wp_TED_SemDistribuidor");
		dc.setCapability("deviceQuery",LGE5X);
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
		
	}
	
	@Test 
	public void test_SemDistribuidor() {
		driver.installApp("cloud:com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity");
		client.launch("com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity", false, true);
		try{Thread.sleep(esperandogifinicial);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@text='Acesse sua conta']")).click();
		driver.findElement(By.xpath("//*[@id='edEmail']")).sendKeys("giuliateste2@mailinator.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='edPassword']")));
		driver.findElement(By.xpath("//*[@id='edPassword']")).sendKeys("Smart2000");
		driver.findElement(By.xpath("//*[@text='Entrar']")).click();
		try{Thread.sleep(esperandogifinicial+4000);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@id='imgCart']")).click();
		driver.findElement(By.xpath("//*[@text='Entrar na loja']")).click();
		try{Thread.sleep(esperandogifintermediario);} catch(Exception ignore){}
		Boolean Permitir = driver.findElements(By.xpath("//*[@text='ALLOW']")).size()>0;
		if (Permitir) {
		driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
		try{Thread.sleep(esperandogifinicial+0500);} catch(Exception ignore){}
	    driver.findElement(By.xpath("//*[@text='Cadastrar novo endereço']")).click();
		try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@id='cepView']")).sendKeys("69908-600");
		try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@id='streetText']")).sendKeys("Rua Pernambuco");
		try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@id='numberText']")).sendKeys("33");
		driver.findElement(By.xpath("//*[@id='neighborhoodText']")).sendKeys("Bosque");
		driver.swipe(768, 431, 768, 359, 128);
		driver.findElement(By.xpath("//*[@text='Estado']")).click();
		try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@text='AC']")).click();
		try{Thread.sleep(threadSleep+2500);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@text='Acrelândia']")).click();
		try{Thread.sleep(threadSleep+2500);} catch(Exception ignore){}
		driver.swipe(621, 1656, 650, 1131, 254);
		try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		driver.swipe(568, 1628, 615, 1296, 240);
		try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		driver.swipe(565, 1731, 562, 1525, 358);
		try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@text='Rio Branco']")).click();
		driver.findElement(By.xpath("//*[@text='Salvar meu endereço para futuras compras']")).click();
		driver.findElement(By.xpath("//*[@text='Salvar']")).click();
		try{Thread.sleep(esperandogifintermediario);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@text='UTILIZAR' and ./parent::*[./parent::*[./preceding-sibling::*[@text='Endereço padrão']]]]")).click();
		try{Thread.sleep(esperandogifintermediario+0500);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@text='O distribuidor mais próximo não está disponível no momento.']")).click();
		}
		else {
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Cadastrar novo endereço']")));
		    driver.findElement(By.xpath("//*[@text='Cadastrar novo endereço']")).click();
			driver.findElement(By.xpath("//*[@id='cepView']")).sendKeys("69908-600");
			new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='streetText']")));
			driver.findElement(By.xpath("//*[@id='streetText']")).sendKeys("Rua Pernambuco");
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='numberText']")));
			driver.findElement(By.xpath("//*[@id='numberText']")).sendKeys("33");
			driver.findElement(By.xpath("//*[@id='neighborhoodText']")).sendKeys("Bosque");
			driver.swipe(768, 431, 768, 359, 128);
			driver.findElement(By.xpath("//*[@text='Estado']")).click();
			driver.findElement(By.xpath("//*[@text='AC']")).click();
			driver.findElement(By.xpath("//*[@text='Acrelândia']")).click();
			driver.swipe(621, 1656, 650, 1131, 254);
			driver.swipe(568, 1628, 615, 1296, 240);
			driver.swipe(565, 1731, 562, 1525, 358);
			driver.findElement(By.xpath("//*[@text='Rio Branco']")).click();
			driver.findElement(By.xpath("//*[@text='Salvar meu endereço para futuras compras']")).click();
			driver.findElement(By.xpath("//*[@text='Salvar']")).click();
			try{Thread.sleep(threadSleep);} catch(Exception ignore){}
			driver.findElement(By.xpath("//*[@text='UTILIZAR' and ./parent::*[./parent::*[./preceding-sibling::*[@text='Endereço padrão']]]]")).click();
			new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='O distribuidor mais próximo não está disponível no momento.']")));
			driver.findElement(By.xpath("//*[@text='O distribuidor mais próximo não está disponível no momento.']")).click();
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
