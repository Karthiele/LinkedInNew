
//package wrapper;

package testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

import wrapper.LinkedInWrappers;
import wrapper.LinkedInWrappersKarthi;

public class TestCase_02 extends LinkedInWrappersKarthi {
	
	

	@Test(invocationTimeOut = 1000)//,expectedExceptions = ThreadTimeoutException.class)
	public void linkIn() throws InterruptedException {

		String countRtsection;
		String countLtsection = "";

		// Click the Advanced Link
		clickByLinkText("Advanced");
		Thread.sleep(5000);

		// Close the Frame
		clickByXPath("//*[@id='advs']/div[1]/button");
		Thread.sleep(5000);

		// Get the Total Result Count
		countRtsection = getTextByXPath("//*[@id='results_count']/div/p/strong");
		Thread.sleep(5000);

		// Print The Result count before the Split
		System.out.println("Total Count before Split :" + countRtsection);

		// Split method used to remove the , from the result.
		countRtsection = Split(countRtsection, ',');

		// Print The Result count after the Split
		System.out.println("Total Count after Split :" + countRtsection);
		Thread.sleep(5000);

		// Close the 2nd Connection
		clickByXPath("//*[@id='pivot-bar']/ul/li[2]/button");
		Thread.sleep(5000);

		// Get the Result Count after closing the 2nd connection
		countRtsection = getTextByXPath("//*[@id='results_count']/div/p/strong");

		// Print The Result count before the Split
		System.out.println("2nd Connection closed. Total Count before Split :" + countRtsection);

		// Split method used to remove the , from the result.
		countRtsection = Split(countRtsection, ',');

		// Print The Result count after the Split
		System.out.println("2nd Connection closed. Total Count after Split :" + countRtsection);
		Thread.sleep(5000);

		// Close the Group Members
		clickByXPath("//*[@id='pivot-bar']/ul/li[2]/button");
		Thread.sleep(5000);

		// Get the Result Count after closing the Group Members/
		countRtsection = getTextByXPath("//*[@id='results_count']/div/p/strong");

		// Print The Result count before the Split
		System.out.println("Group Members closed. Total Count before Split :" + countRtsection);

		// Split method used to remove the , from the result.
		countRtsection = Split(countRtsection, ',');

		// Print The Result count after the Split
		System.out.println("Group Members closed. Total Count after Split :" + countRtsection);
		Thread.sleep(5000);

		// Get the 1st Connection count from the left side pan
		countLtsection = getTextByXPath("//*[@id='facet-N']/fieldset/div/ol/li[2]/div/span");
		Thread.sleep(5000);

		System.out.println("1st Connection count from the left side section:" + countLtsection);

		// Remove() from the count
		countLtsection = Split(countLtsection, '(');
		countLtsection = Split(countLtsection, ')');
		
		// 1st Connection  the count
		System.out.println("1st Connection count from the left side section After Split :" + countLtsection);

		// Compare the Results
		if (countRtsection.equalsIgnoreCase(countLtsection))

		{
			System.out.println("1st Connection count is matching with the result count");
		} else {
			System.out.println("1st Connection count is not matching with the result count");
		}
		closeCurrentWindow();
	}


}