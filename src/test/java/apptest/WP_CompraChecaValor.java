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


public class WP_CompraChecaValor extends BaseTest implements GlobalConstants {
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
		dc.setCapability("testName", "wp_TED_ValorMinimo");
		dc.setCapability("deviceQuery",A8Plus);
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
		
	}
	
	@Test 
	public void test_SemDistribuidor() {
		driver.installApp("cloud:com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity");
		client.launch("com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity", false, true);
		try{Thread.sleep(esperandogifinicial);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@text='Acesse sua conta']")).click();
		driver.findElement(By.xpath("//*[@id='edEmail']")).sendKeys("tedmarketplaces@gmail.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='edPassword']")));
		driver.findElement(By.xpath("//*[@id='edPassword']")).sendKeys("Smart2000");
		driver.findElement(By.xpath("//*[@text='Entrar']")).click();
		try{Thread.sleep(esperandogifinicial+0500);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@id='imgCart']")).click();
		driver.findElement(By.xpath("//*[@text='Entrar na loja']")).click();
		try{Thread.sleep(esperandogifintermediario);} catch(Exception ignore){}
		Boolean Permitir = driver.findElements(By.xpath("//*[@text='ALLOW']")).size()>0;
		if (Permitir) {
		driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
		try{Thread.sleep(esperandogifinicial+0500);} catch(Exception ignore){}
	    /*driver.findElement(By.xpath("//*[@text='Cadastrar novo endereço']")).click();
		try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@id='cepView']")).sendKeys("05606-200");
		try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@id='streetText']")).sendKeys("Avenida Morumbi");
		try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@id='numberText']")).sendKeys("200");
		driver.findElement(By.xpath("//*[@id='neighborhoodText']")).sendKeys("Jardim Morumbi");
		driver.swipe(768, 431, 768, 359, 128);
		driver.findElement(By.xpath("//*[@id='stateView']")).click();
		driver.swipe(90, 1671, 100, 1418, 378);
		driver.swipe(93, 1475, 93, 1203, 255);
		driver.swipe(90, 1671, 100, 1418, 378);
		driver.swipe(90, 1671, 100, 1418, 378);
		driver.swipe(90, 1671, 100, 1418, 378);
		driver.swipe(90, 1671, 100, 1418, 378);
		driver.swipe(90, 1671, 100, 1418, 378);
		driver.swipe(90, 1671, 100, 1418, 378);
		driver.swipe(90, 1671, 100, 1418, 378);
		driver.swipe(90, 1671, 100, 1418, 378);
		driver.findElement(By.xpath("//*[@text='SP']")).click();
		try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@text='Adamantina']")).click();
		driver.swipe(628, 1493, 628, 975, 243);
		driver.swipe(578, 1793, 665, 1100, 231);
		driver.swipe(628, 1700, 665, 1137, 314);
		driver.swipe(553, 1762, 515, 1187, 287);
		driver.swipe(556, 1812, 537, 1153, 352);
		driver.swipe(546, 1796, 550, 878, 305);
		driver.swipe(546, 1784, 500, 1075, 271);
		driver.swipe(553, 1796, 606, 818, 242);
		driver.swipe(606, 1784, 628, 1003, 256);
		driver.swipe(650, 1778, 531, 1037, 263);
		driver.swipe(571, 1800, 568, 1021, 256);
		driver.swipe(565, 1793, 581, 1209, 243);
		driver.swipe(525, 1781, 665, 1034, 214);
		driver.swipe(590, 1456, 615, 1084, 217);
		driver.swipe(518, 1759, 528, 1196, 217);
		driver.swipe(581, 1571, 581, 1240, 155);
		driver.swipe(512, 1890, 496, 1171, 215);
		driver.swipe(559, 1834, 587, 1206, 271);
		driver.swipe(553, 1818, 596, 806, 194);
		driver.swipe(509, 1865, 634, 578, 211);
		driver.swipe(503, 1740, 643, 1006, 350);
		driver.swipe(562, 1840, 531, 1096, 289);
		driver.swipe(512, 1859, 650, 1246, 353);
		driver.swipe(575, 1690, 675, 1143, 184);
		driver.swipe(603, 1765, 621, 1075, 313);
		driver.swipe(603, 1537, 531, 968, 176);
		driver.swipe(603, 1846, 728, 1018, 205);
		driver.swipe(643, 1806, 640, 912, 203);
		driver.swipe(550, 1765, 625, 1100, 231);
		driver.swipe(584, 1853, 653, 1337, 342);
		driver.swipe(593, 1746, 656, 1209, 264);
		driver.swipe(587, 1781, 537, 1400, 285);
		driver.swipe(603, 1862, 643, 1506, 288);
		driver.swipe(625, 1831, 653, 1315, 217);
		driver.swipe(603, 1778, 684, 1409, 340);
		driver.swipe(628, 1493, 628, 975, 243);
		driver.swipe(578, 1793, 665, 1100, 231);
		driver.swipe(628, 1700, 665, 1137, 314);
		driver.swipe(553, 1762, 515, 1187, 287);
		driver.swipe(556, 1812, 537, 1153, 352);
		driver.swipe(546, 1796, 550, 878, 305);
		driver.swipe(546, 1784, 500, 1075, 271);
		driver.swipe(553, 1796, 606, 818, 242);
		driver.swipe(606, 1784, 628, 1003, 256);
		driver.swipe(650, 1778, 531, 1037, 263);
		driver.swipe(571, 1800, 568, 1021, 256);
		driver.swipe(565, 1793, 581, 1209, 243);
		driver.swipe(525, 1781, 665, 1034, 214);
		driver.swipe(590, 1456, 615, 1084, 217);
		driver.swipe(518, 1759, 528, 1196, 217);
		driver.swipe(581, 1571, 581, 1240, 155);
		driver.swipe(512, 1890, 496, 1171, 215);
		driver.swipe(559, 1834, 587, 1206, 271);
		driver.swipe(553, 1818, 596, 806, 194);
		driver.swipe(509, 1865, 634, 578, 211);
		driver.swipe(503, 1740, 643, 1006, 350);
		driver.swipe(562, 1840, 531, 1096, 289);
		driver.swipe(512, 1859, 650, 1246, 353);
		driver.swipe(575, 1690, 675, 1143, 184);
		driver.swipe(603, 1765, 621, 1075, 313);
		driver.swipe(603, 1537, 531, 968, 176);
		driver.swipe(603, 1846, 728, 1018, 205);
		driver.swipe(643, 1806, 640, 912, 203);
		driver.swipe(550, 1765, 625, 1100, 231);
		driver.swipe(584, 1853, 653, 1337, 342);
		driver.swipe(593, 1746, 656, 1209, 264);
		driver.swipe(587, 1781, 537, 1400, 285);
		driver.swipe(603, 1862, 643, 1506, 288);
		driver.swipe(625, 1831, 653, 1315, 217);
		driver.swipe(603, 1778, 684, 1409, 340);
		driver.swipe(628, 1493, 628, 975, 243);
		driver.swipe(578, 1793, 665, 1100, 231);
		driver.swipe(628, 1700, 665, 1137, 314);
		driver.swipe(553, 1762, 515, 1187, 287);
		driver.swipe(556, 1812, 537, 1153, 352);
		driver.swipe(546, 1796, 550, 878, 305);
		driver.swipe(546, 1784, 500, 1075, 271);
		driver.swipe(553, 1796, 606, 818, 242);
		driver.swipe(606, 1784, 628, 1003, 256);
		driver.swipe(650, 1778, 531, 1037, 263);
		driver.swipe(571, 1800, 568, 1021, 256);
		driver.swipe(565, 1793, 581, 1209, 243);
		driver.swipe(525, 1781, 665, 1034, 214);
		driver.swipe(590, 1456, 615, 1084, 217);
		driver.swipe(518, 1759, 528, 1196, 217);
		driver.swipe(581, 1571, 581, 1240, 155);
		driver.swipe(512, 1890, 496, 1171, 215);
		driver.swipe(559, 1834, 587, 1206, 271);
		driver.swipe(553, 1818, 596, 806, 194);
		driver.swipe(509, 1865, 634, 578, 211);
		driver.swipe(503, 1740, 643, 1006, 350);
		driver.swipe(562, 1840, 531, 1096, 289);
		driver.swipe(512, 1859, 650, 1246, 353);
		driver.swipe(575, 1690, 675, 1143, 184);
		driver.swipe(603, 1765, 621, 1075, 313);
		driver.swipe(603, 1537, 531, 968, 176);
		driver.swipe(603, 1846, 728, 1018, 205);
		driver.swipe(643, 1806, 640, 912, 203);
		driver.swipe(550, 1765, 625, 1100, 231);
		driver.swipe(584, 1853, 653, 1337, 342);
		driver.swipe(593, 1746, 656, 1209, 264);
		driver.swipe(587, 1781, 537, 1400, 285);
		driver.swipe(603, 1862, 643, 1506, 288);
		driver.swipe(625, 1831, 653, 1315, 217);
		driver.swipe(603, 1778, 684, 1409, 340);
		driver.swipe(512, 1859, 650, 1246, 353);
		driver.swipe(575, 1690, 675, 1143, 184);
		driver.swipe(603, 1765, 621, 1075, 313);
		driver.swipe(603, 1537, 531, 968, 176);
		driver.swipe(603, 1846, 728, 1018, 205);
		driver.swipe(643, 1806, 640, 912, 203);
		driver.swipe(550, 1765, 625, 1100, 231);
		driver.swipe(584, 1853, 653, 1337, 342);
		driver.swipe(593, 1746, 656, 1209, 264);
		driver.swipe(587, 1781, 537, 1400, 285);
		driver.swipe(603, 1862, 643, 1506, 288);
		driver.swipe(625, 1831, 653, 1315, 217);
		driver.swipe(603, 1778, 684, 1409, 340);
		driver.swipe(512, 1859, 650, 1246, 353);
		driver.swipe(575, 1690, 675, 1143, 184);
		driver.swipe(603, 1765, 621, 1075, 313);
		driver.swipe(603, 1537, 531, 968, 176);
		try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@text='São Paulo']")).click();
		driver.findElement(By.xpath("//*[@text='Salvar meu endereço para futuras compras']")).click();
		driver.findElement(By.xpath("//*[@text='Salvar']")).click();*/
		try{Thread.sleep(esperandogifintermediario);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@text='UTILIZAR' and ./parent::*[./parent::*[./preceding-sibling::*[@text='Endereço padrão']]]]")).click();
		driver.findElement(By.xpath("//*[@text='Entrar na loja']")).click();
		try{Thread.sleep(esperandogifintermediario);} catch(Exception ignore){}
		driver.findElement(By.xpath("//*[@text='UTILIZAR' and ./parent::*[./parent::*[./preceding-sibling::*[@text='Endereço padrão']]]]")).click();
		try{Thread.sleep(esperandogifintermediario+0500);} catch(Exception ignore){}
	    driver.findElement(By.xpath("//*[@id='addQuantityView' and @height>0 and ./parent::*[./parent::*[./preceding-sibling::*[@text='Skol 300ml | Apenas o Líquido.']]]]")).click();
	    driver.findElement(By.xpath("//*[@id='addQuantityView' and @height>0 and ./parent::*[./parent::*[./preceding-sibling::*[@text='Skol 300ml | Apenas o Líquido.']]]]")).click();
	    driver.findElement(By.xpath("//*[@id='addQuantityView' and @height>0 and ./parent::*[./parent::*[./preceding-sibling::*[@text='Skol 300ml | Apenas o Líquido.']]]]")).click();
	    driver.findElement(By.xpath("//*[@id='addQuantityView' and @height>0 and ./parent::*[./parent::*[./preceding-sibling::*[@text='Skol 300ml | Apenas o Líquido.']]]]")).click();
	    driver.findElement(By.xpath("//*[@id='addQuantityView' and @height>0 and ./parent::*[./parent::*[./preceding-sibling::*[@text='Skol 300ml | Apenas o Líquido.']]]]")).click();
	    driver.findElement(By.xpath("//*[@id='addQuantityView' and @height>0 and ./parent::*[./parent::*[./preceding-sibling::*[@text='Skol 300ml | Apenas o Líquido.']]]]")).click();
	    driver.findElement(By.xpath("//*[@id='addQuantityView' and @height>0 and ./parent::*[./parent::*[./preceding-sibling::*[@text='Skol 300ml | Apenas o Líquido.']]]]")).click();
	    driver.findElement(By.xpath("//*[@id='addQuantityView' and @height>0 and ./parent::*[./parent::*[./preceding-sibling::*[@text='Skol 300ml | Apenas o Líquido.']]]]")).click();
	    driver.findElement(By.xpath("//*[@id='addQuantityView' and @height>0 and ./parent::*[./parent::*[./preceding-sibling::*[@text='Skol 300ml | Apenas o Líquido.']]]]")).click();
	    driver.findElement(By.xpath("//*[@id='addQuantityView' and @height>0 and ./parent::*[./parent::*[./preceding-sibling::*[@text='Skol 300ml | Apenas o Líquido.']]]]")).click();
		driver.findElement(By.xpath("//*[@text='Pagar R$ 202,80']")).click();
		try{Thread.sleep(esperandogifintermediario-1500);} catch(Exception ignore){}
		driver.swipe(675, 1243, 665, 743, 253);
		driver.swipe(628, 1550, 578, 940, 233);
		driver.swipe(606, 1578, 653, 1040, 257);
		driver.swipe(584, 1568, 565, 1096, 197);
		driver.swipe(675, 1243, 665, 743, 253);
		driver.swipe(628, 1550, 578, 940, 233);
		driver.swipe(606, 1578, 653, 1040, 257);
		driver.swipe(584, 1568, 565, 1096, 197);
		driver.findElement(By.xpath("//*[@text='Pagar R$ 202,80']")).click();
	    driver.findElement(By.xpath("//*[@text='CONFIRMAR']")).click();
	
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
