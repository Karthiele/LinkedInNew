//package wrapper;

package groups;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wrapper.LinkedInWrappers;
import wrapper.LinkedInWrappersKarthi;

public class TestCase_04 extends LinkedInWrappersKarthi {

	//@Test(groups = "Profile", dependsOnGroups = { "Advanced Search" }, dataProvider = "Jobs")
	@Test(groups = "Profile", dataProvider = "Jobs")
	public void addConnect(String Jobs) throws InterruptedException {

		String viewcolor;

		// Click the Jobs link
		clickByLinkText("Jobs");

		// Search for Selenium
		enterById("job-search-box", Jobs + "\t");

		// Click the Search button
		clickByClassName("search-button");

		// Get the color of the view button
		viewcolor = getCSSvaluebyCSS("#results > li.mod.result.idx0.job > div > div.srp-actions.blue-button > a",
				"background-color");

		// Print the color
		System.out.println("Color of the View button is :" + viewcolor);

		// Check of the color is blue
		if (viewcolor.contains("rgba(0, 140, 201, 1")) // #008cc9 = rgba(0, 140,
														// 201, 1)
		{
			System.out.println("Background of the First View button is blue: " + viewcolor);
		} else {
			System.out.println("Background of the First View button is not blue: " + viewcolor);
		}

		// Click the 2nd View button.
		Thread.sleep(5000);
		clickViewButton();

		// Print the Company Name
		Thread.sleep(5000);
		System.out.println("Name of the Company is : " + getTextByClassName("company"));

		// Click the Company
		clickByLinkText(getTextByClassName("company"));

		// Print the Company size
		System.out.println("Number of employees count : " + getTextByClassName("company-size"));

	}

	// Click the nth View button
	/*public void clickViewButton(int reqLink)

	{
		List<WebElement> links = findAllElementsByLink("View");

		links.get(reqLink - 1).click();

	}*/
}
