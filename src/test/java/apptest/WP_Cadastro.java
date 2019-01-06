package apptest;


import java.net.URL;
import java.text.SimpleDateFormat;
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
import java.util.Date;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import java.text.DateFormat;

public class WP_Cadastro extends BaseTest implements GlobalConstants {
	protected AndroidDriver<AndroidElement> driver = null;
	protected SeeTestClient client;
	protected String ReportURL = System.getenv("ReportURL");
	protected String TestName = System.getenv("testName");
	
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		init(deviceQuery);
		// Init application / device capabilities
		dc.setCapability("testName", "wp_TED_CadastroValido");
		//dc.setCapability("deviceQuery",androidnuvem);
		dc.setCapability("deviceQuery",S7Edge+"or"+S8+"or"+S7+"or"+S6Edge+"or"+Xiaomi);
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
		
		
	}
	
	private String getDateTime() {
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	    Date date = new Date();
	    return dateFormat.format(date);
	}	
	
	@Test 
	public void cadastro() {
		
		 String strEmail = getDateTime();
		  driver.installApp("cloud:com.consul.smartbeer/com.whirlpool.ted.View.SplashActivity");
		  client.launch("com.consul.smartbeer/com.whirlpool.ted.View.SplashActivity", false, true);
		  try {Thread.sleep(esperandogifinicial);}catch (Exception ignore){}
		  driver.findElement(By.xpath("//*[@text='Cadastre-se com seu e-mail pessoal']")).click();
		  driver.findElement(By.xpath("//*[@id='emailView']")).sendKeys("tedmonitoramento@gmail.com");
		  driver.swipe(165, 759, 175, 534, 1234);
		  driver.findElement(By.xpath("//*[@id='password_view']")).sendKeys("Smart2000");
		  driver.findElement(By.xpath("//*[@id='confirm_password_view']")).sendKeys("Smart2000");
		  driver.swipe(309, 856, 390, 406, 888);
		  driver.findElement(By.xpath("//*[@id='name_and_surname_view']")).sendKeys("TED USP Brazil");
		  driver.findElement(By.xpath("//*[@id='cpfView']")).sendKeys("41801452865");
		  driver.swipe(168, 946, 334, 615, 2240);
		  driver.findElement(By.xpath("//*[@id='dobView']")).click();
		  driver.findElement(By.xpath("//*[@text='2019']")).click();
		  client.elementListSelect("xpath=//*[@id='date_picker_year_picker']", "text=2013", 0, false);
	      client.elementListSelect("xpath=//*[@id='date_picker_year_picker']", "text=2008", 0, false);
	      client.elementListSelect("xpath=//*[@id='date_picker_year_picker']", "text=2001", 0, false);
	      client.elementListSelect("xpath=//*[@id='date_picker_year_picker']", "text=1994", 0, true);
		  //client.elementListSelect("xpath=//*[@id='date_picker_year_picker']", "text=1994", 0, true);
		  //client.swipeWhileNotFound("UP", 200, 1000, "NATIVE", "//*[@text='1994' and @onScreen='true']", 0, 500, 100, false);
		  driver.findElement(By.xpath("//*[@text='OK']")).click();
		  driver.swipe(84, 887, 259, 493, 1461);
		  driver.findElement(By.xpath("//*[@id='phoneView']")).sendKeys("13982133161");
		  driver.findElement(By.xpath("//*[@text='Gênero']")).click();
		  driver.findElement(By.xpath("//*[@text='Masculino']")).click();
		  driver.swipe(450, 812, 500, 640, 1292);
		  driver.findElement(By.xpath("//*[@text='Cadastrar']")).click();
		  client.swipeWhileNotFound("DOWN", 200, 1000, "NATIVE", "//*[@id='termsCheckbox' and @onScreen='true']", 0, 500, 100, false);
		  driver.findElement(By.xpath("//*[@id='termsCheckbox']")).click();
		  driver.findElement(By.xpath("//*[@id='privacyCheckbox']")).click();
		  driver.findElement(By.xpath("//*[@id='btAccept']")).click();
		  try{Thread.sleep(esperandogifintermediario);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@id='ok']")).click();	
		  
	}
				
	@Test 
	/*public void cadastroQA() {
		  driver.installApp("cloud:com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity");
		  client.launch("com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity", false, true);
		  try {Thread.sleep(esperandogifinicial);}catch (Exception ignore){}
		  driver.findElement(By.xpath("//*[@text='Cadastre-se com seu e-mail pessoal']")).click();
		  driver.findElement(By.xpath("//*[@id='emailView']")).sendKeys("tedmonitoramento@gmail.com");
		  driver.swipe(165, 759, 175, 534, 1234);
		  driver.findElement(By.xpath("//*[@id='password_view']")).sendKeys("Smart2000");
		  driver.findElement(By.xpath("//*[@id='confirm_password_view']")).sendKeys("Smart2000");
		  driver.swipe(309, 856, 390, 406, 888);
		  driver.findElement(By.xpath("//*[@id='name_and_surname_view']")).sendKeys("TED USP Brazil");
		  driver.findElement(By.xpath("//*[@id='cpfView']")).sendKeys("41801452865");
		  driver.swipe(168, 946, 334, 615, 2240);
		  driver.findElement(By.xpath("//*[@id='dobView']")).click();
		  driver.findElement(By.xpath("//*[@text='2018']")).click();
		  driver.swipe(537, 984, 528, 1237, 200);
		  driver.swipe(543, 903, 546, 1106, 233);
		  driver.swipe(540, 771, 525, 1153, 208);
		  driver.swipe(540, 771, 525, 1153, 208);
		  driver.swipe(540, 771, 525, 1153, 208);
		  driver.swipe(540, 771, 525, 1153, 208);
		  driver.swipe(540, 771, 525, 1153, 208);
		  driver.swipe(540, 771, 525, 1153, 208);
		  driver.swipe(540, 771, 525, 1153, 208);
		  driver.swipe(540, 771, 525, 1153, 208);
	      driver.findElement(By.xpath("//*[@text='1994']")).click();
		  driver.findElement(By.xpath("//*[@text='OK']")).click();
		  driver.swipe(84, 887, 259, 493, 1461);
		  driver.findElement(By.xpath("//*[@id='phoneView']")).sendKeys("13982133161");
		  driver.findElement(By.xpath("//*[@text='Gênero']")).click();
		  driver.findElement(By.xpath("//*[@text='Masculino']")).click();
		  driver.swipe(450, 812, 500, 640, 1292);
		  driver.findElement(By.xpath("//*[@text='Cadastrar']")).click();
		  client.swipeWhileNotFound("DOWN", 200, 1000, "NATIVE", "//*[@id='termsCheckbox' and @onScreen='true']", 0, 500, 100, false);
		  driver.findElement(By.xpath("//*[@id='termsCheckbox']")).click();
		  driver.findElement(By.xpath("//*[@id='privacyCheckbox']")).click();
		  driver.findElement(By.xpath("//*[@id='btAccept']")).click();
		  try{Thread.sleep(esperandogifintermediario);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@id='ok']")).click();	
		  
	}*/
	
	@AfterMethod
	public void tearDown(ITestResult tr) throws AddressException, MessagingException{
		driver.removeApp("com.consul.android.smartbeer.staging");
		System.out.println(""+ ReportURL);
		TestName = "Este é um teste que faz um cadastro no app, ele testa todos os campos da tela de cadastro";
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

