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
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class WP_CadastroInvalidoIOS extends BaseTest implements GlobalConstants {
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
	
	@Test
	public void testecadastroinvalidoIOS(){

		 Boolean Allow = driver.findElements(By.xpath("//*[@value='Allow']")).size()>0;
		  if (Allow) {
			  driver.findElement(By.xpath("//*[@value='Allow']")).click();
			  //client.launch("com.apple.mobilesafari\"", false, false);
			  try{Thread.sleep(esperarminigifs);} catch(Exception ignore){}
			  driver.findElement(By.xpath("//*[@text='Cadastre-se com seu e-mail pessoal']")).click();
			  driver.findElement(By.xpath("//*[@placeholder='Email']")).sendKeys("ashutosh@ashutosh.com.br");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.swipe(165, 759, 175, 534, 1234);
			  driver.findElement(By.xpath("//*[@placeholder='Senha']")).sendKeys("lucasmoreira");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.findElement(By.xpath("//*[@placeholder='Confirmer Senha']")).sendKeys("lucazmoreira");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.swipe(309, 856, 390, 406, 888);
			  driver.findElement(By.xpath("//*[@placeholder='Nome e Sobrenome']")).sendKeys("teste");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.findElement(By.xpath("//*[@placeholder='CPF']")).sendKeys("12345678901");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.swipe(168, 946, 334, 615, 2240);
			  driver.findElement(By.xpath("//*[@text='Data de Nascimento (dd/mm/aaaa)']")).click();
			  driver.swipe(150, 1110, 145, 1043, 408);
			  driver.findElement(By.xpath("//*[@text='Feito']")).click();
			  driver.swipe(84, 887, 259, 493, 1461);
			  driver.findElement(By.xpath("//*[@placeholder='Telefone']")).sendKeys("99999999999");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.findElement(By.xpath("//*[@placeholder='Gênero']")).click();
			  driver.findElement(By.xpath("//*[@text='Masculino']")).click();
			  driver.findElement(By.xpath("//*[@id='Feito']")).click();
			  driver.swipe(450, 812, 500, 640, 1292);
			  driver.findElement(By.xpath("//*[@id='Cadastrar']")).click();
			  }
		  else  {
			  driver.findElement(By.xpath("//*[@text='Cadastre-se com seu e-mail pessoal']")).click();
			  driver.findElement(By.xpath("//*[@placeholder='Email']")).sendKeys("ashutosh@ashutosh.com.br");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.swipe(165, 759, 175, 534, 1234);
			  driver.findElement(By.xpath("//*[@placeholder='Senha']")).sendKeys("lucasmoreira");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.findElement(By.xpath("//*[@placeholder='Confirmer Senha']")).sendKeys("lucazmoreira");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.swipe(309, 856, 390, 406, 888);
			  driver.findElement(By.xpath("//*[@placeholder='Nome e Sobrenome']")).sendKeys("teste");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.findElement(By.xpath("//*[@placeholder='CPF']")).sendKeys("12345678901");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.swipe(168, 946, 334, 615, 2240);
			  driver.findElement(By.xpath("//*[@placeholder='Data de nascimento (dd/mm/aaaa)']")).click();
			  driver.swipe(150, 1110, 145, 1043, 408);
			  driver.findElement(By.xpath("//*[@text='Feito']")).click();
			  driver.swipe(84, 887, 259, 493, 1461);
			  driver.findElement(By.xpath("//*[@placeholder='Telefone']")).sendKeys("99999999999");
			  driver.findElement(By.xpath("//*[@id='Toolbar Done Button']")).click();
			  driver.findElement(By.xpath("//*[@placeholder='Gênero']")).click();
			  driver.findElement(By.xpath("//*[@text='Masculino']")).click();
			  driver.findElement(By.xpath("//*[@id='Feito']")).click();
			  driver.swipe(450, 812, 500, 640, 1292);
			  driver.findElement(By.xpath("//*[@id='Cadastrar']")).click();}
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