package apptest;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class WP_CadastroIOS extends BaseTest implements GlobalConstants {
	protected IOSDriver<IOSElement> driver = null;
	protected SeeTestClient client;


	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='ios'") String deviceQuery) throws Exception{
		init(deviceQuery);
		dc.setCapability(MobileCapabilityType.APP, "cloud:com.consul.smartbeer-staging");
		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.consul.smartbeer-staging");
		dc.setCapability("testName", "wp_TED_Iphone8CadastroBranco");
		dc.setCapability("deviceQuery", "@serialnumber='2ef16f1e7b475b9e6aa09392efb67735b1b57b08'");		
		driver = new IOSDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
	}
	
	private String getDateTime() {
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	    Date date = new Date();
	    return dateFormat.format(date);
	}	
	@Test
	public void testecadastroinvalidoIOS(){
		String strEmail = getDateTime();
		 Boolean Allow = driver.findElements(By.xpath("//*[@value='Allow']")).size()>0;
		  if (Allow) {
			  driver.findElement(By.xpath("//*[@value='Allow']")).click();
			  try{Thread.sleep(esperarminigifs);} catch(Exception ignore){}
			  driver.findElement(By.xpath("//*[@text='Cadastre-se com seu e-mail pessoal']")).click();
			  driver.findElement(By.xpath("//*[@placeholder='Email']")).sendKeys(strEmail + "@mailinator.com");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.swipe(165, 759, 175, 534, 1234);
			  driver.findElement(By.xpath("//*[@placeholder='Senha']")).sendKeys("Smart2000");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.findElement(By.xpath("//*[@placeholder='Confirmer Senha']")).sendKeys("Smart2000");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.swipe(309, 856, 390, 406, 888);
			  driver.findElement(By.xpath("//*[@placeholder='Nome e Sobrenome']")).sendKeys("TED USP BRAZIL");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.findElement(By.xpath("//*[@placeholder='CPF']")).sendKeys("41801452865");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.swipe(168, 946, 334, 615, 2240);
			  driver.findElement(By.xpath("//*[@placeholder='Data de nascimento (dd/mm/aaaa)']")).click();
			  driver.swipe(156, 1050, 147, 1219, 251);
			  driver.findElement(By.xpath("//*[@text='Feito']")).click();
			  driver.swipe(84, 887, 259, 493, 1461);
			  driver.findElement(By.xpath("//*[@placeholder='Telefone']")).sendKeys("13982133161");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.findElement(By.xpath("//*[@placeholder='Gênero']")).click();
			  driver.findElement(By.xpath("//*[@text='Masculino']")).click();
			  driver.findElement(By.xpath("//*[@id='Feito']")).click();
			  driver.swipe(450, 812, 500, 640, 1292);
			  driver.findElement(By.xpath("//*[@id='Cadastrar']")).click();
			  driver.findElement(By.xpath("//*[@text='Aceito os termos de uso']")).click();
			  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Verificar validação']")));
			  driver.findElement(By.xpath("//*[@text='Verificar validação']")).click();
			  client.launch("com.apple.mobilesafari", false, false);
			  driver.context("WEBVIEW_1");
			  driver.findElement(By.xpath("//*[@id='URL']")).sendKeys("www.mailinator.com/v2/inbox.jsp?zone=public&query=" + strEmail);
			  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
			  driver.getKeyboard().sendKeys("{ENTER}");
			  driver.executeScript("client:client.swipeWhileNotFound(\"Right\", 0, 2000, \"NATIVE\", \"xpath=//*[@text='Instruções de confirmação']\", 0, 3000, 2, true)");
			  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
			  driver.executeScript("client:client.swipeWhileNotFound(\"Right\", 0, 2000, \"NATIVE\", \"xpath=//*[@text='Ativar']\", 0, 6000, 7, true)");
			  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
			  driver.executeScript("client:client.deviceAction(\"Home\")");
			  driver.context("NATIVE_APP");
			  client.applicationClearData("com.consul.android.smartbeer.staging");
			  client.launch("com.consul.smartbeer-staging\"", false, false);
			  try{Thread.sleep(esperandogifinicial);} catch(Exception ignore){}
			  driver.findElement(By.xpath("(//*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAView']]]]/*[@class='UIAButton'])[4]")).click();
			  driver.findElement(By.xpath("//*[@placeholder='Email']")).sendKeys(strEmail + "@mailinator.com");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='Senha']")));
			  driver.findElement(By.xpath("//*[@placeholder='Senha']")).sendKeys("Smart2000");
			  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='UIAKeyboard']")));
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.findElement(By.xpath("//*[@text='Entrar']")).click(); 
			  }
		  else  {
			  try{Thread.sleep(esperarminigifs);} catch(Exception ignore){}
			  driver.findElement(By.xpath("//*[@text='Cadastre-se com seu e-mail pessoal']")).click();
			  driver.findElement(By.xpath("//*[@placeholder='Email']")).sendKeys(strEmail + "@mailinator.com");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.swipe(165, 759, 175, 534, 1234);
			  driver.findElement(By.xpath("//*[@placeholder='Senha']")).sendKeys("Smart2000");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.findElement(By.xpath("//*[@placeholder='Confirmer Senha']")).sendKeys("Smart2000");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.swipe(309, 856, 390, 406, 888);
			  driver.findElement(By.xpath("//*[@placeholder='Nome e Sobrenome']")).sendKeys("TED USP BRAZIL");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.findElement(By.xpath("//*[@placeholder='CPF']")).sendKeys("41801452865");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.swipe(168, 946, 334, 615, 2240);
			  driver.findElement(By.xpath("//*[@text='Data de Nascimento (dd/mm/aaaa)']")).click();
			  driver.swipe(156, 1050, 147, 1219, 251);
			  driver.findElement(By.xpath("//*[@text='Feito']")).click();
			  driver.swipe(84, 887, 259, 493, 1461);
			  driver.findElement(By.xpath("//*[@placeholder='Telefone']")).sendKeys("13982133161");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.findElement(By.xpath("//*[@placeholder='Gênero']")).click();
			  driver.findElement(By.xpath("//*[@text='Masculino']")).click();
			  driver.findElement(By.xpath("//*[@id='Feito']")).click();
			  driver.swipe(450, 812, 500, 640, 1292);
			  driver.findElement(By.xpath("//*[@id='Cadastrar']")).click();
			  driver.findElement(By.xpath("//*[@text='Aceito os termos de uso']")).click();
			  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Verificar validação']")));
			  driver.findElement(By.xpath("//*[@text='Verificar validação']")).click();
			  client.launch("com.apple.mobilesafari", false, false);
			  driver.context("WEBVIEW_1");
			  driver.findElement(By.xpath("//*[@id='URL']")).sendKeys("www.mailinator.com/v2/inbox.jsp?zone=public&query=" + strEmail);
			  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
			  driver.getKeyboard().sendKeys("{ENTER}");
			  driver.executeScript("client:client.swipeWhileNotFound(\"Right\", 0, 2000, \"NATIVE\", \"xpath=//*[@text='Instruções de confirmação']\", 0, 3000, 2, true)");
			  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
			  driver.executeScript("client:client.swipeWhileNotFound(\"Right\", 0, 2000, \"NATIVE\", \"xpath=//*[@text='Ativar']\", 0, 6000, 7, true)");
			  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
			  driver.executeScript("client:client.deviceAction(\"Home\")");
			  driver.context("NATIVE_APP");
			  client.applicationClearData("com.consul.android.smartbeer.staging");
			  client.launch("com.consul.smartbeer-staging\"", false, false);
			  try{Thread.sleep(esperandogifinicial);} catch(Exception ignore){}
			  driver.findElement(By.xpath("(//*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAView']]]]/*[@class='UIAButton'])[4]")).click();
			  driver.findElement(By.xpath("//*[@placeholder='Email']")).sendKeys(strEmail + "@mailinator.com");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='Senha']")));
			  driver.findElement(By.xpath("//*[@placeholder='Senha']")).sendKeys("Smart2000");
			  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='UIAKeyboard']")));
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.findElement(By.xpath("//*[@text='Entrar']")).click();  
		  }

			  
			  
		  }
				
	@AfterMethod
	public void tearDown(ITestResult tr){
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