package wrapper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class LinkedInWrappersKarthi extends WrapperMethods {

	String browser;
	String email;
	String password;

	// TestCase01
	@DataProvider(name = "Searchitem")//,parallel=true)
	public Object[][] searchitem()

	{
		return new Object[][] { { "RFT" }, { "Selenium" }, { "Manual Testing" } };
	}

	// TestCase03
	@DataProvider(name = "Skils")
	public Object[][] skils()

	{
		return new Object[][] { { "RFT" }, { "Agile" }, { "Manual Testing" } };
	}

	// TestCase04
	@DataProvider(name = "Jobs")
	public Object[][] skils2()

	{
		return new Object[][] { { "Selenium" }, { "QTP" }, { "Manual Testing" } };

		// Object[][] data = new Object[][] {};

		// return data;
	}

	public boolean loginLinkedInKarthi(String userName, String passWord) {

		try {

			enterById("login-email", userName);
			enterById("login-password", passWord);
			clickByName("submit");
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Unable to login");
			e.printStackTrace();
			return false;
		}
	}

	public String Split(String data, char spliter) {
		String afterSplit = "";
		for (char c : data.toCharArray()) {
			if (c != spliter) {
				afterSplit = afterSplit + c;
			}

		}
		return afterSplit;
	}

	@BeforeSuite(groups = { "Advanced Search", "Profile" })
	public void beforeSuite() {
		System.out.println("Before Suite is executed");
	}

	@AfterSuite(groups = { "Advanced Search", "Profile" })
	public void afterSuite() {
		System.out.println("After Suite is executed");
	}

	@BeforeTest(groups = { "Advanced Search", "Profile" })
	public void beforeTest() {
		System.out.println("Before Test is executed");
	}

	@AfterTest(groups = { "Advanced Search", "Profile" })
	public void afterTest() {
		System.out.println("After Test is executed");
	}

	@AfterClass(groups = { "Advanced Search", "Profile" })
	public void afterClass() {
		System.out.println("After Class is executed");
	}

	@BeforeClass(groups = { "Advanced Search", "Profile" })
	public void beforeClass() {
		browser = "Firefox";
		email = "Karthielex@gmail.com";
		password = "sjb@1986";

	}

	@BeforeMethod(groups = { "Advanced Search", "Profile" })
	@Parameters("browser2")

	public void beforeMethod(String browserName) throws InterruptedException {

		email = "Karthielex@gmail.com";
		password = "sjb@1986";

		// Launch Chrome
		invokeApp(browserName, "https://www.linkedin.com/");

		// Login Linkedin
		loginLinkedInKarthi(email, password);
		Thread.sleep(5000);
		
	}

}
