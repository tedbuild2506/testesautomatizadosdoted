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
		dc.setCapability("testName", "wp_TED_Iphone6CadastroBranco");
		dc.setCapability("deviceQuery", "@serialnumber='5f354f456c655f1cfa05be9a63139072f9e67fe2'");
		driver = new IOSDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
	}
	
	@Test
	public void testecadastroinvalidoIOS(){

		 Boolean Allow = driver.findElements(By.xpath("//*[@text='Allow']")).size()<0;
		 Boolean Cancel = driver.findElements(By.xpath("//*[@text='Cancel']")).size()<0;
//		  if (Allow.TRUE) {
//			  new WebDriverWait(driver, 30, esperandogif).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Allow']"))).click();
//			  if (Allow.FALSE)  {
				  driver.findElement(By.xpath("//*[@text='Cadastre-se com seu e-mail pessoal']")).click();
				  driver.findElement(By.xpath("//*[@placeholder='Email']")).sendKeys("ashutosh@ashutosh.com.br");
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
				  System.out.println("report URL : " + driver.getCapabilities().getCapability("reportUrl"));
				  driver.quit();
		  }
	  
}
	


