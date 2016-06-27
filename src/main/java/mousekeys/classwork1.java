package mousekeys;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/*Login into Jquertui.com
 * Click the dropple link.
 * Select the dragme to target and drop into dropped box.
 * First switch to the frame, find the element and use dragAndDrop method and if again frame is present, switch to it and drop it
 * Perform above action using Action object.
 * Finallty build().perfom(). 
 * 
 * 
 * 
 * 
 * */



public class classwork1

{
	
	@Test
	public void droppable()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.findElement(By.linkText("Droppable")).click();;
		
		
		Actions builder = new Actions(driver);
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		builder.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable"))).build().perform();
		
//		builder.dragAndDropBy(driver.findElement(By.id("draggable")),100,100).build().perform();
		
	}
	
}
