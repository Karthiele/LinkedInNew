//package wrapper;

package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wrapper.LinkedInWrappers;
import wrapper.LinkedInWrappersKarthi;

public class TestCase_05 extends LinkedInWrappersKarthi {

	@Test
	public void linkIn() throws InterruptedException {

		String getComapanyname;
		String browser="Firefox";

		// Launch Chrome
		invokeApp(browser, "https://www.linkedin.com/");

		// Login Linkedin
		loginLinkedInKarthi("karthielex@gmail.com", "sjb@1986");
		Thread.sleep(5000);

		// Click the Advaned Link
		clickByLinkText("Advanced");
		Thread.sleep(3000);

		// Enter the Company Name
		enterById("advs-company", "Capgemini");

		// Get the Entered Company name
		getComapanyname = getAttributeValueByID("advs-company", "value");

		// Print the Company Name
		System.out.println("Company Name is :" + getComapanyname);

		// Check the 1st Connections check box
		clickById("adv-F-N-ffs");// ("//*[@id='adv-F-N-ffs']");

		// Click the Location link
		clickByXPath("//*[@id='adv-facet-G']/fieldset/legend");

		// Click the Add button
		clickByClassName("add-facet-button");
		Thread.sleep(3000);

		// Enter I to the text box
		enterByName("f_G", "I");
		Thread.sleep(3000);

		// New Wrapper Method to Press Enter Key
		sendEndterKeyByName("f_G");

		Thread.sleep(5000);
		
		// Click the Reset button
		clickByXPath("//*[@id='peopleSearchForm']/div[1]/input[2]");

		// Get the Company name
		getComapanyname = getAttributeValueByID("advs-company", "value");

		// Check Company name is emapty.
		if (getComapanyname.isEmpty()) {
			System.out.println("Company Name is cleared");
		}

		// Check whether checkbos is checked alreday
		if (!isSelectedByXpath("//*[@id='adv-in:0-G-ffs']")) {
			System.out.println("Country is cleared");
		}

		Thread.sleep(5000);

		// Click the 1st Connections checkbox
		clickById("adv-F-N-ffs");

		// Click the Search button.
		clickByName("submit");
		Thread.sleep(5000);

		
		if(browser.equalsIgnoreCase("Firefox"))
		{
			scroller("scroll(30,)");
		}
			
		clickByName("submit");
		closeCurrentWindow();
	}
	
	
	

}
