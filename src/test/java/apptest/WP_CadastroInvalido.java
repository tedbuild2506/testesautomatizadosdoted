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



public class WP_CadastroInvalido extends BaseTest implements GlobalConstants {
	protected AndroidDriver<AndroidElement> driver = null;
	protected SeeTestClient client;
	protected String ReportURL = System.getenv("ReportURL");
	protected String TestName = System.getenv("testName");
	
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		init(deviceQuery);
		// Init application / device capabilities
		//dc.setCapability(MobileCapabilityType.APP, "cloud:com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity");
		//dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.consul.android.smartbeer.staging");
		//dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.whirlpool.ted.View.SplashActivity");
		dc.setCapability("testName", "wp_TED_CadastroInvalido");
		//dc.setCapability("deviceQuery",androidnuvem);
		dc.setCapability("deviceQuery",S7Edge+"or"+S8+"or"+S7+"or"+S6Edge+"or"+Xiaomi);
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
		
	}
		
	@Test
	 public void testecadastroinvalido() {
	  driver.installApp("cloud:com.consul.smartbeer/com.whirlpool.ted.View.SplashActivity");
	  client.launch("com.consul.smartbeer/com.whirlpool.ted.View.SplashActivity", false, true);
	  try{Thread.sleep(esperandogifinicial);} catch(Exception ignore){}
	  driver.findElement(By.xpath("//*[@text='Cadastre-se com seu e-mail pessoal']")).click();
	  driver.findElement(By.xpath("//*[@id='emailView']")).sendKeys("ashutosh@ashutosh.com.br");
	  driver.swipe(165, 759, 175, 534, 1234);
	  driver.findElement(By.xpath("//*[@id='password_view']")).sendKeys("lucasmoreira");
	  driver.findElement(By.xpath("//*[@id='confirm_password_view']")).sendKeys("lucazmoreira");
	  driver.swipe(309, 856, 390, 406, 888);
	  driver.findElement(By.xpath("//*[@id='name_and_surname_view']")).sendKeys("teste");
	  driver.findElement(By.xpath("//*[@id='cpfView']")).sendKeys("12345678901");
	  driver.swipe(168, 946, 334, 615, 2240);
	  driver.findElement(By.xpath("//*[@id='dobView']")).click();
	  driver.findElement(By.xpath("//*[@text='2019']")).click();
	  driver.findElement(By.xpath("//*[@text='2020']")).click();
	  driver.findElement(By.xpath("//*[@text='OK']")).click();
	  driver.swipe(84, 887, 259, 493, 1461);
	  driver.findElement(By.xpath("//*[@id='phoneView']")).sendKeys("99999999999");
	  driver.swipe(450, 812, 500, 640, 1292);
	  driver.findElement(By.xpath("//*[@text='Cadastrar']")).click();
	 }
	
	/*@Test
	 public void testTeste_cadastro_campos_invalidosQA() {
	  driver.installApp("cloud:com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity");
	  client.launch("com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity", false, true);
	  try{Thread.sleep(esperandogifinicial);} catch(Exception ignore){}
	  driver.findElement(By.xpath("//*[@text='Cadastre-se com seu e-mail pessoal']")).click();
	  driver.findElement(By.xpath("//*[@id='emailView']")).sendKeys("ashutosh@ashutosh.com.br");
	  driver.swipe(165, 759, 175, 534, 1234);
	  driver.findElement(By.xpath("//*[@id='password_view']")).sendKeys("lucasmoreira");
	  driver.findElement(By.xpath("//*[@id='confirm_password_view']")).sendKeys("lucazmoreira");
	  driver.swipe(309, 856, 390, 406, 888);
	  driver.findElement(By.xpath("//*[@id='name_and_surname_view']")).sendKeys("teste");
	  driver.findElement(By.xpath("//*[@id='cpfView']")).sendKeys("12345678901");
	  driver.swipe(168, 946, 334, 615, 2240);
	  driver.findElement(By.xpath("//*[@id='dobView']")).click();
	  driver.findElement(By.xpath("//*[@text='2018']")).click();
	  driver.findElement(By.xpath("//*[@text='2020']")).click();
	  driver.findElement(By.xpath("//*[@text='OK']")).click();
	  driver.swipe(84, 887, 259, 493, 1461);
	  driver.findElement(By.xpath("//*[@id='phoneView']")).sendKeys("99999999999");
	  driver.swipe(450, 812, 500, 640, 1292);
	  driver.findElement(By.xpath("//*[@text='Cadastrar']")).click();
	 }*/
	
	@AfterMethod
	public void tearDown(ITestResult tr) throws AddressException, MessagingException{
		driver.removeApp("com.consul.android.smartbeer.staging");
		ReportURL = driver.getCapabilities().getCapability("reportUrl").toString();
		System.out.println(""+ ReportURL);
		TestName = "Teste de cadastro inválido.";
		if (driver!=null)
		{
			
			if (tr.isSuccess()) 
			{
				//String result = "\t\n\n Este é um teste que faz\t\n\n um cadastro no app usando dados inválidos (que não devem ser aceitos).\t\n O app não pode permitir o cadastro";
				client.report("Test has passed", true);
				/*Email e = new Email();
				e.setMailServerProperties();
				e.createEmailMessage(ReportURL, TestName, result);
				e.sendEmail();*/
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
