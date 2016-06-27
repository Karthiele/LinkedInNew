package wrapper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public interface GenericWrappers {

	public boolean clickById(String id);

	/*
	 * This method will find the element by id and click
	 * 
	 * @param - id
	 */
	public boolean clickByName(String name);

	/*
	 * This method will find the element by name and clicks on it
	 * 
	 * @param- name as string
	 */
	public boolean clickByClassName(String classname);

	/*
	 * This method will find the element by classname and clicks on submit
	 * 
	 * @param - classname as string
	 */
	public boolean clickByTagName(String tagname);

	public boolean clickByXPath(String xPath);

	/*
	 * This method will find the element by xpath and clicks
	 * 
	 * @param - xpath as string
	 */
	public boolean clickByCSS(String CSS);

	/*
	 * This method will find the element by CSS and clicks on it
	 * 
	 * @param - CSS as string
	 * 
	 */
	public boolean clickByLinkText(String linktext);
	/*
	 * This method will find the element by ink text and clicks
	 * 
	 * @param - linktext as string
	 */

	public boolean clickByPartialLinkText(String partiallinktext);

	public boolean enterById(String id, String data);

	/*
	 * This method will enter the string by finding element by Id and passing
	 * the data to the text field
	 * 
	 * @param - id as string
	 * 
	 * @param - data as string
	 */
	public boolean enterByName(String name, String data);

	public boolean enterByCSS(String CSS, String data);

	public boolean enterByXPath(String xPath, String data);

	public String getTextById(String id);

	/*
	 * This method will get the values by using element id
	 * 
	 * @param- id as string
	 * 
	 */
	public String getTextByName(String name);

	public String getTextByCSS(String CSS);

	public String getTextByClassName(String classname);

	public String getTextByLinkText(String linktext);

	/*
	 * This method will getting text by linkText and returning the linktext
	 * 
	 * @param - linktext as string
	 */
	public String getTextByPartialLinkText(String name, String partiallinktext);

	public String getTextByXPath(String xPath);

	public boolean verifyTextByClassName(String classname, String data);

	public boolean verifyTextByLinkText(String linktext);

	public boolean verifyTextByPartialLinkText(String partiallinktext);

	public boolean verifyTextContainsByLinkText(String name, String linktext);

	public boolean verifyTextContainsByPartialLinkText(String name, String partiallinktext);

	public String verifyTextByXPath(String xPath, String data);
	/*
	 * this method will find the text by xpath and verifies the data
	 * 
	 * @param - xPath as string
	 * 
	 * @param - data as string
	 */

	public boolean verifyTextContainsByClassName(String classname, String data);

	public boolean verifyTextContainsByXPath(String XPath, String text);

	public String verifyTextById(String id, String data);

	public String verifyTextByName(String name, String data);

	public boolean verifyTextByCSS(String CSS, String text);

	public boolean verifyTextContainsByID(String id, String text);

	public boolean verifyTextContainsByName(String name, String text);

	public boolean verifyTextContainsByCSS(String CSS, String text);

	public boolean selectByClassNameByValue(String classname, String value);

	public boolean selectByClassnameByVisbleText(String classname, String VisibleText);

	public boolean selectByClassNameByIndex(String classname, int index);

	public boolean selectByNameByValue(String id, String value);

	public boolean selectByNameByVisbleText(String id, String VisibleText);

	public boolean selectByNameByIndex(String id, int index);

	public boolean selectByIDByValue(String id, String value);

	public boolean selectByIDByVisbleText(String id, String VisibleText);

	public boolean selectByIDByIndex(String id, int index);

	public boolean selectByCSSByValue(String CSS, String value);

	public boolean selectByCSSByVisbleText(String CSS, String VisibleText);

	public boolean selectByCSSByIndex(String CSS, int index);

	public Select getDropDownByXPath(String xPath);

	public boolean selectByTagnameByValue(String tagname, String value);

	public boolean selectByTagnameByVisbleText(String tagname, String VisibleText);

	public boolean selectByTagnameByIndex(String tagname, int index);

	public boolean switchToFrameByID(String id);

	public boolean switchToFrameByName(String name);

	public boolean switchToFrameByClassName(String className);

	public boolean switchToFrameByTagname(String tagname);

	public boolean switchToFrameByCSS(String CSS);

	public boolean switchToFrameByXPath(String xPath);

	public List<WebElement> findAllElementsByID(String id);

	public List<WebElement> findAllElementsByName(String name);

	public List<WebElement> findAllElementsByTagname(String tagname);

	public List<WebElement> findAllElementsByCSS(String CSS);

	public List<WebElement> findAllElementsByXPath(String xPath);

	public List<WebElement> findAllElementsByClassName(String className);
	/*
	 * This method will find all the elements by classname and stores as
	 * collections
	 * 
	 * @param - classname as string
	 */

	public int countAllElementsByID(String id);

	public int countAllElementsByName(String name);

	public int countAllElementsByTagname(String tagname);

	public int countAllElementsByCSS(String CSS);

	public int countAllElementsByXPath(String xPath);

	public int countAllElementsByClassName(String classname);

	public boolean isEnabledByID(String id);

	public boolean isEnabledByName(String name);

	public boolean isEnabledByTagname(String tagname);

	public boolean isEnabledByCSS(String CSS);

	public boolean isEnabledByXPath(String xPath);

	public boolean isEnabledByClassName(String name);

	public boolean isVisibleByID(String id);

	public boolean isVisibleByName(String name);

	public boolean isVisibleByTagname(String tagname);

	public boolean isVisibleByCSS(String CSS);

	public boolean isVisibleByXPath(String xPath);

	public boolean isVisibleByClassName(String name);

	public boolean invokeApp(String browser, String url);

	/*
	 * This method will launch chrome or firefox and maximise the browser and
	 * set the wait for 30 seconds and load the url
	 * 
	 * @param url - The url with http or https
	 */
	public boolean verifyTitle(String title);

	public boolean verifyTitleContains(String title);

	public boolean acceptAlert();

	public boolean dismissAlert();

	public String getAlertText();

	public boolean sendTextToAlert(String data);

	public boolean quitBrowser();

	public boolean closeCurrentWindow();

	/*
	 * closes the current window
	 * 
	 */
	public boolean closeAllWindows();

	public boolean closeAllButParentWindow();

	public List<String> getAllWindowHandles();

	public boolean closeWindowWithTitle(String Title);

	public boolean switchToWindow(String handle);

	public String getCurrentWindowHandle();

	public boolean mouseOverByXpath(String xpathVal); // To be implemented in
	// future

	public boolean mouseOverByLinkText(String linkName); // To be implemented in
	// future

	public boolean getScreenShot();

	public boolean switchToFrameID(String id);

	public boolean switchToFrameName(String name);

	public boolean switchBackFromFrame();

	public String getURL();

	public String getPageSource();

	public List<String> getAllOptionByID(String ID); // do it for all other
	// applicable locators
	// Sarathi

	public String getAttributeValueByID(String id, String Attribute); // do it
	// for
	// all
	// other
	// applicable
	// locators
	// Sarathi

	public String getAttributeValueByName(String name, String Attribute);

	public String getAttributeValueByClassName(String className, String Attribute);

	public String getAttributeValueByXpath(String xpath, String Attribute);

	public String getAttributeValueByTagName(String tagName, String Attribute);

	public String getAttributeValueByCSS(String CSS, String Attribute);

	public boolean isSelectedByXpath(String xpath);

	public void sendEndterKeyByName(String name);

	public void sendEndterKeyByID(String id);

}
