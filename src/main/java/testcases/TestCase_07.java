//package wrapper;

package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wrapper.LinkedInWrappers;
import wrapper.LinkedInWrappersKarthi;

public class TestCase_07 extends LinkedInWrappersKarthi {

	@Test
	public void linkIn() throws InterruptedException {

		String color;
		int countConnect = 0;

		// Launch Chrome
		invokeApp("Chrome", "https://www.linkedin.com/");

		// Login Linkedin
		loginLinkedInKarthi("karthielex@gmail.com", "sjb@1986");
		Thread.sleep(5000);

		// Click the Add connection link
		clickById("dropdowntest");
		Thread.sleep(5000);

		// Get all the button
		List<WebElement> buttons = findAllElementsByTagname("button");

		for (WebElement button : buttons) {
			if (button.getText().contains("Connect"))
				countConnect = countConnect + 1;
		}

		// Print the Total Connect button
		System.out.println("Total Connect button : " + countConnect);

		// Clickconnect method to verify the color of the button and click the
		// required connection
		clickConnect(buttons, 2);

	}

	public void clickConnect(List<WebElement> buttons, int linkToClick) throws InterruptedException {

		int connectCount = 0;
		String name = null;
		String invitation = null;
		String color;

		for (WebElement button : buttons) {

			if (button.getText().contains("Connect with "))

			{
				connectCount = connectCount + 1;

				if (connectCount == linkToClick)

				{
					name = button.getAttribute("title").replace("Connect with ", "");
					color = button.getCssValue("background").toString();
					verifyColor(color);
					button.click();
					Thread.sleep(5000);
					invitation = getTextByCSS("#global-alert-queue > div");
					break;
				}
			}

		}

		System.out.println("Name:" + name);

		System.out.println("Invite : " + invitation);

		verifyInvite(invitation, name);

		Thread.sleep(5000);

		verifyTextByCSS("#global-alert-queue > div", "Invitation sent to " + name);

	}

	public void verifyInvite(String invitation, String name) {
		if (invitation.contains("Invitation sent to " + name)) {
			System.out.println("Invitation Sent Sucessfully");
			getScreenShot();
		} else

		{
			System.out.println("Invitation not Sent");
			getScreenShot();
		}

	}

	public void verifyColor(String color)

	{
		if (color.contains("rgb(0, 119, 181)")) {
			System.out.println("Connection button color is Blue");

		} else {
			System.out.println("Connection button color is not Blue");
		}

	}
}
