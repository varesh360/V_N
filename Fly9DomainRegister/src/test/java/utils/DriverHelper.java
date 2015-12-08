package utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public abstract class DriverHelper 
{
	//Define objects
	private WebDriver driver;

	//Declare objects
	public DriverHelper(WebDriver webdriver) 
	{
		driver = webdriver;
	}

	//Return web driver object
	public WebDriver getWebDriver() 
	{
		return driver;
	}

	//Handle locator type
	public By ByLocator(String locator) 
	{
		By result = null;

		if (locator.startsWith("//")) 
		{ result = By.xpath(locator); }
		else if (locator.startsWith("css=")) 
		{ result = By.cssSelector(locator.replace("css=", "")); } 
		else if (locator.startsWith("name=")) 
		{ result = By.name(locator.replace("name=", ""));
		} else if (locator.startsWith("link=")) 
		{ result = By.linkText(locator.replace("link=", "")); } 
		else 
		{ result = By.id(locator); }
		return result;
	}

	//Assert element present
	public Boolean isElementPresent(String locator) 
	{
		Boolean result = false;
		try 
		{
			getWebDriver().findElement(ByLocator(locator));
			result = true;
		} 
		catch (Exception ex) { }
		return result;
	}

	public Boolean isElementEnable(String locator) 
	{
		Boolean result = false;
		try 
		{
			getWebDriver().findElement(ByLocator(locator)).isEnabled();
			result = true;
		} 
		catch (Exception ex) { }
		return result;
	}
	//Wait for element present
	public void WaitForElementPresent(String locator, int timeout) 
	{
		int i = 0;
		for (; i < timeout; i++) 
		{ 
			if (isElementPresent(locator)) break;
			try 
			{ Thread.sleep(1000); } 
			catch (InterruptedException e) 
			{ e.printStackTrace(); }
		}
		if (i == timeout) Assert.fail(locator + " is not present in given wait time.");
	}

	//Wait for element not present
	public void WaitForElementNotPresent(String locator, int timeout) 
	{
		int i = 0;
		for (; i < timeout; i++) 
		{ 
			if (!isElementPresent(locator)) break; 
			try 
			{ Thread.sleep(1000); } 
			catch (InterruptedException e) 
			{ e.printStackTrace(); }
		}
		if (i == timeout) Assert.fail(locator + " is still present after given wait time.");
	}

	//Wait for element enabled
	public void WaitForElementEnabled(String locator, int timeout) 
	{
		int i = 0;
		for (; i < timeout; i++) 
		{
			if (isElementPresent(locator)) 
			{ if (getWebDriver().findElement(ByLocator(locator)).isEnabled()) break; }
			try 
			{ Thread.sleep(1000); } 
			catch (InterruptedException e) 
			{ e.printStackTrace(); }
		}
		if (i == timeout) Assert.fail(locator + " is not enabled in given wait time.");
	}

	//Wait for element not enabled
	public void WaitForElementNotEnabled(String locator, int timeout) 
	{
		int i = 0;
		for (; i < timeout; i++) 
		{
			if (isElementPresent(locator)) 
			{ if (!getWebDriver().findElement(ByLocator(locator)).isEnabled()) break; }
			try 
			{ Thread.sleep(1000); } 
			catch (InterruptedException e) 
			{ e.printStackTrace(); }
		}
		if (i == timeout) Assert.fail(locator + " is still enabled after given wait time.");
	}

	//Wait for element visible
	public void WaitForElementVisible(String locator, int timeout) 
	{
		int i = 0;
		for (; i < timeout; i++) 
		{
			if (isElementPresent(locator)) 
			{ if (getWebDriver().findElement(ByLocator(locator)).isDisplayed()) break; }
			try 
			{ Thread.sleep(1000); } 
			catch (InterruptedException e) 
			{ e.printStackTrace(); }
		}
		if (i == timeout) Assert.fail(locator + " is not visible in given wait time.");		
	}

	//Wait for element not visible
	public void WaitForElementNotVisible(String locator, int timeout) 
	{
		int i = 0;
		for (; i < timeout; i++) 
		{
			if (isElementPresent(locator)) 
			{ if (!getWebDriver().findElement(ByLocator(locator)).isDisplayed()) break; }
			try 
			{ Thread.sleep(1000); } 
			catch (InterruptedException e) 
			{ e.printStackTrace(); }
		}
		if (i == timeout) Assert.fail(locator + " is still visible after given wait time.");
	}

	//Wait for text present
	public void WaitForTextPresent(String locator, String text, int timeout) 
	{
		WaitForElementPresent(locator, timeout);
		for (int i = 0; i < timeout; i++) 
		{ 
			if (isTextPresent(locator, text)) break;
			try 
			{ Thread.sleep(1000); } 
			catch (InterruptedException e) 
			{ e.printStackTrace(); }
		}
	}

	//Handle mouse over action
	public void mouseOver(String locator) {
		this.WaitForElementPresent(locator, 10);
		WebElement el = getWebDriver().findElement(ByLocator(locator));

		// build and perform the mouseOver with Advanced User Interactions API
		Actions builder = new Actions(getWebDriver());
		builder.moveToElement(el).build().perform();
	}

	//Handle mouse double click action
	public void mouseDoubleClick(String locator) {
		this.WaitForElementPresent(locator, 10);
		WebElement el = getWebDriver().findElement(ByLocator(locator));

		// build and perform the mouse click with Advanced User Interactions API
		Actions builder = new Actions(getWebDriver());
		builder.doubleClick(el).perform();
	}

	// Handle drag and drop action
	public void dragAndDrop(String draggable, String to) {
		this.WaitForElementPresent(draggable, 50);
		this.WaitForElementPresent(to, 50);
		WebElement elDraggable = getWebDriver().findElement(
				ByLocator(draggable));
		WebElement todrag = getWebDriver().findElement(ByLocator(to));

		// build and perform drag and drop with Advanced User Interactions API
		Actions builder = new Actions(getWebDriver());
		builder.dragAndDrop(elDraggable, todrag).perform();
	}

	//Handle click action
	public void clickOn(String locator) 
	{
		WaitForElementPresent(locator, 10);
		WebElement el = getWebDriver().findElement(ByLocator(locator));
		el.click();
	}

	//Handle send keys action
	public void sendKeys(String locator, String text) 
	{
		try{
		WaitForElementPresent(locator, 10);
		WebElement el = getWebDriver().findElement(ByLocator(locator));
		el.clear();
		Thread.sleep(1000);
		el.sendKeys(text);
		} catch(Exception e) {e.printStackTrace();}
	}
	
	public void type(String locator, String text) 
	{
		try{
		WaitForElementPresent(locator, 10);
		WebElement el = getWebDriver().findElement(ByLocator(locator));
		el.sendKeys(text);
		} catch(Exception e) {e.printStackTrace();}
	}

	// Select value from drop down
	public void selectDropDown(String locator, String targetValue) {
		this.WaitForElementPresent(locator, 10);
		new Select(getWebDriver().findElement(ByLocator(locator)))
				.selectByVisibleText(targetValue);
	}

	//Assert text present
	public boolean isTextPresent(String locator, String str) 
	{
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"+ locator + " Not found");
		String message = getWebDriver().findElement(ByLocator(locator)).getText();
		if (message.contains(str)) 
		{ return true; } 
		else 
		{ return false; }
	}

	// Store text from a locator
	public String getText(String locator) {
		WaitForElementPresent(locator, 10);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		String text = getWebDriver().findElement(ByLocator(locator)).getText();
		return text;
	}

	// Assert check box selected
	public boolean isChecked(String locator) {
		boolean checkStatus = false;
		WaitForElementPresent(locator, 10);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		WebElement el = getWebDriver().findElement(ByLocator(locator));
		checkStatus = el.isSelected();
		return checkStatus;
	}

	// Get attribute value
	public String getAttribute(String locator, String attribute) {
		WaitForElementPresent(locator, 10);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		String text = getWebDriver().findElement(ByLocator(locator))
				.getAttribute(attribute);
		return text;
	}
	
	// wait For Load
		public void waitForLoad(int time)
		{
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	// Get integer value
	public Integer getInt(String strString) {
		Pattern intsOnly = Pattern.compile("\\d+");
		String input = strString;
		Matcher makeMatch = intsOnly.matcher(input);
		makeMatch.find();
		String digitStr = makeMatch.group();
		Integer digit = Integer.parseInt(digitStr);
		return digit;
	}

	// Execute java script
	public void javaScriptExecute(String javascrpt) {
		JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
		js.executeScript(javascrpt);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	}
	
	 private boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
	 }
		  

	public void acceptAlert(int sec) throws Exception {
		for (int i = 0; i < sec; i++)
		{
			if(isAlertPresent())
			{
				Alert alert = getWebDriver().switchTo().alert();
				alert.accept();
				break;
			}	
			Thread.sleep(1000);
		}		
	}
	
	public int getTotalRow(String locator){
		WaitForElementVisible(locator, 10);
		Assert.assertTrue(isElementPresent(locator));
		int number = getWebDriver().findElements(ByLocator(locator)).size();
		return number;
	}
	
	//Check if frames are present
	public boolean isFramePresent()
	{
		boolean result = false;
		try
		{
			driver.findElement(By.tagName("iframe"));
			result = true;
		}
		catch (Exception e)
		{}		
		return result;
	}
	
	//Wait for frame to appear
	public void waitForFramePresent(int timeout)
	{
		int i = 0;
		for (; i < timeout; i++)
		{ 
			if (isFramePresent()) break; 
			try 
			{ Thread.sleep(1000); } 
			catch (InterruptedException e) 
			{ e.printStackTrace(); }
		}
		if (i == timeout) Assert.fail("No frame is present");
	}
	
	//Wait for frame to appear
	public void waitForFrameNotPresent(int timeout)
	{
		int i = 0;
		for (; i < timeout; i++)
		{ 
			if (!isFramePresent()) break; 
			try 
			{ Thread.sleep(1000); } 
			catch (InterruptedException e) 
			{ e.printStackTrace(); }
		}
		if (i == timeout) Assert.fail("Frame is present");
	}
	
	//Get frames
	public String[] getFrames()
	{
		String[] frames = (String[]) driver.getWindowHandles().toArray();
		return frames;
	}
	
	//Switch frame
	public void switchFrame(String frameId)
	{ getWebDriver().switchTo().frame(frameId); }
	
	// Select value from drop down
	public void selectDropDownByIndex(String locator, int index) {
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);		
		new Select(getWebDriver().findElement(ByLocator(locator))).selectByIndex(index);

	}
	
	//Check if text is present
    public Boolean TextPresent(String text)
    {
        Boolean result = false;
        String message = driver.findElement(By.cssSelector("BODY")).getText();

        if (message.contains(text))
        { result = true; }

        return result;
    }
    
    // Generate a random number
    public int randomNumber(int number)
    {
     Random ran = new Random();
     int i = ran.nextInt(number);
     return i;
    }
    
}
