package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
import utils.PropertyReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class DriverTestCase 
{
	
	enum DriverType 
	{ Firefox, IE, Chrome }

	//Define objects
	private WebDriver driver;
		
	//Initialize objects
	protected static PropertyReader propertyReader = new PropertyReader();
	
	//Define variables
	protected String URL = propertyReader.readApplicationFile("application.xml", "SetUp.URL");
	protected String Password = propertyReader.readApplicationFile("application.xml", "SetUp.Password");
	public static String Timeout = propertyReader.readApplicationFile("application.xml", "SetUp.Timeout");
	public static int timeout = Integer.parseInt(Timeout); 
	protected static String Email = propertyReader.readApplicationFile("application.xml", "SetUp.Email");
	protected static String AdminUser = propertyReader.readApplicationFile("application.xml", "SetUp.AdminUsername");
	protected static String AdminPass = propertyReader.readApplicationFile("application.xml", "SetUp.AdminPassword");
	protected static String AccountName = propertyReader.readApplicationFile("application.xml", "SetUp.AccountName");
	protected static String Name = propertyReader.readApplicationFile("application.xml", "SetUp.Name");
	protected static String CustEmail = propertyReader.readApplicationFile("application.xml", "SetUp.CustEmail");
	protected static String CustPhone = propertyReader.readApplicationFile("application.xml", "SetUp.CustPhone");
	protected static String UserName = propertyReader.readApplicationFile("application.xml", "SetUp.Username");
	protected static String UserEmail = propertyReader.readApplicationFile("application.xml", "SetUp.UserEmail");
	protected static String UserPassword = propertyReader.readApplicationFile("application.xml", "SetUp.UserPassword");
	protected static String EditUserEmail = propertyReader.readApplicationFile("application.xml", "SetUp.EditUserEmail");
	protected static String EditScreenName = propertyReader.readApplicationFile("application.xml", "SetUp.EditUserScreenName");
	protected static String ChangePassword = propertyReader.readApplicationFile("application.xml", "SetUp.ChangePassword");
	
	@BeforeMethod
	public void setUp() 
	{		
		String driverType = propertyReader.readApplicationFile("application.xml", "SetUp.Browser");	
							
		//Check if desired browser is Firefox
		if (DriverType.Firefox.toString().equals(driverType)) 
		{ 
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			driver = new FirefoxDriver(firefoxProfile); 
		} 		
		
		//Check if desired browser is Internet Explorer
		else if (DriverType.IE.toString().equals(driverType)) 
		{ 
			//Set property for IEDriverServer
			String path = getPath();
			File file = new File(path+"//IEWebdriver//IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			
			//Accept all SSL Certificates
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			//Create driver object
			driver = new InternetExplorerDriver(); 
		}
		
		//Check if desired browser is Chrome
		else if (DriverType.Chrome.toString().equals(driverType)) 
		{ driver = new ChromeDriver(); } 
		
		//If browser type is not matched, consider it as Firefox
		else 
		{ driver = new FirefoxDriver(); }
		
				
		//Maximize window
		driver.manage().window().maximize();
		
		//Delete cookies
		driver.manage().deleteAllCookies();		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}	
	
	@AfterMethod
	public void afterMainMethod() throws ParserConfigurationException, SAXException, org.xml.sax.SAXException, IOException
	{	
		//new ExcelReportGenerator().generateExcelReport("TestResults.xlsx");
		driver.quit();
		
	}
	
	//Return webdriver object
	public WebDriver getWebDriver()
	{
		return driver;
	}
	
	
	//Handle child windows
	public String switchPreviewWindow()
	{
		Set<String> windows = getWebDriver().getWindowHandles();
		Iterator<String> iter = windows.iterator();		
		String parent = iter.next();
		getWebDriver().switchTo().window(iter.next());
		return parent;
	}
	
	//Get random integer
	public int getRandomInteger(int aStart, int aEnd){
		 Random aRandom = new  Random();
	    if ( aStart > aEnd ) {
	      throw new IllegalArgumentException("Start cannot exceed End.");
	    }
	    //get the range, casting to long to avoid overflow problems
	    long range = (long)aEnd - (long)aStart + 1;
	    // compute a fraction of the range, 0 <= frac < range
	    long fraction = (long)(range * aRandom.nextDouble());
	    int randomNumber =  (int)(fraction + aStart);    
	    return randomNumber;
	}
	
	//Get random string
	public String randomString( int len ) 
	{
		String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder( len );
		for( int i = 0; i < len; i++ ) 
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
	}

	//Get absolute path
	public String getPath()
	{
		String path ="";		
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");		
		return path;
	}
	
	//Get absolute path for a file
	public String getPathUpload()
	{
		String path ="";		
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("/", "//");		
		return path;
	}
	 
	//Capturing screenshot on failure 
	public void captureScreenshot(String fileName) 
	{
		try 
		{
			String screenshotName = this.getFileName(fileName);
	        FileOutputStream out = new FileOutputStream("screenshots//" + screenshotName + ".jpg");
	        out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
	        out.close();
	        String path = getPath();
	        String  screen = "file://"+path+"/screenshots/"+screenshotName + ".jpg";
	        Reporter.log("<a href= '"+screen+  "'target='_blank' >" + screenshotName + "</a>");
	     }
		 catch (Exception e) 
		 { }
	 }
	 
	//Creating file name
	public  String getFileName(String file)
	{
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 Calendar cal = Calendar.getInstance();		 
		 String fileName = file+dateFormat.format(cal.getTime());
		 return fileName;
	 }
	
	//Switch frame
	public void switchFrame(String[] arr) 
	{
		for (int i = 0; i < arr.length; i++) 
		{ getWebDriver().switchTo().frame(arr[i]); }
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
			this.WaitForElementPresent(locator, 10);
			WebElement el = getWebDriver().findElement(ByLocator(locator));
			el.click();
		}

		//Handle send keys action
		public void sendKeys(String locator, String text) 
		{
			this.WaitForElementPresent(locator, 10);
			WebElement el = getWebDriver().findElement(ByLocator(locator));
			el.clear();
			el.sendKeys(text);
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
			WaitForElementPresent(locator, 20);
			Assert.assertTrue(isElementPresent(locator), "Element Locator :"
					+ locator + " Not found");
			String text = getWebDriver().findElement(ByLocator(locator)).getText();
			return text;
		}

		// Assert check box selected
		public boolean isChecked(String locator) {
			boolean checkStatus = false;
			WaitForElementPresent(locator, 20);
			Assert.assertTrue(isElementPresent(locator), "Element Locator :"
					+ locator + " Not found");
			WebElement el = getWebDriver().findElement(ByLocator(locator));
			checkStatus = el.isSelected();
			return checkStatus;
		}

		// Get attribute value
		public String getAttribute(String locator, String attribute) {
			WaitForElementPresent(locator, 20);
			Assert.assertTrue(isElementPresent(locator), "Element Locator :"
					+ locator + " Not found");
			String text = getWebDriver().findElement(ByLocator(locator))
					.getAttribute(attribute);
			return text;
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
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
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
			WaitForElementVisible(locator, 30);
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
}
