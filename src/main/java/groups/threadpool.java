package groups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rnd.datakarthi;
import wrapper.LinkedInWrappersKarthi;
import wrapper.WrapperMethods;

public class threadpool {

	
	
	@Test(dataProvider = "Searchitem1", dataProviderClass = datakarthi.class)
	public void pooll(String search)

	{

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\karsunda\\workspace\\java\\Primenumbers\\driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.linkedin.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("login-email")).sendKeys("karthielex@gmail.com");
		driver.findElement(By.id("login-password")).sendKeys("sjb@1986");
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.id("main-search-box")).sendKeys(search);
		driver.findElement(By.name("search")).click();
		
//		invokeApp("Chrome", "https://www.linkedin.com/");
//		
//		enterById("login-email", "karthielex@gmail.com");
//		enterById("login-password", "sjb@1986");
//		clickByName("submit");
		/*invokeApp("Chrome", "https://www.linkedin.com/");
		loginLinkedInKarthi("karthielex@gmail.com", "sjb@1986");*/

	}

}
