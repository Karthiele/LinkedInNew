package wrapper;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.naming.directory.NoSuchAttributeException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionNotFoundException;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class WrapperMethods implements GenericWrappers {

	RemoteWebDriver driver;
	 String SSFolder = "D:\\Project\\LinkedIn\\screenshot\\Snapshot_TC_";
//	String SSFolder = "C:\\Users\\karsunda\\workspace\\java\\Primenumbers\\Screenshot\\Snapshot_TC_";
	 String ChromeDriverLocation = "D:\\Project\\LinkedIn\\drivers\\chromedriver.exe";
//	String ChromeDriverLocation = "C:\\Users\\karsunda\\workspace\\java\\Primenumbers\\driver\\chromedriver.exe";

	int countAllElement;
	Select dropdown;
	String getText = null;
	List<WebElement> listElements;
	int allElementCount;
	Alert alert;
	String browsername;
	
	

	public boolean invokeApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", ChromeDriverLocation);
				driver = new ChromeDriver();
				browsername = browser;

			} else if (browser.equalsIgnoreCase("Firefox")) {

				System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");// "C:\\Users\\karsunda\\AppData\\Local\\Mozilla
				// Firefox\\firefox.exe");
				driver = new FirefoxDriver();
				browsername = browser;

			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return true;
		} catch (WebDriverException e) {
			System.out.println("Browser not opened" + e);
			return false;
		}

	}

	public boolean verifyTitle(String title) {
		if (driver.getTitle().contains(title)) {
			System.out.println(" Title contains " + title);
			return true;
		} else {
			System.out.println("title doesn't contains" + title);
			return false;
		}

		// TODO Auto-generated method stub
	}

	public boolean clickById(String id) {
		try {
			driver.findElementById(id).click();
			return true;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("No Such Element Found" + id);
			e.printStackTrace();
			return false;
		} catch (ElementNotVisibleException e) {
			System.err.println("Element is not visisble" + e);
			getScreenShot();
			return false;
		}

	}

	public boolean clickByName(String name) {

		try {
			driver.findElementByName(name).click();
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Click Element with given name " + name + "is not found");
			getScreenShot();
			e.printStackTrace();
			return false;
		}

	}

	public boolean clickByTagName(String tagname) {

		try {
			driver.findElementByTagName(tagname).click();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return false;
		}

	}

	public boolean clickByXPath(String XPath) {
		try {

			driver.findElementByXPath(XPath).click();

			/*
			 * Action actions = new Action(driver);
			 * 
			 * ((Object)
			 * actions).moveToElement(driver.findElementByXPath(XPath)).click().
			 * perform();
			 */
			return true;
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("Could not fine the element with xpath: " + XPath);
			getScreenShot();
			return false;
		}

	}

	// @author : Karthikeyan
	public boolean clickByCSS(String CSS) {
		try {
			driver.findElement(By.cssSelector(CSS)).click();
			System.out.println("Element successfully clicked using CssSelector locator : " + CSS);
			getScreenShot();
			return true;
		} catch (InvalidSelectorException e) {
			System.out.println("Element falied to click using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (NoSuchElementException e) {
			System.out.println("Element falied to click using CssSelector locator : " + CSS
					+ ". Element is not found. Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (ElementNotVisibleException e) {
			System.out.println("Element falied to click using CssSelector locator : " + CSS
					+ ". Element is not visible. Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (SessionNotFoundException e) {
			System.out.println("Element falied to click using CssSelector locator : " + CSS
					+ ". Session is not found. Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		}
	}

	public boolean clickByLinkText(String linktext) {

		try {
			driver.findElement(By.linkText(linktext)).click();
			return true;
		} catch (NoSuchElementException e) {

			System.out.println("Could not find the link text :" + linktext);
			getScreenShot();
			e.printStackTrace();
			return false;
		}

	}

	public boolean clickByPartialLinkText(String partiallinktext) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.partialLinkText(partiallinktext)).click();
			return true;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not find the partial link text :" + partiallinktext);
			getScreenShot();
			return false;
		}

	}

	public boolean clickByClassName(String classname) {

		try {
			
			
			driver.findElementByClassName(classname).click();
			return true;
		}

		catch (NoSuchElementException e) {
			System.out.println("No element found ");
			getScreenShot();
			return false;
		}

		catch (WebDriverException e) {
			System.out.println(" Web driver has found an error" + e);
			getScreenShot();
			return false;
		}

	}

	public boolean enterById(String id, String data) {
		try {

			driver.findElement(By.id(id)).sendKeys(data);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("No element found " + e);
			getScreenShot();
			return false;
		}

		catch (WebDriverException e) {
			System.out.println(" Web driver has found an error" + e);
			getScreenShot();
			return false;
		} catch (NullPointerException e) {
			System.out.println(" Web driver has found an error NullPointerException" + e);
			getScreenShot();
			return false;
		}

	}

	public boolean enterByName(String name, String data) {

		try {
			driver.findElementByName(name).sendKeys(data);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("No element found " + e);
			getScreenShot();
			return false;
		}

		catch (WebDriverException e) {
			System.out.println(" Web driver has found an error" + e);
			getScreenShot();
			return false;
		}

	}

	public boolean enterByTagname(String tagname, String data) {

		try {
			driver.findElementByTagName(tagname).sendKeys(data);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("No element found " + e);
			getScreenShot();
			return false;
		}

		catch (WebDriverException e) {
			System.out.println(" Web driver has found an error" + e);
			getScreenShot();
			return false;
		}

	}

	public boolean enterByClassName(String id, String data)

	{
		try {
			if (data != null) {
				driver.findElement(By.className(id)).sendKeys(data);
			}

			else {
				System.out.println("please verify the entered text");
			}
		} catch (ElementNotVisibleException e) {
			System.out.println(" element not visible.please verify" + e);
			getScreenShot();
		} catch (NoSuchElementException e) {
			System.out.println("No element found " + e);
			getScreenShot();
		} catch (WebDriverException e) {
			System.out.println(" Web driver has found an error" + e);
			getScreenShot();
		}
		return false;
	}

	public boolean enterByXPath(String xPath, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xPath).sendKeys(data);
			return true;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not fine the element with xpath: " + xPath);
			getScreenShot();
			return false;
		}

	}

	// @author : Karthikeyan
	public boolean enterByCSS(String CSS, String data)

	{
		try {
			driver.findElement(By.cssSelector(CSS)).sendKeys(data);
			System.out.println("Value : " + data + " successfully entered using CssSelector locator : " + CSS);
			getScreenShot();
			return true;
		}

		catch (InvalidSelectorException e) {
			System.out.println("Falied to ented value : " + data + " using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (NoSuchElementException e) {
			System.out.println("Falied to ented value : " + data + " using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (ElementNotVisibleException e) {
			System.out.println("Falied to ented value : " + data + " using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (SessionNotFoundException e) {
			System.out.println("Falied to ented value : " + data + " using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		}
	}

	public Select getDropDownByXPath(String XPath) {
		try {
			WebElement dropdown = driver.findElementByXPath(XPath);
			Select DropDown = new Select(dropdown);
			return DropDown;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not find the element with xpath: " + XPath);
			return null;
		}

	}

	public String getTextById(String id) {
		String getext;
		try {
			getext = driver.findElement(By.id(id)).getText();
			return getext;
		} catch (NoSuchElementException e) {
			System.err.println("Element is not found" + e);
			getScreenShot();
			return null;
		}

		catch (ElementNotVisibleException e) {
			System.err.println("Element is not visisble" + e);
			getScreenShot();
			return null;
		}

	}

	public String getTextByClassName(String classname) {
		try {

			getText = driver.findElement(By.className(classname)).getText();
			
			return getText;

		} catch (ElementNotVisibleException e) {
			System.out.println(" element not visible.please verify");
			getScreenShot();
			return null;

		} catch (NoSuchElementException e) {
			System.out.println("No element found ");
			getScreenShot();
			return null;
		} catch (WebDriverException e) {
			System.out.println(" Web driver has found an error");
			getScreenShot();
			return null;
		}

	}

	public String getTextByTagname(String tagname) {

		String text;
		try {
			text = driver.findElementByTagName(tagname).getText();
			return text;
		} catch (NoSuchElementException e) {
			System.out.println("Get Element with given name " + tagname + "is not found");
			e.printStackTrace();
			getScreenShot();
			return null;
		}

	}

	public String getTextByName(String name) {

		try {
			String textName = driver.findElementByName(name).getText();
			System.out.println("Text in the getText is: " + textName);
			return textName;
		} catch (NoSuchElementException e) {
			System.out.println("Get Element with given name " + name + "is not found");
			getScreenShot();
			e.printStackTrace();
			return null;
		}
	}

	public String getTextByXPath(String XPath) {

		String returnText = null;
		try {
			returnText = driver.findElementByXPath(XPath).getText();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not fine the element with xpath: " + XPath);
			getScreenShot();

		}

		return returnText;
	}

	// @author : Karthikeyan
	public String getTextByCSS(String CSS) {
		try {
			getText = driver.findElement(By.cssSelector(CSS)).getText();
			System.out.println("Successfully got the text using CssSelector locator : " + CSS);
			getScreenShot();
		} catch (InvalidSelectorException e) {
			System.out.println(
					"Falied to get text using CssSelector locator : " + CSS + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
		} catch (NoSuchElementException e) {
			System.out.println(
					"Falied to get text using CssSelector locator : " + CSS + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
		} catch (ElementNotVisibleException e) {
			System.out.println(
					"Falied to get text using CssSelector locator : " + CSS + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
		} catch (SessionNotFoundException e) {
			System.out.println(
					"Falied to get text using CssSelector locator : " + CSS + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
		} catch (NullPointerException e) {
			System.out.println("Failed to verify the element using CssSelector locator : " + CSS
					+ ". Looks no value retrieved.Please refer the error description");
			e.printStackTrace();
			getScreenShot();
		}
		return getText;
	}

	public String getTextByLinkText(String linktext) {

		String linkTextValue = null;
		try {
			linkTextValue = driver.findElementByLinkText(linktext).getText();

		} catch (NoSuchElementException e) {
			System.err.println("Element is not found" + e);
			getScreenShot();
		}

		catch (ElementNotVisibleException e) {
			System.err.println("Element is not visisble" + e);
			getScreenShot();
		}
		return linkTextValue;

	}

	public String verifyTextById(String id, String data) {
		// TODO Auto-generated method stub
		return null;
	}

	public String verifyTextByName(String name, String data) {
		String textName = null;
		try {
			textName = driver.findElementByName(name).getText();

			if (textName.equals(data)) {
				System.out.println("Given Name " + name + "equals" + data);
			} else {
				System.out.println("Given Name " + name + "does not equals" + data);

			}
		} catch (NoSuchElementException e) {
			System.out.println("Get Element with given name " + name + "is not found");
			e.printStackTrace();
			getScreenShot();

		}
		return textName;
	}

	public boolean verifyTextByTagname(String tagname, String data) {

		try {
			if (driver.findElementByTagName(tagname).getText().equals(data)) {
				System.out.println("Matched" + data);
				return true;
			}

			else {
				System.out.println("Data mismatch" + data);
				return false;
			}
		} catch (NoSuchElementException e) {
			System.out.println("No Such Element Found");
			e.printStackTrace();
			getScreenShot();
			return false;
		}

	}

	public boolean verifyTextByClassName(String classname, String data)

	{
		try {

			getText = driver.findElement(By.className(classname)).getAttribute("value");
			if (getText.equalsIgnoreCase(data))
				return true;
			else
				return false;

		} catch (ElementNotVisibleException e) {
			System.out.println(" element not visible.please verify");
			getScreenShot();
			return false;

		} catch (NoSuchElementException e) {
			System.out.println("No element found ");
			getScreenShot();
			return false;
		}

		catch (WebDriverException e) {
			System.out.println(" Web driver has found an error");
			getScreenShot();
			return false;
		}

	}

	// @author : Karthikeyan
	public boolean verifyTextByCSS(String CSS, String text) {
		try {
			if (driver.findElement(By.cssSelector(CSS)).getText().equalsIgnoreCase(text)) {
				System.out
						.println("Text :" + text + " is matching with the element using CssSelector locator : " + CSS);
				getScreenShot();
				return true;
			}

			else {
				System.out.println("Text :" + text + " is not matching with the element using CssSelector locator : "
						+ CSS + ". Please refer the error description");
				getScreenShot();
				return false;
			}
		} catch (InvalidSelectorException e) {
			System.out.println("Failed to verify the element using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (NoSuchElementException e) {
			System.out.println("Failed to verify the element using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (ElementNotVisibleException e) {
			System.out.println("Failed to verify the element using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (SessionNotFoundException e) {
			System.out.println("Failed to verify the element using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (NullPointerException e) {
			System.out.println("Failed to verify the element using CssSelector locator : " + CSS
					+ ". Looks no value retrieved.Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		}
	}

	public String verifyTextByXPath(String xPath, String data) {

		String actualText = null, result = null;
		try {
			actualText = driver.findElementByXPath(xPath).getText();
			if (actualText.equalsIgnoreCase(data)) {
				result = "True";

			} else {
				result = "False";
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not find the element with xpath: " + xPath);
			getScreenShot();
			return null;
		}

		return result;
	}

	public boolean verifyTextByLinkText(String linktext) {
		// TODO Auto-generated method stub
		driver.findElementByLinkText(linktext);
		return false;
	}

	public boolean verifyTextContainsByID(String id, String text) {

		return false;
	}

	public boolean verifyTextContainsByName(String name, String text) {
		try {
			String textName = driver.findElementByName(name).getText();

			if (textName.contains(text)) {
				System.out.println("Given Name " + name + "contains" + text);
				return true;
			} else {
				System.out.println("Given Name " + name + " does not contains" + text);
				return false;
			}
		} catch (NoSuchElementException e) {
			System.out.println("Get Element with given name " + name + "is not found");
			e.printStackTrace();
			getScreenShot();
			return false;
		}

	}

	public boolean verifyTextContainsByClassName(String classname, String data)

	{

		try {
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getText = driver.findElement(By.className(classname)).getText();
			if (getText.contains(data))
			{
				System.out.println("Verify Text passed");
				return true;
				
				
			}
			else
			{
				return false;
			}

		} catch (ElementNotVisibleException e) {
			System.out.println(" element not visible.please verify");
			getScreenShot();
			return false;

		} catch (NoSuchElementException e) {
			System.out.println("No element found ");
			getScreenShot();
			return false;
		}

		catch (WebDriverException e) {
			System.out.println(" Web driver has found an error");
			getScreenShot();
			return false;
		}
	}

	public boolean verifyTextContainsByTagname(String tagname, String data) {

		try {
			if (driver.findElementByTagName(tagname).getText().contains(data)) {
				System.out.println("Matched" + data);
				return true;

			} else {
				System.out.println("Data mismatch" + data);
				return false;
			}
		} catch (Exception e) {
			System.out.println("No Such ELement Found" + e);
			getScreenShot();
			e.printStackTrace();
			return false;
		}

	}

	// @author : Karthikeyan
	public boolean verifyTextContainsByCSS(String CSS, String text) {
		try {
			if (driver.findElement(By.cssSelector(CSS)).getText().contains(text)) {
				System.out.println("Element using CssSelector locator : " + CSS + " is contains the text - " + text);
				getScreenShot();
				return true;
			}

			else {
				System.out
						.println("Element using CssSelector locator : " + CSS + " is not contains the text - " + text);
				getScreenShot();
				return false;
			}

		} catch (InvalidSelectorException e) {
			System.out.println("Failed to verify the element using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (NoSuchElementException e) {
			System.out.println("Failed to verify the element using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (ElementNotVisibleException e) {
			System.out.println("Failed to verify the element using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (SessionNotFoundException e) {
			System.out.println("Failed to verify the element using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (NullPointerException e) {
			System.out.println("Failed to verify the element using CssSelector locator : " + CSS
					+ ". Looks no value retrieved.Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		}
	}

	public boolean verifyTextContainsByLinkText(String linktext, String data) {

		String actualtext = driver.findElementByLinkText(linktext).getText();
		if (actualtext.contains(data)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyTextContainsByXPath(String XPath, String text) {
		// TODO Auto-generated method stub

		try {
			String actualText = driver.findElementByXPath(XPath).getText();
			if (actualText.contains(text)) {
				return true;

			} else {
				return false;
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not find the element with xpath: " + XPath);
			getScreenShot();
			return false;
		}

	}

	public boolean selectByIDByValue(String id, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean selectByIDByVisbleText(String id, String VisibleText) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean selectByIDByIndex(String id, int index) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean selectByTagnameByValue(String tagname, String value) {
		try {
			Select selectedvalue = new Select(driver.findElement(By.tagName(tagname)));
			selectedvalue.selectByValue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean selectByTagnameByVisbleText(String tagname, String VisibleText) {
		try {
			Select selectedVisibleText = new Select(driver.findElement(By.tagName(tagname)));
			selectedVisibleText.selectByVisibleText(VisibleText);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean selectByTagnameByIndex(String tagname, int index) {
		try {
			Select selectedIndex = new Select(driver.findElement(By.tagName(tagname)));
			selectedIndex.selectByIndex(index);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public boolean selectByClassNameByValue(String classname, String value) {
		// TODO Auto-generated method stub
		try {

			Select dropdown = new Select(driver.findElement(By.className(classname)));
			dropdown.selectByValue(value);

		} catch (ElementNotVisibleException e) {
			System.out.println(" element not visible.please verify");
			getScreenShot();

		} catch (NoSuchElementException e) {
			System.out.println("No element found ");
			getScreenShot();
		}

		catch (WebDriverException e) {
			System.out.println(" Web driver has found an error" + e);
			getScreenShot();
		}

		finally {
		}

		return false;
	}

	public boolean selectByClassnameByVisbleText(String classname, String VisibleText)

	{
		// TODO Auto-generated method stub
		try {

			Select dropdown = new Select(driver.findElement(By.className(classname)));
			dropdown.selectByVisibleText(VisibleText);

		} catch (ElementNotVisibleException e) {
			System.out.println(" element not visible.please verify");
			getScreenShot();

		} catch (NoSuchElementException e) {
			System.out.println("No element found ");
			getScreenShot();
		}

		catch (WebDriverException e) {
			System.out.println(" Web driver has found an error" + e);
			getScreenShot();
		}

		finally {
		}

		return false;
	}

	public boolean selectByClassNameByIndex(String classname, int index) {
		// TODO Auto-generated method stub
		try {

			Select dropdown = new Select(driver.findElement(By.className(classname)));
			dropdown.selectByIndex(index);

		} catch (ElementNotVisibleException e) {
			System.out.println(" element not visible.please verify");
			getScreenShot();

		} catch (NoSuchElementException e) {
			System.out.println("No element found ");
			getScreenShot();
		}

		catch (WebDriverException e) {
			System.out.println(" Web driver has found an error" + e);
			getScreenShot();
		}

		finally {
		}

		return false;
	}

	// @author : Karthikeyan
	public boolean selectByCSSByValue(String CSS, String value) {
		try {
			dropdown = new Select(driver.findElement(By.cssSelector(CSS)));
			dropdown.selectByValue(value);
			System.out.println("Successfully selected the dropdown with value : " + value
					+ ", using CssSelector locator : " + CSS);
			getScreenShot();
			return true;
		} catch (InvalidSelectorException e) {
			System.out.println("Failed to select the dropdown with value : " + value + ", using CssSelector locator : "
					+ CSS + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (NoSuchElementException e) {
			System.out.println("Failed to select the dropdown with value : " + value + ", using CssSelector locator : "
					+ CSS + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (ElementNotVisibleException e) {
			System.out.println("Failed to select the dropdown with value : " + value + ", using CssSelector locator : "
					+ CSS + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (SessionNotFoundException e) {
			System.out.println("Failed to select the dropdown with value : " + value + ", using CssSelector locator : "
					+ CSS + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		}
	}

	// @author : Karthikeyan
	public boolean selectByCSSByVisbleText(String CSS, String VisibleText) {
		try {
			dropdown = new Select(driver.findElement(By.cssSelector(CSS)));
			dropdown.selectByVisibleText(VisibleText);
			System.out.println("Successfully selected the dropdown with Visible Text : " + VisibleText
					+ ", using CssSelector locator : " + CSS);
			getScreenShot();
			return true;
		} catch (InvalidSelectorException e) {
			System.out.println("Failed to select the dropdown with Visible Text : " + VisibleText
					+ ", using CssSelector locator : " + CSS + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (NoSuchElementException e) {
			System.out.println("Failed to select the dropdown with Visible Text : " + VisibleText
					+ ", using CssSelector locator : " + CSS + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (ElementNotVisibleException e) {
			System.out.println("Failed to select the dropdown with Visible Text : " + VisibleText
					+ ", using CssSelector locator : " + CSS + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (SessionNotFoundException e) {
			System.out.println("Failed to select the dropdown with Visible Text : " + VisibleText
					+ ", using CssSelector locator : " + CSS + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		}
	}

	// @author : Karthikeyan
	public boolean selectByCSSByIndex(String CSS, int index) {
		try {
			dropdown = new Select(driver.findElement(By.cssSelector(CSS)));
			dropdown.selectByIndex(index);
			System.out.println("Successfully selected the dropdown with Index : " + index
					+ ", using CssSelector locator : " + CSS);
			getScreenShot();
			return true;
		} catch (InvalidSelectorException e) {
			System.out.println("Failed to select the dropdown with Index : " + index + ", using CssSelector locator : "
					+ CSS + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (NoSuchElementException e) {
			System.out.println("Failed to select the dropdown with Index : " + index + ", using CssSelector locator : "
					+ CSS + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (ElementNotVisibleException e) {
			System.out.println("Failed to select the dropdown with Index : " + index + ", using CssSelector locator : "
					+ CSS + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (SessionNotFoundException e) {
			System.out.println("Failed to select the dropdown with Index : " + index + ", using CssSelector locator : "
					+ CSS + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		}
	}

	public boolean switchToFrameByID(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean switchToFrameByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean switchToFrameByTagname(String tagname) {
		try {
			driver.switchTo().frame(driver.findElement(By.tagName(tagname)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean switchToFrameByClassName(String classname) {
		try {

			driver.switchTo().frame(driver.findElement(By.className(classname)));

		} catch (ElementNotVisibleException e) {
			System.out.println(" element not visible.please verify");
			getScreenShot();

		} catch (NoSuchElementException e) {
			System.out.println("No element found ");
			getScreenShot();
		}

		catch (NoSuchFrameException e) {
			System.out.println("No frame found ");
		}

		catch (WebDriverException e) {
			System.out.println(" Web driver has found an error" + e);
			getScreenShot();
		}

		finally {
		}

		// TODO Auto-generated method stub
		return false;
	}

	public boolean switchToFrameByXPath(String XPath) {

		// TODO Auto-generated method stub
		try {
			driver.switchTo().frame(driver.findElementByXPath(XPath));
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not find the element by xpath: " + XPath);
			return false;
		}
		return true;
	}

	// @author : Karthikeyan
	public boolean switchToFrameByCSS(String CSS) {
		try {
			driver.switchTo().frame(driver.findElement(By.cssSelector(CSS)));
			System.out.println("Successfully switched to the frame using CssSelector locator : " + CSS);
			getScreenShot();
			return true;
		} catch (InvalidSelectorException e) {
			System.out.println("Failed to switch the frame using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (NoSuchElementException e) {
			System.out.println("Failed to switch the frame using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (ElementNotVisibleException e) {
			System.out.println("Failed to switch the frame using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (SessionNotFoundException e) {
			System.out.println("Failed to switch the frame using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		}
	}

	public List<WebElement> findAllElementsByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<WebElement> findAllElementsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<WebElement> findAllElementsByTagname(String tagname) {
		List<WebElement> collectionList = null;
		try {
			collectionList = driver.findElements(By.tagName(tagname));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return collectionList;
	}

	// @author : Karthikeyan
	public List<WebElement> findAllElementsByCSS(String CSS) {
		try {
			listElements = driver.findElements(By.cssSelector(CSS));
			System.out.println("Successfully got the list of elements using CssSelector locator : " + CSS);
			getScreenShot();
		} catch (InvalidSelectorException e) {
			System.out.println("Falied to get the list of elements using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
		} catch (NoSuchElementException e) {
			System.out.println("Falied to get the list of elements using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
		} catch (ElementNotVisibleException e) {
			System.out.println("Falied to get the list of elements using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
		} catch (SessionNotFoundException e) {
			System.out.println("Falied to get the list of elements using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
		}
		return listElements;
	}

	public List<WebElement> findAllElementsByXPath(String XPath) {
		// TODO Auto-generated method stub
		List<WebElement> webelements = null;
		try {
			webelements = driver.findElementsByXPath(XPath);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not fine the elements with xpath" + XPath);
			return null;
		}

		return webelements;
	}

	public List<WebElement> findAllElementsByClassName(String className) {

		List<WebElement> listofelement = null;
		try {
			listofelement = driver.findElements(By.className(className));

		} catch (ElementNotVisibleException e) {
			System.out.println(" element not visible.please verify");
			getScreenShot();

		} catch (NoSuchElementException e) {
			System.out.println("No element found ");
			getScreenShot();
		}

		catch (WebDriverException e) {
			System.out.println(" Web driver has found an error" + e);
			getScreenShot();
		}

		return listofelement;

	}

	public List<WebElement> findAllElementsByLink(String linktext) {

		List<WebElement> listofelement = null;
		try {
			listofelement = driver.findElements(By.linkText(linktext));

		} catch (ElementNotVisibleException e) {
			System.out.println(" element not visible.please verify");
			getScreenShot();

		} catch (NoSuchElementException e) {
			System.out.println("No element found ");
			getScreenShot();
		}

		catch (WebDriverException e) {
			System.out.println(" Web driver has found an error" + e);
			getScreenShot();
		}

		return listofelement;

	}

	public int countAllElementsByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int countAllElementsByClassName(String classname) {
		// TODO Auto-generated method stub
		try {
			// countAllElement =
			// driver.findElements(By.className(classname)).size();
			countAllElement = findAllElementsByClassName(classname).size();
		} catch (ElementNotVisibleException e) {
			System.out.println(" element not visible.please verify");
			getScreenShot();

		} catch (NoSuchElementException e) {
			System.out.println("No element found ");
			getScreenShot();
		}

		catch (WebDriverException e) {
			System.out.println(" Web driver has found an error" + e);
			getScreenShot();
		}

		finally {
		}
		return countAllElement;

	}

	// @author : Karthikeyan
	public int countAllElementsByCSS(String CSS) {
		try {
			allElementCount = findAllElementsByCSS(CSS).size();
			System.out.println("Successfully got the size of the element using CssSelector locator : " + CSS);
			getScreenShot();
		} catch (InvalidSelectorException e) {
			System.out.println("Falied to get the size of the element CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
		} catch (NoSuchElementException e) {
			System.out.println("Falied to get the size of the element CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
		} catch (ElementNotVisibleException e) {
			System.out.println("Falied to get the size of the element CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
		} catch (SessionNotFoundException e) {
			System.out.println("Falied to get the size of the element CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
		}
		return allElementCount;
	}

	public int countAllElementsByXPath(String XPath) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			List<WebElement> webelements = driver.findElementsByXPath(XPath);
			count = webelements.size();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not find the element with xpath: " + XPath);
			return 0;
		}
		return count;
	}

	public int countAllElementsByTagname(String tagname) {
		int sizeoflist = 0;
		try {
			sizeoflist = driver.findElementsByTagName(tagname).size();
			return sizeoflist;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

	public boolean isEnabledByID(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEnabledByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	// @author : Karthikeyan
	public boolean isEnabledByCSS(String CSS) {
		try {
			if (driver.findElement(By.cssSelector(CSS)).isEnabled()) {
				System.out.println("Element : " + CSS + " is in enabled state");
				getScreenShot();
				return true;
			}

			else {
				System.out.println("Element : " + CSS + " is in disabled state");
				getScreenShot();
				return false;
			}
		} catch (InvalidSelectorException e) {
			System.out.println("Failed to verify the element using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (NoSuchElementException e) {
			System.out.println("Failed to verify the element using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (ElementNotVisibleException e) {
			System.out.println("Failed to verify the element using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (SessionNotFoundException e) {
			System.out.println("Failed to verify the element using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		}
	}

	public boolean isEnabledByXPath(String XPath) {
		// TODO Auto-generated method stub
		boolean enabledFlag;
		try {
			enabledFlag = driver.findElementByXPath(XPath).isEnabled();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not find the element with xpath: " + XPath);
			return false;
		}
		return enabledFlag;
	}

	public boolean isEnabledByClassName(String classname) {
		// TODO Auto-generated method stub
		try {

			driver.findElement(By.className(classname)).isEnabled();
			return true;

		} catch (ElementNotVisibleException e) {
			System.out.println(" element not visible.please verify");
			getScreenShot();

		} catch (NoSuchElementException e) {
			System.out.println("No element found ");
			getScreenShot();
		}

		catch (WebDriverException e) {
			System.out.println(" Web driver has found an error" + e);
			getScreenShot();
		}

		finally {
		}

		// TODO Auto-generated method stub
		return false;

	}

	public boolean isEnabledByTagname(String tagname) {

		try {
			if (driver.findElementByTagName(tagname).isEnabled())
				return true;
			else
				return false;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean isVisibleByID(String id) {

		try {
			driver.findElementById(id).isDisplayed();
			return true;
		} catch (InvalidSelectorException e) {
			System.err.println("CSS Selector used is invalid. Please use correct locator" + e);
			getScreenShot();
			return false;
		} catch (NoSuchElementException e) {
			System.err.println("Element is not found" + e);
			getScreenShot();
			return false;
		}

		catch (ElementNotVisibleException e) {
			System.err.println("Element is not visisble" + e);
			getScreenShot();
			return false;
		}

	}

	public boolean isVisibleByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isVisibleByTagname(String tagname) {
		try {
			driver.findElementByTagName(tagname).isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	// @author : Karthikeyan
	public boolean isVisibleByCSS(String CSS) {
		try {
			if (driver.findElement(By.cssSelector(CSS)).isDisplayed()) {
				System.out.println("Element : " + CSS + " is displayed");
				getScreenShot();
				return true;
			}

			else {
				System.out.println("Element : " + CSS + " is not displayed");
				getScreenShot();
				return false;
			}
		} catch (InvalidSelectorException e) {
			System.out.println("Falied to verify the element using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (NoSuchElementException e) {
			System.out.println("Falied to verify the element using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (ElementNotVisibleException e) {
			System.out.println("Falied to verify the element using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		} catch (SessionNotFoundException e) {
			System.out.println("Falied to verify the element using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		}
	}

	public boolean isVisibleByXPath(String XPath) {
		// TODO Auto-generated method stub
		boolean visibleFlag;
		try {
			visibleFlag = driver.findElementByXPath(XPath).isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return visibleFlag;
	}

	public boolean isVisibleByClassName(String classname) {

		try {

			driver.findElement(By.className(classname)).isDisplayed();
			return true;

		} catch (ElementNotVisibleException e) {
			System.out.println(" element not visible.please verify");
			getScreenShot();

		} catch (NoSuchElementException e) {
			System.out.println("No element found ");
			getScreenShot();
		}

		catch (WebDriverException e) {
			System.out.println(" Web driver has found an error" + e);
			getScreenShot();
		}

		finally {
		}

		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyTitleContains(String title) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No Alert found");
		}
		return false;
	}

	public boolean dismissAlert() { // Hendle alert

		Alert alert;
		try {
			alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (Exception e) {

		}
		return false;
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().accept();
		return null;
	}

	public boolean sendTextToAlert(String data) {
		alert = driver.switchTo().alert();
		alert.sendKeys(data);
		return false;
	}

	public boolean quitBrowser() {

		driver.quit();
		return false;
	}

	@AfterMethod(alwaysRun = true, groups = "Advanced Search")
	public boolean closeCurrentWindow() {
		try {
			driver.close();
			return true;
		} catch (NoSuchSessionException e) {
			System.out.println("No Window Found" + e);
			e.printStackTrace();
			getScreenShot();
			return false;
		}

	}

	public boolean closeAllWindows() {

		try {

			Set<String> handles = driver.getWindowHandles();

			if (handles.size() > 0)

			{
				for (String handle : handles) {

					driver.switchTo().window(handle).close();
				}
			}

			return true;

		} catch (NullPointerException e) {
			System.out.println("No Browser found");

			return false;
		}
	}

	public boolean closeAllButParentWindow() {
		// TODO Auto-generated method stub
		return false;
	}

	public List<String> getAllWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean closeWindowWithTitle(String Title) {
		// TODO Auto-generated method stub
		try {
			if (Title != null) {
				Set<String> allwindowhandles = driver.getWindowHandles();
				for (String titleofthewindow : allwindowhandles) {
					driver.switchTo().window(titleofthewindow);
					if (driver.getTitle().equalsIgnoreCase(Title)) {
						// Thread.sleep(2000);
						driver.switchTo().window(titleofthewindow).close();
						break;
					}
				}
			} else {
				System.out.println("title doesn't contains any value ");
			}

		} catch (NoSuchWindowException e) {
			System.out.println("No Such window exception found");
		} finally {
		}

		return false;
	}

	public boolean switchToWindow(String handle) {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().window(handle);

		} catch (NoSuchWindowException e) {
			System.out.println("No Such window exception found");
		} finally {
		}

		return false;
	}

	public String getCurrentWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean mouseOverByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean mouseOverByLinkText(String linkName) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getScreenShot() {

		try {
			File screenShot = driver.getScreenshotAs(OutputType.FILE);
			// File
			// scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String file = SSFolder + System.currentTimeMillis() + ".JPG";
			FileUtils.copyFile(screenShot, new File(file));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return false;
	}

	public boolean switchToFrameID(String id) {

		try {
			driver.switchTo().frame(driver.findElement(By.id(id)));
		} catch (NoSuchElementException e) {

			e.printStackTrace();
			getScreenShot();
		}

		return false;
	}

	public boolean switchToFrameName(String name) {
		try {
			driver.switchTo().frame(driver.findElement(By.name(name)));
		} catch (NoSuchElementException e) {

			e.printStackTrace();
			getScreenShot();
		}
		return false;
	}

	public boolean switchBackFromFrame() {

		try {
			driver.switchTo().defaultContent();
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
			getScreenShot();
		}
		return false;
	}

	public String getURL() {

		String currentURL = null;
		try {
			currentURL = driver.getCurrentUrl();
		} catch (Exception e) {
			e.printStackTrace();
			getScreenShot();
		}
		return currentURL;

	}

	public String getPageSource() {
		String pageSource = null;
		try {
			pageSource = driver.getPageSource();
		} catch (Exception e) {
			e.printStackTrace();
			getScreenShot();
		}
		return pageSource;
	}

	public List<String> getAllOptionByID(String ID) {

		System.out.println("Not implemented");
		return null;
	}

	public String getAttributeValueByID(String id, String Attribute) {
		String attributeValue = null;
		try {
			attributeValue = driver.findElement(By.id(id)).getAttribute(Attribute);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			getScreenShot();
		}

		return attributeValue;
	}

	public String getAttributeValueByName(String name, String Attribute) {
		String attributeValue = null;
		try {
			attributeValue = driver.findElement(By.name(name)).getAttribute(Attribute);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			getScreenShot();
		}

		return attributeValue;
	}

	public String getAttributeValueByClassName(String className, String Attribute) {
		String attributeValue = null;
		try {
			attributeValue = driver.findElement(By.className(className)).getAttribute(Attribute);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			getScreenShot();
		}

		return attributeValue;
	}

	public String getAttributeValueByXpath(String xpath, String Attribute) {
		String attributeValue = null;
		try {
			attributeValue = driver.findElement(By.xpath(xpath)).getAttribute(Attribute);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			getScreenShot();
		}

		return attributeValue;
	}

	public String getAttributeValueByTagName(String tagName, String Attribute) {
		String attributeValue = null;
		try {
			attributeValue = driver.findElement(By.tagName(tagName)).getAttribute(Attribute);

		} catch (NoSuchElementException e) {
			e.printStackTrace();
			getScreenShot();
		}

		return attributeValue;
	}

	// @author : Karthikeyan
	public String getAttributeValueByCSS(String CSS, String Attribute) {
		String attributeValue = null;
		try {
			attributeValue = driver.findElement(By.cssSelector(CSS)).getAttribute(Attribute);
			System.out.println(
					"Successfully got the Attribute value: " + Attribute + " using CssSelector locator : " + CSS);
			getScreenShot();
		} catch (InvalidSelectorException e) {
			System.out.println("Failed to get the Attribute value: " + Attribute + " using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
		} catch (NoSuchElementException e) {
			System.out.println("Failed to get the Attribute value: " + Attribute + " using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
		} catch (ElementNotVisibleException e) {
			System.out.println("Failed to get the Attribute value: " + Attribute + " using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
		} catch (SessionNotFoundException e) {
			System.out.println("Failed to get the Attribute value: " + Attribute + " using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
		}

		return attributeValue;
	}

	public boolean switchFromFrame() {
		// TODO Auto-generated method stub
		return false;
	}

	public int countAllElementsByID(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getTextByPartialLinkText(String name, String partiallinktext) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean verifyTextByPartialLinkText(String partiallinktext) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyTextContainsByPartialLinkText(String name, String partiallinktext) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean selectByNameByValue(String id, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean selectByNameByVisbleText(String id, String VisibleText) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean selectByNameByIndex(String id, int index) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getCSSvaluebyCSS(String CSS, String Property) throws InterruptedException {
		try {

			getText = driver.findElementByCssSelector(CSS).getCssValue(Property);

			System.out.println("Successfully got the Propert : " + Property + ", using CssSelector locator : " + CSS);
			getScreenShot();
			
			Thread.sleep(5000);

		} catch (InvalidSelectorException e) {
			System.out.println("Failed to get the property : " + CSS + ", using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();

		} catch (NoSuchElementException e) {
			System.out.println("Failed to get the property : " + CSS + ", using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();

		} catch (ElementNotVisibleException e) {
			System.out.println("Failed to get the property : " + CSS + ", using CssSelector locator : " + CSS
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();

		} catch (SessionNotFoundException e) {
			System.out.println("Failed to select the dropdown with Index : " + CSS + ", using CssSelector locator : "
					+ CSS + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();

		}

		return getText;
	}

	// @author = Karthikeyan
	public void sendEndterKeyByID(String id) {
		try {
			driver.findElement(By.id(id)).sendKeys(Keys.ENTER);
			System.out.println("Successfule Enter key pressed using Id: " + id + ".");
		}

		catch (NoSuchElementException e) {
			System.out.println("Unable to Send Keys.Enter using id: " + id + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();

		} catch (ElementNotVisibleException e) {
			System.out.println("Unable to Send Keys.Enter using id: " + id + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();

		} catch (SessionNotFoundException e) {
			System.out.println("Unable to Send Keys.Enter using id: " + id + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
		} catch (WebDriverException e) {
			System.out.println("Unable to Send Keys.Enter using id: " + id + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();

		}

	}

	/*
	 * public void sendEndterKeyByClassname(String classname) {
	 * driver.findElement(By.className(classname)).sendKeys(Keys.ENTER); }
	 */

	// @author = Karthikeyan
	public void sendEndterKeyByName(String name) {
		try {
			driver.findElement(By.name(name)).sendKeys(Keys.ENTER);
			System.out.println("Successfule Enter key pressed using Name: " + name + ".");

		} catch (NoSuchElementException e) {
			System.out
					.println("Unable to Send Keys.Enter using Name: " + name + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();

		} catch (ElementNotVisibleException e) {
			System.out
					.println("Unable to Send Keys.Enter using Name: " + name + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();

		} catch (SessionNotFoundException e) {
			System.out
					.println("Unable to Send Keys.Enter using Name: " + name + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
		} catch (WebDriverException e) {
			System.out
					.println("Unable to Send Keys.Enter using Name: " + name + ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();

		}
	}

	// @@author : Karthikeyan
	public boolean isSelectedByXpath(String xpath) {
		try {
			if (driver.findElement(By.xpath(xpath)).isSelected())
				return true;
			else
				return false;

		} catch (NoSuchElementException e) {
			System.out.println("Failed to get the Element, using Xpath locator : " + xpath
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;

		} catch (ElementNotVisibleException e) {
			System.out.println("Failed to get the Element, using Xpath locator : " + xpath
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;

		} catch (SessionNotFoundException e) {
			System.out.println("Failed to get the Element, using Xpath locator : " + xpath
					+ ". Please refer the error description");
			e.printStackTrace();
			getScreenShot();
			return false;
		}

	}

	public void scroller(String scrollLimit) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(scrollLimit);
	}
	
	public boolean verifyTextContains(String containsText) {
		if (getText.contains(containsText)) {
			System.out.println(" Text contains " + containsText);
			return true;
		} else {
			System.out.println("Text doesn't contains" + containsText);
			return false;
		}

	}
	
	
	public void threadSleep() throws InterruptedException 
	{
		Thread.sleep(5000);	
	}
	

	public void clickViewButton()

	{
		int req = 5;//Integer.parseInt(reqLink);
		
		List<WebElement> links = findAllElementsByLink("View");

		links.get(req - 1).click();

	}
}
