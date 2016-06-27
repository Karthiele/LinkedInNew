
package testng;

//package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import wrapper.LinkedInWrappers;
import wrapper.LinkedInWrappersKarthi;

public class TestCase_01 extends LinkedInWrappersKarthi {

	String browser;
	String email;
	String password;
	
@Test(invocationCount = 2)
	public void linkIn() throws InterruptedException {
		
	

		String splitResult;
		String getName = "";
		String connection;


		// Click the Advaned Link
		clickByLinkText("Advanced");
		Thread.sleep(5000);

		//Enter the Search Search item
		enterById("main-search-box", "Selenium");

		//Click the Search button.
		clickByClassName("search-button");
		Thread.sleep(5000);

		//Get the Reult 
		splitResult = getTextByXPath("//*[@id='results_count']/div/p/strong[1]");

		//Split the , from the count
		splitResult = Split(splitResult, ',');

		//Print the Result
		System.out.println("Result Count: " + splitResult);

		//Get the Name of the first connection
		getName = getTextByXPath("//*[@id='results']/li[1]/div/h3");
		connection = getTextByXPath("//*[@id='results']/li[1]/div/h3");
		getName = getName.substring(0, getName.length() - 3);

		//	Print the Name
		System.out.println("Name of the first person is :" + getName);

		//		Get the connection type
		connection = connection.substring(connection.length() - 3, connection.length());

		System.out.println("Connection is :" + connection);
	}
	
	
	

}
