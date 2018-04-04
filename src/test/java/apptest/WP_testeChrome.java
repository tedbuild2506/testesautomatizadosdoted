package apptest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.experitest.appium.SeeTestClient;

import java.net.URL;


public class WP_testeChrome implements GlobalConstants  {

    private static final String ACCESS_KEY = "eyJ4cC51Ijo3MDU2MywieHAucCI6NzA1NjEsInhwLm0iOiJNVFV4T1RNd05UUXdPRFl3T1EiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4MzU4MzU4ODUsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.dpSOsOLRZsCMyXUWx-L1JRNndb8ah1ivk-e_eH_71oA";
    private WebDriver driver;
    private URL url;
    private DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws Exception {

        url = new URL("https://cloud.seetest.io/wd/hub");
        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        dc.setCapability(CapabilityType.VERSION, "Any");
        dc.setCapability(CapabilityType.PLATFORM, Platform.ANY);
        dc.setCapability("accessKey", ACCESS_KEY);
        dc.setCapability("testName", "Quick Start Chrome Browser Demo");
        driver = new RemoteWebDriver(url, dc);
    }


    @Test
    public void testExperitest() {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://pecas.hybris-qa.whirlpool.com/pecas/pt/login");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='text-search']")));
        WebElement usuario = driver.findElement(By.xpath("//*[@id='j_username']"));
        usuario.click();
        usuario.sendKeys("Geladeira");
        jse.executeScript("scroll(0, 250);");
		try{Thread.sleep(esperarminigifs);} catch(Exception ignore){}
		WebElement senha = driver.findElement(By.xpath("//*[@id='j_password']"));
		senha.click();
		senha.sendKeys("");
        jse.executeScript("scroll(0, 250);");
        WebElement geladeira = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[4]/div[1]/button"));
		geladeira.click();
	    jse.executeScript("scroll(0, 250);");
	    driver.findElement(By.xpath("//label[contains(@class,'110v')]")).click();
		jse.executeScript("scroll(250, 500);");
		WebElement comprar = driver.findElement(By.xpath("//*[@id=\"BuyButton\"]/a"));
		comprar.click();
		
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}