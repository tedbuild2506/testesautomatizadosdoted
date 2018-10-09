package apptest;


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
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class WP_ZeDeliverySemDistribuidor extends BaseTest implements GlobalConstants {
	protected AndroidDriver<AndroidElement> driver = null;
	protected SeeTestClient client;
	
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		init(deviceQuery);
		// Init application / device capabilities
		dc.setCapability("testName", "wp_TED_ZéDelivery");
		dc.setCapability("deviceQuery",Xiaomi);
		//dc.setCapability("deviceQuery",androidnuvem);
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
		
	}
	
	@Test 
	public void testesemdistribuidor() {
		driver.installApp("cloud:com.consul.smartbeer/com.whirlpool.ted.View.SplashActivity");
		client.launch("com.consul.smartbeer/com.whirlpool.ted.View.SplashActivity", false, true);
		try {Thread.sleep(esperandogifinicial);}catch (Exception ignore){}
		driver.findElement(By.xpath("//*[@text='Acesse sua conta']")).click();
		driver.findElement(By.xpath("//*[@id='edEmail']")).sendKeys("tedmonitoramento@gmail.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='edPassword']")));
		driver.findElement(By.xpath("//*[@id='edPassword']")).sendKeys("Smart2000");
		driver.findElement(By.xpath("//*[@text='Entrar']")).click();
		try{Thread.sleep(esperandogifinicial+4000);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@id='imgCart']")).click();
		driver.findElement(By.xpath("//*[@text='Entrar na loja']")).click();
		try{Thread.sleep(esperandogifintermediario);} catch(Exception ignore){}
		Boolean Permitir = driver.findElements(By.xpath("//*[@text='ALLOW']")).size()>0;
		if (Permitir) {
		driver.findElement(By.xpath("//*[@text='ALLOW']")).click();}
		try{Thread.sleep(esperandogifinicial+0500);} catch(Exception ignore){}
		//driver.findElement(By.xpath("//*[@text='UTILIZAR']")).click();
		driver.findElement(By.xpath("//*[@text='Cadastrar novo endereço']")).click();
		driver.findElement(By.xpath("//*[@id='cepView']")).sendKeys("69908-600");
		try{Thread.sleep(threadSleep+0500);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@id='streetText']")).sendKeys("Rua Pernambuco");
		driver.findElement(By.xpath("//*[@id='numberText']")).sendKeys("33");
		driver.findElement(By.xpath("//*[@id='neighborhoodText']")).sendKeys("Bosque");
		driver.findElement(By.xpath("//*[@text='Salvar meu endereço para futuras compras']")).click();
		driver.findElement(By.xpath("//*[@text='Salvar']")).click();
		try{Thread.sleep(esperandogifinicial+3000);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@id='addQuantityView']")).click();
		try {Thread.sleep(threadSleep+0500);}catch (Exception ignore) {}
		driver.findElement(By.xpath("//*[@id='addQuantityView']")).click();
		driver.findElement(By.xpath("//*[@id='totalPriceTextView']")).click();
		try{Thread.sleep(esperandogifintermediario+0500);} catch(Exception ignore){}
		client.swipeWhileNotFound("DOWN", 200, 1000, "NATIVE", "//*[@id='totalPriceTextView' and @onScreen='true']", 0, 500, 21, false);
		driver.findElement(By.xpath("//*[@id='totalPriceTextView']")).click();
		driver.findElement(By.xpath("//*[@text='CONFIRMAR']")).click();
		try{Thread.sleep(esperandogifintermediario);} catch(Exception ignore){}
				
		}
	
	@AfterMethod
	public void tearDown(ITestResult tr){
		driver.removeApp("com.consul.android.smartbeer.staging");
		if (driver!=null)
		{
			if (tr.isSuccess()) 
			{
				client.report("Test has passed", true);
				client.report("reportURL" + driver.getCapabilities().getCapability("reportUrl"), true);
				client.setShowReport(true);
			}
			else {
				client.report("Test has failed", false);
				client.report("reportURL" + driver.getCapabilities().getCapability("reportUrl"), true);
				client.setShowReport(true);
			}
			System.out.println("report URL : " + driver.getCapabilities().getCapability("reportUrl"));
			driver.quit();
		}
		
	}
	
}
