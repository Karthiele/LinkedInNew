package mousekeys;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.sun.jna.Platform;

/*Login into Jquertui.com
 * Click the Resizable link.
 * Right click using contextclick
 * select the back option using keys.down
 * send keys.enter
 * it should navigate to the home page.
 * 
 * */



public class classwork2

{
	
	@Test
	public void droppable() throws InterruptedException, MalformedURLException
	{
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//		ChromeDriver driver = new ChromeDriver();
//		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");// "C:\\Users\\karsunda\\AppData\\Local\\Mozilla
//		FirefoxDriver driver= new FirefoxDriver();
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setBrowserName("firefox");
		dc.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.0.0.60:4444/wd/hub"), dc);
		
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/");
		driver.findElement(By.linkText("Resizable")).click();;
		Thread.sleep(5000);
		
		Actions builder = new Actions(driver);
		
		builder.contextClick(driver.findElement(By.className("demo-frame")))
		.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER)
		.build().perform();
		
		
		//builder.contextClick(driver.findElement(By.c))
		
		
			
	//	builder.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable"))).build().perform();
		
//		builder.dragAndDropBy(driver.findElement(By.id("draggable")),100,100).build().perform();
		
	}
	
}
