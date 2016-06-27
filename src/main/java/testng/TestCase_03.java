//package wrapper;

package testng;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wrapper.LinkedInWrappers;
import wrapper.LinkedInWrappersKarthi;
import wrapper.WrapperMethods;

public class TestCase_03 extends LinkedInWrappersKarthi

{
	@Test(dependsOnMethods ={ "testng.TestCase_01.linkIn","testng.TestCase_02.linkIn"})
	public void TestCase() throws InterruptedException {

		String browser = "Firefox";
		int count;
		boolean skillExist = false;

		/*// Launch Chrome
		invokeApp(browser, "https://www.linkedin.com/");

		// Login Linkedin
		loginLinkedInKarthi("karthielex@gmail.com", "sjb@1986");
		Thread.sleep(5000);*/

		// Click the Profile Link
		clickByLinkText("Profile");

		// Verify the Current Company
		verifyTextByXPath("//*[@id='overview-summary-current']/td/span/ol/li/span", "Patni Computer Systems");

		// Get the all skills
		List<WebElement> allSkillS = findAllElementsByClassName("endorse-item-name-text");

		// Get the count of the skills
		count = allSkillS.size();

		/*
		 * skillExist flag will set based the skill availability. If Selenium is
		 * available in the Skill list , isSkillExist() will return true
		 */
		skillExist = isSkillExist(allSkillS);

		// If skillExist is not true, add the skill
		if (!skillExist) {
			addSkillExist(count, browser);
		}

		// Sleep to slowdown
		Thread.sleep(5000);

		// Reset skillExist to false
		skillExist = false;

		// Get the all skills again
		allSkillS = findAllElementsByClassName("endorse-item-name-text");

		/*
		 * skillExist flag will set based the skill availability. If Selenium is
		 * available in the Skill list , isSkillExist() will return true
		 */
		skillExist = isSkillExist(allSkillS);

		// if SkillExist is true, added skill skill is available under Skills
		// section
		if (skillExist) {
			System.out.println("Added Skill is available.");
		} else {
			System.out.println("Added Skill is not available.");
		}

		// Close the current window.
		closeCurrentWindow();
	}

	/*
	 * addSkillExist - To add the Skill int count - Issue in firefox. Based on
	 * the count, loop will be iterated and send the \t to avoid the Elemement
	 * not clickable issue. String browser - if the browser is firefoxm, then
	 * only we required the workaround.
	 */

	public void addSkillExist(int count, String browser) throws InterruptedException {
		String tab = "\t";
		clickByXPath("//*[@id='background-skills']/button");
		enterById("edit-skills-add-ta", "Estimation");
		clickById("edit-skills-add-btn");
		Thread.sleep(5000);
		clickById("edit-skills-add-ta");

		if (browser.equalsIgnoreCase("Firefox"))

			{
				for (int i = 0; i <= count + 1; i++) {
				tab = tab + "\t";
			}
			Thread.sleep(5000);
			enterById("edit-skills-add-ta", tab);
		}

		clickByXPath("//*[@id='skills-editor-form']/p/input");
		Thread.sleep(5000);
	}

	// To verify whether Skill is Exist or not.
	public boolean isSkillExist(List<WebElement> allSkillS) {
		boolean skillflag = false;
		for (WebElement skill : allSkillS) {
			System.out.println("Get skill: " + skill.getText());
			if (skill.getText().equalsIgnoreCase("Estimation")) {
				skillflag = true;
				break;
			}
		}
		return skillflag;
	}
}
